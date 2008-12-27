//c739bd6d2cb8ae918139aea2a9a3f

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetResourcesByTypeService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.retrieval.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoRetrievalAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_resp;

import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementación del servicio GetResourcesByType : Get all resources of a given type or class
 * @author quiles
 * @version 1.0
 */
public class GetResourcesByTypeService extends GenGetResourcesByTypeService {

    /**
     * Implementación del servicio
     * @param    __inbean    Parámetro de entrada al servicio: 
     * @param    __outbean    Parámetro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepción producida en la ejecución del servicio en la clase hija
     */
    public void execute(GetResourcesByType_req __inbean,GetResourcesByType_resp __outbean,ServletContext context) throws Exception {

    	// Get the Retrieval API
    	QualiPSoRetrievalAPI model = AdvancedDocModel.getRetrievalAPI(context);
    	
    	// Invoke core API
    	ArrayList resources = model.getResourcesByType(__inbean.getTypeUri());
    	
    	// Write instances URI in the output bean
    	for (int i = 0;i < resources.size();i++) {
    		Resource resource = (Resource)resources.get(i);
    		__outbean.addResources(resource.getURI());
    	}
    
    }


}
