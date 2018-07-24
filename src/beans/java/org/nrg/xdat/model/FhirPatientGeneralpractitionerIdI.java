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
public interface FhirPatientGeneralpractitionerIdI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the generalPractitioner_ID.
	 */
	public Integer getGeneralpractitionerId();

	/**
	 * Sets the value for fhir:patient_generalPractitioner_ID/generalPractitioner_ID.
	 * @param v Value to Set.
	 */
	public void setGeneralpractitionerId(Integer v) ;

	/**
	 * @return Returns the fhir_patient_generalPractitioner_ID_id.
	 */
	public Integer getFhirPatientGeneralpractitionerIdId();
}
