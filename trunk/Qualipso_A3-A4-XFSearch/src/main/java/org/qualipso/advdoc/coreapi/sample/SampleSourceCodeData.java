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

/**
 * Create sample RDF data for source code modules in a project
 * @author quiles
 * @version 1.0
 *
 */
public class SampleSourceCodeData {

	/**
	 * Create a new RDF module resource
	 * @author quiles
	 * @param model
	 * @param uri
	 * @param name
	 * @return the created resource
	 */
	public static Resource createModule(OntModel model,String uri,String name) {
		Resource module = model.createResource(uri);
		module.addProperty(RDF.type, QualiPSoSC.SourceCodeModule);
		module.addProperty(QualiPSoSC.name, name);
		return module;
	}

	/**
	 * Create a new RDF package/namespace resource
	 * @param model
	 * @param uri
	 * @param name
	 * @return the created resource
	 */
	public static Resource createPackage(OntModel model,String uri,String name) {
		Resource pkg = model.createResource(uri);
		pkg.addProperty(RDF.type, QualiPSoSC.Package);
		pkg.addProperty(QualiPSoSC.name, name);
		return pkg;
	}
	
	/**
	 * Create a new RDF source code file resource
	 * @param model
	 * @param uri
	 * @param filename
	 * @param url
	 * @return the created resource
	 */
	public static Resource createFile(OntModel model,String uri,String filename,String url) {
		Resource file = model.createResource(uri);
		file.addProperty(RDF.type, QualiPSoSC.SourceCodeFile);
		file.addProperty(QualiPSoSC.filename, filename);
		file.addProperty(QualiPSoSC.url, url);
		return file;
	}

	/**
	 * Create a new RDF class resource
	 * @param model
	 * @param uri
	 * @param author
	 * @param name
	 * @param version
	 * @param comment
	 * @return the created resource
	 */
	public static Resource createClass(
			OntModel model,
			String author,
			String name,
			String version,
			String comment) {
		// Anonymous resource
		Resource cls = model.createResource();
		cls.addProperty(RDF.type, QualiPSoSC.Class);
		cls.addProperty(QualiPSoSC.author, author);
		cls.addProperty(QualiPSoSC.name, name);
		cls.addProperty(QualiPSoSC.version, version);
		cls.addProperty(QualiPSoSC.comment, comment);
		return cls;
	}

	/**
	 * Create a new RDF attribute resource
	 * @param model
	 * @param uri
	 * @param name
	 * @param comment
	 * @param type
	 * @return the created resource
	 */
	public static Resource createAttribute(OntModel model,String name,String comment,Resource type) {
		// Anonoymous resource
		Resource attribute = model.createResource();
		attribute.addProperty(RDF.type, QualiPSoSC.Attribute);
		attribute.addProperty(QualiPSoSC.name, name);
		attribute.addProperty(QualiPSoSC.comment, comment);
		attribute.addProperty(QualiPSoSC.hasType, type);
		return attribute;
	}

	/**
	 * Create a new RDF constructor resource
	 * @param model
	 * @param uri
	 * @param name
	 * @param comment
	 * @param paramComments
	 * @return the created resource
	 */
	public static Resource createConstructor(
			OntModel model,
			String name,
			String comment,
			String[] paramComments) {
		// Anonymous resource
		Resource constructor = model.createResource();
		constructor.addProperty(RDF.type, QualiPSoSC.Constructor);
		constructor.addProperty(QualiPSoSC.name, name);
		constructor.addProperty(QualiPSoSC.comment, comment);
		for (int i = 0;i < paramComments.length;i++) {
			constructor.addProperty(QualiPSoSC.paramComment, paramComments[i]);
		}
		return constructor;
	}

