package org.qualipso.interop.semantics.xfsearch.control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.client.search.beans.SPARQLResult;
import org.qualipso.interop.semantics.xfsearch.boundary.ForgeServiceRegistry;
import org.qualipso.interop.semantics.xfsearch.boundary.ForgeService;
import org.qualipso.interop.semantics.xfsearch.entity.Ontology;
import org.qualipso.interop.semantics.xfsearch.entity.ResultsAggregator;
import org.qualipso.interop.semantics.xfsearch.entity.SearchCriteria;
import org.qualipso.interop.semantics.xfsearch.entity.ForgeServiceSpecification.ForgeType;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchException;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionCompulsoryParameter;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionFileNotFound;
import org.qualipso.interop.semantics.xfsearch.utils.FileUtils;
import org.qualipso.interop.semantics.xfsearch.utils.XFSearchLog;
import org.qualipso.interop.semantics.xfsearch.utils.XFSearchProperties;

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
 * Entry point class for QUALIPSO WP3.2 XFSearch proof of concept.
 * It controls cross-forge semantic search request provided by a forge semantic engine
 */
public class XFSearchController {
	/**
	 * XFSearch type: HOMEGENEOUS, HETEROGENEOUS
	 */
	public enum XFSearchType {
		HOMEGENEOUS, HETEROGENEOUS
	};

	ResultsAggregator ra = null;
	ForgeServiceRegistry forgeRegistryService = null;
	XFSearchProperties xfSearchProperties = null;
	Ontology localForgeOntology = null;
	Map<String, Ontology> remoteForgesOntology = new HashMap<String, Ontology> ();
	ForgeService localForgeServiceProxy = null;
	List<ForgeService> remoteforgesServiceProxies = null;
	HomogeneousCrossForgeSearchController hocfsc = null;
	HeterogeneousCrossForgeSearchController hecfsc = null;
	
	/**
	 * Default constructor
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws XFSearchExceptionCompulsoryParameter
	 * @throws XFSearchExceptionFileNotFound
	 */
	public XFSearchController() throws XFSearchExceptionFileNotFound, IOException, XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound {
		this (null);
	}
	
	public XFSearchController(String xfsearchPropertiesPath) throws FileNotFoundException, IOException, XFSearchExceptionFileNotFound, XFSearchExceptionCompulsoryParameter {
		xfSearchProperties = XFSearchProperties.getInstance(xfsearchPropertiesPath);
		forgeRegistryService = ForgeServiceRegistry.getInstance(xfSearchProperties);
		
		// Initialize local forge service proxy
		// initialize();
	}

	/**
	 * It initializes local forge service that provides semantic search facilities
	 * @throws XFSearchExceptionCompulsoryParameter
	 * @throws XFSearchExceptionFileNotFound
	 * @throws MalformedURLException 
	 */
//	private void initialize() throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound, MalformedURLException {
//		boolean local = true;
//		localForgeServiceProxy = forgeRegistryService.getForgeServiceProxy ("localforge", local);
//	}

