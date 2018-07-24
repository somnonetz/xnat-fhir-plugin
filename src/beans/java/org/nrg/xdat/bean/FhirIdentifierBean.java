/*
 * GENERATED FILE
 * Created on Tue Jul 24 14:20:58 CEST 2018
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
public class FhirIdentifierBean extends BaseElement implements java.io.Serializable, org.nrg.xdat.model.FhirIdentifierI {
	public static final Logger logger = Logger.getLogger(FhirIdentifierBean.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:identifier";

	public String getSchemaElementName(){
		return "identifier";
	}

	public String getFullSchemaElementName(){
		return "fhir:identifier";
	}

	//FIELD

	private String _Use=null;

	/**
	 * @return Returns the use.
	 */
	public String getUse(){
		return _Use;
	}

	/**
	 * Sets the value for use.
	 * @param v Value to Set.
	 */
	public void setUse(String v){
		_Use=v;
	}

	//FIELD

	private String _Type=null;

	/**
	 * @return Returns the type.
	 */
	public String getType(){
		return _Type;
	}

	/**
	 * Sets the value for type.
	 * @param v Value to Set.
	 */
	public void setType(String v){
		_Type=v;
	}

	//FIELD

	private String _System=null;

	/**
	 * @return Returns the system.
	 */
	public String getSystem(){
		return _System;
	}

	/**
	 * Sets the value for system.
	 * @param v Value to Set.
	 */
	public void setSystem(String v){
		_System=v;
	}

	//FIELD

	private String _Value=null;

	/**
	 * @return Returns the value.
	 */
	public String getValue(){
		return _Value;
	}

	/**
	 * Sets the value for value.
	 * @param v Value to Set.
	 */
	public void setValue(String v){
		_Value=v;
	}

	//FIELD

	private Date _Period_start=null;

	/**
	 * @return Returns the period/start.
	 */
	public Date getPeriod_start(){
		return _Period_start;
	}

	/**
	 * Sets the value for period/start.
	 * @param v Value to Set.
	 */
	public void setPeriod_start(Date v){
		_Period_start=v;
	}

	/**
	 * Sets the value for period/start.
	 * @param v Value to Set.
	 */
	public void setPeriod_start(Object v){
		throw new IllegalArgumentException();
	}

	/**
	 * Sets the value for period/start.
	 * @param v Value to Set.
	 */
	public void setPeriod_start(String v)  {
		_Period_start=formatDateTime(v);
	}

	//FIELD

	private Date _Period_end=null;

	/**
	 * @return Returns the period/end.
	 */
	public Date getPeriod_end(){
		return _Period_end;
	}

	/**
	 * Sets the value for period/end.
	 * @param v Value to Set.
	 */
	public void setPeriod_end(Date v){
		_Period_end=v;
	}

	/**
	 * Sets the value for period/end.
	 * @param v Value to Set.
	 */
	public void setPeriod_end(Object v){
		throw new IllegalArgumentException();
	}

	/**
	 * Sets the value for period/end.
	 * @param v Value to Set.
	 */
	public void setPeriod_end(String v)  {
		_Period_end=formatDateTime(v);
	}

	//FIELD

	private Integer _AssignerId=null;

	/**
	 * @return Returns the assigner_ID.
	 */
	public Integer getAssignerId(){
		return _AssignerId;
	}

	/**
	 * Sets the value for fhir:identifier/assigner_ID.
	 * @param v Value to Set.
	 */
	public void setAssignerId(Integer v) {
		_AssignerId=v;
	}

	/**
	 * Sets the value for fhir:identifier/assigner_ID.
	 * @param v Value to Set.
	 */
	public void setAssignerId(String v)  {
		_AssignerId=formatInteger(v);
	}

	//FIELD

	private Integer _FhirIdentifierId=null;

	/**
	 * @return Returns the fhir_identifier_id.
	 */
	public Integer getFhirIdentifierId() {
		return _FhirIdentifierId;
	}

	/**
	 * Sets the value for fhir_identifier_id.
	 * @param v Value to Set.
	 */
	public void setFhirIdentifierId(Integer v){
		_FhirIdentifierId=v;
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setDataField(String xmlPath,String v) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("use")){
			setUse(v);
		}else if (xmlPath.equals("type")){
			setType(v);
		}else if (xmlPath.equals("system")){
			setSystem(v);
		}else if (xmlPath.equals("value")){
			setValue(v);
		}else if (xmlPath.equals("period/start")){
			setPeriod_start(v);
		}else if (xmlPath.equals("period/end")){
			setPeriod_end(v);
		}else if (xmlPath.equals("assigner_ID")){
			setAssignerId(v);
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
		if (xmlPath.equals("use")){
			return getUse();
		}else if (xmlPath.equals("type")){
			return getType();
		}else if (xmlPath.equals("system")){
			return getSystem();
		}else if (xmlPath.equals("value")){
			return getValue();
		}else if (xmlPath.equals("period/start")){
			return getPeriod_start();
		}else if (xmlPath.equals("period/end")){
			return getPeriod_end();
		}else if (xmlPath.equals("assigner_ID")){
			return getAssignerId();
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
		if (xmlPath.equals("use")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("type")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("system")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("value")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("period/start")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("period/end")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("assigner_ID")){
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
		all_fields.add("use");
		all_fields.add("type");
		all_fields.add("system");
		all_fields.add("value");
		all_fields.add("period/start");
		all_fields.add("period/end");
		all_fields.add("assigner_ID");
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
		writer.write("\n<fhir:FHIRIdentifier");
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
		writer.write("\n</fhir:FHIRIdentifier>");
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
		if (_Use!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:use");
			writer.write(">");
			writer.write(ValueParser(_Use,"string"));
			writer.write("</fhir:use>");
			header--;
		}
		else{
			writer.write("\n" + createHeader(header++) + "<fhir:use");
			writer.write("/>");
			header--;
		}

		if (_Type!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:type");
			writer.write(">");
			writer.write(ValueParser(_Type,"string"));
			writer.write("</fhir:type>");
			header--;
		}
		else{
			writer.write("\n" + createHeader(header++) + "<fhir:type");
			writer.write("/>");
			header--;
		}

		if (_System!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:system");
			writer.write(">");
			writer.write(ValueParser(_System,"string"));
			writer.write("</fhir:system>");
			header--;
		}
		if (_Value!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:value");
			writer.write(">");
			writer.write(ValueParser(_Value,"string"));
			writer.write("</fhir:value>");
			header--;
		}
			int child0=0;
			int att0=0;
			if(_Period_end!=null)
			child0++;
			if(_Period_start!=null)
			child0++;
			if(child0>0 || att0>0){
				writer.write("\n" + createHeader(header++) + "<fhir:period");
			if(child0==0){
				writer.write("/>");
			}else{
				writer.write(">");
		if (_Period_start!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:start");
			writer.write(">");
			writer.write(ValueParser(_Period_start,"dateTime"));
			writer.write("</fhir:start>");
			header--;
		}
		if (_Period_end!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:end");
			writer.write(">");
			writer.write(ValueParser(_Period_end,"dateTime"));
			writer.write("</fhir:end>");
			header--;
		}
				writer.write("\n" + createHeader(--header) + "</fhir:period>");
			}
			}

		if (_AssignerId!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:assigner_ID");
			writer.write(">");
			writer.write(ValueParser(_AssignerId,"integer"));
			writer.write("</fhir:assigner_ID>");
			header--;
		}
	return true;
	}


	protected boolean hasXMLBodyContent(){
		if (_Use!=null) return true;
		return true;//REQUIRED use
	}
}
