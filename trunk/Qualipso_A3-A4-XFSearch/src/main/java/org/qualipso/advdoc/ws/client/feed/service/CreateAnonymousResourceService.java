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
 * Implementaci�n de la operaci�n CreateAnonymousResource : Creates a new anonymous resource
 * @author FRAWA
 * @version 1.0
 */
public class CreateAnonymousResourceService extends GenCreateAnonymousResourceService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
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
