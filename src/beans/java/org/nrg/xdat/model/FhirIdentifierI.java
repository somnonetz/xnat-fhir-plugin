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
public interface FhirIdentifierI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the use.
	 */
	public String getUse();

	/**
	 * Sets the value for use.
	 * @param v Value to Set.
	 */
	public void setUse(String v);

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
	 * @return Returns the system.
	 */
	public String getSystem();

	/**
	 * Sets the value for system.
	 * @param v Value to Set.
	 */
	public void setSystem(String v);

	/**
	 * @return Returns the value.
	 */
	public String getValue();

	/**
	 * Sets the value for value.
	 * @param v Value to Set.
	 */
	public void setValue(String v);

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
	 * @return Returns the assigner_ID.
	 */
	public Integer getAssignerId();

	/**
	 * Sets the value for fhir:identifier/assigner_ID.
	 * @param v Value to Set.
	 */
	public void setAssignerId(Integer v) ;

	/**
	 * @return Returns the fhir_identifier_id.
	 */
	public Integer getFhirIdentifierId();
}
