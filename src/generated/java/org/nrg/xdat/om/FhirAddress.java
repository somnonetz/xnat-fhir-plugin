/*
 * GENERATED FILE
 * Created on Tue Jul 24 14:20:58 CEST 2018
 *
 */
package org.nrg.xdat.om;
import org.nrg.xft.*;
import org.nrg.xdat.om.base.*;
import org.nrg.xft.security.UserI;

import java.util.*;

/**
 * @author XDAT
 *
 *//*
 ******************************** 
 * DO NOT MODIFY THIS FILE HERE
 *
 * TO MODIFY, COPY THIS FILE to src/main/java/org/nrg/xdat/om/ and modify it there 
 ********************************/
@SuppressWarnings({"unchecked","rawtypes"})
public class FhirAddress extends BaseFhirAddress {

	public FhirAddress(ItemI item)
	{
		super(item);
	}

	public FhirAddress(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use BaseFhirAddress(UserI user)
	 **/
	public FhirAddress()
	{}

	public FhirAddress(Hashtable properties, UserI user)
	{
		super(properties,user);
	}

}
