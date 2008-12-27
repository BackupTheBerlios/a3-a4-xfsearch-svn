package org.qualipso.advdoc.coreapi.model;

public class PersistenceThread extends Thread {

	private int timeoutSecs;
	private boolean backup;
	private QualiPSoModel model;
	
	public PersistenceThread(QualiPSoModel model,int timeoutSecs,boolean backup) {
		setDaemon(true);
		this.model = model;
		this.backup = backup;
		this.timeoutSecs = timeoutSecs;
	}
	
	public void setTimeout(int timeout) {
		this.timeoutSecs = timeout;
	}
	
	public void run() {
		while (true) {
			try {
				sleep(this.timeoutSecs * 1000);
				execute();
			} catch (Exception e) {
				this.model.debug("PersistenceThread.run() "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	void execute() throws Exception {
		this.model.debug("PersistenceThread.run() Saving the model...");
		if (this.backup) {
			if (this.model.isModified()) {
				String file = this.model.saveBackup();
				this.model.debug("PersistenceThread.run() Backup model saved: "+file);
			}
		}
		if (this.model.isModified()) {
			String file = this.model.save();
			this.model.debug("PersistenceThread.run() Model saved: "+file);
		}
		if (!this.model.isModified()) {
			this.model.debug("PersistenceThread.run() No saved. Model was not modified");			
		}
	}
	
}
