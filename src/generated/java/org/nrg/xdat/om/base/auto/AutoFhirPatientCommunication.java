/*
 * GENERATED FILE
 * Created on Tue Jul 24 17:16:36 CEST 2018
 *
 */
package org.nrg.xdat.om.base.auto;
import org.apache.log4j.Logger;
import org.nrg.xft.*;
import org.nrg.xft.security.UserI;
import org.nrg.xdat.om.*;
import org.nrg.xft.utils.ResourceFile;
import org.nrg.xft.exception.*;

import java.util.*;

/**
 * @author XDAT
 *
 *//*
 ******************************** 
 * DO NOT MODIFY THIS FILE
 *
 ********************************/
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class AutoFhirPatientCommunication extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirPatientCommunicationI {
	public static final Logger logger = Logger.getLogger(AutoFhirPatientCommunication.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:patient_communication";

	public AutoFhirPatientCommunication(ItemI item)
	{
		super(item);
	}

	public AutoFhirPatientCommunication(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirPatientCommunication(UserI user)
	 **/
	public AutoFhirPatientCommunication(){}

	public AutoFhirPatientCommunication(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:patient_communication";
	}

	//FIELD

	private String _Language=null;

	/**
	 * @return Returns the language.
	 */
	public String getLanguage(){
		try{
			if (_Language==null){
				_Language=getStringProperty("language");
				return _Language;
			}else {
				return _Language;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for language.
	 * @param v Value to Set.
	 */
	public void setLanguage(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/language",v);
		_Language=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Boolean _Preferred=null;

	/**
	 * @return Returns the preferred.
	 */
	public Boolean getPreferred() {
		try{
			if (_Preferred==null){
				_Preferred=getBooleanProperty("preferred");
				return _Preferred;
			}else {
				return _Preferred;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for preferred.
	 * @param v Value to Set.
	 */
	public void setPreferred(Object v){
		try{
		setBooleanProperty(SCHEMA_ELEMENT_NAME + "/preferred",v);
		_Preferred=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirPatientCommunicationId=null;

	/**
	 * @return Returns the fhir_patient_communication_id.
	 */
	public Integer getFhirPatientCommunicationId() {
		try{
			if (_FhirPatientCommunicationId==null){
				_FhirPatientCommunicationId=getIntegerProperty("fhir_patient_communication_id");
				return _FhirPatientCommunicationId;
			}else {
				return _FhirPatientCommunicationId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_patient_communication_id.
	 * @param v Value to Set.
	 */
	public void setFhirPatientCommunicationId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_patient_communication_id",v);
		_FhirPatientCommunicationId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientCommunication> getAllFhirPatientCommunications(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientCommunication> al = new ArrayList<org.nrg.xdat.om.FhirPatientCommunication>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientCommunication> getFhirPatientCommunicationsByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientCommunication> al = new ArrayList<org.nrg.xdat.om.FhirPatientCommunication>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientCommunication> getFhirPatientCommunicationsByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientCommunication> al = new ArrayList<org.nrg.xdat.om.FhirPatientCommunication>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirPatientCommunication getFhirPatientCommunicationsByFhirPatientCommunicationId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:patient_communication/fhir_patient_communication_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirPatientCommunication) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
			else
				 return null;
		} catch (Exception e) {
			logger.error("",e);
		}

		return null;
	}

	public static ArrayList wrapItems(ArrayList items)
	{
		ArrayList al = new ArrayList();
		al = org.nrg.xdat.base.BaseElement.WrapItems(items);
		al.trimToSize();
		return al;
	}

	public static ArrayList wrapItems(org.nrg.xft.collections.ItemCollection items)
	{
		return wrapItems(items.getItems());
	}
	public ArrayList<ResourceFile> getFileResources(String rootPath, boolean preventLoop){
ArrayList<ResourceFile> _return = new ArrayList<ResourceFile>();
	 boolean localLoop = preventLoop;
	        localLoop = preventLoop;
	
	return _return;
}
}
