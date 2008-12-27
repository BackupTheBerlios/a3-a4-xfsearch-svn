//e539bb1bdaf8a7e44ad059a69344ad5a

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : ExecSearchService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecSearch_resp;
import org.qualipso.advdoc.ws.client.search.beans.Namespace;
import org.qualipso.advdoc.ws.client.search.beans.TextSearchCondition;

import tdi.time.TdiChronometer;

/**
 * Implementaci�n de la operaci�n ExecSearch : xecute a query on RDF model (it can include text search). It builds the SPARQL sentence from parameters
 * @author FRAWA
 * @version 1.0
 */
public class ExecSearchService extends GenExecSearchService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(ExecSearch_req __inbean,ExecSearch_resp __outbean,ServletContext context) throws Exception {

    	TdiChronometer crono = new TdiChronometer();
    	crono.start();

    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);

    	// Build query
    	String query = BuildSPARQLSearchService.buildSPARQL(model, __inbean);
    	
    	// Invoke core API
    	SPARQLResultSet rs = model.execSPARQL(query);

    	crono.pause();
    	
    	// Build the response
    	ExecQueryService.buildResult(rs, crono, __outbean);
		    	
    }



}
