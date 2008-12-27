




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoRetrievalAPI
// Versión  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.retrieval.service;


import javax.servlet.*;
import javax.servlet.http.*;


import tdi.xml.parser.TdiXmlNode;
import tdi.xml.parser.TdiXmlParser;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
import es.tid.frawa.service.servlet.SOAPUtils;
import es.tid.frawa.service.servlet.TdiServiceException;
import es.tid.serial.TdiBean;


import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_resp;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_resp;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_resp;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_resp;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_req;
import org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_resp;



/**
 * Servlet controlador del servicio SOAP: QualiPSoRetrievalAPI
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoRetrievalAPISoapController extends HttpServlet {



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
            

            if (payloadNode.getTag().equals("GetResourceProperties")) {

                // SERVICIO: GetResourceProperties


                // Parámetro de entrada al servicio
                GetResourceProperties_req inbean = new GetResourceProperties_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetResourceProperties_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetResourceProperties_resp outbean = new GetResourceProperties_resp();
                    
                // Crear un objeto que implementa la operación
                GetResourcePropertiesService serviceImplementation = new GetResourcePropertiesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetResourceProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
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
                output.println("<GetResourcePropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                output.println("<GetResourceProperties_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetResourcePropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                   	soapWriter.write("<GetResourceProperties_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetResourceProperties_resp>");
                output.println("</GetResourcePropertiesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetResourceProperties_resp>");
                    soapWriter.write("</GetResourcePropertiesResponse>");
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



            } else if (payloadNode.getTag().equals("GetResourceProperty")) {

                // SERVICIO: GetResourceProperty


                // Parámetro de entrada al servicio
                GetResourceProperty_req inbean = new GetResourceProperty_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetResourceProperty_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetResourceProperty_resp outbean = new GetResourceProperty_resp();
                    
                // Crear un objeto que implementa la operación
                GetResourcePropertyService serviceImplementation = new GetResourcePropertyService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetResourceProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
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
                output.println("<GetResourcePropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                output.println("<GetResourceProperty_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetResourcePropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                   	soapWriter.write("<GetResourceProperty_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetResourceProperty_resp>");
                output.println("</GetResourcePropertyResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetResourceProperty_resp>");
                    soapWriter.write("</GetResourcePropertyResponse>");
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



            } else if (payloadNode.getTag().equals("GetResourcesByType")) {

                // SERVICIO: GetResourcesByType


                // Parámetro de entrada al servicio
                GetResourcesByType_req inbean = new GetResourcesByType_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetResourcesByType_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetResourcesByType_resp outbean = new GetResourcesByType_resp();
                    
                // Crear un objeto que implementa la operación
                GetResourcesByTypeService serviceImplementation = new GetResourcesByTypeService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetResourcesByType]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
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
                output.println("<GetResourcesByTypeResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                output.println("<GetResourcesByType_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetResourcesByTypeResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                   	soapWriter.write("<GetResourcesByType_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetResourcesByType_resp>");
                output.println("</GetResourcesByTypeResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetResourcesByType_resp>");
                    soapWriter.write("</GetResourcesByTypeResponse>");
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



            } else if (payloadNode.getTag().equals("GetResourcesWithProperty")) {

                // SERVICIO: GetResourcesWithProperty


                // Parámetro de entrada al servicio
                GetResourcesWithProperty_req inbean = new GetResourcesWithProperty_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetResourcesWithProperty_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetResourcesWithProperty_resp outbean = new GetResourcesWithProperty_resp();
                    
                // Crear un objeto que implementa la operación
                GetResourcesWithPropertyService serviceImplementation = new GetResourcesWithPropertyService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetResourcesWithProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
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
                output.println("<GetResourcesWithPropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                output.println("<GetResourcesWithProperty_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetResourcesWithPropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                   	soapWriter.write("<GetResourcesWithProperty_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetResourcesWithProperty_resp>");
                output.println("</GetResourcesWithPropertyResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetResourcesWithProperty_resp>");
                    soapWriter.write("</GetResourcesWithPropertyResponse>");
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



            } else if (payloadNode.getTag().equals("GetResourcesWithPropertyValue")) {

                // SERVICIO: GetResourcesWithPropertyValue


                // Parámetro de entrada al servicio
                GetResourcesWithPropertyValue_req inbean = new GetResourcesWithPropertyValue_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetResourcesWithPropertyValue_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetResourcesWithPropertyValue_resp outbean = new GetResourcesWithPropertyValue_resp();
                    
                // Crear un objeto que implementa la operación
                GetResourcesWithPropertyValueService serviceImplementation = new GetResourcesWithPropertyValueService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetResourcesWithPropertyValue]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",payloadNode.getTag());
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
                output.println("<GetResourcesWithPropertyValueResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                output.println("<GetResourcesWithPropertyValue_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetResourcesWithPropertyValueResponse xmlns=\"http://www.qualipso.org/advdoc/ws/retrieval\">");
                   	soapWriter.write("<GetResourcesWithPropertyValue_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetResourcesWithPropertyValue_resp>");
                output.println("</GetResourcesWithPropertyValueResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetResourcesWithPropertyValue_resp>");
                    soapWriter.write("</GetResourcesWithPropertyValueResponse>");
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
                filters[i].onException(request,response,t,"QualiPSoRetrievalAPI",payloadNode.getTag());
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
                filters[i].onFinally(request,response,"QualiPSoRetrievalAPI",payloadNode.getTag());
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
                "                  xmlns:tns=\"http://www.qualipso.org/advdoc/ws/retrieval\"",
                "                  xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"",
                "                  xmlns:http=\"http://schemas.xmlsoap.org/wsdl/http/\"",
                "                  xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"",
                "                  targetNamespace=\"http://www.qualipso.org/advdoc/ws/retrieval\">",
                "    <wsdl:types>",
                "        <xs:schema elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:tns=\"http://www.qualipso.org/advdoc/ws/retrieval\" targetNamespace=\"http://www.qualipso.org/advdoc/ws/retrieval\">",
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
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"literal\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetResourcesWithProperty_resp\" type=\"tns:GetResourcesWithProperty_resp\"/>",
                "            <xs:complexType name=\"GetResourcesWithProperty_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourcesUri\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetResourcesWithProperty_req\" type=\"tns:GetResourcesWithProperty_req\"/>",
                "            <xs:complexType name=\"GetResourcesWithProperty_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetResourcesWithPropertyValue_resp\" type=\"tns:GetResourcesWithPropertyValue_resp\"/>",
                "            <xs:complexType name=\"GetResourcesWithPropertyValue_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourcesUri\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetResourcesWithPropertyValue_req\" type=\"tns:GetResourcesWithPropertyValue_req\"/>",
                "            <xs:complexType name=\"GetResourcesWithPropertyValue_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"value\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetResourcesByType_resp\" type=\"tns:GetResourcesByType_resp\"/>",
                "            <xs:complexType name=\"GetResourcesByType_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resources\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetResourcesByType_req\" type=\"tns:GetResourcesByType_req\"/>",
                "            <xs:complexType name=\"GetResourcesByType_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"typeUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetResourceProperty_resp\" type=\"tns:GetResourceProperty_resp\"/>",
                "            <xs:complexType name=\"GetResourceProperty_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"literalProperties\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"LiteralProperty\" nillable=\"false\" type=\"tns:LiteralProperty\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
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
                "            <xs:element name=\"GetResourceProperty_req\" type=\"tns:GetResourceProperty_req\"/>",
                "            <xs:complexType name=\"GetResourceProperty_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetResourceProperties_resp\" type=\"tns:GetResourceProperties_resp\"/>",
                "            <xs:complexType name=\"GetResourceProperties_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"literalProperties\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"LiteralProperty\" nillable=\"false\" type=\"tns:LiteralProperty\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
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
                "            <xs:element name=\"GetResourceProperties_req\" type=\"tns:GetResourceProperties_req\"/>",
                "            <xs:complexType name=\"GetResourceProperties_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"resourceUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "            <!-- Elementos para las operaciones -->",
                "            <xs:element name=\"GetResourceProperties\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourceProperties_req\" type=\"tns:GetResourceProperties_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetResourcePropertiesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourceProperties_resp\" type=\"tns:GetResourceProperties_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetResourceProperty\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourceProperty_req\" type=\"tns:GetResourceProperty_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetResourcePropertyResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourceProperty_resp\" type=\"tns:GetResourceProperty_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetResourcesByType\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourcesByType_req\" type=\"tns:GetResourcesByType_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetResourcesByTypeResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourcesByType_resp\" type=\"tns:GetResourcesByType_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetResourcesWithProperty\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourcesWithProperty_req\" type=\"tns:GetResourcesWithProperty_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetResourcesWithPropertyResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourcesWithProperty_resp\" type=\"tns:GetResourcesWithProperty_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetResourcesWithPropertyValue\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourcesWithPropertyValue_req\" type=\"tns:GetResourcesWithPropertyValue_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetResourcesWithPropertyValueResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetResourcesWithPropertyValue_resp\" type=\"tns:GetResourcesWithPropertyValue_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "        </xs:schema>",
                "    </wsdl:types>",
                "    <wsdl:message name=\"GetResourcePropertiesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourceProperties\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetResourcePropertiesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourcePropertiesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetResourcePropertySoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourceProperty\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetResourcePropertySoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourcePropertyResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetResourcesByTypeSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourcesByType\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetResourcesByTypeSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourcesByTypeResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetResourcesWithPropertySoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourcesWithProperty\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetResourcesWithPropertySoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourcesWithPropertyResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetResourcesWithPropertyValueSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourcesWithPropertyValue\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetResourcesWithPropertyValueSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetResourcesWithPropertyValueResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:portType name=\"QualiPSoRetrievalAPISoapPortType\">",
                "        <wsdl:operation name=\"GetResourceProperties\">",
                "            <wsdl:documentation>Get all properties of a given resource</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetResourcePropertiesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetResourcePropertiesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetResourceProperty\">",
                "            <wsdl:documentation>Get a property of a given resource</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetResourcePropertySoapIn\"/>",
                "            <wsdl:output message=\"tns:GetResourcePropertySoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetResourcesByType\">",
                "            <wsdl:documentation>Get all resources of a given type or class</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetResourcesByTypeSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetResourcesByTypeSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetResourcesWithProperty\">",
                "            <wsdl:documentation>Get all resources with a given property</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetResourcesWithPropertySoapIn\"/>",
                "            <wsdl:output message=\"tns:GetResourcesWithPropertySoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetResourcesWithPropertyValue\">",
                "            <wsdl:documentation>Get resources with a property with a given value</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetResourcesWithPropertyValueSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetResourcesWithPropertyValueSoapOut\"/>",
                "        </wsdl:operation>",
                "    </wsdl:portType>",
                "    <wsdl:binding name=\"QualiPSoRetrievalAPISoapBinding\" type=\"tns:QualiPSoRetrievalAPISoapPortType\">",
                "        <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>",
                "        <wsdl:operation name=\"GetResourceProperties\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/retrieval/GetResourceProperties\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetResourceProperty\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/retrieval/GetResourceProperty\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetResourcesByType\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/retrieval/GetResourcesByType\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetResourcesWithProperty\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/retrieval/GetResourcesWithProperty\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetResourcesWithPropertyValue\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/retrieval/GetResourcesWithPropertyValue\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "    </wsdl:binding>",
                "    <wsdl:service name=\"QualiPSoRetrievalAPI\">",
                "        <wsdl:port name=\"QualiPSoRetrievalAPISoapPort\" binding=\"tns:QualiPSoRetrievalAPISoapBinding\">",
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
	    		    writer.write("<FORM name=\"formSOAP\" action=\""+serviceURL+"?SOAPAction=http://www.qualipso.org/advdoc/ws/retrieval/"+showMethod+"\" method=\"post\">");
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
	    		writer.write("<TITLE>QualiPSoRetrievalAPI</TITLE>");
	    		writer.write("</HEAD>");
	    		writer.write("<BODY>");
                writer.println("<H2>Servicio Web <B>QualiPSoRetrievalAPI</B></H2><P/>");
                writer.println("OPERACIONES<P/>");
                writer.println("<OL>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetResourceProperties&inbean=GetResourceProperties_req&outbean=GetResourceProperties_resp\">GetResourceProperties</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetResourceProperties_req\">GetResourceProperties_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetResourceProperties_resp\">GetResourceProperties_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetResourceProperty&inbean=GetResourceProperty_req&outbean=GetResourceProperty_resp\">GetResourceProperty</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetResourceProperty_req\">GetResourceProperty_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetResourceProperty_resp\">GetResourceProperty_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetResourcesByType&inbean=GetResourcesByType_req&outbean=GetResourcesByType_resp\">GetResourcesByType</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetResourcesByType_req\">GetResourcesByType_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetResourcesByType_resp\">GetResourcesByType_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetResourcesWithProperty&inbean=GetResourcesWithProperty_req&outbean=GetResourcesWithProperty_resp\">GetResourcesWithProperty</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetResourcesWithProperty_req\">GetResourcesWithProperty_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetResourcesWithProperty_resp\">GetResourcesWithProperty_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetResourcesWithPropertyValue&inbean=GetResourcesWithPropertyValue_req&outbean=GetResourcesWithPropertyValue_resp\">GetResourcesWithPropertyValue</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetResourcesWithPropertyValue_req\">GetResourcesWithPropertyValue_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetResourcesWithPropertyValue_resp\">GetResourcesWithPropertyValue_resp</A>)");
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
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
		// Buscar algún import con * y probar a instanciar dinámicamente
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperties_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourceProperty_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesByType_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithProperty_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.retrieval.beans.GetResourcesWithPropertyValue_resp","*",classname);
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