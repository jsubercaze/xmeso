
/* First created by JCasGen Fri Jul 29 16:10:25 EDT 2016 */
package edu.pitt.dbmi.xmeso.model.Model;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** Type defined in edu.pitt.dbmi.xmeso.model.Model
 * Updated by JCasGen Mon Aug 01 09:56:26 EDT 2016
 * @generated */
public class XmesoBooleanDataElement_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (XmesoBooleanDataElement_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = XmesoBooleanDataElement_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new XmesoBooleanDataElement(addr, XmesoBooleanDataElement_Type.this);
  			   XmesoBooleanDataElement_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new XmesoBooleanDataElement(addr, XmesoBooleanDataElement_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = XmesoBooleanDataElement.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.pitt.dbmi.xmeso.model.Model.XmesoBooleanDataElement");
 
  /** @generated */
  final Feature casFeat_attribute;
  /** @generated */
  final int     casFeatCode_attribute;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getAttribute(int addr) {
        if (featOkTst && casFeat_attribute == null)
      jcas.throwFeatMissing("attribute", "edu.pitt.dbmi.xmeso.model.Model.XmesoBooleanDataElement");
    return ll_cas.ll_getStringValue(addr, casFeatCode_attribute);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAttribute(int addr, String v) {
        if (featOkTst && casFeat_attribute == null)
      jcas.throwFeatMissing("attribute", "edu.pitt.dbmi.xmeso.model.Model.XmesoBooleanDataElement");
    ll_cas.ll_setStringValue(addr, casFeatCode_attribute, v);}
    
  
 
  /** @generated */
  final Feature casFeat_value;
  /** @generated */
  final int     casFeatCode_value;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public boolean getValue(int addr) {
        if (featOkTst && casFeat_value == null)
      jcas.throwFeatMissing("value", "edu.pitt.dbmi.xmeso.model.Model.XmesoBooleanDataElement");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_value);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setValue(int addr, boolean v) {
        if (featOkTst && casFeat_value == null)
      jcas.throwFeatMissing("value", "edu.pitt.dbmi.xmeso.model.Model.XmesoBooleanDataElement");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_value, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public XmesoBooleanDataElement_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_attribute = jcas.getRequiredFeatureDE(casType, "attribute", "uima.cas.String", featOkTst);
    casFeatCode_attribute  = (null == casFeat_attribute) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_attribute).getCode();

 
    casFeat_value = jcas.getRequiredFeatureDE(casType, "value", "uima.cas.Boolean", featOkTst);
    casFeatCode_value  = (null == casFeat_value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_value).getCode();

  }
}



    