

/* First created by JCasGen Fri Jul 29 16:10:25 EDT 2016 */
package edu.pitt.dbmi.xmeso.model.Model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Type defined in edu.pitt.dbmi.xmeso.model.Model
 * Updated by JCasGen Mon Aug 01 09:56:26 EDT 2016
 * XML source: C:/Users/zhy19/workspace/xmeso/descriptor/edu/pitt/dbmi/xmeso/XmesoEngine.xml
 * @generated */
public class XmesoCaseForm extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(XmesoCaseForm.class);
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
  protected XmesoCaseForm() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public XmesoCaseForm(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public XmesoCaseForm(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public XmesoCaseForm(JCas jcas, int begin, int end) {
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
  //* Feature: surgicalProcedure

  /** getter for surgicalProcedure - gets surgicalProcedure
   * @generated
   * @return value of the feature 
   */
  public String getSurgicalProcedure() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_surgicalProcedure == null)
      jcasType.jcas.throwFeatMissing("surgicalProcedure", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_surgicalProcedure);}
    
  /** setter for surgicalProcedure - sets surgicalProcedure 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSurgicalProcedure(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_surgicalProcedure == null)
      jcasType.jcas.throwFeatMissing("surgicalProcedure", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_surgicalProcedure, v);}    
   
    
  //*--------------*
  //* Feature: ultrastructuralFindings

  /** getter for ultrastructuralFindings - gets ultrastructuralFindings
   * @generated
   * @return value of the feature 
   */
  public String getUltrastructuralFindings() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_ultrastructuralFindings == null)
      jcasType.jcas.throwFeatMissing("ultrastructuralFindings", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_ultrastructuralFindings);}
    
  /** setter for ultrastructuralFindings - sets ultrastructuralFindings 
   * @generated
   * @param v value to set into the feature 
   */
  public void setUltrastructuralFindings(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_ultrastructuralFindings == null)
      jcasType.jcas.throwFeatMissing("ultrastructuralFindings", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_ultrastructuralFindings, v);}    
   
    
  //*--------------*
  //* Feature: lymphNodesExamined

  /** getter for lymphNodesExamined - gets lymphNodesExamined
   * @generated
   * @return value of the feature 
   */
  public String getLymphNodesExamined() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_lymphNodesExamined == null)
      jcasType.jcas.throwFeatMissing("lymphNodesExamined", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_lymphNodesExamined);}
    
  /** setter for lymphNodesExamined - sets lymphNodesExamined 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLymphNodesExamined(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_lymphNodesExamined == null)
      jcasType.jcas.throwFeatMissing("lymphNodesExamined", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_lymphNodesExamined, v);}    
   
    
  //*--------------*
  //* Feature: specialStain

  /** getter for specialStain - gets specialStain
   * @generated
   * @return value of the feature 
   */
  public String getSpecialStain() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_specialStain == null)
      jcasType.jcas.throwFeatMissing("specialStain", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_specialStain);}
    
  /** setter for specialStain - sets specialStain 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSpecialStain(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_specialStain == null)
      jcasType.jcas.throwFeatMissing("specialStain", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_specialStain, v);}    
   
    
  //*--------------*
  //* Feature: invasiveTumor

  /** getter for invasiveTumor - gets invasiveTumor
   * @generated
   * @return value of the feature 
   */
  public String getInvasiveTumor() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_invasiveTumor == null)
      jcasType.jcas.throwFeatMissing("invasiveTumor", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_invasiveTumor);}
    
  /** setter for invasiveTumor - sets invasiveTumor 
   * @generated
   * @param v value to set into the feature 
   */
  public void setInvasiveTumor(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_invasiveTumor == null)
      jcasType.jcas.throwFeatMissing("invasiveTumor", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_invasiveTumor, v);}    
   
    
  //*--------------*
  //* Feature: surgicalProcedureTerm

  /** getter for surgicalProcedureTerm - gets surgicalProcedureTerm
   * @generated
   * @return value of the feature 
   */
  public String getSurgicalProcedureTerm() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_surgicalProcedureTerm == null)
      jcasType.jcas.throwFeatMissing("surgicalProcedureTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_surgicalProcedureTerm);}
    
  /** setter for surgicalProcedureTerm - sets surgicalProcedureTerm 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSurgicalProcedureTerm(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_surgicalProcedureTerm == null)
      jcasType.jcas.throwFeatMissing("surgicalProcedureTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_surgicalProcedureTerm, v);}    
   
    
  //*--------------*
  //* Feature: ultrastructuralFindingsTerm

  /** getter for ultrastructuralFindingsTerm - gets ultrastructuralFindingsTerm
   * @generated
   * @return value of the feature 
   */
  public String getUltrastructuralFindingsTerm() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_ultrastructuralFindingsTerm == null)
      jcasType.jcas.throwFeatMissing("ultrastructuralFindingsTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_ultrastructuralFindingsTerm);}
    
  /** setter for ultrastructuralFindingsTerm - sets ultrastructuralFindingsTerm 
   * @generated
   * @param v value to set into the feature 
   */
  public void setUltrastructuralFindingsTerm(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_ultrastructuralFindingsTerm == null)
      jcasType.jcas.throwFeatMissing("ultrastructuralFindingsTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_ultrastructuralFindingsTerm, v);}    
   
    
  //*--------------*
  //* Feature: lymphNodesExaminedTerm

  /** getter for lymphNodesExaminedTerm - gets lymphNodesExaminedTerm
   * @generated
   * @return value of the feature 
   */
  public String getLymphNodesExaminedTerm() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_lymphNodesExaminedTerm == null)
      jcasType.jcas.throwFeatMissing("lymphNodesExaminedTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_lymphNodesExaminedTerm);}
    
  /** setter for lymphNodesExaminedTerm - sets lymphNodesExaminedTerm 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLymphNodesExaminedTerm(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_lymphNodesExaminedTerm == null)
      jcasType.jcas.throwFeatMissing("lymphNodesExaminedTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_lymphNodesExaminedTerm, v);}    
   
    
  //*--------------*
  //* Feature: specialStainTerm

  /** getter for specialStainTerm - gets specialStainTerm
   * @generated
   * @return value of the feature 
   */
  public String getSpecialStainTerm() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_specialStainTerm == null)
      jcasType.jcas.throwFeatMissing("specialStainTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_specialStainTerm);}
    
  /** setter for specialStainTerm - sets specialStainTerm 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSpecialStainTerm(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_specialStainTerm == null)
      jcasType.jcas.throwFeatMissing("specialStainTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_specialStainTerm, v);}    
   
    
  //*--------------*
  //* Feature: invasiveTumorTerm

  /** getter for invasiveTumorTerm - gets invasiveTumorTerm
   * @generated
   * @return value of the feature 
   */
  public String getInvasiveTumorTerm() {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_invasiveTumorTerm == null)
      jcasType.jcas.throwFeatMissing("invasiveTumorTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    return jcasType.ll_cas.ll_getStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_invasiveTumorTerm);}
    
  /** setter for invasiveTumorTerm - sets invasiveTumorTerm 
   * @generated
   * @param v value to set into the feature 
   */
  public void setInvasiveTumorTerm(String v) {
    if (XmesoCaseForm_Type.featOkTst && ((XmesoCaseForm_Type)jcasType).casFeat_invasiveTumorTerm == null)
      jcasType.jcas.throwFeatMissing("invasiveTumorTerm", "edu.pitt.dbmi.xmeso.model.Model.XmesoCaseForm");
    jcasType.ll_cas.ll_setStringValue(addr, ((XmesoCaseForm_Type)jcasType).casFeatCode_invasiveTumorTerm, v);}    
  }

    