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
public abstract class AutoFhirHumannameSuffix extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirHumannameSuffixI {
	public static final Logger logger = Logger.getLogger(AutoFhirHumannameSuffix.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:humanName_suffix";

	public AutoFhirHumannameSuffix(ItemI item)
	{
		super(item);
	}

	public AutoFhirHumannameSuffix(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirHumannameSuffix(UserI user)
	 **/
	public AutoFhirHumannameSuffix(){}

	public AutoFhirHumannameSuffix(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:humanName_suffix";
	}

	//FIELD

	private String _Suffix=null;

	/**
	 * @return Returns the suffix.
	 */
	public String getSuffix(){
		try{
			if (_Suffix==null){
				_Suffix=getStringProperty("suffix");
				return _Suffix;
			}else {
				return _Suffix;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for suffix.
	 * @param v Value to Set.
	 */
	public void setSuffix(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/suffix",v);
		_Suffix=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirHumannameSuffixId=null;

	/**
	 * @return Returns the fhir_humanName_suffix_id.
	 */
	public Integer getFhirHumannameSuffixId() {
		try{
			if (_FhirHumannameSuffixId==null){
				_FhirHumannameSuffixId=getIntegerProperty("fhir_humanName_suffix_id");
				return _FhirHumannameSuffixId;
			}else {
				return _FhirHumannameSuffixId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_humanName_suffix_id.
	 * @param v Value to Set.
	 */
	public void setFhirHumannameSuffixId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_humanName_suffix_id",v);
		_FhirHumannameSuffixId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumannameSuffix> getAllFhirHumannameSuffixs(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumannameSuffix> al = new ArrayList<org.nrg.xdat.om.FhirHumannameSuffix>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumannameSuffix> getFhirHumannameSuffixsByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumannameSuffix> al = new ArrayList<org.nrg.xdat.om.FhirHumannameSuffix>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumannameSuffix> getFhirHumannameSuffixsByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumannameSuffix> al = new ArrayList<org.nrg.xdat.om.FhirHumannameSuffix>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirHumannameSuffix getFhirHumannameSuffixsByFhirHumannameSuffixId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:humanName_suffix/fhir_humanName_suffix_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirHumannameSuffix) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
