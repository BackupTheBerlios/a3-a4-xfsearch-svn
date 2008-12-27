//cddf10726e2637a2465c8d2fdd58ed

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetSuperPropertiesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement;

import com.hp.hpl.jena.ontology.OntProperty;

/**
 * Implementación de la operación GetSuperProperties : Get superproperties of a given property
 * @author FRAWA
 * @version 1.0
 */
public class GetSuperPropertiesService extends GenGetSuperPropertiesService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(GetSuperProperties_req __inbean,GetSuperProperties_resp __outbean,ServletContext context) throws Exception {
    	// Get the MEtadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);
    	
    	// Invoke core API
    	ArrayList properties = model.getSuperProperties(__inbean.getPropertyUri(),__inbean.getDirect() == 1 ? true : false);
    	
    	for (int i = 0;i < properties.size();i++) {
    		OntProperty prop = (OntProperty)properties.get(i);
    		String label = prop.getLabel("en");
    		if (label == null) {
        		label = prop.getLabel(null);
        		if (label == null) {
        			label = prop.getLocalName();
        		}
    		}
    		ResourceElement property = new ResourceElement(prop.getURI(),prop.getNameSpace(),prop.getLocalName(),label,prop.getComment(null));
    		__outbean.addSuperproperties(property);
    	}
    }


}
