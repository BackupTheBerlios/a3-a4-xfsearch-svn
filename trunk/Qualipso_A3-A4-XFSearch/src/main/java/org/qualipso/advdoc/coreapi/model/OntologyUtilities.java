package org.qualipso.advdoc.coreapi.model;

import java.util.ArrayList;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.ontology.UnionClass;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class OntologyUtilities {

	/**
	 * Get all superclasses of a given class
	 * @param model
	 * @param classUri
	 * @param direct
	 * @return List of OntClass
	 */
	public static ArrayList getSuperClasses(OntModel model,String classUri,boolean direct) {
		Resource r = model.getResource(classUri);
		OntClass cls = (OntClass) r.as( OntClass.class );
		ArrayList result = new ArrayList();
		ExtendedIterator superclasses = cls.listSuperClasses(direct);
		while (superclasses.hasNext()) {
			Resource res = (Resource)superclasses.next();
			if (res instanceof OntClass) {
				OntClass supcls = (OntClass)res.as(OntClass.class);
				result.add(supcls);
			}
		}
		return result;
	}

	/**
	 * Test if a property is in the domain of a given class
	 * @param model
	 * @param cls
	 * @param prop
	 * @param inSuperclasses
	 * @return
	 */
	public static boolean isInDomain(OntModel model,OntClass cls,OntProperty prop,boolean inSuperclasses) {
		ArrayList superclasses = null;
		if (inSuperclasses) {
			superclasses = getSuperClasses(model,cls.getURI(),false);
		} else {
			superclasses = new ArrayList();
		}
		ExtendedIterator domainIt = prop.listDomain();
		while (domainIt.hasNext()) {
			Object obj = domainIt.next();
			if (obj instanceof OntClass) {
				OntClass res = (OntClass)obj;
				// Check the domain in class and superclasses
				if (prop.hasDomain(cls)) {
					return true;
				} else {
					if (inSuperclasses) {
						for (int i = 0;i < superclasses.size();i++) {
							OntClass superCls = (OntClass)superclasses.get(i);
							if (prop.hasDomain(superCls)) {
								return true;
							}
						}
					}
				}
				// Check union of domain
				if (res.isUnionClass()) {
					UnionClass union = res.asUnionClass();
					ExtendedIterator unionIt = union.listOperands();
					while (unionIt.hasNext()) {
						Object operand = unionIt.next();
						if (operand instanceof OntClass) {
							OntClass tc = (OntClass)operand;
							if (cls.getURI().equals(tc.getURI())) {
								return true;
							} else {
								if (inSuperclasses) {
									for (int i = 0;i < superclasses.size();i++) {
										OntClass superCls = (OntClass)superclasses.get(i);
										if (superCls != null && superCls.getURI() != null && superCls.getURI().equals(tc.getURI())) {
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	
}
