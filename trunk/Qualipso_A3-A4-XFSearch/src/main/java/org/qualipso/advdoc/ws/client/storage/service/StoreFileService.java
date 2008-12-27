//ce56259065f5159cd31547e32f771cc7

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : StoreFileService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI.Path;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.storage.beans.StoreFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.StoreFile_resp;

/**
 * Implementaci�n de la operaci�n StoreFile : 
 * @author FRAWA
 * @version 1.0
 */
public class StoreFileService extends GenStoreFileService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(StoreFile_req __inbean,StoreFile_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoStorageAPI model = AdvancedDocModel.getStorageAPI(context);

    	Path path = CreateFolderService.buildPathObject(__inbean.getPath());

    	// Create folder (if necessary)
    	model.createPath(path);
    	
    	// Invoke the model
    	boolean result = model.storeFile(path, __inbean.getFilename(), __inbean.getOverwrite() == 1, __inbean.getContents());
    	
    	// Output
		__outbean.setResult(result ? 1 : 0);
    }


}
