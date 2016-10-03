/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.dbmi.xmeso.qa;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.pitt.dbmi.xmeso.qa.orm.ReportInfo;

public class QaDataSourceManager {

	private static final Logger logger = LoggerFactory.getLogger(QaDataSourceManager.class);

	protected Configuration configuration;

	protected SessionFactory sessionFactory;

	protected Session session;

	protected Properties xmesoProperties;
	
	public QaDataSourceManager(Properties xmesoProperties) {
		this.xmesoProperties = xmesoProperties;
	}

	protected void buildConfiguration() {
		configuration = new Configuration();
		// No need to allow users to specify the JDBC driver class
		configuration.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
		// We assume all sites use Oracle 10g and later
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		// Key-value pairs specified in xmeso.properties
		configuration.setProperty("hibernate.connection.url", xmesoProperties.getProperty("i2b2.url"));
		configuration.setProperty("hibernate.connection.username", xmesoProperties.getProperty("i2b2.user"));
		configuration.setProperty("hibernate.connection.password", xmesoProperties.getProperty("i2b2.password"));
		configuration.setProperty("hibernate.default_schema", xmesoProperties.getProperty("i2b2.schema"));

		// Add entity beans
		configuration.addAnnotatedClass(ReportInfo.class);
	}

	/**
	 * Get or create configuration object to further customize it before calling getSession()
	 *
	 * @return
	 */
	public Configuration getConfiguration() {
		if (configuration == null) {
			buildConfiguration();
		}
		return configuration;
	}

	protected boolean buildSessionFactory(Configuration configuration) {
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(ssrb.build());
		return !sessionFactory.isClosed();
	}

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
		logger.debug("Destroyed " + getClass().getName() + " : session and sessionFactory removed.");
	}

	@Override
	protected void finalize() throws Throwable {
		destroy();
		super.finalize();
	}

}
