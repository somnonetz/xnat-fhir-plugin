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
public interface FhirPatientLinkI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the other_ID.
	 */
	public Integer getOtherId();

	/**
	 * Sets the value for fhir:patient_link/other_ID.
	 * @param v Value to Set.
	 */
	public void setOtherId(Integer v) ;

	/**
	 * @return Returns the type.
	 */
	public String getType();

	/**
	 * Sets the value for type.
	 * @param v Value to Set.
	 */
	public void setType(String v);

	/**
	 * @return Returns the fhir_patient_link_id.
	 */
	public Integer getFhirPatientLinkId();
}
