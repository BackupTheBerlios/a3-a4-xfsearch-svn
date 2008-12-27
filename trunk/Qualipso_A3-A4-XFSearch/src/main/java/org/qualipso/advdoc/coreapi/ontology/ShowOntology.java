package org.qualipso.advdoc.coreapi.ontology;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.shared.PrefixMapping;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

/**
 * Show the classes and properties that compose an ontology
 * @author quiles
 * @version 1.0
 *
 */
public class ShowOntology {

	/**
	 * Ontology URL
	 */
	//public static String OntologyFile = "file:ontology/foaf.rdf";
	//public static String OntologyFile = "file:ontology/doap.rdf";
	//public static String OntologyFile = "file:ontology/sioc.rdf";
	//public static String OntologyFile = "file:ontology/baetle.rdf";
	//public static String OntologyFile = "file:ontology/qualipso_source_code.owl";
	public static String OntologyFile = "file:ontology/qualipso_documentation.owl";

	/**
	 * Text output file
	 */
	//public static String OutputFile = "ontology/txt/foaf.txt";
	//public static String OutputFile = "ontology/txt/doap.txt";
	//public static String OutputFile = "ontology/txt/sioc.txt";
	//public static String OutputFile = "ontology/txt/baetle.txt";
	//public static String OutputFile = "ontology/txt/qualipso_source_code.txt";
	public static String OutputFile = "ontology/txt/qualipso_documentation.txt";

	/**
	 * Ontology Jena model
	 */
	private OntModel model;
	
	/**
	 * Output stream for report
	 */
	private PrintStream out;
	

	
	/**
	 * Main program
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream(OutputFile);
			PrintStream ps = new PrintStream(fos);
			ShowOntology reporter = new ShowOntology(ps,OntologyFile);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Class constructor
	 * @param out
	 * @param ontology
	 */
	public ShowOntology(PrintStream out,String ontology) {

		this.out = out;
		
		// Create an empty model
		this.model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		
		// Load the ontology
		model.read(ontology);

		// Classes in the model
		ExtendedIterator clss = model.listClasses();
		while (clss.hasNext()) {
			out.println("--------------------------------------------------------------------");
            describeClass((OntClass) clss.next());
        }
		
		// Object Properties in the model
		ExtendedIterator objprops = model.listObjectProperties();
		while (objprops.hasNext()) {
			out.println("--------------------------------------------------------------------");
			describeObjectProperty((ObjectProperty)objprops.next());
		}

		// Datatype Properties in the model
		ExtendedIterator dataprops = model.listDatatypeProperties();
		while (dataprops.hasNext()) {
			out.println("--------------------------------------------------------------------");
			describeDatatypeProperty((DatatypeProperty)dataprops.next());
		}

	}

	/**
	 * Describe a class, superclasses, equivalent classes, disjoint classes and properties 
	 * @param cls
	 */
	private void describeClass(OntClass cls) {
		
		out.println("Class: "+renderURI(cls));
		
        // all super-classes
		showSuperClasses(cls);
		
		// Equivalent classes
		showEquivalentClasses(cls);
		
		// Disjoint classes
		showDisjointClasses(cls);
		
		// Properties
		showProperties(cls);
		
	}

	/**
	 * Describe an object property, super properties, equivalent properties, domain and range
	 * @param prop
	 */
	private void describeObjectProperty(ObjectProperty prop) {
		
		String isSimmetric = prop.isSymmetricProperty() ? " SIMMETRIC " : "";
		String isTransitive = prop.isTransitiveProperty() ? " TRANSITIVE " : "";
		String isFunctional = prop.isFunctionalProperty() ? " FUNCTIONAL " : "";
		String isInverseFunctional = prop.isInverseFunctionalProperty() ? " INVERSE-FUNCTIONAL " : "";
		
		out.println("Object Property: "+renderURI(prop)+ " - " + isSimmetric + isTransitive + isFunctional + isInverseFunctional);

        // all super-properties
		showSuperProperties(prop);
		
		// Equivalent properties
		showEquivalentProperties(prop);
				
		// Domain
		showDomain(prop);
		
		// Range
		showRange(prop);

	}
	
	/**
	 * Describe an datatype property, super properties, equivalent properties, domain and range
	 * @param prop
	 */
	private void describeDatatypeProperty(DatatypeProperty prop) {
		
		String isSimmetric = prop.isSymmetricProperty() ? " SIMMETRIC " : "";
		String isTransitive = prop.isTransitiveProperty() ? " TRANSITIVE " : "";
		String isFunctional = prop.isFunctionalProperty() ? " FUNCTIONAL " : "";
		String isInverseFunctional = prop.isInverseFunctionalProperty() ? " INVERSE-FUNCTIONAL " : "";
		
		out.println("Datatype Property: "+renderURI(prop)+ " - " + isSimmetric + isTransitive + isFunctional + isInverseFunctional);

		// all super-properties
		showSuperProperties(prop);
		
		// Equivalent properties
		showEquivalentProperties(prop);
				
		// Domain
		showDomain(prop);
		
		// Range
		showRange(prop);

	}
	
