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
public class FhirAddressBean extends BaseElement implements java.io.Serializable, org.nrg.xdat.model.FhirAddressI {
	public static final Logger logger = Logger.getLogger(FhirAddressBean.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:address";

	public String getSchemaElementName(){
		return "address";
	}

	public String getFullSchemaElementName(){
		return "fhir:address";
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

	private String _Text=null;

	/**
	 * @return Returns the text.
	 */
	public String getText(){
		return _Text;
	}

	/**
	 * Sets the value for text.
	 * @param v Value to Set.
	 */
	public void setText(String v){
		_Text=v;
	}
	 private List<org.nrg.xdat.bean.FhirAddressLineBean> _Line =new ArrayList<org.nrg.xdat.bean.FhirAddressLineBean>();

	/**
	 * line
	 * @return Returns an List of org.nrg.xdat.bean.FhirAddressLineBean
	 */
	public <A extends org.nrg.xdat.model.FhirAddressLineI> List<A> getLine() {
		return (List<A>) _Line;
	}

	/**
	 * Sets the value for line.
	 * @param v Value to Set.
	 */
	public void setLine(ArrayList<org.nrg.xdat.bean.FhirAddressLineBean> v){
		_Line=v;
	}

	/**
	 * Adds the value for line.
	 * @param v Value to Set.
	 */
	public void addLine(org.nrg.xdat.bean.FhirAddressLineBean v){
		_Line.add(v);
	}

	/**
	 * line
	 * Adds org.nrg.xdat.model.FhirAddressLineI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressLineI> void addLine(A item) throws Exception{
	_Line.add((org.nrg.xdat.bean.FhirAddressLineBean)item);
	}

	/**
	 * Adds the value for line.
	 * @param v Value to Set.
	 */
	public void addLine(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirAddressLineBean)
			_Line.add((org.nrg.xdat.bean.FhirAddressLineBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirAddressLineBean");
	}

	//FIELD

	private String _City=null;

	/**
	 * @return Returns the city.
	 */
	public String getCity(){
		return _City;
	}

	/**
	 * Sets the value for city.
	 * @param v Value to Set.
	 */
	public void setCity(String v){
		_City=v;
	}

	//FIELD

	private String _District=null;

	/**
	 * @return Returns the district.
	 */
	public String getDistrict(){
		return _District;
	}

	/**
	 * Sets the value for district.
	 * @param v Value to Set.
	 */
	public void setDistrict(String v){
		_District=v;
	}

	//FIELD

	private String _State=null;

	/**
	 * @return Returns the state.
	 */
	public String getState(){
		return _State;
	}

	/**
	 * Sets the value for state.
	 * @param v Value to Set.
	 */
	public void setState(String v){
		_State=v;
	}

	//FIELD

	private String _Postalcode=null;

	/**
	 * @return Returns the postalCode.
	 */
	public String getPostalcode(){
		return _Postalcode;
	}

	/**
	 * Sets the value for postalCode.
	 * @param v Value to Set.
	 */
	public void setPostalcode(String v){
		_Postalcode=v;
	}

	//FIELD

	private String _Country=null;

	/**
	 * @return Returns the country.
	 */
	public String getCountry(){
		return _Country;
	}

	/**
	 * Sets the value for country.
	 * @param v Value to Set.
	 */
	public void setCountry(String v){
		_Country=v;
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
	 * Sets the value for fhir:address/assigner_ID.
	 * @param v Value to Set.
	 */
	public void setAssignerId(Integer v) {
		_AssignerId=v;
	}

	/**
	 * Sets the value for fhir:address/assigner_ID.
	 * @param v Value to Set.
	 */
	public void setAssignerId(String v)  {
		_AssignerId=formatInteger(v);
	}

	//FIELD

	private Integer _FhirAddressId=null;

	/**
	 * @return Returns the fhir_address_id.
	 */
	public Integer getFhirAddressId() {
		return _FhirAddressId;
	}

	/**
	 * Sets the value for fhir_address_id.
	 * @param v Value to Set.
	 */
	public void setFhirAddressId(Integer v){
		_FhirAddressId=v;
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
		}else if (xmlPath.equals("text")){
			setText(v);
		}else if (xmlPath.equals("city")){
			setCity(v);
		}else if (xmlPath.equals("district")){
			setDistrict(v);
		}else if (xmlPath.equals("state")){
			setState(v);
		}else if (xmlPath.equals("postalCode")){
			setPostalcode(v);
		}else if (xmlPath.equals("country")){
			setCountry(v);
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
		if (xmlPath.equals("line")){
			addLine(v);
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
		if (xmlPath.equals("use")){
			return getUse();
		}else if (xmlPath.equals("type")){
			return getType();
		}else if (xmlPath.equals("text")){
			return getText();
		}else if (xmlPath.equals("city")){
			return getCity();
		}else if (xmlPath.equals("district")){
			return getDistrict();
		}else if (xmlPath.equals("state")){
			return getState();
		}else if (xmlPath.equals("postalCode")){
			return getPostalcode();
		}else if (xmlPath.equals("country")){
			return getCountry();
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
		if (xmlPath.equals("line")){
			return getLine();
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
		if (xmlPath.equals("line")){
			return "http://cbmi.htw-berlin.de/fhir:address_line";
		}
		else{
			return super.getReferenceFieldName(xmlPath);
		}
	}

	/**
	 * Returns whether or not this is a reference field
	 */
	public String getFieldType(String xmlPath) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("use")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("type")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("text")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("line")){
			return BaseElement.field_inline_repeater;
		}else if (xmlPath.equals("city")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("district")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("state")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("postalCode")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("country")){
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
		all_fields.add("text");
		all_fields.add("line");
		all_fields.add("city");
		all_fields.add("district");
		all_fields.add("state");
		all_fields.add("postalCode");
		all_fields.add("country");
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
		writer.write("\n<fhir:FHIRPatient");
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
		writer.write("\n</fhir:FHIRPatient>");
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

		if (_Text!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:text");
			writer.write(">");
			writer.write(ValueParser(_Text,"string"));
			writer.write("</fhir:text>");
			header--;
		}
		//REFERENCE FROM address -> line
		//IN-LINE REPEATER
		java.util.Iterator iter0=_Line.iterator();
		while(iter0.hasNext()){
			org.nrg.xdat.bean.FhirAddressLineBean child = (org.nrg.xdat.bean.FhirAddressLineBean)iter0.next();
			child.addXMLBody(writer,header);
		}
		if (_City!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:city");
			writer.write(">");
			writer.write(ValueParser(_City,"string"));
			writer.write("</fhir:city>");
			header--;
		}
		if (_District!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:district");
			writer.write(">");
			writer.write(ValueParser(_District,"string"));
			writer.write("</fhir:district>");
			header--;
		}
		if (_State!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:state");
			writer.write(">");
			writer.write(ValueParser(_State,"string"));
			writer.write("</fhir:state>");
			header--;
		}
		if (_Postalcode!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:postalCode");
			writer.write(">");
			writer.write(ValueParser(_Postalcode,"string"));
			writer.write("</fhir:postalCode>");
			header--;
		}
		if (_Country!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:country");
			writer.write(">");
			writer.write(ValueParser(_Country,"string"));
			writer.write("</fhir:country>");
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
