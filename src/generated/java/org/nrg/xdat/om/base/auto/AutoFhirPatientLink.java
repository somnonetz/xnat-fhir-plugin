/*
 * GENERATED FILE
 * Created on Tue Jul 24 14:20:58 CEST 2018
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
public abstract class AutoFhirPatientLink extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirPatientLinkI {
	public static final Logger logger = Logger.getLogger(AutoFhirPatientLink.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:patient_link";

	public AutoFhirPatientLink(ItemI item)
	{
		super(item);
	}

	public AutoFhirPatientLink(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirPatientLink(UserI user)
	 **/
	public AutoFhirPatientLink(){}

	public AutoFhirPatientLink(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:patient_link";
	}

	//FIELD

	private Integer _OtherId=null;

	/**
	 * @return Returns the other_ID.
	 */
	public Integer getOtherId() {
		try{
			if (_OtherId==null){
				_OtherId=getIntegerProperty("other_ID");
				return _OtherId;
			}else {
				return _OtherId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for other_ID.
	 * @param v Value to Set.
	 */
	public void setOtherId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/other_ID",v);
		_OtherId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Type=null;

	/**
	 * @return Returns the type.
	 */
	public String getType(){
		try{
			if (_Type==null){
				_Type=getStringProperty("type");
				return _Type;
			}else {
				return _Type;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for type.
	 * @param v Value to Set.
	 */
	public void setType(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/type",v);
		_Type=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirPatientLinkId=null;

	/**
	 * @return Returns the fhir_patient_link_id.
	 */
	public Integer getFhirPatientLinkId() {
		try{
			if (_FhirPatientLinkId==null){
				_FhirPatientLinkId=getIntegerProperty("fhir_patient_link_id");
				return _FhirPatientLinkId;
			}else {
				return _FhirPatientLinkId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_patient_link_id.
	 * @param v Value to Set.
	 */
	public void setFhirPatientLinkId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_patient_link_id",v);
		_FhirPatientLinkId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientLink> getAllFhirPatientLinks(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientLink> al = new ArrayList<org.nrg.xdat.om.FhirPatientLink>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientLink> getFhirPatientLinksByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientLink> al = new ArrayList<org.nrg.xdat.om.FhirPatientLink>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientLink> getFhirPatientLinksByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientLink> al = new ArrayList<org.nrg.xdat.om.FhirPatientLink>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirPatientLink getFhirPatientLinksByFhirPatientLinkId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:patient_link/fhir_patient_link_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirPatientLink) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
