/*
 * GENERATED FILE
 * Created on Tue Jul 24 17:16:36 CEST 2018
 *
 */
package org.nrg.xdat.model;

import java.util.List;

/**
 * @author XDAT
 *
 */
public interface FhirPatientI extends XnatSubjectassessordataI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * identifier
	 * @return Returns an List of org.nrg.xdat.model.FhirIdentifierI
	 */
	public <A extends org.nrg.xdat.model.FhirIdentifierI> List<A> getIdentifier();

	/**
	 * identifier
	 * @return Returns an List of org.nrg.xdat.model.FhirIdentifierI
	 */
	public <A extends org.nrg.xdat.model.FhirIdentifierI> void addIdentifier(A item) throws Exception;

	/**
	 * @return Returns the active.
	 */
	public Boolean getActive();

	/**
	 * Sets the value for active.
	 * @param v Value to Set.
	 */
	public void setActive(Object v);

	/**
	 * name
	 * @return Returns an List of org.nrg.xdat.model.FhirHumannameI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameI> List<A> getName();

	/**
	 * name
	 * @return Returns an List of org.nrg.xdat.model.FhirHumannameI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameI> void addName(A item) throws Exception;

	/**
	 * telecom
	 * @return Returns an List of org.nrg.xdat.model.FhirContactpointI
	 */
	public <A extends org.nrg.xdat.model.FhirContactpointI> List<A> getTelecom();

	/**
	 * telecom
	 * @return Returns an List of org.nrg.xdat.model.FhirContactpointI
	 */
	public <A extends org.nrg.xdat.model.FhirContactpointI> void addTelecom(A item) throws Exception;

	/**
	 * @return Returns the gender.
	 */
	public String getGender();

	/**
	 * Sets the value for gender.
	 * @param v Value to Set.
	 */
	public void setGender(String v);

	/**
	 * @return Returns the birthDate.
	 */
	public Object getBirthdate();

	/**
	 * Sets the value for birthDate.
	 * @param v Value to Set.
	 */
	public void setBirthdate(Object v);

	/**
	 * @return Returns the deceased/deceasedBoolean.
	 */
	public Boolean getDeceased_deceasedboolean();

	/**
	 * Sets the value for deceased/deceasedBoolean.
	 * @param v Value to Set.
	 */
	public void setDeceased_deceasedboolean(Object v);

	/**
	 * @return Returns the deceased/deceasedDateTime.
	 */
	public Object getDeceased_deceaseddatetime();

	/**
	 * Sets the value for deceased/deceasedDateTime.
	 * @param v Value to Set.
	 */
	public void setDeceased_deceaseddatetime(Object v);

	/**
	 * address
	 * @return Returns an List of org.nrg.xdat.model.FhirAddressI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressI> List<A> getAddress();

	/**
	 * address
	 * @return Returns an List of org.nrg.xdat.model.FhirAddressI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressI> void addAddress(A item) throws Exception;

	/**
	 * @return Returns the maritalStatus.
	 */
	public String getMaritalstatus();

	/**
	 * Sets the value for maritalStatus.
	 * @param v Value to Set.
	 */
	public void setMaritalstatus(String v);

	/**
	 * @return Returns the multipleBirth/multipleBirthBoolean.
	 */
	public Boolean getMultiplebirth_multiplebirthboolean();

	/**
	 * Sets the value for multipleBirth/multipleBirthBoolean.
	 * @param v Value to Set.
	 */
	public void setMultiplebirth_multiplebirthboolean(Object v);

	/**
	 * @return Returns the multipleBirth/multipleBirthInteger.
	 */
	public Integer getMultiplebirth_multiplebirthinteger();

	/**
	 * Sets the value for fhir:patient/multipleBirth/multipleBirthInteger.
	 * @param v Value to Set.
	 */
	public void setMultiplebirth_multiplebirthinteger(Integer v) ;

	/**
	 * photo
	 * @return Returns an List of org.nrg.xdat.model.FhirAttachementI
	 */
	public <A extends org.nrg.xdat.model.FhirAttachementI> List<A> getPhoto();

	/**
	 * photo
	 * @return Returns an List of org.nrg.xdat.model.FhirAttachementI
	 */
	public <A extends org.nrg.xdat.model.FhirAttachementI> void addPhoto(A item) throws Exception;

	/**
	 * contact
	 * @return Returns an List of org.nrg.xdat.model.FhirPatientContactI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientContactI> List<A> getContact();

	/**
	 * contact
	 * @return Returns an List of org.nrg.xdat.model.FhirPatientContactI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientContactI> void addContact(A item) throws Exception;

	/**
	 * @return Returns the animal/species.
	 */
	public String getAnimal_species();

	/**
	 * Sets the value for animal/species.
	 * @param v Value to Set.
	 */
	public void setAnimal_species(String v);

	/**
	 * @return Returns the animal/breed.
	 */
	public String getAnimal_breed();

	/**
	 * Sets the value for animal/breed.
	 * @param v Value to Set.
	 */
	public void setAnimal_breed(String v);

	/**
	 * @return Returns the animal/genderStatus.
	 */
	public String getAnimal_genderstatus();

	/**
	 * Sets the value for animal/genderStatus.
	 * @param v Value to Set.
	 */
	public void setAnimal_genderstatus(String v);

	/**
	 * communication
	 * @return Returns an List of org.nrg.xdat.model.FhirPatientCommunicationI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientCommunicationI> List<A> getCommunication();

	/**
	 * communication
	 * @return Returns an List of org.nrg.xdat.model.FhirPatientCommunicationI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientCommunicationI> void addCommunication(A item) throws Exception;

	/**
	 * generalPractitioner_ID
	 * @return Returns an List of org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI> List<A> getGeneralpractitionerId();

	/**
	 * generalPractitioner_ID
	 * @return Returns an List of org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientGeneralpractitionerIdI> void addGeneralpractitionerId(A item) throws Exception;

	/**
	 * @return Returns the managingOrganization_ID.
	 */
	public Integer getManagingorganizationId();

	/**
	 * Sets the value for fhir:patient/managingOrganization_ID.
	 * @param v Value to Set.
	 */
	public void setManagingorganizationId(Integer v) ;

	/**
	 * link
	 * @return Returns an List of org.nrg.xdat.model.FhirPatientLinkI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientLinkI> List<A> getLink();

	/**
	 * link
	 * @return Returns an List of org.nrg.xdat.model.FhirPatientLinkI
	 */
	public <A extends org.nrg.xdat.model.FhirPatientLinkI> void addLink(A item) throws Exception;
}
