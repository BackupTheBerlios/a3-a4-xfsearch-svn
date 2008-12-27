package org.qualipso.interop.semantics.xfsearch.control;

import org.qualipso.advdoc.ws.client.search.beans.SPARQLResult;
import org.qualipso.interop.semantics.xfsearch.boundary.ForgeService;
import org.qualipso.interop.semantics.xfsearch.entity.SemanticQuery;

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
 * Provides support for HOMOGENEOUS XFSearch feature
 */
public class HomogeneousCrossForgeSearchController {
	
	ForgeService fsp = null;
	
	/**
	 * Default contructor
	 * @param fsp Forge service that provide semantic search features
	 */
	public HomogeneousCrossForgeSearchController (ForgeService fsp){
		this.fsp = fsp;
	}

	/**
	 * It performs a homogeneous semantic search within the associated forge (@see ForgeService) 
	 * @param semanticQuery Semantic query describing the search requested.
	 * @return Semantic search results
	 * @throws Exception
	 */
	public SPARQLResult performHomogeneousXFSearch(SemanticQuery semanticQuery) throws Exception {
		return fsp.performHomogeneousSemanticSearch (semanticQuery);
	}

}
