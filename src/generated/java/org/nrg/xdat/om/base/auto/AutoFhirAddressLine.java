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
public abstract class AutoFhirAddressLine extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirAddressLineI {
	public static final Logger logger = Logger.getLogger(AutoFhirAddressLine.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:address_line";

	public AutoFhirAddressLine(ItemI item)
	{
		super(item);
	}

	public AutoFhirAddressLine(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirAddressLine(UserI user)
	 **/
	public AutoFhirAddressLine(){}

	public AutoFhirAddressLine(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:address_line";
	}

	//FIELD

	private String _Line=null;

	/**
	 * @return Returns the line.
	 */
	public String getLine(){
		try{
			if (_Line==null){
				_Line=getStringProperty("line");
				return _Line;
			}else {
				return _Line;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for line.
	 * @param v Value to Set.
	 */
	public void setLine(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/line",v);
		_Line=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirAddressLineId=null;

	/**
	 * @return Returns the fhir_address_line_id.
	 */
	public Integer getFhirAddressLineId() {
		try{
			if (_FhirAddressLineId==null){
				_FhirAddressLineId=getIntegerProperty("fhir_address_line_id");
				return _FhirAddressLineId;
			}else {
				return _FhirAddressLineId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_address_line_id.
	 * @param v Value to Set.
	 */
	public void setFhirAddressLineId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_address_line_id",v);
		_FhirAddressLineId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirAddressLine> getAllFhirAddressLines(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirAddressLine> al = new ArrayList<org.nrg.xdat.om.FhirAddressLine>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirAddressLine> getFhirAddressLinesByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirAddressLine> al = new ArrayList<org.nrg.xdat.om.FhirAddressLine>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirAddressLine> getFhirAddressLinesByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirAddressLine> al = new ArrayList<org.nrg.xdat.om.FhirAddressLine>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirAddressLine getFhirAddressLinesByFhirAddressLineId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:address_line/fhir_address_line_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirAddressLine) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
