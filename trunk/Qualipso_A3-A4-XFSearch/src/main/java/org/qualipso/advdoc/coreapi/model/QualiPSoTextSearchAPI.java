package org.qualipso.advdoc.coreapi.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.qualipso.advdoc.coreapi.ontology.QualiPSoDOC;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoRS;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoSC;

import tdi.time.TdiChronometer;

import com.hp.hpl.jena.query.larq.IndexBuilderString;
import com.hp.hpl.jena.query.larq.IndexLARQ;
import com.hp.hpl.jena.query.larq.LARQ;
import com.hp.hpl.jena.shared.Lock;
import com.hp.hpl.jena.vocabulary.RDF;

public class QualiPSoTextSearchAPI extends QualiPSoQueryAPI {

	public static final String SEARCH_NAMESPACE = "http://jena.hpl.hp.com/ARQ/property#";
	
	public static final String SEARCH_PROPERTY = "textMatch";
	
	private String indexesDirectory;
	
	private IndexBuilderString builder;
	
	private IndexLARQ index;
	
	private ReindexThread reindexThread;
	
	private boolean reindexNeeded = false;
	
	/**
	 * Constructor
	 * @throws Exception
	 */
	public QualiPSoTextSearchAPI() throws Exception {
		super();	
		this.indexesDirectory = configuration.getIndexesDir();
		this.reindex();
		
		// Reindex Thread
		if (configuration.getReindexTimeout() > 0) {
			debug("Starting reindex thread with "+configuration.getReindexTimeout()+" seconds...");
			this.reindexThread = new ReindexThread(this,configuration.getReindexTimeout());
			this.reindexThread.start();
		}

	}
	
	void setModified() {
		super.setModified();
		this.reindexNeeded = true;
	}
	
	public boolean isReindexNeeded() {
		return reindexNeeded;
	}
	
	/**
	 * Search RDF statements with text
	 * @param textSearch
	 * @return
	 */
	public SPARQLResultSet execSimpleTextSearch(String textSearch) {
		
		StringBuffer sparql = new StringBuffer();
		
		sparql.append("PREFIX lucene: <"+SEARCH_NAMESPACE+">");
		sparql.append('\r');
		sparql.append('\n');
		sparql.append("SELECT DISTINCT ?score ?subject ?predicate ?text ");
		sparql.append('\r');
		sparql.append('\n');
		sparql.append("WHERE {");
		sparql.append('\r');
		sparql.append('\n');
		sparql.append("    (?text ?score) lucene:"+SEARCH_PROPERTY+" '+"+textSearch+"' .");
		sparql.append('\r');
		sparql.append('\n');
		sparql.append("    ?subject ?predicate ?text");
		sparql.append('\r');
		sparql.append('\n');
		sparql.append("}");
		sparql.append('\r');
		sparql.append('\n');
		
		SPARQLResultSet result = execSPARQL(sparql.toString());
		
		debug("execSimpleTextSearch()");
		detail("text   : "+textSearch);
		detail("result : "+result.getNumRows());
		
		return result;
		
	}
	
	public static class TextSearchCondition {
		private String variable;
		private String text;
		public TextSearchCondition(String variable,String text) {
			this.variable = variable;
			this.text = text;
		}
		public String getVariable() {
			return variable;
		}
		public String getText() {
			return text;
		}
	}

	/**
	 * Execute a query on RDF model (it can include text search). It builds the SPARQL sentence from parameters
	 * @param baseNamespace default namespace
	 * @param prefixes
	 * @param namespaces same length than prefixes
	 * @param vars variables
	 * @param distinct discard equal results
	 * @param conditions where conditions
	 * @param optionalConditions where conditions
	 * @param textSearchConditions List of QualiPSoTextSearchAPI.TextSearchCondition 
	 * @param orderBy var order
	 * @param limit max results
	 * @param offset the start index
	 * @return
	 */
	public SPARQLResultSet execSearch(
			String baseNamespace,
			ArrayList prefixes,
			ArrayList namespaces,
			ArrayList vars,
			boolean distinct,
			ArrayList conditions,
			ArrayList[] optionalConditions,
			ArrayList textSearchConditions,
			String orderBy,
			int limit,
			int offset) {

		TdiChronometer crono = new TdiChronometer();
		crono.start();
		
		if (textSearchConditions != null) {
			namespaces.add(SEARCH_NAMESPACE);
			prefixes.add("lucene");
			for (int i = 0;i < textSearchConditions.size();i++) {
				TextSearchCondition condition = (TextSearchCondition)textSearchConditions.get(i);
				// create a text search condition
				conditions.add("?"+condition.variable+" lucene:"+SEARCH_PROPERTY+" '"+condition.text+"'");
			}
		}
		
		try {
			// call parent class
			SPARQLResultSet rs = super.execQuery(
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
			
			return rs;
			
		} finally {
			crono.pause();
			debug("execSearch() "+crono.elapsed()+" ms");
		}
	}
	
	/**
	 * Compute the search result size
	 * @param text (including patterns)
	 * @return the number of results
	 */
	public int getSearchSize(String text) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		
		try {
			Iterator it = index.search(text);
			int c = 0;
			while (it.hasNext()) {
				it.next();
				c++;
			}
			return c;
		} finally {
			crono.pause();
			debug("getSearchSize() "+crono.elapsed()+" ms");
			detail(text);
		}
	}

	/**
	 * Regenerate Lucene indexes
	 */
	public void reindex() {

		debug("Indexing statements...");
		
		TdiChronometer crono = new TdiChronometer();
		crono.start();

		getModel().enterCriticalSection(Lock.WRITE);

		try {			
			
			// Builder to create a Lucene index from RDF data
			if (this.index != null) {
				this.index.close();
			}
			this.builder = new IndexBuilderString(new File(this.indexesDirectory));
			
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
			
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("reindex() "+crono.elapsed()+" ms");
		}
		
	}
	
