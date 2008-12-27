//9d8e43d7dc2332fede646e831a67dde

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : RemoveFolderService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI.Path;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_req;
import org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_resp;

/**
 * Implementaci�n de la operaci�n RemoveFolder : 
 * @author FRAWA
 * @version 1.0
 */
public class RemoveFolderService extends GenRemoveFolderService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(RemoveFolder_req __inbean,RemoveFolder_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoStorageAPI model = AdvancedDocModel.getStorageAPI(context);
    	
    	// Invoke the model
    	Path path = CreateFolderService.buildPathObject(__inbean.getPath());
    	boolean result = model.removeFolder(path, __inbean.getFolder());
    	
    	// Output
		__outbean.setResult(result ? 1 : 0);
    }


}
