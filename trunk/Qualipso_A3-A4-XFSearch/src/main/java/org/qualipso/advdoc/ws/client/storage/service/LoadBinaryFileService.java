//9180f1ac30f1d6fbf997edd7a232667

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : LoadBinaryFileService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI.Path;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_resp;

/**
 * Implementación de la operación LoadBinaryFile : 
 * @author FRAWA
 * @version 1.0
 */
public class LoadBinaryFileService extends GenLoadBinaryFileService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(LoadBinaryFile_req __inbean,LoadBinaryFile_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoStorageAPI model = AdvancedDocModel.getStorageAPI(context);
    	
    	// Invoke the model
    	Path path = CreateFolderService.buildPathObject(__inbean.getPath());
    	byte[] result = model.loadFile(path, __inbean.getFilename());
    	
    	// Output
		__outbean.setData(result);
    }


}
