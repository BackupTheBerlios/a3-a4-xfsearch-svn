package org.qualipso.advdoc.coreapi.sample;

import java.io.FileOutputStream;

import org.qualipso.advdoc.coreapi.ontology.Baetle;
import org.qualipso.advdoc.coreapi.ontology.DOAP;
import org.qualipso.advdoc.coreapi.ontology.FOAF;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoDOC;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoML;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoRS;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoSC;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoVC;
import org.qualipso.advdoc.coreapi.ontology.SIOC;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;

public class SampleVersionControlData {

	public static Resource createFile(
			OntModel model,
			String fileUri,
			Resource repository,
			String fullPath
			) {
		Resource file = model.createResource(fileUri);
		file.addProperty(RDF.type, QualiPSoVC.File);
		file.addProperty(QualiPSoVC.fullPath, fullPath);
		file.addProperty(QualiPSoVC.hasRepository, repository);
		return file;

	}
	
	public static Resource createRevision(
			OntModel model,
			String revisionUri,
			Resource file,
			Resource author,
			String number,
			String branch,
			String commitMessage,
			String date,
			String state
			) {
		Resource revision = model.createResource(revisionUri);
		revision.addProperty(RDF.type, QualiPSoVC.Revision);
		revision.addProperty(QualiPSoVC.hasFile,file);
		file.addProperty(QualiPSoVC.hasRevision,revision);
		revision.addProperty(QualiPSoVC.author, author);
		revision.addProperty(QualiPSoVC.number,number);
		revision.addProperty(QualiPSoVC.branch,branch);
		revision.addProperty(QualiPSoVC.commitMessage,commitMessage);
		revision.addProperty(QualiPSoVC.date,date);
		revision.addProperty(QualiPSoVC.state,state);
		return revision;
	}
	
	public static void main(String[] args) {
		try {
			
			// Create an empty model
			OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
			
			// Namespace prefixes
			model.setNsPrefix("foaf", FOAF.NS);
			model.setNsPrefix("doap", DOAP.NS);
			model.setNsPrefix("sioc", SIOC.NS);
			model.setNsPrefix("baetle", Baetle.NS);
			model.setNsPrefix("qml", QualiPSoML.NS);
			model.setNsPrefix("qdoc", QualiPSoDOC.NS);
			model.setNsPrefix("qsc", QualiPSoSC.NS);
			model.setNsPrefix("qvc", QualiPSoVC.NS);
			model.setNsPrefix("qrs", QualiPSoRS.NS);

			// Read existing project data
			model.read("file:"+SampleProjectConstants.ProjectFile);

			// People
			Resource dse = model.getResource("http://www.tid.es/3015/dse");
			Resource quiles = model.getResource("http://www.tid.es/3015/quiles");
			Resource mcp = model.getResource("http://www.tid.es/3015/mcp");
			Resource acs = model.getResource("http://www.urjc.es/escet/gsyc/acs");
			Resource julia = model.getResource("http://www.urjc.es/escet/gsyc/janaya");
			Resource chemi = model.getResource("http://www.tid.es/3015/josea");
			Resource nadia = model.getResource("http://www.unisa.it/crmpa/nromano");
			Resource luigi = model.getResource("http://www.unisa.it/rcost/lcerulo");

			// Documents
			Resource D432 = model.getResource(SampleProjectConstants.Repository+"/deliverables/D4.3.2/deliverable_D4.3.2");
			
			// Source code files
			Resource showOntologyFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"ShowOntology.java");
			Resource showSchemaFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"ShowSchema.java");
			Resource baetleFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"Baetle.java");
			Resource doapFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"DOAP.java");
			Resource foafFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"FOAF.java");
			Resource siocFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"SIOC.java");
			Resource qualipsoSCFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"QualiPSoSC.java");
			Resource qualipsoRSFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"QualiPSoRS.java");
			
			// repository
			Resource repository = model.getResource(SampleProjectConstants.Repository);
			
			// File 1
			String fileUri = SampleProjectConstants.Repository+"/43257293475892";
			Resource file_01 = createFile(
					model, 
					fileUri, 
					repository, 
					"/myproject/myfolder/MySourcefile.java");

			// Revisions
			Resource revision_01 = createRevision(
					model, 
					fileUri + "/0000001", 
					file_01, 
					quiles, 
					"1.34", 
					"HEAD", 
					"fixed the bug provided by fox", 
					"12/03/2003 23:30:11 CEST", 
					"Added: public class MySourceFile {. Removed: // comment.");
			Resource revision_02 = createRevision(
					model, 
					fileUri + "/0000002", 
					file_01, 
					luigi, 
					"1.33", 
					"HEAD", 
					"added a new feature", 
					"10/08/2001 13:30:41 CEST", 
					"Added: public void add().");

			Resource revision_03 = createRevision(
					model, 
					fileUri + "/0000003", 
					file_01, 
					nadia, 
					"1.32", 
					"HEAD", 
					"refactoring issues", 
					"14/01/2003 21:20:01 CEST", 
					"Added: String name. Removed: int name.");

			// Save the RDF file
			FileOutputStream fos = new FileOutputStream(SampleProjectConstants.ProjectFile);			
			model.write(fos);
			fos.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
