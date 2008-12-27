package org.qualipso.interop.semantics.xfsearch.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mindswap.pellet.jena.PelletQueryExecution;
import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.client.search.beans.SPARQLResult;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionCompulsoryParameter;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionFileNotFound;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.shared.Lock;

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
 * It performs a semantic search onto the associate forge according with the cross-forge semantic search type: HOMOGENEOUS or HETEROGENEOUS
 */
public class SemanticBasedSearchEngine {

	/** Log for this class */
	private Log log = LogFactory.getLog(SemanticBasedSearchEngine.class);	

	/** Ontology which SemanticBasedSearchEngine uses*/
	private Ontology ontology;

	/** Semantic query */
	private SemanticQuery semanticQuery;
	 
	/** Prefixes for sparql query */
	private String[] prefixes;

	private List<String> mappingURLs;
	
	SemanticTranslator semanticTranslator = null;
	
	/**
	 * Constructor for homogeneous cross-forge semantic search
	 * @param ontology Associate forge ontology
	 * @throws XFSearchExceptionCompulsoryParameter
	 * @throws XFSearchExceptionFileNotFound
	 */
	public SemanticBasedSearchEngine(Ontology ontology) throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound{
		this (ontology, new ArrayList<String>());
	}
	
	/**
	 * Constructor for heterogeneous cross-forge semantic search
	 * @param ontology Associate forge ontology
	 * @param mappingURLs Semantic mappings URLs to applied for the heterogeneous cross-forge semantic search
	 * @throws XFSearchExceptionCompulsoryParameter
	 * @throws XFSearchExceptionFileNotFound
	 */
	public SemanticBasedSearchEngine(Ontology ontology, List<String> mappingURLs) throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound{
		this.ontology = ontology;
		this.mappingURLs = 	mappingURLs;
	}
	
	/**
	 * @deprecated
	 */
	public SemanticBasedSearchEngine(Ontology ontology, String[] prefixes) throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound{
		this.ontology = ontology;
		this.prefixes = prefixes;		
	}	
	
	/**
	 * @deprecated
	 */
	public SemanticBasedSearchEngine(String[] ontologiesPaths, String[] prefixes, boolean withPellet) throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound{
		if (ontologiesPaths==null){
			XFSearchExceptionCompulsoryParameter ex = new XFSearchExceptionCompulsoryParameter("ontologiesPaths");
			log.error(ex);
			throw ex;
		}
		
		this.prefixes = prefixes;

		File[] ontologiesFiles = new File[ontologiesPaths.length];
		for (int i=0; i< ontologiesPaths.length; i++){
			ontologiesFiles[i] = new File(ontologiesPaths[i]);
			if (!ontologiesFiles[i].exists()){
				XFSearchExceptionFileNotFound ex = new XFSearchExceptionFileNotFound(ontologiesPaths[i]);
				log.error(ex);
				throw ex;
			}
			this.ontology = new Ontology(Arrays.asList(ontologiesPaths), withPellet);
		}
	}
	
	/**
	 * it returns the ontology used by the semantic search engine
	 * @return The ontology object.
	 */
	public Ontology getOntology (){
		return this.ontology;
	}

	/**
	 * it returns the semantic query used by the semantic search engine
	 * @return
	 */
	public SemanticQuery getSemanticQuery() {
		return semanticQuery;
	}	
	

