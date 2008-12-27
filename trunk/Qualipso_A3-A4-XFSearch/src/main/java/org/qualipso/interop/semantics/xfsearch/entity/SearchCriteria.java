package org.qualipso.interop.semantics.xfsearch.entity;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionCompulsoryParameter;


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
 * This class represents the search criteria defined by user.
 * It comprises the search query in SPARQL and the list of remote forges where to apply it.
 */
public class SearchCriteria {
	/** Search Query in SPARQL*/
	private SemanticQuery semanticQuery = null;
	
	/** Query elements to be returned when query is performed*/
	private String[] queryElementsToReturn;
	
	/** Remote forges where the cross-forge search will be performed, defined also by user*/
	private List<ForgeTarget> remoteForges;
	
	/** Log for this class */
	private Log log = LogFactory.getLog(SearchCriteria.class);	
	
	/** 
	 * Default constructor
	 */
	public SearchCriteria() {}

	/**
	 * It returns the list of remote forges where to apply the search query
	 * @return remoteForges List of remote forges identifiers.
	 */
	public List<ForgeTarget> getRemoteForges() {
		return remoteForges;
	}

	/**
	 * It sets the list of remote forges where to apply the search query
	 * @param remoteForges List of remote forges identifiers.
	 */
	public void setRemoteForges(List<ForgeTarget> remoteForges) {
		this.remoteForges = remoteForges;
	}

	/** 
	 * It returns the semantic query defined by this seach criteria
	 * @return The semantic query.
	 */
	public SemanticQuery getSemanticQuery() {
		return semanticQuery;
	}

	/**
	 * It sets the semantic query defined by this seach criteria
	 * @param query The semantic query.
	 */
	public void setSemanticQuery(SemanticQuery query) {
		this.semanticQuery = query;
	}

	/**
	 * It returns the list of remote forges where to apply the search query
	 * @return This of remote forges identifiers.
	 */
	public List<String> getRemoteForgesIds() {
		List<String> ids = new ArrayList<String>();
		for (ForgeTarget forge: remoteForges){
			ids.add(forge.getId());
		}
		return ids;
	}

	/**
	 * Determines if the local forge is included in the list of forges where cross forge search
	 * should be performed.
	 * @param localForgeName
	 * @return
	 */
	public boolean includesLocalForge(String localForgeName) {
		return getRemoteForgesIds().contains(localForgeName);
	}



}

