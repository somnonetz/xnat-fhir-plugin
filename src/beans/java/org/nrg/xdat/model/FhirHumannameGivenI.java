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
public interface FhirHumannameGivenI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the given.
	 */
	public String getGiven();

	/**
	 * Sets the value for given.
	 * @param v Value to Set.
	 */
	public void setGiven(String v);

	/**
	 * @return Returns the fhir_humanName_given_id.
	 */
	public Integer getFhirHumannameGivenId();
}
