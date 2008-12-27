//d044ef42232e162b18e44e643b45d4c8

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : AddLiteralPropertyService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.feed.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_req;
import org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_resp;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementación del servicio AddLiteralProperty : Add a literal property to an existing resource
 * @author FRAWA
 * @version 1.0
 */
public class AddLiteralPropertyService extends GenAddLiteralPropertyService {

    /**
     * Implementación del servicio
     * @param    __inbean    Parámetro de entrada al servicio: 
     * @param    __outbean    Parámetro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepción producida en la ejecución del servicio en la clase hija
     */
    public void execute(AddLiteralProperty_req __inbean,AddLiteralProperty_resp __outbean,ServletContext context) throws Exception {
    	// Get the Feed API
    	QualiPSoFeedAPI model = AdvancedDocModel.getFeedAPI(context);
    	
    	// Invoke core API
    	Resource resource = model.getResourceByUri(__inbean.getResourceUri());
    	Property property = model.getPropertyByUri(__inbean.getPropertyUri());
    	model.addProperty(resource, property, __inbean.getValue());
    	
    	// Output
    	__outbean.setResourceUri(resource.getURI());
    }


}
