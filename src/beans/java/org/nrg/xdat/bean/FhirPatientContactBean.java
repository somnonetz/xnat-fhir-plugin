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
public class FhirPatientContactBean extends BaseElement implements java.io.Serializable, org.nrg.xdat.model.FhirPatientContactI {
	public static final Logger logger = Logger.getLogger(FhirPatientContactBean.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:patient_contact";

	public String getSchemaElementName(){
		return "patient_contact";
	}

	public String getFullSchemaElementName(){
		return "fhir:patient_contact";
	}

	//FIELD

	private String _Relationship=null;

	/**
	 * @return Returns the relationship.
	 */
	public String getRelationship(){
		return _Relationship;
	}

	/**
	 * Sets the value for relationship.
	 * @param v Value to Set.
	 */
	public void setRelationship(String v){
		_Relationship=v;
	}
	 private org.nrg.xdat.bean.FhirHumannameBean _Name =null;

	/**
	 * name
	 * @return org.nrg.xdat.bean.FhirHumannameBean
	 */
	public org.nrg.xdat.bean.FhirHumannameBean getName() {
		return _Name;
	}

	/**
	 * Sets the value for name.
	 * @param v Value to Set.
	 */
	public void setName(org.nrg.xdat.bean.FhirHumannameBean v){
		_Name =v;
	}

	/**
	 * Sets the value for name.
	 * @param v Value to Set.
	 */
	public void setName(Object v) {
		if (v instanceof org.nrg.xdat.bean.FhirHumannameBean)
			_Name =(org.nrg.xdat.bean.FhirHumannameBean)v;
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirHumannameBean");
	}

	/**
	 * name
	 * @return org.nrg.xdat.model.FhirHumannameI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameI> void setName(A item) throws Exception{
	setName((org.nrg.xdat.bean.FhirHumannameBean)item);
	}

	//FIELD

	private Integer _NameFK=null;

	/**
	 * @return Returns the fhir:patient_contact/name_fhir_humanname_id.
	 */
	public Integer getNameFK(){
		return _NameFK;
	}

	/**
	 * Sets the value for fhir:patient_contact/name_fhir_humanname_id.
	 * @param v Value to Set.
	 */
	public void setNameFK(Integer v) {
		_NameFK=v;
	}
	 private List<org.nrg.xdat.bean.FhirContactpointBean> _Telecom =new ArrayList<org.nrg.xdat.bean.FhirContactpointBean>();

	/**
	 * telecom
	 * @return Returns an List of org.nrg.xdat.bean.FhirContactpointBean
	 */
	public <A extends org.nrg.xdat.model.FhirContactpointI> List<A> getTelecom() {
		return (List<A>) _Telecom;
	}

	/**
	 * Sets the value for telecom.
	 * @param v Value to Set.
	 */
	public void setTelecom(ArrayList<org.nrg.xdat.bean.FhirContactpointBean> v){
		_Telecom=v;
	}

	/**
	 * Adds the value for telecom.
	 * @param v Value to Set.
	 */
	public void addTelecom(org.nrg.xdat.bean.FhirContactpointBean v){
		_Telecom.add(v);
	}

	/**
	 * telecom
	 * Adds org.nrg.xdat.model.FhirContactpointI
	 */
	public <A extends org.nrg.xdat.model.FhirContactpointI> void addTelecom(A item) throws Exception{
	_Telecom.add((org.nrg.xdat.bean.FhirContactpointBean)item);
	}

	/**
	 * Adds the value for telecom.
	 * @param v Value to Set.
	 */
	public void addTelecom(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirContactpointBean)
			_Telecom.add((org.nrg.xdat.bean.FhirContactpointBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirContactpointBean");
	}
	 private org.nrg.xdat.bean.FhirAddressBean _Address =null;

	/**
	 * address
	 * @return org.nrg.xdat.bean.FhirAddressBean
	 */
	public org.nrg.xdat.bean.FhirAddressBean getAddress() {
		return _Address;
	}

	/**
	 * Sets the value for address.
	 * @param v Value to Set.
	 */
	public void setAddress(org.nrg.xdat.bean.FhirAddressBean v){
		_Address =v;
	}

	/**
	 * Sets the value for address.
	 * @param v Value to Set.
	 */
	public void setAddress(Object v) {
		if (v instanceof org.nrg.xdat.bean.FhirAddressBean)
			_Address =(org.nrg.xdat.bean.FhirAddressBean)v;
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirAddressBean");
	}

	/**
	 * address
	 * @return org.nrg.xdat.model.FhirAddressI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressI> void setAddress(A item) throws Exception{
	setAddress((org.nrg.xdat.bean.FhirAddressBean)item);
	}

	//FIELD

	private Integer _AddressFK=null;

	/**
	 * @return Returns the fhir:patient_contact/address_fhir_address_id.
	 */
	public Integer getAddressFK(){
		return _AddressFK;
	}

	/**
	 * Sets the value for fhir:patient_contact/address_fhir_address_id.
	 * @param v Value to Set.
	 */
	public void setAddressFK(Integer v) {
		_AddressFK=v;
	}

	//FIELD

	private String _Gender=null;

	/**
	 * @return Returns the gender.
	 */
	public String getGender(){
		return _Gender;
	}

	/**
	 * Sets the value for gender.
	 * @param v Value to Set.
	 */
	public void setGender(String v){
		_Gender=v;
	}

	//FIELD

	private Integer _OrganizationId=null;

	/**
	 * @return Returns the organization_ID.
	 */
	public Integer getOrganizationId(){
		return _OrganizationId;
	}

	/**
	 * Sets the value for fhir:patient_contact/organization_ID.
	 * @param v Value to Set.
	 */
	public void setOrganizationId(Integer v) {
		_OrganizationId=v;
	}

	/**
	 * Sets the value for fhir:patient_contact/organization_ID.
	 * @param v Value to Set.
	 */
	public void setOrganizationId(String v)  {
		_OrganizationId=formatInteger(v);
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

	private Integer _FhirPatientContactId=null;

	/**
	 * @return Returns the fhir_patient_contact_id.
	 */
	public Integer getFhirPatientContactId() {
		return _FhirPatientContactId;
	}

	/**
	 * Sets the value for fhir_patient_contact_id.
	 * @param v Value to Set.
	 */
	public void setFhirPatientContactId(Integer v){
		_FhirPatientContactId=v;
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setDataField(String xmlPath,String v) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("relationship")){
			setRelationship(v);
		}else if (xmlPath.equals("gender")){
			setGender(v);
		}else if (xmlPath.equals("organization_ID")){
			setOrganizationId(v);
		}else if (xmlPath.equals("period/start")){
			setPeriod_start(v);
		}else if (xmlPath.equals("period/end")){
			setPeriod_end(v);
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
		if (xmlPath.equals("name")){
			setName(v);
		}else if (xmlPath.equals("telecom")){
			addTelecom(v);
		}else if (xmlPath.equals("address")){
			setAddress(v);
		}
		else{
			super.setReferenceField(xmlPath,v);
		}
	}

	/**
	 * Gets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public Object getDataFieldValue(String xmlPath) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("relationship")){
			return getRelationship();
		}else if (xmlPath.equals("gender")){
			return getGender();
		}else if (xmlPath.equals("organization_ID")){
			return getOrganizationId();
		}else if (xmlPath.equals("period/start")){
			return getPeriod_start();
		}else if (xmlPath.equals("period/end")){
			return getPeriod_end();
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
		if (xmlPath.equals("name")){
			return getName();
		}else if (xmlPath.equals("telecom")){
			return getTelecom();
		}else if (xmlPath.equals("address")){
			return getAddress();
		}
		else{
			return super.getReferenceField(xmlPath);
		}
	}

	/**
	 * Gets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public String getReferenceFieldName(String xmlPath) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("name")){
			return "http://cbmi.htw-berlin.de/fhir:humanName";
		}else if (xmlPath.equals("telecom")){
			return "http://cbmi.htw-berlin.de/fhir:contactPoint";
		}else if (xmlPath.equals("address")){
			return "http://cbmi.htw-berlin.de/fhir:address";
		}
		else{
			return super.getReferenceFieldName(xmlPath);
		}
	}

	/**
	 * Returns whether or not this is a reference field
	 */
	public String getFieldType(String xmlPath) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("relationship")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("name")){
			return BaseElement.field_single_reference;
		}else if (xmlPath.equals("telecom")){
			return BaseElement.field_multi_reference;
		}else if (xmlPath.equals("address")){
			return BaseElement.field_single_reference;
		}else if (xmlPath.equals("gender")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("organization_ID")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("period/start")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("period/end")){
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
		all_fields.add("relationship");
		all_fields.add("name");
		all_fields.add("telecom");
		all_fields.add("address");
		all_fields.add("gender");
		all_fields.add("organization_ID");
		all_fields.add("period/start");
		all_fields.add("period/end");
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
		writer.write("\n<fhir:patient_contact");
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
		writer.write("\n</fhir:patient_contact>");
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
		if (_Relationship!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:relationship");
			writer.write(">");
			writer.write(ValueParser(_Relationship,"string"));
			writer.write("</fhir:relationship>");
			header--;
		}
		else{
			writer.write("\n" + createHeader(header++) + "<fhir:relationship");
			writer.write("/>");
			header--;
		}

		//REFERENCE FROM patient_contact -> name
		//DATA-FIELD FROM patient_contact -> name
		if (_Name!=null){
		//NEW ELEMENT
			writer.write("\n" + createHeader(header++) + "<fhir:name");
			_Name.addXMLAtts(writer);
			if(!_Name.getFullSchemaElementName().equals("fhir:humanName")){
				writer.write(" xsi:type=\"" + _Name.getFullSchemaElementName() + "\"");
			}
			if (_Name.hasXMLBodyContent()){
				writer.write(">");
				boolean return0 =_Name.addXMLBody(writer,header);
				if(return0){
					writer.write("\n" + createHeader(--header) + "</fhir:name>");
				}else{
					writer.write("</fhir:name>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
		//NOT REQUIRED

		//REFERENCE FROM patient_contact -> telecom
		java.util.Iterator iter0=_Telecom.iterator();
		while(iter0.hasNext()){
			org.nrg.xdat.bean.FhirContactpointBean child = (org.nrg.xdat.bean.FhirContactpointBean)iter0.next();
			writer.write("\n" + createHeader(header++) + "<fhir:telecom");
			child.addXMLAtts(writer);
			if(!child.getFullSchemaElementName().equals("fhir:contactPoint")){
				writer.write(" xsi:type=\"" + child.getFullSchemaElementName() + "\"");
			}
			if (child.hasXMLBodyContent()){
				writer.write(">");
				boolean return1 =child.addXMLBody(writer,header);
				if(return1){
					writer.write("\n" + createHeader(--header) + "</fhir:telecom>");
				}else{
					writer.write("</fhir:telecom>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
		//REFERENCE FROM patient_contact -> address
		//DATA-FIELD FROM patient_contact -> address
		if (_Address!=null){
		//NEW ELEMENT
			writer.write("\n" + createHeader(header++) + "<fhir:address");
			_Address.addXMLAtts(writer);
			if(!_Address.getFullSchemaElementName().equals("fhir:address")){
				writer.write(" xsi:type=\"" + _Address.getFullSchemaElementName() + "\"");
			}
			if (_Address.hasXMLBodyContent()){
				writer.write(">");
				boolean return1 =_Address.addXMLBody(writer,header);
				if(return1){
					writer.write("\n" + createHeader(--header) + "</fhir:address>");
				}else{
					writer.write("</fhir:address>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
		//NOT REQUIRED

		if (_Gender!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:gender");
			writer.write(">");
			writer.write(ValueParser(_Gender,"string"));
			writer.write("</fhir:gender>");
			header--;
		}
		else{
			writer.write("\n" + createHeader(header++) + "<fhir:gender");
			writer.write("/>");
			header--;
		}

		if (_OrganizationId!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:organization_ID");
			writer.write(">");
			writer.write(ValueParser(_OrganizationId,"integer"));
			writer.write("</fhir:organization_ID>");
			header--;
		}
			int child1=0;
			int att1=0;
			if(_Period_end!=null)
			child1++;
			if(_Period_start!=null)
			child1++;
			if(child1>0 || att1>0){
				writer.write("\n" + createHeader(header++) + "<fhir:period");
			if(child1==0){
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

	return true;
	}


	protected boolean hasXMLBodyContent(){
		if (_Relationship!=null) return true;
		return true;//REQUIRED relationship
	}
}
