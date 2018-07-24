/*
 * GENERATED FILE
 * Created on Tue Jul 24 17:16:36 CEST 2018
 *
 */
package org.nrg.xdat.bean;
import org.apache.log4j.Logger;
import org.nrg.xdat.bean.base.BaseElement;

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
public class FhirAttachementBean extends BaseElement implements java.io.Serializable, org.nrg.xdat.model.FhirAttachementI {
	public static final Logger logger = Logger.getLogger(FhirAttachementBean.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:attachement";

	public String getSchemaElementName(){
		return "attachement";
	}

	public String getFullSchemaElementName(){
		return "fhir:attachement";
	}

	//FIELD

	private String _Contenttype=null;

	/**
	 * @return Returns the contentType.
	 */
	public String getContenttype(){
		return _Contenttype;
	}

	/**
	 * Sets the value for contentType.
	 * @param v Value to Set.
	 */
	public void setContenttype(String v){
		_Contenttype=v;
	}

	//FIELD

	private String _Language=null;

	/**
	 * @return Returns the language.
	 */
	public String getLanguage(){
		return _Language;
	}

	/**
	 * Sets the value for language.
	 * @param v Value to Set.
	 */
	public void setLanguage(String v){
		_Language=v;
	}

	//FIELD

	private Object _Data=null;

	/**
	 * @return Returns the data.
	 */
	public Object getData(){
		return _Data;
	}

	/**
	 * Sets the value for data.
	 * @param v Value to Set.
	 */
	public void setData(Object v){
		_Data=v;
	}

	//FIELD

	private String _Url=null;

	/**
	 * @return Returns the url.
	 */
	public String getUrl(){
		return _Url;
	}

	/**
	 * Sets the value for url.
	 * @param v Value to Set.
	 */
	public void setUrl(String v){
		_Url=v;
	}

	//FIELD

	private Object _Size=null;

	/**
	 * @return Returns the size.
	 */
	public Object getSize(){
		return _Size;
	}

	/**
	 * Sets the value for size.
	 * @param v Value to Set.
	 */
	public void setSize(Object v){
		_Size=v;
	}

	//FIELD

	private Object _Hash=null;

	/**
	 * @return Returns the hash.
	 */
	public Object getHash(){
		return _Hash;
	}

	/**
	 * Sets the value for hash.
	 * @param v Value to Set.
	 */
	public void setHash(Object v){
		_Hash=v;
	}

	//FIELD

	private String _Title=null;

	/**
	 * @return Returns the title.
	 */
	public String getTitle(){
		return _Title;
	}

	/**
	 * Sets the value for title.
	 * @param v Value to Set.
	 */
	public void setTitle(String v){
		_Title=v;
	}

	//FIELD

	private Date _Creation=null;

	/**
	 * @return Returns the creation.
	 */
	public Date getCreation(){
		return _Creation;
	}

	/**
	 * Sets the value for creation.
	 * @param v Value to Set.
	 */
	public void setCreation(Date v){
		_Creation=v;
	}

	/**
	 * Sets the value for creation.
	 * @param v Value to Set.
	 */
	public void setCreation(Object v){
		throw new IllegalArgumentException();
	}

	/**
	 * Sets the value for creation.
	 * @param v Value to Set.
	 */
	public void setCreation(String v)  {
		_Creation=formatDateTime(v);
	}

	//FIELD

	private Integer _FhirAttachementId=null;

	/**
	 * @return Returns the fhir_attachement_id.
	 */
	public Integer getFhirAttachementId() {
		return _FhirAttachementId;
	}

	/**
	 * Sets the value for fhir_attachement_id.
	 * @param v Value to Set.
	 */
	public void setFhirAttachementId(Integer v){
		_FhirAttachementId=v;
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setDataField(String xmlPath,String v) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("contentType")){
			setContenttype(v);
		}else if (xmlPath.equals("language")){
			setLanguage(v);
		}else if (xmlPath.equals("data")){
			setData(v);
		}else if (xmlPath.equals("url")){
			setUrl(v);
		}else if (xmlPath.equals("size")){
			setSize(v);
		}else if (xmlPath.equals("hash")){
			setHash(v);
		}else if (xmlPath.equals("title")){
			setTitle(v);
		}else if (xmlPath.equals("creation")){
			setCreation(v);
		}
		else{
			super.setDataField(xmlPath,v);
		}
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setReferenceField(String xmlPath,BaseElement v) throws BaseElement.UnknownFieldException{
			super.setReferenceField(xmlPath,v);
	}

	/**
	 * Gets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public Object getDataFieldValue(String xmlPath) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("contentType")){
			return getContenttype();
		}else if (xmlPath.equals("language")){
			return getLanguage();
		}else if (xmlPath.equals("data")){
			return getData();
		}else if (xmlPath.equals("url")){
			return getUrl();
		}else if (xmlPath.equals("size")){
			return getSize();
		}else if (xmlPath.equals("hash")){
			return getHash();
		}else if (xmlPath.equals("title")){
			return getTitle();
		}else if (xmlPath.equals("creation")){
			return getCreation();
		}
		else{
			return super.getDataFieldValue(xmlPath);
		}
	}

	/**
	 * Gets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public Object getReferenceField(String xmlPath) throws BaseElement.UnknownFieldException{
			return super.getReferenceField(xmlPath);
	}

	/**
	 * Gets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public String getReferenceFieldName(String xmlPath) throws BaseElement.UnknownFieldException{
			return super.getReferenceFieldName(xmlPath);
	}

	/**
	 * Returns whether or not this is a reference field
	 */
	public String getFieldType(String xmlPath) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("contentType")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("language")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("data")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("url")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("size")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("hash")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("title")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("creation")){
			return BaseElement.field_data;
		}
		else{
			return super.getFieldType(xmlPath);
		}
	}

	/**
	 * Returns arraylist of all fields
	 */
	public ArrayList getAllFields() {
		ArrayList all_fields=new ArrayList();
		all_fields.add("contentType");
		all_fields.add("language");
		all_fields.add("data");
		all_fields.add("url");
		all_fields.add("size");
		all_fields.add("hash");
		all_fields.add("title");
		all_fields.add("creation");
		all_fields.addAll(super.getAllFields());
		return all_fields;
	}


	public String toString(){
		java.io.StringWriter sw = new java.io.StringWriter();
		try{this.toXML(sw,true);}catch(java.io.IOException e){}
		return sw.toString();
	}


	public void toXML(java.io.Writer writer,boolean prettyPrint) throws java.io.IOException{
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.write("\n<fhir:FHIRAttachement");
		TreeMap map = new TreeMap();
		map.putAll(getXMLAtts());
		map.put("xmlns:arc","http://nrg.wustl.edu/arc");
		map.put("xmlns:cat","http://nrg.wustl.edu/catalog");
		map.put("xmlns:fhir","http://cbmi.htw-berlin.de/fhir");
		map.put("xmlns:pipe","http://nrg.wustl.edu/pipe");
		map.put("xmlns:prov","http://www.nbirn.net/prov");
		map.put("xmlns:scr","http://nrg.wustl.edu/scr");
		map.put("xmlns:val","http://nrg.wustl.edu/val");
		map.put("xmlns:wrk","http://nrg.wustl.edu/workflow");
		map.put("xmlns:xdat","http://nrg.wustl.edu/security");
		map.put("xmlns:xnat","http://nrg.wustl.edu/xnat");
		map.put("xmlns:xnat_a","http://nrg.wustl.edu/xnat_assessments");
		map.put("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
		java.util.Iterator iter =map.keySet().iterator();
		while(iter.hasNext()){
			String key = (String)iter.next();
			writer.write(" " + key + "=\"" + map.get(key) + "\"");
		}
		int header = 0;
		if (prettyPrint)header++;
		writer.write(">");
		addXMLBody(writer,header);
		if (prettyPrint)header--;
		writer.write("\n</fhir:FHIRAttachement>");
	}


	protected void addXMLAtts(java.io.Writer writer) throws java.io.IOException{
		TreeMap map = this.getXMLAtts();
		java.util.Iterator iter =map.keySet().iterator();
		while(iter.hasNext()){
			String key = (String)iter.next();
			writer.write(" " + key + "=\"" + map.get(key) + "\"");
		}
	}


	protected TreeMap getXMLAtts() {
		TreeMap map = super.getXMLAtts();
		return map;
	}


	protected boolean addXMLBody(java.io.Writer writer, int header) throws java.io.IOException{
		super.addXMLBody(writer,header);
		if (_Contenttype!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:contentType");
			writer.write(">");
			writer.write(ValueParser(_Contenttype,"string"));
			writer.write("</fhir:contentType>");
			header--;
		}
		if (_Language!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:language");
			writer.write(">");
			writer.write(ValueParser(_Language,"string"));
			writer.write("</fhir:language>");
			header--;
		}
		else{
			writer.write("\n" + createHeader(header++) + "<fhir:language");
			writer.write("/>");
			header--;
		}

		if (_Data!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:data");
			writer.write(">");
			writer.write(ValueParser(_Data,"base64Binary"));
			writer.write("</fhir:data>");
			header--;
		}
		if (_Url!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:url");
			writer.write(">");
			writer.write(ValueParser(_Url,"string"));
			writer.write("</fhir:url>");
			header--;
		}
		if (_Size!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:size");
			writer.write(">");
			writer.write(ValueParser(_Size,"unsignedInt"));
			writer.write("</fhir:size>");
			header--;
		}
		if (_Hash!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:hash");
			writer.write(">");
			writer.write(ValueParser(_Hash,"base64Binary"));
			writer.write("</fhir:hash>");
			header--;
		}
		if (_Title!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:title");
			writer.write(">");
			writer.write(ValueParser(_Title,"string"));
			writer.write("</fhir:title>");
			header--;
		}
		if (_Creation!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:creation");
			writer.write(">");
			writer.write(ValueParser(_Creation,"dateTime"));
			writer.write("</fhir:creation>");
			header--;
		}
	return true;
	}


	protected boolean hasXMLBodyContent(){
		if (_Contenttype!=null) return true;
		if (_Language!=null) return true;
		return true;//REQUIRED language
	}
}
