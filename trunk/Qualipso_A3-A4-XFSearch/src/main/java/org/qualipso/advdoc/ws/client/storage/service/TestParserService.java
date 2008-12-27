//ac8cd5a2d337df6871e364180b645e1

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : TestParserService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.qualipso.advdoc.ws.client.storage.beans.TestParser;

/**
 * Implementación de la operación TestParser : 
 * @author FRAWA
 * @version 1.0
 */
public class TestParserService extends GenTestParserService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(org.qualipso.advdoc.ws.client.storage.beans.TestParser __inbean,org.qualipso.advdoc.ws.client.storage.beans.TestParser __outbean) throws Exception {
    	__outbean.set(__inbean);
    	int numIter = __inbean.getNumIterations();
    	
    	if (numIter <= 0) {
    		return;
    	}
    	
    	String parse = "";
    	
    	// SOAP serialization
    	TestParser serialBean = new TestParser();
    	serialBean.set(__inbean);
    	long start = System.currentTimeMillis();
    	for (int i = 0;i < numIter;i++) {
    		parse = serialBean.toSOAP();
    	}
    	long end = System.currentTimeMillis();
    	long total = end - start;
    	double iterTime = (double)total / (double)numIter;
    	System.out.println("SOAP serialization total time:"+total+" per iter "+iterTime);
    	__outbean.setSoapSerialTime((int)iterTime);

    	// SOAP deserialization
    	parse = "<TestParser>"+parse+"</TestParser>";
    	TestParser deserialBean = new TestParser();
    	start = System.currentTimeMillis();
    	for (int i = 0;i < numIter;i++) {
    		deserialBean.fromSOAP(new StringReader(parse));
    	}
    	end = System.currentTimeMillis();
    	total = end - start;
    	iterTime = (double)total / (double)numIter;
    	//System.out.println(deserialBean.toString());
    	System.out.println("SOAP deserialization total time:"+total+" per iter "+iterTime);
    	__outbean.setSoapDeserialTime((int)iterTime);

    	// JSON serialization
    	serialBean = new TestParser();
    	serialBean.set(__inbean);
    	start = System.currentTimeMillis();
    	for (int i = 0;i < numIter;i++) {
    		parse = serialBean.toJSON(false);
    	}
    	end = System.currentTimeMillis();
    	total = end - start;
    	iterTime = (double)total / (double)numIter;
    	System.out.println("JSON serialization total time:"+total+" per iter "+iterTime);
    	__outbean.setJsonSerialTime((int)iterTime);

    	// JSON deserialization
    	deserialBean = new TestParser();
    	start = System.currentTimeMillis();
    	for (int i = 0;i < numIter;i++) {
    		deserialBean.fromJSON(parse);
    	}
    	end = System.currentTimeMillis();
    	total = end - start;
    	iterTime = (double)total / (double)numIter;
    	System.out.println("JSON deserialization total time:"+total+" per iter "+iterTime);
    	__outbean.setJsonDeserialTime((int)iterTime);

    }


}
