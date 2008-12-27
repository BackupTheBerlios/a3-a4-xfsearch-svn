package org.qualipso.advdoc.ws.client.search.service;

import javax.servlet.ServletContext;

import org.qualipso.advdoc.coreapi.model.QualiPSoTextSearchAPI;
import org.qualipso.advdoc.ws.AdvancedDocModel;

public class QualiPSoSearchAPISoapController extends GenQualiPSoSearchAPISoapController {

	protected void frawaInit() throws Exception {
		System.out.println("Initializing QualiPSo...");
		ServletContext context = getServletContext();
		QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
		System.out.println("QualiPSo initialized OK");
    }
	
	protected void frawaDestroy() {
		System.out.println("Closing QualiPSo...");
		try {
			ServletContext context = getServletContext();
			QualiPSoTextSearchAPI model = AdvancedDocModel.getTextSearchAPI(context);
			System.out.println("    Saving the model...");
			model.save();
			System.out.println("    Model saved OK");
		} catch (Exception e) {
			System.out.println("EXCEPTION: "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("QualiPSo closed OK");
	}
    
}
