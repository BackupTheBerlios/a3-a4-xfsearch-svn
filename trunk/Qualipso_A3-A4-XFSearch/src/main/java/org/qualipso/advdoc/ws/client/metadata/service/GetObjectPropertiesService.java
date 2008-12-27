//f5ce0cc5dd6a6f3ff863d63888be7b

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetObjectPropertiesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement;

import com.hp.hpl.jena.ontology.OntProperty;

/**
 * Implementaci�n de la operaci�n GetObjectProperties : Get all object properties of a given class
 * @author FRAWA
 * @version 1.0
 */
public class GetObjectPropertiesService extends GenGetObjectPropertiesService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(GetObjectProperties_req __inbean,GetObjectProperties_resp __outbean,ServletContext context) throws Exception {
    	// Get the MEtadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);

    	fillObjectProperties(model, __inbean.getClassUri(), __outbean);
    }

    static void fillObjectProperties(QualiPSoMetadataAPI model,String classUri,GetObjectProperties_resp __outbean) {
    	// Invoke core API
    	ArrayList props = model.getObjectProperties(classUri);
    	
    	for (int i = 0;i < props.size();i++) {
    		OntProperty prop = (OntProperty)props.get(i);
    		String label = prop.getLabel("en");
    		if (label == null) {
        		label = prop.getLabel(null);
        		if (label == null) {
        			label = prop.getLocalName();
        		}
    		}
    		ResourceElement property = new ResourceElement(prop.getURI(),prop.getNameSpace(),prop.getLocalName(),label,prop.getComment(null));
    		__outbean.addProperties(property);
    	}        	
    }

}
