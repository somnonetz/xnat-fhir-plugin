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
public abstract class AutoFhirAttachement extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirAttachementI {
	public static final Logger logger = Logger.getLogger(AutoFhirAttachement.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:attachement";

	public AutoFhirAttachement(ItemI item)
	{
		super(item);
	}

	public AutoFhirAttachement(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirAttachement(UserI user)
	 **/
	public AutoFhirAttachement(){}

	public AutoFhirAttachement(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:attachement";
	}

	//FIELD

	private String _Contenttype=null;

	/**
	 * @return Returns the contentType.
	 */
	public String getContenttype(){
		try{
			if (_Contenttype==null){
				_Contenttype=getStringProperty("contentType");
				return _Contenttype;
			}else {
				return _Contenttype;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for contentType.
	 * @param v Value to Set.
	 */
	public void setContenttype(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/contentType",v);
		_Contenttype=null;
		} catch (Exception e1) {logger.error(e1);}
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

	private Object _Data=null;

	/**
	 * @return Returns the data.
	 */
	public Object getData(){
		try{
			if (_Data==null){
				_Data=getProperty("data");
				return _Data;
			}else {
				return _Data;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for data.
	 * @param v Value to Set.
	 */
	public void setData(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/data",v);
		_Data=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Url=null;

	/**
	 * @return Returns the url.
	 */
	public String getUrl(){
		try{
			if (_Url==null){
				_Url=getStringProperty("url");
				return _Url;
			}else {
				return _Url;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for url.
	 * @param v Value to Set.
	 */
	public void setUrl(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/url",v);
		_Url=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Size=null;

	/**
	 * @return Returns the size.
	 */
	public Object getSize(){
		try{
			if (_Size==null){
				_Size=getProperty("size");
				return _Size;
			}else {
				return _Size;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for size.
	 * @param v Value to Set.
	 */
	public void setSize(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/size",v);
		_Size=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Hash=null;

	/**
	 * @return Returns the hash.
	 */
	public Object getHash(){
		try{
			if (_Hash==null){
				_Hash=getProperty("hash");
				return _Hash;
			}else {
				return _Hash;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for hash.
	 * @param v Value to Set.
	 */
	public void setHash(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/hash",v);
		_Hash=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Title=null;

	/**
	 * @return Returns the title.
	 */
	public String getTitle(){
		try{
			if (_Title==null){
				_Title=getStringProperty("title");
				return _Title;
			}else {
				return _Title;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for title.
	 * @param v Value to Set.
	 */
	public void setTitle(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/title",v);
		_Title=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Creation=null;

	/**
	 * @return Returns the creation.
	 */
	public Object getCreation(){
		try{
			if (_Creation==null){
				_Creation=getProperty("creation");
				return _Creation;
			}else {
				return _Creation;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for creation.
	 * @param v Value to Set.
	 */
	public void setCreation(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/creation",v);
		_Creation=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirAttachementId=null;

	/**
	 * @return Returns the fhir_attachement_id.
	 */
	public Integer getFhirAttachementId() {
		try{
			if (_FhirAttachementId==null){
				_FhirAttachementId=getIntegerProperty("fhir_attachement_id");
				return _FhirAttachementId;
			}else {
				return _FhirAttachementId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_attachement_id.
	 * @param v Value to Set.
	 */
	public void setFhirAttachementId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_attachement_id",v);
		_FhirAttachementId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirAttachement> getAllFhirAttachements(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirAttachement> al = new ArrayList<org.nrg.xdat.om.FhirAttachement>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirAttachement> getFhirAttachementsByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirAttachement> al = new ArrayList<org.nrg.xdat.om.FhirAttachement>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirAttachement> getFhirAttachementsByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirAttachement> al = new ArrayList<org.nrg.xdat.om.FhirAttachement>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirAttachement getFhirAttachementsByFhirAttachementId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:attachement/fhir_attachement_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirAttachement) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
