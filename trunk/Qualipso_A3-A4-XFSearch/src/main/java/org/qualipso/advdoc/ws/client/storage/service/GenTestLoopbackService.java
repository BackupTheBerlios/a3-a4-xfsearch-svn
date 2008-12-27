//4329151bf623abb233a10c1de1c67d8

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero : GenTestLoopbackService.java
// Proyecto : QualiPSoStorage
// Versi�n  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------


package org.qualipso.advdoc.ws.client.storage.service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.qualipso.advdoc.ws.client.storage.beans.TestLoopback;

/**
 * Clase base para la operaci�n TestLoopback : 
 * @author FRAWA
 * @version 1.0
 */
public abstract class GenTestLoopbackService extends es.tid.frawa.service.servlet.AbstractService {

    /**
     * M�todo que hay que implementar en la clase derivada
     * @param    __inbean    Par�metro de entrada a la operaci�n: 
     * @param    __outbean    Par�metro de salida de la operaci�n: 
     * @throws   Exception    Excepci�n producida en la ejecuci�n de la operaci�n en la clase hija
     */
    public abstract void execute(org.qualipso.advdoc.ws.client.storage.beans.TestLoopback __inbean,org.qualipso.advdoc.ws.client.storage.beans.TestLoopback __outbean) throws Exception;

    /**
     * M�todo que hay que implementar en la clase derivada
     * @param    __context    Contexto en el que se guardan datos internos relativos a la request
     * @param    servlet    El servlet que recibe la petici�n
     * @param    request    La petici�n HTTP
     * @param    response    La respuesta HTTP
     * @param    __inbean    
     * @param    __outbean    
     * @throws   Exception    Excepci�n elevada en esta rutina porque ocurre una excepci�n en la clase hija o bien en la creaci�n de una transacci�n
     */
    final Throwable executeImpl(HttpServlet servlet,HttpServletRequest request,HttpServletResponse response,org.qualipso.advdoc.ws.client.storage.beans.TestLoopback __inbean,org.qualipso.advdoc.ws.client.storage.beans.TestLoopback __outbean) {

        if (request.getAttribute("SOAP_Header") != null) {
            this.SOAPHeader = (tdi.xml.parser.TdiXmlNode)request.getAttribute("SOAP_Header");
        }

        this.request = request;
        this.response = response;
        this.servlet = servlet;


        try {

            // Invocar el m�todo execute() implementado en la clase derivada
            execute(__inbean,__outbean);


            // Todo ha ido bien
            return null;

        } catch (Throwable t) {



            Throwable returnedException = onException(t,__inbean);
            return returnedException;

        } finally {


        }

    }


    /**
     * Tratamiento de excepciones en la clase hija. Esta rutina es invocada cuando ocurre una excepci�n
     * @param    t    Excepci�n ocurrida en la operaci�n
     * @param    __inbean    Par�metro de entrada de la operaci�n
     * @return   P�gina a la que hay que redirigir
     */
    protected Throwable onException(Throwable t,org.qualipso.advdoc.ws.client.storage.beans.TestLoopback __inbean) {
        return t;   // Implementaci�n por defecto
    }

    protected tdi.xml.parser.TdiXmlNode getSOAPHeader() {
        return this.SOAPHeader;
    }

    protected HttpServletRequest getRequest() {
        return this.request;
    }

    protected HttpServletResponse getResponse() {
        return this.response;
    }

    protected HttpServlet getServlet() {
        return this.servlet;
    }

    private tdi.xml.parser.TdiXmlNode SOAPHeader = null;
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private HttpServlet servlet = null;


}
