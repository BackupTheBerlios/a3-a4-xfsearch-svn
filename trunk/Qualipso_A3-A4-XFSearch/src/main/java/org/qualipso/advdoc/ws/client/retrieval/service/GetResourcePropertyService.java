//e1557d7642d79eaea26b0deae9a83fb

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetResourcePropertyService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.retrieval.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoRetrievalAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.retrieval.beans.LiteralProperty;
import org.qualipso.advdoc.ws.client.retrieval.beans.ObjectProperty;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_resp;

import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;

/**
 * Implementación del servicio GetResourceProperty : Get a property of a given resource
 * @author FRAWA
 * @version 1.0
 */
public class GetResourcePropertyService extends GenGetResourcePropertyService {

    /**
     * Implementación del servicio
     * @param    __inbean    Parámetro de entrada al servicio: 
     * @param    __outbean    Parámetro de salida del servicio: 
     * @param    context    Objeto context necesario en el servicio
     * @throws   Exception    Excepción producida en la ejecución del servicio en la clase hija
     */
    public void execute(GetResourceProperty_req __inbean,GetResourceProperty_resp __outbean,ServletContext context) throws Exception {
    	// Get the Retrieval API
    	QualiPSoRetrievalAPI model = AdvancedDocModel.getRetrievalAPI(context);
    	
    	// Invoke core API
    	ArrayList properties = model.getResourceProperty(__inbean.getResourceUri(),__inbean.getPropertyUri());
    	
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
