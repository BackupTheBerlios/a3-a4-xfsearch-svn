//c182a9c4494976a3b1cbab99c9a1c23c

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetResourcesWithPropertyValueService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.retrieval.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoRetrievalAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_resp;

import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementación del servicio GetResourcesWithPropertyValue : Get resources with a property with a given value
 * @author FRAWA
 * @version 1.0
 */
public class GetResourcesWithPropertyValueService extends GenGetResourcesWithPropertyValueService {

    /**
     * Implementación del servicio
     * @param    __inbean    Parámetro de entrada al servicio: 
     * @param    __outbean    Parámetro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepción producida en la ejecución del servicio en la clase hija
     */
    public void execute(GetResourcesWithPropertyValue_req __inbean,GetResourcesWithPropertyValue_resp __outbean,ServletContext context) throws Exception {
    	
    	// Get the Retrieval API
    	QualiPSoRetrievalAPI model = AdvancedDocModel.getRetrievalAPI(context);
    	
    	// Invoke core API
    	ArrayList resources = model.getResourcesWithPropertyValue(__inbean.getPropertyUri(),__inbean.getValue());
    	
    	// Write properties URI in the output bean
    	for (int i = 0;i < resources.size();i++) {
    		
    		Resource res = (Resource)resources.get(i);
    		
    		__outbean.addResourcesUri(res.getURI());
    	}

    	
    }


}
