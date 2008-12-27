//58c79f6f80a450d9bc21aaad7393319

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : BuildSPARQLSearchService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req;
import org.qualipso.advdoc.ws.client.search.beans.Namespace;
import org.qualipso.advdoc.ws.client.search.beans.TextSearchCondition;


/**
 * Implementación de la operación BuildSPARQLSearch : Build a SPARQL query string from query components (including text search)
 * @author FRAWA
 * @version 1.0
 */
public class BuildSPARQLSearchService extends GenBuildSPARQLSearchService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(ExecSearch_req __inbean,BuildSPARQLSearch_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
    	
    	// Build the query
    	String query = buildSPARQL(model, __inbean);
    	
    	// Output
		__outbean.setSparql(query);
    }
    
    static String buildSPARQL(QualiPSoTextSearchAPI model,ExecSearch_req req) {
		if (req.textConditions_size() > 0) {
			req.addNamespaces(new Namespace("lucene",QualiPSoTextSearchAPI.SEARCH_NAMESPACE));
			for (int i = 0;i < req.textConditions_size();i++) {
				TextSearchCondition condition = req.getTextConditions(i);
				// create a text search condition
				req.addConditions("?"+condition.getVariable()+" lucene:"+QualiPSoTextSearchAPI.SEARCH_PROPERTY+" '"+condition.getTextSearch()+"'");
			}
		}
		
		String query = BuildSPARQLQueryService.buildSPARQL(model, req);
		
		return query;
    	
    }



}
