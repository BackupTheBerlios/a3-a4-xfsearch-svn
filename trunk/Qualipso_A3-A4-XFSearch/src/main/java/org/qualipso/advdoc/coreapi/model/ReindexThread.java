package org.qualipso.advdoc.coreapi.model;

public class ReindexThread extends Thread {

	private int timeoutSecs;
	private QualiPSoTextSearchAPI model;
	
	public ReindexThread(QualiPSoTextSearchAPI model,int timeoutSecs) {
		setDaemon(true);
		this.model = model;
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
				this.model.debug("ReindexThread.run() "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	void execute() throws Exception {
		this.model.debug("ReindexThread.run() Reindexing...");
		if (this.model.isReindexNeeded()) {
			this.model.reindex();
			this.model.debug("ReindexThread.run() Reindex finished");		
		} else {
			this.model.debug("ReindexThread.run() No reindex. The model was not modified.");
		}
	}

}
