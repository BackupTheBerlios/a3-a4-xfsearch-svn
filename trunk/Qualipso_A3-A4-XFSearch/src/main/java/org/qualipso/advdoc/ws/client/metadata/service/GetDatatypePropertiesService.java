//a5fc9a5fd3a1322e495f1d9d137bdee

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetDatatypePropertiesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement;

import com.hp.hpl.jena.ontology.OntProperty;

/**
 * Implementaci�n de la operaci�n GetDatatypeProperties : Get all datatype properties of a given class
 * @author FRAWA
 * @version 1.0
 */
public class GetDatatypePropertiesService extends GenGetDatatypePropertiesService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(GetDatatypeProperties_req __inbean,GetDatatypeProperties_resp __outbean,ServletContext context) throws Exception {
    	// Get the Metadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);
    	
    	fillDatatypeProperties(model, __inbean.getClassUri(), __outbean);
    	
    }
    
    static void fillDatatypeProperties(QualiPSoMetadataAPI model,String classUri,GetDatatypeProperties_resp __outbean) {
    	// Invoke core API
    	ArrayList props = model.getDatatypeProperties(classUri);
    	
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
