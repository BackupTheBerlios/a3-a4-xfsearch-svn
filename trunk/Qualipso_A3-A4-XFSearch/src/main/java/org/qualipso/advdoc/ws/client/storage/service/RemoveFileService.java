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
 * Implementación de la operación RemoveFile : 
 * @author FRAWA
 * @version 1.0
 */
public class RemoveFileService extends GenRemoveFileService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
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
