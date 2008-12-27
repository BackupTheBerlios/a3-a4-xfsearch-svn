package org.qualipso.interop.semantics.xfsearch.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mindswap.pellet.jena.PelletQueryExecution;
import org.qualipso.advdoc.coreapi.model.QualiPSoModel;
import org.qualipso.interop.semantics.xfsearch.control.HeterogeneousCrossForgeSearchController;
import org.qualipso.interop.semantics.xfsearch.utils.XFSearchProperties;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.impl.LiteralLabel;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.rdf.model.impl.LiteralImpl;
import com.hp.hpl.jena.rdf.model.impl.ResourceImpl;
import com.hp.hpl.jena.rdf.model.impl.StatementImpl;
import com.hp.hpl.jena.sparql.syntax.Element;

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
 * This class represents the semantic mapping
 */

public class SemanticTranslator {

	/** Log for this class */
	private Log log = LogFactory.getLog(SemanticTranslator.class);
	private ArrayList<Statement> stmts = null;
	private QualiPSoModel qModel = null;
	private Mapping mapping = null;

	/**
	 * Default constructor
	 */
	public SemanticTranslator() {
	}

	/**
	 * It builds a semantic translator
	 * 
	 * @param ontology
	 *            Ontology that semantic translator enhances after applying a
	 *            mapping
	 * @param mapping
	 *            Semantic mapping
	 */
	public SemanticTranslator(QualiPSoModel qModel, Mapping mapping) {
		this.qModel = qModel;
		this.mapping = mapping;
	}

	/**
	 * @deprecated
	 */
	public Ontology applyMappingsIntoOntModel_old(Ontology ontology,
			String constructString) throws Exception {

		Query query = QueryFactory.create(constructString);
		QueryExecution qexec = QueryExecutionFactory.create(query, ontology
				.getJenaOntModel());
		try {
			Model resultModel = qexec.execConstruct();
			StmtIterator smtIterator = resultModel.listStatements();
			System.out.println("");
			System.out
					.println("TEMPORALLY ADDING HETEROGENEOUS VOCABULARY IN FORGE B...:");
			while (smtIterator.hasNext()) {
				Statement stament = ((Statement) smtIterator.next());
				System.out.println("Semantic statement added= " + stament);

				ontology.getJenaOntModel().add(stament);
				// ontModelJena.remove(stament);

			}
			System.out.println("");
			System.out
					.println("...HETEROGENEOUS VOCABULARY TEMPORALLY ADDED IN FORGE B");

		} finally {
			qexec.close();
		}
		return ontology;

	}

	/**
	 * It applies the semantic mappings into the ontology to extend it with new
	 * statements representing the heterogeneities between forges
	 * 
	 * @return
	 * @throws Exception
	 */
	public void applyMappingsIntoOntModel() throws Exception {
		
		List<String> constructStrings = mapping.getMappingSparqlContructs();
		stmts = new ArrayList<Statement>();
		
		//DEBUG Print original model
		boolean debug = XFSearchProperties.getInstance().isDebugMode();
		boolean reindex = XFSearchProperties.getInstance().isReindexMode();
		if (debug){
			qModel.getModel().write(new FileOutputStream (new File ("gforge_original_model.rdf")));
		}
		int i = 0;
		for (String constructString: constructStrings){
			Query constructQuery = QueryFactory.create(constructString);
	
			QueryExecution queryExecution = null;
			try {
	//			queryExecution = new PelletQueryExecution(constructQuery, model);
				queryExecution = QueryExecutionFactory.create(constructQuery, qModel.getModel());
	//			Model constructModel = queryExecution.execConstruct(qModel.getModel());
				Model constructModel = queryExecution.execConstruct();
				
				//DEBUG Print construct model
				if (debug){
					constructModel.write(new FileOutputStream (new File ("gforge_construct_model_" + (i++) + ".rdf")));
				}
				// Add new statements to the model
				StmtIterator iter = constructModel.listStatements();
				while (iter.hasNext()) {
					Statement s = iter.nextStatement();
					// NOTE: Filter to partially solve bug found in A4 ADVDOC prototype. 
					// A4 has been notified to fix bug.
					// Bug implies that searches by project category with wild characters at the 
					// beginning doesn't work, so qualified categories are not well matched.
					// This fix remove namespace from the qualified category
					if (reindex){
						s = filterQualifiedProjectCategory (s);
					}
					stmts.add(s);
				}
				queryExecution.close();
				queryExecution = null;
				for (Statement s: stmts){
					qModel.getModel().add(s);
				}
				
			} finally {
				if (queryExecution != null) queryExecution.close();
			}
		}
		//DEBUG Print modified model
		if (debug){
			qModel.getModel().write(new FileOutputStream (new File ("gforge_modified_model.rdf")));
		}
	}

	private Statement filterQualifiedProjectCategory(Statement s) {
		Statement result = s;
		Property predicate = s.getPredicate();
		if (predicate.toString().equals("http://usefulinc.com/ns/doap#category")){
			String object = s.getObject().toString();
			String category = object.substring(object.indexOf("#")+1, object.length());
			RDFNode node = new LiteralImpl (category);
			result = new StatementImpl (s.getSubject(), s.getPredicate(), node);
		}
		return result;
	}

