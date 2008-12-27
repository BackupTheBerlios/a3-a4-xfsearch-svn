//fb135621f573073d0fb73b7493b3a8

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : CreateFolderService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI.Path;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_req;
import org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_resp;
import org.qualipso.advdoc.ws.client.storage.beans.FolderPath;

/**
 * Implementaci�n de la operaci�n CreateFolder : 
 * @author FRAWA
 * @version 1.0
 */
public class CreateFolderService extends GenCreateFolderService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @param    context    Objeto context necesario en la operaci�n
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(CreateFolder_req __inbean,CreateFolder_resp __outbean,ServletContext context) throws Exception {
    	
    	// Get the Search API
    	QualiPSoStorageAPI model = AdvancedDocModel.getStorageAPI(context);
    	
    	// Invoke the model
    	Path path = buildPathObject(__inbean.getPath());
    	model.createPath(path);
    	boolean result = model.createFolder(path, __inbean.getFolder());
    	
    	// Output
		__outbean.setResult(result ? 1 : 0);
    	
    }
    
    static Path buildPathObject(FolderPath fPath) {
    	Path path = new Path();
    	for (int i = 0;i < fPath.folders_size();i++) {
    		path.addFolder(fPath.getFolders(i));
    	}
    	return path;
    }


}
