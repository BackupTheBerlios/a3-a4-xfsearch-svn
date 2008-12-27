//623b93062bbbdbc3b31698755cd96e4

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : BuildSPARQLQueryService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req;

/**
 * Implementación de la operación BuildSPARQLQuery : Build a SPARQL query string from query components
 * @author FRAWA
 * @version 1.0
 */
public class BuildSPARQLQueryService extends GenBuildSPARQLQueryService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(ExecQuery_req __inbean,BuildSPARQLQuery_resp __outbean,ServletContext context) throws Exception {
    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
    	
    	// Build the query
    	String query = buildSPARQL(model, __inbean);
    	
    	// Output
		__outbean.setSparql(query);
		
    }

    
    static String buildSPARQL(QualiPSoTextSearchAPI model,ExecQuery_req req) {
		ArrayList prefixes = new ArrayList();
		ArrayList namespaces = new ArrayList();
		for (int i = 0;i < req.namespaces_size();i++) {
			prefixes.add(req.getNamespaces(i).getPrefix());
			namespaces.add(req.getNamespaces(i).getNamespace());
		}
		ArrayList vars = new ArrayList();
		for (int i = 0;i < req.variables_size();i++) {
			vars.add(req.getVariables(i));
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
		String query = model.buildSPARQL(
				req.getBaseNamespace(), 
				prefixes, 
				namespaces, 
				req.getDistinct() == 1 ? true : false,
				vars,
				conditions, 
				optionalConditions,
				req.getOrderBy(), 
				req.getLimit(), 
				req.getOffset());
		
		return query;
    	
    }

}
