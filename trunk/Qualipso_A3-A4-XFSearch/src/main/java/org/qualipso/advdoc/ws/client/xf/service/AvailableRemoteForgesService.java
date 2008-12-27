//5f29f3afea8e24a4ba7d5fe32ef8097

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetForgeListService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.xf.service;

import java.util.StringTokenizer;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qualipso.advdoc.ws.client.xf.beans.Forge;
import org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_req;
import org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_resp;
import org.qualipso.interop.semantics.xfsearch.utils.XFSearchProperties;

/*******************************************************************************
 * Copyright (c) 2007 ATOS Origin SAE, Telefónica I+D
 * All rights reserved. This software and the accompanying materials
 * are made available under the terms of the LGPL v1.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/copyleft/lesser.html
 *
 * Contributors:
 *     @author Jesus Gorroñogoitia, jesus.gorronogoitia@atosresearch.eu ATOS Origin SAE -
 *     @author Jesus Martin, Origin SAE -
 *     @author Jose Antonio Quiles, Telefónica I+D -
 *     @author Skeleton automatically generated with FRAWA
 *     @version 1.0
 *     
 *******************************************************************************/


/**
 * This service retrieves the list of available forges within to perform the cross-forge
 * semantic search
 */
public class AvailableRemoteForgesService extends GenGetForgeListService {

	private Log log = LogFactory.getLog(AvailableRemoteForgesService.class);	
	
    /**
     * It retrieves the list of available forges
     * @param    __inbean    Input parameter (empty in this operation)  
     * @param    __outbean    Output parameter (it contains a String[] object with available forges Ids) 
     * @param    context    Operation context
     * @throws   Exception    Exception throw by this service during its execution in case of exceptiona situation
     */
    public void execute(GetForgeList_req __inbean,GetForgeList_resp __outbean,ServletContext context) throws Exception {
    	XFSearchProperties xfSearchProperties = XFSearchProperties.getInstance();
    	StringTokenizer st = new StringTokenizer (xfSearchProperties.getValuesFromFirtPartOfKey("forges.list")[0], ",");
    	String[] forges = new String[st.countTokens()];
    	int i=0;
    	while (st.hasMoreTokens()){
    		forges[i++] = st.nextToken();
    	}
    	
    	if (forges==null || forges.length==0){
    		log.error("There is no any forges.list key in xfsearch.properties");
    		throw new Exception("It was no possible to determine the list of Forges for Cross Forge Search");
    	}
    		
    	for (i=0; i< forges.length; i++){
    		__outbean.addForges(new Forge(forges[i]));
    	}    	
    }
}
