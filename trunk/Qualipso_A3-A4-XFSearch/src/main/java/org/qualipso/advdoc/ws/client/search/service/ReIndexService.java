//7fb413e7819211cd6d9dbec8c2be96ab

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : ReIndexService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.ReIndex_req;
import org.qualipso.advdoc.ws.client.search.beans.ReIndex_resp;

import tdi.time.TdiChronometer;

/**
 * Implementación de la operación ReIndex : Regenerate Lucene indexes
 * @author FRAWA
 * @version 1.0
 */
public class ReIndexService extends GenReIndexService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(ReIndex_req __inbean,ReIndex_resp __outbean,ServletContext context) throws Exception {
    	
    	TdiChronometer crono = new TdiChronometer();
    	crono.start();
    	
    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
    	
    	model.reindex();

    	crono.pause();
    	
    }


}
