package org.qualipso.advdoc.coreapi.sample;

import java.io.FileOutputStream;

import org.qualipso.advdoc.coreapi.ontology.Baetle;
import org.qualipso.advdoc.coreapi.ontology.DOAP;
import org.qualipso.advdoc.coreapi.ontology.FOAF;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoDOC;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoRS;
import org.qualipso.advdoc.coreapi.ontology.QualiPSoSC;
import org.qualipso.advdoc.coreapi.ontology.SIOC;

import tdi.time.TdiQuickInstant;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;

public class SampleForumData {

	public static Resource createThread(
			OntModel model,
			Resource forum,    // forum
			String threadUri,
			Resource owner     // user
			) {
		Resource thread = model.createResource(threadUri);
		thread.addProperty(RDF.type, SIOC.Thread);
		forum.addProperty(SIOC.parent_of, thread);
		thread.addProperty(SIOC.has_parent, forum);
		owner.addProperty(SIOC.owner_of, thread);
		thread.addProperty(SIOC.has_owner, owner);
		return thread;

	}
	
	public static Resource createPost(
			OntModel model,
			Resource thread,     // thread
			String postUri,
			Resource creator,    // user
			String title,
			String content,
			Resource replyTo,    // post
			Resource relatedTo,  // post
			TdiQuickInstant creationDate
			) {

		Resource post = model.createResource(postUri);
		post.addProperty(RDF.type, SIOC.Post);
		post.addProperty(SIOC.has_container, thread);
		thread.addProperty(SIOC.container_of, post);
		post.addProperty(SIOC.has_creator, creator);
		creator.addProperty(SIOC.creator_of, post);
		if (replyTo != null) {
			post.addProperty(SIOC.reply_of, replyTo);
			replyTo.addProperty(SIOC.has_reply, post);
		}
		if (relatedTo != null) {
			post.addProperty(SIOC.related_to, relatedTo);
		}
		post.addProperty(SIOC.title, title);
		post.addProperty(SIOC.subject, title);
		post.addProperty(SIOC.content, content);

		return post;
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
			model.setNsPrefix("qsc", QualiPSoSC.NS);
			model.setNsPrefix("qrs", QualiPSoRS.NS);
			model.setNsPrefix("qdoc", QualiPSoDOC.NS);

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
			
			// Get the forum resource
			Resource forum = model.getResource(SampleProjectConstants.Forum);
			
			// Create thread-01 and posts
			Resource thread_01 = createThread(model, forum, SampleProjectConstants.Forum+"#000001", quiles);
			String title = "Load Testing GWT Application using JMeter";
			String content = "Hi everyone, I'm trying to do a load/stress test for a GWT based system using JMeter, but it isn´t working. First, I tryed to use the HTTP Proxy Server with no success. The first error was related to the charset utf-8, but I was using the current stable version, 2.2, and this version is too old, and after I used the current release, r545926, and the error with charset disappear. With this second option another error appears, due to a RPC Call, and the log is copyed bellow:"+
							 "So I give up to use the HTTP Proxy Server and tryed to reproduce the sequence calls, using a tool named HttpAnalyzerStdV2, which is a HTTP monitor. But when I start the sequence of calls, the same error occurs. The application works fine without the JMeter. Thanks in advance, Fabio ";
			Resource post_01_01 = createPost(model, thread_01, SampleProjectConstants.Forum+"#000001-01", quiles, title, content, null, null, new TdiQuickInstant(2007,9,12,0,0,0));
			post_01_01.addProperty(QualiPSoRS.relatedToDocument, D432);
			post_01_01.addProperty(QualiPSoRS.relatedToSourceCodeFile, showSchemaFile);
			
			content = "Hi Fabio,I have seen this problem cropping up a few times; it would be great to pin it down now. I assume that you are trying to replay non-empty, RPC request packets against the server? What version of GWT are you using? Were you able to or could you capture the contents of the request as it makes it to the RemoteServiceServlet?  It would be good to know if the request payload is the empty string or if the an empty string is being returned by readPayloadAsUtf8 for some reason. That makes me wonder, what is the value of the Content-Length header of the request?  Is it zero or not specified at all? Thanks, ";
			Resource post_01_02 = createPost(model, thread_01, SampleProjectConstants.Forum+"#000001-02", nadia, title, content, post_01_01, null, new TdiQuickInstant(2007,9,13,0,0,0));
			post_01_02.addProperty(QualiPSoRS.relatedToSourceCodeFile, showOntologyFile);

			content = "Hi Miguel, Yes, I'm trying to replay pre-recordered RPC request against the server (the same server that I used to record). We are using GWT 1.1.10. The problem occurs every time when we try to call any method of RemoteServiceServlet (we've a class \"ModuloServiceImpl\" that extends RemoteServiceServlet... we use this class like a \"dispatcher\" to all components that) The sequence of requests captured by JMeter are: ";
			Resource post_01_03 = createPost(model, thread_01, SampleProjectConstants.Forum+"#000001-03", quiles, title, content, post_01_02, null, new TdiQuickInstant(2007,9,15,0,0,0));

			content = "I'm stumped on this one.  Have you tried to see if it happens with GWT 1.3.3? The POST (the actual RPC request) seems to have data in it, at least it claims to have a length of 118 which should be fine.  I also see the 500 error coming back from the server which I assume to be the result of the OutOfBoundException in the service implementation.  It would be good to see what the payload of the POST was. I would recommend that you override the RemoteService.onBeforeRequestDeserialized(String) method in your RemoteServiceServlet subclass.  If the string is null there and the POST payload is non-empty then we probably have a problem with the RemoteServiceServlet.readPayloadAsUtf8 method; apparently on Win2k. ";
			Resource post_01_04 = createPost(model, thread_01, SampleProjectConstants.Forum+"#000001-04", nadia, title, content, post_01_03, null, new TdiQuickInstant(2007,9,17,0,0,0));
			post_01_04.addProperty(QualiPSoRS.relatedToSourceCodeFile, foafFile);

			// Create thread-02 and posts
			Resource thread_02 = createThread(model, forum, SampleProjectConstants.Forum+"#000002", dse);
			title = "bar charts - graph library with GWT";
			content = "Hello-I need to display bar charts with my GWT application. Does anyone know of good packages/libraries which provides graphing/charting application within GWT? Haas any one implemented graph package with GWT? Joster ";
			Resource post_02_01 = createPost(model, thread_02, SampleProjectConstants.Forum+"#000002-01", dse, title, content, null, null, new TdiQuickInstant(2007,10,2,0,0,0));
			post_02_01.addProperty(QualiPSoRS.relatedToDocument, D432);
			post_02_01.addProperty(QualiPSoRS.relatedToSourceCodeFile, siocFile);
			post_02_01.addProperty(QualiPSoRS.relatedToSourceCodeFile, doapFile);

			content = "You might find this helpful: http://gwt.components.googlepages.com/canvas Amir ";
			Resource post_02_02 = createPost(model, thread_02, SampleProjectConstants.Forum+"#000002-02", acs, title, content, post_02_01, post_01_03, new TdiQuickInstant(2007,10,5,0,0,0));
			post_02_02.addProperty(QualiPSoRS.relatedToSourceCodeFile, showOntologyFile);

			content = "check the last entry in this page: http://www.jfree.org/phpBB2/viewtopic.php?t=19080 I use the JFreeChart explained there.. and its very good ";
			Resource post_02_03 = createPost(model, thread_02, SampleProjectConstants.Forum+"#000002-03", luigi, title, content, post_02_02, post_01_03, new TdiQuickInstant(2007,10,6,0,0,0));
			post_02_03.addProperty(QualiPSoRS.relatedToSourceCodeFile, qualipsoRSFile);

			content = "Thanks. I am looking for an interactive chart component. Something like an interactive bar chart - where I can click on bar's and trigger events. Has anyone built something like this? Please share your learning and/or component. Joster ";
			Resource post_02_04 = createPost(model, thread_02, SampleProjectConstants.Forum+"#000002-04", dse, title, content, post_02_01, null, new TdiQuickInstant(2007,10,7,0,0,0));
			post_02_04.addProperty(QualiPSoRS.relatedToSourceCodeFile, foafFile);
			post_02_04.addProperty(QualiPSoRS.relatedToSourceCodeFile, qualipsoSCFile);

			content = "this might help... http://timepedia.org/ChronoscopeHome.html jim";
			Resource post_02_05 = createPost(model, thread_02, SampleProjectConstants.Forum+"#000002-05", mcp, title, content, post_02_01, null, new TdiQuickInstant(2007,10,9,0,0,0));
			post_02_05.addProperty(QualiPSoRS.relatedToSourceCodeFile, foafFile);
			post_02_05.addProperty(QualiPSoRS.relatedToDocument, D432);

			content = "Besides the other options, wy can't you just create a box, and add other boxes to it, setting their height/width depending on your data? Of all the cart types, a bar chart should be easy to do in a GWT environment without any special libraries. - Brill Pappin ";
			Resource post_02_06 = createPost(model, thread_02, SampleProjectConstants.Forum+"#000002-06", quiles, title, content, post_02_01, null, new TdiQuickInstant(2007,10,14,0,0,0));

			// Save the RDF file
			FileOutputStream fos = new FileOutputStream(SampleProjectConstants.ProjectFile);			
			model.write(fos);
			fos.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
