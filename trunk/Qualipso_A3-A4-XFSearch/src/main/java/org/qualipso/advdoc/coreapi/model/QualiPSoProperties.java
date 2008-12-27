package org.qualipso.advdoc.coreapi.model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * QualiPSo properties reader
 * @author quiles
 *
 */
public class QualiPSoProperties {

	private static final String PropBase = "org.qualipso.advdoc";

	private Properties properties;
	
	private String RDFFile;
	
	private boolean debug = false;
	
	private boolean detail = false;
	
	private String indexesDirectory;
	
	private String storageDirectory;
	
	private int persistenceTimeout = 0;
	
	private boolean persistenceBackup = false;
	
	private int reindexTimeout = 0;
	
	private String inference = "OWL_DL_MEM_RDFS_INF";
	
	public QualiPSoProperties(String filename) throws Exception {
		
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
		
		RDFFile = properties.getProperty(PropBase+".rdf.file",null);

		indexesDirectory = properties.getProperty(PropBase+".lucene.indexes.dir",".");
		
		String debugStr = properties.getProperty(PropBase+".debug.activate","false");
		debug = debugStr.equalsIgnoreCase("true");

		String detailStr = properties.getProperty(PropBase+".detail.activate","false");
		detail = detailStr.equalsIgnoreCase("true");

		storageDirectory = properties.getProperty(PropBase+".storage.dir",".");
		
		persistenceTimeout = Integer.parseInt(properties.getProperty(PropBase+".persistence.timeout", "0"));

		String backupStr = properties.getProperty(PropBase+".persistence.backup","false");
		persistenceBackup = backupStr.equalsIgnoreCase("true");

		reindexTimeout = Integer.parseInt(properties.getProperty(PropBase+".lucene.reindex.timeout", "0"));
		
		inference = properties.getProperty(PropBase+".model.inference","OWL_DL_MEM_RDFS_INF");

	}
	
	public String getInference() {
		return this.inference;
	}
	
	public String getRDFFile() {
		return this.RDFFile;
	}
	
	public boolean isDebug() {
		return this.debug;
	}

	public boolean isDetail() {
		return this.detail;
	}

	public String getIndexesDir() {
		return this.indexesDirectory;
	}
	
	public String getStorageDir() {
		return this.storageDirectory;
	}
	
	public int getPersistenceTimeout() {
		return this.persistenceTimeout;
	}
	
	public boolean isPersistenceBackup() {
		return this.persistenceBackup;
	}
	
	public int getReindexTimeout() {
		return this.reindexTimeout;
	}


}
