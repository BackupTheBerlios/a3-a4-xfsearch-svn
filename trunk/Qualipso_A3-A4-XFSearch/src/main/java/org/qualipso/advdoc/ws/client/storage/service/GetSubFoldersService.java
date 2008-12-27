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
 * Implementaci�n de la operaci�n GetSubFolders : 
 * @author FRAWA
 * @version 1.0
 */
public class GetSubFoldersService extends GenGetSubFoldersService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
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
