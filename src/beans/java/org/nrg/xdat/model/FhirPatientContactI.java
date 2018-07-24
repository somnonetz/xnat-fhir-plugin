/*
 * GENERATED FILE
 * Created on Tue Jul 24 14:20:58 CEST 2018
 *
 */
package org.nrg.xdat.model;

import java.util.List;

/**
 * @author XDAT
 *
 */
public interface FhirPatientContactI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the relationship.
	 */
	public String getRelationship();

	/**
	 * Sets the value for relationship.
	 * @param v Value to Set.
	 */
	public void setRelationship(String v);

	/**
	 * name
	 * @return org.nrg.xdat.model.FhirHumannameI
	 */
	public org.nrg.xdat.model.FhirHumannameI getName();

	/**
	 * name
	 * @return org.nrg.xdat.model.FhirHumannameI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameI> void setName(A item) throws Exception;

	/**
	 * @return Returns the fhir:patient_contact/name_fhir_humanname_id.
	 */
	public Integer getNameFK();

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
	 * address
	 * @return org.nrg.xdat.model.FhirAddressI
	 */
	public org.nrg.xdat.model.FhirAddressI getAddress();

	/**
	 * address
	 * @return org.nrg.xdat.model.FhirAddressI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressI> void setAddress(A item) throws Exception;

	/**
	 * @return Returns the fhir:patient_contact/address_fhir_address_id.
	 */
	public Integer getAddressFK();

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
	 * @return Returns the organization_ID.
	 */
	public Integer getOrganizationId();

	/**
	 * Sets the value for fhir:patient_contact/organization_ID.
	 * @param v Value to Set.
	 */
	public void setOrganizationId(Integer v) ;

	/**
	 * @return Returns the period/start.
	 */
	public Object getPeriod_start();

	/**
	 * Sets the value for period/start.
	 * @param v Value to Set.
	 */
	public void setPeriod_start(Object v);

	/**
	 * @return Returns the period/end.
	 */
	public Object getPeriod_end();

	/**
	 * Sets the value for period/end.
	 * @param v Value to Set.
	 */
	public void setPeriod_end(Object v);

	/**
	 * @return Returns the fhir_patient_contact_id.
	 */
	public Integer getFhirPatientContactId();
}
