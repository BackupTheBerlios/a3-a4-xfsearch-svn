




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoStorage
// Versión  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.storage.service;


import javax.servlet.*;
import javax.servlet.http.*;


import tdi.xml.parser.TdiXmlNode;
import tdi.xml.parser.TdiXmlParser;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
import es.tid.frawa.service.servlet.SOAPUtils;
import es.tid.frawa.service.servlet.TdiServiceException;
import es.tid.serial.TdiBean;


import org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_req;
import org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_resp;
import org.qualipso.advdoc.ws.client.storage.beans.GetFiles_req;
import org.qualipso.advdoc.ws.client.storage.beans.GetFiles_resp;
import org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_req;
import org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_resp;
import org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_resp;
import org.qualipso.advdoc.ws.client.storage.beans.LoadFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.LoadFile_resp;
import org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_resp;
import org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_req;
import org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_resp;
import org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_resp;
import org.qualipso.advdoc.ws.client.storage.beans.StoreFile_req;
import org.qualipso.advdoc.ws.client.storage.beans.StoreFile_resp;
import org.qualipso.advdoc.ws.client.storage.beans.TestLoopback;
import org.qualipso.advdoc.ws.client.storage.beans.TestParser;



/**
 * Servlet controlador del servicio SOAP: QualiPSoStorage
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoStorageSoapController extends HttpServlet {



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
            // Crea una sesión si no existe (esta opción está marcada en el modelo de servicios)
            request.getSession(true);

            
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
            

            if (payloadNode.getTag().equals("CreateFolder")) {

                // SERVICIO: CreateFolder


                // Parámetro de entrada al servicio
                CreateFolder_req inbean = new CreateFolder_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("CreateFolder_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                CreateFolder_resp outbean = new CreateFolder_resp();
                    
                // Crear un objeto que implementa la operación
                CreateFolderService serviceImplementation = new CreateFolderService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: CreateFolder]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<CreateFolderResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<CreateFolder_resp>");
                if (needSOAP) {
                    soapWriter.write("<CreateFolderResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<CreateFolder_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</CreateFolder_resp>");
                output.println("</CreateFolderResponse>");
                if (needSOAP) {
                   	soapWriter.write("</CreateFolder_resp>");
                    soapWriter.write("</CreateFolderResponse>");
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



            } else if (payloadNode.getTag().equals("GetFiles")) {

                // SERVICIO: GetFiles


                // Parámetro de entrada al servicio
                GetFiles_req inbean = new GetFiles_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetFiles_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetFiles_resp outbean = new GetFiles_resp();
                    
                // Crear un objeto que implementa la operación
                GetFilesService serviceImplementation = new GetFilesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetFiles]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<GetFilesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<GetFiles_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetFilesResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<GetFiles_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetFiles_resp>");
                output.println("</GetFilesResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetFiles_resp>");
                    soapWriter.write("</GetFilesResponse>");
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



            } else if (payloadNode.getTag().equals("GetSubFolders")) {

                // SERVICIO: GetSubFolders


                // Parámetro de entrada al servicio
                GetSubFolders_req inbean = new GetSubFolders_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetSubFolders_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                GetSubFolders_resp outbean = new GetSubFolders_resp();
                    
                // Crear un objeto que implementa la operación
                GetSubFoldersService serviceImplementation = new GetSubFoldersService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetSubFolders]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<GetSubFoldersResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<GetSubFolders_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetSubFoldersResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<GetSubFolders_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetSubFolders_resp>");
                output.println("</GetSubFoldersResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetSubFolders_resp>");
                    soapWriter.write("</GetSubFoldersResponse>");
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



            } else if (payloadNode.getTag().equals("LoadBinaryFile")) {

                // SERVICIO: LoadBinaryFile


                // Parámetro de entrada al servicio
                LoadBinaryFile_req inbean = new LoadBinaryFile_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("LoadBinaryFile_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                LoadBinaryFile_resp outbean = new LoadBinaryFile_resp();
                    
                // Crear un objeto que implementa la operación
                LoadBinaryFileService serviceImplementation = new LoadBinaryFileService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: LoadBinaryFile]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<LoadBinaryFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<LoadBinaryFile_resp>");
                if (needSOAP) {
                    soapWriter.write("<LoadBinaryFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<LoadBinaryFile_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</LoadBinaryFile_resp>");
                output.println("</LoadBinaryFileResponse>");
                if (needSOAP) {
                   	soapWriter.write("</LoadBinaryFile_resp>");
                    soapWriter.write("</LoadBinaryFileResponse>");
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



            } else if (payloadNode.getTag().equals("LoadFile")) {

                // SERVICIO: LoadFile


                // Parámetro de entrada al servicio
                LoadFile_req inbean = new LoadFile_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("LoadFile_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                LoadFile_resp outbean = new LoadFile_resp();
                    
                // Crear un objeto que implementa la operación
                LoadFileService serviceImplementation = new LoadFileService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: LoadFile]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<LoadFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<LoadFile_resp>");
                if (needSOAP) {
                    soapWriter.write("<LoadFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<LoadFile_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</LoadFile_resp>");
                output.println("</LoadFileResponse>");
                if (needSOAP) {
                   	soapWriter.write("</LoadFile_resp>");
                    soapWriter.write("</LoadFileResponse>");
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



            } else if (payloadNode.getTag().equals("RemoveFile")) {

                // SERVICIO: RemoveFile


                // Parámetro de entrada al servicio
                RemoveFile_req inbean = new RemoveFile_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("RemoveFile_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                RemoveFile_resp outbean = new RemoveFile_resp();
                    
                // Crear un objeto que implementa la operación
                RemoveFileService serviceImplementation = new RemoveFileService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: RemoveFile]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<RemoveFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<RemoveFile_resp>");
                if (needSOAP) {
                    soapWriter.write("<RemoveFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<RemoveFile_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</RemoveFile_resp>");
                output.println("</RemoveFileResponse>");
                if (needSOAP) {
                   	soapWriter.write("</RemoveFile_resp>");
                    soapWriter.write("</RemoveFileResponse>");
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



            } else if (payloadNode.getTag().equals("RemoveFolder")) {

                // SERVICIO: RemoveFolder


                // Parámetro de entrada al servicio
                RemoveFolder_req inbean = new RemoveFolder_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("RemoveFolder_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                RemoveFolder_resp outbean = new RemoveFolder_resp();
                    
                // Crear un objeto que implementa la operación
                RemoveFolderService serviceImplementation = new RemoveFolderService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: RemoveFolder]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<RemoveFolderResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<RemoveFolder_resp>");
                if (needSOAP) {
                    soapWriter.write("<RemoveFolderResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<RemoveFolder_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</RemoveFolder_resp>");
                output.println("</RemoveFolderResponse>");
                if (needSOAP) {
                   	soapWriter.write("</RemoveFolder_resp>");
                    soapWriter.write("</RemoveFolderResponse>");
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



            } else if (payloadNode.getTag().equals("StoreBinaryFile")) {

                // SERVICIO: StoreBinaryFile


                // Parámetro de entrada al servicio
                StoreBinaryFile_req inbean = new StoreBinaryFile_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("StoreBinaryFile_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                StoreBinaryFile_resp outbean = new StoreBinaryFile_resp();
                    
                // Crear un objeto que implementa la operación
                StoreBinaryFileService serviceImplementation = new StoreBinaryFileService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: StoreBinaryFile]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<StoreBinaryFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<StoreBinaryFile_resp>");
                if (needSOAP) {
                    soapWriter.write("<StoreBinaryFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<StoreBinaryFile_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</StoreBinaryFile_resp>");
                output.println("</StoreBinaryFileResponse>");
                if (needSOAP) {
                   	soapWriter.write("</StoreBinaryFile_resp>");
                    soapWriter.write("</StoreBinaryFileResponse>");
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



            } else if (payloadNode.getTag().equals("StoreFile")) {

                // SERVICIO: StoreFile


                // Parámetro de entrada al servicio
                StoreFile_req inbean = new StoreFile_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("StoreFile_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                StoreFile_resp outbean = new StoreFile_resp();
                    
                // Crear un objeto que implementa la operación
                StoreFileService serviceImplementation = new StoreFileService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: StoreFile]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<StoreFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<StoreFile_resp>");
                if (needSOAP) {
                    soapWriter.write("<StoreFileResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<StoreFile_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</StoreFile_resp>");
                output.println("</StoreFileResponse>");
                if (needSOAP) {
                   	soapWriter.write("</StoreFile_resp>");
                    soapWriter.write("</StoreFileResponse>");
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



            } else if (payloadNode.getTag().equals("TestLoopback")) {

                // SERVICIO: TestLoopback


                // Parámetro de entrada al servicio
                org.qualipso.advdoc.ws.client.storage.beans.TestLoopback inbean = new org.qualipso.advdoc.ws.client.storage.beans.TestLoopback();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("TestLoopback");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                org.qualipso.advdoc.ws.client.storage.beans.TestLoopback outbean = new org.qualipso.advdoc.ws.client.storage.beans.TestLoopback();
                    
                // Crear un objeto que implementa la operación
                TestLoopbackService serviceImplementation = new TestLoopbackService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: TestLoopback]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<TestLoopbackResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<TestLoopback>");
                if (needSOAP) {
                    soapWriter.write("<TestLoopbackResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<TestLoopback>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</TestLoopback>");
                output.println("</TestLoopbackResponse>");
                if (needSOAP) {
                   	soapWriter.write("</TestLoopback>");
                    soapWriter.write("</TestLoopbackResponse>");
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



            } else if (payloadNode.getTag().equals("TestParser")) {

                // SERVICIO: TestParser


                // Parámetro de entrada al servicio
                org.qualipso.advdoc.ws.client.storage.beans.TestParser inbean = new org.qualipso.advdoc.ws.client.storage.beans.TestParser();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("TestParser");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",payloadNode.getTag());
                }
                    
                // Parámetro de salida del servicio
                org.qualipso.advdoc.ws.client.storage.beans.TestParser outbean = new org.qualipso.advdoc.ws.client.storage.beans.TestParser();
                    
                // Crear un objeto que implementa la operación
                TestParserService serviceImplementation = new TestParserService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: TestParser]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el método afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",payloadNode.getTag());
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
                output.println("<TestParserResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                output.println("<TestParser>");
                if (needSOAP) {
                    soapWriter.write("<TestParserResponse xmlns=\"http://www.qualipso.org/advdoc/ws/storage\">");
                   	soapWriter.write("<TestParser>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</TestParser>");
                output.println("</TestParserResponse>");
                if (needSOAP) {
                   	soapWriter.write("</TestParser>");
                    soapWriter.write("</TestParserResponse>");
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
                filters[i].onException(request,response,t,"QualiPSoStorage",payloadNode.getTag());
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
                filters[i].onFinally(request,response,"QualiPSoStorage",payloadNode.getTag());
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
                "                  xmlns:tns=\"http://www.qualipso.org/advdoc/ws/storage\"",
                "                  xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"",
                "                  xmlns:http=\"http://schemas.xmlsoap.org/wsdl/http/\"",
                "                  xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"",
                "                  targetNamespace=\"http://www.qualipso.org/advdoc/ws/storage\">",
                "    <wsdl:types>",
                "        <xs:schema elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:tns=\"http://www.qualipso.org/advdoc/ws/storage\" targetNamespace=\"http://www.qualipso.org/advdoc/ws/storage\">",
                "",
                "            <xs:element name=\"StoreFile_resp\" type=\"tns:StoreFile_resp\"/>",
                "            <xs:complexType name=\"StoreFile_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"result\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"StoreBinaryFile_resp\" type=\"tns:StoreBinaryFile_resp\"/>",
                "            <xs:complexType name=\"StoreBinaryFile_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"result\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"RemoveFolder_resp\" type=\"tns:RemoveFolder_resp\"/>",
                "            <xs:complexType name=\"RemoveFolder_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"result\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"RemoveFile_resp\" type=\"tns:RemoveFile_resp\"/>",
                "            <xs:complexType name=\"RemoveFile_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"result\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"LoadFile_resp\" type=\"tns:LoadFile_resp\"/>",
                "            <xs:complexType name=\"LoadFile_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"contents\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"LoadBinaryFile_resp\" type=\"tns:LoadBinaryFile_resp\"/>",
                "            <xs:complexType name=\"LoadBinaryFile_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"data\" type=\"xs:base64Binary\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSubFolders_resp\" type=\"tns:GetSubFolders_resp\"/>",
                "            <xs:complexType name=\"GetSubFolders_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"folders\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetFiles_resp\" type=\"tns:GetFiles_resp\"/>",
                "            <xs:complexType name=\"GetFiles_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"files\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"FolderPath\" type=\"tns:FolderPath\"/>",
                "            <xs:complexType name=\"FolderPath\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"folders\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"CreateFolder_resp\" type=\"tns:CreateFolder_resp\"/>",
                "            <xs:complexType name=\"CreateFolder_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"result\" type=\"xs:integer\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"CreateFolder_req\" type=\"tns:CreateFolder_req\"/>",
                "            <xs:complexType name=\"CreateFolder_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"folder\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"path\" type=\"tns:FolderPath\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"Composite\" type=\"tns:Composite\"/>",
                "            <xs:complexType name=\"Composite\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"id\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"name\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"value\" type=\"xs:double\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"comments\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"string\" nillable=\"false\" type=\"xs:string\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"years\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"int\" nillable=\"false\" type=\"xs:integer\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"TestLoopback\" type=\"tns:TestLoopback\"/>",
                "            <xs:complexType name=\"TestLoopback\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"clientRequestTime\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"clientResponseTime\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"serverTime\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"data1\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"Composite\" nillable=\"false\" type=\"tns:Composite\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"data2\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"Composite\" nillable=\"false\" type=\"tns:Composite\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"data3\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"Composite\" nillable=\"false\" type=\"tns:Composite\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"StoreFile_req\" type=\"tns:StoreFile_req\"/>",
                "            <xs:complexType name=\"StoreFile_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"contents\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"filename\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"overwrite\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"path\" type=\"tns:FolderPath\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"StoreBinaryFile_req\" type=\"tns:StoreBinaryFile_req\"/>",
                "            <xs:complexType name=\"StoreBinaryFile_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"filename\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"overwrite\" type=\"xs:integer\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"path\" type=\"tns:FolderPath\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"data\" type=\"xs:base64Binary\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"RemoveFolder_req\" type=\"tns:RemoveFolder_req\"/>",
                "            <xs:complexType name=\"RemoveFolder_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"folder\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"path\" type=\"tns:FolderPath\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"RemoveFile_req\" type=\"tns:RemoveFile_req\"/>",
                "            <xs:complexType name=\"RemoveFile_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"file\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"path\" type=\"tns:FolderPath\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"LoadFile_req\" type=\"tns:LoadFile_req\"/>",
                "            <xs:complexType name=\"LoadFile_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"filename\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"path\" type=\"tns:FolderPath\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"LoadBinaryFile_req\" type=\"tns:LoadBinaryFile_req\"/>",
                "            <xs:complexType name=\"LoadBinaryFile_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"filename\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"path\" type=\"tns:FolderPath\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetSubFolders_req\" type=\"tns:GetSubFolders_req\"/>",
                "            <xs:complexType name=\"GetSubFolders_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"path\" type=\"tns:FolderPath\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetFiles_req\" type=\"tns:GetFiles_req\"/>",
                "            <xs:complexType name=\"GetFiles_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"filter\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"path\" type=\"tns:FolderPath\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"TestParser\" type=\"tns:TestParser\"/>",
                "            <xs:complexType name=\"TestParser\">",
                "                <xs:complexContent mixed=\"false\">",
                "                    <xs:extension base=\"tns:TestLoopback\">",
                "                        <xs:sequence>",
                "                            <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"jsonDeserialTime\" type=\"xs:integer\"/>",
                "                            <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"jsonSerialTime\" type=\"xs:integer\"/>",
                "                            <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"numIterations\" type=\"xs:integer\"/>",
                "                            <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"soapDeserialTime\" type=\"xs:integer\"/>",
                "                            <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"soapSerialTime\" type=\"xs:integer\"/>",
                "                        </xs:sequence>",
                "                    </xs:extension>",
                "                </xs:complexContent>",
                "            </xs:complexType>",
                "            <!-- Elementos para las operaciones -->",
                "            <xs:element name=\"CreateFolder\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"CreateFolder_req\" type=\"tns:CreateFolder_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"CreateFolderResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"CreateFolder_resp\" type=\"tns:CreateFolder_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetFiles\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetFiles_req\" type=\"tns:GetFiles_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetFilesResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetFiles_resp\" type=\"tns:GetFiles_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSubFolders\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSubFolders_req\" type=\"tns:GetSubFolders_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetSubFoldersResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetSubFolders_resp\" type=\"tns:GetSubFolders_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"LoadBinaryFile\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"LoadBinaryFile_req\" type=\"tns:LoadBinaryFile_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"LoadBinaryFileResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"LoadBinaryFile_resp\" type=\"tns:LoadBinaryFile_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"LoadFile\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"LoadFile_req\" type=\"tns:LoadFile_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"LoadFileResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"LoadFile_resp\" type=\"tns:LoadFile_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"RemoveFile\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"RemoveFile_req\" type=\"tns:RemoveFile_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"RemoveFileResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"RemoveFile_resp\" type=\"tns:RemoveFile_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"RemoveFolder\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"RemoveFolder_req\" type=\"tns:RemoveFolder_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"RemoveFolderResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"RemoveFolder_resp\" type=\"tns:RemoveFolder_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"StoreBinaryFile\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"StoreBinaryFile_req\" type=\"tns:StoreBinaryFile_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"StoreBinaryFileResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"StoreBinaryFile_resp\" type=\"tns:StoreBinaryFile_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"StoreFile\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"StoreFile_req\" type=\"tns:StoreFile_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"StoreFileResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"StoreFile_resp\" type=\"tns:StoreFile_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"TestLoopback\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"TestLoopback\" type=\"tns:TestLoopback\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"TestLoopbackResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"TestLoopback\" type=\"tns:TestLoopback\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"TestParser\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"TestParser\" type=\"tns:TestParser\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"TestParserResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"TestParser\" type=\"tns:TestParser\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "        </xs:schema>",
                "    </wsdl:types>",
                "    <wsdl:message name=\"CreateFolderSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:CreateFolder\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"CreateFolderSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:CreateFolderResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetFilesSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetFiles\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetFilesSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetFilesResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSubFoldersSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSubFolders\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetSubFoldersSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetSubFoldersResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"LoadBinaryFileSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:LoadBinaryFile\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"LoadBinaryFileSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:LoadBinaryFileResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"LoadFileSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:LoadFile\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"LoadFileSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:LoadFileResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"RemoveFileSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:RemoveFile\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"RemoveFileSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:RemoveFileResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"RemoveFolderSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:RemoveFolder\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"RemoveFolderSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:RemoveFolderResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"StoreBinaryFileSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:StoreBinaryFile\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"StoreBinaryFileSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:StoreBinaryFileResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"StoreFileSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:StoreFile\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"StoreFileSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:StoreFileResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"TestLoopbackSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:TestLoopback\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"TestLoopbackSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:TestLoopbackResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"TestParserSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:TestParser\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"TestParserSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:TestParserResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:portType name=\"QualiPSoStorageSoapPortType\">",
                "        <wsdl:operation name=\"CreateFolder\">",
                "            <wsdl:input message=\"tns:CreateFolderSoapIn\"/>",
                "            <wsdl:output message=\"tns:CreateFolderSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetFiles\">",
                "            <wsdl:input message=\"tns:GetFilesSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetFilesSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSubFolders\">",
                "            <wsdl:input message=\"tns:GetSubFoldersSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetSubFoldersSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"LoadBinaryFile\">",
                "            <wsdl:input message=\"tns:LoadBinaryFileSoapIn\"/>",
                "            <wsdl:output message=\"tns:LoadBinaryFileSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"LoadFile\">",
                "            <wsdl:input message=\"tns:LoadFileSoapIn\"/>",
                "            <wsdl:output message=\"tns:LoadFileSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"RemoveFile\">",
                "            <wsdl:input message=\"tns:RemoveFileSoapIn\"/>",
                "            <wsdl:output message=\"tns:RemoveFileSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"RemoveFolder\">",
                "            <wsdl:input message=\"tns:RemoveFolderSoapIn\"/>",
                "            <wsdl:output message=\"tns:RemoveFolderSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"StoreBinaryFile\">",
                "            <wsdl:input message=\"tns:StoreBinaryFileSoapIn\"/>",
                "            <wsdl:output message=\"tns:StoreBinaryFileSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"StoreFile\">",
                "            <wsdl:input message=\"tns:StoreFileSoapIn\"/>",
                "            <wsdl:output message=\"tns:StoreFileSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"TestLoopback\">",
                "            <wsdl:input message=\"tns:TestLoopbackSoapIn\"/>",
                "            <wsdl:output message=\"tns:TestLoopbackSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"TestParser\">",
                "            <wsdl:input message=\"tns:TestParserSoapIn\"/>",
                "            <wsdl:output message=\"tns:TestParserSoapOut\"/>",
                "        </wsdl:operation>",
                "    </wsdl:portType>",
                "    <wsdl:binding name=\"QualiPSoStorageSoapBinding\" type=\"tns:QualiPSoStorageSoapPortType\">",
                "        <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>",
                "        <wsdl:operation name=\"CreateFolder\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/CreateFolder\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetFiles\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/GetFiles\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"GetSubFolders\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/GetSubFolders\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"LoadBinaryFile\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/LoadBinaryFile\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"LoadFile\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/LoadFile\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"RemoveFile\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/RemoveFile\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"RemoveFolder\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/RemoveFolder\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"StoreBinaryFile\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/StoreBinaryFile\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"StoreFile\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/StoreFile\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"TestLoopback\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/TestLoopback\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"TestParser\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/storage/TestParser\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "    </wsdl:binding>",
                "    <wsdl:service name=\"QualiPSoStorage\">",
                "        <wsdl:port name=\"QualiPSoStorageSoapPort\" binding=\"tns:QualiPSoStorageSoapBinding\">",
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
	    		    writer.write("<FORM name=\"formSOAP\" action=\""+serviceURL+"?SOAPAction=http://www.qualipso.org/advdoc/ws/storage/"+showMethod+"\" method=\"post\">");
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
	    		writer.write("<TITLE>QualiPSoStorage</TITLE>");
	    		writer.write("</HEAD>");
	    		writer.write("<BODY>");
                writer.println("<H2>Servicio Web <B>QualiPSoStorage</B></H2><P/>");
                writer.println("OPERACIONES<P/>");
                writer.println("<OL>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=CreateFolder&inbean=CreateFolder_req&outbean=CreateFolder_resp\">CreateFolder</A> (input : <A HREF=\""+serviceURL+"?showFrame=CreateFolder_req\">CreateFolder_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=CreateFolder_resp\">CreateFolder_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetFiles&inbean=GetFiles_req&outbean=GetFiles_resp\">GetFiles</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetFiles_req\">GetFiles_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetFiles_resp\">GetFiles_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetSubFolders&inbean=GetSubFolders_req&outbean=GetSubFolders_resp\">GetSubFolders</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetSubFolders_req\">GetSubFolders_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetSubFolders_resp\">GetSubFolders_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=LoadBinaryFile&inbean=LoadBinaryFile_req&outbean=LoadBinaryFile_resp\">LoadBinaryFile</A> (input : <A HREF=\""+serviceURL+"?showFrame=LoadBinaryFile_req\">LoadBinaryFile_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=LoadBinaryFile_resp\">LoadBinaryFile_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=LoadFile&inbean=LoadFile_req&outbean=LoadFile_resp\">LoadFile</A> (input : <A HREF=\""+serviceURL+"?showFrame=LoadFile_req\">LoadFile_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=LoadFile_resp\">LoadFile_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=RemoveFile&inbean=RemoveFile_req&outbean=RemoveFile_resp\">RemoveFile</A> (input : <A HREF=\""+serviceURL+"?showFrame=RemoveFile_req\">RemoveFile_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=RemoveFile_resp\">RemoveFile_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=RemoveFolder&inbean=RemoveFolder_req&outbean=RemoveFolder_resp\">RemoveFolder</A> (input : <A HREF=\""+serviceURL+"?showFrame=RemoveFolder_req\">RemoveFolder_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=RemoveFolder_resp\">RemoveFolder_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=StoreBinaryFile&inbean=StoreBinaryFile_req&outbean=StoreBinaryFile_resp\">StoreBinaryFile</A> (input : <A HREF=\""+serviceURL+"?showFrame=StoreBinaryFile_req\">StoreBinaryFile_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=StoreBinaryFile_resp\">StoreBinaryFile_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=StoreFile&inbean=StoreFile_req&outbean=StoreFile_resp\">StoreFile</A> (input : <A HREF=\""+serviceURL+"?showFrame=StoreFile_req\">StoreFile_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=StoreFile_resp\">StoreFile_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=TestLoopback&inbean=org.qualipso.advdoc.ws.client.storage.beans.TestLoopback&outbean=org.qualipso.advdoc.ws.client.storage.beans.TestLoopback\">TestLoopback</A> (input : <A HREF=\""+serviceURL+"?showFrame=org.qualipso.advdoc.ws.client.storage.beans.TestLoopback\">TestLoopback</A>, output : <A HREF=\""+serviceURL+"?showFrame=org.qualipso.advdoc.ws.client.storage.beans.TestLoopback\">TestLoopback</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=TestParser&inbean=org.qualipso.advdoc.ws.client.storage.beans.TestParser&outbean=org.qualipso.advdoc.ws.client.storage.beans.TestParser\">TestParser</A> (input : <A HREF=\""+serviceURL+"?showFrame=org.qualipso.advdoc.ws.client.storage.beans.TestParser\">TestParser</A>, output : <A HREF=\""+serviceURL+"?showFrame=org.qualipso.advdoc.ws.client.storage.beans.TestParser\">TestParser</A>)");
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
        if ("org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.GetFiles_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.GetFiles_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.GetFiles_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.GetFiles_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.LoadFile_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.LoadFile_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.LoadFile_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.LoadFile_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.StoreFile_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.StoreFile_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.StoreFile_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.StoreFile_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.TestLoopback".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.TestLoopback");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.storage.beans.TestParser".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.storage.beans.TestParser");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
		// Buscar algún import con * y probar a instanciar dinámicamente
		if ("org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.CreateFolder_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.GetFiles_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.GetFiles_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.GetFiles_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.GetFiles_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.GetSubFolders_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.LoadBinaryFile_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.LoadFile_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.LoadFile_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.LoadFile_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.LoadFile_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.RemoveFile_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.RemoveFolder_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.StoreBinaryFile_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.StoreFile_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.StoreFile_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.StoreFile_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.StoreFile_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.TestLoopback".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.TestLoopback","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.storage.beans.TestParser".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.storage.beans.TestParser","*",classname);
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