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
 * Implementaci�n de la operaci�n AddLiteralProperties : 
 * @author FRAWA
 * @version 1.0
 */
public class AddLiteralPropertiesService extends GenAddLiteralPropertiesService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
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
