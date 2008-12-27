package org.qualipso.advdoc.coreapi.sample;

import java.io.FileOutputStream;

import org.qualipso.advdoc.coreapi.ontology.Baetle;
import org.qualipso.advdoc.coreapi.ontology.DOAP;
import org.qualipso.advdoc.coreapi.ontology.FOAF;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoDOC;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoRS;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoSC;
import org.qualipso.advdoc.coreapi.ontology.SIOC;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;

public class SampleDocumentationData {

	/**
	 * Create a new RDF document storage resource
	 * @param model
	 * @param uri
	 * @param title
	 * @return the new created resource
	 */
	public static Resource createDocumentStorage(OntModel model,String uri,String title) {
		Resource docstore = model.createResource(uri);
		docstore.addProperty(RDF.type, QualiPSoDOC.DocumentStorage);
		docstore.addProperty(QualiPSoDOC.title,title);
		return docstore;
	}

	/**
	 * Create a new RDF folder resource
	 * @param model
	 * @param uri
	 * @param title
	 * @param description
	 * @param creator
	 * @return the new created resource
	 */
	public static Resource createFolder(OntModel model,String uri,String title,String description,Resource creator) {
		Resource folder = model.createResource(uri);
		folder.addProperty(RDF.type, QualiPSoDOC.Folder);
		folder.addProperty(QualiPSoDOC.title,title);
		folder.addProperty(QualiPSoDOC.description,description);
		folder.addProperty(QualiPSoDOC.creator,creator);
		return folder;
	}

	
	/**
	 * Create a new RDF document resource
	 * @param model
	 * @param uri
	 * @param title
	 * @param description
	 * @param creator
	 * @param license
	 * @param dateSubmitted
	 * @param dateAccepted
	 * @param subject
	 * @param language
	 * @param contributors
	 * @param publishers
	 * @return the new created resource
	 */
	public static Resource createDocument(
			OntModel model,
			String uri,
			String title,
			String description,
			Resource creator,
			String license,
			String dateSubmitted,
			String dateAccepted,
			String subject,
			String language,
			Resource[] contributors,
			Resource[] publishers) {
		Resource doc = model.createResource(uri);
		doc.addProperty(RDF.type, QualiPSoDOC.TextDocument);
		doc.addProperty(QualiPSoDOC.title,title);
		doc.addProperty(QualiPSoDOC.description,description);
		doc.addProperty(QualiPSoDOC.creator,creator);
		doc.addProperty(QualiPSoDOC.license,license);
		doc.addProperty(QualiPSoDOC.dateSubmitted,dateSubmitted);
		doc.addProperty(QualiPSoDOC.dateAccepted,dateAccepted);
		doc.addProperty(QualiPSoDOC.subject,subject);
		doc.addProperty(QualiPSoDOC.language,language);
		for (int i = 0;i < contributors.length;i++) {
			doc.addProperty(QualiPSoDOC.contributor, contributors[i]);
		}
		for (int i = 0;i < publishers.length;i++) {
			doc.addProperty(QualiPSoDOC.publisher, publishers[i]);
		}

		return doc;
	}

	/**
	 * Create a new RDF section resource
	 * @param model
	 * @param uri
	 * @param title
	 * @param creator
	 * @param level
	 * @param number
	 * @param paragraphs
	 * @return the new created resource
	 */
	public static Resource createSection(
			OntModel model,
			String title,
			Resource creator,
			int level,
			String number,
			String[] paragraphs) {
		// Anonymous resource
		Resource section = model.createResource();
		section.addProperty(RDF.type, QualiPSoDOC.Section);
		section.addProperty(QualiPSoDOC.title,title);
		section.addProperty(QualiPSoDOC.creator,creator);
		section.addProperty(QualiPSoDOC.level,""+level);
		section.addProperty(QualiPSoDOC.sectionNumber,number);
		for (int i = 0;i < paragraphs.length;i++) {
			// Text anonymous resource
			Resource text = model.createResource();
			text.addProperty(RDF.type, QualiPSoDOC.Text);
			text.addProperty(QualiPSoDOC.creator, creator);
			text.addProperty(QualiPSoDOC.textContents, paragraphs[i]);
			section.addProperty(QualiPSoDOC.hasText, text);
		}
		return section;
	}
	
