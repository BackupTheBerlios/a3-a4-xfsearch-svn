//e38630b27c366ddf85fa4caffbd0c3ad

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : RemoveFileService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI.Path;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_resp;

/**
 * Implementaci�n de la operaci�n RemoveFile : 
 * @author FRAWA
 * @version 1.0
 */
public class RemoveFileService extends GenRemoveFileService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(RemoveFile_req __inbean,RemoveFile_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoStorageAPI model = AdvancedDocModel.getStorageAPI(context);
    	
    	// Invoke the model
    	Path path = CreateFolderService.buildPathObject(__inbean.getPath());
    	boolean result = model.removeFile(path, __inbean.getFile());
    	
    	// Output
		__outbean.setResult(result ? 1 : 0);
    }


}
