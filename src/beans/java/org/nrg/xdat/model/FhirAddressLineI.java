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
public interface FhirAddressLineI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the line.
	 */
	public String getLine();

	/**
	 * Sets the value for line.
	 * @param v Value to Set.
	 */
	public void setLine(String v);

	/**
	 * @return Returns the fhir_address_line_id.
	 */
	public Integer getFhirAddressLineId();
}
