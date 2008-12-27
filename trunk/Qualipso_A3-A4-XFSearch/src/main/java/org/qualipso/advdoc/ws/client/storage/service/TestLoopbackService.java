//d3b3226fb21ec657495748b566467776

/* 1.0 */

//-----------------------------------------------------------------
// Fichero : TestLoopbackService.java
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.qualipso.advdoc.ws.client.storage.beans.TestLoopback;

/**
 * Implementación de la operación TestLoopback : 
 * @author FRAWA
 * @version 1.0
 */
public class TestLoopbackService extends GenTestLoopbackService {

    /**
     * Implementación de la operación
     * @param    __inbean    Parámetro de entrada a la operación: 
     * @param    __outbean    Parámetro de salida de la operación: 
     * @throws   Exception    Excepción producida en la ejecución de la operación en la clase hija
     */
    public void execute(org.qualipso.advdoc.ws.client.storage.beans.TestLoopback __inbean,org.qualipso.advdoc.ws.client.storage.beans.TestLoopback __outbean) throws Exception {
    	__outbean.set(__inbean);
    	__outbean.setServerTime((int)System.currentTimeMillis());
    }


}
