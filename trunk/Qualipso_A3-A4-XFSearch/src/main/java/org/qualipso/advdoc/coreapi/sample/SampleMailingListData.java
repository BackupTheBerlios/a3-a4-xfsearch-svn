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

public class SampleMailingListData {

	public static Resource createMail(
			OntModel model,
			String mailUri,
			Resource from,
			String fromAddress,
			Resource[] to,
			String[] toAddress,
			Resource[] cc,
			String[] ccAddress,
			String subject,
			String contents,
			String date,
			Resource relatedToMail
			) {
		Resource mail = model.createResource(mailUri);
		mail.addProperty(RDF.type, QualiPSoML.Mail);
		mail.addProperty(QualiPSoML.from, from);
		mail.addProperty(QualiPSoML.from_address, fromAddress);
		mail.addProperty(SIOC.has_creator, from);
		for (int i = 0;i < to.length;i++) {
			mail.addProperty(QualiPSoML.to, to[i]);
		}
		for (int i = 0;i < toAddress.length;i++) {
			mail.addProperty(QualiPSoML.to_address, toAddress[i]);
		}
		for (int i = 0;i < cc.length;i++) {
			mail.addProperty(QualiPSoML.cc, cc[i]);
		}
		for (int i = 0;i < ccAddress.length;i++) {
			mail.addProperty(QualiPSoML.cc_address, ccAddress[i]);
		}
		mail.addProperty(SIOC.subject, subject);
		mail.addProperty(SIOC.title, subject);
		mail.addProperty(SIOC.content, contents);
		mail.addProperty(SIOC.created_at, date);
		if (relatedToMail != null) {
			mail.addProperty(SIOC.related_to, relatedToMail);
		}
		return mail;

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
			
			// Mail 1
			Resource mail_01 = createMail(
					model, 
					"http://mail.qualipso.org/projects/advdoc/mail_237463524", 
					quiles, 
					"quiles@tid.es", 
					new Resource[] { acs }, 
					new String[] { "acs@gsyc.escet.urjc.es" }, 
					new Resource[] { }, 
					new String[] { }, 
					"Email contacts", 
					"Hi! I think that the emails for the four people that we were in the A4 QualiPSo are in the To field. Until we have a mailing list we should email directly to this emails. Cheers", 
					"20061201", 
					null);

			// Mail 2
			Resource mail_02 = createMail(
					model, 
					"http://mail.qualipso.org/projects/advdoc/mail_48484746", 
					acs, 
					"acs@gsyc.escet.urjc.es", 
					new Resource[] { quiles }, 
					new String[] { "quiles@tid.es" }, 
					new Resource[] { }, 
					new String[] { }, 
					"Re: Email contacts", 
					"Thank you for the information", 
					"20061201", 
					mail_01);

			// Mail 3
			Resource mail_03 = createMail(
					model, 
					"http://mail.qualipso.org/projects/advdoc/mail_4837261", 
					quiles, 
					"quiles@tid.es", 
					new Resource[] { acs, chemi, dse, mcp }, 
					new String[] { "acs@gsyc.escet.urjc.es", "josea@tid.es", "dse@tid.es", "mcp@tid.es" }, 
					new Resource[] {julia, nadia }, 
					new String[] { "janaya@gsyc.escet.urjc.es", "nromano@crmpa.unisa.it"}, 
					"Email contacts", 
					"Hi Alvaro, did you read my proposal about modeling OSS with OWL? have you had any experience in this subject? have you modeled  any ontologies with OWL? Regards,  José Antonio",
					"20070112", 
					null);
			mail_03.addProperty(QualiPSoRS.mailAboutSourceCode, doapFile);
			mail_03.addProperty(QualiPSoRS.mailAboutSourceCode, qualipsoRSFile);
			mail_03.addProperty(QualiPSoRS.mailAboutDocument, D432);

			// Save the RDF file
			FileOutputStream fos = new FileOutputStream(SampleProjectConstants.ProjectFile);			
			model.write(fos);
			fos.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
