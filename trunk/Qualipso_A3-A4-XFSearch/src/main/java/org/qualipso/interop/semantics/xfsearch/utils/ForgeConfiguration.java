package org.qualipso.interop.semantics.xfsearch.utils;

import java.util.List;

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
 * Forge XFSearch service configuration structure
 */
public class ForgeConfiguration {
	String ID = null;
	List<String> ontologiesURL = null;
	String mappingURL = null;
	
	/**
	 * it returns the semantic mapping associated to the forge
	 * @return
	 */
	public String getMappingURL() {
		return mappingURL;
	}
	
	/**
	 * it sets the semantic mapping associated to the forge
	 * @param mappingURL
	 */
	public void setMappingURL(String mappingURL) {
		this.mappingURL = mappingURL;
	}
	
	/**
	 * It gets the forge identifier
	 * @return
	 */
	public String getID() {
		return ID;
	}
	
	/** 
	 * It sets the forge identifier
	 * @param id
	 */
	public void setID(String id) {
		ID = id;
	}
	
	/**
	 * It gets the forge ontologies locators
	 * @return
	 */
	public List<String> getOntologiesURL() {
		return ontologiesURL;
	}
	
	/**
	 * It sets the forge ontologies locators
	 * @param ontologiesURL
	 */
	public void setOntologiesURL(List<String> ontologiesURL) {
		this.ontologiesURL = ontologiesURL;
	}

}
