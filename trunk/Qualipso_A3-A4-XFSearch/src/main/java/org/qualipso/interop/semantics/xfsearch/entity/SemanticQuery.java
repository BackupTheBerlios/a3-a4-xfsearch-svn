package org.qualipso.interop.semantics.xfsearch.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;

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
 * This class represents the semantic query
 */

public class SemanticQuery {
	
	/** Jena Query */
	private Query query ;
	
	/** Sparql Query as String*/
	private String sparqlQuery;
	
	/**
	 * Default Constructor
	 * 
	 * @param sparqlQuery Semantic query in SPARQL
	 */
	public SemanticQuery(String sparqlQuery){
		this.sparqlQuery = sparqlQuery;
		this.query = QueryFactory.create(sparqlQuery);
	}
	
	/**
	 * It constructs a semantic query in SPARQL read from a file
	 * @param semanticQueryFile Path of file containing the semantic query
	 * @throws Exception
	 */
	public SemanticQuery(File semanticQueryFile) throws Exception{
		this.sparqlQuery = "";
		Reader reader = new FileReader(semanticQueryFile);
		BufferedReader bufferedReader = new BufferedReader(reader);
		boolean end = false;
		String lines = "";
				
		while (!end){
			String line_aux = bufferedReader.readLine();
			if (line_aux!=null)
				lines = lines + line_aux + "\r";
			else
				end = true;
		}
		System.out.println();		
		System.out.println("Reading semantic query...: ");
		System.out.println(lines);		

		this.sparqlQuery = lines;
	}	

	/**
	 * It return the semantic query
	 * @return query Semantic query
	 */
	public Query getQuery() {
		return this.query;
	}	
	
	/**
	 * It gets the semantic SPARQL query
	 * @return sparqlQuery Semantic SPARQL query
	 */
	public String getSparqlQuery() {
		return this.sparqlQuery;
	}

	public void setSparqlQuery(String query) {
		this.sparqlQuery = query;
	}

}
