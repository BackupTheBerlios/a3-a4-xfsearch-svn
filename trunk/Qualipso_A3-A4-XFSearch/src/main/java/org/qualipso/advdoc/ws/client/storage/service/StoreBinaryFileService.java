//78e9fb6fe945545a776e27c7df9a50

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : StoreBinaryFileService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI.Path;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_resp;

/**
 * Implementación de la operación StoreBinaryFile : 
 * @author FRAWA
 * @version 1.0
 */
public class StoreBinaryFileService extends GenStoreBinaryFileService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(StoreBinaryFile_req __inbean,StoreBinaryFile_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoStorageAPI model = AdvancedDocModel.getStorageAPI(context);
    	
    	Path path = CreateFolderService.buildPathObject(__inbean.getPath());

    	// Create folder (if necessary)
    	model.createPath(path);
    	
    	// Invoke the model
    	boolean result = model.storeFile(path, __inbean.getFilename(), __inbean.getOverwrite() == 1, __inbean.getData());
    	
    	// Output
		__outbean.setResult(result ? 1 : 0);
    }


}
