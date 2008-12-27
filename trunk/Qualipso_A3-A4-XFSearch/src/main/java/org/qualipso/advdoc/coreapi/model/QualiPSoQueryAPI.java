package org.qualipso.advdoc.coreapi.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.qualipso.interop.semantics.xfsearch.entity.Mapping;
import org.qualipso.interop.semantics.xfsearch.entity.SemanticTranslator;
import org.qualipso.interop.semantics.xfsearch.utils.FileUtils;
import org.qualipso.interop.semantics.xfsearch.utils.XFSearchProperties;

import tdi.time.TdiChronometer;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.larq.IndexBuilderString;
import com.hp.hpl.jena.query.larq.IndexLARQ;
import com.hp.hpl.jena.query.larq.LARQ;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.shared.Lock;

/*******************************************************************************
 * Copyright (c) 2007 Telefónica I+D, ATOS Origin SAE
 * All rights reserved. This software and the accompanying materials
 * are made available under the terms of the LGPL v1.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/copyleft/lesser.html
 *
 * Contributors:
 *     @author Jose Antonio Quiles, Telefónica I+D -
 *     @author Jesus Gorroñogoitia, jesus.gorronogoitia@atosresearch.eu ATOS Origin SAE -
 *     @author Jesus Martin, Origin SAE -
 *     @author Skeleton automatically generated with FRAWA
 *     @version 1.0
 *     
 *******************************************************************************/

public class QualiPSoQueryAPI extends QualiPSoMetadataAPI {
	private IndexLARQ index;
	private boolean reindexNeeded = false;
	private IndexBuilderString builder;
	private String indexesDirectory;

	public QualiPSoQueryAPI() throws Exception {
		super();
	}
	
	/**
	 * Execute a query on RDF model. It builds the SPARQL sentence from parameters (WS)
	 * @param baseNamespace default namespace
	 * @param prefixes 
	 * @param namespaces same length than prefixes
	 * @param distinct discard equal results
	 * @param vars variables
	 * @param conditions where conditions
	 * @param optionalConditions where conditions (list of ArrayList of String)
	 * @param orderBy var order
	 * @param limit max results
	 * @param offset the start index
	 * @return
	 */
	public SPARQLResultSet execQuery(
			String baseNamespace,
			ArrayList prefixes,
			ArrayList namespaces,
			boolean distinct,
			ArrayList vars,
			ArrayList conditions,
			ArrayList[] optionalConditions,
			String orderBy,
			int limit,
			int offset) {
		
		TdiChronometer crono = new TdiChronometer();
		crono.start();

		String sparql = buildSPARQL(
				baseNamespace, 
				prefixes, 
				namespaces, 
				distinct,
				vars, 
				conditions, 
				optionalConditions,
				orderBy, 
				limit, 
				offset);
		
		SPARQLResultSet rs = null;

		try {
		
			rs = execSPARQL(sparql);
			return rs;
					
		} finally {
			crono.pause();
			debug("execQuery() "+crono.elapsed()+" ms");
		}
		
	}
	
	/**
	 * Execute any SPARQL query on model (WS)
	 * @param sparql
	 * @return
	 */
	public SPARQLResultSet execSPARQL(String sparql) {

		TdiChronometer crono = new TdiChronometer();
		crono.start();
		
		Query query = QueryFactory.create(sparql);

		getModel().enterCriticalSection(Lock.READ);

		QueryExecution qexec = null;
		SPARQLResultSet rset = null;
		try {
			qexec = QueryExecutionFactory.create(query,getModel());
			ResultSet rs = qexec.execSelect();
			
			rset = new SPARQLResultSet(rs,sparql,true);
			
			return rset;
			
		} finally {
			if (qexec != null) {
				qexec.close();
			}
			getModel().leaveCriticalSection();
			crono.pause();
			debug("execSPARQL() "+crono.elapsed()+" ms");
			detail(sparql);
			detail("Result: "+rset.getNumRows());
		}

	}
	
	/**
	 * It performs an heterogeneous cross-forge semantic search in an particular forge
	 * It modifies the forge ontologies and knowledge base with appropriate semantic 
	 * mappings to make it compatible with the query.
	 * @param mapping Semantic mappings
	 * @param sparql Semantic query
	 * @return Search results
	 * @throws FileNotFoundException 
	 */
	public SPARQLResultSet execMappedSPARQL(String mappingList, String sparql) throws FileNotFoundException {
		//Modify remote ontology with mapping constructs
		//Perform search
		SemanticTranslator semanticTranslator = null;
		SPARQLResultSet results = null;
		try {
			// TODO Support multiple mapping sources
			List<String> mappings = extractMappings (mappingList);
			
			getModel().enterCriticalSection(Lock.WRITE);
			
			// Apply mapping statements
			Mapping mapping = new Mapping (mappings);
			semanticTranslator = new SemanticTranslator (this, mapping);
			semanticTranslator.applyMappingsIntoOntModel();
			
			//Reindex model
			boolean reindex = XFSearchProperties.getInstance().isReindexMode();
			if (reindex){
				indexModel();
			}
			// Perform search
			results = execSPARQL (sparql);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Remove mapping statements from the model
			if (semanticTranslator != null){
				semanticTranslator.removeMapping ();
			}
			getModel().leaveCriticalSection();
		}
		
		return results;
	}
	
