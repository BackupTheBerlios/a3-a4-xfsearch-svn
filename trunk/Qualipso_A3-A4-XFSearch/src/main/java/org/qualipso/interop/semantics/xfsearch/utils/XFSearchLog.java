package org.qualipso.interop.semantics.xfsearch.utils;

import java.io.File;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

/*******************************************************************************
 * Copyright (c) 2007 ATOS Origin SAE, 
 * All rights reserved. This software and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     @author Jesus Gorroñogoitia, jesus.gorronogoitia@atosresearch.eu ATOS Origin SAE -
 *     @author Jesus Martin, Origin SAE -
 *     
 *******************************************************************************/

/**
 * It provides log facilities for debugging
 */
public class XFSearchLog {
	private static Log log;

	/**
	 * To obtain the logger (l4J)
	 * @return 
	 */
	public static Log getLogger(){
		return getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
	
	/**
	 * It returns the log object
	 * @param classname Name of class requesting the log object
	 * @return Log object
	 */
	public static Log getLogger(String classname){
		if (log==null) {
		    configure (classname);
		}
		return log;
	}

	/**
	 * It configures the log system
	 * @param classname
	 */
	private static void configure (String classname){
		Properties log4j_properties = FileUtils.readProperties("log4j");
		PropertyConfigurator.configure(log4j_properties);
		log = LogFactory.getLog(classname);
	}


}
