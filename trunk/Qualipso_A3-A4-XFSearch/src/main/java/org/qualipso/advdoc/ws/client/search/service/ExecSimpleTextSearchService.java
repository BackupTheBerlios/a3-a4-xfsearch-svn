//f2b7388d79431cf6ef16bca92c6bcf9

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : ExecSimpleTextSearchService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_resp;


import tdi.time.TdiChronometer;

/**
 * Implementación de la operación ExecSimpleTextSearch : Search RDF statements with text
 * @author FRAWA
 * @version 1.0
 */
public class ExecSimpleTextSearchService extends GenExecSimpleTextSearchService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(ExecSimpleTextSearch_req __inbean,ExecSimpleTextSearch_resp __outbean,ServletContext context) throws Exception {
    	
    	TdiChronometer crono = new TdiChronometer();
    	crono.start();
    	
    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
    	
    	// Invoke core API		
		SPARQLResultSet rs = model.execSimpleTextSearch(__inbean.getTextSearch());
		
		crono.pause();
		
		// Build the response
		ExecQueryService.buildResult(rs, crono, __outbean);
    }


}
