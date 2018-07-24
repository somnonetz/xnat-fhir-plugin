/*
 * GENERATED FILE
 * Created on Tue Jul 24 17:16:36 CEST 2018
 *
 */
package org.nrg.xdat.om.base;
import org.nrg.xdat.om.base.auto.*;
import org.nrg.xft.*;
import org.nrg.xft.security.UserI;

import java.util.*;

/**
 * @author XDAT
 *
 *//*
 ******************************** 
 * DO NOT MODIFY THIS FILE HERE
 *
 * TO MODIFY, COPY THIS FILE to src/main/java/org/nrg/xdat/om/base/ and modify it there 
 ********************************/
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class BaseFhirContactpoint extends AutoFhirContactpoint {

	public BaseFhirContactpoint(ItemI item)
	{
		super(item);
	}

	public BaseFhirContactpoint(UserI user)
	{
		super(user);
	}

	/*
	 * @deprecated Use BaseFhirContactpoint(UserI user)
	 **/
	public BaseFhirContactpoint()
	{}

	public BaseFhirContactpoint(Hashtable properties, UserI user)
	{
		super(properties,user);
	}

}
