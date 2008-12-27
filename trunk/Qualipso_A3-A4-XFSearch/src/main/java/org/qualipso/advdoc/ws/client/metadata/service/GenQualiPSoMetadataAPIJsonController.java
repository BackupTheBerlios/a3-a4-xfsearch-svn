




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoMetadataAPI
// Versión  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.metadata.service;


import javax.servlet.*;
import javax.servlet.http.*;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
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
 * Servlet controlador del servicio JSON: QualiPSoMetadataAPI
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoMetadataAPIJsonController extends HttpServlet {



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
            

            if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetAllProperties")) {

                // SERVICIO: GetAllProperties


                // Parámetro de entrada al servicio
                GetAllProperties_req inbean = new GetAllProperties_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetDatatypeProperties")) {

                // SERVICIO: GetDatatypeProperties


                // Parámetro de entrada al servicio
                GetDatatypeProperties_req inbean = new GetDatatypeProperties_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetDisjointClasses")) {

                // SERVICIO: GetDisjointClasses


                // Parámetro de entrada al servicio
                GetDisjointClasses_req inbean = new GetDisjointClasses_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetEquivalentClasses")) {

                // SERVICIO: GetEquivalentClasses


                // Parámetro de entrada al servicio
                GetEquivalentClasses_req inbean = new GetEquivalentClasses_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetInstancesForObjectProperty")) {

                // SERVICIO: GetInstancesForObjectProperty


                // Parámetro de entrada al servicio
                GetInstancesForObjectProperty_req inbean = new GetInstancesForObjectProperty_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetObjectProperties")) {

                // SERVICIO: GetObjectProperties


                // Parámetro de entrada al servicio
                GetObjectProperties_req inbean = new GetObjectProperties_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetPropertyRange")) {

                // SERVICIO: GetPropertyRange


                // Parámetro de entrada al servicio
                GetPropertyRange_req inbean = new GetPropertyRange_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetRangeAndProperties")) {

                // SERVICIO: GetRangeAndProperties


                // Parámetro de entrada al servicio
                GetRangeAndProperties_req inbean = new GetRangeAndProperties_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetSubClasses")) {

                // SERVICIO: GetSubClasses


                // Parámetro de entrada al servicio
                GetSubClasses_req inbean = new GetSubClasses_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetSubProperties")) {

                // SERVICIO: GetSubProperties


                // Parámetro de entrada al servicio
                GetSubProperties_req inbean = new GetSubProperties_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetSuperClasses")) {

                // SERVICIO: GetSuperClasses


                // Parámetro de entrada al servicio
                GetSuperClasses_req inbean = new GetSuperClasses_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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



            } else if (action.equals("http://www.qualipso.org/advdoc/ws/metadata/GetSuperProperties")) {

                // SERVICIO: GetSuperProperties


                // Parámetro de entrada al servicio
                GetSuperProperties_req inbean = new GetSuperProperties_req();
                inbean.fromJSON(input.toString());
                    
                // Invocar el método beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoMetadataAPI",action);
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
                    filters[i].afterService(request,response,outbean,"QualiPSoMetadataAPI",action);
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
                filters[i].onException(request,response,t,"QualiPSoMetadataAPI",action);
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
                filters[i].onFinally(request,response,"QualiPSoMetadataAPI",action);
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