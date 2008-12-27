package org.qualipso.interop.semantics.xfsearch.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.qualipso.interop.semantics.xfsearch.control.CrossForgeSearchController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * @author Jesus Martin
 *
 */
public class Mapping {
	/**
	 * 
	 */
	private File mappingFile;
	
	/**
	 * 
	 */
	private String[] mappingSparqlContruct;
	
	/** Log for this class */
	private Log log = LogFactory.getLog(Mapping.class);	
	
	/**
	 * 
	 * @param mappingFilePath
	 * @throws Exception
	 */
	public Mapping(String mappingFilePath) throws Exception{
		this.mappingSparqlContruct = new String[1];
		this.mappingFile = new File(mappingFilePath);
		Reader reader = new FileReader(this.mappingFile);
		BufferedReader bufferedReader = new BufferedReader(reader);
		boolean end = false;
		String lines = "";
				
		while (!end){
			String line_aux = bufferedReader.readLine();
			if (line_aux!=null)
				lines = lines + line_aux + "\r";
			else
				end = true;
		}

		System.out.println();		
		System.out.println("Reading semantic mapping...: ");
		System.out.println(lines);		

		this.mappingSparqlContruct[0] = lines;
		
		
		
	}

	/**
	 * 
	 * @return
	 */
	public String[] getMappingSparqlContruct() {
		return this.mappingSparqlContruct;
	}
	
	
	

}
