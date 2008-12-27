//69a4329744740aeed9d078dc553859

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : ExecAskService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import org.qualipso.advdoc.coreapi.model.QualiPSoQueryAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.ExecAsk_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecAsk_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req;
import org.qualipso.advdoc.ws.client.search.beans.Namespace;
import org.qualipso.advdoc.ws.client.search.beans.TextSearchCondition;

/**
 * Implementación de la operación ExecAsk : 
 * @author FRAWA
 * @version 1.0
 */
public class ExecAskService extends GenExecAskService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(ExecAsk_req __inbean,ExecAsk_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
    	
    	// Build the query
    	String query = buildSPARQLAsk(model, __inbean);
    	
    	// Invoke core API		
		boolean result = model.execSPARQLAsk(query);
		
		// Result
		__outbean.setResult(result ? 1 : 0);
    }
    
    static String buildSPARQLAsk(QualiPSoQueryAPI model,ExecAsk_req req) {

		if (req.textConditions_size() > 0) {
			req.addNamespaces(new Namespace("lucene",QualiPSoTextSearchAPI.SEARCH_NAMESPACE));
			for (int i = 0;i < req.textConditions_size();i++) {
				TextSearchCondition condition = req.getTextConditions(i);
				// create a text search condition
				req.addConditions("?"+condition.getVariable()+" lucene:"+QualiPSoTextSearchAPI.SEARCH_PROPERTY+" '"+condition.getTextSearch()+"'");
			}
		}
    	
    	ArrayList prefixes = new ArrayList();
		ArrayList namespaces = new ArrayList();
		for (int i = 0;i < req.namespaces_size();i++) {
			prefixes.add(req.getNamespaces(i).getPrefix());
			namespaces.add(req.getNamespaces(i).getNamespace());
		}

		ArrayList conditions = new ArrayList();
		for (int i = 0;i < req.conditions_size();i++) {
			conditions.add(req.getConditions(i));
		}
		
		ArrayList[] optionalConditions = new ArrayList[req.optionalConditions_size()];
		for (int i = 0;i < optionalConditions.length;i++) {
			ArrayList conditionGroup = new ArrayList();
			for (int j = 0;j < req.getOptionalConditions(i).optionalCondition_size();j++) {
				String condition = req.getOptionalConditions(i).getOptionalCondition(j);
				conditionGroup.add(condition);
			}
			optionalConditions[i] = conditionGroup;
		}
		
		String query = model.buildSPARQLAsk(
				req.getBaseNamespace(), 
				prefixes, 
				namespaces, 
				conditions, 
				optionalConditions);
		
		return query;

    }


}
