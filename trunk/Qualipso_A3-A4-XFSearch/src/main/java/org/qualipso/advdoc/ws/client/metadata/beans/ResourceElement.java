//48a5c9492c7ecac60ced9979342e6a6

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : ResourceElement.java
// Proyecto : QualiPSoMetadataAPI
// Versión  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.metadata.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * Class or Property
 * @author FRAWA
 * @version 1.0
 */
public class ResourceElement extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     * 
     */
    protected String comment = "";
    /**
     * 
     */
    protected String label = "";
    /**
     * 
     */
    protected String localName = "";
    /**
     * 
     */
    protected String namespace = "";
    /**
     * 
     */
    protected String URI = "";

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public ResourceElement() {
        // Registrarse como Observer de los atributos hijos
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public ResourceElement(ResourceElement object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(ResourceElement object) {
        setComment(object.getComment());
        setLabel(object.getLabel());
        setLocalName(object.getLocalName());
        setNamespace(object.getNamespace());
        setURI(object.getURI());
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    comment    
     * @param    label    
     * @param    localName    
     * @param    namespace    
     * @param    URI    
     */
    public ResourceElement(String URI,String namespace,String localName,String label,String comment) {
        setComment(comment);
        setLabel(label);
        setLocalName(localName);
        setNamespace(namespace);
        setURI(URI);
    }



    /**
     * Conversión a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("ResourceElement",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceElement)) {
            return false;
        }
        ResourceElement value = (ResourceElement)obj;
        if (!(value.comment.equals(this.comment))) {
            return false;
        }
        if (!(value.label.equals(this.label))) {
            return false;
        }
        if (!(value.localName.equals(this.localName))) {
            return false;
        }
        if (!(value.namespace.equals(this.namespace))) {
            return false;
        }
        if (!(value.URI.equals(this.URI))) {
            return false;
        }
        return true;
    }


    /**
     * Genera un csdigo hash para el bean basandose en todos los atributos
     * @return   Retorna el csdigo hash del bean
     */
    public int hashCode() {
        // empezamos con un nzmero primo cualquiera
        int code = 7;
        // Concatenar con el hashcode del atributo comment
        code = tdi.gen.TdiHashcode.concat(code,this.comment);
        // Concatenar con el hashcode del atributo label
        code = tdi.gen.TdiHashcode.concat(code,this.label);
        // Concatenar con el hashcode del atributo localName
        code = tdi.gen.TdiHashcode.concat(code,this.localName);
        // Concatenar con el hashcode del atributo namespace
        code = tdi.gen.TdiHashcode.concat(code,this.namespace);
        // Concatenar con el hashcode del atributo URI
        code = tdi.gen.TdiHashcode.concat(code,this.URI);
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(ResourceElement[] __array1,ResourceElement[] __array2) {
        if (__array1.length != __array2.length) {
            return false;
        }
        for (int i = 0;i < __array1.length;i++) {
            if (!__array1[i].equals(__array2[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Lectura del atributo comment
     * @return   Valor del atributo comment
     */
    public String getComment() { return this.comment; }

    /**
     * Escritura del atributo comment
     * @param    valor    Nuevo valor del atributo comment
     */
    public void setComment(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.comment = valor;
        setChanged();
    }

    /**
     * Lectura del atributo label
     * @return   Valor del atributo label
     */
    public String getLabel() { return this.label; }

    /**
     * Escritura del atributo label
     * @param    valor    Nuevo valor del atributo label
     */
    public void setLabel(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.label = valor;
        setChanged();
    }

    /**
     * Lectura del atributo localName
     * @return   Valor del atributo localName
     */
    public String getLocalName() { return this.localName; }

    /**
     * Escritura del atributo localName
     * @param    valor    Nuevo valor del atributo localName
     */
    public void setLocalName(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.localName = valor;
        setChanged();
    }

    /**
     * Lectura del atributo namespace
     * @return   Valor del atributo namespace
     */
    public String getNamespace() { return this.namespace; }

    /**
     * Escritura del atributo namespace
     * @param    valor    Nuevo valor del atributo namespace
     */
    public void setNamespace(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.namespace = valor;
        setChanged();
    }

    /**
     * Lectura del atributo URI
     * @return   Valor del atributo URI
     */
    public String getURI() { return this.URI; }

    /**
     * Escritura del atributo URI
     * @param    valor    Nuevo valor del atributo URI
     */
    public void setURI(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.URI = valor;
        setChanged();
    }


    /********************************************************************/
    /*********************** CODIGO PERSONALIZADO ***********************/
    /********************************************************************/





    /********************************************************************/
    /******************* FIN DEL CODIGO PERSONALIZADO *******************/
    /********************************************************************/



    /********************************************************************/
    /******************** ESTRUCTURA INTERNA DEL BEAN *******************/
    /********************************************************************/


    private static StringBuffer estructura = null;
    public static String getStructure() {
        if (estructura == null) {
            String[] lines = new String[] {
                "ResourceElement <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string comment<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string label<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string localName<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string namespace<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string URI<BR>",
            };
            estructura = new StringBuffer();
            for (int i = 0;i < lines.length;i++) {
                estructura.append(lines[i]);
                estructura.append('\n');
            }
        }
        return estructura.toString();
    }


    /********************************************************************/
    /*************** RELLENAR EL BEAN CON DATOS DE EJEMPLO **************/
    /********************************************************************/


    public void fillSampleData() {
        this.setComment("string");
        this.setLabel("string");
        this.setLocalName("string");
        this.setNamespace("string");
        this.setURI("string");
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append(this.comment);
    output.append(this.label);
    output.append(this.localName);
    output.append(this.namespace);
    output.append(this.URI);
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    this.comment = input.extract_String();
    this.label = input.extract_String();
    this.localName = input.extract_String();
    this.namespace = input.extract_String();
    this.URI = input.extract_String();
    setChanged();
  }


  /**
   * Convierte el bean a Javascript
   * @param    varName    Crea una variable javascript con este nombre
   * @return   Cadena con el csdigo javascript
   */
  public String toJS(String varName) {
      return toJS(true,true,varName,0);
  }

  /**
   * Convierte el bean a Javascript
   * @param    root    Indica si es ramz
   * @param    create    Indica si hay que crear un objeto javascript
   * @param    varName    Nombre de la variable javascript
   * @param    indents    Nzmero de espacios en blanco para indentar
   * @return   Cadena con el csdigo javascript
   */
  public String toJS(boolean root,boolean create,String varName,int indents) {
    StringBuffer js = new StringBuffer();
    if (root) {
        js.append("var ");
    }
    if (create) {
        js.append(varName+" = new Object();\n");
        js.append(varName+".__constructor__ = 'ResourceElement';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.metadata.beans';\n");
    }
    js.append(varName+".comment = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.comment)+"';\n");
    js.append(varName+".label = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.label)+"';\n");
    js.append(varName+".localName = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.localName)+"';\n");
    js.append(varName+".namespace = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.namespace)+"';\n");
    js.append(varName+".URI = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.URI)+"';\n");
    return js.toString();
  }


  /**
   * Convierte el bean a una cadena XMLRPC
   * @return   Cadena XMLRPC
   */
  public String toXMLRPC() {
    try {
      StringBuffer __out = new StringBuffer();
      es.tid.serial.XmlRpcWriter __writer = new es.tid.serial.XmlRpcWriter(__out,es.tid.serial.XmlRpcWriter.ISO8859_1);
      __writer.writeObject(this.toRPC());
      return __out.toString();
    } catch (Exception e) {
      return "ERROR "+getClass().getName()+".toXMLRPC()";
    }
  }

  /**
   * Convierte el bean a una cadena TDI XML
   * @param    tag    Tag XML del elemento ramz
   * @param    indents    Nzmero de espacios en blanco para indentar
   * @return   Cadena TDI XML
   */
  public String toXML(String tag, int indents) {
    return toXML(tag,indents,true,false);
  }

  /**
   * Convierte el bean a una cadena TDI XML
   * @param    tag    Tag XML del elemento ramz
   * @param    indents    Nzmero de espacios en blanco para indentar
   * @param    ponerIndicesDeArrays    Indica si los tags XML de los elementos de los arrays llevaran el mndice del elemento
   * @param    escaparStrings    Indica si hay que escapar los caracteres especiales en los strings
   * @return   Cadena TDI XML
   */
  public String toXML(String tag, int indents,boolean ponerIndicesDeArrays,boolean escaparStrings) {
    StringBuffer xml = new StringBuffer();
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"<"+tag+" type=\"ResourceElement\" package=\"org.qualipso.advdoc.ws.client.metadata.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<ResourceElement type=\"ResourceElement\" package=\"org.qualipso.advdoc.ws.client.metadata.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<comment type=\"string\">"+tdi.text.StringUtil.escapeXML(this.comment,false)+"</comment>");
    } else {
        xml.append(_indentar(indents+1)+"<comment type=\"string\">"+this.comment+"</comment>");
    }

    xml.append("\n");
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<label type=\"string\">"+tdi.text.StringUtil.escapeXML(this.label,false)+"</label>");
    } else {
        xml.append(_indentar(indents+1)+"<label type=\"string\">"+this.label+"</label>");
    }

    xml.append("\n");
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<localName type=\"string\">"+tdi.text.StringUtil.escapeXML(this.localName,false)+"</localName>");
    } else {
        xml.append(_indentar(indents+1)+"<localName type=\"string\">"+this.localName+"</localName>");
    }

    xml.append("\n");
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<namespace type=\"string\">"+tdi.text.StringUtil.escapeXML(this.namespace,false)+"</namespace>");
    } else {
        xml.append(_indentar(indents+1)+"<namespace type=\"string\">"+this.namespace+"</namespace>");
    }

    xml.append("\n");
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<URI type=\"string\">"+tdi.text.StringUtil.escapeXML(this.URI,false)+"</URI>");
    } else {
        xml.append(_indentar(indents+1)+"<URI type=\"string\">"+this.URI+"</URI>");
    }

    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</ResourceElement>");
    }
    return xml.toString();
  }

  /**
   * Rutina para serializar a XMLRPC
   * @return   Hashtable que contiene los datos del bean en la forma clave/valor
   */
  public Object toRPC() {
    java.util.Hashtable __struct__ = new java.util.Hashtable();
    return toRPC(__struct__);
  }

  /**
   * Rutina para serializar a XMLRPC
   * @param    __struct__    Tabla hash donde se aqade el contenido del bean
   * @return   Hashtable que contiene los datos del bean en la forma clave/valor
   */
  protected Object toRPC(java.util.Hashtable __struct__) {
    __struct__.put("comment", tdi.text.StringUtil.sustituyeUnicode(this.comment));
    __struct__.put("label", tdi.text.StringUtil.sustituyeUnicode(this.label));
    __struct__.put("localName", tdi.text.StringUtil.sustituyeUnicode(this.localName));
    __struct__.put("namespace", tdi.text.StringUtil.sustituyeUnicode(this.namespace));
    __struct__.put("URI", tdi.text.StringUtil.sustituyeUnicode(this.URI));
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_comment = __params__.get("comment");
    if (__object_comment == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo comment");
    }
    if (!(__object_comment instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo comment no es de tipo String");
    }
    setComment((String)__object_comment);
    Object __object_label = __params__.get("label");
    if (__object_label == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo label");
    }
    if (!(__object_label instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo label no es de tipo String");
    }
    setLabel((String)__object_label);
    Object __object_localName = __params__.get("localName");
    if (__object_localName == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo localName");
    }
    if (!(__object_localName instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo localName no es de tipo String");
    }
    setLocalName((String)__object_localName);
    Object __object_namespace = __params__.get("namespace");
    if (__object_namespace == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo namespace");
    }
    if (!(__object_namespace instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo namespace no es de tipo String");
    }
    setNamespace((String)__object_namespace);
    Object __object_URI = __params__.get("URI");
    if (__object_URI == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo URI");
    }
    if (!(__object_URI instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo URI no es de tipo String");
    }
    setURI((String)__object_URI);
    setChanged();
  }

  /**
   * Rellena el bean con los datos TDI XML que hay en el stream
   * @param    __is    Stream donde estan los datos serializados en formato TDI XML
   * @param    __b    Cadena donde se va guardando el contenido XML que hay en el stream
   * @param    __pw    Salida donde se escribe el contenido XML que hay en el stream
   * @throws   Exception    Cuando el stream no tiene los datos adecuados para rellenar el bean
   */
  public void fromXML(java.io.InputStream __is,StringBuffer __b,java.io.PrintWriter __pw) throws Exception {
    javax.xml.parsers.DocumentBuilderFactory __dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
    __dbf.setValidating(false);
    javax.xml.parsers.DocumentBuilder __parser = __dbf.newDocumentBuilder();
    int __c;
    while ((__c = __is.read()) >= 0) {
      __b.append((char)__c);
    }
    java.io.StringBufferInputStream __str = new java.io.StringBufferInputStream(__b.toString());
    if (__pw != null) {
      __pw.println(__b.toString());
      __pw.flush();
    }
    org.w3c.dom.Document __doc = __parser.parse(__str);
    org.w3c.dom.Element __root = __doc.getDocumentElement();
    fromXML(__root);
    setChanged();
  }

  /**
   * Rellena el bean con los datos que hay en el stream en formato TDI XML
   * @param    __is    Stream donde estan los datos serializados en formato TDI XML
   * @throws   Exception    Cuando el stream no tiene los datos adecuados para rellenar el bean
   */
  public void fromXML(java.io.InputStream __is) throws Exception {
    javax.xml.parsers.DocumentBuilderFactory __dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
    __dbf.setValidating(false);
    javax.xml.parsers.DocumentBuilder __parser = __dbf.newDocumentBuilder();
    org.w3c.dom.Document __doc = __parser.parse(__is);
    org.w3c.dom.Element __root = __doc.getDocumentElement();
    fromXML(__root);
    setChanged();
  }

  /**
   * Rellena los datos del bean a partir de un nodo DOM en formato TDI XML
   * @param    __node    Nodo DOM que contiene los datos del bean en formato TDI XML
   * @throws   Exception    Cuando el stream no tiene los datos adecuados para rellenar el bean
   */
  public void fromXML(org.w3c.dom.Element __node) throws Exception {
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"comment");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setComment(__v);
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"label");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setLabel(__v);
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"localName");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setLocalName(__v);
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"namespace");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setNamespace(__v);
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"URI");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setURI(__v);
    }

    setChanged();
  }

    /**
     * Serializa el bean en formato SOAP document
     * @throws   java.io.Exception    Cuando se produce una excepción al serializar el bean
     * @return   Cadena de texto en formato SOAP document
     */
    public String toSOAP() throws java.io.IOException {
        java.io.StringWriter writer = new java.io.StringWriter();
        this.toSOAP(writer);
        return writer.toString();
    }



    /**
     * Serializa el bean en formato SOAP document
     * @param    writer    Writer donde se escribirá el bean en formato SOAP document
     * @throws   Exception    Cuando se produce un error en la serialización del bean
     */
    public void toSOAP(java.io.Writer writer) throws java.io.IOException {
        writer.write("<comment>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getComment(), false));
        writer.write("</comment>");
        writer.write("\n");
        writer.write("<label>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getLabel(), false));
        writer.write("</label>");
        writer.write("\n");
        writer.write("<localName>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getLocalName(), false));
        writer.write("</localName>");
        writer.write("\n");
        writer.write("<namespace>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getNamespace(), false));
        writer.write("</namespace>");
        writer.write("\n");
        writer.write("<URI>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getURI(), false));
        writer.write("</URI>");
        writer.write("\n");
    }




    /**
     * Rellena los campos del bean decodificando un documento SOAP document
     * @param    reader    Reader donde se leerá el bean en formato SOAP document
     * @throws   Exception    Cuando se produce un error en la deserialización del bean
     */
    public void fromSOAP(java.io.Reader reader) throws java.io.IOException,org.xml.sax.SAXException {
        tdi.xml.parser.TdiXmlParser parser = new tdi.xml.parser.TdiXmlParser(reader);
        tdi.xml.parser.TdiXmlNode root = parser.getTree();
        if (root != null) {
            this.fromSOAP(root);
        }
    }

    /**
     * Rellena los campos del bean decodificando un nodo SOAP document
     * @param    beanNode    Nodo XML padre que contiene los datos del bean
     * @throws   Exception    Cuando se produce un error en la deserialización del bean
     */
    public void fromSOAP(tdi.xml.parser.TdiXmlNode beanNode) {
        tdi.xml.parser.TdiXmlNode node;

        node = beanNode.getFirstChildByName("comment");
        if (node != null && node.getContents() != null) {
            this.setComment(node.getContents());
        }

        node = beanNode.getFirstChildByName("label");
        if (node != null && node.getContents() != null) {
            this.setLabel(node.getContents());
        }

        node = beanNode.getFirstChildByName("localName");
        if (node != null && node.getContents() != null) {
            this.setLocalName(node.getContents());
        }

        node = beanNode.getFirstChildByName("namespace");
        if (node != null && node.getContents() != null) {
            this.setNamespace(node.getContents());
        }

        node = beanNode.getFirstChildByName("URI");
        if (node != null && node.getContents() != null) {
            this.setURI(node.getContents());
        }

    }



    /**
     * Serializa el bean en formato JSON
     * @throws   es.tid.serial.json.JSONException    Cuando se produce una excepción al serializar el bean
     * @return   Cadena de texto en formato JSON
     */
    public String toJSON(boolean prettyPrint) throws JSONException {
        JSONObject json = new JSONObject();
        this.toJSON(json);
        if (prettyPrint) {
            return json.toString(4);
        } else {
            return json.toString();
        }
    }



    /**
     * Serializa el bean en formato JSON
     * @param    json    objeto donde se escribirá el bean en formato JSON
     * @throws   es.tid.serial.json.JSONException    Cuando se produce un error en la serialización del bean
     */
    public void toJSON(JSONObject json) throws JSONException {
        JSONObject jObject;
        json.put("comment",this.getComment());
        json.put("label",this.getLabel());
        json.put("localName",this.getLocalName());
        json.put("namespace",this.getNamespace());
        json.put("URI",this.getURI());
        JSONArray jArray;
        JSONArray jObjectArray;
    }




    /**
     * Deserializa el bean en formato JSON
     * @throws   es.tid.serial.json.JSONException    Cuando se produce una excepción al deserializar el bean
     */
    public void fromJSON(String str) throws JSONException {
        JSONObject json = new JSONObject(str);
        this.fromJSON(json);
    }



    /**
     * Deserializa el bean en formato JSON
     * @param    json    objeto que contiene los datos del bean en formato JSON
     * @throws   es.tid.serial.json.JSONException    Cuando se produce un error en la deserialización del objeto JSON
     */
    public void fromJSON(JSONObject json) throws JSONException {
        this.setComment(json.getString("comment"));
        this.setLabel(json.getString("label"));
        this.setLocalName(json.getString("localName"));
        this.setNamespace(json.getString("namespace"));
        this.setURI(json.getString("URI"));
        JSONArray jArray;
        JSONArray jObjectArray;
    }





  /**
   * Obtiene una cadena con un determinado nzmero de espacios
   * @param    indents    Nzmero de tabuladores a indentar
   * @return   Cadena con los espacios correspondientes a la indentacisn requerida
   */
  private String _indentar(int indents) {
      return TdiSerialUtil.indentar(indents);
  }


  /**
   * Obtiene el primer nodo de un arbol DOM que cumple el tag especificado
   * @param    parent    Nodo DOM donde se quiere buscar
   * @param    name    Tag que se esta buscando
   * @throws   Exception    Excepciones elevadas por el DOM
   * @return   Cadena TDI XML
   */
  private org.w3c.dom.Element getNodeByName(org.w3c.dom.Element parent,String name) throws Exception {
    org.w3c.dom.NodeList child = parent.getChildNodes();
    for (int i=0; i<child.getLength(); i++) {
      if (name.equals(child.item(i).getNodeName())) {
        return (org.w3c.dom.Element)child.item(i);
      }
    }
    return null;
  }


    /**
     * Actualiza el objeto cuando se modifican los objetos observados (implementacisn de la interfaz java.util.Observer)
     * @param    observable    Objeto hijo que se ha modificado
     * @param    object    Datos asociados (se ignora)
     */
    public void update(java.util.Observable observable,Object object) {
        setChanged();
        notifyObservers();
    }
    /**
     * Construye un objeto copia del actual (implementacisn de la interfaz TdiCloneable)
     * @return   Un nuevo objeto, copia del actual
     */
    public Object clone() {
        return new ResourceElement(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof ResourceElement)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        ResourceElement bean = (ResourceElement)source;
        this.set(bean);
    }

}
