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
public interface FhirAttachementI {

	public String getXSIType();

	public void toXML(java.io.Writer writer) throws java.lang.Exception;

	/**
	 * @return Returns the contentType.
	 */
	public String getContenttype();

	/**
	 * Sets the value for contentType.
	 * @param v Value to Set.
	 */
	public void setContenttype(String v);

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
	 * @return Returns the data.
	 */
	public Object getData();

	/**
	 * Sets the value for data.
	 * @param v Value to Set.
	 */
	public void setData(Object v);

	/**
	 * @return Returns the url.
	 */
	public String getUrl();

	/**
	 * Sets the value for url.
	 * @param v Value to Set.
	 */
	public void setUrl(String v);

	/**
	 * @return Returns the size.
	 */
	public Object getSize();

	/**
	 * Sets the value for size.
	 * @param v Value to Set.
	 */
	public void setSize(Object v);

	/**
	 * @return Returns the hash.
	 */
	public Object getHash();

	/**
	 * Sets the value for hash.
	 * @param v Value to Set.
	 */
	public void setHash(Object v);

	/**
	 * @return Returns the title.
	 */
	public String getTitle();

	/**
	 * Sets the value for title.
	 * @param v Value to Set.
	 */
	public void setTitle(String v);

	/**
	 * @return Returns the creation.
	 */
	public Object getCreation();

	/**
	 * Sets the value for creation.
	 * @param v Value to Set.
	 */
	public void setCreation(Object v);

	/**
	 * @return Returns the fhir_attachement_id.
	 */
	public Integer getFhirAttachementId();
}
