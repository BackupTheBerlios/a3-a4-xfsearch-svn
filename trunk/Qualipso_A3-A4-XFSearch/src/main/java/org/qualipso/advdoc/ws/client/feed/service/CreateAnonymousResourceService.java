//97298762eb81a057474e5676de6840f4

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : CreateAnonymousResourceService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.feed.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_req;
import org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_resp;

import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementación de la operación CreateAnonymousResource : Creates a new anonymous resource
 * @author FRAWA
 * @version 1.0
 */
public class CreateAnonymousResourceService extends GenCreateAnonymousResourceService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(CreateAnonymousResource_req __inbean,CreateAnonymousResource_resp __outbean,ServletContext context) throws Exception {
    	// Get the Feed API
    	QualiPSoFeedAPI model = AdvancedDocModel.getFeedAPI(context);
    	
    	// Invoke core API
    	Resource newResource = model.createAnonymousResource();
    	
    	// Output
    	__outbean.setAnonymousId(newResource.getId().getLabelString());

    }


}