	public static void main(String[] args) {
		try {
			
			QualiPSoTextSearchAPI model = new QualiPSoTextSearchAPI();
			
			// execSimpleTextSearch()
			String searchText = "jose*";
			SPARQLResultSet rs = model.execSimpleTextSearch(searchText);
			System.out.println("execSimpleTextSearch() - Searching: "+searchText);
			System.out.println(rs.toString());
			
			// execSearch()
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
			vars.add("text");
			ArrayList conditions = new ArrayList();
			ArrayList optionalConditions = new ArrayList();
			ArrayList tsc = new ArrayList();
			tsc.add(new QualiPSoTextSearchAPI.TextSearchCondition("text","QualiPSo"));
			rs = model.execSearch(
					null, 
					prefixes, 
					namespaces, 
					vars, 
					true, 
					conditions,
					new ArrayList[] { optionalConditions },
					tsc,
					null, 
					0, 
					0);
			
			System.out.println("execSearch() - Searching: "+searchText);
			System.out.println(rs.toString());

			// ADVANCED QUERIES
			
			System.out.println("SPARQL: Get document title with a figure entitled \"Architecture for information and documentation advanced tools\"");
			String query = 
				   "PREFIX qdoc: <"+QualiPSoDOC.NS+"> \n"
				+  "PREFIX rdf:  <"+RDF.getURI()+"> \n"
				+  "SELECT ?title ?sectionTitle \n"
				+  "WHERE { \n"
				+  "    ?figure rdf:type qdoc:Figure . \n"				
				+  "    ?figure qdoc:title \"Architecture for information and documentation advanced tools\" . \n"
				+  "    ?section qdoc:hasElement ?figure . \n"
				+  "    ?doc qdoc:hasElement ?section . \n"
				+  "    ?doc qdoc:title ?title . \n"
				+  "    ?section qdoc:title ?sectionTitle . \n"
				+  "      }";

			rs = model.execSPARQL(query);
			System.out.println(rs);

			//---------------------------------------------------------------
			
			System.out.println("SPARQL: Get document title with a figure whose title includes \"architecture\"");
			query = 
				   "PREFIX qdoc: <"+QualiPSoDOC.NS+"> \n"
				+  "PREFIX rdf:  <"+RDF.getURI()+"> \n"
				+  "PREFIX lucene:  <"+SEARCH_NAMESPACE+"> \n"
				+  "SELECT ?doc ?docTitle ?figTitle \n"
				+  "WHERE { \n"
				+  "    ?figure rdf:type qdoc:Figure . \n"
				+  "    ?figTitle lucene:"+SEARCH_PROPERTY+" '+architecture' . \n"				
				+  "    ?figure qdoc:title ?figTitle . \n"
				+  "    ?section qdoc:hasElement ?figure . \n"
				+  "    ?doc qdoc:hasElement ?section . \n"
				+  "    ?doc qdoc:title ?docTitle . \n"
				+  "      }";

			rs = model.execSPARQL(query);
			System.out.println(rs);

			//---------------------------------------------------------------
			
			System.out.println("SPARQL: Get document and section titles with a section talking on \"QualiPSo\"");
			query = 
				   "PREFIX qdoc: <"+QualiPSoDOC.NS+"> \n"
				+  "PREFIX rdf:  <"+RDF.getURI()+"> \n"
				+  "PREFIX lucene:  <"+SEARCH_NAMESPACE+"> \n"
				+  "SELECT ?docTitle ?sectionTitle \n"
				+  "WHERE { \n"
				+  "    ?contents lucene:"+SEARCH_PROPERTY+" '+QualiPSo' . \n"				
				+  "    ?text qdoc:textContents ?contents . \n"
				+  "    ?section qdoc:hasText ?text . \n"
				+  "    ?doc qdoc:hasElement ?section . \n"
				+  "    ?doc qdoc:title ?docTitle . \n"
				+  "    ?section qdoc:title ?sectionTitle . \n"
			+  "      }";

			rs = model.execSPARQL(query);
			System.out.println(rs);

			//---------------------------------------------------------------
			
			System.out.println("SPARQL: Get document title, section title and number, which are documenting the class \"ShowSchema\"");
			query = 
				   "PREFIX qdoc: <"+QualiPSoDOC.NS+"> \n"
				+  "PREFIX qrs: <"+QualiPSoRS.NS+"> \n"
				+  "PREFIX qsc: <"+QualiPSoSC.NS+"> \n"
				+  "PREFIX rdf:  <"+RDF.getURI()+"> \n"
				+  "SELECT DISTINCT ?docTitle ?sectionNumber ?sectionTitle \n"
				+  "WHERE { \n"
				+  "    ?class qsc:name 'ShowSchema' .\n"
				+  "    ?file qsc:hasClass ?class . \n"
				+  "    ?section qrs:documentsSourceCode ?file . \n"
				+  "    ?doc qdoc:hasElement ?section . \n"
				+  "    ?doc qdoc:title ?docTitle . \n"
				+  "    ?section qdoc:title ?sectionTitle . \n"
				+  "    ?section qdoc:sectionNumber ?sectionNumber . \n"
			+  "      }";

			rs = model.execSPARQL(query);
			System.out.println(rs);

			//---------------------------------------------------------------

			int a = model.getSearchSize("a*");
			int an = model.getSearchSize("an*");
			int ant = model.getSearchSize("ant*");
			int anto = model.getSearchSize("anto*");

			System.out.println("PROGRESS SEARCH: "+a+","+an+","+ant+","+anto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
