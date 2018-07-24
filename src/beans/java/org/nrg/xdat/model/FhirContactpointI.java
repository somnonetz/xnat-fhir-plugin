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
public interface FhirContactpointI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

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
	 * @return Returns the use.
	 */
	public String getUse();

	/**
	 * Sets the value for use.
	 * @param v Value to Set.
	 */
	public void setUse(String v);

	/**
	 * @return Returns the rank.
	 */
	public Object getRank();

	/**
	 * Sets the value for rank.
	 * @param v Value to Set.
	 */
	public void setRank(Object v);

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
	 * @return Returns the fhir_contactPoint_id.
	 */
	public Integer getFhirContactpointId();
}