	public static Resource createFigure(OntModel model,Resource creator,String title) {
		// Anonymous figure node
		Resource figure = model.createResource();
		figure.addProperty(RDF.type, QualiPSoDOC.Figure);
		figure.addProperty(QualiPSoDOC.title,title);
		figure.addProperty(QualiPSoDOC.creator,creator);
		return figure;
	}

	
	/**
	 * Main program
	 * @author quiles
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			// Create an empty model
			OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
			
			// Namespace prefixes
			model.setNsPrefix("foaf", FOAF.NS);
			model.setNsPrefix("doap", DOAP.NS);
			model.setNsPrefix("sioc", SIOC.NS);
			model.setNsPrefix("baetle", Baetle.NS);
			model.setNsPrefix("qsc", QualiPSoSC.NS);
			model.setNsPrefix("qrs", QualiPSoRS.NS);
			model.setNsPrefix("qdoc", QualiPSoDOC.NS);

			// Read existing project data
			model.read("file:"+SampleProjectConstants.ProjectFile);

			// Find people
			Resource dse = model.getResource("http://www.tid.es/3015/dse");
			Resource quiles = model.getResource("http://www.tid.es/3015/quiles");
			Resource mcp = model.getResource("http://www.tid.es/3015/mcp");
			Resource acs = model.getResource("http://www.urjc.es/escet/gsyc/acs");
			Resource julia = model.getResource("http://www.urjc.es/escet/gsyc/janaya");
			Resource chemi = model.getResource("http://www.tid.es/3015/josea");
			Resource nadia = model.getResource("http://www.unisa.it/crmpa/nromano");
			Resource luigi = model.getResource("http://www.unisa.it/rcost/lcerulo");

			
			// Create the document storage
			Resource docstore = createDocumentStorage(model, SampleProjectConstants.DocStorage, "Project Advanced Tools Documentation");
			
			// Ade the document store to the project
			Resource project = model.getResource(SampleProjectConstants.ProjectURI);
			project.addProperty(QualiPSoRS.hasDocStorage, docstore);
			
			// Create folders
			Resource userguidesFolder = createFolder(
					model, 
					SampleProjectConstants.DocStorage+"/userguides", 
					"User Guides", 
					"This folder contains the user guides of the project", 
					quiles);
			Resource adminguidesFolder = createFolder(
					model, 
					SampleProjectConstants.DocStorage+"/adminguides", 
					"Administration Guides", 
					"This folder contains the administration guides of the project", 
					quiles);
			Resource installguidesFolder = createFolder(
					model, 
					SampleProjectConstants.DocStorage+"/installguides", 
					"Installation Guides", 
					"This folder contains the installation guides of the project", 
					quiles);
			Resource deliverablesFolder = createFolder(
					model, 
					SampleProjectConstants.DocStorage+"/deliverables", 
					"Project Deliverables", 
					"This folder contains the deliverables of the project", 
					quiles);
			
			// Add folders to document store
			docstore.addProperty(QualiPSoDOC.hasFolder, userguidesFolder);
			docstore.addProperty(QualiPSoDOC.hasFolder, adminguidesFolder);
			docstore.addProperty(QualiPSoDOC.hasFolder, installguidesFolder);
			docstore.addProperty(QualiPSoDOC.hasFolder, deliverablesFolder);
			
			// Create a document
			Resource deliverable_d432 = createDocument(
					model, 
					SampleProjectConstants.Repository+"/deliverables/D4.3.2/deliverable_D4.3.2", 
					"Advanced doc and info management tools, version 1.0: design documentation",
					"This document specifies the design documentation for the version 1.0 of the advanced management " +
					"tools for documentation and information management. The architecture for the system is described " +
					"in a generic way and the concrete implementation for the different tools and repositories is included. " +
					"A repository storing semantic information about FLOSS projects and advanced tools reporting on it " +
					"are specified.", 
					quiles, 
					"This work is licensed under the Creative Commons Attribution-Share Alike 3.0 License. "+
					"To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send a letter to Creative "+
					"Commons, 171 Second Street, Suite 300, San Francisco, California, 94105, USA. "+
					"This work is partially funded by EU under the grant of IST-FP6-034763.", 
					"Dec/2007", 
					"Dec/2007", 
					"This document specifies the design documentation for the version "+
					"1.0 of the advanced management tools for documentation and "+
					"information management. A repository storing semantic information "+
					"about FLOSS projects and advanced tools reporting on it are "+
					"specified.", 
					"EN-en", 
					new Resource[] { quiles, dse, acs, nadia, luigi }, 
					new Resource[] { quiles });
			
			// Add document to folder
			deliverablesFolder.addProperty(QualiPSoDOC.hasDocument, deliverable_d432);
			
			// Create sections
			Resource section_1 = createSection(
					model, 
					"Introduction", 
					quiles, 
					1, 
					"1", 
					new String[] {
							"The aim of the activity 4 is focused on the research and development of tools to handle and exploit "+
							"the correlation between all information items that usually happens in a FLOSS project. The "+
							"availability of these tools would have an impact not only on the confidence in OSS, but also could "+
							"mean a major competitive advantage of the OSS projects, since the information creation and "+
							"exchange are more promoted in this type of projects than other commercial ones.",
							"Tools for management of information and documentation that are going to be implemented in this "+
							"first iteration of activity 4 of QualiPSo will allow us to solve common problems between the "+
							"developers community, reporters, testers, managers, etc. in a FLOSS project.",
							"We're going to describe in this document the architecture to implement these advanced tools for "+
							"information and documentation management. The goals of this architecture:",
							"generic extendible configurable",
							"The architecture has to be generic enough to bear all kind of information repositories, whatever "+
							"implementation may have. It must support information repositories in different programming "+
							"languages and environments, over different web and application servers, with different storage "+
							"formats (files, databases, etc.), and working in all kind of computers (whether locally or remotely of "+
							"the system implementation and the advanced tools). Besides, the architecture must support "+
							"advanced tools for information and documentation management implemented in different platforms "+
							"and languages.",
							"On the other hand, the architecture must be easily extendible with new information repositories that "+
							"may appear in the future, both repository types as well as specific tools. The system must allow an "+
							"easy way of inclusion of new information sources, without needing to modify neither the "+
							"architecture, not even the programs which are currently developing. Besides, the architecture must "+
							"allow to extend the advanced tools, so it can be made easily, without modifications of the system "+
							"core. If you wish to add new tools for information and documentation management in the future.",
					});

			Resource section_2 = createSection(
					model, 
					"Architecture", 
					quiles, 
					1, 
					"2", 
					new String[] {
							"This chapter describes the architecture for the advanced tools for information and documentation "+
							"management in the QualiPSo project. It will be described the distinct components composing the "+
							"architecture in a generic way, as well as the interfaces among these components. The internal details "+
							"for every component will be left to next chapters of this document. In this chapter, we will not get "+
							"in on the concrete information repositories, rather we will describe the repositories in an abstract "+
							"way, explaining the different kinds of repositories, as well as different integration ways in the "+
							"architecture.",
							"...",
					});
			
			// Create figure
			Resource figure2_1 = createFigure(model, quiles, "Architecture for information and documentation advanced tools");
			section_2.addProperty(QualiPSoDOC.hasElement, figure2_1);

			Resource section_2_1 = createSection(
					model, 
					"Repositories of information", 
					quiles, 
					2, 
					"2.1", 
					new String[] {
							"Information repositories are the sources from which textual and semantic information will be "+
							"extracted. This information will be properly indexed in the core of the system. And finally, "+
							"advanced tools for information and documentation management will carry out searches and "+
							"navigation.",
							"...",
					});

			Resource section_2_2 = createSection(
					model, 
					"Abstract integration layer", 
					quiles, 
					2, 
					"2.2", 
					new String[] {
							"The abstract integration layer allow the system to integrate the different information repositories "+
							"used in FLOSS projects in a transparent way. The objective of this layer is to integrate seamlessly "+
							"the different kinds of repositories (described above) with the generic architecture, and they can load, "+
							"using the Feed API, its information in the system. Later, this information will be indexed in order to "+
							"be exploited by advanced tools for information and documentation management.",
							"...",
					});

			// Create figures
			Resource figure2_2_1 = createFigure(model, quiles, "Abstract integration layer model");
			section_2_2.addProperty(QualiPSoDOC.hasElement, figure2_2_1);
			Resource figure2_2_2 = createFigure(model, quiles, "Diferent types of integration layers");
			section_2_2.addProperty(QualiPSoDOC.hasElement, figure2_2_2);

			// Add sections to document
			deliverable_d432.addProperty(QualiPSoDOC.hasElement, section_1);
			deliverable_d432.addProperty(QualiPSoDOC.hasElement, section_2);
			deliverable_d432.addProperty(QualiPSoDOC.hasElement, section_2_1);
			deliverable_d432.addProperty(QualiPSoDOC.hasElement, section_2_2);
			
			// Relate sections to source code files
			Resource showOntology = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"ShowOntology.java");
			Resource showSchema = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"ShowSchema.java");
			Resource doap = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"DOAP.java");
			
			section_2_1.addProperty(QualiPSoRS.documentsSourceCode, showOntology);
			section_2_1.addProperty(QualiPSoRS.documentsSourceCode, showSchema);
			section_2_2.addProperty(QualiPSoRS.documentsSourceCode, showSchema);
			section_1.addProperty(QualiPSoRS.documentsSourceCode, doap);
			
			// Save the RDF file
			FileOutputStream fos = new FileOutputStream(SampleProjectConstants.ProjectFile);			
			model.write(fos);
			fos.close();
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
