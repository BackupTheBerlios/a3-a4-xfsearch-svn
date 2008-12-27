




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoFeedAPI
// Versi�n  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.feed.service;


import javax.servlet.*;
import javax.servlet.http.*;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
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
 * Servlet controlador del servicio JSON: QualiPSoFeedAPI
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoFeedAPIJsonController extends HttpServlet {



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


            // Mensaje por defecto para los filtros que no necesitan el texto JSON
            StringBuffer soapStr = new StringBuffer("");


			// Leer el mensaje JSON
			
            if (request.getParameter("JSONAction") != null && request.getParameter("JSONAction").length() > 0) {
                action = request.getParameter("JSONAction");
                String tmp = request.getParameter("JSON");
                if (tmp == null || tmp.length() == 0) {
                    throw new Exception(getClass().getName()+".service() JSONAction viene en la URL pero no viene el par�metro JSON con los datos");
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
            
            // Invocar el m�todo beforeParse() de los filtros
            for (int i = 0;i < filters.length;i++) {
                filters[i].beforeParse(request,response,input.toString());
            }


            //
            // Invocar al servicio adecuado en funci�n del header JSONAction
            //
            

            if (action.equals("http://www.qualipso.org/advdoc/ws/feed/AddLiteralProperties")) {

                // SERVICIO: AddLiteralProperties


                // Par�metro de entrada al servicio
                AddLiteralProperties_req inbean = new AddLiteralProperties_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",action);
                }
                    
                // Par�metro de salida del servicio
                AddLiteralProperties_resp outbean = new AddLiteralProperties_resp();
                    
                // Crear un objeto que implementa la operaci�n
                AddLiteralPropertiesService serviceImplementation = new AddLiteralPropertiesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: AddLiteralProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/feed/AddLiteralProperty")) {

                // SERVICIO: AddLiteralProperty


                // Par�metro de entrada al servicio
                AddLiteralProperty_req inbean = new AddLiteralProperty_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",action);
                }
                    
                // Par�metro de salida del servicio
                AddLiteralProperty_resp outbean = new AddLiteralProperty_resp();
                    
                // Crear un objeto que implementa la operaci�n
                AddLiteralPropertyService serviceImplementation = new AddLiteralPropertyService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: AddLiteralProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/feed/AddObjectProperties")) {

                // SERVICIO: AddObjectProperties


                // Par�metro de entrada al servicio
                AddObjectProperties_req inbean = new AddObjectProperties_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",action);
                }
                    
                // Par�metro de salida del servicio
                AddObjectProperties_resp outbean = new AddObjectProperties_resp();
                    
                // Crear un objeto que implementa la operaci�n
                AddObjectPropertiesService serviceImplementation = new AddObjectPropertiesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: AddObjectProperties]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/feed/AddObjectProperty")) {

                // SERVICIO: AddObjectProperty


                // Par�metro de entrada al servicio
                AddObjectProperty_req inbean = new AddObjectProperty_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",action);
                }
                    
                // Par�metro de salida del servicio
                AddObjectProperty_resp outbean = new AddObjectProperty_resp();
                    
                // Crear un objeto que implementa la operaci�n
                AddObjectPropertyService serviceImplementation = new AddObjectPropertyService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: AddObjectProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/feed/CreateAnonymousResource")) {

                // SERVICIO: CreateAnonymousResource


                // Par�metro de entrada al servicio
                CreateAnonymousResource_req inbean = new CreateAnonymousResource_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",action);
                }
                    
                // Par�metro de salida del servicio
                CreateAnonymousResource_resp outbean = new CreateAnonymousResource_resp();
                    
                // Crear un objeto que implementa la operaci�n
                CreateAnonymousResourceService serviceImplementation = new CreateAnonymousResourceService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: CreateAnonymousResource]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/feed/CreateProperty")) {

                // SERVICIO: CreateProperty


                // Par�metro de entrada al servicio
                CreateProperty_req inbean = new CreateProperty_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",action);
                }
                    
                // Par�metro de salida del servicio
                CreateProperty_resp outbean = new CreateProperty_resp();
                    
                // Crear un objeto que implementa la operaci�n
                CreatePropertyService serviceImplementation = new CreatePropertyService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: CreateProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/feed/CreateResource")) {

                // SERVICIO: CreateResource


                // Par�metro de entrada al servicio
                CreateResource_req inbean = new CreateResource_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",action);
                }
                    
                // Par�metro de salida del servicio
                CreateResource_resp outbean = new CreateResource_resp();
                    
                // Crear un objeto que implementa la operaci�n
                CreateResourceService serviceImplementation = new CreateResourceService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: CreateResource]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/feed/RemoveProperty")) {

                // SERVICIO: RemoveProperty


                // Par�metro de entrada al servicio
                RemoveProperty_req inbean = new RemoveProperty_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",action);
                }
                    
                // Par�metro de salida del servicio
                RemoveProperty_resp outbean = new RemoveProperty_resp();
                    
                // Crear un objeto que implementa la operaci�n
                RemovePropertyService serviceImplementation = new RemovePropertyService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: RemoveProperty]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/feed/Save")) {

                // SERVICIO: Save


                // Par�metro de entrada al servicio
                Save_req inbean = new Save_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoFeedAPI",action);
                }
                    
                // Par�metro de salida del servicio
                Save_resp outbean = new Save_resp();
                    
                // Crear un objeto que implementa la operaci�n
                SaveService serviceImplementation = new SaveService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: Save]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoFeedAPI",action);
                }
                    
                // Respuesta
                output = response.getWriter();
                    
                // Bean de salida
                String output_str = outbean.toJSON(false);
                    
                // Invocar el m�todo afterParse() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterParse(request,response,output_str.toString());
                }
                
                // Enviar la respuesta
                output.println(output_str);


                // Invocar el m�todo endService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].endService(request,response);
                }


                
            } else {
            	
                throw new Exception(getClass().getName() + ".service() Operaci�n "+action+" no v�lida");
                
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
                filters[i].onException(request,response,t,"QualiPSoFeedAPI",action);
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
                filters[i].onFinally(request,response,"QualiPSoFeedAPI",action);
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
     * Env�o de error JSON al cliente
     */
    private void sendError(PrintWriter writer,TdiServiceException exception) throws IOException {
    
    	writer.println("{");
    	exception.toJSON(writer);
    	writer.println("}");
    }


    
    private static final long serialVersionUID = 1L;
    
}