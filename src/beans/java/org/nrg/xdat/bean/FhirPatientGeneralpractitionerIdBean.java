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
public class FhirPatientGeneralpractitionerIdBean extends BaseElement implements java.io.Serializable, org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI {
	public static final Logger logger = Logger.getLogger(FhirPatientGeneralpractitionerIdBean.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:patient_generalPractitioner_ID";

	public String getSchemaElementName(){
		return "patient_generalPractitioner_ID";
	}

	public String getFullSchemaElementName(){
		return "fhir:patient_generalPractitioner_ID";
	}

	//FIELD

	private Integer _GeneralpractitionerId=null;

	/**
	 * @return Returns the generalPractitioner_ID.
	 */
	public Integer getGeneralpractitionerId(){
		return _GeneralpractitionerId;
	}

	/**
	 * Sets the value for fhir:patient_generalPractitioner_ID/generalPractitioner_ID.
	 * @param v Value to Set.
	 */
	public void setGeneralpractitionerId(Integer v) {
		_GeneralpractitionerId=v;
	}

	/**
	 * Sets the value for fhir:patient_generalPractitioner_ID/generalPractitioner_ID.
	 * @param v Value to Set.
	 */
	public void setGeneralpractitionerId(String v)  {
		_GeneralpractitionerId=formatInteger(v);
	}

	//FIELD

	private Integer _FhirPatientGeneralpractitionerIdId=null;

	/**
	 * @return Returns the fhir_patient_generalPractitioner_ID_id.
	 */
	public Integer getFhirPatientGeneralpractitionerIdId() {
		return _FhirPatientGeneralpractitionerIdId;
	}

	/**
	 * Sets the value for fhir_patient_generalPractitioner_ID_id.
	 * @param v Value to Set.
	 */
	public void setFhirPatientGeneralpractitionerIdId(Integer v){
		_FhirPatientGeneralpractitionerIdId=v;
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setDataField(String xmlPath,String v) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("generalPractitioner_ID")){
			setGeneralpractitionerId(v);
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
		if (xmlPath.equals("generalPractitioner_ID")){
			return getGeneralpractitionerId();
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
		if (xmlPath.equals("generalPractitioner_ID")){
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
		all_fields.add("generalPractitioner_ID");
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
		writer.write("\n<fhir:patient_generalPractitioner_ID");
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
		writer.write("\n</fhir:patient_generalPractitioner_ID>");
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
		if (_GeneralpractitionerId!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:generalPractitioner_ID");
			writer.write(">");
			writer.write(ValueParser(_GeneralpractitionerId,"integer"));
			writer.write("</fhir:generalPractitioner_ID>");
			header--;
		}
		else{
			writer.write("\n" + createHeader(header++) + "<fhir:generalPractitioner_ID");
			writer.write("/>");
			header--;
		}

	return true;
	}


	protected boolean hasXMLBodyContent(){
		if (_GeneralpractitionerId!=null) return true;
		return true;//REQUIRED generalPractitioner_ID
	}
}
