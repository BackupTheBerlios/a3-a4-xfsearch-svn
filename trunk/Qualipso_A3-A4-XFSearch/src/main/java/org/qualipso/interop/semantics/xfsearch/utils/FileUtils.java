package org.qualipso.interop.semantics.xfsearch.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;

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
 * Helper class with File access facilities
 */
public class FileUtils {
	
	/**
	 * it reads a file into a String object
	 * @param filePath File path
	 * @return An String object containing the file content
	 * @throws java.io.IOException
	 */
	public static String readFileAsString(String filePath)
			throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}
	
	/**
	 * it reads a property file from the class path
	 * @see Properties
	 * @param bundle The name of the property bundle
	 * @return The properties object
	 */
	public static Properties readProperties(String bundle) {
		ResourceBundle rb = ResourceBundle.getBundle(bundle);
		Properties log4j_properties = new Properties();
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()){
			String key = keys.nextElement();
			log4j_properties.put(key, rb.getString(key));
		}
		return log4j_properties;
	}

	public static String getFileName(String ontologyPath, String extension) {
		return ontologyPath.substring(
				ontologyPath.lastIndexOf(File.separator)+1,
				ontologyPath.indexOf(extension)-1);
	}

	public static void saveOntolgy(OntModel jenaOntModel, String ontologyName) throws FileNotFoundException {
		jenaOntModel.write(new FileOutputStream(new File(ontologyName)));
	}

	public static void saveOntology(Model mappedModel, String ontologyName) throws FileNotFoundException {
		mappedModel.write(new FileOutputStream(new File(ontologyName)));
	}
}
