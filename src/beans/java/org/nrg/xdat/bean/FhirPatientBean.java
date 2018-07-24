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
public class FhirPatientBean extends XnatSubjectassessordataBean implements java.io.Serializable, org.nrg.xdat.model.FhirPatientI {
	public static final Logger logger = Logger.getLogger(FhirPatientBean.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:patient";

	public String getSchemaElementName(){
		return "patient";
	}

	public String getFullSchemaElementName(){
		return "fhir:patient";
	}
	 private List<org.nrg.xdat.bean.FhirIdentifierBean> _Identifier =new ArrayList<org.nrg.xdat.bean.FhirIdentifierBean>();

	/**
	 * identifier
	 * @return Returns an List of org.nrg.xdat.bean.FhirIdentifierBean
	 */
	public <A extends org.nrg.xdat.model.FhirIdentifierI> List<A> getIdentifier() {
		return (List<A>) _Identifier;
	}

	/**
	 * Sets the value for identifier.
	 * @param v Value to Set.
	 */
	public void setIdentifier(ArrayList<org.nrg.xdat.bean.FhirIdentifierBean> v){
		_Identifier=v;
	}

	/**
	 * Adds the value for identifier.
	 * @param v Value to Set.
	 */
	public void addIdentifier(org.nrg.xdat.bean.FhirIdentifierBean v){
		_Identifier.add(v);
	}

	/**
	 * identifier
	 * Adds org.nrg.xdat.model.FhirIdentifierI
	 */
	public <A extends org.nrg.xdat.model.FhirIdentifierI> void addIdentifier(A item) throws Exception{
	_Identifier.add((org.nrg.xdat.bean.FhirIdentifierBean)item);
	}

	/**
	 * Adds the value for identifier.
	 * @param v Value to Set.
	 */
	public void addIdentifier(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirIdentifierBean)
			_Identifier.add((org.nrg.xdat.bean.FhirIdentifierBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirIdentifierBean");
	}

	//FIELD

	private Boolean _Active=null;

	/**
	 * @return Returns the active.
	 */
	public Boolean getActive() {
		return _Active;
	}

	/**
	 * Sets the value for active.
	 * @param v Value to Set.
	 */
	public void setActive(Object v){
		if(v instanceof Boolean){
			_Active=(Boolean)v;
		}else if(v instanceof String){
			_Active=formatBoolean((String)v);
		}else if(v!=null){
			throw new IllegalArgumentException();
		}
	}
	 private List<org.nrg.xdat.bean.FhirHumannameBean> _Name =new ArrayList<org.nrg.xdat.bean.FhirHumannameBean>();

	/**
	 * name
	 * @return Returns an List of org.nrg.xdat.bean.FhirHumannameBean
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameI> List<A> getName() {
		return (List<A>) _Name;
	}

	/**
	 * Sets the value for name.
	 * @param v Value to Set.
	 */
	public void setName(ArrayList<org.nrg.xdat.bean.FhirHumannameBean> v){
		_Name=v;
	}

	/**
	 * Adds the value for name.
	 * @param v Value to Set.
	 */
	public void addName(org.nrg.xdat.bean.FhirHumannameBean v){
		_Name.add(v);
	}

	/**
	 * name
	 * Adds org.nrg.xdat.model.FhirHumannameI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameI> void addName(A item) throws Exception{
	_Name.add((org.nrg.xdat.bean.FhirHumannameBean)item);
	}

	/**
	 * Adds the value for name.
	 * @param v Value to Set.
	 */
	public void addName(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirHumannameBean)
			_Name.add((org.nrg.xdat.bean.FhirHumannameBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirHumannameBean");
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

	private Date _Birthdate=null;

	/**
	 * @return Returns the birthDate.
	 */
	public Date getBirthdate(){
		return _Birthdate;
	}

	/**
	 * Sets the value for birthDate.
	 * @param v Value to Set.
	 */
	public void setBirthdate(Date v){
		_Birthdate=v;
	}

	/**
	 * Sets the value for birthDate.
	 * @param v Value to Set.
	 */
	public void setBirthdate(Object v){
		throw new IllegalArgumentException();
	}

	/**
	 * Sets the value for birthDate.
	 * @param v Value to Set.
	 */
	public void setBirthdate(String v)  {
		_Birthdate=formatDate(v);
	}

	//FIELD

	private Boolean _Deceased_deceasedboolean=null;

	/**
	 * @return Returns the deceased/deceasedBoolean.
	 */
	public Boolean getDeceased_deceasedboolean() {
		return _Deceased_deceasedboolean;
	}

	/**
	 * Sets the value for deceased/deceasedBoolean.
	 * @param v Value to Set.
	 */
	public void setDeceased_deceasedboolean(Object v){
		if(v instanceof Boolean){
			_Deceased_deceasedboolean=(Boolean)v;
		}else if(v instanceof String){
			_Deceased_deceasedboolean=formatBoolean((String)v);
		}else if(v!=null){
			throw new IllegalArgumentException();
		}
	}

	//FIELD

	private Date _Deceased_deceaseddatetime=null;

	/**
	 * @return Returns the deceased/deceasedDateTime.
	 */
	public Date getDeceased_deceaseddatetime(){
		return _Deceased_deceaseddatetime;
	}

	/**
	 * Sets the value for deceased/deceasedDateTime.
	 * @param v Value to Set.
	 */
	public void setDeceased_deceaseddatetime(Date v){
		_Deceased_deceaseddatetime=v;
	}

	/**
	 * Sets the value for deceased/deceasedDateTime.
	 * @param v Value to Set.
	 */
	public void setDeceased_deceaseddatetime(Object v){
		throw new IllegalArgumentException();
	}

	/**
	 * Sets the value for deceased/deceasedDateTime.
	 * @param v Value to Set.
	 */
	public void setDeceased_deceaseddatetime(String v)  {
		_Deceased_deceaseddatetime=formatDateTime(v);
	}
	 private List<org.nrg.xdat.bean.FhirAddressBean> _Address =new ArrayList<org.nrg.xdat.bean.FhirAddressBean>();

	/**
	 * address
	 * @return Returns an List of org.nrg.xdat.bean.FhirAddressBean
	 */
	public <A extends org.nrg.xdat.model.FhirAddressI> List<A> getAddress() {
		return (List<A>) _Address;
	}

	/**
	 * Sets the value for address.
	 * @param v Value to Set.
	 */
	public void setAddress(ArrayList<org.nrg.xdat.bean.FhirAddressBean> v){
		_Address=v;
	}

	/**
	 * Adds the value for address.
	 * @param v Value to Set.
	 */
	public void addAddress(org.nrg.xdat.bean.FhirAddressBean v){
		_Address.add(v);
	}

	/**
	 * address
	 * Adds org.nrg.xdat.model.FhirAddressI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressI> void addAddress(A item) throws Exception{
	_Address.add((org.nrg.xdat.bean.FhirAddressBean)item);
	}

	/**
	 * Adds the value for address.
	 * @param v Value to Set.
	 */
	public void addAddress(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirAddressBean)
			_Address.add((org.nrg.xdat.bean.FhirAddressBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirAddressBean");
	}

	//FIELD

	private String _Maritalstatus=null;

	/**
	 * @return Returns the maritalStatus.
	 */
	public String getMaritalstatus(){
		return _Maritalstatus;
	}

	/**
	 * Sets the value for maritalStatus.
	 * @param v Value to Set.
	 */
	public void setMaritalstatus(String v){
		_Maritalstatus=v;
	}

	//FIELD

	private Boolean _Multiplebirth_multiplebirthboolean=null;

	/**
	 * @return Returns the multipleBirth/multipleBirthBoolean.
	 */
	public Boolean getMultiplebirth_multiplebirthboolean() {
		return _Multiplebirth_multiplebirthboolean;
	}

	/**
	 * Sets the value for multipleBirth/multipleBirthBoolean.
	 * @param v Value to Set.
	 */
	public void setMultiplebirth_multiplebirthboolean(Object v){
		if(v instanceof Boolean){
			_Multiplebirth_multiplebirthboolean=(Boolean)v;
		}else if(v instanceof String){
			_Multiplebirth_multiplebirthboolean=formatBoolean((String)v);
		}else if(v!=null){
			throw new IllegalArgumentException();
		}
	}

	//FIELD

	private Integer _Multiplebirth_multiplebirthinteger=null;

	/**
	 * @return Returns the multipleBirth/multipleBirthInteger.
	 */
	public Integer getMultiplebirth_multiplebirthinteger(){
		return _Multiplebirth_multiplebirthinteger;
	}

	/**
	 * Sets the value for fhir:patient/multipleBirth/multipleBirthInteger.
	 * @param v Value to Set.
	 */
	public void setMultiplebirth_multiplebirthinteger(Integer v) {
		_Multiplebirth_multiplebirthinteger=v;
	}

	/**
	 * Sets the value for fhir:patient/multipleBirth/multipleBirthInteger.
	 * @param v Value to Set.
	 */
	public void setMultiplebirth_multiplebirthinteger(String v)  {
		_Multiplebirth_multiplebirthinteger=formatInteger(v);
	}
	 private List<org.nrg.xdat.bean.FhirAttachementBean> _Photo =new ArrayList<org.nrg.xdat.bean.FhirAttachementBean>();

	/**
	 * photo
	 * @return Returns an List of org.nrg.xdat.bean.FhirAttachementBean
	 */
	public <A extends org.nrg.xdat.model.FhirAttachementI> List<A> getPhoto() {
		return (List<A>) _Photo;
	}

	/**
	 * Sets the value for photo.
	 * @param v Value to Set.
	 */
	public void setPhoto(ArrayList<org.nrg.xdat.bean.FhirAttachementBean> v){
		_Photo=v;
	}

	/**
	 * Adds the value for photo.
	 * @param v Value to Set.
	 */
	public void addPhoto(org.nrg.xdat.bean.FhirAttachementBean v){
		_Photo.add(v);
	}

	/**
	 * photo
	 * Adds org.nrg.xdat.model.FhirAttachementI
	 */
	public <A extends org.nrg.xdat.model.FhirAttachementI> void addPhoto(A item) throws Exception{
	_Photo.add((org.nrg.xdat.bean.FhirAttachementBean)item);
	}

	/**
	 * Adds the value for photo.
	 * @param v Value to Set.
	 */
	public void addPhoto(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirAttachementBean)
			_Photo.add((org.nrg.xdat.bean.FhirAttachementBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirAttachementBean");
	}
	 private List<org.nrg.xdat.bean.FhirPatientContactBean> _Contact =new ArrayList<org.nrg.xdat.bean.FhirPatientContactBean>();

	/**
	 * contact
	 * @return Returns an List of org.nrg.xdat.bean.FhirPatientContactBean
	 */
	public <A extends org.nrg.xdat.model.FhirPatientContactI> List<A> getContact() {
		return (List<A>) _Contact;
	}

	/**
	 * Sets the value for contact.
	 * @param v Value to Set.
	 */
	public void setContact(ArrayList<org.nrg.xdat.bean.FhirPatientContactBean> v){
		_Contact=v;
	}

	/**
	 * Adds the value for contact.
	 * @param v Value to Set.
	 */
	public void addContact(org.nrg.xdat.bean.FhirPatientContactBean v){
		_Contact.add(v);
	}

	/**
	 * contact
	 * Adds org.nrg.xdat.model.FhirPatientContactI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientContactI> void addContact(A item) throws Exception{
	_Contact.add((org.nrg.xdat.bean.FhirPatientContactBean)item);
	}

	/**
	 * Adds the value for contact.
	 * @param v Value to Set.
	 */
	public void addContact(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirPatientContactBean)
			_Contact.add((org.nrg.xdat.bean.FhirPatientContactBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirPatientContactBean");
	}

	//FIELD

	private String _Animal_species=null;

	/**
	 * @return Returns the animal/species.
	 */
	public String getAnimal_species(){
		return _Animal_species;
	}

	/**
	 * Sets the value for animal/species.
	 * @param v Value to Set.
	 */
	public void setAnimal_species(String v){
		_Animal_species=v;
	}

	//FIELD

	private String _Animal_breed=null;

	/**
	 * @return Returns the animal/breed.
	 */
	public String getAnimal_breed(){
		return _Animal_breed;
	}

	/**
	 * Sets the value for animal/breed.
	 * @param v Value to Set.
	 */
	public void setAnimal_breed(String v){
		_Animal_breed=v;
	}

	//FIELD

	private String _Animal_genderstatus=null;

	/**
	 * @return Returns the animal/genderStatus.
	 */
	public String getAnimal_genderstatus(){
		return _Animal_genderstatus;
	}

	/**
	 * Sets the value for animal/genderStatus.
	 * @param v Value to Set.
	 */
	public void setAnimal_genderstatus(String v){
		_Animal_genderstatus=v;
	}
	 private List<org.nrg.xdat.bean.FhirPatientCommunicationBean> _Communication =new ArrayList<org.nrg.xdat.bean.FhirPatientCommunicationBean>();

	/**
	 * communication
	 * @return Returns an List of org.nrg.xdat.bean.FhirPatientCommunicationBean
	 */
	public <A extends org.nrg.xdat.model.FhirPatientCommunicationI> List<A> getCommunication() {
		return (List<A>) _Communication;
	}

	/**
	 * Sets the value for communication.
	 * @param v Value to Set.
	 */
	public void setCommunication(ArrayList<org.nrg.xdat.bean.FhirPatientCommunicationBean> v){
		_Communication=v;
	}

	/**
	 * Adds the value for communication.
	 * @param v Value to Set.
	 */
	public void addCommunication(org.nrg.xdat.bean.FhirPatientCommunicationBean v){
		_Communication.add(v);
	}

	/**
	 * communication
	 * Adds org.nrg.xdat.model.FhirPatientCommunicationI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientCommunicationI> void addCommunication(A item) throws Exception{
	_Communication.add((org.nrg.xdat.bean.FhirPatientCommunicationBean)item);
	}

	/**
	 * Adds the value for communication.
	 * @param v Value to Set.
	 */
	public void addCommunication(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirPatientCommunicationBean)
			_Communication.add((org.nrg.xdat.bean.FhirPatientCommunicationBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirPatientCommunicationBean");
	}
	 private List<org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean> _GeneralpractitionerId =new ArrayList<org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean>();

	/**
	 * generalPractitioner_ID
	 * @return Returns an List of org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean
	 */
	public <A extends org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI> List<A> getGeneralpractitionerId() {
		return (List<A>) _GeneralpractitionerId;
	}

	/**
	 * Sets the value for generalPractitioner_ID.
	 * @param v Value to Set.
	 */
	public void setGeneralpractitionerId(ArrayList<org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean> v){
		_GeneralpractitionerId=v;
	}

	/**
	 * Adds the value for generalPractitioner_ID.
	 * @param v Value to Set.
	 */
	public void addGeneralpractitionerId(org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean v){
		_GeneralpractitionerId.add(v);
	}

	/**
	 * generalPractitioner_ID
	 * Adds org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI> void addGeneralpractitionerId(A item) throws Exception{
	_GeneralpractitionerId.add((org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean)item);
	}

	/**
	 * Adds the value for generalPractitioner_ID.
	 * @param v Value to Set.
	 */
	public void addGeneralpractitionerId(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean)
			_GeneralpractitionerId.add((org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean");
	}

	//FIELD

	private Integer _ManagingorganizationId=null;

	/**
	 * @return Returns the managingOrganization_ID.
	 */
	public Integer getManagingorganizationId(){
		return _ManagingorganizationId;
	}

	/**
	 * Sets the value for fhir:patient/managingOrganization_ID.
	 * @param v Value to Set.
	 */
	public void setManagingorganizationId(Integer v) {
		_ManagingorganizationId=v;
	}

	/**
	 * Sets the value for fhir:patient/managingOrganization_ID.
	 * @param v Value to Set.
	 */
	public void setManagingorganizationId(String v)  {
		_ManagingorganizationId=formatInteger(v);
	}
	 private List<org.nrg.xdat.bean.FhirPatientLinkBean> _Link =new ArrayList<org.nrg.xdat.bean.FhirPatientLinkBean>();

	/**
	 * link
	 * @return Returns an List of org.nrg.xdat.bean.FhirPatientLinkBean
	 */
	public <A extends org.nrg.xdat.model.FhirPatientLinkI> List<A> getLink() {
		return (List<A>) _Link;
	}

	/**
	 * Sets the value for link.
	 * @param v Value to Set.
	 */
	public void setLink(ArrayList<org.nrg.xdat.bean.FhirPatientLinkBean> v){
		_Link=v;
	}

	/**
	 * Adds the value for link.
	 * @param v Value to Set.
	 */
	public void addLink(org.nrg.xdat.bean.FhirPatientLinkBean v){
		_Link.add(v);
	}

	/**
	 * link
	 * Adds org.nrg.xdat.model.FhirPatientLinkI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientLinkI> void addLink(A item) throws Exception{
	_Link.add((org.nrg.xdat.bean.FhirPatientLinkBean)item);
	}

	/**
	 * Adds the value for link.
	 * @param v Value to Set.
	 */
	public void addLink(Object v){
		if (v instanceof org.nrg.xdat.bean.FhirPatientLinkBean)
			_Link.add((org.nrg.xdat.bean.FhirPatientLinkBean)v);
		else
			throw new IllegalArgumentException("Must be a valid org.nrg.xdat.bean.FhirPatientLinkBean");
	}

	/**
	 * Sets the value for a field via the XMLPATH.
	 * @param v Value to Set.
	 */
	public void setDataField(String xmlPath,String v) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("active")){
			setActive(v);
		}else if (xmlPath.equals("gender")){
			setGender(v);
		}else if (xmlPath.equals("birthDate")){
			setBirthdate(v);
		}else if (xmlPath.equals("deceased/deceasedBoolean")){
			setDeceased_deceasedboolean(v);
		}else if (xmlPath.equals("deceased/deceasedDateTime")){
			setDeceased_deceaseddatetime(v);
		}else if (xmlPath.equals("maritalStatus")){
			setMaritalstatus(v);
		}else if (xmlPath.equals("multipleBirth/multipleBirthBoolean")){
			setMultiplebirth_multiplebirthboolean(v);
		}else if (xmlPath.equals("multipleBirth/multipleBirthInteger")){
			setMultiplebirth_multiplebirthinteger(v);
		}else if (xmlPath.equals("animal/species")){
			setAnimal_species(v);
		}else if (xmlPath.equals("animal/breed")){
			setAnimal_breed(v);
		}else if (xmlPath.equals("animal/genderStatus")){
			setAnimal_genderstatus(v);
		}else if (xmlPath.equals("managingOrganization_ID")){
			setManagingorganizationId(v);
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
		if (xmlPath.equals("identifier")){
			addIdentifier(v);
		}else if (xmlPath.equals("name")){
			addName(v);
		}else if (xmlPath.equals("telecom")){
			addTelecom(v);
		}else if (xmlPath.equals("address")){
			addAddress(v);
		}else if (xmlPath.equals("photo")){
			addPhoto(v);
		}else if (xmlPath.equals("contact")){
			addContact(v);
		}else if (xmlPath.equals("communication")){
			addCommunication(v);
		}else if (xmlPath.equals("generalPractitioner_ID")){
			addGeneralpractitionerId(v);
		}else if (xmlPath.equals("link")){
			addLink(v);
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
		if (xmlPath.equals("active")){
			return getActive();
		}else if (xmlPath.equals("gender")){
			return getGender();
		}else if (xmlPath.equals("birthDate")){
			return getBirthdate();
		}else if (xmlPath.equals("deceased/deceasedBoolean")){
			return getDeceased_deceasedboolean();
		}else if (xmlPath.equals("deceased/deceasedDateTime")){
			return getDeceased_deceaseddatetime();
		}else if (xmlPath.equals("maritalStatus")){
			return getMaritalstatus();
		}else if (xmlPath.equals("multipleBirth/multipleBirthBoolean")){
			return getMultiplebirth_multiplebirthboolean();
		}else if (xmlPath.equals("multipleBirth/multipleBirthInteger")){
			return getMultiplebirth_multiplebirthinteger();
		}else if (xmlPath.equals("animal/species")){
			return getAnimal_species();
		}else if (xmlPath.equals("animal/breed")){
			return getAnimal_breed();
		}else if (xmlPath.equals("animal/genderStatus")){
			return getAnimal_genderstatus();
		}else if (xmlPath.equals("managingOrganization_ID")){
			return getManagingorganizationId();
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
		if (xmlPath.equals("identifier")){
			return getIdentifier();
		}else if (xmlPath.equals("name")){
			return getName();
		}else if (xmlPath.equals("telecom")){
			return getTelecom();
		}else if (xmlPath.equals("address")){
			return getAddress();
		}else if (xmlPath.equals("photo")){
			return getPhoto();
		}else if (xmlPath.equals("contact")){
			return getContact();
		}else if (xmlPath.equals("communication")){
			return getCommunication();
		}else if (xmlPath.equals("generalPractitioner_ID")){
			return getGeneralpractitionerId();
		}else if (xmlPath.equals("link")){
			return getLink();
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
		if (xmlPath.equals("identifier")){
			return "http://cbmi.htw-berlin.de/fhir:identifier";
		}else if (xmlPath.equals("name")){
			return "http://cbmi.htw-berlin.de/fhir:humanName";
		}else if (xmlPath.equals("telecom")){
			return "http://cbmi.htw-berlin.de/fhir:contactPoint";
		}else if (xmlPath.equals("address")){
			return "http://cbmi.htw-berlin.de/fhir:address";
		}else if (xmlPath.equals("photo")){
			return "http://cbmi.htw-berlin.de/fhir:attachement";
		}else if (xmlPath.equals("contact")){
			return "http://cbmi.htw-berlin.de/fhir:patient_contact";
		}else if (xmlPath.equals("communication")){
			return "http://cbmi.htw-berlin.de/fhir:patient_communication";
		}else if (xmlPath.equals("generalPractitioner_ID")){
			return "http://cbmi.htw-berlin.de/fhir:patient_generalPractitioner_ID";
		}else if (xmlPath.equals("link")){
			return "http://cbmi.htw-berlin.de/fhir:patient_link";
		}
		else{
			return super.getReferenceFieldName(xmlPath);
		}
	}

	/**
	 * Returns whether or not this is a reference field
	 */
	public String getFieldType(String xmlPath) throws BaseElement.UnknownFieldException{
		if (xmlPath.equals("identifier")){
			return BaseElement.field_multi_reference;
		}else if (xmlPath.equals("active")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("name")){
			return BaseElement.field_multi_reference;
		}else if (xmlPath.equals("telecom")){
			return BaseElement.field_multi_reference;
		}else if (xmlPath.equals("gender")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("birthDate")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("deceased/deceasedBoolean")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("deceased/deceasedDateTime")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("address")){
			return BaseElement.field_multi_reference;
		}else if (xmlPath.equals("maritalStatus")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("multipleBirth/multipleBirthBoolean")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("multipleBirth/multipleBirthInteger")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("photo")){
			return BaseElement.field_multi_reference;
		}else if (xmlPath.equals("contact")){
			return BaseElement.field_multi_reference;
		}else if (xmlPath.equals("animal/species")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("animal/breed")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("animal/genderStatus")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("communication")){
			return BaseElement.field_multi_reference;
		}else if (xmlPath.equals("generalPractitioner_ID")){
			return BaseElement.field_inline_repeater;
		}else if (xmlPath.equals("managingOrganization_ID")){
			return BaseElement.field_data;
		}else if (xmlPath.equals("link")){
			return BaseElement.field_multi_reference;
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
		all_fields.add("identifier");
		all_fields.add("active");
		all_fields.add("name");
		all_fields.add("telecom");
		all_fields.add("gender");
		all_fields.add("birthDate");
		all_fields.add("deceased/deceasedBoolean");
		all_fields.add("deceased/deceasedDateTime");
		all_fields.add("address");
		all_fields.add("maritalStatus");
		all_fields.add("multipleBirth/multipleBirthBoolean");
		all_fields.add("multipleBirth/multipleBirthInteger");
		all_fields.add("photo");
		all_fields.add("contact");
		all_fields.add("animal/species");
		all_fields.add("animal/breed");
		all_fields.add("animal/genderStatus");
		all_fields.add("communication");
		all_fields.add("generalPractitioner_ID");
		all_fields.add("managingOrganization_ID");
		all_fields.add("link");
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
		writer.write("\n<fhir:FHIRAddress");
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
		writer.write("\n</fhir:FHIRAddress>");
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
		//REFERENCE FROM patient -> subjectAssessorData
		//REFERENCE FROM patient -> identifier
		java.util.Iterator iter0=_Identifier.iterator();
		while(iter0.hasNext()){
			org.nrg.xdat.bean.FhirIdentifierBean child = (org.nrg.xdat.bean.FhirIdentifierBean)iter0.next();
			writer.write("\n" + createHeader(header++) + "<fhir:identifier");
			child.addXMLAtts(writer);
			if(!child.getFullSchemaElementName().equals("fhir:identifier")){
				writer.write(" xsi:type=\"" + child.getFullSchemaElementName() + "\"");
			}
			if (child.hasXMLBodyContent()){
				writer.write(">");
				boolean return1 =child.addXMLBody(writer,header);
				if(return1){
					writer.write("\n" + createHeader(--header) + "</fhir:identifier>");
				}else{
					writer.write("</fhir:identifier>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
		if (_Active!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:active");
			writer.write(">");
			writer.write(ValueParser(_Active,"boolean"));
			writer.write("</fhir:active>");
			header--;
		}
		//REFERENCE FROM patient -> name
		java.util.Iterator iter1=_Name.iterator();
		while(iter1.hasNext()){
			org.nrg.xdat.bean.FhirHumannameBean child = (org.nrg.xdat.bean.FhirHumannameBean)iter1.next();
			writer.write("\n" + createHeader(header++) + "<fhir:name");
			child.addXMLAtts(writer);
			if(!child.getFullSchemaElementName().equals("fhir:humanName")){
				writer.write(" xsi:type=\"" + child.getFullSchemaElementName() + "\"");
			}
			if (child.hasXMLBodyContent()){
				writer.write(">");
				boolean return2 =child.addXMLBody(writer,header);
				if(return2){
					writer.write("\n" + createHeader(--header) + "</fhir:name>");
				}else{
					writer.write("</fhir:name>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
		//REFERENCE FROM patient -> telecom
		java.util.Iterator iter2=_Telecom.iterator();
		while(iter2.hasNext()){
			org.nrg.xdat.bean.FhirContactpointBean child = (org.nrg.xdat.bean.FhirContactpointBean)iter2.next();
			writer.write("\n" + createHeader(header++) + "<fhir:telecom");
			child.addXMLAtts(writer);
			if(!child.getFullSchemaElementName().equals("fhir:contactPoint")){
				writer.write(" xsi:type=\"" + child.getFullSchemaElementName() + "\"");
			}
			if (child.hasXMLBodyContent()){
				writer.write(">");
				boolean return3 =child.addXMLBody(writer,header);
				if(return3){
					writer.write("\n" + createHeader(--header) + "</fhir:telecom>");
				}else{
					writer.write("</fhir:telecom>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
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

		if (_Birthdate!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:birthDate");
			writer.write(">");
			writer.write(ValueParser(_Birthdate,"date"));
			writer.write("</fhir:birthDate>");
			header--;
		}
			int child3=0;
			int att3=0;
			if(_Deceased_deceaseddatetime!=null)
			child3++;
			if(_Deceased_deceasedboolean!=null)
			child3++;
			if(child3>0 || att3>0){
				writer.write("\n" + createHeader(header++) + "<fhir:deceased");
			if(child3==0){
				writer.write("/>");
			}else{
				writer.write(">");
		if (_Deceased_deceasedboolean!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:deceasedBoolean");
			writer.write(">");
			writer.write(ValueParser(_Deceased_deceasedboolean,"boolean"));
			writer.write("</fhir:deceasedBoolean>");
			header--;
		}
		if (_Deceased_deceaseddatetime!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:deceasedDateTime");
			writer.write(">");
			writer.write(ValueParser(_Deceased_deceaseddatetime,"dateTime"));
			writer.write("</fhir:deceasedDateTime>");
			header--;
		}
				writer.write("\n" + createHeader(--header) + "</fhir:deceased>");
			}
			}

		//REFERENCE FROM patient -> address
		java.util.Iterator iter4=_Address.iterator();
		while(iter4.hasNext()){
			org.nrg.xdat.bean.FhirAddressBean child = (org.nrg.xdat.bean.FhirAddressBean)iter4.next();
			writer.write("\n" + createHeader(header++) + "<fhir:address");
			child.addXMLAtts(writer);
			if(!child.getFullSchemaElementName().equals("fhir:address")){
				writer.write(" xsi:type=\"" + child.getFullSchemaElementName() + "\"");
			}
			if (child.hasXMLBodyContent()){
				writer.write(">");
				boolean return5 =child.addXMLBody(writer,header);
				if(return5){
					writer.write("\n" + createHeader(--header) + "</fhir:address>");
				}else{
					writer.write("</fhir:address>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
		if (_Maritalstatus!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:maritalStatus");
			writer.write(">");
			writer.write(ValueParser(_Maritalstatus,"string"));
			writer.write("</fhir:maritalStatus>");
			header--;
		}
		else{
			writer.write("\n" + createHeader(header++) + "<fhir:maritalStatus");
			writer.write("/>");
			header--;
		}

			int child5=0;
			int att5=0;
			if(_Multiplebirth_multiplebirthboolean!=null)
			child5++;
			if(_Multiplebirth_multiplebirthinteger!=null)
			child5++;
			if(child5>0 || att5>0){
				writer.write("\n" + createHeader(header++) + "<fhir:multipleBirth");
			if(child5==0){
				writer.write("/>");
			}else{
				writer.write(">");
		if (_Multiplebirth_multiplebirthboolean!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:multipleBirthBoolean");
			writer.write(">");
			writer.write(ValueParser(_Multiplebirth_multiplebirthboolean,"boolean"));
			writer.write("</fhir:multipleBirthBoolean>");
			header--;
		}
		if (_Multiplebirth_multiplebirthinteger!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:multipleBirthInteger");
			writer.write(">");
			writer.write(ValueParser(_Multiplebirth_multiplebirthinteger,"integer"));
			writer.write("</fhir:multipleBirthInteger>");
			header--;
		}
				writer.write("\n" + createHeader(--header) + "</fhir:multipleBirth>");
			}
			}

		//REFERENCE FROM patient -> photo
		java.util.Iterator iter6=_Photo.iterator();
		while(iter6.hasNext()){
			org.nrg.xdat.bean.FhirAttachementBean child = (org.nrg.xdat.bean.FhirAttachementBean)iter6.next();
			writer.write("\n" + createHeader(header++) + "<fhir:photo");
			child.addXMLAtts(writer);
			if(!child.getFullSchemaElementName().equals("fhir:attachement")){
				writer.write(" xsi:type=\"" + child.getFullSchemaElementName() + "\"");
			}
			if (child.hasXMLBodyContent()){
				writer.write(">");
				boolean return7 =child.addXMLBody(writer,header);
				if(return7){
					writer.write("\n" + createHeader(--header) + "</fhir:photo>");
				}else{
					writer.write("</fhir:photo>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
		//REFERENCE FROM patient -> contact
		java.util.Iterator iter7=_Contact.iterator();
		while(iter7.hasNext()){
			org.nrg.xdat.bean.FhirPatientContactBean child = (org.nrg.xdat.bean.FhirPatientContactBean)iter7.next();
			writer.write("\n" + createHeader(header++) + "<fhir:contact");
			child.addXMLAtts(writer);
			if(!child.getFullSchemaElementName().equals("fhir:patient_contact")){
				writer.write(" xsi:type=\"" + child.getFullSchemaElementName() + "\"");
			}
			if (child.hasXMLBodyContent()){
				writer.write(">");
				boolean return8 =child.addXMLBody(writer,header);
				if(return8){
					writer.write("\n" + createHeader(--header) + "</fhir:contact>");
				}else{
					writer.write("</fhir:contact>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
			int child8=0;
			int att8=0;
			if(_Animal_species!=null)
			child8++;
			if(_Animal_breed!=null)
			child8++;
			if(_Animal_genderstatus!=null)
			child8++;
			if(child8>0 || att8>0){
				writer.write("\n" + createHeader(header++) + "<fhir:animal");
			if(child8==0){
				writer.write("/>");
			}else{
				writer.write(">");
		if (_Animal_species!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:species");
			writer.write(">");
			writer.write(ValueParser(_Animal_species,"string"));
			writer.write("</fhir:species>");
			header--;
		}
		if (_Animal_breed!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:breed");
			writer.write(">");
			writer.write(ValueParser(_Animal_breed,"string"));
			writer.write("</fhir:breed>");
			header--;
		}
		if (_Animal_genderstatus!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:genderStatus");
			writer.write(">");
			writer.write(ValueParser(_Animal_genderstatus,"string"));
			writer.write("</fhir:genderStatus>");
			header--;
		}
		else{
			writer.write("\n" + createHeader(header++) + "<fhir:genderStatus");
			writer.write("/>");
			header--;
		}

				writer.write("\n" + createHeader(--header) + "</fhir:animal>");
			}
			}

		//REFERENCE FROM patient -> communication
		java.util.Iterator iter9=_Communication.iterator();
		while(iter9.hasNext()){
			org.nrg.xdat.bean.FhirPatientCommunicationBean child = (org.nrg.xdat.bean.FhirPatientCommunicationBean)iter9.next();
			writer.write("\n" + createHeader(header++) + "<fhir:communication");
			child.addXMLAtts(writer);
			if(!child.getFullSchemaElementName().equals("fhir:patient_communication")){
				writer.write(" xsi:type=\"" + child.getFullSchemaElementName() + "\"");
			}
			if (child.hasXMLBodyContent()){
				writer.write(">");
				boolean return10 =child.addXMLBody(writer,header);
				if(return10){
					writer.write("\n" + createHeader(--header) + "</fhir:communication>");
				}else{
					writer.write("</fhir:communication>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
		//REFERENCE FROM patient -> generalPractitioner_ID
		//IN-LINE REPEATER
		java.util.Iterator iter10=_GeneralpractitionerId.iterator();
		while(iter10.hasNext()){
			org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean child = (org.nrg.xdat.bean.FhirPatientGeneralpractitionerIdBean)iter10.next();
			child.addXMLBody(writer,header);
		}
		if (_ManagingorganizationId!=null){
			writer.write("\n" + createHeader(header++) + "<fhir:managingOrganization_ID");
			writer.write(">");
			writer.write(ValueParser(_ManagingorganizationId,"integer"));
			writer.write("</fhir:managingOrganization_ID>");
			header--;
		}
		//REFERENCE FROM patient -> link
		java.util.Iterator iter11=_Link.iterator();
		while(iter11.hasNext()){
			org.nrg.xdat.bean.FhirPatientLinkBean child = (org.nrg.xdat.bean.FhirPatientLinkBean)iter11.next();
			writer.write("\n" + createHeader(header++) + "<fhir:link");
			child.addXMLAtts(writer);
			if(!child.getFullSchemaElementName().equals("fhir:patient_link")){
				writer.write(" xsi:type=\"" + child.getFullSchemaElementName() + "\"");
			}
			if (child.hasXMLBodyContent()){
				writer.write(">");
				boolean return12 =child.addXMLBody(writer,header);
				if(return12){
					writer.write("\n" + createHeader(--header) + "</fhir:link>");
				}else{
					writer.write("</fhir:link>");
					header--;
				}
			}else {writer.write("/>");header--;}
		}
	return true;
	}


	protected boolean hasXMLBodyContent(){
		if(_Identifier.size()>0) return true;
		if (_Active!=null) return true;
		if(_Name.size()>0) return true;
		if(_Telecom.size()>0) return true;
		if (_Gender!=null) return true;
		return true;//REQUIRED gender
	}
}
