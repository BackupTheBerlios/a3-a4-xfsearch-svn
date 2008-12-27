//67faaeceda5ac1fa164492519d57d096

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetSubFoldersService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI.Path;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_req;
import org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_resp;

/**
 * Implementación de la operación GetSubFolders : 
 * @author FRAWA
 * @version 1.0
 */
public class GetSubFoldersService extends GenGetSubFoldersService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(GetSubFolders_req __inbean,GetSubFolders_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoStorageAPI model = AdvancedDocModel.getStorageAPI(context);
    	
    	// Invoke the model
    	Path path = CreateFolderService.buildPathObject(__inbean.getPath());
    	String[] result = model.getSubFolders(path);
    	
    	// Output
		__outbean.setFolders(result);
    }


}
