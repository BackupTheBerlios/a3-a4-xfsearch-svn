//4de0e5e1b5174cf7cd61ac16ef0f22a

/* 1.0 */

//-----------------------------------------------------------------
//Fichero : SearchCrossForgeService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.xf.service;

/*******************************************************************************
 * Copyright (c) 2007 ATOS Origin SAE, Telefónica I+D
 * All rights reserved. This software and the accompanying materials
 * are made available under the terms of the LGPL v1.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/copyleft/lesser.html
 *
 * Contributors:
 *     @author Jesus Gorroñogoitia, jesus.gorronogoitia@atosresearch.eu ATOS Origin SAE -
 *     @author Jesus Martin, Origin SAE -
 *     @author Jose Antonio Quiles, Telefónica I+D -
 *     @author Skeleton automatically generated with FRAWA
 *     @version 1.0
 *     
 *******************************************************************************/


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qualipso.advdoc.coreapi.model.SPARQLResultSet;
import org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_resp;
import org.qualipso.advdoc.ws.client.search.beans.SPARQLResult;
import org.qualipso.advdoc.ws.client.search.service.QualiPSoSearchAPISoapClient;
import org.qualipso.advdoc.ws.client.xf.beans.Forge;
import org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_req;
import org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_resp;
import org.qualipso.interop.semantics.xfsearch.control.XFSearchController;
import org.qualipso.interop.semantics.xfsearch.entity.ForgeTarget;
import org.qualipso.interop.semantics.xfsearch.entity.ResultsAggregator;
import org.qualipso.interop.semantics.xfsearch.entity.SearchCriteria;
import org.qualipso.interop.semantics.xfsearch.entity.SemanticQuery;
import org.qualipso.interop.semantics.xfsearch.model.Mapping;
import org.qualipso.interop.semantics.xfsearch.utils.XFSearchProperties;

/**
 * This service performs the cross-forge semantic search process
 */
public class CrossForgeSearchService extends GenSearchCrossForgeService {


	private Log log = LogFactory.getLog(CrossForgeSearchService.class);

    /**
     * It performs the cross-forge semantic search process
     * @param    __inbean    Input parameter (it contains a String[] object with available forges Ids )  
     * @param    __outbean    Output parameter (it contains a ResultSet[] object with the obtained results) 
     * @param    context    Operation context
     * @throws   Exception    Exception throw by this service during its execution in case of exceptiona situation
     */
	public void execute(SearchCrossForge_req __inbean,SearchCrossForge_resp __outbean,ServletContext context) throws Exception {

		// It performs the cross-forge search
		performCrossForgeSearch (__inbean, __outbean);
		
		// Old version
//		performCrossForgeSearch_old (__inbean, __outbean);
	}
	
