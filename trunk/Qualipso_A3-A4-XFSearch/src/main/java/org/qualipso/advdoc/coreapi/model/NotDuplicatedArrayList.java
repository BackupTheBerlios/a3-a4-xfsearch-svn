package org.qualipso.advdoc.coreapi.model;

import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.Resource;

class NotDuplicatedArrayList extends ArrayList {

	public boolean add(Object object) {
		if (object instanceof Resource) {
			Resource res1 = (Resource)object;
			for (int i = 0;i < size();i++) {
				Object obj = get(i);
				if (obj instanceof Resource) {
					Resource res2 = (Resource)obj;
					if (res2.getURI().equals(res1.getURI())) {
						return false;
					}
				}
			}
			super.add(object);
		} else {
			super.add(object);
		}
		return true;
	}
	
}
