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
public class FhirPatientCommunicationBean extends BaseElement implements java.io.Serializable, org.nrg.xdat.model.FhirPatientCommunicationI {
	public static final Logger logger = Logger.getLogger(FhirPatientCommunicationBean.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:patient_communication";

	public String getSchemaElementName(){
		return "patient_communication";
	}

	public String getFullSchemaElementName(){
		return "fhir:patient_communication";
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

	private Boolean _Preferred=null;

	/**
	 * @return Returns the preferred.
	 */
	public Boolean getPreferred() {
		return _Preferred;
	}

	/**
	 * Sets the value for preferred.
	 * @param v Value to Set.
	 */
	public void setPreferred(Object v){
		if(v instanceof Boolean){
			_Preferred=(Boolean)v;
		}else if(v instanceof String){
			_Preferred=formatBoolean((String)v);
		}else if(v!=null){
			throw new IllegalArgumentException();
		}
	}

	//FIELD

	private Integer _FhirPatientCommunicationId=null;

	/**
	 * @return Returns the fhir_patient_communication_id.
	 */
	public Integer getFhirPatientCommunicationId() {
		return _FhirPatientCommunicationId;
	}

	/**
	 * Sets the value for fhir_patient_communication_id.
	 * @param v Value to Set.
	 */
	public void setFhirPatientCommunicationId(Integer v){
		_FhirPatientCommunicationId=v;
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setDataField(String xmlPath,String v) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("language")){
			setLanguage(v);
		}else if (xmlPath.equals("preferred")){
			setPreferred(v);
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
		if (xmlPath.equals("language")){
			return getLanguage();
		}else if (xmlPath.equals("preferred")){
			return getPreferred();
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
		if (xmlPath.equals("language")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("preferred")){
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
		all_fields.add("language");
		all_fields.add("preferred");
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
		writer.write("\n<fhir:patient_communication");
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
		writer.write("\n</fhir:patient_communication>");
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
		if (_Language!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:language");
			writer.write(">");
			writer.write(ValueParser(_Language,"string"));
			writer.write("</fhir:language>");
			header--;
		}
		if (_Preferred!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:preferred");
			writer.write(">");
			writer.write(ValueParser(_Preferred,"boolean"));
			writer.write("</fhir:preferred>");
			header--;
		}
	return true;
	}


	protected boolean hasXMLBodyContent(){
		if (_Language!=null) return true;
		if (_Preferred!=null) return true;
		if(super.hasXMLBodyContent())return true;
		return false;
	}
}
