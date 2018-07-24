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
public interface FhirAddressI {

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
	 * @return Returns the text.
	 */
	public String getText();

	/**
	 * Sets the value for text.
	 * @param v Value to Set.
	 */
	public void setText(String v);

	/**
	 * line
	 * @return Returns an List of org.nrg.xdat.model.FhirAddressLineI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressLineI> List<A> getLine();

	/**
	 * line
	 * @return Returns an List of org.nrg.xdat.model.FhirAddressLineI
	 */
	public <A extends org.nrg.xdat.model.FhirAddressLineI> void addLine(A item) throws Exception;

	/**
	 * @return Returns the city.
	 */
	public String getCity();

	/**
	 * Sets the value for city.
	 * @param v Value to Set.
	 */
	public void setCity(String v);

	/**
	 * @return Returns the district.
	 */
	public String getDistrict();

	/**
	 * Sets the value for district.
	 * @param v Value to Set.
	 */
	public void setDistrict(String v);

	/**
	 * @return Returns the state.
	 */
	public String getState();

	/**
	 * Sets the value for state.
	 * @param v Value to Set.
	 */
	public void setState(String v);

	/**
	 * @return Returns the postalCode.
	 */
	public String getPostalcode();

	/**
	 * Sets the value for postalCode.
	 * @param v Value to Set.
	 */
	public void setPostalcode(String v);

	/**
	 * @return Returns the country.
	 */
	public String getCountry();

	/**
	 * Sets the value for country.
	 * @param v Value to Set.
	 */
	public void setCountry(String v);

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
	 * Sets the value for fhir:address/assigner_ID.
	 * @param v Value to Set.
	 */
	public void setAssignerId(Integer v) ;

	/**
	 * @return Returns the fhir_address_id.
	 */
	public Integer getFhirAddressId();
}