	/**
	 * Create a new RDF method resource
	 * @param model
	 * @param uri
	 * @param name
	 * @param comment
	 * @param paramComments
	 * @return the created resource
	 */
	public static Resource createMethod(
			OntModel model,
			String name,
			String comment,
			String[] paramComments,
			String returnComment) {
		// Anonymous resource
		Resource method = model.createResource();
		method.addProperty(RDF.type, QualiPSoSC.Method);
		method.addProperty(QualiPSoSC.name, name);
		method.addProperty(QualiPSoSC.comment, comment);
		for (int i = 0;i < paramComments.length;i++) {
			method.addProperty(QualiPSoSC.paramComment, paramComments[i]);
		}
		method.addProperty(QualiPSoSC.returnComment, returnComment);
		return method;
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

			// Create modules
			Resource mod_coreapi = createModule(model, SampleProjectConstants.SourceCodeBaseURI+"mod_coreapi", "Core API");
			Resource mod_ws = createModule(model, SampleProjectConstants.SourceCodeBaseURI+"mod_ws", "Web Service");
			Resource mod_infosources = createModule(model, SampleProjectConstants.SourceCodeBaseURI+"mod_infosources", "Information Sources");
			Resource mod_advtools = createModule(model, SampleProjectConstants.SourceCodeBaseURI+"mod_advtools", "Advanced Tools");
			
			// Add modules to the repository
			Resource repository = model.getResource(SampleProjectConstants.Repository);
			repository.addProperty(QualiPSoRS.hasSourceCodeModule, mod_coreapi);
			repository.addProperty(QualiPSoRS.hasSourceCodeModule, mod_ws);
			repository.addProperty(QualiPSoRS.hasSourceCodeModule, mod_infosources);
			repository.addProperty(QualiPSoRS.hasSourceCodeModule, mod_advtools);

			// Create packages
			Resource coreapi = createPackage(model, SampleProjectConstants.SourceCodeBaseURI+"org.qualipso.advdoc.coreapi", "org.qualipso.advdoc.coreapi");
			Resource coreapi_ontology = createPackage(model, SampleProjectConstants.SourceCodeBaseURI+"org.qualipso.advdoc.coreapi.ontology", "org.qualipso.advdoc.coreapi.ontology");
			Resource coreapi_sample = createPackage(model, SampleProjectConstants.SourceCodeBaseURI+"org.qualipso.advdoc.coreapi.sample", "org.qualipso.advdoc.coreapi.sample");
			Resource ws_feed = createPackage(model, SampleProjectConstants.SourceCodeBaseURI+"org.qualipso.advdoc.ws.feed", "org.qualipso.advdoc.ws.feed");
			Resource ws_retrieval = createPackage(model, SampleProjectConstants.SourceCodeBaseURI+"org.qualipso.advdoc.ws.retrieval", "org.qualipso.advdoc.ws.retrieval");
			Resource srccode = createPackage(model, SampleProjectConstants.SourceCodeBaseURI+"org.qualipso.advdoc.infosources.srccode", "org.qualipso.advdoc.infosource.srccode");
			Resource semsearch = createPackage(model, SampleProjectConstants.SourceCodeBaseURI+"org.qualipso.advtools.semsearch", "org.qualipso.advdoc.advtools.semsearch");

			// Subpackages
			coreapi.addProperty(QualiPSoSC.hasSubpackage, coreapi_ontology);
			coreapi.addProperty(QualiPSoSC.hasSubpackage, coreapi_sample);

			// Add packages to modules
			mod_coreapi.addProperty(QualiPSoSC.hasPackage, coreapi);
			mod_coreapi.addProperty(QualiPSoSC.hasPackage, coreapi_ontology);
			mod_coreapi.addProperty(QualiPSoSC.hasPackage, coreapi_sample);
			mod_ws.addProperty(QualiPSoSC.hasPackage, ws_feed);
			mod_ws.addProperty(QualiPSoSC.hasPackage, ws_retrieval);
			mod_infosources.addProperty(QualiPSoSC.hasPackage, srccode);
			mod_advtools.addProperty(QualiPSoSC.hasPackage, semsearch);
			
			// Source code files
			Resource showOntologyFile = createFile(model, SampleProjectConstants.SourceCodeBaseURI+"ShowOntology.java", "ShowOntology.java", SampleProjectConstants.SourceCodeBaseURI+"/org/qualipso/advdoc/coreapi/ontology/ShowOntology.java");
			Resource showSchemaFile = createFile(model, SampleProjectConstants.SourceCodeBaseURI+"ShowSchema.java", "ShowSchema.java", SampleProjectConstants.SourceCodeBaseURI+"/org/qualipso/advdoc/coreapi/ontology/ShowSchema.java");
			Resource baetleFile = createFile(model, SampleProjectConstants.SourceCodeBaseURI+"Baetle.java", "Baetle.java", SampleProjectConstants.SourceCodeBaseURI+"/org/qualipso/advdoc/coreapi/ontology/Baetle.java");
			Resource doapFile = createFile(model, SampleProjectConstants.SourceCodeBaseURI+"DOAP.java", "DOAP.java", SampleProjectConstants.SourceCodeBaseURI+"/org/qualipso/advdoc/coreapi/ontology/DOAP.java");
			Resource foafFile = createFile(model, SampleProjectConstants.SourceCodeBaseURI+"FOAF.java", "FOAF.java", SampleProjectConstants.SourceCodeBaseURI+"/org/qualipso/advdoc/coreapi/ontology/FOAF.java");
			Resource siocFile = createFile(model, SampleProjectConstants.SourceCodeBaseURI+"SIOC.java", "SIOC.java", SampleProjectConstants.SourceCodeBaseURI+"/org/qualipso/advdoc/coreapi/ontology/SIOC.java");
			Resource qualipsoSCFile = createFile(model, SampleProjectConstants.SourceCodeBaseURI+"QualiPSoSC.java", "QualiPSoSC.java", SampleProjectConstants.SourceCodeBaseURI+"/org/qualipso/advdoc/coreapi/ontology/QualiPSoSC.java");
			Resource qualipsoRSFile = createFile(model, SampleProjectConstants.SourceCodeBaseURI+"QualiPSoRS.java", "QualiPSoRS.java", SampleProjectConstants.SourceCodeBaseURI+"/org/qualipso/advdoc/coreapi/ontology/QualiPSoRS.java");
			
			// Programming language for source code files
			showOntologyFile.addProperty(QualiPSoSC.programmingLanguage,QualiPSoSC.Java);
			showSchemaFile.addProperty(QualiPSoSC.programmingLanguage,QualiPSoSC.Java);
			baetleFile.addProperty(QualiPSoSC.programmingLanguage,QualiPSoSC.Java);
			doapFile.addProperty(QualiPSoSC.programmingLanguage,QualiPSoSC.Java);
			foafFile.addProperty(QualiPSoSC.programmingLanguage,QualiPSoSC.Java);
			siocFile.addProperty(QualiPSoSC.programmingLanguage,QualiPSoSC.Java);
			qualipsoSCFile.addProperty(QualiPSoSC.programmingLanguage,QualiPSoSC.Java);
			qualipsoRSFile.addProperty(QualiPSoSC.programmingLanguage,QualiPSoSC.Java);
			
			// Add author to source code files
			Resource quiles = model.getResource("http://www.tid.es/3015/quiles");
			showOntologyFile.addProperty(QualiPSoRS.hasAuthor, quiles);
			showSchemaFile.addProperty(QualiPSoRS.hasAuthor, quiles);
			
			// Add source files to packages
			coreapi_ontology.addProperty(QualiPSoSC.hasSourceFile, showOntologyFile);
			coreapi_ontology.addProperty(QualiPSoSC.hasSourceFile, showSchemaFile);
			coreapi_ontology.addProperty(QualiPSoSC.hasSourceFile, baetleFile);
			coreapi_ontology.addProperty(QualiPSoSC.hasSourceFile, doapFile);
			coreapi_ontology.addProperty(QualiPSoSC.hasSourceFile, foafFile);
			coreapi_ontology.addProperty(QualiPSoSC.hasSourceFile, siocFile);
			coreapi_ontology.addProperty(QualiPSoSC.hasSourceFile, qualipsoSCFile);
			coreapi_ontology.addProperty(QualiPSoSC.hasSourceFile, qualipsoRSFile);
			
			// Create classes
			Resource showOntologyClass = createClass(
					model, 
					"quiles", 
					"ShowOntology", 
					"1.0", 
					"Show the classes and properties that compose an ontology");
			Resource showSchemaClass = createClass(
					model, 
					"quiles", 
					"ShowSchema", 
					"1.0", 
					"Show the classes and properties that compose an RDF schema");
			Resource DOAPClass = createClass(
					model, 
					"quiles", 
					"DOAP", 
					"1.0", 
					"Constants defined in DOAP ontology");
			Resource FOAFClass = createClass(
					model, 
					"quiles", 
					"FOAF", 
					"1.0", 
					"Constants defined in FOAF ontology");
			Resource SIOCClass = createClass(
					model, 
					"quiles", 
					"SIOC", 
					"1.0", 
					"Constants defined in SIOC ontology");
			Resource BaetleClass = createClass(
					model, 
					"quiles", 
					"Baetle", 
					"1.0", 
					"Constants defined in Baetle ontology");
			Resource QualiPSoSCClass = createClass(
					model, 
					"quiles", 
					"QualiPSoSC", 
					"1.0", 
					"Constants defined in qualipso source code ontology");
			Resource QualiPSoRSClass = createClass(
					model, 
					"quiles", 
					"QualiPSoRS", 
					"1.0", 
					"Constants defined in qualipso relationship ontology");
			
			// Add classes to source code file
			showOntologyFile.addProperty(QualiPSoSC.hasClass, showOntologyClass);
			showSchemaFile.addProperty(QualiPSoSC.hasClass, showSchemaClass);
			doapFile.addProperty(QualiPSoSC.hasClass, DOAPClass);
			foafFile.addProperty(QualiPSoSC.hasClass, FOAFClass);
			siocFile.addProperty(QualiPSoSC.hasClass, SIOCClass);
			baetleFile.addProperty(QualiPSoSC.hasClass, BaetleClass);
			qualipsoSCFile.addProperty(QualiPSoSC.hasClass, QualiPSoSCClass);
			qualipsoRSFile.addProperty(QualiPSoSC.hasClass, QualiPSoRSClass);

			// Create attributes
			Resource ontologyFile = createAttribute(
					model, 
					"OntologyFile", 
					"Ontology URL", 
					QualiPSoSC.string);
			Resource outputFile = createAttribute(
					model, 
					"OutputFile", 
					"Text output filename", 
					QualiPSoSC.string);

			Resource modelAttribute = createAttribute(
					model, 
					"model", 
					"Ontology Jena model", 
					model.createResource().addProperty(QualiPSoSC.name, "com.hp.hpl.jena.ontology.OntModel"));

			Resource outAttribute = createAttribute(
					model, 
					"out", 
					"Output stream for report", 
					model.createResource().addProperty(QualiPSoSC.name, "java.io.OutputStream"));

			// Add attributes to class
			showOntologyClass.addProperty(QualiPSoSC.hasAttribute, ontologyFile);
			showOntologyClass.addProperty(QualiPSoSC.hasAttribute, outputFile);
			showOntologyClass.addProperty(QualiPSoSC.hasAttribute, outAttribute);
			showOntologyClass.addProperty(QualiPSoSC.hasAttribute, modelAttribute);
			
			// Class constructor
			Resource showOntologyConstructor = createConstructor(
					model, 
					"ShowOntology", 
					"ShowOntology constructor", 
					new String[] { "out", "ontology" } );
			
			// Add constructor to class
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, showOntologyConstructor);
			
