//f1df4879ccb57fddc11bdc1367cbd49d

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : ExecConstructAndSearchService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

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

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_resp;

import tdi.time.TdiChronometer;

/**
 * This service performs a heterogeneous semantic search in a remote forge, by adapting its 
 * internal information schema (ontologies) and data (knowledge base) with an appropriate 
 * semantic mapping
 */
public class MappedSearchService extends GenExecConstructAndSearchService {

    /**
     * It performs the heterogeneous semantic search in a remote forge
     * @param    __inbean    Input parameter (it contains a String object with the semantic mapping 
     * and another String object with the semantic query )  
     * @param    __outbean    Output parameter (it contains a ResultSet[] object with the obtained results) 
     * @param    context    Operation context
     * @throws   Exception    Exception throw by this service during its execution in case of exceptiona situation
     */
    public void execute(ExecConstructAndSearch_req __inbean,ExecConstructAndSearch_resp __outbean,ServletContext context) throws Exception {
    	TdiChronometer crono = new TdiChronometer();
    	crono.start();
    	
    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
    	
    	// Invoke core API		
//		SPARQLResultSet rs = model.execSPARQLConstructAndSelect(__inbean.getConstruct(), __inbean.getSparql());
		SPARQLResultSet rs = model.execMappedSPARQL(__inbean.getConstruct(), __inbean.getSparql());
		
		crono.pause();
		
		// Build the response
		ExecQueryService.buildResult(rs, crono, __outbean);
    }
}
