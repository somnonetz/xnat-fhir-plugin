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
public abstract class AutoFhirHumannameGiven extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirHumannameGivenI {
	public static final Logger logger = Logger.getLogger(AutoFhirHumannameGiven.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:humanName_given";

	public AutoFhirHumannameGiven(ItemI item)
	{
		super(item);
	}

	public AutoFhirHumannameGiven(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirHumannameGiven(UserI user)
	 **/
	public AutoFhirHumannameGiven(){}

	public AutoFhirHumannameGiven(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:humanName_given";
	}

	//FIELD

	private String _Given=null;

	/**
	 * @return Returns the given.
	 */
	public String getGiven(){
		try{
			if (_Given==null){
				_Given=getStringProperty("given");
				return _Given;
			}else {
				return _Given;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for given.
	 * @param v Value to Set.
	 */
	public void setGiven(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/given",v);
		_Given=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirHumannameGivenId=null;

	/**
	 * @return Returns the fhir_humanName_given_id.
	 */
	public Integer getFhirHumannameGivenId() {
		try{
			if (_FhirHumannameGivenId==null){
				_FhirHumannameGivenId=getIntegerProperty("fhir_humanName_given_id");
				return _FhirHumannameGivenId;
			}else {
				return _FhirHumannameGivenId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_humanName_given_id.
	 * @param v Value to Set.
	 */
	public void setFhirHumannameGivenId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_humanName_given_id",v);
		_FhirHumannameGivenId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumannameGiven> getAllFhirHumannameGivens(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumannameGiven> al = new ArrayList<org.nrg.xdat.om.FhirHumannameGiven>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumannameGiven> getFhirHumannameGivensByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumannameGiven> al = new ArrayList<org.nrg.xdat.om.FhirHumannameGiven>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumannameGiven> getFhirHumannameGivensByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumannameGiven> al = new ArrayList<org.nrg.xdat.om.FhirHumannameGiven>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirHumannameGiven getFhirHumannameGivensByFhirHumannameGivenId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:humanName_given/fhir_humanName_given_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirHumannameGiven) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
