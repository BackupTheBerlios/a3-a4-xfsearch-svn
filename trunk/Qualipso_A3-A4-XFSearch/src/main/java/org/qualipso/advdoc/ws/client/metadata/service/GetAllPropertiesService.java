//2cbd2e28d3a24dfd53537f5847189786

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetAllPropertiesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_resp;

import com.hp.hpl.jena.ontology.OntProperty;

/**
 * Implementación de la operación GetAllProperties : Get datatype and object properties of a given class
 * @author FRAWA
 * @version 1.0
 */
public class GetAllPropertiesService extends GenGetAllPropertiesService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(GetAllProperties_req __inbean,GetAllProperties_resp __outbean,ServletContext context) throws Exception {
    	
    	// Get the Metadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);

    	// DATATYPE PROPERTIES
    	GetDatatypePropertiesService.fillDatatypeProperties(model, __inbean.getClassUri(), __outbean.getDatatypeProperties());

    	// OBJECT PROPERTIES
    	GetObjectPropertiesService.fillObjectProperties(model, __inbean.getClassUri(), __outbean.getObjectProperties());

    }


}
