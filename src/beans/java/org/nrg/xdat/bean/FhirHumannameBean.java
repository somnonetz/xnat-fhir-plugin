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
public class FhirHumannameBean extends BaseElement implements java.io.Serializable, org.nrg.xdat.model.FhirHumannameI {
	public static final Logger logger = Logger.getLogger(FhirHumannameBean.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:humanName";

	public String getSchemaElementName(){
		return "humanName";
	}

	public String getFullSchemaElementName(){
		return "fhir:humanName";
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

	//FIELD

	private String _Family=null;

	/**
	 * @return Returns the family.
	 */
	public String getFamily(){
		return _Family;
	}

	/**
	 * Sets the value for family.
	 * @param v Value to Set.
	 */
	public void setFamily(String v){
		_Family=v;
	}
	 private List<org.nrg.xdat.bean.FhirHumannameGivenBean> _Given =new ArrayList<org.nrg.xdat.bean.FhirHumannameGivenBean>();

	/**
	 * given
	 * @return Returns an List of org.nrg.xdat.bean.FhirHumannameGivenBean
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameGivenI> List<A> getGiven() {
		return (List<A>) _Given;
	}

	/**
	 * Sets the value for given.
	 * @param v Value to Set.
	 */
	public void setGiven(ArrayList<org.nrg.xdat.bean.FhirHumannameGivenBean> v){
		_Given=v;
	}

	/**
	 * Adds the value for given.
	 * @param v Value to Set.
	 */
	public void addGiven(org.nrg.xdat.bean.FhirHumannameGivenBean v){
		_Given.add(v);
	}

	/**
	 * given
	 * Adds org.nrg.xdat.model.FhirHumannameGivenI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameGivenI> void addGiven(A item) throws Exception{
	_Given.add((org.nrg.xdat.bean.FhirHumannameGivenBean)item);
	}

	/**
	 * Adds the value for given.
	 * @param v Value to Set.
	 */
	public void addGiven(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirHumannameGivenBean)
			_Given.add((org.nrg.xdat.bean.FhirHumannameGivenBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirHumannameGivenBean");
	}
	 private List<org.nrg.xdat.bean.FhirHumannamePrefixBean> _Prefix =new ArrayList<org.nrg.xdat.bean.FhirHumannamePrefixBean>();

	/**
	 * prefix
	 * @return Returns an List of org.nrg.xdat.bean.FhirHumannamePrefixBean
	 */
	public <A extends org.nrg.xdat.model.FhirHumannamePrefixI> List<A> getPrefix() {
		return (List<A>) _Prefix;
	}

	/**
	 * Sets the value for prefix.
	 * @param v Value to Set.
	 */
	public void setPrefix(ArrayList<org.nrg.xdat.bean.FhirHumannamePrefixBean> v){
		_Prefix=v;
	}

	/**
	 * Adds the value for prefix.
	 * @param v Value to Set.
	 */
	public void addPrefix(org.nrg.xdat.bean.FhirHumannamePrefixBean v){
		_Prefix.add(v);
	}

	/**
	 * prefix
	 * Adds org.nrg.xdat.model.FhirHumannamePrefixI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannamePrefixI> void addPrefix(A item) throws Exception{
	_Prefix.add((org.nrg.xdat.bean.FhirHumannamePrefixBean)item);
	}

	/**
	 * Adds the value for prefix.
	 * @param v Value to Set.
	 */
	public void addPrefix(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirHumannamePrefixBean)
			_Prefix.add((org.nrg.xdat.bean.FhirHumannamePrefixBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirHumannamePrefixBean");
	}
	 private List<org.nrg.xdat.bean.FhirHumannameSuffixBean> _Suffix =new ArrayList<org.nrg.xdat.bean.FhirHumannameSuffixBean>();

	/**
	 * suffix
	 * @return Returns an List of org.nrg.xdat.bean.FhirHumannameSuffixBean
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameSuffixI> List<A> getSuffix() {
		return (List<A>) _Suffix;
	}

	/**
	 * Sets the value for suffix.
	 * @param v Value to Set.
	 */
	public void setSuffix(ArrayList<org.nrg.xdat.bean.FhirHumannameSuffixBean> v){
		_Suffix=v;
	}

	/**
	 * Adds the value for suffix.
	 * @param v Value to Set.
	 */
	public void addSuffix(org.nrg.xdat.bean.FhirHumannameSuffixBean v){
		_Suffix.add(v);
	}

	/**
	 * suffix
	 * Adds org.nrg.xdat.model.FhirHumannameSuffixI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameSuffixI> void addSuffix(A item) throws Exception{
	_Suffix.add((org.nrg.xdat.bean.FhirHumannameSuffixBean)item);
	}

	/**
	 * Adds the value for suffix.
	 * @param v Value to Set.
	 */
	public void addSuffix(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirHumannameSuffixBean)
			_Suffix.add((org.nrg.xdat.bean.FhirHumannameSuffixBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirHumannameSuffixBean");
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

	private Integer _FhirHumannameId=null;

	/**
	 * @return Returns the fhir_humanName_id.
	 */
	public Integer getFhirHumannameId() {
		return _FhirHumannameId;
	}

	/**
	 * Sets the value for fhir_humanName_id.
	 * @param v Value to Set.
	 */
	public void setFhirHumannameId(Integer v){
		_FhirHumannameId=v;
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setDataField(String xmlPath,String v) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("use")){
			setUse(v);
		}else if (xmlPath.equals("text")){
			setText(v);
		}else if (xmlPath.equals("family")){
			setFamily(v);
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
		if (xmlPath.equals("given")){
			addGiven(v);
		}else if (xmlPath.equals("prefix")){
			addPrefix(v);
		}else if (xmlPath.equals("suffix")){
			addSuffix(v);
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
		}else if (xmlPath.equals("text")){
			return getText();
		}else if (xmlPath.equals("family")){
			return getFamily();
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
		if (xmlPath.equals("given")){
			return getGiven();
		}else if (xmlPath.equals("prefix")){
			return getPrefix();
		}else if (xmlPath.equals("suffix")){
			return getSuffix();
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
		if (xmlPath.equals("given")){
			return "http://cbmi.htw-berlin.de/fhir:humanName_given";
		}else if (xmlPath.equals("prefix")){
			return "http://cbmi.htw-berlin.de/fhir:humanName_prefix";
		}else if (xmlPath.equals("suffix")){
			return "http://cbmi.htw-berlin.de/fhir:humanName_suffix";
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
		}else if (xmlPath.equals("text")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("family")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("given")){
			return BaseElement.field_inline_repeater;
		}else if (xmlPath.equals("prefix")){
			return BaseElement.field_inline_repeater;
		}else if (xmlPath.equals("suffix")){
			return BaseElement.field_inline_repeater;
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
		all_fields.add("use");
		all_fields.add("text");
		all_fields.add("family");
		all_fields.add("given");
		all_fields.add("prefix");
		all_fields.add("suffix");
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
		writer.write("\n<fhir:FHIRHumanName");
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
		writer.write("\n</fhir:FHIRHumanName>");
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

		if (_Text!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:text");
			writer.write(">");
			writer.write(ValueParser(_Text,"string"));
			writer.write("</fhir:text>");
			header--;
		}
		if (_Family!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:family");
			writer.write(">");
			writer.write(ValueParser(_Family,"string"));
			writer.write("</fhir:family>");
			header--;
		}
		//REFERENCE FROM humanName -> given
		//IN-LINE REPEATER
		java.util.Iterator iter0=_Given.iterator();
		while(iter0.hasNext()){
			org.nrg.xdat.bean.FhirHumannameGivenBean child = (org.nrg.xdat.bean.FhirHumannameGivenBean)iter0.next();
			child.addXMLBody(writer,header);
		}
		//REFERENCE FROM humanName -> prefix
		//IN-LINE REPEATER
		java.util.Iterator iter1=_Prefix.iterator();
		while(iter1.hasNext()){
			org.nrg.xdat.bean.FhirHumannamePrefixBean child = (org.nrg.xdat.bean.FhirHumannamePrefixBean)iter1.next();
			child.addXMLBody(writer,header);
		}
		//REFERENCE FROM humanName -> suffix
		//IN-LINE REPEATER
		java.util.Iterator iter2=_Suffix.iterator();
		while(iter2.hasNext()){
			org.nrg.xdat.bean.FhirHumannameSuffixBean child = (org.nrg.xdat.bean.FhirHumannameSuffixBean)iter2.next();
			child.addXMLBody(writer,header);
		}
			int child3=0;
			int att3=0;
			if(_Period_end!=null)
			child3++;
			if(_Period_start!=null)
			child3++;
			if(child3>0 || att3>0){
				writer.write("\n" + createHeader(header++) + "<fhir:period");
			if(child3==0){
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
		if (_Use!=null) return true;
		return true;//REQUIRED use
	}
}
