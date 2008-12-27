




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoSearchAPI
// Versión  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791






package org.qualipso.advdoc.ws.client.search.service;



import java.io.*;
import java.net.*;


import org.xml.sax.SAXException;


import tdi.xml.parser.TdiXmlNode;
import tdi.xml.parser.TdiXmlParser;
import es.tid.frawa.common.TdiSession;
import es.tid.frawa.service.servlet.SOAPUtils;
import es.tid.frawa.service.servlet.TdiServiceException;
import org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req;
import org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req;
import org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecAsk_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecAsk_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecQuery_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecSearch_resp;
import org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_req;
import org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_resp;
import org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_req;
import org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_resp;
import org.qualipso.advdoc.ws.client.search.beans.ReIndex_req;
import org.qualipso.advdoc.ws.client.search.beans.ReIndex_resp;

/**
 * Cliente SOAP para acceder al servicio QualiPSoSearchAPI
 * Operaciones del servicio:
 *     org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp BuildSPARQLQuery(org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req)
 *     org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp BuildSPARQLSearch(org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req)
 *     ExecAsk_resp ExecAsk(ExecAsk_req)
 *     ExecConstructAndSearch_resp ExecConstructAndSearch(ExecConstructAndSearch_req)
 *     ExecQuery_resp ExecQuery(ExecQuery_req)
 *     ExecSPARQL_resp ExecSPARQL(ExecSPARQL_req)
 *     ExecSearch_resp ExecSearch(ExecSearch_req)
 *     ExecSimpleTextSearch_resp ExecSimpleTextSearch(ExecSimpleTextSearch_req)
 *     GetSearchSize_resp GetSearchSize(GetSearchSize_req)
 *     ReIndex_resp ReIndex(ReIndex_req)
 * @author FRAWA+
 * @version 1.0
 */
public class QualiPSoSearchAPISoapClient {



    /**
     * Constructor con los datos de la URL del servicio
     * @param    protocol    Protocolo para conectar con el servidor
     * @param    host    Máquina donde está el servidor
     * @param    port    Puerto donde escucha el servidor
     * @param    servlet    Mapping del servlet en el servidor
     * @param    session    Sesión para todas las invocaciones que se hagan a este servidor (puede ser null para no usar sesión)
     * @param    username    Usuario para autenticación básica en el servidor (puede ser null)
     * @param    password    Password para autenticación básica en el servidor (puede ser null)
     * @throws   MalformedURLException    Se eleva si la URL es incorrecta
     */
    public QualiPSoSearchAPISoapClient(String protocol,
    							   String host,
    							   int port,
    							   String servlet,
    							   TdiSession session,
    							   String username,
    							   String password) throws java.net.MalformedURLException {
        this.init(protocol,host,port,servlet,session,username,password);
    }
    
    /**
     * Constructor con URL completa
     * @param   url URL del servicio
     * @param    session    Sesión para todas las invocaciones que se hagan a este servidor (puede ser null para no usar sesión)
     * @param    username    Usuario para autenticación básica en el servidor (puede ser null)
     * @param    password    Password para autenticación básica en el servidor (puede ser null)
     * @throws   MalformedURLException    Se eleva si la URL es incorrecta
     */
    public QualiPSoSearchAPISoapClient(String url,
    							   TdiSession session,
    							   String username,
    							   String password) throws java.net.MalformedURLException {
        URL u = new URL(url);
        String protocol = u.getProtocol();
        String host = u.getHost();
        int port = u.getPort();
        String servlet = u.getPath();
        this.init(protocol,host,port,servlet,session,username,password);
    }
    
  

