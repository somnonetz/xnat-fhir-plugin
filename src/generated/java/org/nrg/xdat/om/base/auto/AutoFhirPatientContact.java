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
public abstract class AutoFhirPatientContact extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirPatientContactI {
	public static final Logger logger = Logger.getLogger(AutoFhirPatientContact.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:patient_contact";

	public AutoFhirPatientContact(ItemI item)
	{
		super(item);
	}

	public AutoFhirPatientContact(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirPatientContact(UserI user)
	 **/
	public AutoFhirPatientContact(){}

	public AutoFhirPatientContact(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:patient_contact";
	}

	//FIELD

	private String _Relationship=null;

	/**
	 * @return Returns the relationship.
	 */
	public String getRelationship(){
		try{
			if (_Relationship==null){
				_Relationship=getStringProperty("relationship");
				return _Relationship;
			}else {
				return _Relationship;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for relationship.
	 * @param v Value to Set.
	 */
	public void setRelationship(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/relationship",v);
		_Relationship=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private org.nrg.xdat.om.FhirHumanname _Name =null;

	/**
	 * name
	 * @return org.nrg.xdat.om.FhirHumanname
	 */
	public org.nrg.xdat.om.FhirHumanname getName() {
		try{
			if (_Name==null){
				_Name=((FhirHumanname)org.nrg.xdat.base.BaseElement.GetGeneratedItem((XFTItem)getProperty("name")));
				return _Name;
			}else {
				return _Name;
			}
		} catch (Exception e1) {return null;}
	}

	/**
	 * Sets the value for name.
	 * @param v Value to Set.
	 */
	public void setName(ItemI v) throws Exception{
		_Name =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/name",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/name",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * name
	 * set org.nrg.xdat.model.FhirHumannameI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameI> void setName(A item) throws Exception{
	setName((ItemI)item);
	}

	/**
	 * Removes the name.
	 * */
	public void removeName() {
		_Name =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/name",0);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
		catch (java.lang.IndexOutOfBoundsException e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _NameFK=null;

	/**
	 * @return Returns the fhir:patient_contact/name_fhir_humanname_id.
	 */
	public Integer getNameFK(){
		try{
			if (_NameFK==null){
				_NameFK=getIntegerProperty("fhir:patient_contact/name_fhir_humanname_id");
				return _NameFK;
			}else {
				return _NameFK;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir:patient_contact/name_fhir_humanname_id.
	 * @param v Value to Set.
	 */
	public void setNameFK(Integer v) {
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/name_fhir_humanname_id",v);
		_NameFK=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirContactpoint> _Telecom =null;

	/**
	 * telecom
	 * @return Returns an List of org.nrg.xdat.om.FhirContactpoint
	 */
	public <A extends org.nrg.xdat.model.FhirContactpointI> List<A> getTelecom() {
		try{
			if (_Telecom==null){
				_Telecom=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("telecom"));
			}
			return (List<A>) _Telecom;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirContactpoint>();}
	}

	/**
	 * Sets the value for telecom.
	 * @param v Value to Set.
	 */
	public void setTelecom(ItemI v) throws Exception{
		_Telecom =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/telecom",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/telecom",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * telecom
	 * Adds org.nrg.xdat.model.FhirContactpointI
	 */
	public <A extends org.nrg.xdat.model.FhirContactpointI> void addTelecom(A item) throws Exception{
	setTelecom((ItemI)item);
	}

	/**
	 * Removes the telecom of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeTelecom(int index) throws java.lang.IndexOutOfBoundsException {
		_Telecom =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/telecom",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}
	 private org.nrg.xdat.om.FhirAddress _Address =null;

	/**
	 * address
	 * @return org.nrg.xdat.om.FhirAddress
	 */
	public org.nrg.xdat.om.FhirAddress getAddress() {
		try{
			if (_Address==null){
				_Address=((FhirAddress)org.nrg.xdat.base.BaseElement.GetGeneratedItem((XFTItem)getProperty("address")));
				return _Address;
			}else {
				return _Address;
			}
		} catch (Exception e1) {return null;}
	}

	/**
	 * Sets the value for address.
	 * @param v Value to Set.
	 */
	public void setAddress(ItemI v) throws Exception{
		_Address =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/address",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/address",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * address
	 * set org.nrg.xdat.model.FhirAddressI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressI> void setAddress(A item) throws Exception{
	setAddress((ItemI)item);
	}

	/**
	 * Removes the address.
	 * */
	public void removeAddress() {
		_Address =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/address",0);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
		catch (java.lang.IndexOutOfBoundsException e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _AddressFK=null;

	/**
	 * @return Returns the fhir:patient_contact/address_fhir_address_id.
	 */
	public Integer getAddressFK(){
		try{
			if (_AddressFK==null){
				_AddressFK=getIntegerProperty("fhir:patient_contact/address_fhir_address_id");
				return _AddressFK;
			}else {
				return _AddressFK;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir:patient_contact/address_fhir_address_id.
	 * @param v Value to Set.
	 */
	public void setAddressFK(Integer v) {
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/address_fhir_address_id",v);
		_AddressFK=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Gender=null;

	/**
	 * @return Returns the gender.
	 */
	public String getGender(){
		try{
			if (_Gender==null){
				_Gender=getStringProperty("gender");
				return _Gender;
			}else {
				return _Gender;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for gender.
	 * @param v Value to Set.
	 */
	public void setGender(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/gender",v);
		_Gender=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _OrganizationId=null;

	/**
	 * @return Returns the organization_ID.
	 */
	public Integer getOrganizationId() {
		try{
			if (_OrganizationId==null){
				_OrganizationId=getIntegerProperty("organization_ID");
				return _OrganizationId;
			}else {
				return _OrganizationId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for organization_ID.
	 * @param v Value to Set.
	 */
	public void setOrganizationId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/organization_ID",v);
		_OrganizationId=null;
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

	private Integer _FhirPatientContactId=null;

	/**
	 * @return Returns the fhir_patient_contact_id.
	 */
	public Integer getFhirPatientContactId() {
		try{
			if (_FhirPatientContactId==null){
				_FhirPatientContactId=getIntegerProperty("fhir_patient_contact_id");
				return _FhirPatientContactId;
			}else {
				return _FhirPatientContactId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_patient_contact_id.
	 * @param v Value to Set.
	 */
	public void setFhirPatientContactId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_patient_contact_id",v);
		_FhirPatientContactId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientContact> getAllFhirPatientContacts(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientContact> al = new ArrayList<org.nrg.xdat.om.FhirPatientContact>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientContact> getFhirPatientContactsByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientContact> al = new ArrayList<org.nrg.xdat.om.FhirPatientContact>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatientContact> getFhirPatientContactsByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatientContact> al = new ArrayList<org.nrg.xdat.om.FhirPatientContact>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirPatientContact getFhirPatientContactsByFhirPatientContactId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:patient_contact/fhir_patient_contact_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirPatientContact) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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
	
	        //name
	        FhirHumanname childName = (FhirHumanname)this.getName();
	            if (childName!=null){
	              for(ResourceFile rf: ((FhirHumanname)childName).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("name[" + ((FhirHumanname)childName).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("name/" + ((FhirHumanname)childName).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	
	        localLoop = preventLoop;
	
	        //telecom
	        for(org.nrg.xdat.model.FhirContactpointI childTelecom : this.getTelecom()){
	            if (childTelecom!=null){
	              for(ResourceFile rf: ((FhirContactpoint)childTelecom).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("telecom[" + ((FhirContactpoint)childTelecom).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("telecom/" + ((FhirContactpoint)childTelecom).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	        //address
	        FhirAddress childAddress = (FhirAddress)this.getAddress();
	            if (childAddress!=null){
	              for(ResourceFile rf: ((FhirAddress)childAddress).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("address[" + ((FhirAddress)childAddress).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("address/" + ((FhirAddress)childAddress).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	
	        localLoop = preventLoop;
	
	return _return;
}
}
