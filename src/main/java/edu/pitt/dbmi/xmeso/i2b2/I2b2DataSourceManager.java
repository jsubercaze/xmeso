/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.dbmi.xmeso.i2b2;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public abstract class I2b2DataSourceManager {

	private static final Logger logger = LoggerFactory.getLogger(I2b2DataSourceManager.class);

	protected Configuration configuration;

	protected SessionFactory sessionFactory;

	protected Session session;
	
	protected URL dbPropertiesUrl;

	public I2b2DataSourceManager() {
	}

	protected void buildConfiguration() {

		try {
			Properties dbProperties = new Properties();
			FileReader reader = new FileReader(dbPropertiesUrl.getPath());
			dbProperties.load(reader);

			/* Sample i2b2 connection settings
			 *  
			 *  hibernate.driver = oracle.jdbc.OracleDriver
				hibernate.dialect = org.hibernate.dialect.Oracle10gDialect
				hibernate.url = jdbc:oracle:thin:@dbmi-i2b2-dev05.dbmi.pitt.edu:1521:XE
				hibernate.user = 
				hibernate.password = 
			 */
			configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class", dbProperties.getProperty("hibernate.driver"));
			configuration.setProperty("hibernate.dialect", dbProperties.getProperty("hibernate.dialect"));
			configuration.setProperty("hibernate.connection.url", dbProperties.getProperty("hibernate.url"));
			configuration.setProperty("hibernate.connection.username", dbProperties.getProperty("hibernate.user"));
			configuration.setProperty("hibernate.connection.password", dbProperties.getProperty("hibernate.password"));
			configuration.setProperty("hibernate.default_schema", dbProperties.getProperty("hibernate.default_schema"));

			addAnnotatedClasses();

		} catch (IOException x) {
			System.err.println("Error connecting to I2B2 database.");
		}

	}

	/**
	 * get or create configuration object to further customize it before calling
	 * getSession()
	 *
	 * @return
	 */
	public Configuration getConfiguration() {
		if (configuration == null) {
			buildConfiguration();
		}
		return configuration;
	}

	protected abstract void addAnnotatedClasses(); 

	public void addAnnotatedClsesForPackage() {
		logger.debug("Entered addAnnotatedClsesForPackage for " + getClass().getName());
		
		try {
			String pkgName = getClass().getPackage().getName();
			ClassPath classPath = ClassPath.from(getClass().getClassLoader());
			final ArrayList<Class<?>> clses = new ArrayList<Class<?>>();
			Set<ClassInfo> clsInfos = classPath.getTopLevelClassesRecursive(pkgName);
			for (ClassInfo clsInfo : clsInfos) {
				if (!clsInfo.getName().equals(getClass().getName())) {
					clses.add(clsInfo.load());
				}
			}
			if (clses.isEmpty()) {
				logger.error("Failed to load hibernate classes");
			} else {
				for (Class<?> cls : clses) {
//					System.err.println("Configuring " + cls.getName()
//							+ " into Hibernate");
//					logger.info("Configuring " + cls.getName()
//							+ " into Hibernate");
					configuration.addAnnotatedClass(cls);
				}
			}
		} catch (IOException e) {
		}
		logger.debug("Exited addAnnotatedClsesForPackage for " + getClass().getName());
	}

	/*
	 * SessionFactory
	 */
	protected boolean buildSessionFactory(Configuration configuration) {
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(ssrb.build());
		return !sessionFactory.isClosed();
	}

	/*
	 * Session
	 */
	public Session getSession() {
		try {
			if (session == null) {
				if (configuration == null) {
					buildConfiguration();
				}
				if (sessionFactory == null) {
					buildSessionFactory(configuration);
				}

				session = sessionFactory.openSession();
			}
		} catch (Exception x) {
			System.err.println("Failed to get database session.");
			session = null;
		}
		return session;
	}

	/*
	 * Clean up
	 */
	protected void closeSession() throws HibernateException {
		if (session != null && session.isOpen()) {
			session.close();
			session = null;
		}
	}

	protected void closeSessionFactory() throws HibernateException {
		if (sessionFactory != null && !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
		sessionFactory = null;
	}

	public void destroy() {
		closeSession();
		closeSessionFactory();
		logger.debug("destroyed " + getClass().getName() + " : session and sessionFactory removed.");
	}

	@Override
	protected void finalize() throws Throwable {
		destroy();
		super.finalize();
	}

}
