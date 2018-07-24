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
public interface FhirHumannamePrefixI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the prefix.
	 */
	public String getPrefix();

	/**
	 * Sets the value for prefix.
	 * @param v Value to Set.
	 */
	public void setPrefix(String v);

	/**
	 * @return Returns the fhir_humanName_prefix_id.
	 */
	public Integer getFhirHumannamePrefixId();
}