	/**
	 * Show the equivalent classes of a given class
	 * @param cls
	 */
	private void showEquivalentClasses(OntClass cls) {
		ExtendedIterator equivs = cls.listEquivalentClasses();
		while (equivs.hasNext()) {
			Resource res = (Resource)equivs.next();
			out.println("    equivalent to "+renderURI(res));
		}
	}

	/**
	 * Show the disjoint classes of a given class
	 * @param cls
	 */
	private void showDisjointClasses(OntClass cls) {
		ExtendedIterator disjoints = cls.listDisjointWith();
		while (disjoints.hasNext()) {
			Resource res = (Resource)disjoints.next();
			out.println("    disjoint from "+renderURI(res));
		}
	}
	
	/**
	 * Show the equivalent properties of a given property
	 * @param prop
	 */
	private void showEquivalentProperties(OntProperty prop) {
		ExtendedIterator equivs = prop.listEquivalentProperties();
		while (equivs.hasNext()) {
			Resource res = (Resource)equivs.next();
			out.println("    equivalent to "+renderURI(res));
		}
	}

	/**
	 * Show the domain of a given property
	 * @param prop
	 */
	private void showDomain(OntProperty prop) {
		ExtendedIterator domain = prop.listDomain();
		while (domain.hasNext()) {
			Resource res = (Resource)domain.next();
			out.println("    domain "+renderURI(res));
		}
	}

	/**
	 * Show the range of a given property
	 * @param prop
	 */
	private void showRange(OntProperty prop) {
		ExtendedIterator range = prop.listRange();
		while (range.hasNext()) {
			Resource res = (Resource)range.next();
			out.println("    range "+renderURI(res));
		}
	}

	/**
	 * Show super properties of a given property
	 * @param prop
	 */
	private void showSuperProperties(OntProperty prop) {
		ExtendedIterator superprops = prop.listSuperProperties(false);
		try {
			while (superprops.hasNext()) {
				Resource res = (Resource)superprops.next();
				out.println("    subproperty of "+renderURI(res));
			}
		} catch (Exception e) {
			// ignore
		}
	}
	
	/**
	 * Show super classes of a given class
	 * @param cls
	 */
	private void showSuperClasses(OntClass cls) {
		try {
			ExtendedIterator superclasses = cls.listSuperClasses(false);
			while (superclasses.hasNext()) {
				Resource res = (Resource)superclasses.next();
				if (res instanceof OntClass) {
					OntClass supcls = (OntClass)res.as(OntClass.class);
					out.println("    subclass of "+renderURI(supcls));
				}
			}
		} catch (Exception e) {
			// ignore
		}
	}
	
	/**
	 * Show direct (not inherited) properties of a given class (object and datatype)
	 * @param cls
	 */
	private void showProperties(OntClass cls) {
		
		// Direct Object Properties
		ArrayList objprops = getObjectProperties(cls);
		if (objprops.size() > 0) {
			out.println("    object properties:");
		}
		for (int i = 0;i < objprops.size();i++) {
			ObjectProperty op = (ObjectProperty)objprops.get(i);
			out.println("        "+renderURI(op)+" ("+renderURI(op.getRange())+(op.isFunctionalProperty()?"":"*")+")");
		}

		// Direct Datatype Properties
		ArrayList dataprops = getDatatypeProperties(cls);
		if (dataprops.size() > 0) {
			out.println("    datatype properties:");
		}
		for (int i = 0;i < dataprops.size();i++) {
			DatatypeProperty dp = (DatatypeProperty)dataprops.get(i);
			out.println("        "+renderURI(dp)+" ("+renderURI(dp.getRange())+(dp.isFunctionalProperty()?"":"*")+")");
		}
	}

	/**
	 * Return the direct object properties of a given class
	 * @param cls
	 * @return list of ObjectProperty
	 */
	private ArrayList getObjectProperties(OntClass cls) {

		ArrayList result = new ArrayList();
		
		// Get all ObjectProperties and check the domain
		ExtendedIterator objprops = model.listObjectProperties();
		while (objprops.hasNext()) {
			ObjectProperty op = (ObjectProperty)objprops.next();
			if (op.hasDomain(cls)) {
				result.add(op);
			}
		}

		return result;
	}

	/**
	 * Return the direct datatype properties of a given class
	 * @param cls
	 * @return list of ObjectProperty
	 */
	private ArrayList getDatatypeProperties(OntClass cls) {

		ArrayList result = new ArrayList();
		
		// Get all DatatypeProperties and check the domain
		ExtendedIterator dataprops = model.listDatatypeProperties();
		while (dataprops.hasNext()) {
			DatatypeProperty op = (DatatypeProperty)dataprops.next();
			if (op.hasDomain(cls)) {
				result.add(op);
			}
		}

		return result;
	}
	
	/**
	 * Return an URI with namespace prefix (if exists)
	 * @param res
	 * @return the URI with namespace prefix
	 */
    private String renderURI(Resource res) {
    	try {
	    	PrefixMapping prefixes = res.getModel().getGraph().getPrefixMapping();
	        return prefixes.shortForm(res.getURI());
    	} catch (Exception e) {
    		if (res != null) {
    			return res.getURI();
    		} else {
    			return "";
    		}
    	}
    }


}
