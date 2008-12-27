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
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.RDF;

/**
 * Create sample RDF data for project, groups, organizations, persons and communities
 * The classes in this package must be executed in the following order:
 * 		- SampleProjectData
 * 		- SampleSourceCodeData
 * 		- SampleDocumentationData
 * 		- SampleForumData
 * 		- SampleBugData
 * @author quiles
 * @version 1.0
 *
 */
public class SampleProjectData {

	/**
	 * Create a new RDF organization resource
	 * @author quiles
	 * @param model
	 * @param organizationUri
	 * @return the created resource
	 */
	public static Resource createOrganization(OntModel model,String organizationUri) {
		Resource organization = model.createResource(organizationUri);
		organization.addProperty(RDF.type, FOAF.Organization);
		return organization;
	}
	
	/**
	 * Create a new RDF group resource
	 * @author quiles
	 * @param model
	 * @param groupUri
	 * @return the created resource
	 */
	public static Resource createGroup(OntModel model,String groupUri) {
		Resource group = model.createResource(groupUri);
		group.addProperty(RDF.type, FOAF.Group);
		return group;
	}
	
	/**
	 * Create a new RDF person resource
	 * @author quiles
	 * @param model
	 * @param personUri
	 * @param firstName
	 * @param surname
	 * @param mbox
	 * @return the created resource
	 */
	public static Resource createPerson(OntModel model,String personUri,String firstName,String surname,String mbox) {
		Resource person = model.createResource(personUri);
		person.addProperty(RDF.type, FOAF.Person);
		person.addProperty(RDF.type, SIOC.User);
		person.addProperty(FOAF.firstName, firstName);
		person.addProperty(FOAF.surname, surname);
		person.addProperty(FOAF.mbox, mbox);
		person.addProperty(SIOC.first_name, firstName);
		person.addProperty(SIOC.last_name, surname);
		person.addProperty(SIOC.name, firstName+" "+surname);
		person.addProperty(SIOC.email, mbox);
		
		return person;
	}
	
	/**
	 * Create a new RDF project resource
	 * @author quiles
	 * @param model
	 * @param projectUri
	 * @param homePages
	 * @param releases
	 * @param downloadPages
	 * @param wikiUri
	 * @param mailingListUri
	 * @param repositoryUri
	 * @param bugDatabaseUri
	 * @param mantainers
	 * @param developers
	 * @param documenters
	 * @param translators
	 * @param testers
	 * @param programmingLanguages
	 * @param os
	 * @return the created resource
	 */
	public static Resource createProject(
			OntModel model,
			String projectUri,
			String[] homePages,
			String[] releases,
			String[] downloadPages,
			String wikiUri,
			String mailingListUri,
			String repositoryUri,
			String bugDatabaseUri,
			String forumUri,
			Resource[] mantainers,
			Resource[] developers,
			Resource[] documenters,
			Resource[] translators,
			Resource[] testers,
			Resource[] programmingLanguages,
			String[] os) {
		
		Resource project = model.createResource(projectUri);
		project.addProperty(RDF.type, DOAP.Project);
		
		for (int i = 0;i < homePages.length;i++) {
			Resource homePage = model.createResource(homePages[i]);
			project.addProperty(DOAP.homepage, homePage);
		}
		for (int i = 0;i < releases.length;i++) {
			project.addProperty(DOAP.release, model.createResource().addProperty(DOAP.revision, releases[i]));
		}
		for (int i = 0;i < downloadPages.length;i++) {
			Resource downloadPage = model.createResource(downloadPages[i]);
			project.addProperty(DOAP.download_page, downloadPage);
		}
		// Wiki
		Resource wikiRes = model.createResource(wikiUri);
		project.addProperty(DOAP.wiki, wikiRes);
		// Mailing list
		Resource maillistRes = model.createResource(mailingListUri);
		project.addProperty(DOAP.mailing_list, maillistRes);
		// Repository
		Resource repository = model.createResource(repositoryUri);
		repository.addProperty(RDF.type, DOAP.SVNRepository);
		repository.addProperty(DOAP.location, repositoryUri);
		project.addProperty(DOAP.repository, repository);
		// Bug database
		Resource bugDatabaseRes = model.createResource(bugDatabaseUri);
		project.addProperty(DOAP.bug_database, bugDatabaseRes);
		// Forum
		Resource forumRes = model.createResource(forumUri);
		forumRes.addProperty(RDF.type, SIOC.Forum);
		project.addProperty(QualiPSoRS.hasForum, forumRes);
		// Mantainers
		for (int i = 0;i < mantainers.length;i++) {
			project.addProperty(DOAP.maintainer, mantainers[i]);
		}
		for (int i = 0;i < developers.length;i++) {
			project.addProperty(DOAP.developer, developers[i]);
		}
		for (int i = 0;i < documenters.length;i++) {
			project.addProperty(DOAP.documenter, documenters[i]);
		}
		for (int i = 0;i < translators.length;i++) {
			project.addProperty(DOAP.translator, translators[i]);
		}
		for (int i = 0;i < testers.length;i++) {
			project.addProperty(DOAP.tester, testers[i]);
		}
		for (int i = 0;i < programmingLanguages.length;i++) {
			project.addProperty(DOAP.programming_language, programmingLanguages[i]);
		}
		for (int i = 0;i < os.length;i++) {
			project.addProperty(DOAP.os, os[i]);
		}
				
		return project;
		
	}
	