	/**
	 * Regenerate Lucene indexes
	 */
	public void indexModel() {
		debug("Indexing new statements...");
		
		TdiChronometer crono = new TdiChronometer();
		crono.start();

		try {			
			// Builder to create a Lucene index from RDF data
			if (this.index != null) {
				this.index.close();
			}
			this.builder = new IndexBuilderString(new File(configuration.getIndexesDir()));
			
			// Register the builder in the model
			getModel().register(this.builder);
			
			// Create an index based on existing statements
			this.builder.indexStatements(getModel().listStatements());
			
			// Finish indexing
			this.builder.closeForWriting();
			
			// Unregister
			getModel().unregister(this.builder);
			
			// Create the access index
			this.index = builder.getIndex();
			
			LARQ.setDefaultIndex(this.index);
			
			reindexNeeded = false;
			
		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			crono.pause();
			debug("indexModel() "+crono.elapsed()+" ms");
		}
		
	}
	
	private List<String> extractMappings(String mappingList) throws IOException {
		List<String> mappings = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer (mappingList, ",");
		while (st.hasMoreTokens()){
			mappings.add(FileUtils.readFileAsString(st.nextToken()));
		}
		return mappings;
	}

	/**
	 * It performs an heterogeneous cross-forge semantic search in an particular forge
	 * It modifies the forge ontologies and knowledge base with appropriate semantic 
	 * mappings to make it compatible with the query.
	 * @deprecated
	 * @param construct Semantic mappings
	 * @param select Semantic query
	 * @return Search results
	 */
	public SPARQLResultSet execSPARQLConstructAndSelect(String construct,String select) {

		TdiChronometer crono = new TdiChronometer();
		crono.start();
		
		Query query = QueryFactory.create(construct);

		getModel().enterCriticalSection(Lock.WRITE);
		
		SPARQLResultSet rset = null;
		QueryExecution qConstruct = null;
		
		try {
			// Save complete ontology for debugging
			try {
				getModel().write(new FileOutputStream(new File("ontology.rdf")));
			} catch (FileNotFoundException e) {
				//Ignored
			}
			
			// Execute CONSTRUCT 
			qConstruct = QueryExecutionFactory.create(query,getModel());
			Model constructModel = qConstruct.execConstruct();
			
			// Add new statements to the model
			StmtIterator iter = constructModel.listStatements();
			ArrayList stmts = new ArrayList();
			while (iter.hasNext()) {
				Statement s = iter.nextStatement();
				System.out.println (s);
				stmts.add(s);
				getModel().add(s);
			}
			
			// Save model and complete ontology for debugging
			try {
				constructModel.write(new FileOutputStream(new File("mapped_statements.rdf")));
				getModel().write(new FileOutputStream(new File("extended_ontology.rdf")));
			} catch (FileNotFoundException e) {
				//Ignored
			}

			// Execute SELECT
			rset = execSPARQL(select);

			// Remove new statements from the model
			for (int i = 0;i < stmts.size();i++) {
				getModel().remove((Statement)stmts.get(i));
			}
			
			return rset;
			
		} finally {
			if (qConstruct != null) {
				qConstruct.close();
			}
			getModel().leaveCriticalSection();
			crono.pause();
			debug("execSPARQLConstructAndSelect() "+crono.elapsed()+" ms");
			detail(construct);
			detail(select);
			detail("Result: "+rset.getNumRows());
		}

	}