	/**
	 * It performs the cross-forge semantic search process
	 * @deprecated
	 * @param __inbean
	 * @param __outbean
	 * @throws Exception
	 */
	private void performCrossForgeSearch_old (SearchCrossForge_req __inbean, SearchCrossForge_resp __outbean) throws Exception {
		XFSearchProperties xFSearchProperties = XFSearchProperties.getInstance("xfsearch_old");
//		ArrayList responses = new ArrayList();
		String localForgeName = "QualiPSo";
		String forgeName = __inbean.getForges(0).getForgeName();
		String forgeURL = null;
		QualiPSoSearchAPISoapClient stub = null;
		ExecSPARQL_resp execSPARQL_resp = null;
		ExecSPARQL_req execSPARQL_req = null;
		SPARQLResult sparqlResult = null;
		boolean performedLocalSearch = false;
		ArrayList<SPARQLResult> responses = new ArrayList<SPARQLResult>();
		// Perform local forge search?
		if (forgeName.equalsIgnoreCase(localForgeName)){
			performedLocalSearch = true;
			forgeURL = xFSearchProperties.getPropertyValue("forges.url."+__inbean.getForges(0).getForgeName());
			log.info("Size of requested forges: "+__inbean.forges_size());
			log.info("localForgeName: "+forgeName);
			log.info("forgeURL of localForgeName: "+forgeURL);
			
			stub = new QualiPSoSearchAPISoapClient(forgeURL,null, null, null );
			//QualiPSoSearchAPISoapClient stub = new QualiPSoSearchAPISoapClient("http://"+__inbean.getForges(0).getForgeName()+"/ws/search",null,null,null);
			execSPARQL_req = new ExecSPARQL_req(__inbean.getSparql()); 
			execSPARQL_resp = stub.ExecSPARQL(execSPARQL_req);
			sparqlResult = execSPARQL_resp.getResult();
			responses.add(sparqlResult);
		}
		
		// Remote Forges search
		int iForge = performedLocalSearch? 1: 0;
		for (int i = iForge; i < __inbean.forges_size(); i++) {
			String remoteForgeName= __inbean.getForges(i).getForgeName();
			forgeURL = xFSearchProperties.getPropertyValue("forges.url."+remoteForgeName);
			log.info("forgeURL of remoteForgeName: "+remoteForgeName);
			stub = new QualiPSoSearchAPISoapClient(forgeURL,null,null,null);
			String mappingPath = xFSearchProperties.getPropertyValue("mapping."+localForgeName+"."+remoteForgeName);
			log.info("mappingPath: "+mappingPath);
			
			if (mappingPath==null){
				//Homogeneous case
				execSPARQL_req = new ExecSPARQL_req(__inbean.getSparql()); 
				execSPARQL_resp = stub.ExecSPARQL(execSPARQL_req);
				sparqlResult = execSPARQL_resp.getResult();
				responses.add(sparqlResult);    			 
			}
			
			if (mappingPath!=null){
				//Heterogeneus case
				Mapping mapping = new Mapping (mappingPath);
				String[] mappingConstruct = mapping.getMappingSparqlContruct();
				if (mappingConstruct==null || mappingConstruct.length==0){
					log.error("There is no any file: "+mappingPath);
					throw new Exception ("It was not possible to carry out the heterogeneous cross forge search");
				}
				ExecConstructAndSearch_req execConstructAndSearch_req = new ExecConstructAndSearch_req(__inbean.getSparql(),mappingConstruct[0]);
				ExecConstructAndSearch_resp execConstructAndSearch_resp = stub.ExecConstructAndSearch(execConstructAndSearch_req);
				sparqlResult = execConstructAndSearch_resp.getResult();
				responses.add(sparqlResult);
			}    		 
		}

		// Join responses
		ResultsAggregator resultsAggregator = new ResultsAggregator(); 
		SPARQLResult totalSPARQLResult = resultsAggregator.consolidateResults(responses);
		
		// fill __outbean
		__outbean.setResult(totalSPARQLResult);
	}
	
	/**
	 * cross-forge semantic search core process
	 * @param    __inbean    Input parameter (it contains a String[] object with available forges Ids )  
     * @param    __outbean    Output parameter (it contains a String[] object with available forges Ids 
     * and a String object with the SPARQL query)
	 * @throws   Exception    Exception throw by this service during its execution in case of exceptiona situation
	 */
	private void performCrossForgeSearch (SearchCrossForge_req __inbean, SearchCrossForge_resp __outbean) throws Exception {
		// It performs cross-forge semantic search (homogeneous | heterogeneous)
		// It let control to XFSearchController
		
		// Getting list of forges selected by user where to perform the cross-forge search
		// local forge may be included or not
		if (__inbean.getSparql() == null){
			throw new Exception ("Please, provide a search criteria useful to create a query");
		}
		
		SearchCriteria sc = getSearchCriteria(__inbean);
		// It invokes control for cross-forge search
		// Cross-forge configuration taken from class path
		Map<String, SPARQLResult> xfsr = new XFSearchController(null).performXFSearch(sc);
		
		// Separate results view by forge
		SPARQLResult totalSPARQLResult = new ResultsAggregator().consolidateResults(xfsr);
		
		// Provisional results preparation since separation amongst forges is not supported
//		ArrayList<SPARQLResult> responses = new ArrayList<SPARQLResult>();
//		for (SPARQLResult result:xfsr.values()){
//			responses.add(result);
//		}
//		SPARQLResult totalSPARQLResult = new ResultsAggregator().consolidateResults(responses);
		__outbean.setResult(totalSPARQLResult);
	}

	/**
	 * It extract a SearchCriteria object from the service input parameter	
	 * @param    __inbean    Input parameter (it contains a String[] object with available forges Ids )  
	 * @return Search criteria
	 */
	private SearchCriteria getSearchCriteria(SearchCrossForge_req __inbean) {
		// List of forges upon where to perform the cross-forge search
		// It may or not include the local forge
		List<ForgeTarget> forges = new ArrayList<ForgeTarget>();
		Forge[] _forges = __inbean.getForges();
		for (int i=0; i<_forges.length; i++){
			ForgeTarget ft = new ForgeTarget ();
			ft.setId(_forges[i].getForgeName());
			forges.add(ft);
		}
		// Creating search criteria (includes list of forges and query)
		SearchCriteria sc = new SearchCriteria ();
		String query = __inbean.getSparql();
		SemanticQuery semanticQuery = new SemanticQuery (query);
		sc.setSemanticQuery(semanticQuery);
		sc.setRemoteForges(forges);
		return sc;
	}


}
