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
 * Implementaci�n de la operaci�n GetFiles : 
 * @author FRAWA
 * @version 1.0
 */
public class GetFilesService extends GenGetFilesService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
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