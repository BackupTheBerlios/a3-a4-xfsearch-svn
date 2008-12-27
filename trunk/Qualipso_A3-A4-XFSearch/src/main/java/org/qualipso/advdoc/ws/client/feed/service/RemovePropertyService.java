//8773094e28b3123438d4b2397779a4a

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : RemovePropertyService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.feed.service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_req;
import org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_resp;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementación del servicio RemoveProperty : Remove all sentences with a property for a given resource
 * @author FRAWA
 * @version 1.0
 */
public class RemovePropertyService extends GenRemovePropertyService {

    /**
     * Implementación del servicio
     * @param    __inbean    Parámetro de entrada al servicio: 
     * @param    __outbean    Parámetro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepción producida en la ejecución del servicio en la clase hija
     */
    public void execute(RemoveProperty_req __inbean,RemoveProperty_resp __outbean,ServletContext context) throws Exception {
    	// Get the Feed API
    	QualiPSoFeedAPI model = AdvancedDocModel.getFeedAPI(context);
    	
    	// Invoke core API
    	Resource resource = model.getResourceByUri(__inbean.getResourceUri());
    	Property property = model.getPropertyByUri(__inbean.getPropertyUri());
    	model.removeProperty(resource, property);
    	
    	// Output
    	__outbean.setResourceUri(resource.getURI());

    }


}
