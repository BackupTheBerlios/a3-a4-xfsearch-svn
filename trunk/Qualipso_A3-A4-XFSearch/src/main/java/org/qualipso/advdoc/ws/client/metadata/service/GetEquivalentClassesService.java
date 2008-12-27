//190e6984bda841f10d21816677320a0

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetEquivalentClassesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement;

import com.hp.hpl.jena.ontology.OntClass;

/**
 * Implementaci�n de la operaci�n GetEquivalentClasses : Get equivalent classes to a given one
 * @author FRAWA
 * @version 1.0
 */
public class GetEquivalentClassesService extends GenGetEquivalentClassesService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(GetEquivalentClasses_req __inbean,GetEquivalentClasses_resp __outbean,ServletContext context) throws Exception {
    	// Get the Metadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);
    	
    	// Invoke core API
    	ArrayList classes = model.getEquivalentClasses(__inbean.getClassUri());
    	
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
    		__outbean.addEquivalentClasses(theClass);
    	}
    }


}
