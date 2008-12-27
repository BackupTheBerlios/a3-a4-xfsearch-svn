//d1a7d189e52774acfb4e4a28ceb58c87

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : ExecSPARQLService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_resp;

import tdi.time.TdiChronometer;

/**
 * Implementaci�n de la operaci�n ExecSPARQL : Execute any SPARQL query on model
 * @author FRAWA
 * @version 1.0
 */
public class ExecSPARQLService extends GenExecSPARQLService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(ExecSPARQL_req __inbean,ExecSPARQL_resp __outbean,ServletContext context) throws Exception {
    	TdiChronometer crono = new TdiChronometer();
    	crono.start();
    	
    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
    	
    	// Invoke core API		
		SPARQLResultSet rs = model.execSPARQL(__inbean.getSparql());
		
		crono.pause();
		
		// Build the response
		ExecQueryService.buildResult(rs, crono, __outbean);
    }


}
