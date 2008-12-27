//15cc4fd6cd6fa6dcadc77c662b9b3ff

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetDisjointClassesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement;

import com.hp.hpl.jena.ontology.OntClass;

/**
 * Implementación de la operación GetDisjointClasses : Get disjoint classes to a given one
 * @author FRAWA
 * @version 1.0
 */
public class GetDisjointClassesService extends GenGetDisjointClassesService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(GetDisjointClasses_req __inbean,GetDisjointClasses_resp __outbean,ServletContext context) throws Exception {
    	// Get the Metadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);
    	
    	// Invoke core API
    	ArrayList classes = model.getDisjointClasses(__inbean.getClassUri());
    	
    	for (int i = 0;i < classes.size();i++) {
    		OntClass cls = (OntClass)classes.get(i);
    		String label = cls.getLabel("en");
    		if (label == null) {
        		label = cls.getLabel(null);
        		if (label == null) {
        			label = cls.getLocalName();
        		}
    		}
    		ResourceElement theClass = new ResourceElement(cls.getURI(),cls.getNameSpace(),cls.getLocalName(),label,cls.getComment(null));
    		__outbean.addDisjointClasses(theClass);
    	}

    }


}
