//2c19143a93b7824e2807eee81825514

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetInstancesForObjectPropertyService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.ClassAndProperties;
import org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_resp;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Implementaci�n de la operaci�n GetInstancesForObjectProperty : Get all possible instances for a given object property
 * @author FRAWA
 * @version 1.0
 */
public class GetInstancesForObjectPropertyService extends GenGetInstancesForObjectPropertyService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(GetInstancesForObjectProperty_req __inbean,GetInstancesForObjectProperty_resp __outbean,ServletContext context) throws Exception {

    	// Get the Metadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);

    	// Get the range of the property
    	ArrayList range = model.getPropertyRange(__inbean.getPropertyURI());
    	
    	// Get the instances for every range class
    	for (int i = 0;i < range.size();i++) {
    		OntClass cls = (OntClass)range.get(i);
        	ArrayList resources = model.getResourcesByType(cls.getURI());
        	
        	// Write instances URI in the output bean
        	for (int j = 0;j < resources.size();j++) {
        		Resource resource = (Resource)resources.get(j);
        		__outbean.addInstanceURIs(resource.getURI());
        	}
    	}
    	
    }


}