	/**
	 * Create a new RDF community resource
	 * @author quiles
	 * @param model
	 * @param communityUri
	 * @param title
	 * @param people
	 * @return the created resource
	 */
	private static Resource createCommunity(OntModel model,String communityUri,String title,Resource[] people) {
		
		Resource community = model.createResource(communityUri);
		community.addProperty(RDF.type, SIOC.Community);
		community.addProperty(DC.title, title);
		
		for (int i = 0;i < people.length;i++) {
			community.addProperty(FOAF.member, people[i]);
		}
		
		return community;
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
			
			// Create organizations
			Resource tid = createOrganization(model, "http://www.tid.es");
			Resource urjc = createOrganization(model, "http://www.urjc.es");
			Resource unisa = createOrganization(model, "http://www.unisa.it");

			// Create work groups
			Resource tidGroup = createGroup(model, "http://www.tid.es/qualipso/a4/groups/tid");
			Resource urjcGroup = createGroup(model, "http://www.urjc.es/qualipso/a4/groups/urjc");
			Resource crmpaGroup = createGroup(model, "http://www.unisa.it/qualipso/a4/groups/crmpa");
			Resource rcostGroup = createGroup(model, "http://www.unisa.it/qualipso/a4/groups/rcost");

			// Create people
			Resource dse = createPerson(model, "http://www.tid.es/3015/dse", "David", "Sanchez", "mailto:dse@tid.es");
			Resource quiles = createPerson(model, "http://www.tid.es/3015/quiles", "Jose Antonio", "Quiles", "mailto:quiles@tid.es");
			Resource mcp = createPerson(model, "http://www.tid.es/3015/mcp", "Miguel", "Carrillo", "mailto:mcp@tid.es");
			Resource acs = createPerson(model, "http://www.urjc.es/escet/gsyc/acs", "Alvaro", "del Castillo", "mailto:acs@gsyc.escet.urjc.es");
			Resource julia = createPerson(model, "http://www.urjc.es/escet/gsyc/janaya", "Julia", "Anaya", "mailto:janaya@gsyc.escet.urjc.es");
			Resource chemi = createPerson(model, "http://www.tid.es/3015/josea", "Jose Miguel", "Alonso", "mailto:josea@tid.es");
			Resource nadia = createPerson(model, "http://www.unisa.it/crmpa/nromano", "Nadia", "Romano", "mailto:nromano@crmpa.unisa.it");
			Resource luigi = createPerson(model, "http://www.unisa.it/rcost/lcerulo", "Luigi", "Cerulo", "mailto:lcerulo@unisannio.it");
			
			// Create the project
			Resource advdocProject = createProject(
					model, 
					SampleProjectConstants.ProjectURI, 
					new String[] { "http://www.qualipso.org/a4/advdoc" }, 
					new String[] { "1.0" }, 
					new String[] { "http://www.qualipso.org/a4/advdoc/downloads", "http://www.qualipso.org/forge/downloads" }, 
					SampleProjectConstants.Wiki,
					SampleProjectConstants.Mailist,
					SampleProjectConstants.Repository,
					SampleProjectConstants.BugDatabase,
					SampleProjectConstants.Forum,
					new Resource[] { mcp, chemi }, 
					new Resource[] { dse, quiles, acs, julia }, 
					new Resource[] { mcp, nadia }, 
					new Resource[] { acs }, 
					new Resource[] { dse, acs, luigi }, 
					new Resource[] { QualiPSoSC.Java, QualiPSoSC.Javascript, QualiPSoSC.HTML },
					new String[] { "Windows", "Linux", } );
			
			// Add people to groups
			tidGroup.addProperty(FOAF.member, chemi);
			tidGroup.addProperty(FOAF.member, quiles);
			tidGroup.addProperty(FOAF.member, mcp);
			tidGroup.addProperty(FOAF.member, dse);
			urjcGroup.addProperty(FOAF.member, acs);
			urjcGroup.addProperty(FOAF.member, julia);
			crmpaGroup.addProperty(FOAF.member, nadia);
			rcostGroup.addProperty(FOAF.member, luigi);
			
			// Current project for people
			dse.addProperty(FOAF.currentProject, advdocProject);
			quiles.addProperty(FOAF.currentProject, advdocProject);
			mcp.addProperty(FOAF.currentProject, advdocProject);
			acs.addProperty(FOAF.currentProject, advdocProject);
			julia.addProperty(FOAF.currentProject, advdocProject);
			chemi.addProperty(FOAF.currentProject, advdocProject);
			nadia.addProperty(FOAF.currentProject, advdocProject);
			luigi.addProperty(FOAF.currentProject, advdocProject);

			// Create de Community
			createCommunity(model, "http://www.qualipso.org/projects/qualipso/a4/community", "QualiPSo A4 Community", new Resource[] { dse, quiles, mcp, acs, julia, chemi, nadia, luigi } );
			
			// Save the RDF file (creates a new RDF file)
			FileOutputStream fos = new FileOutputStream(SampleProjectConstants.ProjectFile);			
			model.write(fos);
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