	/**
	 * it removes mapping statements from the ontology to recover the original
	 * state
	 * 
	 * @param ontology
	 *            Ontology to clean up
	 * @throws FileNotFoundException 
	 */
	public void removeMapping() throws FileNotFoundException {
		// Remove new statements from the model
		if (stmts != null){
			for (int i = 0; i < stmts.size(); i++) {
				qModel.getModel().remove((Statement) stmts.get(i));
			}
			stmts = null;
		}
		
		//DEBUG Print restored model
		qModel.getModel().write(new FileOutputStream (new File ("gforge_restored_model.rdf")));
	}

	/**
	 * @deprecated
	 */
	public SemanticQuery translateSemanticQuery(SemanticQuery semanticQuery,
			Mapping mapping) {
		// queryString= "PREFIX foaf: <http://xmlns.com/foaf/0.1/> \r\n"+
		// "PREFIX doap: <http://usefulinc.com/ns/doap#> \r\n"+
		// "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \r\n"+
		// "PREFIX owl: <http://www.w3.org/2002/07/owl#> \r\n"+
		// "PREFIX p1: <http://xmlns.com/wordnet/1.6/> \r\n"+
		// "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \r\n"+
		//"SELECT ?foafPerson  WHERE { ?foafPerson rdf:type foaf:Person . \r\n"+
		// "doap:QualiPSo_XFSearch rdf:type doap:Project. \r\n"+
		// "doap:QualiPSo_XFSearch doap:developer ?foafPerson. \r\n"+
		// "doap:QualiPSo_XFSearch doap:documenter ?foafPerson }";

		// CONSTRUCT {doap:Proj rdf:type rdfs:Class}
		// WHERE {doap:Project rdf:type rdfs:Class}
		// =====================================================
		// CONSTRUCT {foaf:Member rdf:type rdf:Class}
		// WHERE {foaf:Person rdf:type rdfs:Class}
		// =====================================================
		// CONSTRUCT {doap:contributor rdf:type rdf:Property.
		// doap:Proj doap:contributor foaf:Member }
		// WHERE {doap:developer rdf:type rdf:Property.
		// doap:developer rdfs:domain doap:Project.
		// doap:developer rdfs:range foaf:Person.
		// doap:documenter rdf:type rdf:Property.
		// doap:documenter rdfs:domain doap:Project.
		// doap:documenter rdfs:range foaf:Person}
		// =====================================================

		String prefixes = "PREFIX foaf: <http://xmlns.com/foaf/0.1/> \r\n"
				+ "PREFIX doap: <http://usefulinc.com/ns/doap#> \r\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \r\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#> \r\n"
				+ "PREFIX p1: <http://xmlns.com/wordnet/1.6/> \r\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \r\n";

		List<String> ontologyFiles = new ArrayList<String>() {
		};
		ontologyFiles
				.add("D:\\Eclipse QualiPSo WP32\\workspace\\XFSearch\\ontologies\\Second iteration\\ontology A\\OWL-DL\\doap.owl");
		Ontology ontology = new Ontology(new ArrayList<String>(), false);

		String[] mappingSparqlContructs = (String[]) mapping.getMappingSparqlContructs().toArray();
		String mappingSparqlContruct = "";

		String sparqlSemanticQuery = semanticQuery.getSparqlQuery();

		// It does not work. TODO: FIX IT:
		// for (int i=0; i< mappingSparqlContructs.length; i++){
		System.out.println("test de translator: ");

		mappingSparqlContruct = prefixes + "\r\n" + mappingSparqlContructs[0];

		Query queryConstruct = QueryFactory.create(mappingSparqlContruct);
		// //////// CONSTRUCT:
		System.out.println("queryConstruct.getConstructTemplate().toString(): "
				+ queryConstruct.getConstructTemplate().toString());
		// ///////// WHERE:
		System.out.println("queryConstruct.getQueryPattern().toString(): "
				+ queryConstruct.getQueryPattern().toString());

		QueryExecution qexecConstruct = QueryExecutionFactory.create(
				queryConstruct, ontology.getJenaOntModel());
		try {
			Model resultModel = qexecConstruct.execConstruct();
			System.out.println();
			System.out.println("empieza el test de constructString:");
			StmtIterator smtIterator = resultModel.listStatements();
			while (smtIterator.hasNext()) {
				Statement stament = ((Statement) smtIterator.next());
				System.out.println(stament);
				System.out.println(stament.getSubject().getLocalName());

			}
			// System.out.println(resultModel.toString());
			Element semanticQueryElement = semanticQuery.getQuery()
					.getQueryPattern();
			System.out.println("semanticQuery.getQuery().getQueryPattern(): "
					+ semanticQuery.getQuery().getProject());
			// semanticQueryElement.
			Iterator semanticQueryIterator = semanticQueryElement
					.varsMentioned().iterator();
			while (semanticQueryIterator.hasNext()) {
				System.out.println("semanticQueryIterator.next(): "
						+ semanticQueryIterator.next());
			}

			// SIMULATION. WHEN the part above will be fixed, delete this part:

		}

		finally {
			qexecConstruct.close();
		}

		log
				.info("========sparqlSemanticQuery==========="
						+ sparqlSemanticQuery);

		SemanticQuery translatedSemanticQuery = new SemanticQuery(
				sparqlSemanticQuery);
		return translatedSemanticQuery;

		// }

	}

}
