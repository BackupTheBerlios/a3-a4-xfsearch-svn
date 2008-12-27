//ae3642db2fcfb7e5984d227f984db26

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetSubPropertiesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement;

import com.hp.hpl.jena.ontology.OntProperty;

/**
 * Implementación de la operación GetSubProperties : Get subproperties of a given property
 * @author FRAWA
 * @version 1.0
 */
public class GetSubPropertiesService extends GenGetSubPropertiesService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(GetSubProperties_req __inbean,GetSubProperties_resp __outbean,ServletContext context) throws Exception {
    	// Get the MEtadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);
    	
    	// Invoke core API
    	ArrayList properties = model.getSubProperties(__inbean.getPropertyUri(),__inbean.getDirect() == 1 ? true : false);
    	
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
    		__outbean.addSubproperties(property);
    	}
    }


}
