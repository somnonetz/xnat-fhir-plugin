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
public abstract class AutoFhirPatientGeneralpractitionerId extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI {
	public static final Logger logger = Logger.getLogger(AutoFhirPatientGeneralpractitionerId.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:patient_generalPractitioner_ID";

	public AutoFhirPatientGeneralpractitionerId(ItemI item)
	{
		super(item);
	}

	public AutoFhirPatientGeneralpractitionerId(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirPatientGeneralpractitionerId(UserI user)
	 **/
	public AutoFhirPatientGeneralpractitionerId(){}

	public AutoFhirPatientGeneralpractitionerId(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:patient_generalPractitioner_ID";
	}

	//FIELD

	private Integer _GeneralpractitionerId=null;

	/**
	 * @return Returns the generalPractitioner_ID.
	 */
	public Integer getGeneralpractitionerId() {
		try{
			if (_GeneralpractitionerId==null){
				_GeneralpractitionerId=getIntegerProperty("generalPractitioner_ID");
				return _GeneralpractitionerId;
			}else {
				return _GeneralpractitionerId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for generalPractitioner_ID.
	 * @param v Value to Set.
	 */
	public void setGeneralpractitionerId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/generalPractitioner_ID",v);
		_GeneralpractitionerId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirPatientGeneralpractitionerIdId=null;

	/**
	 * @return Returns the fhir_patient_generalPractitioner_ID_id.
	 */
	public Integer getFhirPatientGeneralpractitionerIdId() {
		try{
			if (_FhirPatientGeneralpractitionerIdId==null){
				_FhirPatientGeneralpractitionerIdId=getIntegerProperty("fhir_patient_generalPractitioner_ID_id");
				return _FhirPatientGeneralpractitionerIdId;
			}else {
				return _FhirPatientGeneralpractitionerIdId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_patient_generalPractitioner_ID_id.
	 * @param v Value to Set.
	 */
	public void setFhirPatientGeneralpractitionerIdId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_patient_generalPractitioner_ID_id",v);
		_FhirPatientGeneralpractitionerIdId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId> getAllFhirPatientGeneralpractitionerIds(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId> al = new ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId> getFhirPatientGeneralpractitionerIdsByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId> al = new ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId> getFhirPatientGeneralpractitionerIdsByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId> al = new ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirPatientGeneralpractitionerId getFhirPatientGeneralpractitionerIdsByFhirPatientGeneralpractitionerIdId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:patient_generalPractitioner_ID/fhir_patient_generalPractitioner_ID_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirPatientGeneralpractitionerId) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
