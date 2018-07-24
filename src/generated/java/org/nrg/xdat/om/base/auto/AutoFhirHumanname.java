/*
 * GENERATED FILE
 * Created on Tue Jul 24 14:20:58 CEST 2018
 *
 */
package org.nrg.xdat.om.base.auto;
import org.apache.log4j.Logger;
import org.nrg.xft.*;
import org.nrg.xft.security.UserI;
import org.nrg.xdat.om.*;
import org.nrg.xft.utils.ResourceFile;
import org.nrg.xft.exception.*;

import java.util.*;

/**
 * @author XDAT
 *
 *//*
 ******************************** 
 * DO NOT MODIFY THIS FILE
 *
 ********************************/
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class AutoFhirHumanname extends org.nrg.xdat.base.BaseElement implements org.nrg.xdat.model.FhirHumannameI {
	public static final Logger logger = Logger.getLogger(AutoFhirHumanname.class);
	public static final String SCHEMA_ELEMENT_NAME="fhir:humanName";

	public AutoFhirHumanname(ItemI item)
	{
		super(item);
	}

	public AutoFhirHumanname(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use AutoFhirHumanname(UserI user)
	 **/
	public AutoFhirHumanname(){}

	public AutoFhirHumanname(Hashtable properties,UserI user)
	{
		super(properties,user);
	}

	public String getSchemaElementName(){
		return "fhir:humanName";
	}

	//FIELD

	private String _Use=null;

	/**
	 * @return Returns the use.
	 */
	public String getUse(){
		try{
			if (_Use==null){
				_Use=getStringProperty("use");
				return _Use;
			}else {
				return _Use;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for use.
	 * @param v Value to Set.
	 */
	public void setUse(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/use",v);
		_Use=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Text=null;

	/**
	 * @return Returns the text.
	 */
	public String getText(){
		try{
			if (_Text==null){
				_Text=getStringProperty("text");
				return _Text;
			}else {
				return _Text;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for text.
	 * @param v Value to Set.
	 */
	public void setText(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/text",v);
		_Text=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private String _Family=null;

	/**
	 * @return Returns the family.
	 */
	public String getFamily(){
		try{
			if (_Family==null){
				_Family=getStringProperty("family");
				return _Family;
			}else {
				return _Family;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for family.
	 * @param v Value to Set.
	 */
	public void setFamily(String v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/family",v);
		_Family=null;
		} catch (Exception e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirHumannameGiven> _Given =null;

	/**
	 * given
	 * @return Returns an List of org.nrg.xdat.om.FhirHumannameGiven
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameGivenI> List<A> getGiven() {
		try{
			if (_Given==null){
				_Given=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("given"));
			}
			return (List<A>) _Given;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirHumannameGiven>();}
	}

	/**
	 * Sets the value for given.
	 * @param v Value to Set.
	 */
	public void setGiven(ItemI v) throws Exception{
		_Given =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/given",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/given",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * given
	 * Adds org.nrg.xdat.model.FhirHumannameGivenI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameGivenI> void addGiven(A item) throws Exception{
	setGiven((ItemI)item);
	}

	/**
	 * Removes the given of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeGiven(int index) throws java.lang.IndexOutOfBoundsException {
		_Given =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/given",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirHumannamePrefix> _Prefix =null;

	/**
	 * prefix
	 * @return Returns an List of org.nrg.xdat.om.FhirHumannamePrefix
	 */
	public <A extends org.nrg.xdat.model.FhirHumannamePrefixI> List<A> getPrefix() {
		try{
			if (_Prefix==null){
				_Prefix=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("prefix"));
			}
			return (List<A>) _Prefix;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirHumannamePrefix>();}
	}

	/**
	 * Sets the value for prefix.
	 * @param v Value to Set.
	 */
	public void setPrefix(ItemI v) throws Exception{
		_Prefix =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/prefix",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/prefix",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * prefix
	 * Adds org.nrg.xdat.model.FhirHumannamePrefixI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannamePrefixI> void addPrefix(A item) throws Exception{
	setPrefix((ItemI)item);
	}

	/**
	 * Removes the prefix of the given index.
	 * @param index Index of child to remove.
	 */
	public void removePrefix(int index) throws java.lang.IndexOutOfBoundsException {
		_Prefix =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/prefix",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}
	 private ArrayList<org.nrg.xdat.om.FhirHumannameSuffix> _Suffix =null;

	/**
	 * suffix
	 * @return Returns an List of org.nrg.xdat.om.FhirHumannameSuffix
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameSuffixI> List<A> getSuffix() {
		try{
			if (_Suffix==null){
				_Suffix=org.nrg.xdat.base.BaseElement.WrapItems(getChildItems("suffix"));
			}
			return (List<A>) _Suffix;
		} catch (Exception e1) {return (List<A>) new ArrayList<org.nrg.xdat.om.FhirHumannameSuffix>();}
	}

	/**
	 * Sets the value for suffix.
	 * @param v Value to Set.
	 */
	public void setSuffix(ItemI v) throws Exception{
		_Suffix =null;
		try{
			if (v instanceof XFTItem)
			{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/suffix",v,true);
			}else{
				getItem().setChild(SCHEMA_ELEMENT_NAME + "/suffix",v.getItem(),true);
			}
		} catch (Exception e1) {logger.error(e1);throw e1;}
	}

	/**
	 * suffix
	 * Adds org.nrg.xdat.model.FhirHumannameSuffixI
	 */
	public <A extends org.nrg.xdat.model.FhirHumannameSuffixI> void addSuffix(A item) throws Exception{
	setSuffix((ItemI)item);
	}

	/**
	 * Removes the suffix of the given index.
	 * @param index Index of child to remove.
	 */
	public void removeSuffix(int index) throws java.lang.IndexOutOfBoundsException {
		_Suffix =null;
		try{
			getItem().removeChild(SCHEMA_ELEMENT_NAME + "/suffix",index);
		} catch (FieldNotFoundException e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Period_start=null;

	/**
	 * @return Returns the period/start.
	 */
	public Object getPeriod_start(){
		try{
			if (_Period_start==null){
				_Period_start=getProperty("period/start");
				return _Period_start;
			}else {
				return _Period_start;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for period/start.
	 * @param v Value to Set.
	 */
	public void setPeriod_start(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/period/start",v);
		_Period_start=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Object _Period_end=null;

	/**
	 * @return Returns the period/end.
	 */
	public Object getPeriod_end(){
		try{
			if (_Period_end==null){
				_Period_end=getProperty("period/end");
				return _Period_end;
			}else {
				return _Period_end;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for period/end.
	 * @param v Value to Set.
	 */
	public void setPeriod_end(Object v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/period/end",v);
		_Period_end=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	//FIELD

	private Integer _FhirHumannameId=null;

	/**
	 * @return Returns the fhir_humanName_id.
	 */
	public Integer getFhirHumannameId() {
		try{
			if (_FhirHumannameId==null){
				_FhirHumannameId=getIntegerProperty("fhir_humanName_id");
				return _FhirHumannameId;
			}else {
				return _FhirHumannameId;
			}
		} catch (Exception e1) {logger.error(e1);return null;}
	}

	/**
	 * Sets the value for fhir_humanName_id.
	 * @param v Value to Set.
	 */
	public void setFhirHumannameId(Integer v){
		try{
		setProperty(SCHEMA_ELEMENT_NAME + "/fhir_humanName_id",v);
		_FhirHumannameId=null;
		} catch (Exception e1) {logger.error(e1);}
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumanname> getAllFhirHumannames(org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumanname> al = new ArrayList<org.nrg.xdat.om.FhirHumanname>();

		try{
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetAllItems(SCHEMA_ELEMENT_NAME,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumanname> getFhirHumannamesByField(String xmlPath, Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumanname> al = new ArrayList<org.nrg.xdat.om.FhirHumanname>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(xmlPath,value,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static ArrayList<org.nrg.xdat.om.FhirHumanname> getFhirHumannamesByField(org.nrg.xft.search.CriteriaCollection criteria, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		ArrayList<org.nrg.xdat.om.FhirHumanname> al = new ArrayList<org.nrg.xdat.om.FhirHumanname>();
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems(criteria,user,preLoad);
			al = org.nrg.xdat.base.BaseElement.WrapItems(items.getItems());
		} catch (Exception e) {
			logger.error("",e);
		}

		al.trimToSize();
		return al;
	}

	public static FhirHumanname getFhirHumannamesByFhirHumannameId(Object value, org.nrg.xft.security.UserI user,boolean preLoad)
	{
		try {
			org.nrg.xft.collections.ItemCollection items = org.nrg.xft.search.ItemSearch.GetItems("fhir:humanName/fhir_humanName_id",value,user,preLoad);
			ItemI match = items.getFirst();
			if (match!=null)
				return (FhirHumanname) org.nrg.xdat.base.BaseElement.GetGeneratedItem(match);
			else
				 return null;
		} catch (Exception e) {
			logger.error("",e);
		}

		return null;
	}

	public static ArrayList wrapItems(ArrayList items)
	{
		ArrayList al = new ArrayList();
		al = org.nrg.xdat.base.BaseElement.WrapItems(items);
		al.trimToSize();
		return al;
	}

	public static ArrayList wrapItems(org.nrg.xft.collections.ItemCollection items)
	{
		return wrapItems(items.getItems());
	}
	public ArrayList<ResourceFile> getFileResources(String rootPath, boolean preventLoop){
ArrayList<ResourceFile> _return = new ArrayList<ResourceFile>();
	 boolean localLoop = preventLoop;
	        localLoop = preventLoop;
	
	        //given
	        for(org.nrg.xdat.model.FhirHumannameGivenI childGiven : this.getGiven()){
	            if (childGiven!=null){
	              for(ResourceFile rf: ((FhirHumannameGiven)childGiven).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("given[" + ((FhirHumannameGiven)childGiven).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("given/" + ((FhirHumannameGiven)childGiven).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	        //prefix
	        for(org.nrg.xdat.model.FhirHumannamePrefixI childPrefix : this.getPrefix()){
	            if (childPrefix!=null){
	              for(ResourceFile rf: ((FhirHumannamePrefix)childPrefix).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("prefix[" + ((FhirHumannamePrefix)childPrefix).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("prefix/" + ((FhirHumannamePrefix)childPrefix).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	        //suffix
	        for(org.nrg.xdat.model.FhirHumannameSuffixI childSuffix : this.getSuffix()){
	            if (childSuffix!=null){
	              for(ResourceFile rf: ((FhirHumannameSuffix)childSuffix).getFileResources(rootPath, localLoop)) {
	                 rf.setXpath("suffix[" + ((FhirHumannameSuffix)childSuffix).getItem().getPKString() + "]/" + rf.getXpath());
	                 rf.setXdatPath("suffix/" + ((FhirHumannameSuffix)childSuffix).getItem().getPKString() + "/" + rf.getXpath());
	                 _return.add(rf);
	              }
	            }
	        }
	
	        localLoop = preventLoop;
	
	return _return;
}
}
