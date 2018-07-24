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
public abstract class AutoFhirIdentifier extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirIdentifierI {
	public static final Logger logger = Logger.getLogger(AutoFhirIdentifier.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:identifier";

	public AutoFhirIdentifier(ItemI item)
	{
		super(item);
	}

	public AutoFhirIdentifier(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirIdentifier(UserI user)
	 **/
	public AutoFhirIdentifier(){}

	public AutoFhirIdentifier(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:identifier";
	}

	//FIELD

	private String _Use=null;

	/**
	 * @return Returns the use.
	 */
	public String getUse(){
		try{
			if (_Use==null){
				_Use=getStringProperty("use");
				return _Use;
			}else {
				return _Use;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for use.
	 * @param v Value to Set.
	 */
	public void setUse(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/use",v);
		_Use=null;
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

	private String _System=null;

	/**
	 * @return Returns the system.
	 */
	public String getSystem(){
		try{
			if (_System==null){
				_System=getStringProperty("system");
				return _System;
			}else {
				return _System;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for system.
	 * @param v Value to Set.
	 */
	public void setSystem(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/system",v);
		_System=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Value=null;

	/**
	 * @return Returns the value.
	 */
	public String getValue(){
		try{
			if (_Value==null){
				_Value=getStringProperty("value");
				return _Value;
			}else {
				return _Value;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for value.
	 * @param v Value to Set.
	 */
	public void setValue(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/value",v);
		_Value=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Period_start=null;

	/**
	 * @return Returns the period/start.
	 */
	public Object getPeriod_start(){
		try{
			if (_Period_start==null){
				_Period_start=getProperty("period/start");
				return _Period_start;
			}else {
				return _Period_start;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for period/start.
	 * @param v Value to Set.
	 */
	public void setPeriod_start(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/period/start",v);
		_Period_start=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Period_end=null;

	/**
	 * @return Returns the period/end.
	 */
	public Object getPeriod_end(){
		try{
			if (_Period_end==null){
				_Period_end=getProperty("period/end");
				return _Period_end;
			}else {
				return _Period_end;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for period/end.
	 * @param v Value to Set.
	 */
	public void setPeriod_end(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/period/end",v);
		_Period_end=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _AssignerId=null;

	/**
	 * @return Returns the assigner_ID.
	 */
	public Integer getAssignerId() {
		try{
			if (_AssignerId==null){
				_AssignerId=getIntegerProperty("assigner_ID");
				return _AssignerId;
			}else {
				return _AssignerId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for assigner_ID.
	 * @param v Value to Set.
	 */
	public void setAssignerId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/assigner_ID",v);
		_AssignerId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirIdentifierId=null;

	/**
	 * @return Returns the fhir_identifier_id.
	 */
	public Integer getFhirIdentifierId() {
		try{
			if (_FhirIdentifierId==null){
				_FhirIdentifierId=getIntegerProperty("fhir_identifier_id");
				return _FhirIdentifierId;
			}else {
				return _FhirIdentifierId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_identifier_id.
	 * @param v Value to Set.
	 */
	public void setFhirIdentifierId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_identifier_id",v);
		_FhirIdentifierId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirIdentifier> getAllFhirIdentifiers(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirIdentifier> al = new ArrayList<org.nrg.xdat.om.FhirIdentifier>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirIdentifier> getFhirIdentifiersByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirIdentifier> al = new ArrayList<org.nrg.xdat.om.FhirIdentifier>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirIdentifier> getFhirIdentifiersByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirIdentifier> al = new ArrayList<org.nrg.xdat.om.FhirIdentifier>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirIdentifier getFhirIdentifiersByFhirIdentifierId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:identifier/fhir_identifier_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirIdentifier) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
