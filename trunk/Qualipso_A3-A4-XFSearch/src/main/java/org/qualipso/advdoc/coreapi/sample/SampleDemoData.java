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

public class SampleDemoData {

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
			model.setNsPrefix("qvc", QualiPSoVC.NS);
			model.setNsPrefix("qml", QualiPSoML.NS);

			// Read existing project data
			model.read("file:"+SampleProjectConstants.ProjectFile);

			// Save the RDF file
			FileOutputStream fos = new FileOutputStream(SampleProjectConstants.ProjectFile);			
			model.write(fos);
			fos.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