	/**
	 * Execute any SPARQL ask on model (WS)
	 * @param sparql
	 * @return
	 */
	public boolean execSPARQLAsk(String sparql) {

		TdiChronometer crono = new TdiChronometer();
		crono.start();
		
		boolean result = false;
		
		Query query = QueryFactory.create(sparql);

		getModel().enterCriticalSection(Lock.READ);

		QueryExecution qexec = null;
		try {
			qexec = QueryExecutionFactory.create(query,getModel());
			result = qexec.execAsk();
			
			return result;
			
		} finally {
			if (qexec != null) {
				qexec.close();
			}
			getModel().leaveCriticalSection();
			crono.pause();
			debug("execSPARQLAsk() "+crono.elapsed()+" ms");
			detail(sparql);
			detail("Result: "+result);
		}

	}

	
	/**
	 * Build a SPARQL query string from query components
	 * @param baseNamespace
	 * @param prefixes
	 * @param namespaces
	 * @param distinct
	 * @param vars
	 * @param conditions
	 * @param optionalConditions list of ArrayList of String
	 * @param orderBy
	 * @param limit
	 * @param offset
	 * @return
	 */
	public String buildSPARQL(
			String baseNamespace,
			ArrayList prefixes,
			ArrayList namespaces,
			boolean distinct,
			ArrayList vars,
			ArrayList conditions,
			ArrayList[] optionalConditions,
			String orderBy,
			int limit,
			int offset) {
		
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		
		StringBuffer sb = new StringBuffer();

		if (prefixes.size() != namespaces.size()) {
			throw new IllegalArgumentException("Prefixes size not matches namespaces size");
		}
		
		if (baseNamespace != null && baseNamespace.length() > 0) {
			sb.append("BASE <");
			sb.append(baseNamespace);
			sb.append('>');
			sb.append('\r');
			sb.append('\n');
		}
		
		for (int i = 0;i < prefixes.size();i++) {
			sb.append("PREFIX ");
			sb.append((String)prefixes.get(i));
			sb.append(": ");
			sb.append('<');
			sb.append((String)namespaces.get(i));
			sb.append('>');
			sb.append('\r');
			sb.append('\n');
		}

		sb.append("SELECT ");
		if (distinct) {
			sb.append("DISTINCT ");
		}
		for (int i = 0;i < vars.size();i++) {
			sb.append(" ?");
			sb.append((String)vars.get(i));
		}
		sb.append('\r');
		sb.append('\n');
		
		sb.append("WHERE {");
		sb.append('\r');
		sb.append('\n');

		for (int i = 0;i < conditions.size();i++) {
			sb.append("    ");
			sb.append((String)conditions.get(i));
			sb.append(" .");
			sb.append('\r');
			sb.append('\n');
		}

		for (int i = 0;i < optionalConditions.length;i++) {
			sb.append("    OPTIONAL { ");
			sb.append('\r');
			sb.append('\n');
			ArrayList optionalGroup = optionalConditions[i];
			for (int j = 0;j < optionalGroup.size();j++) {
				String optional = (String)optionalGroup.get(j);
				sb.append("        ");
				sb.append(optional);
				sb.append(" . ");
				sb.append('\r');
				sb.append('\n');
			}
			sb.append("    }");
			sb.append('\r');
			sb.append('\n');
		}

		sb.append("}");
		sb.append('\r');
		sb.append('\n');

		if (orderBy != null && orderBy.length() > 0) {
			sb.append("ORDER BY ");
			sb.append(orderBy);
			sb.append('\r');
			sb.append('\n');
		}
		
		if (limit > 0) {
			sb.append("LIMIT "+limit);
			sb.append('\r');
			sb.append('\n');			
		}

		if (offset > 0) {
			sb.append("OFFSET "+offset);
			sb.append('\r');
			sb.append('\n');			
		}

		crono.pause();
		
		debug("buildSPARQL() "+crono.elapsed()+" ms");
		detail("Result: "+sb.toString());
		
		return sb.toString();
		
	}

