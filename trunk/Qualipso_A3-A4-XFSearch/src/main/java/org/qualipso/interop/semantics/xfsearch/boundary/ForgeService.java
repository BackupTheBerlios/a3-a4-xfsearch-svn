package org.qualipso.interop.semantics.xfsearch.boundary;

import java.io.IOException;
import java.util.List;

import org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_req;
import org.qualipso.advdoc.ws.client.search.beans.SPARQLResult;
import org.qualipso.interop.semantics.xfsearch.entity.ForgeServiceSpecification;
import org.qualipso.interop.semantics.xfsearch.entity.Mapping;
import org.qualipso.interop.semantics.xfsearch.entity.SemanticBasedSearchEngine;
import org.qualipso.interop.semantics.xfsearch.entity.SemanticQuery;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionCompulsoryParameter;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionFileNotFound;
import org.qualipso.interop.semantics.xfsearch.utils.FileUtils;

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
 * it provides a forge XFSearch service proxy implementation
 * To get access to a particular forge service make usage of ForgeService
 * @see ForgeService 
 */

public class ForgeService {
	ForgeServiceSpecification fss = null; 
	SemanticBasedSearchEngine forgeSemanticSearchEngine = null;
	
	/**
	 * Default constructor
	 * @param fss Contains a specification of the forge XFSearch service
	 * @throws XFSearchExceptionCompulsoryParameter
	 * @throws XFSearchExceptionFileNotFound
	 */
	public ForgeService (ForgeServiceSpecification fss) throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound{
		this.fss = fss;
		forgeSemanticSearchEngine = new SemanticBasedSearchEngine(fss.getOntology(), fss.getMappingsURL());
	}
	
	/**
	 * It performs a semantic search in the forge associate to this service proxy
	 * @param semanticQuery SPARQL query representing the semantic search and associated criteria
	 * @return The results of the semantic search performed in the associated forge
	 * @throws Exception
	 */
	public SPARQLResult performSemanticSearch(SemanticQuery semanticQuery) throws Exception {
		ExecSPARQL_req execSPARQL_req = new ExecSPARQL_req(semanticQuery.getSparqlQuery());
		return fss.getStub().ExecSPARQL(execSPARQL_req).getResult();
	}

	/**
	 * it provides the specification that parameterizes this forge XFSearch service
	 * @return forge XFSearch specification
	 */
	public ForgeServiceSpecification getForgeServiceSpecification() {
		return fss;
	}

	/**
	 * It performs an heterogeneous semantic search within the associate forge
	 * @param semanticQuery an semantic query describing the search criteria
	 * @return The semantic search results.
	 * @throws Exception 
	 */
	public SPARQLResult performHeterogeneousSemanticSearch(SemanticQuery semanticQuery) throws Exception {	
//		return forgeSemanticSearchEngine.performHeterogeneousSemanticSearch(semanticQuery);
//		String mappings = getMappingSparqlContructsAsString(fss.getMappingsURL()); 
		String mappings = getMappingSparqlURLsAsString(fss.getMappingsURL()); 
		ExecConstructAndSearch_req execConstructAndSearch_req = new ExecConstructAndSearch_req(semanticQuery.getSparqlQuery(), mappings);
		return fss.getStub().ExecConstructAndSearch(execConstructAndSearch_req).getResult();	
	}
	
	private String getMappingSparqlURLsAsString(List<String> mappingsURL) {
		StringBuffer sb = new StringBuffer();
		for (String mappingURL: mappingsURL){
			sb.append(mappingURL+ ",");
		}
		return sb.toString();
	}

	private String getMappingSparqlContructsAsString(List<String> mappingsURL) throws IOException {
		StringBuffer sb = new StringBuffer();
		for (String mappingURL: mappingsURL){
			sb.append(FileUtils.readFileAsString(mappingURL)+ ",");
		}
		return sb.toString();
	}

	/**
	 * It performs an homogeneous semantic search within the associate forge
	 * @param semanticQuery an semantic query describing the search criteria
	 * @return The semantic search results.
	 * @throws Exception 
	 */
	public SPARQLResult performHomogeneousSemanticSearch(SemanticQuery semanticQuery) throws Exception {	
		return performSemanticSearch(semanticQuery);
	}
}
