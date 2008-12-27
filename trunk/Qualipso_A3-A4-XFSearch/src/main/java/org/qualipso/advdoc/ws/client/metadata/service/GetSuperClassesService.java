//8dbc71b7cb4ee574987762d4423f5371

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetSuperClassesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.metadata.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement;

import com.hp.hpl.jena.ontology.OntClass;

/**
 * Implementaci�n de la operaci�n GetSuperClasses : Get superclasses of a given class
 * @author FRAWA
 * @version 1.0
 */
public class GetSuperClassesService extends GenGetSuperClassesService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(GetSuperClasses_req __inbean,GetSuperClasses_resp __outbean,ServletContext context) throws Exception {
    	// Get the Metadata API
    	QualiPSoMetadataAPI model = AdvancedDocModel.getMetadataAPI(context);
    	
    	// Invoke core API
    	ArrayList classes = model.getSuperClasses(__inbean.getClassUri(),__inbean.getDirect() == 1 ? true : false);
    	
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
    		__outbean.addSuperclasses(theClass);
    	}

    }


}
