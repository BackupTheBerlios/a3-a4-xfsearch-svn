//3a353d2d9711dcc523df8c4578edfd9f

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetResourcesWithPropertyService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.retrieval.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoRetrievalAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_resp;


import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementaci�n del servicio GetResourcesWithProperty : Get all resources with a given property
 * @author FRAWA
 * @version 1.0
 */
public class GetResourcesWithPropertyService extends GenGetResourcesWithPropertyService {

    /**
     * Implementaci�n del servicio
     * @param    __inbean    Par�metro de entrada al servicio: 
     * @param    __outbean    Par�metro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepci�n producida en la ejecuci�n del servicio en la clase hija
     */
    public void execute(GetResourcesWithProperty_req __inbean,GetResourcesWithProperty_resp __outbean,ServletContext context) throws Exception {
    	// Get the Retrieval API
    	QualiPSoRetrievalAPI model = AdvancedDocModel.getRetrievalAPI(context);
    	
    	// Invoke core API
    	ArrayList resources = model.getResourcesWithProperty(__inbean.getPropertyUri());
    	
    	// Write properties URI in the output bean
    	for (int i = 0;i < resources.size();i++) {
    		
    		Resource res = (Resource)resources.get(i);
    		
    		__outbean.addResourcesUri(res.getURI());
    	}
    }


}