	/**
	 * @deprecated
	 */
	public void performLocalDescribe(String sparqlQuery) throws Exception{
		//this.semanticQuery = this.buildSemanticQuery(searchCriteria);
		
		Query query = QueryFactory.create(sparqlQuery);		
		QueryExecution queryExecution = null;  
		try {
			
		    queryExecution = QueryExecutionFactory.create(query, this.ontology.getJenaOntModel()) ;
	        Model model = queryExecution.execDescribe();	
	        System.out.println (model.toString());

	        
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	        		
	
/*			
//			queryExecution = QueryExecutionFactory.create(this.semanticQuery.getQuery(), this.ontology.getJenaOntModel()) ;
//			ResultSet resultSet = queryExecution.execSelect() ;
		while (resultsSet.hasNext() ){
			QuerySolution querySolution = resultsSet.nextSolution() ;
			List resultVars = query.getResultVars();
			for (int i=0; i< resultVars.size(); i++){
				
				if ( querySolution.get((String)resultVars.get(i)).isLiteral() ){
					Literal literal = querySolution.getLiteral((String)resultVars.get(i));
					//log.info("Results="+literal.getValue());
					//log.info("(String)resultVars.get(i)= "+(String)resultVars.get(i));
					if (searchResults.size() < resultVars.size() ){
						SearchResultsForOneResultVar searchResultsForOneResultVar = new SearchResultsForOneResultVar((String)resultVars.get(i));
						searchResultsForOneResultVar.addResult(literal.getValue().toString());
						searchResults.addResultsForOneResultVar(searchResultsForOneResultVar);
					}
					else {
						for (int j=0; j< searchResults.size(); j++){
							SearchResultsForOneResultVar searchResultsForOneResultVar = searchResults.getResultsForOneResultVar(j);
							if (searchResultsForOneResultVar.getResultVariable().equals( (String)resultVars.get(i) )){
								searchResultsForOneResultVar.addResult(literal.getValue().toString());
							}
						}
					}
				}								
				
				
				if ( querySolution.get((String)resultVars.get(i)).isResource() ){
				
				//log.info ( ( querySolution.get((String)resultVars.get(i)) ).asNode().getLocalName() );
				
				Resource resource = querySolution.getResource((String)resultVars.get(i));
				//log.info("Results="+resource.getLocalName());
				//log.info("(String)resultVars.get(i)= "+(String)resultVars.get(i));
				if (searchResults.size() < resultVars.size() ){
					SearchResultsForOneResultVar searchResultsForOneResultVar = new SearchResultsForOneResultVar((String)resultVars.get(i));
					searchResultsForOneResultVar.addResult(resource.getLocalName());
					searchResults.addResultsForOneResultVar(searchResultsForOneResultVar);
				}
				else {
					for (int j=0; j< searchResults.size(); j++){
						SearchResultsForOneResultVar searchResultsForOneResultVar = searchResults.getResultsForOneResultVar(j);
						if (searchResultsForOneResultVar.getResultVariable().equals( (String)resultVars.get(i) )){
							searchResultsForOneResultVar.addResult(resource.getLocalName());
						}
					}
				}
			}		
			}
		}
		//log.info("it worked...");
	}
	catch (Exception ex){
		log.error(ex);
		throw ex;
	}
	finally {
		queryExecution.close();
	}
	
	return searchResults;*/
}

		/**
		 *@deprecated
		 */
		public void performLocalDescribe_withPellet(String sparqlQuery) throws Exception{
			//this.semanticQuery = this.buildSemanticQuery(searchCriteria);
			
			Query query = QueryFactory.create(sparqlQuery);			
			QueryExecution queryExecution = null;  
			try {
				
			    queryExecution = new PelletQueryExecution(query, this.ontology.getJenaOntModel());
		        Model model = queryExecution.execDescribe();	
		        System.out.println (model.toString());

		        
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
		}		

	/**
	 * Performs an homogeneous semantic search in this forge service, which does not implies to apply any semantic mapping
	 * @param semanticQuery
	 * @return Semantic search results
	 * @throws Exception
	 */
	public SPARQLResultSet performHomogeneousSemanticSearch(SemanticQuery semanticQuery) throws Exception{
		return performSemanticSearch (semanticQuery);
	}
	
	/**
	 * Performs an heterogeneous semantic search in this forge service, which implies to apply any semantic mapping
	 * @param semanticQuery
	 * @return Semantic search results
	 * @throws Exception
	 */
//	public SPARQLResultSet performHeterogeneousSemanticSearch(SemanticQuery semanticQuery){
//		//Modify remote ontology with mapping constructs
//		//Perform search
//		
//		SPARQLResultSet results = null;
//		try {
//			// TODO Support multiple mapping sources
//			Mapping mapping = new Mapping (mappingURLs.get(0));
//			ontology.getJenaOntModel().enterCriticalSection(Lock.WRITE);
//			// Apply mapping statements
//			semanticTranslator = new SemanticTranslator (ontology, mapping);
//			semanticTranslator.applyMappingsIntoOntModel();
//
//			// Perform search
//			results = performSemanticSearch(semanticQuery);
//			
//			// Remove mapping statements from the model
//			semanticTranslator.removeMapping ();		
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ontology.getJenaOntModel().leaveCriticalSection();
//		}
//		
//		return results;
//	}

	/**
	 * it performs a semantic search in the associate forge
	 * @param semanticQuery.getSparqlQuery()
	 * @return Semantic search results
	 * @throws Exception
	 */
	public SPARQLResultSet performSemanticSearch(SemanticQuery semanticQuery) throws Exception{
		Query query = QueryFactory.create(semanticQuery.getSparqlQuery());
		SPARQLResultSet searchResults = null;
		QueryExecution queryExecution = null;  
		try {	
			
			queryExecution = new PelletQueryExecution(query, this.ontology.getJenaOntModel());
	        ResultSet resultsSet = queryExecution.execSelect();	
	        searchResults = new SPARQLResultSet(resultsSet, semanticQuery.getSparqlQuery(),true);
	        
			// readQueryResults(query, searchResults, resultsSet);
		}
		catch (Exception ex){
			log.error(ex);
			throw ex;
		}
		finally {
			queryExecution.close();
		}
		
		return searchResults;
	}
	
	
	/**
	 * it sets the forge ontology where the semantic search engine performs the seach.
	 * @param ontology The ontology object
	 */
	public void setOntology(Ontology ontology){
		this.ontology = ontology;
	}

}

