//12184151442a951a3f35cb71f7af2c1

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : AddLiteralPropertiesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.feed.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_req;
import org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_resp;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementación de la operación AddLiteralProperties : 
 * @author FRAWA
 * @version 1.0
 */
public class AddLiteralPropertiesService extends GenAddLiteralPropertiesService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(AddLiteralProperties_req __inbean,AddLiteralProperties_resp __outbean,ServletContext context) throws Exception {
    	// Get the Feed API
    	QualiPSoFeedAPI model = AdvancedDocModel.getFeedAPI(context);
    	
    	// Invoke core API
    	Resource resource = model.getResourceByUri(__inbean.getResourceUri());
    	for (int i = 0;i < __inbean.literalProperties_size();i++) {
    		Property property = model.getPropertyByUri(__inbean.getLiteralProperties(i).getPropertyUri());
    		model.addProperty(resource, property, __inbean.getLiteralProperties(i).getValue());
    	}
    	
    	// Output
    	__outbean.setResourceUri(resource.getURI());
    }


}
