




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoRetrievalAPI
// Versión  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.retrieval.service;


import javax.servlet.*;
import javax.servlet.http.*;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
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
 * Servlet controlador del servicio JSON: QualiPSoRetrievalAPI
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoRetrievalAPIJsonController extends HttpServlet {



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
            

            if (action.equals("http://www.qualipso.org/advdoc/ws/retrieval/GetResourceProperties")) {

                // SERVICIO: GetResourceProperties


                // Parámetro de entrada al servicio
                GetResourceProperties_req inbean = new GetResourceProperties_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/retrieval/GetResourceProperty")) {

                // SERVICIO: GetResourceProperty


                // Parámetro de entrada al servicio
                GetResourceProperty_req inbean = new GetResourceProperty_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/retrieval/GetResourcesByType")) {

                // SERVICIO: GetResourcesByType


                // Parámetro de entrada al servicio
                GetResourcesByType_req inbean = new GetResourcesByType_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/retrieval/GetResourcesWithProperty")) {

                // SERVICIO: GetResourcesWithProperty


                // Parámetro de entrada al servicio
                GetResourcesWithProperty_req inbean = new GetResourcesWithProperty_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/retrieval/GetResourcesWithPropertyValue")) {

                // SERVICIO: GetResourcesWithPropertyValue


                // Parámetro de entrada al servicio
                GetResourcesWithPropertyValue_req inbean = new GetResourcesWithPropertyValue_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoRetrievalAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoRetrievalAPI",action);
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
                filters[i].onException(request,response,t,"QualiPSoRetrievalAPI",action);
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
                filters[i].onFinally(request,response,"QualiPSoRetrievalAPI",action);
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