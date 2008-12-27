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
 * Implementación de la operación RemoveFolder : 
 * @author FRAWA
 * @version 1.0
 */
public class RemoveFolderService extends GenRemoveFolderService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
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
