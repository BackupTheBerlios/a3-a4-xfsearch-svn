




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoMetadataAPI
// Versión  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.metadata.service;


import javax.servlet.*;
import javax.servlet.http.*;


import tdi.xml.parser.TdiXmlNode;
import tdi.xml.parser.TdiXmlParser;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
import es.tid.frawa.service.servlet.SOAPUtils;
import es.tid.frawa.service.servlet.TdiServiceException;
import es.tid.serial.TdiBean;


import org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_resp;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_req;
import org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_resp;



/**
 * Servlet controlador del servicio SOAP: QualiPSoMetadataAPI
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoMetadataAPISoapController extends HttpServlet {



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
            

            if (payloadNode.getTag().equals("GetAllProperties")) {

                // SERVICIO: GetAllProperties


                // Parámetro de entrada al servicio
                GetAllProperties_req inbean = new GetAllProperties_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetAllProperties_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetAllProperties_resp outbean = new GetAllProperties_resp();
                    
                // Crear un objeto que implementa la operación
                GetAllPropertiesService serviceImplementation = new GetAllPropertiesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetAllProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetAllPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetAllProperties_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetAllPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetAllProperties_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetAllProperties_resp>");
                output.println("</GetAllPropertiesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetAllProperties_resp>");
                    soapWriter.write("</GetAllPropertiesResponse>");
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



            } else if (payloadNode.getTag().equals("GetDatatypeProperties")) {

                // SERVICIO: GetDatatypeProperties


                // Parámetro de entrada al servicio
                GetDatatypeProperties_req inbean = new GetDatatypeProperties_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetDatatypeProperties_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetDatatypeProperties_resp outbean = new GetDatatypeProperties_resp();
                    
                // Crear un objeto que implementa la operación
                GetDatatypePropertiesService serviceImplementation = new GetDatatypePropertiesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetDatatypeProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetDatatypePropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetDatatypeProperties_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetDatatypePropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetDatatypeProperties_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetDatatypeProperties_resp>");
                output.println("</GetDatatypePropertiesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetDatatypeProperties_resp>");
                    soapWriter.write("</GetDatatypePropertiesResponse>");
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



            } else if (payloadNode.getTag().equals("GetDisjointClasses")) {

                // SERVICIO: GetDisjointClasses


                // Parámetro de entrada al servicio
                GetDisjointClasses_req inbean = new GetDisjointClasses_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetDisjointClasses_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetDisjointClasses_resp outbean = new GetDisjointClasses_resp();
                    
                // Crear un objeto que implementa la operación
                GetDisjointClassesService serviceImplementation = new GetDisjointClassesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetDisjointClasses]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetDisjointClassesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetDisjointClasses_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetDisjointClassesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetDisjointClasses_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetDisjointClasses_resp>");
                output.println("</GetDisjointClassesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetDisjointClasses_resp>");
                    soapWriter.write("</GetDisjointClassesResponse>");
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



            } else if (payloadNode.getTag().equals("GetEquivalentClasses")) {

                // SERVICIO: GetEquivalentClasses


                // Parámetro de entrada al servicio
                GetEquivalentClasses_req inbean = new GetEquivalentClasses_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetEquivalentClasses_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetEquivalentClasses_resp outbean = new GetEquivalentClasses_resp();
                    
                // Crear un objeto que implementa la operación
                GetEquivalentClassesService serviceImplementation = new GetEquivalentClassesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetEquivalentClasses]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetEquivalentClassesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetEquivalentClasses_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetEquivalentClassesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetEquivalentClasses_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetEquivalentClasses_resp>");
                output.println("</GetEquivalentClassesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetEquivalentClasses_resp>");
                    soapWriter.write("</GetEquivalentClassesResponse>");
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



            } else if (payloadNode.getTag().equals("GetInstancesForObjectProperty")) {

                // SERVICIO: GetInstancesForObjectProperty


                // Parámetro de entrada al servicio
                GetInstancesForObjectProperty_req inbean = new GetInstancesForObjectProperty_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetInstancesForObjectProperty_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetInstancesForObjectProperty_resp outbean = new GetInstancesForObjectProperty_resp();
                    
                // Crear un objeto que implementa la operación
                GetInstancesForObjectPropertyService serviceImplementation = new GetInstancesForObjectPropertyService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetInstancesForObjectProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetInstancesForObjectPropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetInstancesForObjectProperty_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetInstancesForObjectPropertyResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetInstancesForObjectProperty_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetInstancesForObjectProperty_resp>");
                output.println("</GetInstancesForObjectPropertyResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetInstancesForObjectProperty_resp>");
                    soapWriter.write("</GetInstancesForObjectPropertyResponse>");
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



            } else if (payloadNode.getTag().equals("GetObjectProperties")) {

                // SERVICIO: GetObjectProperties


                // Parámetro de entrada al servicio
                GetObjectProperties_req inbean = new GetObjectProperties_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetObjectProperties_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetObjectProperties_resp outbean = new GetObjectProperties_resp();
                    
                // Crear un objeto que implementa la operación
                GetObjectPropertiesService serviceImplementation = new GetObjectPropertiesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetObjectProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetObjectPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetObjectProperties_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetObjectPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetObjectProperties_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetObjectProperties_resp>");
                output.println("</GetObjectPropertiesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetObjectProperties_resp>");
                    soapWriter.write("</GetObjectPropertiesResponse>");
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



            } else if (payloadNode.getTag().equals("GetPropertyRange")) {

                // SERVICIO: GetPropertyRange


                // Parámetro de entrada al servicio
                GetPropertyRange_req inbean = new GetPropertyRange_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetPropertyRange_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetPropertyRange_resp outbean = new GetPropertyRange_resp();
                    
                // Crear un objeto que implementa la operación
                GetPropertyRangeService serviceImplementation = new GetPropertyRangeService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetPropertyRange]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetPropertyRangeResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetPropertyRange_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetPropertyRangeResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetPropertyRange_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetPropertyRange_resp>");
                output.println("</GetPropertyRangeResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetPropertyRange_resp>");
                    soapWriter.write("</GetPropertyRangeResponse>");
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



            } else if (payloadNode.getTag().equals("GetRangeAndProperties")) {

                // SERVICIO: GetRangeAndProperties


                // Parámetro de entrada al servicio
                GetRangeAndProperties_req inbean = new GetRangeAndProperties_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetRangeAndProperties_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetRangeAndProperties_resp outbean = new GetRangeAndProperties_resp();
                    
                // Crear un objeto que implementa la operación
                GetRangeAndPropertiesService serviceImplementation = new GetRangeAndPropertiesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetRangeAndProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetRangeAndPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetRangeAndProperties_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetRangeAndPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetRangeAndProperties_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetRangeAndProperties_resp>");
                output.println("</GetRangeAndPropertiesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetRangeAndProperties_resp>");
                    soapWriter.write("</GetRangeAndPropertiesResponse>");
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



            } else if (payloadNode.getTag().equals("GetSubClasses")) {

                // SERVICIO: GetSubClasses


                // Parámetro de entrada al servicio
                GetSubClasses_req inbean = new GetSubClasses_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetSubClasses_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetSubClasses_resp outbean = new GetSubClasses_resp();
                    
                // Crear un objeto que implementa la operación
                GetSubClassesService serviceImplementation = new GetSubClassesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetSubClasses]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetSubClassesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetSubClasses_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetSubClassesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetSubClasses_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetSubClasses_resp>");
                output.println("</GetSubClassesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetSubClasses_resp>");
                    soapWriter.write("</GetSubClassesResponse>");
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



            } else if (payloadNode.getTag().equals("GetSubProperties")) {

                // SERVICIO: GetSubProperties


                // Parámetro de entrada al servicio
                GetSubProperties_req inbean = new GetSubProperties_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetSubProperties_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetSubProperties_resp outbean = new GetSubProperties_resp();
                    
                // Crear un objeto que implementa la operación
                GetSubPropertiesService serviceImplementation = new GetSubPropertiesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetSubProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetSubPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetSubProperties_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetSubPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetSubProperties_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetSubProperties_resp>");
                output.println("</GetSubPropertiesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetSubProperties_resp>");
                    soapWriter.write("</GetSubPropertiesResponse>");
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



            } else if (payloadNode.getTag().equals("GetSuperClasses")) {

                // SERVICIO: GetSuperClasses


                // Parámetro de entrada al servicio
                GetSuperClasses_req inbean = new GetSuperClasses_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetSuperClasses_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetSuperClasses_resp outbean = new GetSuperClasses_resp();
                    
                // Crear un objeto que implementa la operación
                GetSuperClassesService serviceImplementation = new GetSuperClassesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetSuperClasses]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetSuperClassesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetSuperClasses_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetSuperClassesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetSuperClasses_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetSuperClasses_resp>");
                output.println("</GetSuperClassesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetSuperClasses_resp>");
                    soapWriter.write("</GetSuperClassesResponse>");
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



            } else if (payloadNode.getTag().equals("GetSuperProperties")) {

                // SERVICIO: GetSuperProperties


                // Parámetro de entrada al servicio
                GetSuperProperties_req inbean = new GetSuperProperties_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetSuperProperties_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetSuperProperties_resp outbean = new GetSuperProperties_resp();
                    
                // Crear un objeto que implementa la operación
                GetSuperPropertiesService serviceImplementation = new GetSuperPropertiesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetSuperProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                output.println("<GetSuperPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                output.println("<GetSuperProperties_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetSuperPropertiesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/metadata\">");
                   	soapWriter.write("<GetSuperProperties_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetSuperProperties_resp>");
                output.println("</GetSuperPropertiesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetSuperProperties_resp>");
                    soapWriter.write("</GetSuperPropertiesResponse>");
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
                filters[i].onException(request,response,t,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                filters[i].onFinally(request,response,"QualiPSoMetadataAPI",payloadNode.getTag());
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
                "                  xmlns:tns=\"http://www.qualipso.org/advdoc/ws/metadata\"",
                "                  xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"",
                "                  xmlns:http=\"http://schemas.xmlsoap.org/wsdl/http/\"",
                "                  xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"",
                "                  targetNamespace=\"http://www.qualipso.org/advdoc/ws/metadata\">",
                "    <wsdl:types>",
                "        <xs:schema elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:tns=\"http://www.qualipso.org/advdoc/ws/metadata\" targetNamespace=\"http://www.qualipso.org/advdoc/ws/metadata\">",
                "",
                "            <xs:element name=\"ResourceElement\" type=\"tns:ResourceElement\"/>",
                "            <xs:complexType name=\"ResourceElement\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"comment\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"label\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"localName\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"namespace\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"URI\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSuperProperties_resp\" type=\"tns:GetSuperProperties_resp\"/>",
                "            <xs:complexType name=\"GetSuperProperties_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"superproperties\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ResourceElement\" nillable=\"false\" type=\"tns:ResourceElement\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSuperProperties_req\" type=\"tns:GetSuperProperties_req\"/>",
                "            <xs:complexType name=\"GetSuperProperties_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"direct\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSuperClasses_resp\" type=\"tns:GetSuperClasses_resp\"/>",
                "            <xs:complexType name=\"GetSuperClasses_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"superclasses\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ResourceElement\" nillable=\"false\" type=\"tns:ResourceElement\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSuperClasses_req\" type=\"tns:GetSuperClasses_req\"/>",
                "            <xs:complexType name=\"GetSuperClasses_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"classUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"direct\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSubProperties_resp\" type=\"tns:GetSubProperties_resp\"/>",
                "            <xs:complexType name=\"GetSubProperties_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"subproperties\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ResourceElement\" nillable=\"false\" type=\"tns:ResourceElement\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSubProperties_req\" type=\"tns:GetSubProperties_req\"/>",
                "            <xs:complexType name=\"GetSubProperties_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"direct\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSubClasses_resp\" type=\"tns:GetSubClasses_resp\"/>",
                "            <xs:complexType name=\"GetSubClasses_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"subclasses\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ResourceElement\" nillable=\"false\" type=\"tns:ResourceElement\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSubClasses_req\" type=\"tns:GetSubClasses_req\"/>",
                "            <xs:complexType name=\"GetSubClasses_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"classUri\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"direct\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetRangeAndProperties_req\" type=\"tns:GetRangeAndProperties_req\"/>",
                "            <xs:complexType name=\"GetRangeAndProperties_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetPropertyRange_resp\" type=\"tns:GetPropertyRange_resp\"/>",
                "            <xs:complexType name=\"GetPropertyRange_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"classes\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ResourceElement\" nillable=\"false\" type=\"tns:ResourceElement\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetPropertyRange_req\" type=\"tns:GetPropertyRange_req\"/>",
                "            <xs:complexType name=\"GetPropertyRange_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetObjectProperties_resp\" type=\"tns:GetObjectProperties_resp\"/>",
                "            <xs:complexType name=\"GetObjectProperties_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"properties\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ResourceElement\" nillable=\"false\" type=\"tns:ResourceElement\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetObjectProperties_req\" type=\"tns:GetObjectProperties_req\"/>",
                "            <xs:complexType name=\"GetObjectProperties_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"classUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetInstancesForObjectProperty_resp\" type=\"tns:GetInstancesForObjectProperty_resp\"/>",
                "            <xs:complexType name=\"GetInstancesForObjectProperty_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"instanceURIs\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetInstancesForObjectProperty_req\" type=\"tns:GetInstancesForObjectProperty_req\"/>",
                "            <xs:complexType name=\"GetInstancesForObjectProperty_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"propertyURI\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetEquivalentClasses_resp\" type=\"tns:GetEquivalentClasses_resp\"/>",
                "            <xs:complexType name=\"GetEquivalentClasses_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"equivalentClasses\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ResourceElement\" nillable=\"false\" type=\"tns:ResourceElement\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetEquivalentClasses_req\" type=\"tns:GetEquivalentClasses_req\"/>",
                "            <xs:complexType name=\"GetEquivalentClasses_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"classUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetDisjointClasses_resp\" type=\"tns:GetDisjointClasses_resp\"/>",
                "            <xs:complexType name=\"GetDisjointClasses_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"disjointClasses\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ResourceElement\" nillable=\"false\" type=\"tns:ResourceElement\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetDisjointClasses_req\" type=\"tns:GetDisjointClasses_req\"/>",
                "            <xs:complexType name=\"GetDisjointClasses_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"classUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetDatatypeProperties_resp\" type=\"tns:GetDatatypeProperties_resp\"/>",
                "            <xs:complexType name=\"GetDatatypeProperties_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"properties\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ResourceElement\" nillable=\"false\" type=\"tns:ResourceElement\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetDatatypeProperties_req\" type=\"tns:GetDatatypeProperties_req\"/>",
                "            <xs:complexType name=\"GetDatatypeProperties_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"classUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetAllProperties_resp\" type=\"tns:GetAllProperties_resp\"/>",
                "            <xs:complexType name=\"GetAllProperties_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"datatypeProperties\" type=\"tns:GetDatatypeProperties_resp\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"objectProperties\" type=\"tns:GetObjectProperties_resp\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetAllProperties_req\" type=\"tns:GetAllProperties_req\"/>",
                "            <xs:complexType name=\"GetAllProperties_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"classUri\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"ClassAndProperties\" type=\"tns:ClassAndProperties\"/>",
                "            <xs:complexType name=\"ClassAndProperties\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"properties\" type=\"tns:GetAllProperties_resp\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"theClass\" type=\"tns:ResourceElement\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetRangeAndProperties_resp\" type=\"tns:GetRangeAndProperties_resp\"/>",
                "            <xs:complexType name=\"GetRangeAndProperties_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"classes\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"ClassAndProperties\" nillable=\"false\" type=\"tns:ClassAndProperties\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "            <!-- Elementos para las operaciones -->",
                "            <xs:element name=\"GetAllProperties\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetAllProperties_req\" type=\"tns:GetAllProperties_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetAllPropertiesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetAllProperties_resp\" type=\"tns:GetAllProperties_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetDatatypeProperties\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetDatatypeProperties_req\" type=\"tns:GetDatatypeProperties_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetDatatypePropertiesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetDatatypeProperties_resp\" type=\"tns:GetDatatypeProperties_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetDisjointClasses\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetDisjointClasses_req\" type=\"tns:GetDisjointClasses_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetDisjointClassesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetDisjointClasses_resp\" type=\"tns:GetDisjointClasses_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetEquivalentClasses\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetEquivalentClasses_req\" type=\"tns:GetEquivalentClasses_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetEquivalentClassesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetEquivalentClasses_resp\" type=\"tns:GetEquivalentClasses_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetInstancesForObjectProperty\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetInstancesForObjectProperty_req\" type=\"tns:GetInstancesForObjectProperty_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetInstancesForObjectPropertyResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetInstancesForObjectProperty_resp\" type=\"tns:GetInstancesForObjectProperty_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetObjectProperties\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetObjectProperties_req\" type=\"tns:GetObjectProperties_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetObjectPropertiesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetObjectProperties_resp\" type=\"tns:GetObjectProperties_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetPropertyRange\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetPropertyRange_req\" type=\"tns:GetPropertyRange_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetPropertyRangeResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetPropertyRange_resp\" type=\"tns:GetPropertyRange_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetRangeAndProperties\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetRangeAndProperties_req\" type=\"tns:GetRangeAndProperties_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetRangeAndPropertiesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetRangeAndProperties_resp\" type=\"tns:GetRangeAndProperties_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSubClasses\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSubClasses_req\" type=\"tns:GetSubClasses_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSubClassesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSubClasses_resp\" type=\"tns:GetSubClasses_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSubProperties\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSubProperties_req\" type=\"tns:GetSubProperties_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSubPropertiesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSubProperties_resp\" type=\"tns:GetSubProperties_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSuperClasses\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSuperClasses_req\" type=\"tns:GetSuperClasses_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSuperClassesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSuperClasses_resp\" type=\"tns:GetSuperClasses_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSuperProperties\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSuperProperties_req\" type=\"tns:GetSuperProperties_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSuperPropertiesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSuperProperties_resp\" type=\"tns:GetSuperProperties_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "        </xs:schema>",
                "    </wsdl:types>",
                "    <wsdl:message name=\"GetAllPropertiesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetAllProperties\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetAllPropertiesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetAllPropertiesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetDatatypePropertiesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetDatatypeProperties\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetDatatypePropertiesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetDatatypePropertiesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetDisjointClassesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetDisjointClasses\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetDisjointClassesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetDisjointClassesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetEquivalentClassesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetEquivalentClasses\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetEquivalentClassesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetEquivalentClassesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetInstancesForObjectPropertySoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetInstancesForObjectProperty\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetInstancesForObjectPropertySoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetInstancesForObjectPropertyResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetObjectPropertiesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetObjectProperties\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetObjectPropertiesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetObjectPropertiesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetPropertyRangeSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetPropertyRange\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetPropertyRangeSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetPropertyRangeResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetRangeAndPropertiesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetRangeAndProperties\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetRangeAndPropertiesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetRangeAndPropertiesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSubClassesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSubClasses\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSubClassesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSubClassesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSubPropertiesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSubProperties\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSubPropertiesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSubPropertiesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSuperClassesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSuperClasses\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSuperClassesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSuperClassesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSuperPropertiesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSuperProperties\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSuperPropertiesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSuperPropertiesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:portType name=\"QualiPSoMetadataAPISoapPortType\">",
                "        <wsdl:operation name=\"GetAllProperties\">",
                "            <wsdl:documentation>Get datatype and object properties of a given class</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetAllPropertiesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetAllPropertiesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetDatatypeProperties\">",
                "            <wsdl:documentation>Get all datatype properties of a given class</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetDatatypePropertiesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetDatatypePropertiesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetDisjointClasses\">",
                "            <wsdl:documentation>Get disjoint classes to a given one</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetDisjointClassesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetDisjointClassesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetEquivalentClasses\">",
                "            <wsdl:documentation>Get equivalent classes to a given one</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetEquivalentClassesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetEquivalentClassesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetInstancesForObjectProperty\">",
                "            <wsdl:documentation>Get all possible instances for a given object property</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetInstancesForObjectPropertySoapIn\"/>",
                "            <wsdl:output message=\"tns:GetInstancesForObjectPropertySoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetObjectProperties\">",
                "            <wsdl:documentation>Get all object properties of a given class</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetObjectPropertiesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetObjectPropertiesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetPropertyRange\">",
                "            <wsdl:documentation>Get the range of a given property</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetPropertyRangeSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetPropertyRangeSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetRangeAndProperties\">",
                "            <wsdl:documentation>Get the range of a given property. It also gets the properties of each range class</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetRangeAndPropertiesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetRangeAndPropertiesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSubClasses\">",
                "            <wsdl:documentation>Get subclasses of a given class</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetSubClassesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetSubClassesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSubProperties\">",
                "            <wsdl:documentation>Get subproperties of a given property</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetSubPropertiesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetSubPropertiesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSuperClasses\">",
                "            <wsdl:documentation>Get superclasses of a given class</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetSuperClassesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetSuperClassesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSuperProperties\">",
                "            <wsdl:documentation>Get superproperties of a given property</wsdl:documentation>",
                "            <wsdl:input message=\"tns:GetSuperPropertiesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetSuperPropertiesSoapOut\"/>",
                "        </wsdl:operation>",
                "    </wsdl:portType>",
                "    <wsdl:binding name=\"QualiPSoMetadataAPISoapBinding\" type=\"tns:QualiPSoMetadataAPISoapPortType\">",
                "        <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>",
                "        <wsdl:operation name=\"GetAllProperties\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetAllProperties\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetDatatypeProperties\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetDatatypeProperties\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetDisjointClasses\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetDisjointClasses\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetEquivalentClasses\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetEquivalentClasses\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetInstancesForObjectProperty\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetInstancesForObjectProperty\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetObjectProperties\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetObjectProperties\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetPropertyRange\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetPropertyRange\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetRangeAndProperties\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetRangeAndProperties\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSubClasses\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetSubClasses\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSubProperties\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetSubProperties\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSuperClasses\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetSuperClasses\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSuperProperties\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/metadata/GetSuperProperties\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "    </wsdl:binding>",
                "    <wsdl:service name=\"QualiPSoMetadataAPI\">",
                "        <wsdl:port name=\"QualiPSoMetadataAPISoapPort\" binding=\"tns:QualiPSoMetadataAPISoapBinding\">",
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
	    		    writer.write("<FORM name=\"formSOAP\" action=\""+serviceURL+"?SOAPAction=http://www.qualipso.org/advdoc/ws/metadata/"+showMethod+"\" method=\"post\">");
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
	    		writer.write("<TITLE>QualiPSoMetadataAPI</TITLE>");
	    		writer.write("</HEAD>");
	    		writer.write("<BODY>");
                writer.println("<H2>Servicio Web <B>QualiPSoMetadataAPI</B></H2><P/>");
                writer.println("OPERACIONES<P/>");
                writer.println("<OL>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetAllProperties&inbean=GetAllProperties_req&outbean=GetAllProperties_resp\">GetAllProperties</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetAllProperties_req\">GetAllProperties_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetAllProperties_resp\">GetAllProperties_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetDatatypeProperties&inbean=GetDatatypeProperties_req&outbean=GetDatatypeProperties_resp\">GetDatatypeProperties</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetDatatypeProperties_req\">GetDatatypeProperties_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetDatatypeProperties_resp\">GetDatatypeProperties_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetDisjointClasses&inbean=GetDisjointClasses_req&outbean=GetDisjointClasses_resp\">GetDisjointClasses</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetDisjointClasses_req\">GetDisjointClasses_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetDisjointClasses_resp\">GetDisjointClasses_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetEquivalentClasses&inbean=GetEquivalentClasses_req&outbean=GetEquivalentClasses_resp\">GetEquivalentClasses</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetEquivalentClasses_req\">GetEquivalentClasses_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetEquivalentClasses_resp\">GetEquivalentClasses_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetInstancesForObjectProperty&inbean=GetInstancesForObjectProperty_req&outbean=GetInstancesForObjectProperty_resp\">GetInstancesForObjectProperty</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetInstancesForObjectProperty_req\">GetInstancesForObjectProperty_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetInstancesForObjectProperty_resp\">GetInstancesForObjectProperty_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetObjectProperties&inbean=GetObjectProperties_req&outbean=GetObjectProperties_resp\">GetObjectProperties</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetObjectProperties_req\">GetObjectProperties_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetObjectProperties_resp\">GetObjectProperties_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetPropertyRange&inbean=GetPropertyRange_req&outbean=GetPropertyRange_resp\">GetPropertyRange</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetPropertyRange_req\">GetPropertyRange_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetPropertyRange_resp\">GetPropertyRange_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetRangeAndProperties&inbean=GetRangeAndProperties_req&outbean=GetRangeAndProperties_resp\">GetRangeAndProperties</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetRangeAndProperties_req\">GetRangeAndProperties_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetRangeAndProperties_resp\">GetRangeAndProperties_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetSubClasses&inbean=GetSubClasses_req&outbean=GetSubClasses_resp\">GetSubClasses</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetSubClasses_req\">GetSubClasses_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetSubClasses_resp\">GetSubClasses_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetSubProperties&inbean=GetSubProperties_req&outbean=GetSubProperties_resp\">GetSubProperties</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetSubProperties_req\">GetSubProperties_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetSubProperties_resp\">GetSubProperties_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetSuperClasses&inbean=GetSuperClasses_req&outbean=GetSuperClasses_resp\">GetSuperClasses</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetSuperClasses_req\">GetSuperClasses_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetSuperClasses_resp\">GetSuperClasses_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetSuperProperties&inbean=GetSuperProperties_req&outbean=GetSuperProperties_resp\">GetSuperProperties</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetSuperProperties_req\">GetSuperProperties_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetSuperProperties_resp\">GetSuperProperties_resp</A>)");
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
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
		// Buscar algún import con * y probar a instanciar dinámicamente
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetAllProperties_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetDatatypeProperties_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetDisjointClasses_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetEquivalentClasses_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetInstancesForObjectProperty_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetObjectProperties_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetPropertyRange_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetRangeAndProperties_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetSubClasses_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetSubProperties_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperClasses_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.metadata.beans.GetSuperProperties_resp","*",classname);
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