//47881c9b17cdda4b506236bb70b2461e

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : GetSearchSizeService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_req;
import org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_resp;

/**
 * Implementación de la operación GetSearchSize : Get the number of result of a search
 * @author FRAWA
 * @version 1.0
 */
public class GetSearchSizeService extends GenGetSearchSizeService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(GetSearchSize_req __inbean,GetSearchSize_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
    	
    	// Invoke core API
    	int n = model.getSearchSize(__inbean.getSearchText());
    	
    	// Output
		__outbean.setSize(n);
		__outbean.setSearchText(__inbean.getSearchText());
    }


}
