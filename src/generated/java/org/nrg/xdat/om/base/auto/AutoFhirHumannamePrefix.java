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
public abstract class AutoFhirHumannamePrefix extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirHumannamePrefixI {
	public static final Logger logger = Logger.getLogger(AutoFhirHumannamePrefix.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:humanName_prefix";

	public AutoFhirHumannamePrefix(ItemI item)
	{
		super(item);
	}

	public AutoFhirHumannamePrefix(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirHumannamePrefix(UserI user)
	 **/
	public AutoFhirHumannamePrefix(){}

	public AutoFhirHumannamePrefix(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:humanName_prefix";
	}

	//FIELD

	private String _Prefix=null;

	/**
	 * @return Returns the prefix.
	 */
	public String getPrefix(){
		try{
			if (_Prefix==null){
				_Prefix=getStringProperty("prefix");
				return _Prefix;
			}else {
				return _Prefix;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for prefix.
	 * @param v Value to Set.
	 */
	public void setPrefix(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/prefix",v);
		_Prefix=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirHumannamePrefixId=null;

	/**
	 * @return Returns the fhir_humanName_prefix_id.
	 */
	public Integer getFhirHumannamePrefixId() {
		try{
			if (_FhirHumannamePrefixId==null){
				_FhirHumannamePrefixId=getIntegerProperty("fhir_humanName_prefix_id");
				return _FhirHumannamePrefixId;
			}else {
				return _FhirHumannamePrefixId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_humanName_prefix_id.
	 * @param v Value to Set.
	 */
	public void setFhirHumannamePrefixId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_humanName_prefix_id",v);
		_FhirHumannamePrefixId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumannamePrefix> getAllFhirHumannamePrefixs(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumannamePrefix> al = new ArrayList<org.nrg.xdat.om.FhirHumannamePrefix>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumannamePrefix> getFhirHumannamePrefixsByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumannamePrefix> al = new ArrayList<org.nrg.xdat.om.FhirHumannamePrefix>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumannamePrefix> getFhirHumannamePrefixsByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumannamePrefix> al = new ArrayList<org.nrg.xdat.om.FhirHumannamePrefix>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirHumannamePrefix getFhirHumannamePrefixsByFhirHumannamePrefixId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:humanName_prefix/fhir_humanName_prefix_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirHumannamePrefix) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