	/**
	 * Perform a XFSearch (Homogeneous or Heterogeneous according with the type of local and remote forges)
	 * @param query Semantic query in SPARQL
	 * @param remoteForgesIds List of remote forges identifiers
	 * @return a map collection of semantic search results found in local and remote forges
	 */
	public Map<String, SPARQLResult> performXFSearch(SearchCriteria searchCriteria) {
		ra = new ResultsAggregator();

		try {
			// Modified search query to support both-word-side wild-characters
//			modifiedSearchQueryLuceneTextMatch (searchCriteria);
			
			// Recover remote forges service proxies. Call ForgeRegistryService to recover a ForgeServiceProxy
			// Recover all remote forge information as in old methods  readConfiguration and loadOntology
			forgeRegistryService.setForgesIds(searchCriteria.getRemoteForgesIds());
			remoteforgesServiceProxies = forgeRegistryService.getRemoteForgeServiceProxies ();
			localForgeServiceProxy = forgeRegistryService.getLocalForgeServiceProxy();

			// Perform local query invoking local ForgeServiceProxy
			if (searchCriteria.includesLocalForge (xfSearchProperties.getLocalForgeName())){
				SPARQLResult localForgeSearchResults = localForgeServiceProxy.performSemanticSearch (searchCriteria.getSemanticQuery());
				// Use ResultsAggregator
				ra.addResult(localForgeServiceProxy.getForgeServiceSpecification().getId(), localForgeSearchResults);
			}
			// Perform remote query
			// for each remote forge determine type of search (homogeneous vs heterogeneous comparing forge types)
			// TODO: distribute remote forge using WS
			for (ForgeService remoteforgeServiceProxy: remoteforgesServiceProxies){
				// Determine search type
				XFSearchType type = determineXFSearchType (localForgeServiceProxy.getForgeServiceSpecification().getType(), 
						remoteforgeServiceProxy.getForgeServiceSpecification().getType());
				// Use appropriate controller according to the search type
				if (type == XFSearchType.HOMEGENEOUS){
					hocfsc = new HomogeneousCrossForgeSearchController(remoteforgeServiceProxy);
					ra.addResult (remoteforgeServiceProxy.getForgeServiceSpecification().getId(),
							hocfsc.performHomogeneousXFSearch(searchCriteria.getSemanticQuery()));
				} else if (type == XFSearchType.HETEROGENEOUS){
					hecfsc = new HeterogeneousCrossForgeSearchController(remoteforgeServiceProxy);
					ra.addResult (remoteforgeServiceProxy.getForgeServiceSpecification().getId(),
							hecfsc.performHeterogeneousXFSearch(searchCriteria.getSemanticQuery()));
				} else {
					throw new XFSearchException ("XFSearchType not supported. Check prototype configuration");
				}
			}
		} catch (Exception ex) {
			XFSearchLog.getLogger().trace(ex);
		}

		return ra.consolidateResults();
	}

	private void modifiedSearchQueryLuceneTextMatch(
			SearchCriteria searchCriteria) {
		String query = searchCriteria.getSemanticQuery().getSparqlQuery();
		if (hasLuceneTextMatch(query)){
			//modify query
			query = modifiedSearchQueryLuceneTextMatch (query);
			searchCriteria.getSemanticQuery().setSparqlQuery(query);
		}
		
	}

	private String modifiedSearchQueryLuceneTextMatch(String query) {
		String newQuery = new String (query);
		// TODO: Modified logic to use regular expressions
		int end = query.length();
		int indexi = 0;
		int indexf = 0;
		indexi = newQuery.indexOf("lucene:textMatch '", indexf);
		while (indexi > 0){
			indexi += "lucene:textMatch '".length();
			indexf = newQuery.indexOf("'", indexi);
			String finalwildChar = "*";
			String substring = query.substring(indexi, indexf);
			if (substring.endsWith("*")){
				finalwildChar = "";
			}
			newQuery = newQuery.replace (substring, "*" + substring + finalwildChar);
			indexi = newQuery.indexOf("lucene:textMatch '", indexf);
		}
		
		return newQuery;
	}

	private boolean hasLuceneTextMatch(String query) {
		return query.indexOf("lucene:textMatch") > 0;
	}

	/**
	 * It determines XFSearch type between two forges comparing those forge types
	 * @param type1 Forge1 type
	 * @param type2 Forge2 type
	 * @return XFSearch type (HOMEGENEOUS or HETEROGENEOUS)
	 */
	private XFSearchType determineXFSearchType(ForgeType type1, ForgeType type2) {
		XFSearchType searchType = XFSearchType.HETEROGENEOUS;
		if (type1 == type2){
			searchType = XFSearchType.HOMEGENEOUS;
		}
		return searchType;
	}
}
