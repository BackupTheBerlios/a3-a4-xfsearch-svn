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

public class SampleBugData {

	
	public static Resource createIssue(
			OntModel model,
			String issueUri,
			String issueType,
			Resource project,
			Resource owner,
			String name,
			String description,
			String environment,
			String platform,
			String operating_system,
			Resource priority,
			TdiQuickInstant created,
			int votes
			) {
		Resource issue = model.createResource(issueUri);
		issue.addProperty(RDF.type, issueType);
		issue.addProperty(Baetle.project, project);
		issue.addProperty(SIOC.has_owner, owner);
		issue.addProperty(Baetle.name, name);
		issue.addProperty(Baetle.description, description);
		issue.addProperty(Baetle.environment, environment);
		issue.addProperty(Baetle.platform, platform);
		issue.addProperty(Baetle.operating_system, operating_system);
		issue.addProperty(Baetle.priority, priority);
		issue.addProperty(Baetle.created, created.toISO8601());
		issue.addProperty(Baetle.votes, ""+votes);
		return issue;
	}
	
	public static Resource addCommentToIssue(
			OntModel model,
			Resource issue,
			Resource creator,
			TdiQuickInstant date,
			String description
			) {
		Resource comment = model.createResource();
		comment.addProperty(RDF.type, SIOC.Post);
		issue.addProperty(Baetle.comment, comment);
		comment.addProperty(SIOC.has_creator, creator);
		comment.addProperty(SIOC.created_at, date.toISO8601());
		comment.addProperty(SIOC.description, description);
		return comment;
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

			// Project
			Resource project = model.getResource(SampleProjectConstants.ProjectURI);
			
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
			
			// modules
			Resource mod_coreapi = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"mod_coreapi");
			Resource mod_ws = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"mod_ws");
			Resource mod_infosources = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"mod_infosources");
			Resource mod_advtools = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"mod_advtools");

			// Source code files
			Resource showOntologyFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"ShowOntology.java");
			Resource showSchemaFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"ShowSchema.java");
			Resource baetleFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"Baetle.java");
			Resource doapFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"DOAP.java");
			Resource foafFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"FOAF.java");
			Resource siocFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"SIOC.java");
			Resource qualipsoSCFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"QualiPSoSC.java");
			Resource qualipsoRSFile = model.getResource(SampleProjectConstants.SourceCodeBaseURI+"QualiPSoRS.java");

			// Forum threads and posts
			Resource thread_01 = model.getResource(SampleProjectConstants.Forum+"#000001");
			Resource post_01_01 = model.getResource(SampleProjectConstants.Forum+"#000001-01");
			Resource post_01_02 = model.getResource(SampleProjectConstants.Forum+"#000001-02");
			Resource post_01_03 = model.getResource(SampleProjectConstants.Forum+"#000001-03");
			Resource post_01_04 = model.getResource(SampleProjectConstants.Forum+"#000001-04");
			Resource thread_02 = model.getResource(SampleProjectConstants.Forum+"#000002");
			Resource post_02_01 = model.getResource(SampleProjectConstants.Forum+"#000002-01");
			Resource post_02_02 = model.getResource(SampleProjectConstants.Forum+"#000002-02");
			Resource post_02_03 = model.getResource(SampleProjectConstants.Forum+"#000002-03");
			Resource post_02_04 = model.getResource(SampleProjectConstants.Forum+"#000002-04");
			Resource post_02_05 = model.getResource(SampleProjectConstants.Forum+"#000002-05");
			Resource post_02_06 = model.getResource(SampleProjectConstants.Forum+"#000002-06");
			
			// Priorities
			Resource blockerPriority = model.createResource();
			blockerPriority.addProperty(RDF.type, Baetle.Blocker.getURI());
			Resource majorPriority = model.createResource();
			majorPriority.addProperty(RDF.type, Baetle.Major.getURI());
			Resource minorPriority = model.createResource();
			minorPriority.addProperty(RDF.type, Baetle.Minor.getURI());
			Resource criticalPriority = model.createResource();
			criticalPriority.addProperty(RDF.type, Baetle.Critical.getURI());
			
			// Create Issues
			Resource issue_01 = createIssue(model, SampleProjectConstants.BugDatabase+"#8009", Baetle.Enhancement.getURI(), project, quiles, "[Editor Mgmt] Split File Editor", "It would improve usability if it were possible to split the file editor like you can in MS Word or emacs. That is to say, have the equivalent of two editors open on the same file in the same page.", "", "PC", "Windows", majorPriority, new TdiQuickInstant(2002,1,22,0,0,0),181);
			addCommentToIssue(model, issue_01, acs, new TdiQuickInstant(2002,1,25,0,0,0), "Request makes sense but has lower priority for 2.0 unless we get external help we will not be able to do it. ");
			addCommentToIssue(model, issue_01, nadia, new TdiQuickInstant(2002,6,17,0,0,0), "Moving to Platform as this would be generally useful for text editors. Still deferred to post 2.0 though.");
			addCommentToIssue(model, issue_01, mcp, new TdiQuickInstant(2002,6,17,0,0,0), "Bug 20090 has been marked as a duplicate of this bug.");
			addCommentToIssue(model, issue_01, quiles, new TdiQuickInstant(2002,8,9,0,0,0), "Reopen to investigate");
			addCommentToIssue(model, issue_01, quiles, new TdiQuickInstant(2004,1,7,0,0,0), "It would be especially helpful if one could split the text editing area to work on two different documents simultaneously as well, with the option of splitting both horizontally and vertically (documents side-by-side and documents one above the other). That is, the functionality should work for multiple views of the same document and for views of different documents, and should be available as both horizontal and vertical spits.");
			addCommentToIssue(model, issue_01, chemi, new TdiQuickInstant(2004,1,7,0,0,0), "Split of different documents is already supported (just drag the editor tab to the side, top, or bottom of the current editor area). This request is for a split of the same document.");

			Resource issue_02 = createIssue(model, SampleProjectConstants.BugDatabase+"#215518", Baetle.Defect.getURI(), project, dse, "NullPointerException during export", "Build ID: M20071023-1652 Steps To Reproduce: 1. create new project, which is PDE project (osgi bundle for equinox) and has AspectJ capability 2. try to export project with Export -> Plug-in Development -> Deployable plug-ins and fragments with AspectJ Support More information: I have ajdt 1.5.1 from 11.01.2008 (with aspectj 1.5.4, date the same). During export of plug-in with AspectJ support NullPointerException is thrown.","", "MAC", "MacOS", criticalPriority, new TdiQuickInstant(2008,1,16,0,0,0),16);

			Resource issue_03 = createIssue(model, SampleProjectConstants.BugDatabase+"#201052", Baetle.Enhancement.getURI(), project, mcp, "[RCP] RCP should provide some role based access control", "When building commercial applications it is often necessary to allow or deny access to actions, views, editors, wizards and perspectives based on the role of the user of this application. Since there is no support for this in RCP one has to build custom solutions, sometimes by modifying parts of RCP, sometimes by doing tricks with actions and plugins. My company has just started to work on an concept to integrate role based access control into RCP. We are looking for requirements and, as soon as the first documents are done, feedback. The goal is to find a non intrusive way to add access control to RCP. If there are already other people working on this we would like to get in contact.", "", "PC", "Windows", minorPriority, new TdiQuickInstant(2007,8,24,0,0,0),18);
			addCommentToIssue(model, issue_03, quiles, new TdiQuickInstant(2007,8,24,0,0,0), "Nice indeed, very nice. I'll keep looking forward what you find out. Do you know about the Equinox-Project working on Security? http://mea-bloga.blogspot.com/2007/07/equinox-and-security.html");
			addCommentToIssue(model, issue_03, dse, new TdiQuickInstant(2007,8,24,0,0,0), "You can go a long way with activities. See http://blog.rcp-company.com/2007/06/using-activities-for-user-management.html But only as long as you don't use of \"open view\" or the perspective chooser... To me, the easy solution would be to plug the holes in the activities solution. Possibly via a new configuration setting. Please note that I assume a lot here about the security of the target machine and the lock-down of the OS. If that is not the case, we will need a completely new framework that is resilient to all the possible attaches via Trojan plug-in...");
			addCommentToIssue(model, issue_03, quiles, new TdiQuickInstant(2007,8,31,0,0,0), "Another interesting approach might use AbstractSourceProvider in conjunction with the IHandlerService, IEvaluationService, ... ");

			// Relate issues to source code modules
			issue_01.addProperty(QualiPSoRS.bugAboutSourceCodeModule, mod_coreapi);
			issue_01.addProperty(QualiPSoRS.bugAboutSourceCodeModule, mod_ws);
			issue_02.addProperty(QualiPSoRS.bugAboutSourceCodeModule, mod_infosources);
			issue_03.addProperty(QualiPSoRS.bugAboutSourceCodeModule, mod_advtools);
			
			// Relate forum posts to issues
			post_01_03.addProperty(QualiPSoRS.relatedToIssue, issue_01);
			post_01_03.addProperty(QualiPSoRS.relatedToIssue, issue_03);
			post_02_03.addProperty(QualiPSoRS.relatedToIssue, issue_02);
			post_01_04.addProperty(QualiPSoRS.relatedToIssue, issue_03);
			post_02_05.addProperty(QualiPSoRS.relatedToIssue, issue_03);
			post_02_04.addProperty(QualiPSoRS.relatedToIssue, issue_03);
			
			// Relate issues to source code files
			issue_01.addProperty(QualiPSoRS.bugAboutSourceCodeFile, showOntologyFile);
			issue_01.addProperty(QualiPSoRS.bugAboutSourceCodeFile, doapFile);
			issue_01.addProperty(QualiPSoRS.bugAboutSourceCodeFile, qualipsoSCFile);
			issue_02.addProperty(QualiPSoRS.bugAboutSourceCodeFile, foafFile);
			issue_02.addProperty(QualiPSoRS.bugAboutSourceCodeFile, showSchemaFile);
			
			// Relate issues to document
			issue_01.addProperty(QualiPSoRS.bugAboutDocument, D432);
			issue_03.addProperty(QualiPSoRS.bugAboutDocument, D432);
			
			// Relate issues to document sections
			// TODO
			
			// Save the RDF file
			FileOutputStream fos = new FileOutputStream(SampleProjectConstants.ProjectFile);			
			model.write(fos);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
