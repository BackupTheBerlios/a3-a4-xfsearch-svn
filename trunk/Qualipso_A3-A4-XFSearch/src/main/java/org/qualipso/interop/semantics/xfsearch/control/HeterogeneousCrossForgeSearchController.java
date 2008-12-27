package org.qualipso.interop.semantics.xfsearch.control;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.client.search.beans.SPARQLResult;
import org.qualipso.interop.semantics.xfsearch.boundary.ForgeService;
import org.qualipso.interop.semantics.xfsearch.entity.SemanticQuery;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionCompulsoryParameter;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionFileNotFound;

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
 * Provides support for HETEROGENEOUS XFSearch feature
 */
public class HeterogeneousCrossForgeSearchController {

	/** Log for this class */
	private Log log = LogFactory
			.getLog(HeterogeneousCrossForgeSearchController.class);

	ForgeService fsp = null;


	/**
	 * Default contructor
	 * @param fsp Forge service that provide semantic search features
	 */
	public HeterogeneousCrossForgeSearchController(ForgeService fsp) {
		this.fsp = fsp;
	}

	/**
	 * It performs a heterogeneous semantic search within the associated forge (@see ForgeService) 
	 * @param semanticQuery Semantic query describing the search requested.
	 * @return Semantic search results
	 * @throws Exception 
	 */
	public SPARQLResult performHeterogeneousXFSearch(
			SemanticQuery semanticQuery)
			throws Exception {
		return fsp.performHeterogeneousSemanticSearch(semanticQuery);
	}

}
