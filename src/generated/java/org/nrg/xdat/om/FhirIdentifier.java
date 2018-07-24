/*
 * GENERATED FILE
 * Created on Tue Jul 24 17:16:36 CEST 2018
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
public class FhirIdentifier extends BaseFhirIdentifier {

	public FhirIdentifier(ItemI item)
	{
		super(item);
	}

	public FhirIdentifier(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use BaseFhirIdentifier(UserI user)
	 **/
	public FhirIdentifier()
	{}

	public FhirIdentifier(Hashtable properties, UserI user)
	{
		super(properties,user);
	}

}
