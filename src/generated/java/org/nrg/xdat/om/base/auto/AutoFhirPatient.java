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
public abstract class AutoFhirPatient extends XnatSubjectassessordata implements org.nrg.xdat.model.FhirPatientI {
	public static final Logger logger = Logger.getLogger(AutoFhirPatient.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:patient";

	public AutoFhirPatient(ItemI item)
	{
		super(item);
	}

	public AutoFhirPatient(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirPatient(UserI user)
	 **/
	public AutoFhirPatient(){}

	public AutoFhirPatient(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:patient";
	}
	 private org.nrg.xdat.om.XnatSubjectassessordata _Subjectassessordata =null;

	/**
	 * subjectAssessorData
	 * @return org.nrg.xdat.om.XnatSubjectassessordata
	 */
	public org.nrg.xdat.om.XnatSubjectassessordata getSubjectassessordata() {
		try{
			if (_Subjectassessordata==null){
				_Subjectassessordata=((XnatSubjectassessordata)org.nrg.xdat.base.BaseElement.GetGeneratedItem((XFTItem)getProperty("subjectAssessorData")));
				return _Subjectassessordata;
			}else {
				return _Subjectassessordata;
			}
		} catch (Exception e1) {return null;}
	}

	/**
	 * Sets the value for subjectAssessorData.
	 * @param v Value to Set.
	 */
	public void setSubjectassessordata(ItemI v) throws Exception{
		_Subjectassessordata =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/subjectAssessorData",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/subjectAssessorData",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * subjectAssessorData
	 * set org.nrg.xdat.model.XnatSubjectassessordataI
	 */
	public <A extends org.nrg.xdat.model.XnatSubjectassessordataI> void setSubjectassessordata(A item) throws Exception{
	setSubjectassessordata((ItemI)item);
	}

	/**
	 * Removes the subjectAssessorData.
	 * */
	public void removeSubjectassessordata() {
		_Subjectassessordata =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/subjectAssessorData",0);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
		catch (java.lang.IndexOutOfBoundsException e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirIdentifier> _Identifier =null;

	/**
	 * identifier
	 * @return Returns an List of org.nrg.xdat.om.FhirIdentifier
	 */
	public <A extends org.nrg.xdat.model.FhirIdentifierI> List<A> getIdentifier() {
		try{
			if (_Identifier==null){
				_Identifier=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("identifier"));
			}
			return (List<A>) _Identifier;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirIdentifier>();}
	}

	/**
	 * Sets the value for identifier.
	 * @param v Value to Set.
	 */
	public void setIdentifier(ItemI v) throws Exception{
		_Identifier =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/identifier",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/identifier",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * identifier
	 * Adds org.nrg.xdat.model.FhirIdentifierI
	 */
	public <A extends org.nrg.xdat.model.FhirIdentifierI> void addIdentifier(A item) throws Exception{
	setIdentifier((ItemI)item);
	}

	/**
	 * Removes the identifier of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeIdentifier(int index) throws java.lang.IndexOutOfBoundsException {
		_Identifier =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/identifier",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}

	//FIELD

	private Boolean _Active=null;

	/**
	 * @return Returns the active.
	 */
	public Boolean getActive() {
		try{
			if (_Active==null){
				_Active=getBooleanProperty("active");
				return _Active;
			}else {
				return _Active;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for active.
	 * @param v Value to Set.
	 */
	public void setActive(Object v){
		try{
		setBooleanProperty(SCHEMA_ELEMENT_NAME + "/active",v);
		_Active=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirHumanname> _Name =null;

	/**
	 * name
	 * @return Returns an List of org.nrg.xdat.om.FhirHumanname
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameI> List<A> getName() {
		try{
			if (_Name==null){
				_Name=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("name"));
			}
			return (List<A>) _Name;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirHumanname>();}
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
	 * Adds org.nrg.xdat.model.FhirHumannameI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameI> void addName(A item) throws Exception{
	setName((ItemI)item);
	}

	/**
	 * Removes the name of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeName(int index) throws java.lang.IndexOutOfBoundsException {
		_Name =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/name",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
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

	private Object _Birthdate=null;

	/**
	 * @return Returns the birthDate.
	 */
	public Object getBirthdate(){
		try{
			if (_Birthdate==null){
				_Birthdate=getProperty("birthDate");
				return _Birthdate;
			}else {
				return _Birthdate;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for birthDate.
	 * @param v Value to Set.
	 */
	public void setBirthdate(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/birthDate",v);
		_Birthdate=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Boolean _Deceased_deceasedboolean=null;

	/**
	 * @return Returns the deceased/deceasedBoolean.
	 */
	public Boolean getDeceased_deceasedboolean() {
		try{
			if (_Deceased_deceasedboolean==null){
				_Deceased_deceasedboolean=getBooleanProperty("deceased/deceasedBoolean");
				return _Deceased_deceasedboolean;
			}else {
				return _Deceased_deceasedboolean;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for deceased/deceasedBoolean.
	 * @param v Value to Set.
	 */
	public void setDeceased_deceasedboolean(Object v){
		try{
		setBooleanProperty(SCHEMA_ELEMENT_NAME + "/deceased/deceasedBoolean",v);
		_Deceased_deceasedboolean=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Deceased_deceaseddatetime=null;

	/**
	 * @return Returns the deceased/deceasedDateTime.
	 */
	public Object getDeceased_deceaseddatetime(){
		try{
			if (_Deceased_deceaseddatetime==null){
				_Deceased_deceaseddatetime=getProperty("deceased/deceasedDateTime");
				return _Deceased_deceaseddatetime;
			}else {
				return _Deceased_deceaseddatetime;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for deceased/deceasedDateTime.
	 * @param v Value to Set.
	 */
	public void setDeceased_deceaseddatetime(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/deceased/deceasedDateTime",v);
		_Deceased_deceaseddatetime=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirAddress> _Address =null;

	/**
	 * address
	 * @return Returns an List of org.nrg.xdat.om.FhirAddress
	 */
	public <A extends org.nrg.xdat.model.FhirAddressI> List<A> getAddress() {
		try{
			if (_Address==null){
				_Address=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("address"));
			}
			return (List<A>) _Address;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirAddress>();}
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
	 * Adds org.nrg.xdat.model.FhirAddressI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressI> void addAddress(A item) throws Exception{
	setAddress((ItemI)item);
	}

	/**
	 * Removes the address of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeAddress(int index) throws java.lang.IndexOutOfBoundsException {
		_Address =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/address",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}

	//FIELD

	private String _Maritalstatus=null;

	/**
	 * @return Returns the maritalStatus.
	 */
	public String getMaritalstatus(){
		try{
			if (_Maritalstatus==null){
				_Maritalstatus=getStringProperty("maritalStatus");
				return _Maritalstatus;
			}else {
				return _Maritalstatus;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for maritalStatus.
	 * @param v Value to Set.
	 */
	public void setMaritalstatus(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/maritalStatus",v);
		_Maritalstatus=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Boolean _Multiplebirth_multiplebirthboolean=null;

	/**
	 * @return Returns the multipleBirth/multipleBirthBoolean.
	 */
	public Boolean getMultiplebirth_multiplebirthboolean() {
		try{
			if (_Multiplebirth_multiplebirthboolean==null){
				_Multiplebirth_multiplebirthboolean=getBooleanProperty("multipleBirth/multipleBirthBoolean");
				return _Multiplebirth_multiplebirthboolean;
			}else {
				return _Multiplebirth_multiplebirthboolean;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for multipleBirth/multipleBirthBoolean.
	 * @param v Value to Set.
	 */
	public void setMultiplebirth_multiplebirthboolean(Object v){
		try{
		setBooleanProperty(SCHEMA_ELEMENT_NAME + "/multipleBirth/multipleBirthBoolean",v);
		_Multiplebirth_multiplebirthboolean=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _Multiplebirth_multiplebirthinteger=null;

	/**
	 * @return Returns the multipleBirth/multipleBirthInteger.
	 */
	public Integer getMultiplebirth_multiplebirthinteger() {
		try{
			if (_Multiplebirth_multiplebirthinteger==null){
				_Multiplebirth_multiplebirthinteger=getIntegerProperty("multipleBirth/multipleBirthInteger");
				return _Multiplebirth_multiplebirthinteger;
			}else {
				return _Multiplebirth_multiplebirthinteger;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for multipleBirth/multipleBirthInteger.
	 * @param v Value to Set.
	 */
	public void setMultiplebirth_multiplebirthinteger(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/multipleBirth/multipleBirthInteger",v);
		_Multiplebirth_multiplebirthinteger=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirAttachement> _Photo =null;

	/**
	 * photo
	 * @return Returns an List of org.nrg.xdat.om.FhirAttachement
	 */
	public <A extends org.nrg.xdat.model.FhirAttachementI> List<A> getPhoto() {
		try{
			if (_Photo==null){
				_Photo=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("photo"));
			}
			return (List<A>) _Photo;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirAttachement>();}
	}

	/**
	 * Sets the value for photo.
	 * @param v Value to Set.
	 */
	public void setPhoto(ItemI v) throws Exception{
		_Photo =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/photo",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/photo",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * photo
	 * Adds org.nrg.xdat.model.FhirAttachementI
	 */
	public <A extends org.nrg.xdat.model.FhirAttachementI> void addPhoto(A item) throws Exception{
	setPhoto((ItemI)item);
	}

	/**
	 * Removes the photo of the given index.
	 * @param index Index of child to remove.
	 */
	public void removePhoto(int index) throws java.lang.IndexOutOfBoundsException {
		_Photo =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/photo",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirPatientContact> _Contact =null;

	/**
	 * contact
	 * @return Returns an List of org.nrg.xdat.om.FhirPatientContact
	 */
	public <A extends org.nrg.xdat.model.FhirPatientContactI> List<A> getContact() {
		try{
			if (_Contact==null){
				_Contact=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("contact"));
			}
			return (List<A>) _Contact;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirPatientContact>();}
	}

	/**
	 * Sets the value for contact.
	 * @param v Value to Set.
	 */
	public void setContact(ItemI v) throws Exception{
		_Contact =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/contact",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/contact",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * contact
	 * Adds org.nrg.xdat.model.FhirPatientContactI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientContactI> void addContact(A item) throws Exception{
	setContact((ItemI)item);
	}

	/**
	 * Removes the contact of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeContact(int index) throws java.lang.IndexOutOfBoundsException {
		_Contact =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/contact",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}

	//FIELD

	private String _Animal_species=null;

	/**
	 * @return Returns the animal/species.
	 */
	public String getAnimal_species(){
		try{
			if (_Animal_species==null){
				_Animal_species=getStringProperty("animal/species");
				return _Animal_species;
			}else {
				return _Animal_species;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for animal/species.
	 * @param v Value to Set.
	 */
	public void setAnimal_species(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/animal/species",v);
		_Animal_species=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Animal_breed=null;

	/**
	 * @return Returns the animal/breed.
	 */
	public String getAnimal_breed(){
		try{
			if (_Animal_breed==null){
				_Animal_breed=getStringProperty("animal/breed");
				return _Animal_breed;
			}else {
				return _Animal_breed;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for animal/breed.
	 * @param v Value to Set.
	 */
	public void setAnimal_breed(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/animal/breed",v);
		_Animal_breed=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Animal_genderstatus=null;

	/**
	 * @return Returns the animal/genderStatus.
	 */
	public String getAnimal_genderstatus(){
		try{
			if (_Animal_genderstatus==null){
				_Animal_genderstatus=getStringProperty("animal/genderStatus");
				return _Animal_genderstatus;
			}else {
				return _Animal_genderstatus;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for animal/genderStatus.
	 * @param v Value to Set.
	 */
	public void setAnimal_genderstatus(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/animal/genderStatus",v);
		_Animal_genderstatus=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirPatientCommunication> _Communication =null;

	/**
	 * communication
	 * @return Returns an List of org.nrg.xdat.om.FhirPatientCommunication
	 */
	public <A extends org.nrg.xdat.model.FhirPatientCommunicationI> List<A> getCommunication() {
		try{
			if (_Communication==null){
				_Communication=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("communication"));
			}
			return (List<A>) _Communication;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirPatientCommunication>();}
	}

	/**
	 * Sets the value for communication.
	 * @param v Value to Set.
	 */
	public void setCommunication(ItemI v) throws Exception{
		_Communication =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/communication",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/communication",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * communication
	 * Adds org.nrg.xdat.model.FhirPatientCommunicationI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientCommunicationI> void addCommunication(A item) throws Exception{
	setCommunication((ItemI)item);
	}

	/**
	 * Removes the communication of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeCommunication(int index) throws java.lang.IndexOutOfBoundsException {
		_Communication =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/communication",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId> _GeneralpractitionerId =null;

	/**
	 * generalPractitioner_ID
	 * @return Returns an List of org.nrg.xdat.om.FhirPatientGeneralpractitionerId
	 */
	public <A extends org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI> List<A> getGeneralpractitionerId() {
		try{
			if (_GeneralpractitionerId==null){
				_GeneralpractitionerId=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("generalPractitioner_ID"));
			}
			return (List<A>) _GeneralpractitionerId;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirPatientGeneralpractitionerId>();}
	}

	/**
	 * Sets the value for generalPractitioner_ID.
	 * @param v Value to Set.
	 */
	public void setGeneralpractitionerId(ItemI v) throws Exception{
		_GeneralpractitionerId =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/generalPractitioner_ID",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/generalPractitioner_ID",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * generalPractitioner_ID
	 * Adds org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI> void addGeneralpractitionerId(A item) throws Exception{
	setGeneralpractitionerId((ItemI)item);
	}

	/**
	 * Removes the generalPractitioner_ID of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeGeneralpractitionerId(int index) throws java.lang.IndexOutOfBoundsException {
		_GeneralpractitionerId =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/generalPractitioner_ID",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _ManagingorganizationId=null;

	/**
	 * @return Returns the managingOrganization_ID.
	 */
	public Integer getManagingorganizationId() {
		try{
			if (_ManagingorganizationId==null){
				_ManagingorganizationId=getIntegerProperty("managingOrganization_ID");
				return _ManagingorganizationId;
			}else {
				return _ManagingorganizationId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for managingOrganization_ID.
	 * @param v Value to Set.
	 */
	public void setManagingorganizationId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/managingOrganization_ID",v);
		_ManagingorganizationId=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirPatientLink> _Link =null;

	/**
	 * link
	 * @return Returns an List of org.nrg.xdat.om.FhirPatientLink
	 */
	public <A extends org.nrg.xdat.model.FhirPatientLinkI> List<A> getLink() {
		try{
			if (_Link==null){
				_Link=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("link"));
			}
			return (List<A>) _Link;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirPatientLink>();}
	}

	/**
	 * Sets the value for link.
	 * @param v Value to Set.
	 */
	public void setLink(ItemI v) throws Exception{
		_Link =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/link",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/link",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * link
	 * Adds org.nrg.xdat.model.FhirPatientLinkI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientLinkI> void addLink(A item) throws Exception{
	setLink((ItemI)item);
	}

	/**
	 * Removes the link of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeLink(int index) throws java.lang.IndexOutOfBoundsException {
		_Link =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/link",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatient> getAllFhirPatients(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatient> al = new ArrayList<org.nrg.xdat.om.FhirPatient>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatient> getFhirPatientsByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatient> al = new ArrayList<org.nrg.xdat.om.FhirPatient>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirPatient> getFhirPatientsByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirPatient> al = new ArrayList<org.nrg.xdat.om.FhirPatient>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirPatient getFhirPatientsById(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:patient/id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirPatient) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
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

	public org.w3c.dom.Document toJoinedXML() throws Exception
	{
		ArrayList al = new ArrayList();
		al.add(this.getItem());
		al.add(org.nrg.xft.search.ItemSearch.GetItem("xnat:subjectData.ID",this.getItem().getProperty("xnat:mrSessionData.subject_ID"),getItem().getUser(),false));
		al.trimToSize();
		return org.nrg.xft.schema.Wrappers.XMLWrapper.XMLWriter.ItemListToDOM(al);
	}
	public ArrayList<ResourceFile> getFileResources(String rootPath, boolean preventLoop){
ArrayList<ResourceFile> _return = new ArrayList<ResourceFile>();
	 boolean localLoop = preventLoop;
	        localLoop = preventLoop;
	
	        //subjectAssessorData
	        XnatSubjectassessordata childSubjectassessordata = (XnatSubjectassessordata)this.getSubjectassessordata();
	            if (childSubjectassessordata!=null){
	              for(ResourceFile rf: ((XnatSubjectassessordata)childSubjectassessordata).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("subjectAssessorData[" + ((XnatSubjectassessordata)childSubjectassessordata).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("subjectAssessorData/" + ((XnatSubjectassessordata)childSubjectassessordata).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	
	        localLoop = preventLoop;
	
	        //identifier
	        for(org.nrg.xdat.model.FhirIdentifierI childIdentifier : this.getIdentifier()){
	            if (childIdentifier!=null){
	              for(ResourceFile rf: ((FhirIdentifier)childIdentifier).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("identifier[" + ((FhirIdentifier)childIdentifier).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("identifier/" + ((FhirIdentifier)childIdentifier).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	        //name
	        for(org.nrg.xdat.model.FhirHumannameI childName : this.getName()){
	            if (childName!=null){
	              for(ResourceFile rf: ((FhirHumanname)childName).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("name[" + ((FhirHumanname)childName).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("name/" + ((FhirHumanname)childName).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
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
	        for(org.nrg.xdat.model.FhirAddressI childAddress : this.getAddress()){
	            if (childAddress!=null){
	              for(ResourceFile rf: ((FhirAddress)childAddress).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("address[" + ((FhirAddress)childAddress).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("address/" + ((FhirAddress)childAddress).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	        //photo
	        for(org.nrg.xdat.model.FhirAttachementI childPhoto : this.getPhoto()){
	            if (childPhoto!=null){
	              for(ResourceFile rf: ((FhirAttachement)childPhoto).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("photo[" + ((FhirAttachement)childPhoto).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("photo/" + ((FhirAttachement)childPhoto).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	        //contact
	        for(org.nrg.xdat.model.FhirPatientContactI childContact : this.getContact()){
	            if (childContact!=null){
	              for(ResourceFile rf: ((FhirPatientContact)childContact).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("contact[" + ((FhirPatientContact)childContact).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("contact/" + ((FhirPatientContact)childContact).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	        //communication
	        for(org.nrg.xdat.model.FhirPatientCommunicationI childCommunication : this.getCommunication()){
	            if (childCommunication!=null){
	              for(ResourceFile rf: ((FhirPatientCommunication)childCommunication).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("communication[" + ((FhirPatientCommunication)childCommunication).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("communication/" + ((FhirPatientCommunication)childCommunication).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	        //generalPractitioner_ID
	        for(org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI childGeneralpractitionerId : this.getGeneralpractitionerId()){
	            if (childGeneralpractitionerId!=null){
	              for(ResourceFile rf: ((FhirPatientGeneralpractitionerId)childGeneralpractitionerId).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("generalPractitioner_ID[" + ((FhirPatientGeneralpractitionerId)childGeneralpractitionerId).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("generalPractitioner_ID/" + ((FhirPatientGeneralpractitionerId)childGeneralpractitionerId).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	        //link
	        for(org.nrg.xdat.model.FhirPatientLinkI childLink : this.getLink()){
	            if (childLink!=null){
	              for(ResourceFile rf: ((FhirPatientLink)childLink).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("link[" + ((FhirPatientLink)childLink).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("link/" + ((FhirPatientLink)childLink).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	return _return;
}
}