	/**
	 * Build a SPARQL query string from query components
	 * @param baseNamespace
	 * @param prefixes
	 * @param namespaces
	 * @param conditions
	 * @param optionalConditions list of ArrayList of String
	 * @return
	 */
	public String buildSPARQLAsk(
			String baseNamespace,
			ArrayList prefixes,
			ArrayList namespaces,
			ArrayList conditions,
			ArrayList[] optionalConditions) {
		
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		
		StringBuffer sb = new StringBuffer();

		if (prefixes.size() != namespaces.size()) {
			throw new IllegalArgumentException("Prefixes size not matches namespaces size");
		}
		
		if (baseNamespace != null && baseNamespace.length() > 0) {
			sb.append("BASE <");
			sb.append(baseNamespace);
			sb.append('>');
			sb.append('\r');
			sb.append('\n');
		}
		
		for (int i = 0;i < prefixes.size();i++) {
			sb.append("PREFIX ");
			sb.append((String)prefixes.get(i));
			sb.append(": ");
			sb.append('<');
			sb.append((String)namespaces.get(i));
			sb.append('>');
			sb.append('\r');
			sb.append('\n');
		}

		sb.append("ASK ");
		sb.append('\r');
		sb.append('\n');
		
		sb.append("WHERE {");
		sb.append('\r');
		sb.append('\n');

		for (int i = 0;i < conditions.size();i++) {
			sb.append("    ");
			sb.append((String)conditions.get(i));
			sb.append(" .");
			sb.append('\r');
			sb.append('\n');
		}

		for (int i = 0;i < optionalConditions.length;i++) {
			sb.append("    OPTIONAL { ");
			sb.append('\r');
			sb.append('\n');
			ArrayList optionalGroup = optionalConditions[i];
			for (int j = 0;j < optionalGroup.size();j++) {
				String optional = (String)optionalGroup.get(j);
				sb.append("        ");
				sb.append(optional);
				sb.append(" . ");
				sb.append('\r');
				sb.append('\n');
			}
			sb.append("    }");
			sb.append('\r');
			sb.append('\n');
		}

		sb.append("}");
		sb.append('\r');
		sb.append('\n');

		crono.pause();
		
		debug("buildSPARQLAsk() "+crono.elapsed()+" ms");
		detail("Result: "+sb.toString());
		
		return sb.toString();
		
	}

	
	public static void main(String[] args) {
		try {
			
			QualiPSoQueryAPI model = new QualiPSoQueryAPI();
			
			String query1    = 
				   "PREFIX foaf: <http://xmlns.com/foaf/0.1/> "
				+  "SELECT ?person "
				+  "WHERE {"
				+  "    ?person foaf:surname \"Quiles\""
				+  "      }";
			
			String query2 = 
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
				"SELECT DISTINCT  ?infosrc " +
				"WHERE { " +
				"?infosrc rdf:type <http://www.qualipso.org/ontology/doc/qualipso_documentation#TextDocument> . "+
				"}";
			
			String query3 =
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
				"SELECT DISTINCT  ?forumpost ?forumpost_content_encoded "+
				"WHERE { "+
				"?forumpost rdf:type <http://rdfs.org/sioc/ns#Post> . "+
				"OPTIONAL { ?forumpost <http://rdfs.org/sioc/ns#content_encoded> ?forumpost_content_encoded . } "+
				"}";
			
			String query4 =
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
				"	SELECT DISTINCT  ?source ?source_filename ?source_hasInterface_name "+
				"	WHERE { "+
				"	    ?source rdf:type <http://www.qualipso.org/ontology/doc/qualipso_source_code#SourceCodeFile> . "+
				"       OPTIONAL {"+
				"           ?source <http://www.qualipso.org/ontology/doc/qualipso_source_code#filename> ?source_filename . " +
				"       }"+
				"	    OPTIONAL { " +
				"           ?source <http://www.qualipso.org/ontology/doc/qualipso_source_code#hasInterface> ?source_hasInterface ." +
				"           ?source_hasInterface <http://www.qualipso.org/ontology/doc/qualipso_source_code#name> ?source_hasInterface_name . "+
				"       }" +
				"	}";

			String ask1    = 
				   "PREFIX foaf: <http://xmlns.com/foaf/0.1/> "
				+  "ASK "
				+  "WHERE {"
				+  "    ?person foaf:surname \"Quiles\""
				+  "      }";

			
			// execSPARQL()
			SPARQLResultSet rs = model.execSPARQL(query1);
			System.out.println("query1:\n"+rs);

			// execSPARQL()
			rs = model.execSPARQL(query2);
			System.out.println("query2:\n"+rs);

			// execSPARQL()
			rs = model.execSPARQL(query3);
			System.out.println("query3:\n"+rs);

			// execSPARQL()
			rs = model.execSPARQL(query4);
			System.out.println("query4:\n"+rs);

			// execSPARQL()
			boolean resultAsk = model.execSPARQLAsk(ask1);
			System.out.println("ask1:\n"+resultAsk);

			// buildSPARQL()
			ArrayList prefixes = new ArrayList();
			prefixes.add("foaf");
			prefixes.add("qdoc");
			prefixes.add("qsc");
			prefixes.add("qrs");
			ArrayList namespaces = new ArrayList();
			namespaces.add("http://xmlns.com/foaf/0.1/");
			namespaces.add("http://www.qualipso.org/ontology/doc/qualipso_documentation#");
			namespaces.add("http://www.qualipso.org/ontology/doc/qualipso_source_code#");
			namespaces.add("http://www.qualipso.org/ontology/doc/qualipso_relationship#");
			ArrayList vars = new ArrayList();
			vars.add("person");
			ArrayList conditions = new ArrayList();
			conditions.add("?person foaf:surname \"Quiles\"");
			ArrayList optionalConditions = new ArrayList();
			optionalConditions.add("?person foaf:firstName \"Jose Antonio\"");
			optionalConditions.add("?person foaf:lastName \"Quiles\"");
			query1 = model.buildSPARQL(
					"http://www.qualipso.org/",  //baseNamespace, 
					prefixes, 
					namespaces, 
					true,
					vars,
					conditions, 
					new ArrayList[] { optionalConditions },
					null, 
					20, 
					0);
			System.out.println(query1);
			
			rs = model.execSPARQL(query1);
			System.out.println(rs);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
