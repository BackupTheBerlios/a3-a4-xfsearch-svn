//76af9b8d59f86be64bcbd143252fe76f

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : SaveService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.feed.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.feed.beans.Save_req;
import org.qualipso.advdoc.ws.client.feed.beans.Save_resp;

/**
 * Implementación del servicio Save : Save data to permanent storage
 * @author FRAWA
 * @version 1.0
 */
public class SaveService extends GenSaveService {

    /**
     * Implementación del servicio
     * @param    __inbean    Parámetro de entrada al servicio: 
     * @param    __outbean    Parámetro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepción producida en la ejecución del servicio en la clase hija
     */
    public void execute(Save_req __inbean,Save_resp __outbean,ServletContext context) throws Exception {
    	
    	// Get the Feed API
    	QualiPSoFeedAPI model = AdvancedDocModel.getFeedAPI(context);
    	
    	// Invoke core API
    	model.save(__inbean.getFilename());
    	
    }


}
