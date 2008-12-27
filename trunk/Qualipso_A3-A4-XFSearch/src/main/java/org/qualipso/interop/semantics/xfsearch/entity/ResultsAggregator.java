package org.qualipso.interop.semantics.xfsearch.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qualipso.advdoc.ws.client.search.beans.Node;
import org.qualipso.advdoc.ws.client.search.beans.Row;
import org.qualipso.advdoc.ws.client.search.beans.SPARQLResult;

/*******************************************************************************
 * Copyright (c) 2007 ATOS Origin SAE, 
 * All rights reserved. This software and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     @author Jesus Gorroñogoitia, jesus.gorronogoitia@atosresearch.eu ATOS Origin SAE -
 *     @author Jesus Martin, Origin SAE -
 *     
 *******************************************************************************/

/**
 * Class used to consolidate results acquire during the cross-forge semantic search process within
 * several forges (local and remote ones)  
 */
public class ResultsAggregator {
	private HashMap<String, SPARQLResult> results = new HashMap<String, SPARQLResult>();
	
	/** Log for this class */
	private Log log = LogFactory.getLog(ResultsAggregator.class);
	
	/**
	 * Default constructor
	 */
	public ResultsAggregator(){
		
	}
	
	/**
	 * it adds a semantic search result set provided by a particular forge 
	 * @param id Forge identifier
	 * @param result Semantic search result set obtained within that forge
	 * @see SPARQLResultSet
	 */
	public void addResult(String id, SPARQLResult result) {
		results.put (id, result);
	}

	/**
	 * it returns the consolidate cross-forge semantic search results
	 * (across all the forges participating in the search process)
	 * @return Consolidate cross-forge semantic search results
	 */
	public Map<String, SPARQLResult> consolidateResults() {
		return results;
	}
	
	public SPARQLResult consolidateResults (ArrayList partialSPARQLResults){
		int partialSPARQLResultsNumber = partialSPARQLResults.size();
		log.info("partialSPARQLResultsNumber: "+partialSPARQLResultsNumber);
		
		// We initialize the sPARQLResult with the first result; 
		SPARQLResult sPARQLResult = (SPARQLResult) partialSPARQLResults.get(0);
		
		// We aggregate the remaining partial results (from the second one)
		for (int i=1; i<partialSPARQLResultsNumber; i++){
			SPARQLResult partialSPARQLResult = (SPARQLResult) partialSPARQLResults.get(i);
			Row[] rows = partialSPARQLResult.getRows();
			if (rows!=null){
				for (int j=0; j<rows.length; j++){
					sPARQLResult.addRows(rows[j]);
				}
			}
			log.info("An additional partial result has been aggregated");
		}
		return sPARQLResult;
	}

	public SPARQLResult consolidateResults(Map<String, SPARQLResult> xfsr) {
		SPARQLResult results = new SPARQLResult ();
		// Columns
		String[] cols = xfsr.values().iterator().next().getColumns();
		String[] columns = new String[cols.length+1];
		columns[0] = "Forge";
		for (int i=0; i<cols.length; i++){
			columns[i+1] = cols[i];
		}
		results.setColumns(columns);
		
		//Rows by forge
		for (String forge:xfsr.keySet()){
			SPARQLResult sr = xfsr.get(forge);
			Row[] rows = sr.getRows();
			Node forgeNode = new Node ();
			forgeNode.setIsLiteral(1);
			forgeNode.setValue(forge);
			for (int i=0; i<rows.length; i++){
				Row row = new Row();
				Node[] nodes = rows[i].getNodes();
				row.addNodes(forgeNode);
				for (int j=0; j<nodes.length; j++){
					row.addNodes(nodes[j]);
				}
				results.addRows(row);
			}
		}
		return results;
	}
}
