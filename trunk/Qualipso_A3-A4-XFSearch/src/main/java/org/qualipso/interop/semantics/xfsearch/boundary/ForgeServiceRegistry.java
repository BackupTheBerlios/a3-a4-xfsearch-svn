package org.qualipso.interop.semantics.xfsearch.boundary;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.qualipso.advdoc.ws.client.search.service.QualiPSoSearchAPISoapClient;
import org.qualipso.interop.semantics.xfsearch.entity.ForgeServiceSpecification;
import org.qualipso.interop.semantics.xfsearch.entity.Ontology;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionCompulsoryParameter;
import org.qualipso.interop.semantics.xfsearch.exception.XFSearchExceptionFileNotFound;
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
 * It is a registry of local and remote forges XFSearch services. 
 * It provides a proxy the XFSearch service corresponding to the forge identified by id.
 */
public class ForgeServiceRegistry {

	private static ForgeServiceRegistry instance = null;
	private XFSearchProperties xfSearchProperties = null;
	private ForgeService localForgeServiceProxy = null;
	List<ForgeService> remoteForgeServiceProxies = null;
	
	/**
	 * Create the singleton instance of ForgeRegistryService
	 */
	
	private ForgeServiceRegistry(XFSearchProperties xfSearchProperties){
		this.xfSearchProperties = xfSearchProperties;
	}
	
	/**
	 * Return the singleton instance of ForgeRegistryService
	 * @param xfSearchProperties XFSearch properties object
	 * @return singleton instance
	 */
	public static ForgeServiceRegistry getInstance(XFSearchProperties xfSearchProperties) {
		if (instance == null){
			instance = new ForgeServiceRegistry (xfSearchProperties);
		}
		return instance;
	}
	
	/**
	 * Return the singleton instance of ForgeRegistryService
	 * @return Singleton instance of ForgeRegistryService
	 */
	public static ForgeServiceRegistry getInstance() {
		return instance;
	}
	
	/**
	 * Set forges
	 * @return Singleton instance of ForgeRegistryService
	 * @throws MalformedURLException 
	 * @throws XFSearchExceptionFileNotFound 
	 * @throws XFSearchExceptionCompulsoryParameter 
	 */
	public void setForgesIds(List<String> forgeIds) throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound, MalformedURLException {
		getForgeServiceProxies (forgeIds);
	}
	

	/**
	 * Provides a forge XFSearch service proxy object for the forge identified by forgeId
	 * @param forgeId universal unique identifier of a forge
	 * @param local it flags a local forge service
	 * @return Forge XFSearch service proxy object
	 * @throws XFSearchExceptionFileNotFound 
	 * @throws XFSearchExceptionCompulsoryParameter 
	 * @throws MalformedURLException 
	 */
	private ForgeService getForgeServiceProxy (String forgeId, boolean local) throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound, MalformedURLException{
		ForgeServiceSpecification fss = new ForgeServiceSpecification();
		
		//Id
		fss.setId(forgeId);
		
		//Type
		fss.setType(ForgeServiceSpecification.ForgeType.getType(xfSearchProperties.getForgeType(forgeId)));
		
		//Local forge
		fss.setLocal(local);
		
		// Ontologies
//		ArrayList<String> forgeOntologiesURLs = new ArrayList<String>();
//		forgeOntologiesURLs.addAll(xfSearchProperties.getForgeOntologies(forgeId));
//		fss.setOntologiesURL(forgeOntologiesURLs);
		
		// Load Ontologies
//		Ontology ontology = new Ontology(fss.getOntologiesURL(), usePellet);
//		fss.setOntology(ontology);
		
		// Mappings (only for remote ontologies)
		if (!local){
			ArrayList<String> forgeMappingsURLs = new ArrayList<String>();
			forgeMappingsURLs.addAll(xfSearchProperties.getForgeMappings(forgeId));
			fss.setMappingsURL(forgeMappingsURLs);
		}
		
		//Search service URL
		fss.setServiceURL(xfSearchProperties.getForgeURL(forgeId));
		
		//Search service stub
		QualiPSoSearchAPISoapClient searchStub = new QualiPSoSearchAPISoapClient (fss.getServiceURL(), null, null, null);
		fss.setStub (searchStub);
		
		ForgeService proxy = new ForgeService (fss);
		return proxy;
	}
	
	/**
	 * Return ForgeServiceProxy list of remote forges identified by forgesIds
	 * @param forgeIds List of forges identifiers
	 * @return List of forge XFSearch service proxies
	 * @throws XFSearchExceptionFileNotFound 
	 * @throws XFSearchExceptionCompulsoryParameter 
	 * @throws MalformedURLException 
	 */
	private void getForgeServiceProxies (List<String> forgeIds) throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound, MalformedURLException{
		remoteForgeServiceProxies = new ArrayList<ForgeService> ();
		for (String forgeId: forgeIds){
			boolean local = xfSearchProperties.isLocalForge (forgeId);
			if (!local){
				ForgeService proxy = getForgeServiceProxy(forgeId, local);
				remoteForgeServiceProxies.add(proxy);
			}
		}
	}
	
	public List<ForgeService> getRemoteForgeServiceProxies () throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound, MalformedURLException{
		return remoteForgeServiceProxies;
	}

	public ForgeService getLocalForgeServiceProxy() throws XFSearchExceptionCompulsoryParameter, XFSearchExceptionFileNotFound, MalformedURLException {
		return getForgeServiceProxy(xfSearchProperties.getLocalForgeName(), true);
	}
}
