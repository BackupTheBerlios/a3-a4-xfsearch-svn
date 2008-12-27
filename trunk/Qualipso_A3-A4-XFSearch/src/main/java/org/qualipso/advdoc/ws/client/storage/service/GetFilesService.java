//eb7c52d6efe38cdbfb392bdcaea3b5e

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetFilesService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI.Path;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.storage.beans.GetFiles_req;
import org.qualipso.advdoc.ws.client.storage.beans.GetFiles_resp;

/**
 * Implementación de la operación GetFiles : 
 * @author FRAWA
 * @version 1.0
 */
public class GetFilesService extends GenGetFilesService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(GetFiles_req __inbean,GetFiles_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoStorageAPI model = AdvancedDocModel.getStorageAPI(context);
    	
    	// Invoke the model
    	Path path = CreateFolderService.buildPathObject(__inbean.getPath());
    	String[] result = model.getFiles(path,__inbean.getFilter());
    	
    	// Output
		__outbean.setFiles(result);
    }


}
