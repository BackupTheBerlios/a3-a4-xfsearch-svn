package org.qualipso.interop.semantics.xfsearch.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qualipso.interop.semantics.xfsearch.utils.FileUtils;
import org.qualipso.interop.semantics.xfsearch.utils.XFSearchLog;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
 * Formal representation of a semantic mapping
 */

public class Mapping {	
	/**
	 * 
	 */
	private List<String> mappingSparqlContructs = new ArrayList<String> ();
	
	/** Log for this class */
	private Log log = LogFactory.getLog(Mapping.class);	
	
	/**
	 * Default constructor
	 * @param mappingFilePath Path of the file that contains the semantic mapping
	 * @throws Exception
	 */
	public Mapping(List<String> mappings) throws Exception{
		for (String mapping: mappings){
			mappingSparqlContructs.add(mapping);
		}
	}

	
	/**
	 * It returns the mapping statements
	 * @return Mapping statements.
	 */
	public List<String> getMappingSparqlContructs() {
		return this.mappingSparqlContructs;
	}
}
