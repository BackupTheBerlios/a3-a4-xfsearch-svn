package org.qualipso.interop.semantics.xfsearch.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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
 * Main XFSearch configuration facility
 */
public class XFSearchProperties {

	/** Property file */
	private Properties properties;
	private static XFSearchProperties instance = null;
	
	/** 
	 * Default Constructor
	 * 
	 * @param propertyFile Property file located from classpath
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	private XFSearchProperties(String xfsearchPropertiesPath) throws IOException {
		if (xfsearchPropertiesPath !=null){ //Not the default XFSearch properties file, specified by properties path or bundle name
			File xfsearchPropertiesFile = new File (xfsearchPropertiesPath);
			if (xfsearchPropertiesFile.exists()){
				this.properties = new Properties();
				this.properties.load(new FileInputStream (xfsearchPropertiesFile));
			} else { // xfsearchPropertiesPath is not a file path, maybe a bundle name
				String bundlename = xfsearchPropertiesPath;
				this.properties = FileUtils.readProperties(bundlename);
			}
		} else {
			this.properties = FileUtils.readProperties("xfsearch");
		}
	}
	
	private XFSearchProperties() throws XFSearchExceptionFileNotFound, IOException {
		this(null);
	}

	public static XFSearchProperties getInstance() throws XFSearchExceptionFileNotFound, IOException{
		if (instance == null){
			instance = new XFSearchProperties();
		}
		return instance;
	}
	
	public static XFSearchProperties getInstance(String xfsearchPropertiesPath) throws IOException{
		if (instance == null){
			instance = new XFSearchProperties(xfsearchPropertiesPath);
		}
		return instance;
	}

	/**
	 * It returns the values of the keys which starts with firstPartOfKey followed of '.'
	 * 
	 * For example: if 'firstPartOfKey==ontologA', it returns the values of:
	 * 		ontologyA.doap=C:/........ 
	 * 		ontologyA.foaf=C:/........
	 * 		ontologyA.qualipso_documentation=C:/........
	 * 		ontologyA.qualipso_relathionship=C:/........
	 *   
	 * @param firstPartOfKey partial description of the key which values are requested
	 * @return String[]
	 */
	public String[] getValuesFromFirtPartOfKey(String firstPartOfKey){
		Enumeration allPropertyKeys = this.properties.propertyNames();
		List valuesFromFirtPartOfKeyList = new LinkedList();
		while (allPropertyKeys.hasMoreElements()){
			String wholeKey = (String) allPropertyKeys.nextElement();
			if (wholeKey.startsWith(firstPartOfKey)){
				String keyValue = this.properties.getProperty(wholeKey);
				valuesFromFirtPartOfKeyList.add(keyValue);
			}
		}
		String[] valuesFromFirtPartOfKey = new String[valuesFromFirtPartOfKeyList.size()];
		valuesFromFirtPartOfKey = (String[]) valuesFromFirtPartOfKeyList.toArray(valuesFromFirtPartOfKey);
		
		return valuesFromFirtPartOfKey;
	}
	
	/**
	 * It returns configuration values corresponding to a property partially described by a property key
	 * @param firstPartOfKey Value key partial description
	 * @return List of values corresponding to that key
	 */
	public List<String> propertyValues(String firstPartOfKey){
		return Arrays.asList(getValuesFromFirtPartOfKey(firstPartOfKey));
	}
	
	/**
	 * It returns configuration value corresponding to a property 
	 * @param wholeKey property key
	 * @return String property value
	 */
	public String getPropertyValue(String wholeKey){
		return this.properties.getProperty(wholeKey);
	}
 
	/**
	 * It returns the list of ontologies constituting the knowledge base of the forge identified by the parameter
	 * @param forgeId Forge identifier
	 * @return List of forge ontologies
	 */
	public List<String> getForgeOntologies (String forgeId){
		return propertyValues(forgeId + ".ontology");
	}
	
	/**
	 * It returns the forge type
	 * @param forgeId Forge identifier
	 * @return Forge type
	 */
	public String getForgeType (String forgeId){
		return propertyValues(forgeId + ".type").get(0);
	}
	
	/**
	 * It returns the list of mappings associated to the forge identified by the parameter
	 * @param forgeId Forge identifier
	 * @return List of forge mappings
	 */
	public List<String> getForgeMappings (String forgeId){
		return propertyValues(forgeId + ".mapping");
	}

	public String getLocalForgeName() {
		return getPropertyValue("localforge.name");
	}

	public String getForgeURL(String forgeId) {
		return propertyValues(forgeId + ".url").get(0);
	}

	public boolean isLocalForge(String forgeId) {
		return forgeId.equalsIgnoreCase(getLocalForgeName());
	}
	
	public boolean isDebugMode (){
	  return Boolean.parseBoolean(getPropertyValue("debug"));
	}

	public boolean isReindexMode() {
		return Boolean.parseBoolean(getPropertyValue("reindex"));
	}
	
}
