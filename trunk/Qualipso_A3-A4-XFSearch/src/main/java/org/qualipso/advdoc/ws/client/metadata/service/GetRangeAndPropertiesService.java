//61f8c26e7f9a1c5f7be37fb9d72da259

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetRangeAndPropertiesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.ClassAndProperties;
import org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement;

import com.hp.hpl.jena.ontology.OntClass;

/**
 * Implementación de la operación GetRangeAndProperties : Get the range of a given property. It also gets the properties of each range class
 * @author FRAWA
 * @version 1.0
 */
public class GetRangeAndPropertiesService extends GenGetRangeAndPropertiesService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(GetRangeAndProperties_req __inbean,GetRangeAndProperties_resp __outbean,ServletContext context) throws Exception {

    	// Get the Metadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);

    	// Get the range of the property
    	ArrayList range = model.getPropertyRange(__inbean.getPropertyUri());
    	
    	// Get the properties for every range class
    	for (int i = 0;i < range.size();i++) {
    		OntClass cls = (OntClass)range.get(i);
    		ClassAndProperties cp = new ClassAndProperties();
    		String label = cls.getLabel("en");
    		if (label == null) {
        		label = cls.getLabel(null);
        		if (label == null) {
        			label = cls.getLocalName();
        		}
    		}
    		ResourceElement theClass = new ResourceElement(cls.getURI(),cls.getNameSpace(),cls.getLocalName(),label,cls.getComment(null));
    		cp.setTheClass(theClass);
    		// fill datatype properties
    		GetDatatypePropertiesService.fillDatatypeProperties(model, cls.getURI(), cp.getProperties().getDatatypeProperties());
    		// fill object properties
    		GetObjectPropertiesService.fillObjectProperties(model, cls.getURI(), cp.getProperties().getObjectProperties());
    		__outbean.addClasses(cp);
    	}
    }


}
