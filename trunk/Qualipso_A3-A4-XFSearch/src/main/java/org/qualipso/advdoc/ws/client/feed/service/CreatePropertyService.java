//88d6cf6c0838c9b4934636ee019fabe

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : CreatePropertyService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.feed.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_req;
import org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_resp;

import com.hp.hpl.jena.rdf.model.Property;

/**
 * Implementación de la operación CreateProperty : 
 * @author FRAWA
 * @version 1.0
 */
public class CreatePropertyService extends GenCreatePropertyService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(CreateProperty_req __inbean,CreateProperty_resp __outbean,ServletContext context) throws Exception {
    	// Get the Feed API
    	QualiPSoFeedAPI model = AdvancedDocModel.getFeedAPI(context);
    	
    	// Invoke core API
    	Property newProperty = model.createProperty(__inbean.getPropertyUri());
    	
    	// Output
    	__outbean.setPropertyUri(newProperty.getURI());
    }


}
