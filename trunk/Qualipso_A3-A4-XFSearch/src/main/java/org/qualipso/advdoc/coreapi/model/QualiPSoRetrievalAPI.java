package org.qualipso.advdoc.coreapi.model;

import java.util.ArrayList;

import tdi.time.TdiChronometer;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.shared.Lock;
import com.hp.hpl.jena.vocabulary.RDF;

public class QualiPSoRetrievalAPI extends QualiPSoStorageAPI {

	public QualiPSoRetrievalAPI() throws Exception {
		super();
	}
	
	/**
	 * Get a resource from a given URI
	 * @param resourceUri
	 * @return
	 */
	public Resource getResourceByUri(String resourceUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		Resource r = null;
		try {
			r = getModel().getResource(resourceUri);
			return r;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getResourcesByUri() "+crono.elapsed()+" ms");
			detail("URI     : "+resourceUri);
			detail("Result  : "+r);
		}
	}

	/**
	 * Get a property from a given URI
	 * @param propertyUri
	 * @return
	 */
	public Property getPropertyByUri(String propertyUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		Property p = null;
		try {
			p = getModel().getProperty(propertyUri);
			return p;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getPropertyByUri() "+crono.elapsed()+" ms");
			detail("URI     : "+propertyUri);
			detail("Result  : "+p);
		}
	}

	/**
	 * Get all resources of a given type or class (WS)
	 * @param typeUri
	 * @return List of Resource
	 */
	public ArrayList getResourcesByType(String typeUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			Resource typeResource = getResourceByUri(typeUri);
			ResIterator i = getModel().listSubjectsWithProperty(RDF.type,typeResource);
			while (i.hasNext()) {
				Resource r = i.nextResource();
				result.add(r);
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getResourcesByType() "+crono.elapsed()+" ms");
			detail("URI     : "+typeUri);
			detail("Result  : "+result.size());
		}
	}
	
	/**
	 * Get all properties of a given resource (WS)
	 * @param resourceUri
	 * @return List of Statement
	 */
	public ArrayList getResourceProperties(String resourceUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			Resource r = getResourceByUri(resourceUri);
			StmtIterator i = r.listProperties();
			while (i.hasNext()) {
				Statement stmt = i.nextStatement();
				result.add(stmt);
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getResourceProperties() "+crono.elapsed()+" ms");
			detail("URI     : "+resourceUri);
			detail("Result  : "+result.size());
		}
	}
	
	/**
	 * Get a property of a given resource (WS)
	 * @param resourceUri
	 * @param propertyUri
	 * @return List of Statement
	 */
	public ArrayList getResourceProperty(String resourceUri,String propertyUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			Resource r = getResourceByUri(resourceUri);
			Property p = getModel().getProperty(propertyUri);
			StmtIterator i = r.listProperties(p);
			while (i.hasNext()) {
				Statement stmt = i.nextStatement();
				result.add(stmt);
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getResourceProperty() "+crono.elapsed()+" ms");
			detail("resource URI     : "+resourceUri);
			detail("property URI     : "+resourceUri);
			detail("Result  : "+result.size());
		}
	}

	/**
	 * Get all resources with a given property (WS)
	 * @param propertyUri
	 * @return List of Resource
	 */
	public ArrayList getResourcesWithProperty(String propertyUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			Property p = getModel().getProperty(propertyUri);
			ResIterator i = getModel().listSubjectsWithProperty(p);
			while (i.hasNext()) {
				Resource r = i.nextResource();
				result.add(r);
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getResourcesWithProperty() "+crono.elapsed()+" ms");
			detail("property URI     : "+propertyUri);
			detail("Result  : "+result.size());
		}
	}
	
	/**
	 * Get resources with a property with a given value (WS)
	 * @param propertyUri
	 * @param value
	 * @return List of Resource
	 */
	public ArrayList getResourcesWithPropertyValue(String propertyUri,String value) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			Property p = getModel().getProperty(propertyUri);
			ResIterator i = getModel().listSubjectsWithProperty(p,value);
			while (i.hasNext()) {
				Resource r = i.nextResource();
				result.add(r);
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getResourcesWithPropertyValue() "+crono.elapsed()+" ms");
			detail("property URI     : "+propertyUri);
			detail("value            : "+value);
			detail("Result  : "+result.size());
		}
	}
	
	public static void main(String[] args) {
		try {
			
			QualiPSoRetrievalAPI model = new QualiPSoRetrievalAPI();
			
			// getResourceByUri()
			Resource quiles = model.getResourceByUri("http://www.tid.es/3015/quiles");
			System.out.println("getResourceByUri() -> "+quiles);

			// getPropertyByUri()
			Property invokes = model.getPropertyByUri("http://www.qualipso.org/ontology/doc/qualipso_source_code#invokesMethod");
			System.out.println("getPropertyByUri() -> "+invokes);

			// getResourcesByType()
			ArrayList folders = model.getResourcesByType("http://www.qualipso.org/ontology/doc/qualipso_documentation#Folder");
			System.out.println("getResourcesByType() -> "+folders.size()+ " " + folders);
			
			// getResourceProperties()
			ArrayList quilesProperties = model.getResourceProperties("http://www.tid.es/3015/quiles");
			System.out.println("getResourceProperties() -> "+quilesProperties.size()+ " " + quilesProperties);

			// getResourceProperty()
			Resource docStore = model.getResourceByUri("http://www.qualipso.org/a4/advdoc/documentation");
			ArrayList hasFolder = model.getResourceProperty(docStore.toString(),"http://www.qualipso.org/ontology/doc/qualipso_documentation#hasFolder");
			System.out.println("getResourceProperty() -> "+hasFolder.size()+ " " + hasFolder);

			// getResourcesWithProperty()
			ArrayList names = model.getResourcesWithProperty("http://xmlns.com/foaf/0.1/surname");
			System.out.println("getResourcesWithProperty() -> "+names.size()+ " " + names);

			// getResourcesWithPropertyValue()
			ArrayList namesQuiles = model.getResourcesWithPropertyValue("http://xmlns.com/foaf/0.1/surname","Quiles");
			System.out.println("getResourcesWithPropertyValue() -> "+namesQuiles.size()+ " " + namesQuiles);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
