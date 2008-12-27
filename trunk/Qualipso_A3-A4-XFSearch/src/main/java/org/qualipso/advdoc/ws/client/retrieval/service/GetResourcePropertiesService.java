//e245398b5ca230bf4711d1db4a27259e

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetResourcePropertiesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.retrieval.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoRetrievalAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_resp;
import org.qualipso.advdoc.ws.client.retrieval.beans.LiteralProperty;
import org.qualipso.advdoc.ws.client.retrieval.beans.ObjectProperty;

import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;

/**
 * Implementación del servicio GetResourceProperties : Get all properties of a given resource
 * @author quiles
 * @version 1.0
 */
public class GetResourcePropertiesService extends GenGetResourcePropertiesService {

    /**
     * Implementación del servicio
     * @param    __inbean    Parámetro de entrada al servicio: 
     * @param    __outbean    Parámetro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepción producida en la ejecución del servicio en la clase hija
     */
    public void execute(GetResourceProperties_req __inbean,GetResourceProperties_resp __outbean,ServletContext context) throws Exception {
    	// Get the Retrieval API
    	QualiPSoRetrievalAPI model = AdvancedDocModel.getRetrievalAPI(context);
    	
    	// Invoke core API
    	ArrayList properties = model.getResourceProperties(__inbean.getResourceUri());
    	
    	// Write properties URI in the output bean
    	for (int i = 0;i < properties.size();i++) {
    		Statement stmt = (com.hp.hpl.jena.rdf.model.Statement)properties.get(i);
    		
    		RDFNode node = stmt.getObject();
    		if (node instanceof Resource) {
    			Resource resource = (Resource)node;
    			ObjectProperty prop = new ObjectProperty();
    			prop.setObjectUri(resource.getURI());
    			prop.setPropertyUri(stmt.getPredicate().getURI());
    			__outbean.addObjectProperties(prop);
    		} else {
    			LiteralProperty prop = new LiteralProperty();
    			prop.setLiteral(node.toString());
    			prop.setPropertyUri(stmt.getPredicate().getURI());
    			__outbean.addLiteralProperties(prop);
    		}
    		
    	}

    }


}
