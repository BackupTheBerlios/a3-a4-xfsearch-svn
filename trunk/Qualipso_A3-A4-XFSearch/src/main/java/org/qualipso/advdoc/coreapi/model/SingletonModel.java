package org.qualipso.advdoc.coreapi.model;

public class SingletonModel {
	
	private static QualiPSoTextSearchAPI theModel = null;
	
	public static synchronized QualiPSoTextSearchAPI getTextSearchModel() throws Exception {
		if (theModel == null) {
			theModel = new QualiPSoTextSearchAPI();
		}
		return theModel;
	}

	public static synchronized QualiPSoQueryAPI getQueryModel() throws Exception {
		if (theModel == null) {
			theModel = new QualiPSoTextSearchAPI();
		}
		return theModel;
	}

	public static synchronized QualiPSoMetadataAPI getMetadataModel() throws Exception {
		if (theModel == null) {
			theModel = new QualiPSoTextSearchAPI();
		}
		return theModel;
	}

	public static synchronized QualiPSoRetrievalAPI getRetrievalModel() throws Exception {
		if (theModel == null) {
			theModel = new QualiPSoTextSearchAPI();
		}
		return theModel;
	}

	public static synchronized QualiPSoFeedAPI getFeedModel() throws Exception {
		if (theModel == null) {
			theModel = new QualiPSoTextSearchAPI();
		}
		return theModel;
	}

	public static synchronized QualiPSoStorageAPI getStorageModel() throws Exception {
		if (theModel == null) {
			theModel = new QualiPSoTextSearchAPI();
		}
		return theModel;
	}

	public static synchronized void setModel(QualiPSoTextSearchAPI model) {
		theModel = model;
	}
}
