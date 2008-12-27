//3f5eced7869adeaa83199ce1e78fddc4

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : ExecQueryService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.search.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.AdvancedDocModel;
import org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecQuery_resp;
import org.qualipso.advdoc.ws.client.search.beans.Node;
import org.qualipso.advdoc.ws.client.search.beans.Row;


import tdi.time.TdiChronometer;

/**
 * Implementación de la operación ExecQuery : Execute a query on RDF model. It builds the SPARQL sentence from parameters
 * @author FRAWA
 * @version 1.0
 */
public class ExecQueryService extends GenExecQueryService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @param    context    Objeto context necesario en la operación
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(ExecQuery_req __inbean,ExecQuery_resp __outbean,ServletContext context) throws Exception {

    	TdiChronometer crono = new TdiChronometer();
    	crono.start();
    	
    	// Get the Search API
    	QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
    	
    	// Build the query
    	String query = BuildSPARQLQueryService.buildSPARQL(model, __inbean);
    	
    	// Invoke core API		
		SPARQLResultSet rs = model.execSPARQL(query);
		
		crono.pause();
		
		// Build the response
		buildResult(rs, crono, __outbean);
				
    }

    static void buildResult(SPARQLResultSet rs,TdiChronometer crono,ExecQuery_resp resp) {
		// Query time
		resp.setTime((double)crono.elapsed()/1000.0);
		
		// SPARQL query
		resp.setSparql(rs.getQuery());
		
		// Columns
		String[] cols = rs.getColumnsAsArray();
		for (int i = 0;i < cols.length;i++) {
			resp.getResult().addColumns(cols[i]);
		}

		// Rows
		for (int i = 0;i < rs.getNumRows();i++) {
			Row row = new Row();
			for (int j = 0;j < rs.getNumColumns();j++) {
				Node node = new Node();
				try {
					node.setIsLiteral(rs.isLiteral(i, j) ? 1 : 0);
				} catch (Exception e) {
					node.setIsLiteral(1);
				}
				try {
					node.setValue(rs.getAsString(i, j));
				} catch (Exception e) {
					node.setValue("");
				}
				row.addNodes(node);
			}
			resp.getResult().addRows(row);
		}
    	
    }

}
