




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoSearchAPI
// Versi�n  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.search.service;


import javax.servlet.*;
import javax.servlet.http.*;


import tdi.xml.parser.TdiXmlNode;
import tdi.xml.parser.TdiXmlParser;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
import es.tid.frawa.service.servlet.SOAPUtils;
import es.tid.frawa.service.servlet.TdiServiceException;
import es.tid.serial.TdiBean;


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
 * Servlet controlador del servicio SOAP: QualiPSoSearchAPI
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoSearchAPISoapController extends HttpServlet {



    /*
     * Rutina vac�a. Para implementar opcionalmente en la clase derivada
     */
    protected void frawaInit() throws Exception {
    }
    
    /*
     * Rutina vac�a. Para implementar opcionalmente en la clase derivada
     */
    protected void frawaDestroy() {
    }
    
    /*
     * Rutina vac�a. Para implementar opcionalmente en la clase derivada. Retornar false para abortar la petici�n
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

        // Comprobar si alg�n filtro necesita el mensaje SOAP
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
            // No se crea una sesi�n (esta opci�n est� desmarcada en el modelo de servicios)

            
            // Invocar el m�todo startService() de los filtros
            for (int i = 0;i < filters.length;i++) {
                filters[i].startService(request,response);
            }
            
            // Invocar el m�todo frawaService() de la clase derivada (si est� implementado)
            if (!frawaService(request,response)) {
                // Ha retornado false, por tanto abortamos el procesamiento del servicio
                return;
            }


            StringBuffer soapStr = new StringBuffer("Mensaje SOAP no disponible. Retornar true en needsParseCallbacks() del filtro");


			// Leer el mensaje SOAP
			
            if (request.getParameter("SOAP") != null && request.getParameter("SOAP").length() > 0) {
                String tmp = request.getParameter("SOAP");
                if (tmp == null || tmp.length() == 0) {
                    throw new Exception(getClass().getName()+".service() SOAPAction viene en la URL pero no viene el par�metro SOAP con los datos");
                }
                soapStr = new StringBuffer(tmp);
                input = new BufferedReader(new StringReader(soapStr.toString()));
            } else if (needSOAP) {
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace("Leyendo mensaje SOAP para enviarlo a los filtros. ATENCI�N: Esto puede ser ineficiente");
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(getClass().getName()+".service() Leyendo mensaje SOAP para enviarlo a los filtros. ATENCI�N: Esto puede ser ineficiente");
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
            
            // Invocar el m�todo beforeParse() de los filtros
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
            // Invocar al servicio adecuado en funci�n del nodo ra�z del mensaje SOAP
            //
            

            if (payloadNode.getTag().equals("BuildSPARQLQuery")) {

                // SERVICIO: BuildSPARQLQuery


                // Par�metro de entrada al servicio
                org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req inbean = new org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("ExecQuery_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp outbean = new org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp();
                    
                // Crear un objeto que implementa la operaci�n
                BuildSPARQLQueryService serviceImplementation = new BuildSPARQLQueryService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: BuildSPARQLQuery]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<BuildSPARQLQueryResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<BuildSPARQLQuery_resp>");
                if (needSOAP) {
                    soapWriter.write("<BuildSPARQLQueryResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<BuildSPARQLQuery_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</BuildSPARQLQuery_resp>");
                output.println("</BuildSPARQLQueryResponse>");
                if (needSOAP) {
                   	soapWriter.write("</BuildSPARQLQuery_resp>");
                    soapWriter.write("</BuildSPARQLQueryResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("BuildSPARQLSearch")) {

                // SERVICIO: BuildSPARQLSearch


                // Par�metro de entrada al servicio
                org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req inbean = new org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("ExecSearch_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp outbean = new org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp();
                    
                // Crear un objeto que implementa la operaci�n
                BuildSPARQLSearchService serviceImplementation = new BuildSPARQLSearchService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: BuildSPARQLSearch]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<BuildSPARQLSearchResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<BuildSPARQLSearch_resp>");
                if (needSOAP) {
                    soapWriter.write("<BuildSPARQLSearchResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<BuildSPARQLSearch_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</BuildSPARQLSearch_resp>");
                output.println("</BuildSPARQLSearchResponse>");
                if (needSOAP) {
                   	soapWriter.write("</BuildSPARQLSearch_resp>");
                    soapWriter.write("</BuildSPARQLSearchResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("ExecAsk")) {

                // SERVICIO: ExecAsk


                // Par�metro de entrada al servicio
                ExecAsk_req inbean = new ExecAsk_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("ExecAsk_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                ExecAsk_resp outbean = new ExecAsk_resp();
                    
                // Crear un objeto que implementa la operaci�n
                ExecAskService serviceImplementation = new ExecAskService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: ExecAsk]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<ExecAskResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<ExecAsk_resp>");
                if (needSOAP) {
                    soapWriter.write("<ExecAskResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<ExecAsk_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</ExecAsk_resp>");
                output.println("</ExecAskResponse>");
                if (needSOAP) {
                   	soapWriter.write("</ExecAsk_resp>");
                    soapWriter.write("</ExecAskResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("ExecConstructAndSearch")) {

                // SERVICIO: ExecConstructAndSearch


                // Par�metro de entrada al servicio
                ExecConstructAndSearch_req inbean = new ExecConstructAndSearch_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("ExecConstructAndSearch_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                ExecConstructAndSearch_resp outbean = new ExecConstructAndSearch_resp();
                    
                // Crear un objeto que implementa la operaci�n
                MappedSearchService serviceImplementation = new MappedSearchService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: ExecConstructAndSearch]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<ExecConstructAndSearchResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<ExecConstructAndSearch_resp>");
                if (needSOAP) {
                    soapWriter.write("<ExecConstructAndSearchResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<ExecConstructAndSearch_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</ExecConstructAndSearch_resp>");
                output.println("</ExecConstructAndSearchResponse>");
                if (needSOAP) {
                   	soapWriter.write("</ExecConstructAndSearch_resp>");
                    soapWriter.write("</ExecConstructAndSearchResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("ExecQuery")) {

                // SERVICIO: ExecQuery


                // Par�metro de entrada al servicio
                ExecQuery_req inbean = new ExecQuery_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("ExecQuery_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                ExecQuery_resp outbean = new ExecQuery_resp();
                    
                // Crear un objeto que implementa la operaci�n
                ExecQueryService serviceImplementation = new ExecQueryService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: ExecQuery]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<ExecQueryResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<ExecQuery_resp>");
                if (needSOAP) {
                    soapWriter.write("<ExecQueryResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<ExecQuery_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</ExecQuery_resp>");
                output.println("</ExecQueryResponse>");
                if (needSOAP) {
                   	soapWriter.write("</ExecQuery_resp>");
                    soapWriter.write("</ExecQueryResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("ExecSPARQL")) {

                // SERVICIO: ExecSPARQL


                // Par�metro de entrada al servicio
                ExecSPARQL_req inbean = new ExecSPARQL_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("ExecSPARQL_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                ExecSPARQL_resp outbean = new ExecSPARQL_resp();
                    
                // Crear un objeto que implementa la operaci�n
                ExecSPARQLService serviceImplementation = new ExecSPARQLService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: ExecSPARQL]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<ExecSPARQLResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<ExecSPARQL_resp>");
                if (needSOAP) {
                    soapWriter.write("<ExecSPARQLResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<ExecSPARQL_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</ExecSPARQL_resp>");
                output.println("</ExecSPARQLResponse>");
                if (needSOAP) {
                   	soapWriter.write("</ExecSPARQL_resp>");
                    soapWriter.write("</ExecSPARQLResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("ExecSearch")) {

                // SERVICIO: ExecSearch


                // Par�metro de entrada al servicio
                ExecSearch_req inbean = new ExecSearch_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("ExecSearch_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                ExecSearch_resp outbean = new ExecSearch_resp();
                    
                // Crear un objeto que implementa la operaci�n
                ExecSearchService serviceImplementation = new ExecSearchService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: ExecSearch]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<ExecSearchResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<ExecSearch_resp>");
                if (needSOAP) {
                    soapWriter.write("<ExecSearchResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<ExecSearch_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</ExecSearch_resp>");
                output.println("</ExecSearchResponse>");
                if (needSOAP) {
                   	soapWriter.write("</ExecSearch_resp>");
                    soapWriter.write("</ExecSearchResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("ExecSimpleTextSearch")) {

                // SERVICIO: ExecSimpleTextSearch


                // Par�metro de entrada al servicio
                ExecSimpleTextSearch_req inbean = new ExecSimpleTextSearch_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("ExecSimpleTextSearch_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                ExecSimpleTextSearch_resp outbean = new ExecSimpleTextSearch_resp();
                    
                // Crear un objeto que implementa la operaci�n
                ExecSimpleTextSearchService serviceImplementation = new ExecSimpleTextSearchService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: ExecSimpleTextSearch]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<ExecSimpleTextSearchResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<ExecSimpleTextSearch_resp>");
                if (needSOAP) {
                    soapWriter.write("<ExecSimpleTextSearchResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<ExecSimpleTextSearch_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</ExecSimpleTextSearch_resp>");
                output.println("</ExecSimpleTextSearchResponse>");
                if (needSOAP) {
                   	soapWriter.write("</ExecSimpleTextSearch_resp>");
                    soapWriter.write("</ExecSimpleTextSearchResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("GetSearchSize")) {

                // SERVICIO: GetSearchSize


                // Par�metro de entrada al servicio
                GetSearchSize_req inbean = new GetSearchSize_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetSearchSize_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                GetSearchSize_resp outbean = new GetSearchSize_resp();
                    
                // Crear un objeto que implementa la operaci�n
                GetSearchSizeService serviceImplementation = new GetSearchSizeService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetSearchSize]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<GetSearchSizeResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<GetSearchSize_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetSearchSizeResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<GetSearchSize_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetSearchSize_resp>");
                output.println("</GetSearchSizeResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetSearchSize_resp>");
                    soapWriter.write("</GetSearchSizeResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (payloadNode.getTag().equals("ReIndex")) {

                // SERVICIO: ReIndex


                // Par�metro de entrada al servicio
                ReIndex_req inbean = new ReIndex_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("ReIndex_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoSearchAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                ReIndex_resp outbean = new ReIndex_resp();
                    
                // Crear un objeto que implementa la operaci�n
                ReIndexService serviceImplementation = new ReIndexService();
                    
                // Invocar la implementaci�n de la operaci�n
                Throwable applicationException = serviceImplementation.executeImpl(this,request,response,inbean,outbean);
                    
                // Si ha ocurrido una excepci�n, enviarla al cliente
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: ReIndex]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoSearchAPI",payloadNode.getTag());
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
                output.println("<ReIndexResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                output.println("<ReIndex_resp>");
                if (needSOAP) {
                    soapWriter.write("<ReIndexResponse xmlns=\"http://www.qualipso.org/advdoc/ws/search\">");
                   	soapWriter.write("<ReIndex_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</ReIndex_resp>");
                output.println("</ReIndexResponse>");
                if (needSOAP) {
                   	soapWriter.write("</ReIndex_resp>");
                    soapWriter.write("</ReIndexResponse>");
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


                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,soapStr.toString());
                }


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }


                
            } else {
            	
                throw new Exception(getClass().getName() + ".service() Operaci�n "+payloadNode.getTag()+" no v�lida");
                
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


            // Invocar el m�todo onException() de los filtros
            for (int i = 0;i < filters.length;i++) {
                filters[i].onException(request,response,t,"QualiPSoSearchAPI",payloadNode.getTag());
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


            // Invocar el m�todo onFinally() de los filtros
            for (int i = 0;i < filters.length;i++) {
                filters[i].onFinally(request,response,"QualiPSoSearchAPI",payloadNode.getTag());
            }


        }


    }



    /*
     * Inicializaci�n del servlet
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
     * Destrucci�n del servlet
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
     * Env�o de error SOAP al cliente
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
                "                  xmlns:tns=\"http://www.qualipso.org/advdoc/ws/search\"",
                "                  xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"",
                "                  xmlns:http=\"http://schemas.xmlsoap.org/wsdl/http/\"",
                "                  xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"",
                "                  targetNamespace=\"http://www.qualipso.org/advdoc/ws/search\">",
                "    <wsdl:types>",
                "        <xs:schema elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:tns=\"http://www.qualipso.org/advdoc/ws/search\" targetNamespace=\"http://www.qualipso.org/advdoc/ws/search\">",
                "",
                "            <xs:element name=\"TextSearchCondition\" type=\"tns:TextSearchCondition\"/>",
                "            <xs:complexType name=\"TextSearchCondition\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"textSearch\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"variable\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ReIndex_resp\" type=\"tns:ReIndex_resp\"/>",
                "            <xs:complexType name=\"ReIndex_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"time\" type=\"xs:double\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ReIndex_req\" type=\"tns:ReIndex_req\"/>",
                "            <xs:complexType name=\"ReIndex_req\">",
                "                <xs:sequence>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"OptionalConditionGroup\" type=\"tns:OptionalConditionGroup\"/>",
                "            <xs:complexType name=\"OptionalConditionGroup\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"optionalCondition\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"Node\" type=\"tns:Node\"/>",
                "            <xs:complexType name=\"Node\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"isLiteral\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"value\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"Namespace\" type=\"tns:Namespace\"/>",
                "            <xs:complexType name=\"Namespace\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"namespace\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"prefix\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSearchSize_resp\" type=\"tns:GetSearchSize_resp\"/>",
                "            <xs:complexType name=\"GetSearchSize_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"searchText\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"size\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSearchSize_req\" type=\"tns:GetSearchSize_req\"/>",
                "            <xs:complexType name=\"GetSearchSize_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"searchText\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecSimpleTextSearch_req\" type=\"tns:ExecSimpleTextSearch_req\"/>",
                "            <xs:complexType name=\"ExecSimpleTextSearch_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"textSearch\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecSPARQL_req\" type=\"tns:ExecSPARQL_req\"/>",
                "            <xs:complexType name=\"ExecSPARQL_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"sparql\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecQuery_req\" type=\"tns:ExecQuery_req\"/>",
                "            <xs:complexType name=\"ExecQuery_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"baseNamespace\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"distinct\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"limit\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"offset\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"orderBy\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"conditions\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"namespaces\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"Namespace\" nillable=\"false\" type=\"tns:Namespace\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"optionalConditions\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"OptionalConditionGroup\" nillable=\"false\" type=\"tns:OptionalConditionGroup\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"variables\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecConstructAndSearch_req\" type=\"tns:ExecConstructAndSearch_req\"/>",
                "            <xs:complexType name=\"ExecConstructAndSearch_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"construct\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"sparql\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecAsk_resp\" type=\"tns:ExecAsk_resp\"/>",
                "            <xs:complexType name=\"ExecAsk_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"result\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"BuildSPARQLSearch_resp\" type=\"tns:BuildSPARQLSearch_resp\"/>",
                "            <xs:complexType name=\"BuildSPARQLSearch_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"sparql\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"BuildSPARQLQuery_resp\" type=\"tns:BuildSPARQLQuery_resp\"/>",
                "            <xs:complexType name=\"BuildSPARQLQuery_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"sparql\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"Row\" type=\"tns:Row\"/>",
                "            <xs:complexType name=\"Row\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"nodes\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"Node\" nillable=\"false\" type=\"tns:Node\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecSearch_req\" type=\"tns:ExecSearch_req\"/>",
                "            <xs:complexType name=\"ExecSearch_req\">",
                "                <xs:complexContent mixed=\"false\">",
                "                    <xs:extension base=\"tns:ExecQuery_req\">",
                "                        <xs:sequence>",
                "                            <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"textConditions\">",
                "                                <xs:complexType>",
                "                                    <xs:sequence>",
                "                                        <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"TextSearchCondition\" nillable=\"false\" type=\"tns:TextSearchCondition\"/>",
                "                                    </xs:sequence>",
                "                                </xs:complexType>",
                "                            </xs:element>",
                "                        </xs:sequence>",
                "                    </xs:extension>",
                "                </xs:complexContent>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecAsk_req\" type=\"tns:ExecAsk_req\"/>",
                "            <xs:complexType name=\"ExecAsk_req\">",
                "                <xs:complexContent mixed=\"false\">",
                "                    <xs:extension base=\"tns:ExecSearch_req\">",
                "                        <xs:sequence>",
                "                        </xs:sequence>",
                "                    </xs:extension>",
                "                </xs:complexContent>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"SPARQLResult\" type=\"tns:SPARQLResult\"/>",
                "            <xs:complexType name=\"SPARQLResult\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"columns\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"rows\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"Row\" nillable=\"false\" type=\"tns:Row\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecQuery_resp\" type=\"tns:ExecQuery_resp\"/>",
                "            <xs:complexType name=\"ExecQuery_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"result\" type=\"tns:SPARQLResult\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"sparql\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"time\" type=\"xs:double\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecConstructAndSearch_resp\" type=\"tns:ExecConstructAndSearch_resp\"/>",
                "            <xs:complexType name=\"ExecConstructAndSearch_resp\">",
                "                <xs:complexContent mixed=\"false\">",
                "                    <xs:extension base=\"tns:ExecQuery_resp\">",
                "                        <xs:sequence>",
                "                        </xs:sequence>",
                "                    </xs:extension>",
                "                </xs:complexContent>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecSimpleTextSearch_resp\" type=\"tns:ExecSimpleTextSearch_resp\"/>",
                "            <xs:complexType name=\"ExecSimpleTextSearch_resp\">",
                "                <xs:complexContent mixed=\"false\">",
                "                    <xs:extension base=\"tns:ExecQuery_resp\">",
                "                        <xs:sequence>",
                "                        </xs:sequence>",
                "                    </xs:extension>",
                "                </xs:complexContent>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecSearch_resp\" type=\"tns:ExecSearch_resp\"/>",
                "            <xs:complexType name=\"ExecSearch_resp\">",
                "                <xs:complexContent mixed=\"false\">",
                "                    <xs:extension base=\"tns:ExecQuery_resp\">",
                "                        <xs:sequence>",
                "                        </xs:sequence>",
                "                    </xs:extension>",
                "                </xs:complexContent>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ExecSPARQL_resp\" type=\"tns:ExecSPARQL_resp\"/>",
                "            <xs:complexType name=\"ExecSPARQL_resp\">",
                "                <xs:complexContent mixed=\"false\">",
                "                    <xs:extension base=\"tns:ExecQuery_resp\">",
                "                        <xs:sequence>",
                "                        </xs:sequence>",
                "                    </xs:extension>",
                "                </xs:complexContent>",
                "            </xs:complexType>",
                "            <!-- Elementos para las operaciones -->",
                "            <xs:element name=\"BuildSPARQLQuery\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecQuery_req\" type=\"tns:ExecQuery_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"BuildSPARQLQueryResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"BuildSPARQLQuery_resp\" type=\"tns:BuildSPARQLQuery_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"BuildSPARQLSearch\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecSearch_req\" type=\"tns:ExecSearch_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"BuildSPARQLSearchResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"BuildSPARQLSearch_resp\" type=\"tns:BuildSPARQLSearch_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecAsk\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecAsk_req\" type=\"tns:ExecAsk_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecAskResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecAsk_resp\" type=\"tns:ExecAsk_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecConstructAndSearch\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecConstructAndSearch_req\" type=\"tns:ExecConstructAndSearch_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecConstructAndSearchResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecConstructAndSearch_resp\" type=\"tns:ExecConstructAndSearch_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecQuery\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecQuery_req\" type=\"tns:ExecQuery_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecQueryResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecQuery_resp\" type=\"tns:ExecQuery_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecSPARQL\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecSPARQL_req\" type=\"tns:ExecSPARQL_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecSPARQLResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecSPARQL_resp\" type=\"tns:ExecSPARQL_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecSearch\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecSearch_req\" type=\"tns:ExecSearch_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecSearchResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecSearch_resp\" type=\"tns:ExecSearch_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecSimpleTextSearch\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecSimpleTextSearch_req\" type=\"tns:ExecSimpleTextSearch_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ExecSimpleTextSearchResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ExecSimpleTextSearch_resp\" type=\"tns:ExecSimpleTextSearch_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSearchSize\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSearchSize_req\" type=\"tns:GetSearchSize_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSearchSizeResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSearchSize_resp\" type=\"tns:GetSearchSize_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ReIndex\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ReIndex_req\" type=\"tns:ReIndex_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"ReIndexResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"ReIndex_resp\" type=\"tns:ReIndex_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "        </xs:schema>",
                "    </wsdl:types>",
                "    <wsdl:message name=\"BuildSPARQLQuerySoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:BuildSPARQLQuery\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"BuildSPARQLQuerySoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:BuildSPARQLQueryResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"BuildSPARQLSearchSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:BuildSPARQLSearch\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"BuildSPARQLSearchSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:BuildSPARQLSearchResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecAskSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecAsk\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecAskSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecAskResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecConstructAndSearchSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecConstructAndSearch\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecConstructAndSearchSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecConstructAndSearchResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecQuerySoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecQuery\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecQuerySoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecQueryResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecSPARQLSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecSPARQL\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecSPARQLSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecSPARQLResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecSearchSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecSearch\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecSearchSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecSearchResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecSimpleTextSearchSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecSimpleTextSearch\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ExecSimpleTextSearchSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ExecSimpleTextSearchResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSearchSizeSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSearchSize\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSearchSizeSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSearchSizeResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ReIndexSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ReIndex\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"ReIndexSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:ReIndexResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:portType name=\"QualiPSoSearchAPISoapPortType\">",
                "        <wsdl:operation name=\"BuildSPARQLQuery\">",
                "            <wsdl:documentation>Build a SPARQL query string from query components</wsdl:documentation>",
                "            <wsdl:input message=\"tns:BuildSPARQLQuerySoapIn\"/>",
                "            <wsdl:output message=\"tns:BuildSPARQLQuerySoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"BuildSPARQLSearch\">",
                "            <wsdl:documentation>Build a SPARQL query string from query components (including text search)</wsdl:documentation>",
                "            <wsdl:input message=\"tns:BuildSPARQLSearchSoapIn\"/>",
                "            <wsdl:output message=\"tns:BuildSPARQLSearchSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecAsk\">",
                "            <wsdl:input message=\"tns:ExecAskSoapIn\"/>",
                "            <wsdl:output message=\"tns:ExecAskSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecConstructAndSearch\">",
                "            <wsdl:input message=\"tns:ExecConstructAndSearchSoapIn\"/>",
                "            <wsdl:output message=\"tns:ExecConstructAndSearchSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecQuery\">",
                "            <wsdl:documentation>Execute a query on RDF model. It builds the SPARQL sentence from parameters</wsdl:documentation>",
                "            <wsdl:input message=\"tns:ExecQuerySoapIn\"/>",
                "            <wsdl:output message=\"tns:ExecQuerySoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecSPARQL\">",
                "            <wsdl:documentation>Execute any SPARQL query on model</wsdl:documentation>",
                "            <wsdl:input message=\"tns:ExecSPARQLSoapIn\"/>",
                "            <wsdl:output message=\"tns:ExecSPARQLSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecSearch\">",
                "            <wsdl:documentation>xecute a query on RDF model (it can include text search). It builds the SPARQL sentence from parameters</wsdl:documentation>",
                "            <wsdl:input message=\"tns:ExecSearchSoapIn\"/>",
                "            <wsdl:output message=\"tns:ExecSearchSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecSimpleTextSearch\">",
                "            <wsdl:documentation>Search RDF statements with text</wsdl:documentation>",
                "            <wsdl:input message=\"tns:ExecSimpleTextSearchSoapIn\"/>",
                "            <wsdl:output message=\"tns:ExecSimpleTextSearchSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSearchSize\">",
                "            <wsdl:documentation>Get the number of result of a search</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetSearchSizeSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetSearchSizeSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ReIndex\">",
                "            <wsdl:documentation>Regenerate Lucene indexes</wsdl:documentation>",
                "            <wsdl:input message=\"tns:ReIndexSoapIn\"/>",
                "            <wsdl:output message=\"tns:ReIndexSoapOut\"/>",
                "        </wsdl:operation>",
                "    </wsdl:portType>",
                "    <wsdl:binding name=\"QualiPSoSearchAPISoapBinding\" type=\"tns:QualiPSoSearchAPISoapPortType\">",
                "        <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>",
                "        <wsdl:operation name=\"BuildSPARQLQuery\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/BuildSPARQLQuery\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"BuildSPARQLSearch\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/BuildSPARQLSearch\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecAsk\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/ExecAsk\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecConstructAndSearch\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/ExecConstructAndSearch\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecQuery\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/ExecQuery\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecSPARQL\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/ExecSPARQL\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecSearch\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/ExecSearch\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ExecSimpleTextSearch\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/ExecSimpleTextSearch\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSearchSize\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/GetSearchSize\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"ReIndex\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/search/ReIndex\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "    </wsdl:binding>",
                "    <wsdl:service name=\"QualiPSoSearchAPI\">",
                "        <wsdl:port name=\"QualiPSoSearchAPISoapPort\" binding=\"tns:QualiPSoSearchAPISoapBinding\">",
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
	    		    writer.write("<FORM name=\"formSOAP\" action=\""+serviceURL+"?SOAPAction=http://www.qualipso.org/advdoc/ws/search/"+showMethod+"\" method=\"post\">");
	    		    writer.write("<TEXTAREA name=\"SOAP\" type=\"text\" rows=\"20\" cols=\"100\"></TEXTAREA>");
	    		    writer.write("<INPUT type=\"submit\" name=\"Invocar operaci�n\"></INPUT>");
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
	    		writer.write("<TITLE>QualiPSoSearchAPI</TITLE>");
	    		writer.write("</HEAD>");
	    		writer.write("<BODY>");
                writer.println("<H2>Servicio Web <B>QualiPSoSearchAPI</B></H2><P/>");
                writer.println("OPERACIONES<P/>");
                writer.println("<OL>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=BuildSPARQLQuery&inbean=org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req&outbean=org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp\">BuildSPARQLQuery</A> (input : <A HREF=\""+serviceURL+"?showFrame=org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req\">ExecQuery_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp\">BuildSPARQLQuery_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=BuildSPARQLSearch&inbean=org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req&outbean=org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp\">BuildSPARQLSearch</A> (input : <A HREF=\""+serviceURL+"?showFrame=org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req\">ExecSearch_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp\">BuildSPARQLSearch_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=ExecAsk&inbean=ExecAsk_req&outbean=ExecAsk_resp\">ExecAsk</A> (input : <A HREF=\""+serviceURL+"?showFrame=ExecAsk_req\">ExecAsk_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=ExecAsk_resp\">ExecAsk_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=ExecConstructAndSearch&inbean=ExecConstructAndSearch_req&outbean=ExecConstructAndSearch_resp\">ExecConstructAndSearch</A> (input : <A HREF=\""+serviceURL+"?showFrame=ExecConstructAndSearch_req\">ExecConstructAndSearch_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=ExecConstructAndSearch_resp\">ExecConstructAndSearch_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=ExecQuery&inbean=ExecQuery_req&outbean=ExecQuery_resp\">ExecQuery</A> (input : <A HREF=\""+serviceURL+"?showFrame=ExecQuery_req\">ExecQuery_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=ExecQuery_resp\">ExecQuery_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=ExecSPARQL&inbean=ExecSPARQL_req&outbean=ExecSPARQL_resp\">ExecSPARQL</A> (input : <A HREF=\""+serviceURL+"?showFrame=ExecSPARQL_req\">ExecSPARQL_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=ExecSPARQL_resp\">ExecSPARQL_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=ExecSearch&inbean=ExecSearch_req&outbean=ExecSearch_resp\">ExecSearch</A> (input : <A HREF=\""+serviceURL+"?showFrame=ExecSearch_req\">ExecSearch_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=ExecSearch_resp\">ExecSearch_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=ExecSimpleTextSearch&inbean=ExecSimpleTextSearch_req&outbean=ExecSimpleTextSearch_resp\">ExecSimpleTextSearch</A> (input : <A HREF=\""+serviceURL+"?showFrame=ExecSimpleTextSearch_req\">ExecSimpleTextSearch_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=ExecSimpleTextSearch_resp\">ExecSimpleTextSearch_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetSearchSize&inbean=GetSearchSize_req&outbean=GetSearchSize_resp\">GetSearchSize</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetSearchSize_req\">GetSearchSize_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetSearchSize_resp\">GetSearchSize_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=ReIndex&inbean=ReIndex_req&outbean=ReIndex_resp\">ReIndex</A> (input : <A HREF=\""+serviceURL+"?showFrame=ReIndex_req\">ReIndex_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=ReIndex_resp\">ReIndex_resp</A>)");
                writer.write("</LI>");
                writer.println("</OL>");
                writer.write("<HR>");
                writer.println("Pulse en <a href=\""+serviceURL+"?wsdl\">WSDL<a> para obtener la descripci�n del servicio");
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
		// Buscar alg�n import que coincida el nombre de la clase
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecAsk_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecAsk_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecAsk_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecAsk_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ReIndex_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ReIndex_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.search.beans.ReIndex_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.search.beans.ReIndex_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
		// Buscar alg�n import con * y probar a instanciar din�micamente
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLQuery_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.BuildSPARQLSearch_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecAsk_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecAsk_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecAsk_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecAsk_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecConstructAndSearch_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecQuery_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecSPARQL_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecSearch_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ExecSimpleTextSearch_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.GetSearchSize_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ReIndex_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ReIndex_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.search.beans.ReIndex_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.search.beans.ReIndex_resp","*",classname);
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