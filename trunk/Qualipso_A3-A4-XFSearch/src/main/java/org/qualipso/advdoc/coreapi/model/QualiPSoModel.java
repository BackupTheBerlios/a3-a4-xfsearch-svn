package org.qualipso.advdoc.coreapi.model;

import java.io.FileOutputStream;
import java.util.ArrayList;

import tdi.time.TdiChronometer;
import tdi.time.TdiQuickInstant;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.shared.Lock;

/**
 * QualiPSo model
 * @author quiles
 *
 */
public class QualiPSoModel {

	/**
	 * Jena model
	 */
	private OntModel model;
	
	/**
	 * Ontologies list
	 */
	protected OntologyProperties ontologies;
	
	/**
	 * QualiPSo configuration properties
	 */
	protected QualiPSoProperties configuration;
	
	/**
	 * Debug messages to console
	 */
	private boolean debug; 
	
	/**
	 * Detail messages to console
	 */
	private boolean detail;
	
	/**
	 * Persistence thread. It saves the model to disk periodically
	 */
	private PersistenceThread persistence;
	
	/**
	 * Model modified flag
	 */
	private boolean modified = false;
	
	/**
	 * Constructor
	 * @throws Exception
	 */
	public QualiPSoModel() throws Exception {
		
		// Read QualiPSo configuration
		System.out.println("Reading QualiPSo configuration...");
		this.configuration = new QualiPSoProperties(QualiPSoConstants.QualiPSoPropertyFile);
		System.out.println("OK");
		
		// Create an empty model
		System.out.println("Creating JENA model ("+configuration.getInference()+")...");
		if (this.configuration.getInference().equalsIgnoreCase("OWL_DL_MEM_RULE_INF")) {
			this.model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF);
		} else {
			this.model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RDFS_INF);
		}
		System.out.println("OK");
		
		// Read ontology properties
		System.out.println("Reading ontology properties...");
		this.ontologies = new OntologyProperties(QualiPSoConstants.OntologiesPropertyFile);
		System.out.println("OK");		

		this.debug = configuration.isDebug();
		
		this.detail = configuration.isDetail();
		
		// Namespace prefixes
		ArrayList onts = this.ontologies.getOntologies();
		for (int i = 0;i < onts.size();i++) {
			OntologyBean bean = (OntologyBean)onts.get(i);
			this.model.setNsPrefix(bean.getPrefix(), bean.getUrl());
		}

		// Read RDF data
		TdiChronometer crono = new TdiChronometer();
		debug("Reading RDF data from "+"file:"+configuration.getRDFFile()+"...");
		crono.start();
		model.read("file:"+configuration.getRDFFile());
		crono.pause();
		debug("RDF data read. "+crono.elapsed()+ " ms");

		// Load ontologies
		for (int i = 0;i < onts.size();i++) {
			OntologyBean bean = (OntologyBean)onts.get(i);
			crono = new TdiChronometer();
			debug("Reading ontology "+bean.getName());
			crono.start();
			this.model.getDocumentManager().loadImport(this.model,"file:"+bean.getFilename());
			crono.pause();
			debug("Ontology "+bean.getName()+" read. "+crono.elapsed()+" ms");
		}
		
		// Persistence Thread
		if (configuration.getPersistenceTimeout() > 0) {
			debug("Starting persistence thread at "+configuration.getPersistenceTimeout()+" seconds...");
			this.persistence = new PersistenceThread(this,configuration.getPersistenceTimeout(),configuration.isPersistenceBackup());
			this.persistence.start();
		}
		
	}
	
	/**
	 * Save the model to disk
	 * @param filename
	 * @throws Exception
	 */
	public void save(String filename) throws Exception {
		model.enterCriticalSection(Lock.WRITE);
		try {
			debug("Saving repository in "+filename+"...");
			TdiChronometer crono = new TdiChronometer();
			crono.start();
			FileOutputStream fos = new FileOutputStream(filename);			
			model.write(fos);
			fos.close();
			crono.pause();
			debug("Saved "+filename+" in "+crono.elapsed()+" ms");
		} finally {
			model.leaveCriticalSection();
		}
	}
	
	/**
	 * Save the model to disk (it uses the estandar filename)
	 * @return the filename
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.save(configuration.getRDFFile());
		this.modified = false;
		return configuration.getRDFFile();
	}

	/**
	 * Save a backup model to disk (it uses the standard filename and the current date/time)
	 * @return the filename
	 * @throws Exception
	 */
	public String saveBackup() throws Exception {
		String backupFilename = configuration.getRDFFile() + "." + new TdiQuickInstant().toISO8601()+".bak";
		this.save(backupFilename);
		return backupFilename;
	}
	
	/**
	 * Model modified flag
	 * @return
	 */
	public boolean isModified() {
		return this.modified;
	}
	
	void setModified() {
		this.modified = true;
	}
	
	public OntModel getModel() {
		return this.model;
	}
	
	protected void debug(String message) {
		if (this.debug) {
			String date = new TdiQuickInstant().toISO8601();
			System.out.println();
			System.out.println(date + ": " + message);
		}
	}

	protected void detail(String message) {
		if (this.detail) {
			System.out.println("    > "+message);
		}
	}

	public static void main(String[] args) {
		try {
			QualiPSoModel model = new QualiPSoModel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
