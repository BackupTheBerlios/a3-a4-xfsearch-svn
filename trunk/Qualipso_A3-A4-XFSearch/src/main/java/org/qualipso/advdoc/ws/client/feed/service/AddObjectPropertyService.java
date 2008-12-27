//e22b344951cd31078e195d74cde6f9f

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : AddObjectPropertyService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.feed.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_req;
import org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_resp;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementación del servicio AddObjectProperty : Add an object property to an existing resource
 * @author FRAWA
 * @version 1.0
 */
public class AddObjectPropertyService extends GenAddObjectPropertyService {

    /**
     * Implementación del servicio
     * @param    __inbean    Parámetro de entrada al servicio: 
     * @param    __outbean    Parámetro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepción producida en la ejecución del servicio en la clase hija
     */
    public void execute(AddObjectProperty_req __inbean,AddObjectProperty_resp __outbean,ServletContext context) throws Exception {
    	// Get the Feed API
    	QualiPSoFeedAPI model = AdvancedDocModel.getFeedAPI(context);
    	
    	// Invoke core API
    	Resource resource = model.getResourceByUri(__inbean.getResourceUri());
    	Property property = model.getPropertyByUri(__inbean.getPropertyUri());
    	Resource object = model.getResourceByUri(__inbean.getObjectUri());
    	model.addProperty(resource, property, object);
    	
    	// Output
    	__outbean.setResourceUri(resource.getURI());

    }


}
