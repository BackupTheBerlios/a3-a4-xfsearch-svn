package org.qualipso.advdoc.coreapi.ontology;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.shared.PrefixMapping;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class ShowSchema {

	public static String SchemaFile = "file:ontology/dcelements.rdf";
	//public static String SchemaFile = "file:ontology/dcterms.rdf";
	//public static String SchemaFile = "file:ontology/dctype.rdf";
	//public static String SchemaFile = "file:ontology/dcam.rdf";


	public static String OutputFile = "ontology/txt/dcelements.txt";
	//public static String OutputFile = "ontology/txt/dcterms.txt";
	//public static String OutputFile = "ontology/txt/dctype.txt";
	//public static String OutputFile = "ontology/txt/dcam.txt";
	
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream(OutputFile);
			PrintStream ps = new PrintStream(fos);
			ShowSchema reporter = new ShowSchema(ps,SchemaFile);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private OntModel model;
	private PrintStream out;
	
	public ShowSchema(PrintStream out,String schema) {

		this.out = out;
		
		// Create an empty model
		this.model = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);
		
		// Load the schema
		model.read(schema);

		// Classes in the model
		ExtendedIterator clss = model.listSubjectsWithProperty(RDF.type,RDFS.Class);
		while (clss.hasNext()) {
			Resource res = (Resource)clss.next();
			out.println("--------------------------------------------------------------------");
			describeClass(res);
		}

		// Properties in the model
		ExtendedIterator props = model.listSubjectsWithProperty(RDF.type,RDF.Property);
		while (props.hasNext()) {
			Resource res = (Resource)props.next();
			out.println("--------------------------------------------------------------------");
			describeProperty(res);
		}

	}

	private void describeClass(Resource cls) {
		
		out.println("Class: "+renderURI(cls));
		
        // all super-classes
		showSuperClasses(cls);
				
		// Properties
		showProperties(cls);
		
	}

	private void describeProperty(Resource prop) {

		out.println("Property: "+renderURI(prop));

        // all super-properties
		showSuperProperties(prop);
		
		// Domain
		showDomain(prop);
		
		// Range
		showRange(prop);

	}
	
	private void showDomain(Resource prop) {
		try {
			StmtIterator domains = prop.listProperties(RDFS.domain);
			while (domains.hasNext()) {
				Statement stmt = domains.nextStatement();
				out.println("    domain "+renderURI((Resource)stmt.getObject().as(Resource.class)));
			}
		} catch (Exception e) {
			// ignore
		}

	}

	private void showRange(Resource prop) {
		try {
			StmtIterator ranges = prop.listProperties(RDFS.range);
			while (ranges.hasNext()) {
				Statement stmt = ranges.nextStatement();
				out.println("    range "+renderURI((Resource)stmt.getObject().as(Resource.class)));
			}
		} catch (Exception e) {
			// ignore
		}
	}

	
	private void showSuperProperties(Resource prop) {
		try {
			StmtIterator supers = prop.listProperties(RDFS.subPropertyOf);
			while (supers.hasNext()) {
				Statement stmt = supers.nextStatement();
				out.println("    subproperty of "+renderURI((Resource)stmt.getObject().as(Resource.class)));
			}
		} catch (Exception e) {
			// ignore
		}

	}
	
	
	private void showSuperClasses(Resource cls) {
		try {
			StmtIterator supers = cls.listProperties(RDFS.subClassOf);
			while (supers.hasNext()) {
				Statement stmt = supers.nextStatement();
				out.println("    subclass of "+renderURI((Resource)stmt.getObject().as(Resource.class)));
			}
		} catch (Exception e) {
			// ignore
		}
	}
	
	private void showProperties(Resource cls) {
		
		// Direct Object Properties
		ArrayList props = getDirectProperties(cls);
		if (props.size() > 0) {
			out.println("    properties:");
		}
		for (int i = 0;i < props.size();i++) {
			out.println("        "+renderURI((Resource)props.get(i)));
		}		
		
	}

	
	private ArrayList getDirectProperties(Resource cls) {

		ArrayList result = new ArrayList();
		
		ExtendedIterator props = model.listSubjectsWithProperty(RDF.type,RDF.Property);
		while (props.hasNext()) {
			Resource res = (Resource)props.next();
			StmtIterator domains = res.listProperties(RDFS.domain);
			while (domains.hasNext()) {
				Statement stmt = domains.nextStatement();
				if (stmt.getObject().toString().equals(cls.toString())) {
					result.add(stmt.getSubject());
				}
			}

		}

		return result;
	}
	
    protected String renderURI(Resource res) {
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
