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
public interface FhirHumannameSuffixI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the suffix.
	 */
	public String getSuffix();

	/**
	 * Sets the value for suffix.
	 * @param v Value to Set.
	 */
	public void setSuffix(String v);

	/**
	 * @return Returns the fhir_humanName_suffix_id.
	 */
	public Integer getFhirHumannameSuffixId();
}
