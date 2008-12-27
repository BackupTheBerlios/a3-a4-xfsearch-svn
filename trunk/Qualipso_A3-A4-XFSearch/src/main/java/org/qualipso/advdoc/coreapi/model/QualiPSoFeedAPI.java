package org.qualipso.advdoc.coreapi.model;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import tdi.time.TdiChronometer;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.shared.Lock;

public class QualiPSoFeedAPI extends QualiPSoRetrievalAPI {

	public QualiPSoFeedAPI() throws Exception {
		super();
	}
	
	/**
	 * Load the model with new RDF data
	 * @param rdfData
	 */
	public void loadRDFData(String rdfData) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.WRITE);
		try {
			getModel().read(new ByteArrayInputStream(rdfData.getBytes()),null);
		} finally {
			setModified();
			getModel().leaveCriticalSection();
			crono.pause();
			debug("loadRDFData() "+crono.elapsed()+" ms");
		}
	}
	
	/**
	 * Creates a new resource (WS)
	 * @param resourceUri
	 * @return the new resource
	 */
	public Resource createResource(String resourceUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.WRITE);
		Resource r = null;
		try {
			r = getModel().createResource(resourceUri);
			return r;
		} finally {
			setModified();
			getModel().leaveCriticalSection();
			crono.pause();
			debug("createResource() "+crono.elapsed()+" ms");
			detail("URI   : "+resourceUri);
			detail("Result: "+r);
		}
	}

	/**
	 * Creates a new anonymous resource (WS)
	 * @return the new resource
	 */
	public Resource createAnonymousResource() {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.WRITE);
		Resource resource = null;
		try {
			resource = getModel().createResource();
			return resource;
		} finally {
			setModified();
			getModel().leaveCriticalSection();
			crono.pause();
			debug("createAnonymousResource() "+crono.elapsed()+" ms");
			detail("Result: "+resource);
		}
	}

	
	/**
	 * Creates a new property
	 * @param propertyUri
	 * @return the new property
	 */
	public Property createProperty(String propertyUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.WRITE);
		Property p = null;
		try {
			p = getModel().createProperty(propertyUri);
			return p;
		} finally {
			setModified();
			getModel().leaveCriticalSection();
			crono.pause();
			debug("createProperty() "+crono.elapsed()+" ms");
			detail("URI   : "+propertyUri);
			detail("Result: "+p);
		}
	}
	
	/**
	 * Create a new statement with a literal (WS)
	 * @param resource
	 * @param property
	 * @param literal
	 * @return the resource
	 */
	public Resource addProperty(Resource resource,Property property,String literal) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.WRITE);
		try {
			resource.addProperty(property, literal);
			return resource;
		} finally {
			setModified();
			getModel().leaveCriticalSection();
			crono.pause();
			debug("addProperty() "+crono.elapsed()+" ms");
			detail("Resource :  "+resource.getURI());
			detail("Property :  "+property.getURI());
			detail("Literal  :  "+literal);
		}
	}
	
	/**
	 * Create a new statement with an object (WS)
	 * @param resource
	 * @param property
	 * @param object
	 * @return the resource
	 */
	public Resource addProperty(Resource resource,Property property,Resource object) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();		
		getModel().enterCriticalSection(Lock.WRITE);
		try {
			resource.addProperty(property, object);
			return resource;
		} finally {
			setModified();
			getModel().leaveCriticalSection();
			crono.pause();
			debug("addProperty() "+crono.elapsed()+" ms");
			detail("Resource :  "+resource.getURI());
			detail("Property :  "+property.getURI());
			detail("Object   :  "+object.getURI());
		}
	}
	
	/**
	 * Remove all sentences with a property for a given resource (WS)
	 * @param resource
	 * @param property
	 */
	public void removeProperty(Resource resource,Property property) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.WRITE);
		try {
			getModel().removeAll(resource,property,null);
		} finally {
			setModified();
			getModel().leaveCriticalSection();
			crono.pause();
			debug("removeProperty() "+crono.elapsed()+" ms");
			detail("Resource :  "+resource.getURI());
			detail("Property :  "+property.getURI());
		}
	}
	

	public static void main(String[] args) {
		try {
			
			QualiPSoFeedAPI model = new QualiPSoFeedAPI();

			// createResource
			model.createResource("http://www.qualipso.org/projects/qualipso/a4/advdoc/repository#Test.java");
			model.createResource("http://www.qualipso.org/projects/qualipso/a4/advdoc/repository#Test45.java");
			//model.createResource("adrian.colyer@gmail.com");
			// Test
			Resource src = model.getResourceByUri("http://www.qualipso.org/projects/qualipso/a4/advdoc/repository#Test.java");
			System.out.println("createResource() -> "+src);
			src = model.getResourceByUri("http://www.qualipso.org/projects/qualipso/a4/advdoc/repository#Test45.java");
			System.out.println("createResource() -> "+src);
			//src = model.getResourceByUri("adrian.colyer@gmail.com");
			//System.out.println("createResource() -> "+src);

			// createAnonymousResource
			Resource anon = model.createAnonymousResource();
			// Test
			System.out.println("createAnonymousResource() -> "+anon.getId().getLabelString());

			// createProperty
			model.createProperty("http://www.qualipso.org/ontology/doc/qualipso_source_code#hasJavaVersion");
			// Test
			Property javaVersion = model.getPropertyByUri("http://www.qualipso.org/ontology/doc/qualipso_source_code#hasJavaVersion");
			System.out.println("createProperty() -> "+javaVersion);
			
			// addProperty
			model.addProperty(src, javaVersion, "1.5");
			// Test
			ArrayList properties = model.getResourceProperties(src.getURI());
			System.out.println("addProperty() -> "+properties.size()+ " "+properties);

			// addProperty
			Resource version = model.createResource("http://www.qualipso.org/ontology/doc/qualipso_source_code#Java1.5");
			model.addProperty(src, javaVersion, version);
			// Test
			properties = model.getResourceProperties(src.getURI());
			System.out.println("addProperty() -> "+properties.size()+ " "+properties);
			
			// removeProperty
			Resource quiles = model.getResourceByUri("http://www.tid.es/3015/quiles");
			properties = model.getResourceProperties("http://www.tid.es/3015/quiles");
			System.out.println("Before removeProperty() -> "+properties.size()+ " "+properties);
			Property prop = model.getPropertyByUri("http://xmlns.com/foaf/0.1/surname");
			model.removeProperty(quiles, prop);
			properties = model.getResourceProperties("http://www.tid.es/3015/quiles");
			System.out.println("After removeProperty() -> "+properties.size()+ " "+properties);
			
			// loadRDFData
			FileInputStream fis = new FileInputStream("rdf/mailinglist_sample.rdf");
			int l = (int)new File("rdf/mailinglist_sample.rdf").length();
			byte[] data = new byte[l];
			fis.read(data);
			fis.close();
			String rdf = new String(data);
			model.loadRDFData(rdf);
			
			model.saveBackup();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
