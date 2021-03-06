

/* First created by JCasGen Wed Sep 07 16:18:03 EDT 2016 */
package edu.pitt.dbmi.xmeso.model.Model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Type defined in edu.pitt.dbmi.xmeso.model.Model
 * Updated by JCasGen Wed Sep 07 16:18:03 EDT 2016
 * XML source: C:/Users/zhy19/workspace/xmeso/descriptor/edu/pitt/dbmi/xmeso/XmesoEngine.xml
 * @generated */
public class XmesoNumberDataElement extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(XmesoNumberDataElement.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected XmesoNumberDataElement() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public XmesoNumberDataElement(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public XmesoNumberDataElement(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public XmesoNumberDataElement(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: attribute

  /** getter for attribute - gets attribute
   * @generated
   * @return value of the feature 
   */
  public String getAttribute() {
    if (XmesoNumberDataElement_Type.featOkTst && ((XmesoNumberDataElement_Type)jcasType).casFeat_attribute == null)
      jcasType.jcas.throwFeatMissing("attribute", "edu.pitt.dbmi.xmeso.model.Model.XmesoNumberDataElement");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoNumberDataElement_Type)jcasType).casFeatCode_attribute);}
    
  /** setter for attribute - sets attribute 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAttribute(String v) {
    if (XmesoNumberDataElement_Type.featOkTst && ((XmesoNumberDataElement_Type)jcasType).casFeat_attribute == null)
      jcasType.jcas.throwFeatMissing("attribute", "edu.pitt.dbmi.xmeso.model.Model.XmesoNumberDataElement");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoNumberDataElement_Type)jcasType).casFeatCode_attribute, v);}    
   
    
  //*--------------*
  //* Feature: value

  /** getter for value - gets value
   * @generated
   * @return value of the feature 
   */
  public int getValue() {
    if (XmesoNumberDataElement_Type.featOkTst && ((XmesoNumberDataElement_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "edu.pitt.dbmi.xmeso.model.Model.XmesoNumberDataElement");
    return jcasType.ll_cas.ll_getIntValue(addr, ((XmesoNumberDataElement_Type)jcasType).casFeatCode_value);}
    
  /** setter for value - sets value 
   * @generated
   * @param v value to set into the feature 
   */
  public void setValue(int v) {
    if (XmesoNumberDataElement_Type.featOkTst && ((XmesoNumberDataElement_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "edu.pitt.dbmi.xmeso.model.Model.XmesoNumberDataElement");
    jcasType.ll_cas.ll_setIntValue(addr, ((XmesoNumberDataElement_Type)jcasType).casFeatCode_value, v);}    
  }

    