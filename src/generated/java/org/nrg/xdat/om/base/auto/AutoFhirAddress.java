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
public abstract class AutoFhirAddress extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirAddressI {
	public static final Logger logger = Logger.getLogger(AutoFhirAddress.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:address";

	public AutoFhirAddress(ItemI item)
	{
		super(item);
	}

	public AutoFhirAddress(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirAddress(UserI user)
	 **/
	public AutoFhirAddress(){}

	public AutoFhirAddress(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:address";
	}

	//FIELD

	private String _Use=null;

	/**
	 * @return Returns the use.
	 */
	public String getUse(){
		try{
			if (_Use==null){
				_Use=getStringProperty("use");
				return _Use;
			}else {
				return _Use;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for use.
	 * @param v Value to Set.
	 */
	public void setUse(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/use",v);
		_Use=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Type=null;

	/**
	 * @return Returns the type.
	 */
	public String getType(){
		try{
			if (_Type==null){
				_Type=getStringProperty("type");
				return _Type;
			}else {
				return _Type;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for type.
	 * @param v Value to Set.
	 */
	public void setType(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/type",v);
		_Type=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Text=null;

	/**
	 * @return Returns the text.
	 */
	public String getText(){
		try{
			if (_Text==null){
				_Text=getStringProperty("text");
				return _Text;
			}else {
				return _Text;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for text.
	 * @param v Value to Set.
	 */
	public void setText(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/text",v);
		_Text=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirAddressLine> _Line =null;

	/**
	 * line
	 * @return Returns an List of org.nrg.xdat.om.FhirAddressLine
	 */
	public <A extends org.nrg.xdat.model.FhirAddressLineI> List<A> getLine() {
		try{
			if (_Line==null){
				_Line=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("line"));
			}
			return (List<A>) _Line;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirAddressLine>();}
	}

	/**
	 * Sets the value for line.
	 * @param v Value to Set.
	 */
	public void setLine(ItemI v) throws Exception{
		_Line =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/line",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/line",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * line
	 * Adds org.nrg.xdat.model.FhirAddressLineI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressLineI> void addLine(A item) throws Exception{
	setLine((ItemI)item);
	}

	/**
	 * Removes the line of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeLine(int index) throws java.lang.IndexOutOfBoundsException {
		_Line =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/line",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}

	//FIELD

	private String _City=null;

	/**
	 * @return Returns the city.
	 */
	public String getCity(){
		try{
			if (_City==null){
				_City=getStringProperty("city");
				return _City;
			}else {
				return _City;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for city.
	 * @param v Value to Set.
	 */
	public void setCity(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/city",v);
		_City=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _District=null;

	/**
	 * @return Returns the district.
	 */
	public String getDistrict(){
		try{
			if (_District==null){
				_District=getStringProperty("district");
				return _District;
			}else {
				return _District;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for district.
	 * @param v Value to Set.
	 */
	public void setDistrict(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/district",v);
		_District=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _State=null;

	/**
	 * @return Returns the state.
	 */
	public String getState(){
		try{
			if (_State==null){
				_State=getStringProperty("state");
				return _State;
			}else {
				return _State;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for state.
	 * @param v Value to Set.
	 */
	public void setState(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/state",v);
		_State=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Postalcode=null;

	/**
	 * @return Returns the postalCode.
	 */
	public String getPostalcode(){
		try{
			if (_Postalcode==null){
				_Postalcode=getStringProperty("postalCode");
				return _Postalcode;
			}else {
				return _Postalcode;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for postalCode.
	 * @param v Value to Set.
	 */
	public void setPostalcode(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/postalCode",v);
		_Postalcode=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Country=null;

	/**
	 * @return Returns the country.
	 */
	public String getCountry(){
		try{
			if (_Country==null){
				_Country=getStringProperty("country");
				return _Country;
			}else {
				return _Country;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for country.
	 * @param v Value to Set.
	 */
	public void setCountry(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/country",v);
		_Country=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Period_start=null;

	/**
	 * @return Returns the period/start.
	 */
	public Object getPeriod_start(){
		try{
			if (_Period_start==null){
				_Period_start=getProperty("period/start");
				return _Period_start;
			}else {
				return _Period_start;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for period/start.
	 * @param v Value to Set.
	 */
	public void setPeriod_start(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/period/start",v);
		_Period_start=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Period_end=null;

	/**
	 * @return Returns the period/end.
	 */
	public Object getPeriod_end(){
		try{
			if (_Period_end==null){
				_Period_end=getProperty("period/end");
				return _Period_end;
			}else {
				return _Period_end;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for period/end.
	 * @param v Value to Set.
	 */
	public void setPeriod_end(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/period/end",v);
		_Period_end=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _AssignerId=null;

	/**
	 * @return Returns the assigner_ID.
	 */
	public Integer getAssignerId() {
		try{
			if (_AssignerId==null){
				_AssignerId=getIntegerProperty("assigner_ID");
				return _AssignerId;
			}else {
				return _AssignerId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for assigner_ID.
	 * @param v Value to Set.
	 */
	public void setAssignerId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/assigner_ID",v);
		_AssignerId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirAddressId=null;

	/**
	 * @return Returns the fhir_address_id.
	 */
	public Integer getFhirAddressId() {
		try{
			if (_FhirAddressId==null){
				_FhirAddressId=getIntegerProperty("fhir_address_id");
				return _FhirAddressId;
			}else {
				return _FhirAddressId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_address_id.
	 * @param v Value to Set.
	 */
	public void setFhirAddressId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_address_id",v);
		_FhirAddressId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirAddress> getAllFhirAddresss(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirAddress> al = new ArrayList<org.nrg.xdat.om.FhirAddress>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirAddress> getFhirAddresssByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirAddress> al = new ArrayList<org.nrg.xdat.om.FhirAddress>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirAddress> getFhirAddresssByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirAddress> al = new ArrayList<org.nrg.xdat.om.FhirAddress>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirAddress getFhirAddresssByFhirAddressId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:address/fhir_address_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirAddress) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
	
	        //line
	        for(org.nrg.xdat.model.FhirAddressLineI childLine : this.getLine()){
	            if (childLine!=null){
	              for(ResourceFile rf: ((FhirAddressLine)childLine).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("line[" + ((FhirAddressLine)childLine).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("line/" + ((FhirAddressLine)childLine).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	return _return;
}
}
