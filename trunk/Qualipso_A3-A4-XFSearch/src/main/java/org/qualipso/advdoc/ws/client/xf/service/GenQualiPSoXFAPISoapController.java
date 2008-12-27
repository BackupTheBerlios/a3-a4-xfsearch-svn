




//-----------------------------------------------------------------
// Fichero generado por FRAWA. NO MODIFICAR!!!
// Proyecto : QualiPSoXFAPI
// Versi�n  : 1.0
//----------------------------------------------------------------- 


// TDI_3971_4573_0146_8888_2525_8264_3791



package org.qualipso.advdoc.ws.client.xf.service;


import javax.servlet.*;
import javax.servlet.http.*;


import tdi.xml.parser.TdiXmlNode;
import tdi.xml.parser.TdiXmlParser;


import java.io.*;


import es.tid.frawa.service.servlet.AbstractService;
import es.tid.frawa.service.servlet.SOAPUtils;
import es.tid.frawa.service.servlet.TdiServiceException;
import es.tid.serial.TdiBean;


import org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_req;
import org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_resp;
import org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_req;
import org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_resp;



/**
 * Servlet controlador del servicio SOAP: QualiPSoXFAPI
 * @author FRAWA+
 * @version 1.0
 */
public class GenQualiPSoXFAPISoapController extends HttpServlet {



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
            // Crea una sesi�n si no existe (esta opci�n est� marcada en el modelo de servicios)
            request.getSession(true);

            
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
            

            if (payloadNode.getTag().equals("GetForgeList")) {

                // SERVICIO: GetForgeList


                // Par�metro de entrada al servicio
                GetForgeList_req inbean = new GetForgeList_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("GetForgeList_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoXFAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                GetForgeList_resp outbean = new GetForgeList_resp();
                    
                // Crear un objeto que implementa la operaci�n
                AvailableRemoteForgesService serviceImplementation = new AvailableRemoteForgesService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: GetForgeList]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoXFAPI",payloadNode.getTag());
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
                output.println("<GetForgeListResponse xmlns=\"http://www.qualipso.org/advdoc/ws/xf\">");
                output.println("<GetForgeList_resp>");
                if (needSOAP) {
                    soapWriter.write("<GetForgeListResponse xmlns=\"http://www.qualipso.org/advdoc/ws/xf\">");
                   	soapWriter.write("<GetForgeList_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</GetForgeList_resp>");
                output.println("</GetForgeListResponse>");
                if (needSOAP) {
                   	soapWriter.write("</GetForgeList_resp>");
                    soapWriter.write("</GetForgeListResponse>");
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



            } else if (payloadNode.getTag().equals("SearchCrossForge")) {

                // SERVICIO: SearchCrossForge


                // Par�metro de entrada al servicio
                SearchCrossForge_req inbean = new SearchCrossForge_req();
                TdiXmlNode parameterNode = payloadNode.getFirstChildByName("SearchCrossForge_req");
                inbean.fromSOAP(parameterNode);
                    
                // Invocar el m�todo beforeService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].beforeService(request,response,inbean,"QualiPSoXFAPI",payloadNode.getTag());
                }
                    
                // Par�metro de salida del servicio
                SearchCrossForge_resp outbean = new SearchCrossForge_resp();
                    
                // Crear un objeto que implementa la operaci�n
                CrossForgeSearchService serviceImplementation = new CrossForgeSearchService();
                    
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
                        sendError(output,new TdiServiceException(1,"."+rc+"[Operation: SearchCrossForge]"+rc+inputBean+rc+".",applicationException.getClass().getName()+":"+applicationException.getMessage()));
                    }
                    return;
                }


