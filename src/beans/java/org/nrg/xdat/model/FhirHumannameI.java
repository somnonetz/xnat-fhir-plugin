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
public interface FhirHumannameI {

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
	 * @return Returns the text.
	 */
	public String getText();

	/**
	 * Sets the value for text.
	 * @param v Value to Set.
	 */
	public void setText(String v);

	/**
	 * @return Returns the family.
	 */
	public String getFamily();

	/**
	 * Sets the value for family.
	 * @param v Value to Set.
	 */
	public void setFamily(String v);

	/**
	 * given
	 * @return Returns an List of org.nrg.xdat.model.FhirHumannameGivenI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameGivenI> List<A> getGiven();

	/**
	 * given
	 * @return Returns an List of org.nrg.xdat.model.FhirHumannameGivenI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameGivenI> void addGiven(A item) throws Exception;

	/**
	 * prefix
	 * @return Returns an List of org.nrg.xdat.model.FhirHumannamePrefixI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannamePrefixI> List<A> getPrefix();

	/**
	 * prefix
	 * @return Returns an List of org.nrg.xdat.model.FhirHumannamePrefixI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannamePrefixI> void addPrefix(A item) throws Exception;

	/**
	 * suffix
	 * @return Returns an List of org.nrg.xdat.model.FhirHumannameSuffixI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameSuffixI> List<A> getSuffix();

	/**
	 * suffix
	 * @return Returns an List of org.nrg.xdat.model.FhirHumannameSuffixI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameSuffixI> void addSuffix(A item) throws Exception;

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
	 * @return Returns the fhir_humanName_id.
	 */
	public Integer getFhirHumannameId();
}
