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
 * Implementaci�n de la operaci�n TestLoopback : 
 * @author FRAWA
 * @version 1.0
 */
public class TestLoopbackService extends GenTestLoopbackService {

    /**
     * Implementaci�n de la operaci�n
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public void execute(org.qualipso.advdoc.ws.client.storage.beans.TestLoopback __inbean,org.qualipso.advdoc.ws.client.storage.beans.TestLoopback __outbean) throws Exception {
    	__outbean.set(__inbean);
    	__outbean.setServerTime((int)System.currentTimeMillis());
    }


}
