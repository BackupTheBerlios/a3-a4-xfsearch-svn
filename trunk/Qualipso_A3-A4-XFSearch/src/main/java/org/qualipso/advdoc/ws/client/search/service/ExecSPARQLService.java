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
 * Implementación de la operación ExecSPARQL : Execute any SPARQL query on model
 * @author FRAWA
 * @version 1.0
 */
public class ExecSPARQLService extends GenExecSPARQLService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
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
