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
 * Implementaci�n de la operaci�n ReIndex : Regenerate Lucene indexes
 * @author FRAWA
 * @version 1.0
 */
public class ReIndexService extends GenReIndexService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
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
