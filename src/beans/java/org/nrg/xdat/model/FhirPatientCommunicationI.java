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
public interface FhirPatientCommunicationI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the language.
	 */
	public String getLanguage();

	/**
	 * Sets the value for language.
	 * @param v Value to Set.
	 */
	public void setLanguage(String v);

	/**
	 * @return Returns the preferred.
	 */
	public Boolean getPreferred();

	/**
	 * Sets the value for preferred.
	 * @param v Value to Set.
	 */
	public void setPreferred(Object v);

	/**
	 * @return Returns the fhir_patient_communication_id.
	 */
	public Integer getFhirPatientCommunicationId();
}
