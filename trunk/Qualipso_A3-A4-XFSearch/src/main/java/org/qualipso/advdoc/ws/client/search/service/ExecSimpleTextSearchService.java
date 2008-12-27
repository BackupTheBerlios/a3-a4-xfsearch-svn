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
 * Implementaci�n de la operaci�n ExecSimpleTextSearch : Search RDF statements with text
 * @author FRAWA
 * @version 1.0
 */
public class ExecSimpleTextSearchService extends GenExecSimpleTextSearchService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
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
