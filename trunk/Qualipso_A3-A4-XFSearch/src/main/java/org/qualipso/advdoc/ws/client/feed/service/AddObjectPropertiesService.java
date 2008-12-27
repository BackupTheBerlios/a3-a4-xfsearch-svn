//90a3fbc48a0b2d13f9d82e3a80ef7e

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : AddObjectPropertiesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.feed.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_req;
import org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_resp;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementaci�n de la operaci�n AddObjectProperties : 
 * @author FRAWA
 * @version 1.0
 */
public class AddObjectPropertiesService extends GenAddObjectPropertiesService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(AddObjectProperties_req __inbean,AddObjectProperties_resp __outbean,ServletContext context) throws Exception {
    	// Get the Feed API
    	QualiPSoFeedAPI model = AdvancedDocModel.getFeedAPI(context);
    	
    	// Invoke core API
    	Resource resource = model.getResourceByUri(__inbean.getResourceUri());
    	for (int i = 0;i < __inbean.objectProperties_size();i++) {
	    	Property property = model.getPropertyByUri(__inbean.getObjectProperties(i).getPropertyUri());
	    	Resource object = model.getResourceByUri(__inbean.getObjectProperties(i).getObjectUri());
	    	model.addProperty(resource, property, object);
    	}
    	
    	// Output
    	__outbean.setResourceUri(resource.getURI());
    }


}
