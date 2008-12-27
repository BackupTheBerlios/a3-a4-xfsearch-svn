//a85581e323b67e4dad7361d47fd3e88

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : CreateResourceService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.feed.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.feed.beans.CreateResource_req;
import org.qualipso.advdoc.ws.client.feed.beans.CreateResource_resp;

import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementaci�n del servicio CreateResource : Creates a new resource
 * @author FRAWA
 * @version 1.0
 */
public class CreateResourceService extends GenCreateResourceService {

    /**
     * Implementaci�n del servicio
     * @param    __inbean    Par�metro de entrada al servicio: 
     * @param    __outbean    Par�metro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepci�n producida en la ejecuci�n del servicio en la clase hija
     */
    public void execute(CreateResource_req __inbean,CreateResource_resp __outbean,ServletContext context) throws Exception {
    	// Get the Feed API
    	QualiPSoFeedAPI model = AdvancedDocModel.getFeedAPI(context);
    	
    	// Invoke core API
    	Resource newResource = model.createResource(__inbean.getResourceUri());
    	
    	// Output
    	__outbean.setResourceUri(newResource.getURI());

    }


}