                // Invocar el m�todo afterService() de los filtros
                for (int i = 0;i < filters.length;i++) {
                    filters[i].afterService(request,response,outbean,"QualiPSoXFAPI",payloadNode.getTag());
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
                output.println("<SearchCrossForgeResponse xmlns=\"http://www.qualipso.org/advdoc/ws/xf\">");
                output.println("<SearchCrossForge_resp>");
                if (needSOAP) {
                    soapWriter.write("<SearchCrossForgeResponse xmlns=\"http://www.qualipso.org/advdoc/ws/xf\">");
                   	soapWriter.write("<SearchCrossForge_resp>");
                }
                    
                // Bean de salida
                outbean.toSOAP(output);
                if (needSOAP) {
                   	outbean.toSOAP(soapWriter);
                }


                    
                // Respuesta
                output.println("</SearchCrossForge_resp>");
                output.println("</SearchCrossForgeResponse>");
                if (needSOAP) {
                   	soapWriter.write("</SearchCrossForge_resp>");
                    soapWriter.write("</SearchCrossForgeResponse>");
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
                filters[i].onException(request,response,t,"QualiPSoXFAPI",payloadNode.getTag());
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
                filters[i].onFinally(request,response,"QualiPSoXFAPI",payloadNode.getTag());
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
                "                  xmlns:tns=\"http://www.qualipso.org/advdoc/ws/xf\"",
                "                  xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"",
                "                  xmlns:http=\"http://schemas.xmlsoap.org/wsdl/http/\"",
                "                  xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\"",
                "                  targetNamespace=\"http://www.qualipso.org/advdoc/ws/xf\">",
                "    <wsdl:types>",
                "        <xs:schema elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:tns=\"http://www.qualipso.org/advdoc/ws/xf\" targetNamespace=\"http://www.qualipso.org/advdoc/ws/xf\">",
                "",
                "            <xs:element name=\"SearchCrossForge_resp\" type=\"tns:SearchCrossForge_resp\"/>",
                "            <xs:complexType name=\"SearchCrossForge_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"result\" type=\"tns:SPARQLResult\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetForgeList_req\" type=\"tns:GetForgeList_req\"/>",
                "            <xs:complexType name=\"GetForgeList_req\">",
                "                <xs:sequence>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"Forge\" type=\"tns:Forge\"/>",
                "            <xs:complexType name=\"Forge\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"forgeName\" type=\"xs:string\"/>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"SearchCrossForge_req\" type=\"tns:SearchCrossForge_req\"/>",
                "            <xs:complexType name=\"SearchCrossForge_req\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"sparql\" type=\"xs:string\"/>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"forges\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"Forge\" nillable=\"false\" type=\"tns:Forge\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "",
                "            <xs:element name=\"GetForgeList_resp\" type=\"tns:GetForgeList_resp\"/>",
                "            <xs:complexType name=\"GetForgeList_resp\">",
                "                <xs:sequence>",
                "                    <xs:element minOccurs=\"1\" maxOccurs=\"1\" name=\"forges\">",
                "                        <xs:complexType>",
                "                            <xs:sequence>",
                "                                <xs:element minOccurs=\"0\" maxOccurs=\"unbounded\" name=\"Forge\" nillable=\"false\" type=\"tns:Forge\"/>",
                "                            </xs:sequence>",
                "                        </xs:complexType>",
                "                    </xs:element>",
                "                </xs:sequence>",
                "            </xs:complexType>",
                "            <!-- Elementos para las operaciones -->",
                "            <xs:element name=\"GetForgeList\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetForgeList_req\" type=\"tns:GetForgeList_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"GetForgeListResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"GetForgeList_resp\" type=\"tns:GetForgeList_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"SearchCrossForge\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"SearchCrossForge_req\" type=\"tns:SearchCrossForge_req\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "            <xs:element name=\"SearchCrossForgeResponse\">",
                "                <xs:complexType>",
                "                    <xs:sequence>",
                "                        <xs:element name=\"SearchCrossForge_resp\" type=\"tns:SearchCrossForge_resp\"/>",
                "                    </xs:sequence>",
                "                </xs:complexType>",
                "            </xs:element>",
                "        </xs:schema>",
                "    </wsdl:types>",
                "    <wsdl:message name=\"GetForgeListSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetForgeList\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"GetForgeListSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:GetForgeListResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"SearchCrossForgeSoapIn\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:SearchCrossForge\"/>",
                "    </wsdl:message>",
                "    <wsdl:message name=\"SearchCrossForgeSoapOut\">",
                "        <wsdl:part name=\"parameters\" element=\"tns:SearchCrossForgeResponse\"/>",
                "    </wsdl:message>",
                "    <wsdl:portType name=\"QualiPSoXFAPISoapPortType\">",
                "        <wsdl:operation name=\"GetForgeList\">",
                "            <wsdl:input message=\"tns:GetForgeListSoapIn\"/>",
                "            <wsdl:output message=\"tns:GetForgeListSoapOut\"/>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"SearchCrossForge\">",
                "            <wsdl:input message=\"tns:SearchCrossForgeSoapIn\"/>",
                "            <wsdl:output message=\"tns:SearchCrossForgeSoapOut\"/>",
                "        </wsdl:operation>",
                "    </wsdl:portType>",
                "    <wsdl:binding name=\"QualiPSoXFAPISoapBinding\" type=\"tns:QualiPSoXFAPISoapPortType\">",
                "        <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>",
                "        <wsdl:operation name=\"GetForgeList\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/xf/GetForgeList\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "        <wsdl:operation name=\"SearchCrossForge\">",
                "            <soap:operation soapAction=\"http://www.qualipso.org/advdoc/ws/xf/SearchCrossForge\"/>",
                "            <wsdl:input>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:input>",
                "            <wsdl:output>",
                "                <soap:body use=\"literal\"/>",
                "            </wsdl:output>",
                "        </wsdl:operation>",
                "    </wsdl:binding>",
                "    <wsdl:service name=\"QualiPSoXFAPI\">",
                "        <wsdl:port name=\"QualiPSoXFAPISoapPort\" binding=\"tns:QualiPSoXFAPISoapBinding\">",
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
	    		    writer.write("<FORM name=\"formSOAP\" action=\""+serviceURL+"?SOAPAction=http://www.qualipso.org/advdoc/ws/xf/"+showMethod+"\" method=\"post\">");
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
	    		writer.write("<TITLE>QualiPSoXFAPI</TITLE>");
	    		writer.write("</HEAD>");
	    		writer.write("<BODY>");
                writer.println("<H2>Servicio Web <B>QualiPSoXFAPI</B></H2><P/>");
                writer.println("OPERACIONES<P/>");
                writer.println("<OL>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=GetForgeList&inbean=GetForgeList_req&outbean=GetForgeList_resp\">GetForgeList</A> (input : <A HREF=\""+serviceURL+"?showFrame=GetForgeList_req\">GetForgeList_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=GetForgeList_resp\">GetForgeList_resp</A>)");
                writer.write("</LI>");
                writer.write("<LI>");
                writer.write("<A HREF=\""+serviceURL+"?showMethod=SearchCrossForge&inbean=SearchCrossForge_req&outbean=SearchCrossForge_resp\">SearchCrossForge</A> (input : <A HREF=\""+serviceURL+"?showFrame=SearchCrossForge_req\">SearchCrossForge_req</A>, output : <A HREF=\""+serviceURL+"?showFrame=SearchCrossForge_resp\">SearchCrossForge_resp</A>)");
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
        if ("org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_req".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_req");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
        if ("org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_resp".endsWith(classname)) {
            try {
		        return Class.forName("org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_resp");
   			} catch (Exception e) {
   			    // seguir
   			}
        }
		// Buscar alg�n import con * y probar a instanciar din�micamente
		if ("org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.xf.beans.GetForgeList_resp","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_req".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_req","*",classname);
            try {
		        return Class.forName(cn);
   			} catch (Exception e) {
                // Traza
                //new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
                new es.tid.frawa.common.TdiFrawaTraceListener().trace(e);
   			}
		}
		if ("org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_resp".endsWith("*")) {
			// Sustituir * por la clase
			String cn = tdi.text.StringUtil.replace("org.qualipso.advdoc.ws.client.xf.beans.SearchCrossForge_resp","*",classname);
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