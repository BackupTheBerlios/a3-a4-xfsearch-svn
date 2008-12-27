package org.qualipso.advdoc.coreapi.model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * Ontologies properties reader
 * @author quiles
 *
 */
public class OntologyProperties {
	
	private static final String PropBase = "org.qualipso.advdoc.ontologies";

	private Properties properties;
	
	private ArrayList ontologies;
	
	public OntologyProperties(String filename) throws Exception {
		
		properties = new Properties();
		
		// Load properties from disk or resource
		try {
			FileInputStream fis = new FileInputStream(filename);
			properties.load(fis);
			fis.close();
		} catch (Exception e) {
            InputStream is = getClass().getResourceAsStream(filename);
            properties.load(is);
            is.close();
		}
		
		// Get ontologies list
		String ontologiesList = properties.getProperty(PropBase,"");
		
		// Parse ontologies list and create ontology beans
		ontologies = new ArrayList();
		StringTokenizer st = new StringTokenizer(ontologiesList,",");
		while (st.hasMoreTokens()) {
			String name = st.nextToken();
			OntologyBean bean = new OntologyBean();
			bean.setName(name);
			String fn = properties.getProperty(PropBase+"."+name+".file",null);
			bean.setFilename(fn);
			String prefix = properties.getProperty(PropBase+"."+name+".prefix",null);
			bean.setPrefix(prefix);
			String url = properties.getProperty(PropBase+"."+name+".url",null);
			bean.setUrl(url);
			String javaclass = properties.getProperty(PropBase+"."+name+".javaclass",null);
			bean.setJavaClass(javaclass);
			ontologies.add(bean);
		}
		
	}
	
	public Properties getProperties() {
		return this.properties;
	}
	
	public ArrayList getOntologies() {
		return this.ontologies;
	}
	
	public OntologyBean getOntology(String name) {
		for (int i = 0;i < ontologies.size();i++) {
			OntologyBean bean = (OntologyBean)ontologies.get(i);
			if (bean.getName().equalsIgnoreCase(name)) {
				return bean;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		try {
			OntologyProperties op = new OntologyProperties("properties/ontologies.properties");
			Properties props = op.getProperties();
			props.list(System.out);
			ArrayList ontologies = op.getOntologies();
			for (int i = 0;i < ontologies.size();i++) {
				System.out.println(ontologies.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