			// Create methods
			Resource describeClassMethod = createMethod(
					model, 
					"describeClass", 
					"Describe a class, superclasses, equivalent classes, disjoint classes and properties", 
					new String[] { "cls" }, 
					"");
			Resource describeObjectPropertyMethod = createMethod(
					model, 
					"describeObjectProperty", 
					"Describe an object property, super properties, equivalent properties, domain and range", 
					new String[] { "prop" }, 
					"");
			Resource describeDatatypePropertyMethod = createMethod(
					model, 
					"describeDatatypeProperty", 
					"Describe an datatype property, super properties, equivalent properties, domain and range", 
					new String[] { "prop" }, 
					"");
			Resource showEquivalentClassesMethod = createMethod(
					model, 
					"showEquivalentClasses", 
					"Show the equivalent classes of a given class", 
					new String[] { "cls" }, 
					"");
			Resource showDisjointClassesMethod = createMethod(
					model, 
					"showDisjointClasses", 
					"Show the disjoint classes of a given class", 
					new String[] { "cls" }, 
					"");
			Resource showEquivalentPropertiesMethod = createMethod(
					model, 
					"showEquivalentProperties", 
					"Show the equivalent properties of a given property", 
					new String[] { "prop" }, 
					"");
			Resource showDomainMethod = createMethod(
					model, 
					"showDomain", 
					"Show the domain of a given property", 
					new String[] { "prop" }, 
					"");
			Resource showRangeMethod = createMethod(
					model, 
					"showRange", 
					"Show the range of a given property", 
					new String[] { "prop" }, 
					"");
			Resource showSuperPropertiesMethod = createMethod(
					model, 
					"showSuperProperties", 
					"Show super properties of a given property", 
					new String[] { "prop" }, 
					"");
			Resource showSuperClassesMethod = createMethod(
					model, 
					"showSuperClasses", 
					"Show super classes of a given class", 
					new String[] { "cls" }, 
					"");
			Resource showPropertiesMethod = createMethod(
					model, 
					"showSuperProperties", 
					"Show direct (not inherited) properties of a given class (object and datatype)", 
					new String[] { "cls" }, 
					"");
			Resource getDirectObjectPropertiesMethod = createMethod(
					model, 
					"getDirectObjectProperties", 
					"Return the direct object properties of a given class", 
					new String[] { "cls" }, 
					"list of ObjectProperty");
			Resource getDirectDatatypePropertiesMethod = createMethod(
					model, 
					"getDirectDatatypeProperties", 
					"Return the direct datatype properties of a given class", 
					new String[] { "cls" }, 
					"list of DatatypeProperty");
			Resource renderURIMethod = createMethod(
					model, 
					"renderURI", 
					"Return an URI with namespace prefix (if exists)", 
					new String[] { "res" }, 
					"the URI with namespace prefix");
			
