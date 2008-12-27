//69cc6dbbcbb43b661283d215dae65579

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : LoadFileService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI.Path;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.storage.beans.LoadFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.LoadFile_resp;

/**
 * Implementación de la operación LoadFile : 
 * @author FRAWA
 * @version 1.0
 */
public class LoadFileService extends GenLoadFileService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(LoadFile_req __inbean,LoadFile_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoStorageAPI model = AdvancedDocModel.getStorageAPI(context);
    	
    	// Invoke the model
    	Path path = CreateFolderService.buildPathObject(__inbean.getPath());
    	String result = model.loadTextFile(path, __inbean.getFilename());
    	
    	// Output
		__outbean.setContents(result);
    }


}
