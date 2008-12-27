//8025359793d8bea8c9551ea726fe3a4

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetPropertyRangeService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement;

import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementación de la operación GetPropertyRange : Get the range of a given property
 * @author FRAWA
 * @version 1.0
 */
public class GetPropertyRangeService extends GenGetPropertyRangeService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(GetPropertyRange_req __inbean,GetPropertyRange_resp __outbean,ServletContext context) throws Exception {
    	// Get the Metadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);
    	
    	// Invoke core API
    	ArrayList props = model.getPropertyRange(__inbean.getPropertyUri());
    	
    	for (int i = 0;i < props.size();i++) {
    		OntResource cls = (OntResource)props.get(i);
    		String label = cls.getLabel("en");
    		if (label == null) {
        		label = cls.getLabel(null);
        		if (label == null) {
        			label = cls.getLocalName();
        		}
    		}
    		ResourceElement theClass = new ResourceElement(cls.getURI(),cls.getNameSpace(),cls.getLocalName(),label,cls.getComment(null));
    		__outbean.addClasses(theClass);
    	}    

    }


}
