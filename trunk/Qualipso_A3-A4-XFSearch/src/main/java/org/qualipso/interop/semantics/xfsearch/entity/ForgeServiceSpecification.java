package org.qualipso.interop.semantics.xfsearch.entity;

import java.util.ArrayList;
import java.util.List;

import org.qualipso.advdoc.ws.client.search.service.QualiPSoSearchAPISoapClient;

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
 * It represents the specification of remote forge services.
 */
public class ForgeServiceSpecification {
	/**
	 * Forge type identifiers
	 */
	public enum ForgeType {
		QUALIPSO("QUALIPSO"), GFORGE("GFORGE");
		String id;
		ForgeType (String id){
			this.id = id;
		}
		public static ForgeType getType(String type){
			if (type.equalsIgnoreCase("QUALIPSO")){
				return QUALIPSO;
			} else if (type.equalsIgnoreCase("GFORGE")){
				return GFORGE;
			} else {
				return null;
			}
		}
	};
	
	String id;
	List<String> ontologiesURL = new ArrayList<String>();
	List<String> mappingsURL = new ArrayList<String>();
	ForgeType type;
	Ontology ontology = null;
	boolean isLocal = false;
	String URL = null;
	QualiPSoSearchAPISoapClient stub = null;
	
	public QualiPSoSearchAPISoapClient getStub() {
		return stub;
	}

	public String getServiceURL() {
		return URL;
	}

	public void setServiceURL(String url) {
		URL = url;
	}

	/**
	 * it flags a forge as local or as remote
	 * @return Local boolean flag
	 */
	public boolean isLocal() {
		return isLocal;
	}

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	/**
	 * it returns the forge type
	 * @return forge type
	 */
	public ForgeType getType() {
		return type;
	}

	public void setType(ForgeType type) {
		this.type = type;
	}

	/**
	 * it returns the forge unique identifier
	 * @return forge identifier
	 */
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * it returns the ontology used by forge for internal information representation
	 * @return Forge ontology
	 */
	public Ontology getOntology() {
		return ontology;
	}

	public void setOntology(Ontology ontology) {
		this.ontology = ontology;
	}

	/** 
	 * it returns the list of ontology models URLs used to build up the forge ontology
	 * @return
	 */
	public List<String> getOntologiesURL() {
		return ontologiesURL;
	}
	public void setOntologiesURL(List<String> ontologiesURL) {
		this.ontologiesURL = ontologiesURL;
	}
	
	/**
	 * It returns the list of semantic mappings to apply when cross-search within this forge as remote
	 * @return
	 */
	public List<String> getMappingsURL() {
		return mappingsURL;
	}
	public void setMappingsURL(List<String> mappingsURL) {
		this.mappingsURL = mappingsURL;
	}

	public void setStub(QualiPSoSearchAPISoapClient searchStub) {
		this.stub = searchStub;	
	}

}
