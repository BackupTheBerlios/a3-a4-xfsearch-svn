package org.qualipso.advdoc.coreapi.model;

/**
 * Ontology config bean
 * @author quiles
 *
 */
public class OntologyBean {

	private String name;
	private String filename;
	private String prefix;
	private String javaClass;
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getJavaClass() {
		return javaClass;
	}
	public void setJavaClass(String javaClass) {
		this.javaClass = javaClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString() {
		return "Ontology " + getName() + ": [File:" + getFilename() + "] [URL:" + getUrl() + "] [Prefix:"+getPrefix()+"] [Java Class:" +getJavaClass()+"]";
	}
	
}
