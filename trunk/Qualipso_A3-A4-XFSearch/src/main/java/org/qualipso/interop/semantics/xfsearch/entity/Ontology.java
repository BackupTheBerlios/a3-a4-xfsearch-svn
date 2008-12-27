package org.qualipso.interop.semantics.xfsearch.entity;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import org.mindswap.pellet.jena.PelletReasonerFactory;


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
 * Formal representation of a forge ontology
 * It loads the ontology in memory using Jena API
 */

public class Ontology {

	/** OntModel of Jena API. It is where finally the OWL files are loaded. */
	private OntModel ontologyModel;

	private Log log = LogFactory.getLog(Ontology.class);

	/**
	 * Default constructor
	 */
	public Ontology(){
		
	}
	
	/**
	 * It build an ontology loading it for several model sources
	 * @param ontologyFiles Path of files containig the ontology model sources.
	 * @param withPellet Flag setting the usage of Pellet ontology engine.
	 */
	public Ontology(List<String> ontologyFiles, boolean withPellet){
		try {
			if (!withPellet){
				this.ontologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF);
			}
			else {
				this.ontologyModel = ModelFactory.createOntologyModel( PelletReasonerFactory.THE_SPEC );
				ontologyModel.setStrictMode( true );
			}
			for (String ontologyFile: ontologyFiles){
				ontologyModel.read("file:"+ontologyFile);
			}
		}
		catch (Throwable ex){
			System.out.println("We go on...");
		}

	}


	/**
	 * It returns the ontology model
	 * @return OntModel ontology model
	 */
	public OntModel getJenaOntModel(){
		return this.ontologyModel;
	}

	/**
	 * It sets the ontology model
	 * @param OntModel ontologyModel
	 */
	public void setJenaOntModel(OntModel ontModel){
		this.ontologyModel = ontModel;
	}	






}

