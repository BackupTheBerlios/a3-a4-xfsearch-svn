




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoStorage
// Versión  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.storage.service;


import javax.servlet.*;
import javax.servlet.http.*;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
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
 * Servlet controlador del servicio JSON: QualiPSoStorage
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoStorageJsonController extends HttpServlet {



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
            return;
    	}
    	
    	// Se trata de un POST
    	
    	// La respuesta es JSON
        response.setContentType("application/json; charset=UTF-8");
    	
        // Crear los filtros definidos para todos los servicios
        es.tid.frawa.service.servlet.Filter[] filters = new es.tid.frawa.service.servlet.Filter[0];

    	PrintWriter output = null;
    	
    	StringBuffer input = null;


        String action = "";


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


            // Mensaje por defecto para los filtros que no necesitan el texto JSON
            StringBuffer soapStr = new StringBuffer("");


			// Leer el mensaje JSON
			
            if (request.getParameter("JSONAction") != null && request.getParameter("JSONAction").length() > 0) {
                action = request.getParameter("JSONAction");
                String tmp = request.getParameter("JSON");
                if (tmp == null || tmp.length() == 0) {
                    throw new Exception(getClass().getName()+".service() JSONAction viene en la URL pero no viene el parámetro JSON con los datos");
                }
                input = new StringBuffer(tmp);
            } else {
                action = request.getHeader("JSONAction");
                if (action == null || action.length() == 0) {
                    throw new Exception(getClass().getName()+".service() La cabecera HTTP JSONAction no esta definida");
                }
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(getClass().getName()+".service() Leyendo mensaje JSON");
            	BufferedReader input_r = new BufferedReader(request.getReader());
            	input = new StringBuffer();
            	String line = input_r.readLine();
            	while (line != null) {
            		input.append(line);
            		line = input_r.readLine();
            	}
            }
            
            // Invocar el método beforeParse() de los filtros
            for (int i = 0;i < filters.length;i++) {
                filters[i].beforeParse(request,response,input.toString());
            }


            //
            // Invocar al servicio adecuado en función del header JSONAction
            //
            

            if (action.equals("http://www.qualipso.org/advdoc/ws/storage/CreateFolder")) {

                // SERVICIO: CreateFolder


                // Parámetro de entrada al servicio
                CreateFolder_req inbean = new CreateFolder_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/GetFiles")) {

                // SERVICIO: GetFiles


                // Parámetro de entrada al servicio
                GetFiles_req inbean = new GetFiles_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/GetSubFolders")) {

                // SERVICIO: GetSubFolders


                // Parámetro de entrada al servicio
                GetSubFolders_req inbean = new GetSubFolders_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/LoadBinaryFile")) {

                // SERVICIO: LoadBinaryFile


                // Parámetro de entrada al servicio
                LoadBinaryFile_req inbean = new LoadBinaryFile_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/LoadFile")) {

                // SERVICIO: LoadFile


                // Parámetro de entrada al servicio
                LoadFile_req inbean = new LoadFile_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/RemoveFile")) {

                // SERVICIO: RemoveFile


                // Parámetro de entrada al servicio
                RemoveFile_req inbean = new RemoveFile_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/RemoveFolder")) {

                // SERVICIO: RemoveFolder


                // Parámetro de entrada al servicio
                RemoveFolder_req inbean = new RemoveFolder_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/StoreBinaryFile")) {

                // SERVICIO: StoreBinaryFile


                // Parámetro de entrada al servicio
                StoreBinaryFile_req inbean = new StoreBinaryFile_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/StoreFile")) {

                // SERVICIO: StoreFile


                // Parámetro de entrada al servicio
                StoreFile_req inbean = new StoreFile_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/TestLoopback")) {

                // SERVICIO: TestLoopback


                // Parámetro de entrada al servicio
                org.qualipso.advdoc.ws.client.storage.beans.TestLoopback inbean = new org.qualipso.advdoc.ws.client.storage.beans.TestLoopback();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/storage/TestParser")) {

                // SERVICIO: TestParser


                // Parámetro de entrada al servicio
                org.qualipso.advdoc.ws.client.storage.beans.TestParser inbean = new org.qualipso.advdoc.ws.client.storage.beans.TestParser();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoStorage",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoStorage",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el método afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el método endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }


                
            } else {
            	
                throw new Exception(getClass().getName() + ".service() Operación "+action+" no válida");
                
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
                filters[i].onException(request,response,t,"QualiPSoStorage",action);
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
                filters[i].onFinally(request,response,"QualiPSoStorage",action);
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
     * Envío de error JSON al cliente
     */
    private void sendError(PrintWriter writer,TdiServiceException exception) throws IOException {
    
    	writer.println("{");
    	exception.toJSON(writer);
    	writer.println("}");
    }


    
    private static final long serialVersionUID = 1L;
    
}