    /**
     * Operación: BuildSPARQLQuery Build a SPARQL query string from query components 
     * @param    inbean    org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp    
     */
     public org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp BuildSPARQLQuery(org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"BuildSPARQLQueryService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req.class, org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp.class } );
             
                 // Invocar al método execute
                 org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp outbean = new org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"BuildSPARQLQuery"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/BuildSPARQLQuery");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<BuildSPARQLQuery xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<ExecQuery_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</ExecQuery_req>");
         output.println("</BuildSPARQLQuery>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("BuildSPARQLQueryResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("BuildSPARQLQuery_resp");
        	 org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp outbean = new org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <BuildSPARQLQuery>");
         }
         
     }



    /**
     * Operación: BuildSPARQLSearch Build a SPARQL query string from query components (including text search) 
     * @param    inbean    org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp    
     */
     public org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp BuildSPARQLSearch(org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"BuildSPARQLSearchService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req.class, org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp.class } );
             
                 // Invocar al método execute
                 org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp outbean = new org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"BuildSPARQLSearch"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/BuildSPARQLSearch");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<BuildSPARQLSearch xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<ExecSearch_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</ExecSearch_req>");
         output.println("</BuildSPARQLSearch>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("BuildSPARQLSearchResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("BuildSPARQLSearch_resp");
        	 org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp outbean = new org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <BuildSPARQLSearch>");
         }
         
     }



    /**
     * Operación: ExecAsk  
     * @param    inbean    ExecAsk_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   ExecAsk_resp    
     */
     public ExecAsk_resp ExecAsk(ExecAsk_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"ExecAskService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { ExecAsk_req.class, ExecAsk_resp.class } );
             
                 // Invocar al método execute
                 ExecAsk_resp outbean = new ExecAsk_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"ExecAsk"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/ExecAsk");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<ExecAsk xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<ExecAsk_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</ExecAsk_req>");
         output.println("</ExecAsk>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("ExecAskResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("ExecAsk_resp");
        	 ExecAsk_resp outbean = new ExecAsk_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <ExecAsk>");
         }
         
     }



    /**
     * Operación: ExecConstructAndSearch  
     * @param    inbean    ExecConstructAndSearch_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   ExecConstructAndSearch_resp    
     */
     public ExecConstructAndSearch_resp ExecConstructAndSearch(ExecConstructAndSearch_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"ExecConstructAndSearchService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { ExecConstructAndSearch_req.class, ExecConstructAndSearch_resp.class } );
             
                 // Invocar al método execute
                 ExecConstructAndSearch_resp outbean = new ExecConstructAndSearch_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"ExecConstructAndSearch"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/ExecConstructAndSearch");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<ExecConstructAndSearch xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<ExecConstructAndSearch_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</ExecConstructAndSearch_req>");
         output.println("</ExecConstructAndSearch>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("ExecConstructAndSearchResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("ExecConstructAndSearch_resp");
        	 ExecConstructAndSearch_resp outbean = new ExecConstructAndSearch_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <ExecConstructAndSearch>");
         }
         
     }



    /**
     * Operación: ExecQuery Execute a query on RDF model. It builds the SPARQL sentence from parameters 
     * @param    inbean    ExecQuery_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   ExecQuery_resp    
     */
     public ExecQuery_resp ExecQuery(ExecQuery_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"ExecQueryService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { ExecQuery_req.class, ExecQuery_resp.class } );
             
                 // Invocar al método execute
                 ExecQuery_resp outbean = new ExecQuery_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"ExecQuery"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/ExecQuery");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<ExecQuery xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<ExecQuery_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</ExecQuery_req>");
         output.println("</ExecQuery>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("ExecQueryResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("ExecQuery_resp");
        	 ExecQuery_resp outbean = new ExecQuery_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <ExecQuery>");
         }
         
     }



    /**
     * Operación: ExecSPARQL Execute any SPARQL query on model 
     * @param    inbean    ExecSPARQL_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   ExecSPARQL_resp    
     */
     public ExecSPARQL_resp ExecSPARQL(ExecSPARQL_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"ExecSPARQLService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { ExecSPARQL_req.class, ExecSPARQL_resp.class } );
             
                 // Invocar al método execute
                 ExecSPARQL_resp outbean = new ExecSPARQL_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"ExecSPARQL"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/ExecSPARQL");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<ExecSPARQL xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<ExecSPARQL_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</ExecSPARQL_req>");
         output.println("</ExecSPARQL>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("ExecSPARQLResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("ExecSPARQL_resp");
        	 ExecSPARQL_resp outbean = new ExecSPARQL_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <ExecSPARQL>");
         }
         
     }



    /**
     * Operación: ExecSearch xecute a query on RDF model (it can include text search). It builds the SPARQL sentence from parameters 
     * @param    inbean    ExecSearch_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   ExecSearch_resp    
     */
     public ExecSearch_resp ExecSearch(ExecSearch_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"ExecSearchService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { ExecSearch_req.class, ExecSearch_resp.class } );
             
                 // Invocar al método execute
                 ExecSearch_resp outbean = new ExecSearch_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"ExecSearch"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/ExecSearch");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<ExecSearch xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<ExecSearch_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</ExecSearch_req>");
         output.println("</ExecSearch>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("ExecSearchResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("ExecSearch_resp");
        	 ExecSearch_resp outbean = new ExecSearch_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <ExecSearch>");
         }
         
     }



    /**
     * Operación: ExecSimpleTextSearch Search RDF statements with text 
     * @param    inbean    ExecSimpleTextSearch_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   ExecSimpleTextSearch_resp    
     */
     public ExecSimpleTextSearch_resp ExecSimpleTextSearch(ExecSimpleTextSearch_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"ExecSimpleTextSearchService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { ExecSimpleTextSearch_req.class, ExecSimpleTextSearch_resp.class } );
             
                 // Invocar al método execute
                 ExecSimpleTextSearch_resp outbean = new ExecSimpleTextSearch_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"ExecSimpleTextSearch"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/ExecSimpleTextSearch");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<ExecSimpleTextSearch xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<ExecSimpleTextSearch_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</ExecSimpleTextSearch_req>");
         output.println("</ExecSimpleTextSearch>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("ExecSimpleTextSearchResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("ExecSimpleTextSearch_resp");
        	 ExecSimpleTextSearch_resp outbean = new ExecSimpleTextSearch_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <ExecSimpleTextSearch>");
         }
         
     }



    /**
     * Operación: GetSearchSize Get the number of result of a search 
     * @param    inbean    GetSearchSize_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   GetSearchSize_resp    
     */
     public GetSearchSize_resp GetSearchSize(GetSearchSize_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"GetSearchSizeService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { GetSearchSize_req.class, GetSearchSize_resp.class } );
             
                 // Invocar al método execute
                 GetSearchSize_resp outbean = new GetSearchSize_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"GetSearchSize"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/GetSearchSize");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<GetSearchSize xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<GetSearchSize_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</GetSearchSize_req>");
         output.println("</GetSearchSize>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("GetSearchSizeResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("GetSearchSize_resp");
        	 GetSearchSize_resp outbean = new GetSearchSize_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <GetSearchSize>");
         }
         
     }



    /**
     * Operación: ReIndex Regenerate Lucene indexes 
     * @param    inbean    ReIndex_req    
     * @throws   IOException    Error de comunicaciones
     * @throws   SAXException    Error en el formato del mensaje SOAP
     * @throws   TdiServiceException    Error de aplicación en el servidor
     * @return   ReIndex_resp    
     */
     public ReIndex_resp ReIndex(ReIndex_req inbean) throws IOException,SAXException,TdiServiceException {


         // Si no hay URL, invocar directamente a la clase java del servicio
         if (this._url == null) {
             try {
                 // Instanciar la clase del servicio
                 String serviceClassname = "org.qualipso.advdoc.ws.client.search.service"+"."+"ReIndexService";
                 Class serviceClass = Class.forName(serviceClassname);
             
                 // Crear el objeto servicio
                 Object serviceObj = serviceClass.newInstance();
             
                 // Buscar el método execute
                 java.lang.reflect.Method method = serviceClass.getMethod("execute", new Class[] { ReIndex_req.class, ReIndex_resp.class } );
             
                 // Invocar al método execute
                 ReIndex_resp outbean = new ReIndex_resp();
                 method.invoke(serviceObj, new Object[] { inbean, outbean } );
             
                 return outbean;
             } catch (Exception e) {
                 throw new RuntimeException(getClass().getName()+"ReIndex"+"() "+e.getMessage(),e);
             }
         }


         // Abrir la conexión con el servidor
         HttpURLConnection connection = (HttpURLConnection)this._url.openConnection();
         if (_session != null) {
             _session.setCookies(connection);
         }
         
         // Autenticación básica (para servidores protegidos con LDAP)
         if (this._username != null && this._password != null) {
             tdi.text.Base64Encoder encoder = new tdi.text.Base64Encoder(this._username + ':' + this._password);
             String auth = encoder.processString().trim();
             connection.setRequestProperty("Authorization", "Basic " + auth);
         }
        
         // Conectar con el servidor
         //connection.connect();
         
         // Se van a enviar datos al servidor en el POST
         connection.setDoOutput(true);
         connection.setRequestMethod("POST");
         
         // Header de HTTP para indicar el servicio invocado
         connection.setRequestProperty("SOAPAction","http://www.qualipso.org/advdoc/ws/search/ReIndex");


         // Content-type: text/xml
         connection.setRequestProperty("Content-Type","text/xml");
         
         // Enviar los datos SOAP al servidor
         PrintWriter output = new PrintWriter(connection.getOutputStream(),true);
         // cabecera SOAP
         SOAPUtils.writeSOAPHeader(output);
         // Operación
         output.println("<ReIndex xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
         output.println("<ReIndex_req>");
         // Datos del bean
         inbean.toSOAP(output);
         // operación
         output.println("</ReIndex_req>");
         output.println("</ReIndex>");
         // cola SOAP
         SOAPUtils.writeSOAPTail(output);
         
         // Cerrar el canal de salida
         output.close();
         
         // Leer la respuesta del servidor
         BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));


         // Contenido (puede ser la respuesta o una excepción)
         TdiXmlNode contentsNode = SOAPUtils.getSOAPContentsNode(input);


         // Si hay que mantener información de sesión, guardar las cookies que vienen del servidor
         if (this._session != null) {
             this._session.storeCookies(connection);
         }
         
         if (contentsNode.getTag().equals("ReIndexResponse")) {
             TdiXmlNode parameterNode = contentsNode.getFirstChildByName("ReIndex_resp");
        	 ReIndex_resp outbean = new ReIndex_resp();
        	 outbean.fromSOAP(parameterNode);
             // Cerrar el canal de entrada
             input.close();
             // Retornar el resultado recibido del servidor
             return outbean;
         } else if (contentsNode.getTag().equals("Fault")) {
        	 TdiServiceException exception = new TdiServiceException();
        	 exception.fromSOAP(contentsNode);
             // Cerrar el canal de entrada
             input.close();
        	 throw exception;
         } else {
             // Cerrar el canal de entrada
             input.close();
        	 throw new RuntimeException("Respuesta <"+contentsNode.getTag()+"> no válida para operación <ReIndex>");
         }
         
     }



    private void init(String protocol,String host,int port,String servlet,TdiSession session,String username,String password) throws MalformedURLException {
        this._protocol = protocol;
        this._host = host;
        this._port = port;
        this._servlet = servlet;
        this._url = new URL(_protocol+"://"+_host+":"+_port+_servlet);
        this._session = session;
        this._username = username;
        this._password = password;
    }
    
    


    /**
     * Protocolo para conectar con el servidor
     */
    private String _protocol;



    /**
     * Máquina donde reside el servidor
     */
    private String _host;



    /**
     * Puerto donde escucha el servidor
     */
    private int _port;



    /**
     * Servlet que implementa los servicios
     */
    private String _servlet;



    /**
     * URL para invocar los servicios
     */
    private URL _url;



    /**
     * Usuario para autenticación básica
     */
    private String _username;



    /**
     * Password para autenticación básica
     */
    private String _password;



    /**
     * Sesión que se mantiene durante todas las invocaciones a los servicios
     */
    private TdiSession _session;
      



}





