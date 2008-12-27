package org.qualipso.advdoc.coreapi.model;

import java.util.ArrayList;

import tdi.time.TdiChronometer;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.shared.Lock;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class QualiPSoMetadataAPI extends QualiPSoFeedAPI {

	public QualiPSoMetadataAPI() throws Exception {
		super();
	}
	
	/**
	 * Get superclasses of a given class (WS)
	 * @param classUri
	 * @param direct
	 * @return List of OntClass
	 */
	public ArrayList getSuperClasses(String classUri,boolean direct) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			//Resource r = getModel().getResource(classUri);
			//OntClass cls = (OntClass) r.as( OntClass.class );
			OntClass cls = getModel().getOntClass(classUri);
			if (cls == null) {
				return result;
			}
			ExtendedIterator superclasses = cls.listSuperClasses(direct);
			while (superclasses.hasNext()) {
				Resource res = (Resource)superclasses.next();
				if (res instanceof OntClass) {
					OntClass supcls = (OntClass)res.as(OntClass.class);
					if (!classUri.equals(supcls.getURI())) {
						result.add(supcls);
					}
				}
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getSuperClasses() "+crono.elapsed()+" ms");
			detail("Class URI:  "+classUri);
			detail("direct   :  "+direct);
			detail("Result   :  "+result.size());
		}
	}
	
	/**
	 * Get subclasses of a given class (WS)
	 * @param classUri
	 * @param direct
	 * @return List of OntClass
	 */
	public ArrayList getSubClasses(String classUri,boolean direct) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			//Resource r = getModel().getResource(classUri);
			//OntClass cls = (OntClass) r.as( OntClass.class );
			OntClass cls = getModel().getOntClass(classUri);
			if (cls == null) {
				return result;
			}
			ExtendedIterator subclasses = cls.listSubClasses(direct);
			while (subclasses.hasNext()) {
				Resource res = (Resource)subclasses.next();
				if (res instanceof OntClass) {
					OntClass subcls = (OntClass)res.as(OntClass.class);
					if (!classUri.equals(subcls.getURI())) {
						result.add(subcls);
					}
				}
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getSubClasses() "+crono.elapsed()+" ms");
			detail("Class URI:  "+classUri);
			detail("direct   :  "+direct);
			detail("Result   :  "+result.size());
		}
	}


	/**
	 * Get superproperties of a given property (WS)
	 * @param classUri
	 * @param direct
	 * @return List of OntProperty
	 */
	public ArrayList getSuperProperties(String propertyUri,boolean direct) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			OntProperty property = getModel().getOntProperty(propertyUri);
			if (property == null) {
				return result;
			}
			ExtendedIterator superprops = property.listSuperProperties(direct);
			while (superprops.hasNext()) {
				Resource res = (Resource)superprops.next();
				if (res instanceof OntProperty) {
					OntProperty supprop = (OntProperty)res.as(OntProperty.class);
					if (!propertyUri.equals(supprop.getURI())) {
						result.add(supprop);
					}
				}
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getSuperProperties() "+crono.elapsed()+" ms");
			detail("Property URI:  "+propertyUri);
			detail("direct      :  "+direct);
			detail("Result      :  "+result.size());
		}
	}

	
	/**
	 * Get subproperties of a given property (WS)
	 * @param classUri
	 * @param direct
	 * @return List of OntProperty
	 */
	public ArrayList getSubProperties(String propertyUri,boolean direct) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			OntProperty property = getModel().getOntProperty(propertyUri);
			if (property == null) {
				return result;
			}
			ExtendedIterator subprops = property.listSubProperties(direct);
			while (subprops.hasNext()) {
				Resource res = (Resource)subprops.next();
				if (res instanceof OntProperty) {
					OntProperty subprop = (OntProperty)res.as(OntProperty.class);
					if (!propertyUri.equals(subprop.getURI())) {
						result.add(subprop);
					}
				}
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getSuperProperties() "+crono.elapsed()+" ms");
			detail("Property URI:  "+propertyUri);
			detail("direct      :  "+direct);
			detail("Result      :  "+result.size());
		}
	}

	
	/**
	 * Get all object properties of a given class (WS)
	 * @param classUri
	 * @return List of ObjectProperty
	 */
	public ArrayList getObjectProperties(String classUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			//Resource r = getModel().getResource(classUri);
			//OntClass cls = (OntClass) r.as( OntClass.class );
			OntClass cls = getModel().getOntClass(classUri);
			if (cls == null) {
				return result;
			}
					
			ExtendedIterator objprops = getModel().listObjectProperties();
			while (objprops.hasNext()) {
				ObjectProperty op = (ObjectProperty)objprops.next();
				if (OntologyUtilities.isInDomain(getModel(),cls, op,true)) {
					result.add(op);
				}
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getClassObjectProperties() "+crono.elapsed()+" ms");
			detail("Class URI   :  "+classUri);
			detail("Result      :  "+result.size());
		}
	}
	
	/**
	 * Get all datatype properties of a given class (WS)
	 * @param classUri
	 * @return List of DatatypeProperty
	 */
	public ArrayList getDatatypeProperties(String classUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			//Resource r = getModel().getResource(classUri);
			//OntClass cls = (OntClass) r.as( OntClass.class );
			OntClass cls = getModel().getOntClass(classUri);
			if (cls == null) {
				return result;
			}

					
			ExtendedIterator dataprops = getModel().listDatatypeProperties();
			while (dataprops.hasNext()) {
				DatatypeProperty dp = (DatatypeProperty)dataprops.next();
				if (OntologyUtilities.isInDomain(getModel(),cls, dp,true)) {
					result.add(dp);
				}
			}
			return result;
		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getClassDatatypeProperties() "+crono.elapsed()+" ms");
			detail("Class URI   :  "+classUri);
			detail("Result      :  "+result.size());
		}
	}
	
	/**
	 * Get the range of a given property (WS)
	 * @param propertyUri
	 * @return List of OntResource
	 */
	public ArrayList getPropertyRange(String propertyUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			OntProperty prop = getModel().getOntProperty(propertyUri);
			if (prop == null) {
				return result;
			}
						
			ExtendedIterator rangeIt = prop.listRange();
			while (rangeIt.hasNext()) {
				result.add(rangeIt.next());
			}
			ArrayList superprops = getSuperProperties(propertyUri,false);
			for (int i = 0;i < superprops.size();i++) {
				OntProperty sp = (OntProperty)superprops.get(i);
				rangeIt = sp.listRange();
				while (rangeIt.hasNext()) {
					result.add(rangeIt.next());
				}				
			}
			
			return result;

		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getPropertyRange() "+crono.elapsed()+" ms");
			detail("Property URI:  "+propertyUri);
			detail("Result      :  "+result.size());
		}
	}
	
	/**
	 * Get equivalent classes to a given one
	 * @param classUri
	 * @return List of OntClass
	 */
	public ArrayList getEquivalentClasses(String classUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {			
			OntClass cls = getModel().getOntClass(classUri);
			if (cls == null) {
				return result;
			}
			
			ExtendedIterator equivIt = cls.listEquivalentClasses();			
			while (equivIt.hasNext()) {
				result.add(equivIt.next());
			}
			
			return result;

		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getEquivalentClasses() "+crono.elapsed()+" ms");
			detail("Class URI   :  "+classUri);
			detail("Result      :  "+result.size());
		}

	}

	/**
	 * Get disjoint classes to a given one
	 * @param classUri
	 * @return List of OntClass
	 */
	public ArrayList getDisjointClasses(String classUri) {
		TdiChronometer crono = new TdiChronometer();
		crono.start();
		getModel().enterCriticalSection(Lock.READ);
		ArrayList result = new ArrayList();
		try {
			
			OntClass cls = getModel().getOntClass(classUri);
			if (cls == null) {
				return result;
			}
			
			ExtendedIterator disjointIt = cls.listDisjointWith();			
			while (disjointIt.hasNext()) {
				result.add(disjointIt.next());
			}
			
			return result;

		} finally {
			getModel().leaveCriticalSection();
			crono.pause();
			debug("getDisjointClasses() "+crono.elapsed()+" ms");
			detail("Class URI   :  "+classUri);
			detail("Result      :  "+result.size());
		}

	}
	
	public static void main(String[] args) {
		try {
			
			QualiPSoMetadataAPI model = new QualiPSoMetadataAPI();
			
			// getSuperClasses()
			ArrayList superClasses = model.getSuperClasses("http://www.qualipso.org/ontology/doc/qualipso_documentation#TextDocument",false);
			System.out.println("getSuperClasses() no direct -> "+superClasses.size()+ " " + superClasses);
			superClasses = model.getSuperClasses("http://www.qualipso.org/ontology/doc/qualipso_documentation#TextDocument",true);
			System.out.println("getSuperClasses() direct -> "+superClasses.size()+ " " + superClasses);

			// getSubClasses()
			ArrayList subClasses = model.getSubClasses("http://www.qualipso.org/ontology/doc/qualipso_documentation#Entity",false);
			System.out.println("getSubClasses() no direct -> "+subClasses.size()+ " " + subClasses);
			subClasses = model.getSubClasses("http://www.qualipso.org/ontology/doc/qualipso_documentation#Entity",true);
			System.out.println("getSubClasses() direct -> "+subClasses.size()+ " " + subClasses);

			// getSuperProperties()
			ArrayList superProps = model.getSuperProperties("http://www.qualipso.org/ontology/doc/qualipso_documentation#contributor",false);
			System.out.println("getSuperProperties() no direct -> "+superProps.size()+ " " + superProps);
			superProps = model.getSuperProperties("http://www.qualipso.org/ontology/doc/qualipso_documentation#contributor",true);
			System.out.println("getSuperProperties() direct -> "+superProps.size()+ " " + superProps);

			// getSubProperties()
			ArrayList subProps = model.getSubProperties("http://purl.org/dc/elements/1.1/contributor",false);
			System.out.println("getSubProperties() no direct -> "+subProps.size()+ " " + subProps);
			subProps = model.getSubProperties("http://purl.org/dc/elements/1.1/contributor",true);
			System.out.println("getSubProperties() direct -> "+subProps.size()+ " " + subProps);

			// getClassObjectProperties()
			ArrayList properties = model.getObjectProperties("http://www.qualipso.org/ontology/doc/qualipso_documentation#TextDocument");
			System.out.println("getClassObjectProperties() -> "+properties.size()+ " " + properties);
			
			// getClassObjectProperties()
			properties = model.getObjectProperties("http://www.qualipso.org/ontology/doc/qualipso_maillinglist#Mail");
			System.out.println("getClassObjectProperties() -> "+properties.size()+ " " + properties);

			// getClassDatatypeProperties()
			properties = model.getDatatypeProperties("http://www.qualipso.org/ontology/doc/qualipso_documentation#TextDocument");
			System.out.println("getClassDatatypeProperties() -> "+properties.size()+ " " + properties);

			// getClassDatatypeProperties()
			properties = model.getDatatypeProperties("http://xmlns.com/baetle/#Issue");
			System.out.println("getClassDatatypeProperties() -> "+properties.size()+ " " + properties);

			// getPropertyRange()
			ArrayList range = model.getPropertyRange("http://www.qualipso.org/ontology/doc/qualipso_documentation#contributor");
			System.out.println("getPropertyRange() -> "+range.size()+ " " + range);

			// getEquivalentClasses()
			ArrayList equiv = model.getEquivalentClasses("http://www.qualipso.org/ontology/doc/qualipso_documentation#TextDocument");
			System.out.println("getEquivalentClasses() -> "+equiv.size()+ " " + equiv);

			// getDisjointClasses()
			ArrayList disjoint = model.getDisjointClasses("http://rdfs.org/sioc/ns#Container");
			System.out.println("getDisjointClasses() -> "+disjoint.size()+ " " + disjoint);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
