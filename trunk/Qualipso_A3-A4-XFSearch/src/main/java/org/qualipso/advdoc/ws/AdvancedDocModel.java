package org.qualipso.advdoc.ws;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoFeedAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoMetadataAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoRetrievalAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoStorageAPI;
import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.coreapi.model.SingletonModel;

public class AdvancedDocModel {

	private static final String MODEL_ATTRIBUTE = "QualiPSo Model";

	public static QualiPSoStorageAPI getStorageAPI(ServletContext context) throws Exception {
		return getModel(context);
	}

	public static QualiPSoRetrievalAPI getRetrievalAPI(ServletContext context) throws Exception {
		return getModel(context);
	}

	public static QualiPSoFeedAPI getFeedAPI(ServletContext context) throws Exception {
		return getModel(context);
	}

	public static QualiPSoMetadataAPI getMetadataAPI(ServletContext context) throws Exception {
		return getModel(context);
	}

	public static QualiPSoTextSearchAPI getTextSearchAPI(ServletContext context) throws Exception {
		return getModel(context);
	}

	private static QualiPSoTextSearchAPI getModel(ServletContext context) throws Exception {
		Object obj = context.getAttribute(MODEL_ATTRIBUTE);
		if (obj == null) {
			QualiPSoTextSearchAPI model = new QualiPSoTextSearchAPI();
			SingletonModel.setModel(model);
			context.setAttribute(MODEL_ATTRIBUTE, model);
			obj = model;
		}
		return (QualiPSoTextSearchAPI)obj;
	}
	
}