			// Add methods to class
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, describeClassMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, describeObjectPropertyMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, describeDatatypePropertyMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, showEquivalentClassesMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, showDisjointClassesMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, showEquivalentPropertiesMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, showDomainMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, showRangeMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, showSuperPropertiesMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, showSuperClassesMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, showPropertiesMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, getDirectObjectPropertiesMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, getDirectDatatypePropertiesMethod);
			showOntologyClass.addProperty(QualiPSoSC.hasMethod, renderURIMethod);

			// Method invocation
			showOntologyConstructor.addProperty(QualiPSoSC.invokesMethod, describeClassMethod);
			showOntologyConstructor.addProperty(QualiPSoSC.invokesMethod, describeObjectPropertyMethod);
			showOntologyConstructor.addProperty(QualiPSoSC.invokesMethod, describeDatatypePropertyMethod);
			describeClassMethod.addProperty(QualiPSoSC.invokesMethod, showSuperClassesMethod);
			describeClassMethod.addProperty(QualiPSoSC.invokesMethod, showEquivalentClassesMethod);
			describeClassMethod.addProperty(QualiPSoSC.invokesMethod, showDisjointClassesMethod);
			describeClassMethod.addProperty(QualiPSoSC.invokesMethod, showPropertiesMethod);
			describeObjectPropertyMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			describeObjectPropertyMethod.addProperty(QualiPSoSC.invokesMethod, showSuperPropertiesMethod);
			describeObjectPropertyMethod.addProperty(QualiPSoSC.invokesMethod, showEquivalentPropertiesMethod);
			describeObjectPropertyMethod.addProperty(QualiPSoSC.invokesMethod, showDomainMethod);
			describeObjectPropertyMethod.addProperty(QualiPSoSC.invokesMethod, showRangeMethod);
			describeDatatypePropertyMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			describeDatatypePropertyMethod.addProperty(QualiPSoSC.invokesMethod, showSuperPropertiesMethod);
			describeDatatypePropertyMethod.addProperty(QualiPSoSC.invokesMethod, showEquivalentPropertiesMethod);
			describeDatatypePropertyMethod.addProperty(QualiPSoSC.invokesMethod, showDomainMethod);
			describeDatatypePropertyMethod.addProperty(QualiPSoSC.invokesMethod, showRangeMethod);
			showEquivalentClassesMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			showDisjointClassesMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			showEquivalentPropertiesMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			showDomainMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			showRangeMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			showSuperPropertiesMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			showSuperClassesMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			showPropertiesMethod.addProperty(QualiPSoSC.invokesMethod, renderURIMethod);
			showPropertiesMethod.addProperty(QualiPSoSC.invokesMethod, getDirectObjectPropertiesMethod);
			showPropertiesMethod.addProperty(QualiPSoSC.invokesMethod, getDirectDatatypePropertiesMethod);
			
			// Save the RDF file
			FileOutputStream fos = new FileOutputStream(SampleProjectConstants.ProjectFile);			
			model.write(fos);
			fos.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
