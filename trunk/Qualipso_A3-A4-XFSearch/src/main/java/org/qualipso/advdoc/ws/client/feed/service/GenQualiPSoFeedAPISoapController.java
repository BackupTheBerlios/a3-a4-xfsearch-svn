




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoFeedAPI
// Versión  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.feed.service;


import javax.servlet.*;
import javax.servlet.http.*;


import tdi.xml.parser.TdiXmlNode;
import tdi.xml.parser.TdiXmlParser;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
import es.tid.frawa.service.servlet.SOAPUtils;
import es.tid.frawa.service.servlet.TdiServiceException;
import es.tid.serial.TdiBean;


import org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_req;
import org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_resp;
import org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_req;
import org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_resp;
import org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_req;
import org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_resp;
import org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_req;
import org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_resp;
import org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_req;
import org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_resp;
import org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_req;
import org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_resp;
import org.qualipso.advdoc.ws.client.feed.beans.CreateResource_req;
import org.qualipso.advdoc.ws.client.feed.beans.CreateResource_resp;
import org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_req;
import org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_resp;
import org.qualipso.advdoc.ws.client.feed.beans.Save_req;
import org.qualipso.advdoc.ws.client.feed.beans.Save_resp;



/**
 * Servlet controlador del servicio SOAP: QualiPSoFeedAPI
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoFeedAPISoapController extends HttpServlet {



    /*
     * Rutina vacía. Para implementar opcionalmente en la clase derivada
     */
    protected void frawaInit() throws Exception {
    }
    
    /*
     * Rutina vacía. Para implementar opcionalmente en la clase derivada
     */
    protected void frawaDestroy() {
    }
    
    /*
     * Rutina vacía. Para implementar opcionalmente en la clase derivada. Retornar false para abortar la petición
     * @param request
     * @param response
     * @return boolean
     */
    protected boolean frawaService(HttpServletRequest request,HttpServletResponse response) {
        return true;
    }



    /*
     * Procesamiento de peticiones GET y POST
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public final void service(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException,IOException {



    	// Comprobar si es un GET
        if (request.getMethod().equalsIgnoreCase("GET")) {
            processGET(request,response);
            return;
    	}
    	
    	// Se trata de un POST
    	
    	// La respuesta es XML
        response.setContentType("text/xml; charset=UTF-8");
    	
    	
        // Crear los filtros definidos para todos los servicios
        es.tid.frawa.service.servlet.Filter[] filters = new es.tid.frawa.service.servlet.Filter[0];

        // Comprobar si algún filtro necesita el mensaje SOAP
        boolean needSOAP = false;
        for (int i = 0;i < filters.length;i++) {
            if (filters[i].needsParseCallbacks()) {
            	needSOAP = true;
              	break;
            }
        }


    	PrintWriter output = null;
    	
    	BufferedReader input = null;
    	
    	TdiXmlNode payloadNode = new TdiXmlNode();
    	payloadNode.setTag("desconocido");


        try {
            // No se crea una sesión (esta opción está desmarcada en el modelo de servicios)

            
            // Invocar el método startService() de los filtros
            for (int i = 0;i < filters.length;i++) {
                filters[i].startService(request,response);
            }
            
            // Invocar el método frawaService() de la clase derivada (si está implementado)
            if (!frawaService(request,response)) {
                // Ha retornado false, por tanto abortamos el procesamiento del servicio
                return;
            }


            StringBuffer soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");


			// Leer el mensaje SOAP
			
            if (request.getParameter("SOAP") != null && request.getParameter("SOAP").length() > 0) {
                String tmp = request.getParameter("SOAP");
                if (tmp == null || tmp.length() == 0) {
                    throw new Exception(getClass().getName()+".service() SOAPAction viene en la URL pero no viene el parámetro SOAP con los datos");
                }
                soapStr = new StringBuffer(tmp);
                input = new BufferedReader(new StringReader(soapStr.toString()));
            } else if (needSOAP) {
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace("Leyendo mensaje SOAP para enviarlo a los filtros. ATENCIÓN: Esto puede ser ineficiente");
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(getClass().getName()+".service() Leyendo mensaje SOAP para enviarlo a los filtros. ATENCIÓN: Esto puede ser ineficiente");
            	input = new BufferedReader(request.getReader());
            	soapStr = new StringBuffer();
            	String line = input.readLine();
            	while (line != null) {
            		soapStr.append(line);
            		line = input.readLine();
            	}
                input = new BufferedReader(new StringReader(soapStr.toString()));
            } else {
            	input = new BufferedReader(request.getReader());
            }
            
            // Invocar el método beforeParse() de los filtros
            for (int i = 0;i < filters.length;i++) {
                filters[i].beforeParse(request,response,soapStr.toString());
            }
            
            // Parsear el mensaje SOAP
            TdiXmlParser parser = new TdiXmlParser(input);
            
            // Obtener el nodo <Envelope>
            TdiXmlNode envelopeNode = parser.getTree();


            // Obtener el payload SOAP (dentro del tag <Body> )
            payloadNode = SOAPUtils.getSOAPContentsNode(envelopeNode);
            
            // Obtener el nodo <Header>
            TdiXmlNode headerNode = SOAPUtils.getSOAPHeaderNode(envelopeNode);


            // Guardar el header en la request
            if (headerNode != null) {
            	request.setAttribute("SOAP_Header",headerNode);
            }



            //
            // Invocar al servicio adecuado en función del nodo raíz del mensaje SOAP
            //
            

            if (payloadNode.getTag().equals("AddLiteralProperties")) {

                // SERVICIO: AddLiteralProperties


                // Parámetro de entrada al servicio
                AddLiteralProperties_req inbean = new AddLiteralProperties_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("AddLiteralProperties_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                AddLiteralProperties_resp outbean = new AddLiteralProperties_resp();
                    
                // Crear un objeto que implementa la operación
                AddLiteralPropertiesService serviceImplementation = new AddLiteralPropertiesService();
                    
                // Invocar la implementación de la operación
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepción, enviarla al cliente
                if (applicationException != null) {
                    // Traza
                    //new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    output = response.getWriter();
                    if (applicationException instanceof TdiServiceException) {
                        sendError(output,(TdiServiceException)applicationException);
                    } else {
                        String inputBean = tdi.text.StringUtil.escapeXML(inbean.toString(),false);
                        String rc = "\n";
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: AddLiteralProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Respuesta
                output = response.getWriter();
                StringWriter soapWriter = null;
                if (needSOAP) {
                    soapWriter = new StringWriter();                    	
                }
                    
                // Cabecera SOAP
                SOAPUtils.writeSOAPHeader(output);
                if (needSOAP) {
                    SOAPUtils.writeSOAPHeader(soapWriter);
                }
                    
                // Respuesta
                output.println("<AddLiteralPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                output.println("<AddLiteralProperties_resp>");
                if (needSOAP) {
                    soapWriter.write("<AddLiteralPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                   	soapWriter.write("<AddLiteralProperties_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</AddLiteralProperties_resp>");
                output.println("</AddLiteralPropertiesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</AddLiteralProperties_resp>");
                    soapWriter.write("</AddLiteralPropertiesResponse>");
                }
                    
                // Cola SOAP
                SOAPUtils.writeSOAPTail(output);
                if (needSOAP) {
                   	SOAPUtils.writeSOAPTail(soapWriter);
                }


                soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");
                if (needSOAP) {
                    soapStr = new StringBuffer(soapWriter.toString());
                }


                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("AddLiteralProperty")) {

                // SERVICIO: AddLiteralProperty


                // Parámetro de entrada al servicio
                AddLiteralProperty_req inbean = new AddLiteralProperty_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("AddLiteralProperty_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                AddLiteralProperty_resp outbean = new AddLiteralProperty_resp();
                    
                // Crear un objeto que implementa la operación
                AddLiteralPropertyService serviceImplementation = new AddLiteralPropertyService();
                    
                // Invocar la implementación de la operación
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepción, enviarla al cliente
                if (applicationException != null) {
                    // Traza
                    //new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    output = response.getWriter();
                    if (applicationException instanceof TdiServiceException) {
                        sendError(output,(TdiServiceException)applicationException);
                    } else {
                        String inputBean = tdi.text.StringUtil.escapeXML(inbean.toString(),false);
                        String rc = "\n";
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: AddLiteralProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Respuesta
                output = response.getWriter();
                StringWriter soapWriter = null;
                if (needSOAP) {
                    soapWriter = new StringWriter();                    	
                }
                    
                // Cabecera SOAP
                SOAPUtils.writeSOAPHeader(output);
                if (needSOAP) {
                    SOAPUtils.writeSOAPHeader(soapWriter);
                }
                    
                // Respuesta
                output.println("<AddLiteralPropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                output.println("<AddLiteralProperty_resp>");
                if (needSOAP) {
                    soapWriter.write("<AddLiteralPropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                   	soapWriter.write("<AddLiteralProperty_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</AddLiteralProperty_resp>");
                output.println("</AddLiteralPropertyResponse>");
                if (needSOAP) {
                   	soapWriter.write("</AddLiteralProperty_resp>");
                    soapWriter.write("</AddLiteralPropertyResponse>");
                }
                    
                // Cola SOAP
                SOAPUtils.writeSOAPTail(output);
                if (needSOAP) {
                   	SOAPUtils.writeSOAPTail(soapWriter);
                }


                soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");
                if (needSOAP) {
                    soapStr = new StringBuffer(soapWriter.toString());
                }


                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("AddObjectProperties")) {

                // SERVICIO: AddObjectProperties


                // Parámetro de entrada al servicio
                AddObjectProperties_req inbean = new AddObjectProperties_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("AddObjectProperties_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                AddObjectProperties_resp outbean = new AddObjectProperties_resp();
                    
                // Crear un objeto que implementa la operación
                AddObjectPropertiesService serviceImplementation = new AddObjectPropertiesService();
                    
                // Invocar la implementación de la operación
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepción, enviarla al cliente
                if (applicationException != null) {
                    // Traza
                    //new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    output = response.getWriter();
                    if (applicationException instanceof TdiServiceException) {
                        sendError(output,(TdiServiceException)applicationException);
                    } else {
                        String inputBean = tdi.text.StringUtil.escapeXML(inbean.toString(),false);
                        String rc = "\n";
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: AddObjectProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Respuesta
                output = response.getWriter();
                StringWriter soapWriter = null;
                if (needSOAP) {
                    soapWriter = new StringWriter();                    	
                }
                    
                // Cabecera SOAP
                SOAPUtils.writeSOAPHeader(output);
                if (needSOAP) {
                    SOAPUtils.writeSOAPHeader(soapWriter);
                }
                    
                // Respuesta
                output.println("<AddObjectPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                output.println("<AddObjectProperties_resp>");
                if (needSOAP) {
                    soapWriter.write("<AddObjectPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                   	soapWriter.write("<AddObjectProperties_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</AddObjectProperties_resp>");
                output.println("</AddObjectPropertiesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</AddObjectProperties_resp>");
                    soapWriter.write("</AddObjectPropertiesResponse>");
                }
                    
                // Cola SOAP
                SOAPUtils.writeSOAPTail(output);
                if (needSOAP) {
                   	SOAPUtils.writeSOAPTail(soapWriter);
                }


                soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");
                if (needSOAP) {
                    soapStr = new StringBuffer(soapWriter.toString());
                }


                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("AddObjectProperty")) {

                // SERVICIO: AddObjectProperty


                // Parámetro de entrada al servicio
                AddObjectProperty_req inbean = new AddObjectProperty_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("AddObjectProperty_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                AddObjectProperty_resp outbean = new AddObjectProperty_resp();
                    
                // Crear un objeto que implementa la operación
                AddObjectPropertyService serviceImplementation = new AddObjectPropertyService();
                    
                // Invocar la implementación de la operación
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepción, enviarla al cliente
                if (applicationException != null) {
                    // Traza
                    //new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    output = response.getWriter();
                    if (applicationException instanceof TdiServiceException) {
                        sendError(output,(TdiServiceException)applicationException);
                    } else {
                        String inputBean = tdi.text.StringUtil.escapeXML(inbean.toString(),false);
                        String rc = "\n";
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: AddObjectProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Respuesta
                output = response.getWriter();
                StringWriter soapWriter = null;
                if (needSOAP) {
                    soapWriter = new StringWriter();                    	
                }
                    
                // Cabecera SOAP
                SOAPUtils.writeSOAPHeader(output);
                if (needSOAP) {
                    SOAPUtils.writeSOAPHeader(soapWriter);
                }
                    
                // Respuesta
                output.println("<AddObjectPropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                output.println("<AddObjectProperty_resp>");
                if (needSOAP) {
                    soapWriter.write("<AddObjectPropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                   	soapWriter.write("<AddObjectProperty_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</AddObjectProperty_resp>");
                output.println("</AddObjectPropertyResponse>");
                if (needSOAP) {
                   	soapWriter.write("</AddObjectProperty_resp>");
                    soapWriter.write("</AddObjectPropertyResponse>");
                }
                    
                // Cola SOAP
                SOAPUtils.writeSOAPTail(output);
                if (needSOAP) {
                   	SOAPUtils.writeSOAPTail(soapWriter);
                }


                soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");
                if (needSOAP) {
                    soapStr = new StringBuffer(soapWriter.toString());
                }


                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("CreateAnonymousResource")) {

                // SERVICIO: CreateAnonymousResource


                // Parámetro de entrada al servicio
                CreateAnonymousResource_req inbean = new CreateAnonymousResource_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("CreateAnonymousResource_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                CreateAnonymousResource_resp outbean = new CreateAnonymousResource_resp();
                    
                // Crear un objeto que implementa la operación
                CreateAnonymousResourceService serviceImplementation = new CreateAnonymousResourceService();
                    
                // Invocar la implementación de la operación
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepción, enviarla al cliente
                if (applicationException != null) {
                    // Traza
                    //new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    output = response.getWriter();
                    if (applicationException instanceof TdiServiceException) {
                        sendError(output,(TdiServiceException)applicationException);
                    } else {
                        String inputBean = tdi.text.StringUtil.escapeXML(inbean.toString(),false);
                        String rc = "\n";
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: CreateAnonymousResource]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Respuesta
                output = response.getWriter();
                StringWriter soapWriter = null;
                if (needSOAP) {
                    soapWriter = new StringWriter();                    	
                }
                    
                // Cabecera SOAP
                SOAPUtils.writeSOAPHeader(output);
                if (needSOAP) {
                    SOAPUtils.writeSOAPHeader(soapWriter);
                }
                    
                // Respuesta
                output.println("<CreateAnonymousResourceResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                output.println("<CreateAnonymousResource_resp>");
                if (needSOAP) {
                    soapWriter.write("<CreateAnonymousResourceResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                   	soapWriter.write("<CreateAnonymousResource_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</CreateAnonymousResource_resp>");
                output.println("</CreateAnonymousResourceResponse>");
                if (needSOAP) {
                   	soapWriter.write("</CreateAnonymousResource_resp>");
                    soapWriter.write("</CreateAnonymousResourceResponse>");
                }
                    
                // Cola SOAP
                SOAPUtils.writeSOAPTail(output);
                if (needSOAP) {
                   	SOAPUtils.writeSOAPTail(soapWriter);
                }


                soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");
                if (needSOAP) {
                    soapStr = new StringBuffer(soapWriter.toString());
                }


                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("CreateProperty")) {

                // SERVICIO: CreateProperty


                // Parámetro de entrada al servicio
                CreateProperty_req inbean = new CreateProperty_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("CreateProperty_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                CreateProperty_resp outbean = new CreateProperty_resp();
                    
                // Crear un objeto que implementa la operación
                CreatePropertyService serviceImplementation = new CreatePropertyService();
                    
                // Invocar la implementación de la operación
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepción, enviarla al cliente
                if (applicationException != null) {
                    // Traza
                    //new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    output = response.getWriter();
                    if (applicationException instanceof TdiServiceException) {
                        sendError(output,(TdiServiceException)applicationException);
                    } else {
                        String inputBean = tdi.text.StringUtil.escapeXML(inbean.toString(),false);
                        String rc = "\n";
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: CreateProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Respuesta
                output = response.getWriter();
                StringWriter soapWriter = null;
                if (needSOAP) {
                    soapWriter = new StringWriter();                    	
                }
                    
                // Cabecera SOAP
                SOAPUtils.writeSOAPHeader(output);
                if (needSOAP) {
                    SOAPUtils.writeSOAPHeader(soapWriter);
                }
                    
                // Respuesta
                output.println("<CreatePropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                output.println("<CreateProperty_resp>");
                if (needSOAP) {
                    soapWriter.write("<CreatePropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                   	soapWriter.write("<CreateProperty_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</CreateProperty_resp>");
                output.println("</CreatePropertyResponse>");
                if (needSOAP) {
                   	soapWriter.write("</CreateProperty_resp>");
                    soapWriter.write("</CreatePropertyResponse>");
                }
                    
                // Cola SOAP
                SOAPUtils.writeSOAPTail(output);
                if (needSOAP) {
                   	SOAPUtils.writeSOAPTail(soapWriter);
                }


                soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");
                if (needSOAP) {
                    soapStr = new StringBuffer(soapWriter.toString());
                }


                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("CreateResource")) {

                // SERVICIO: CreateResource


                // Parámetro de entrada al servicio
                CreateResource_req inbean = new CreateResource_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("CreateResource_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                CreateResource_resp outbean = new CreateResource_resp();
                    
                // Crear un objeto que implementa la operación
                CreateResourceService serviceImplementation = new CreateResourceService();
                    
                // Invocar la implementación de la operación
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepción, enviarla al cliente
                if (applicationException != null) {
                    // Traza
                    //new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    output = response.getWriter();
                    if (applicationException instanceof TdiServiceException) {
                        sendError(output,(TdiServiceException)applicationException);
                    } else {
                        String inputBean = tdi.text.StringUtil.escapeXML(inbean.toString(),false);
                        String rc = "\n";
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: CreateResource]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Respuesta
                output = response.getWriter();
                StringWriter soapWriter = null;
                if (needSOAP) {
                    soapWriter = new StringWriter();                    	
                }
                    
                // Cabecera SOAP
                SOAPUtils.writeSOAPHeader(output);
                if (needSOAP) {
                    SOAPUtils.writeSOAPHeader(soapWriter);
                }
                    
                // Respuesta
                output.println("<CreateResourceResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                output.println("<CreateResource_resp>");
                if (needSOAP) {
                    soapWriter.write("<CreateResourceResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                   	soapWriter.write("<CreateResource_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</CreateResource_resp>");
                output.println("</CreateResourceResponse>");
                if (needSOAP) {
                   	soapWriter.write("</CreateResource_resp>");
                    soapWriter.write("</CreateResourceResponse>");
                }
                    
                // Cola SOAP
                SOAPUtils.writeSOAPTail(output);
                if (needSOAP) {
                   	SOAPUtils.writeSOAPTail(soapWriter);
                }


                soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");
                if (needSOAP) {
                    soapStr = new StringBuffer(soapWriter.toString());
                }


                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("RemoveProperty")) {

                // SERVICIO: RemoveProperty


                // Parámetro de entrada al servicio
                RemoveProperty_req inbean = new RemoveProperty_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("RemoveProperty_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                RemoveProperty_resp outbean = new RemoveProperty_resp();
                    
                // Crear un objeto que implementa la operación
                RemovePropertyService serviceImplementation = new RemovePropertyService();
                    
                // Invocar la implementación de la operación
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepción, enviarla al cliente
                if (applicationException != null) {
                    // Traza
                    //new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    output = response.getWriter();
                    if (applicationException instanceof TdiServiceException) {
                        sendError(output,(TdiServiceException)applicationException);
                    } else {
                        String inputBean = tdi.text.StringUtil.escapeXML(inbean.toString(),false);
                        String rc = "\n";
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: RemoveProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Respuesta
                output = response.getWriter();
                StringWriter soapWriter = null;
                if (needSOAP) {
                    soapWriter = new StringWriter();                    	
                }
                    
                // Cabecera SOAP
                SOAPUtils.writeSOAPHeader(output);
                if (needSOAP) {
                    SOAPUtils.writeSOAPHeader(soapWriter);
                }
                    
                // Respuesta
                output.println("<RemovePropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                output.println("<RemoveProperty_resp>");
                if (needSOAP) {
                    soapWriter.write("<RemovePropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                   	soapWriter.write("<RemoveProperty_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</RemoveProperty_resp>");
                output.println("</RemovePropertyResponse>");
                if (needSOAP) {
                   	soapWriter.write("</RemoveProperty_resp>");
                    soapWriter.write("</RemovePropertyResponse>");
                }
                    
                // Cola SOAP
                SOAPUtils.writeSOAPTail(output);
                if (needSOAP) {
                   	SOAPUtils.writeSOAPTail(soapWriter);
                }


                soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");
                if (needSOAP) {
                    soapStr = new StringBuffer(soapWriter.toString());
                }


                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("Save")) {

                // SERVICIO: Save


                // Parámetro de entrada al servicio
                Save_req inbean = new Save_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("Save_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                Save_resp outbean = new Save_resp();
                    
                // Crear un objeto que implementa la operación
                SaveService serviceImplementation = new SaveService();
                    
                // Invocar la implementación de la operación
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepción, enviarla al cliente
                if (applicationException != null) {
                    // Traza
                    //new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    new es.tid.frawa.common.TdiFrawaTraceListener().trace(applicationException);
                    output = response.getWriter();
                    if (applicationException instanceof TdiServiceException) {
                        sendError(output,(TdiServiceException)applicationException);
                    } else {
                        String inputBean = tdi.text.StringUtil.escapeXML(inbean.toString(),false);
                        String rc = "\n";
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: Save]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",payloadNode.getTag());
                }
                    
                // Respuesta
                output = response.getWriter();
                StringWriter soapWriter = null;
                if (needSOAP) {
                    soapWriter = new StringWriter();                    	
                }
                    
                // Cabecera SOAP
                SOAPUtils.writeSOAPHeader(output);
                if (needSOAP) {
                    SOAPUtils.writeSOAPHeader(soapWriter);
                }
                    
                // Respuesta
                output.println("<SaveResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                output.println("<Save_resp>");
                if (needSOAP) {
                    soapWriter.write("<SaveResponse xmlns=\"http://www.qualipso.org/advdoc/ws/feed\">");
                   	soapWriter.write("<Save_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</Save_resp>");
                output.println("</SaveResponse>");
                if (needSOAP) {
                   	soapWriter.write("</Save_resp>");
                    soapWriter.write("</SaveResponse>");
                }
                    
                // Cola SOAP
                SOAPUtils.writeSOAPTail(output);
                if (needSOAP) {
                   	SOAPUtils.writeSOAPTail(soapWriter);
                }


                soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");
                if (needSOAP) {
                    soapStr = new StringBuffer(soapWriter.toString());
                }


                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }


                
            } else {
            	
                throw new Exception(getClass().getName() + ".service() Operación "+payloadNode.getTag()+" no válida");
                
            }


        } catch (ServletException e) {


			// Ha ocurrido un error en los filtros


            // Traza
            //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
            new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);


            // Enviar <Fault> al cliente
            if (output == null) {
            	output = response.getWriter();
            }
            TdiServiceException se = new TdiServiceException(-1,"Filter exception",e.getMessage());
            sendError(output,se);


        } catch (Throwable t) {


            // Invocar el método onException() de los filtros
            for (int i = 0;i < filters.length;i++) {
                filters[i].onException(request,response,t,"QualiPSoFeedAPI",payloadNode.getTag());
            }
            
            // Traza
            //new es.tid.frawa.common.TdiFrawaTraceListener().trace(t);
            new es.tid.frawa.common.TdiFrawaTraceListener().trace(t);
            
            // Elevar una ServletException
            throw new ServletException(getClass().getName() + ".service() Server Exception: " + t.getClass().getName() + " -> " + t.getMessage());
            //if (output == null) {
            //	output = response.getWriter();
            //}
            //TdiServiceException se = new TdiServiceException(-2,t.getClass().getName(),t.getMessage());
            //sendError(output,se);
            
        } finally {


            // Invocar el método onFinally() de los filtros
            for (int i = 0;i < filters.length;i++) {
                filters[i].onFinally(request,response,"QualiPSoFeedAPI",payloadNode.getTag());
            }


        }


    }



    /*
     * Inicialización del servlet
     */
    public final void init() throws ServletException {
        try {
            //new es.tid.frawa.common.TdiFrawaTraceListener().trace(getClass().getName() + ".init()");
            new es.tid.frawa.common.TdiFrawaTraceListener().trace(getClass().getName() + ".init()");
            frawaInit();
        } catch (Exception e) {
            //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
            new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
            throw new ServletException(getClass().getName()+".init() "+e.getMessage());
        }
    }


    /*
     * Destrucción del servlet
     */
    public final void destroy() {
        //new es.tid.frawa.common.TdiFrawaTraceListener().trace(getClass().getName() + ".destroy()");
        new es.tid.frawa.common.TdiFrawaTraceListener().trace(getClass().getName() + ".destroy()");
        frawaDestroy();
        // Cerrar los pools de conexiones utilizados
        try {
        } catch (Exception e) {
            // Traza
            //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
            new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
        }
    }



    /*
     * Envío de error SOAP al cliente
     */
    private void sendError(PrintWriter writer,TdiServiceException exception) throws IOException {
    
    	SOAPUtils.writeSOAPHeader(writer);
    	writer.println("<soap:Fault>");
    	exception.toSOAP(writer);
    	writer.println("</soap:Fault>");
    	SOAPUtils.writeSOAPTail(writer);
    	
    }


    
    private StringBuffer wsdl = null;
    private synchronized String getWSDL() {
        if (wsdl == null) {
        	String[] lines = new String[] {
                "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>",
                "<wsdl:definitions xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"",
                "                  xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"",
                "                  xmlns:mime=\"http://schemas.xmlsoap.org/wsdl/mime/\"",
                "                  xmlns:tns=\"http://www.qualipso.org/advdoc/ws/feed\"",
                "                  xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"",
                "                  xmlns:http=\"http://schemas.xmlsoap.org/wsdl/http/\"",
                "                  xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"",
                "                  targetNamespace=\"http://www.qualipso.org/advdoc/ws/feed\">",
                "    <wsdl:types>",
                "        <xs:schema elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:tns=\"http://www.qualipso.org/advdoc/ws/feed\" targetNamespace=\"http://www.qualipso.org/advdoc/ws/feed\">",
                "",
                "            <xs:element name=\"Save_resp\" type=\"tns:Save_resp\"/>",
                "            <xs:complexType name=\"Save_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"filename\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"filesize\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"Save_req\" type=\"tns:Save_req\"/>",
                "            <xs:complexType name=\"Save_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"filename\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"RemoveProperty_resp\" type=\"tns:RemoveProperty_resp\"/>",
                "            <xs:complexType name=\"RemoveProperty_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"RemoveProperty_req\" type=\"tns:RemoveProperty_req\"/>",
                "            <xs:complexType name=\"RemoveProperty_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ObjectProperty\" type=\"tns:ObjectProperty\"/>",
                "            <xs:complexType name=\"ObjectProperty\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"objectUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"LiteralProperty\" type=\"tns:LiteralProperty\"/>",
                "            <xs:complexType name=\"LiteralProperty\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"value\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"CreateResource_resp\" type=\"tns:CreateResource_resp\"/>",
                "            <xs:complexType name=\"CreateResource_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"CreateResource_req\" type=\"tns:CreateResource_req\"/>",
                "            <xs:complexType name=\"CreateResource_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"CreateProperty_resp\" type=\"tns:CreateProperty_resp\"/>",
                "            <xs:complexType name=\"CreateProperty_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"CreateProperty_req\" type=\"tns:CreateProperty_req\"/>",
                "            <xs:complexType name=\"CreateProperty_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"CreateAnonymousResource_resp\" type=\"tns:CreateAnonymousResource_resp\"/>",
                "            <xs:complexType name=\"CreateAnonymousResource_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"anonymousId\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"CreateAnonymousResource_req\" type=\"tns:CreateAnonymousResource_req\"/>",
                "            <xs:complexType name=\"CreateAnonymousResource_req\">",
                "                <xs:sequence>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"AddObjectProperty_resp\" type=\"tns:AddObjectProperty_resp\"/>",
                "            <xs:complexType name=\"AddObjectProperty_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"AddObjectProperty_req\" type=\"tns:AddObjectProperty_req\"/>",
                "            <xs:complexType name=\"AddObjectProperty_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"objectUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"AddObjectProperties_resp\" type=\"tns:AddObjectProperties_resp\"/>",
                "            <xs:complexType name=\"AddObjectProperties_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"AddObjectProperties_req\" type=\"tns:AddObjectProperties_req\"/>",
                "            <xs:complexType name=\"AddObjectProperties_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"objectProperties\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ObjectProperty\" nillable=\"false\" type=\"tns:ObjectProperty\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"AddLiteralProperty_resp\" type=\"tns:AddLiteralProperty_resp\"/>",
                "            <xs:complexType name=\"AddLiteralProperty_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"AddLiteralProperty_req\" type=\"tns:AddLiteralProperty_req\"/>",
                "            <xs:complexType name=\"AddLiteralProperty_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"value\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"AddLiteralProperties_resp\" type=\"tns:AddLiteralProperties_resp\"/>",
                "            <xs:complexType name=\"AddLiteralProperties_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"AddLiteralProperties_req\" type=\"tns:AddLiteralProperties_req\"/>",
                "            <xs:complexType name=\"AddLiteralProperties_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"literalProperties\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"LiteralProperty\" nillable=\"false\" type=\"tns:LiteralProperty\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "            <!-- Elementos para las operaciones -->",
                "            <xs:element name=\"AddLiteralProperties\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"AddLiteralProperties_req\" type=\"tns:AddLiteralProperties_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"AddLiteralPropertiesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"AddLiteralProperties_resp\" type=\"tns:AddLiteralProperties_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"AddLiteralProperty\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"AddLiteralProperty_req\" type=\"tns:AddLiteralProperty_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"AddLiteralPropertyResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"AddLiteralProperty_resp\" type=\"tns:AddLiteralProperty_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"AddObjectProperties\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"AddObjectProperties_req\" type=\"tns:AddObjectProperties_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"AddObjectPropertiesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"AddObjectProperties_resp\" type=\"tns:AddObjectProperties_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"AddObjectProperty\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"AddObjectProperty_req\" type=\"tns:AddObjectProperty_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"AddObjectPropertyResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"AddObjectProperty_resp\" type=\"tns:AddObjectProperty_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"CreateAnonymousResource\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"CreateAnonymousResource_req\" type=\"tns:CreateAnonymousResource_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"CreateAnonymousResourceResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"CreateAnonymousResource_resp\" type=\"tns:CreateAnonymousResource_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"CreateProperty\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"CreateProperty_req\" type=\"tns:CreateProperty_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"CreatePropertyResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"CreateProperty_resp\" type=\"tns:CreateProperty_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"CreateResource\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"CreateResource_req\" type=\"tns:CreateResource_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"CreateResourceResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"CreateResource_resp\" type=\"tns:CreateResource_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"RemoveProperty\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"RemoveProperty_req\" type=\"tns:RemoveProperty_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"RemovePropertyResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"RemoveProperty_resp\" type=\"tns:RemoveProperty_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"Save\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"Save_req\" type=\"tns:Save_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"SaveResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"Save_resp\" type=\"tns:Save_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "        </xs:schema>",
                "    </wsdl:types>",
                "    <wsdl:message name=\"AddLiteralPropertiesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:AddLiteralProperties\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"AddLiteralPropertiesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:AddLiteralPropertiesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"AddLiteralPropertySoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:AddLiteralProperty\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"AddLiteralPropertySoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:AddLiteralPropertyResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"AddObjectPropertiesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:AddObjectProperties\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"AddObjectPropertiesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:AddObjectPropertiesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"AddObjectPropertySoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:AddObjectProperty\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"AddObjectPropertySoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:AddObjectPropertyResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"CreateAnonymousResourceSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:CreateAnonymousResource\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"CreateAnonymousResourceSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:CreateAnonymousResourceResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"CreatePropertySoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:CreateProperty\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"CreatePropertySoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:CreatePropertyResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"CreateResourceSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:CreateResource\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"CreateResourceSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:CreateResourceResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"RemovePropertySoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:RemoveProperty\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"RemovePropertySoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:RemovePropertyResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"SaveSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:Save\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"SaveSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:SaveResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:portType name=\"QualiPSoFeedAPISoapPortType\">",
                "        <wsdl:operation name=\"AddLiteralProperties\">",
                "            <wsdl:documentation>Add some literal properties to an existing resource</wsdl:documentation>",
                "            <wsdl:input message=\"tns:AddLiteralPropertiesSoapIn\"/>",
                "            <wsdl:output message=\"tns:AddLiteralPropertiesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"AddLiteralProperty\">",
                "            <wsdl:documentation>Add a literal property to an existing resource</wsdl:documentation>",
                "            <wsdl:input message=\"tns:AddLiteralPropertySoapIn\"/>",
                "            <wsdl:output message=\"tns:AddLiteralPropertySoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"AddObjectProperties\">",
                "            <wsdl:documentation>Add some object properties to an existing resource</wsdl:documentation>",
                "            <wsdl:input message=\"tns:AddObjectPropertiesSoapIn\"/>",
                "            <wsdl:output message=\"tns:AddObjectPropertiesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"AddObjectProperty\">",
                "            <wsdl:documentation>Add an object property to an existing resource</wsdl:documentation>",
                "            <wsdl:input message=\"tns:AddObjectPropertySoapIn\"/>",
                "            <wsdl:output message=\"tns:AddObjectPropertySoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"CreateAnonymousResource\">",
                "            <wsdl:documentation>Creates a new anonymous resource</wsdl:documentation>",
                "            <wsdl:input message=\"tns:CreateAnonymousResourceSoapIn\"/>",
                "            <wsdl:output message=\"tns:CreateAnonymousResourceSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"CreateProperty\">",
                "            <wsdl:documentation>Creates a new property</wsdl:documentation>",
                "            <wsdl:input message=\"tns:CreatePropertySoapIn\"/>",
                "            <wsdl:output message=\"tns:CreatePropertySoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"CreateResource\">",
                "            <wsdl:documentation>Creates a new resource</wsdl:documentation>",
                "            <wsdl:input message=\"tns:CreateResourceSoapIn\"/>",
                "            <wsdl:output message=\"tns:CreateResourceSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"RemoveProperty\">",
                "            <wsdl:documentation>Remove all sentences with a property for a given resource</wsdl:documentation>",
                "            <wsdl:input message=\"tns:RemovePropertySoapIn\"/>",
                "            <wsdl:output message=\"tns:RemovePropertySoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"Save\">",
                "            <wsdl:documentation>Save data to permanent storage</wsdl:documentation>",
                "            <wsdl:input message=\"tns:SaveSoapIn\"/>",
                "            <wsdl:output message=\"tns:SaveSoapOut\"/>",
                "        </wsdl:operation>",
                "    </wsdl:portType>",
                "    <wsdl:binding name=\"QualiPSoFeedAPISoapBinding\" type=\"tns:QualiPSoFeedAPISoapPortType\">",
                "        <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>",
                "        <wsdl:operation name=\"AddLiteralProperties\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/feed/AddLiteralProperties\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"AddLiteralProperty\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/feed/AddLiteralProperty\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"AddObjectProperties\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/feed/AddObjectProperties\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"AddObjectProperty\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/feed/AddObjectProperty\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"CreateAnonymousResource\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/feed/CreateAnonymousResource\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"CreateProperty\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/feed/CreateProperty\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"CreateResource\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/feed/CreateResource\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"RemoveProperty\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/feed/RemoveProperty\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"Save\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/feed/Save\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "    </wsdl:binding>",
                "    <wsdl:service name=\"QualiPSoFeedAPI\">",
                "        <wsdl:port name=\"QualiPSoFeedAPISoapPort\" binding=\"tns:QualiPSoFeedAPISoapBinding\">",
                "            <soap:address location=\"[URL_SERVICE_LOCATION]\"/>",
                "        </wsdl:port>",
                "    </wsdl:service>",
                "</wsdl:definitions>",
        	};
        	wsdl = new StringBuffer();
        	for (int i = 0;i < lines.length;i++) {
        	    wsdl.append(lines[i]);
        	    wsdl.append("\n");
        	}
        }
        return wsdl.toString();
    }
    
    private static final long serialVersionUID = 1L;
    
    
    private void processGET(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {


    	    String wsdlHeader = request.getParameter("wsdl");
    	    String showBean = request.getParameter("showBean");
    	    String showMethod = request.getParameter("showMethod");
    	    String showSOAP = request.getParameter("showSOAP");
    	    String showFrame = request.getParameter("showFrame");
    	    String inbean = request.getParameter("inbean");
    	    String outbean = request.getParameter("outbean");
    	    if (wsdlHeader == null) {
        	    wsdlHeader = request.getParameter("WSDL");    		
    	    }
  		    //String serviceURL = request.getScheme() + "://" + java.net.InetAddress.getLocalHost().getCanonicalHostName() + ":" + request.getServerPort() + request.getRequestURI();
  		    String serviceURL = "";
    	    if (wsdlHeader != null) {
                // La respuesta es XML
                response.setContentType("text/xml");
    		    PrintWriter writer = response.getWriter();
    		    String wsdl = getWSDL();
    		    wsdl = tdi.text.StringUtil.replace(wsdl,"[URL_SERVICE_LOCATION]",serviceURL);
    		    writer.println(wsdl);
    		} else if (showFrame != null) {
                // La respuesta es HTML
                response.setContentType("text/html");
	    		PrintWriter writer = response.getWriter();
    		    writer.write("<HTML>");
	    		writer.write("<FRAMESET cols=\"50%,50%\">");
	    		writer.write("<FRAME src=\""+serviceURL+"?showBean="+showFrame+"\">");
	    		writer.write("<FRAME src=\""+serviceURL+"?showSOAP="+showFrame+"\">");
	    		writer.write("</FRAMESET>");
    		    writer.write("</HTML>");
    		} else if (showBean != null) {
                // La respuesta es HTML
                response.setContentType("text/html");
	    		PrintWriter writer = response.getWriter();
	    		try {
	    		    writer.write("<HTML>");
	    		    writer.write("<HEAD>");
	    		    writer.write("<TITLE>"+showBean+"</TITLE>");
	    		    writer.write("</HEAD>");
	    		    writer.write("<BODY>");
	    			Class c = getBeanClass(showBean);
				    java.lang.reflect.Method m = c.getMethod("getStructure",new Class[0]);
				    Object obj = c.newInstance();
				    writer.write((String)m.invoke(obj,new Object[0]));
				    writer.write("<HR>");
				    writer.write("<P>");
				    writer.write("<P>");
				    writer.write("<A HREF=\"javascript:history.back()\">Volver</A><P/>");
	    		    writer.write("</BODY>");
	    		    writer.write("</HTML>");
	    		} catch (Exception e__1) {
	    		}
    		} else if (showSOAP != null) {
                // La respuesta es XML
                response.setContentType("text/xml");
	    		PrintWriter writer = response.getWriter();
	    		try {
	    			Class c = getBeanClass(showSOAP);
				    Object obj = c.newInstance();
				    TdiBean bean = (TdiBean)obj;
				    bean.fillSampleData();
				    writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				    writer.write("<"+es.tid.serial.BeanUtil.getTypeWithoutPackage(showSOAP)+">");
				    writer.write(bean.toSOAP());
				    writer.write("</"+es.tid.serial.BeanUtil.getTypeWithoutPackage(showSOAP)+">");
	    		} catch (Exception e__1) {
	    		}
    		} else if (showMethod != null) {
                // La respuesta es HTML
                response.setContentType("text/html");
	    		PrintWriter writer = response.getWriter();
	    		try {
	    			Class c = getBeanClass(inbean);
				    Object obj = c.newInstance();
				    TdiBean bean = (TdiBean)obj;
				    bean.fillSampleData();
				    java.io.StringWriter sw = new java.io.StringWriter();
				    es.tid.frawa.service.servlet.SOAPUtils.writeSOAPHeader(sw);
				    sw.write("\n");
				    sw.write("<"+showMethod+">");
				    sw.write("\n");
				    sw.write("<"+es.tid.serial.BeanUtil.getTypeWithoutPackage(inbean)+">");
				    sw.write("\n");
				    bean.toSOAP(sw);
				    sw.write("</"+es.tid.serial.BeanUtil.getTypeWithoutPackage(inbean)+">");
				    sw.write("\n");
				    sw.write("</"+showMethod+">");
				    sw.write("\n");
				    sw.write("\n");
				    es.tid.frawa.service.servlet.SOAPUtils.writeSOAPTail(sw);
				    sw.write("\n");
				    
				    String line = null;
				    StringBuffer soap = new StringBuffer();
				    java.io.BufferedReader br = new java.io.BufferedReader(new java.io.StringReader(sw.toString()));
				    line = br.readLine();
				    while (line != null) {
				    	soap.append(line);
				    	soap.append("\\n");
				    	line = br.readLine();
				    }


	    		    writer.write("<HTML>");
	    		    writer.write("<HEAD>");
	    		    writer.write("<TITLE>"+showMethod+"</TITLE>");
	    		    writer.write("<SCRIPT language=\"javascript\">");
	    		    writer.write("function setSOAP() {");
	    		    writer.write("    document.forms[\"formSOAP\"].SOAP.value = '"+soap.toString()+"';");
	    		    writer.write("    ");	    		    
	    		    writer.write("}");
	    		    writer.write("</SCRIPT>");
	    		    writer.write("</HEAD>");
	    		    writer.write("<BODY onLoad=\"setSOAP()\">");
	    		    writer.write("<FORM name=\"formSOAP\" action=\""+serviceURL+"?SOAPAction=http://www.qualipso.org/advdoc/ws/feed/"+showMethod+"\" method=\"post\">");
	    		    writer.write("<TEXTAREA name=\"SOAP\" type=\"text\" rows=\"20\" cols=\"100\"></TEXTAREA>");
	    		    writer.write("<INPUT type=\"submit\" name=\"Invocar operación\"></INPUT>");
	    		    writer.write("</FORM>");
	    		    writer.write("</BODY>");
    		        writer.write("</HTML>");
	    		} catch (Exception e__1) {
	    		}
	    	} else {
                // La respuesta es HTML
                response.setContentType("text/html");
	    		PrintWriter writer = response.getWriter();
	    		writer.write("<HTML>");
	    		writer.write("<HEAD>");
	    		writer.write("<TITLE>QualiPSoFeedAPI</TITLE>");
	    		writer.write("</HEAD>");
	    		writer.write("<BODY>");
                writer.println("<H2>Servicio Web <B>QualiPSoFeedAPI</B></H2><P/>");
                writer.println("OPERACIONES<P/>");
                writer.println("<OL>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=AddLiteralProperties&inbean=AddLiteralProperties_req&outbean=AddLiteralProperties_resp\">AddLiteralProperties</A> (input : <A HREF=\""+serviceURL+"?showFrame=AddLiteralProperties_req\">AddLiteralProperties_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=AddLiteralProperties_resp\">AddLiteralProperties_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=AddLiteralProperty&inbean=AddLiteralProperty_req&outbean=AddLiteralProperty_resp\">AddLiteralProperty</A> (input : <A HREF=\""+serviceURL+"?showFrame=AddLiteralProperty_req\">AddLiteralProperty_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=AddLiteralProperty_resp\">AddLiteralProperty_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=AddObjectProperties&inbean=AddObjectProperties_req&outbean=AddObjectProperties_resp\">AddObjectProperties</A> (input : <A HREF=\""+serviceURL+"?showFrame=AddObjectProperties_req\">AddObjectProperties_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=AddObjectProperties_resp\">AddObjectProperties_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=AddObjectProperty&inbean=AddObjectProperty_req&outbean=AddObjectProperty_resp\">AddObjectProperty</A> (input : <A HREF=\""+serviceURL+"?showFrame=AddObjectProperty_req\">AddObjectProperty_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=AddObjectProperty_resp\">AddObjectProperty_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=CreateAnonymousResource&inbean=CreateAnonymousResource_req&outbean=CreateAnonymousResource_resp\">CreateAnonymousResource</A> (input : <A HREF=\""+serviceURL+"?showFrame=CreateAnonymousResource_req\">CreateAnonymousResource_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=CreateAnonymousResource_resp\">CreateAnonymousResource_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=CreateProperty&inbean=CreateProperty_req&outbean=CreateProperty_resp\">CreateProperty</A> (input : <A HREF=\""+serviceURL+"?showFrame=CreateProperty_req\">CreateProperty_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=CreateProperty_resp\">CreateProperty_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=CreateResource&inbean=CreateResource_req&outbean=CreateResource_resp\">CreateResource</A> (input : <A HREF=\""+serviceURL+"?showFrame=CreateResource_req\">CreateResource_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=CreateResource_resp\">CreateResource_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=RemoveProperty&inbean=RemoveProperty_req&outbean=RemoveProperty_resp\">RemoveProperty</A> (input : <A HREF=\""+serviceURL+"?showFrame=RemoveProperty_req\">RemoveProperty_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=RemoveProperty_resp\">RemoveProperty_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=Save&inbean=Save_req&outbean=Save_resp\">Save</A> (input : <A HREF=\""+serviceURL+"?showFrame=Save_req\">Save_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=Save_resp\">Save_resp</A>)");
                writer.write("</LI>");
                writer.println("</OL>");
                writer.write("<HR>");
                writer.println("Pulse en <a href=\""+serviceURL+"?wsdl\">WSDL<a> para obtener la descripción del servicio");
	    		writer.write("</BODY>");
	    		writer.write("</HTML>");
	    	}


    }
    
    // Rutina para obtener una clase de un bean
    private static Class getBeanClass(String classname) {
		// Si el inbean ya tiene package, retornarlo
		if (classname.indexOf('.') >= 0) {
		    try {
   			    return Class.forName(classname);
   			} catch (Exception e) {
   			    // seguir
   			}
		}
		// Buscar algún import que coincida el nombre de la clase
        if ("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.CreateResource_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.CreateResource_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.CreateResource_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.CreateResource_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.Save_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.Save_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.feed.beans.Save_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.feed.beans.Save_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
		// Buscar algún import con * y probar a instanciar dinámicamente
		if ("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperties_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.AddLiteralProperty_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperties_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.AddObjectProperty_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.CreateAnonymousResource_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.CreateProperty_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.CreateResource_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.CreateResource_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.CreateResource_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.CreateResource_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.RemoveProperty_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.Save_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.Save_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.feed.beans.Save_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.feed.beans.Save_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
        // No se ha podido instanciar
		return null;    
    }



}