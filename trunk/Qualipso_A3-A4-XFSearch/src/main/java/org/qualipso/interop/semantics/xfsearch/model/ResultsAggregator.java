package org.qualipso.interop.semantics.xfsearch.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qualipso.advdoc.ws.client.search.beans.Row;
import org.qualipso.advdoc.ws.client.search.beans.SPARQLResult;
//import org.qualipso.interop.semantics.xfsearch.control.CrossForgeSearchController;

public class ResultsAggregator {
	
	/** Log for this class */
	private Log log = LogFactory.getLog(ResultsAggregator.class);
	
	/**
	 * 
	 */
	public ResultsAggregator(){
		
	}
	
	/**
	 * 
	 * @param localForgeSearchResults
	 * @param remoteForgeSearchResults
	 * @return
	 */
	/*
	public SearchResults consolidateResults(SearchResults localForgeSearchResults, SearchResults remoteForgeSearchResults){
		SearchResults searchResults = new SearchResults();
		try {

		for (int i=0; i< localForgeSearchResults.size(); i++){
			log.info("i:"+i);
			SearchResultsForOneResultVar searchResultsForOneResultVar = new SearchResultsForOneResultVar(localForgeSearchResults.getResultsForOneResultVar(i).getResultVariable());

			searchResultsForOneResultVar.addResultsAll(localForgeSearchResults.getResultsForOneResultVar(i));
			searchResultsForOneResultVar.addResultsAll(remoteForgeSearchResults.getResultsForOneResultVar(i));
			searchResults.addResultsForOneResultVar(searchResultsForOneResultVar);
		}
		
		log.info("searchResults: "+searchResults);
		
		for (int i=0; i< searchResults.size(); i++){
			SearchResultsForOneResultVar searchResultsForOneResultVar = searchResults.getResultsForOneResultVar(i);
			log.info("===================");
			log.info("ResultVariable= "+searchResultsForOneResultVar.getResultVariable());
			for (int j=0; j< searchResultsForOneResultVar.size(); j++){
				log.info(searchResultsForOneResultVar.getResult(j));
				
			}
			
		}		

		}
		catch (Exception ex){
			log.equals(ex);
		}
		return searchResults;
	}
	*/
	
	
	public SPARQLResult consolidateResults (ArrayList partialSPARQLResults){
		int partialSPARQLResultsNumber = partialSPARQLResults.size();
		log.info("partialSPARQLResultsNumber: "+partialSPARQLResultsNumber);
		
		// We inizialite the sPARQLResult with the first result; 
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
	
}
