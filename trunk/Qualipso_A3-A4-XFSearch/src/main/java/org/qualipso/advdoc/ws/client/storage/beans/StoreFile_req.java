//ead2674e4e677d9eec226ff51eec5150

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : StoreFile_req.java
// Proyecto : QualiPSoStorage
// Versión  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.storage.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * 
 * @composed 1 - 1 org.qualipso.advdoc.ws.client.storage.beans.FolderPath
 * @author FRAWA
 * @version 1.0
 */
public class StoreFile_req extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     * 
     */
    protected String contents = "";
    /**
     * 
     */
    protected String filename = "";
    /**
     * 
     */
    protected int overwrite = 0;
    /**
     * 
     */
    protected org.qualipso.advdoc.ws.client.storage.beans.FolderPath path = new org.qualipso.advdoc.ws.client.storage.beans.FolderPath();

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public StoreFile_req() {
        // Registrarse como Observer de los atributos hijos
        this.path.addObserver(this);
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public StoreFile_req(StoreFile_req object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(StoreFile_req object) {
        setContents(object.getContents());
        setFilename(object.getFilename());
        setOverwrite(object.getOverwrite());
        getPath().set(object.getPath());
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    contents    
     * @param    filename    
     * @param    overwrite    
     * @param    path    
     */
    public StoreFile_req(org.qualipso.advdoc.ws.client.storage.beans.FolderPath path,String filename,int overwrite,String contents) {
        setContents(contents);
        setFilename(filename);
        setOverwrite(overwrite);
        setPath(path);
    }



    /**
     * Conversión a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("StoreFile_req",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        ok = ok && this.getPath().valida(errores);
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof StoreFile_req)) {
            return false;
        }
        StoreFile_req value = (StoreFile_req)obj;
        if (!(value.contents.equals(this.contents))) {
            return false;
        }
        if (!(value.filename.equals(this.filename))) {
            return false;
        }
        if (value.overwrite != this.overwrite) {
            return false;
        }
        if (!(value.path.equals(this.path))) {
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
        // Concatenar con el hashcode del atributo contents
        code = tdi.gen.TdiHashcode.concat(code,this.contents);
        // Concatenar con el hashcode del atributo filename
        code = tdi.gen.TdiHashcode.concat(code,this.filename);
        // Concatenar con el hashcode del atributo overwrite
        code = tdi.gen.TdiHashcode.concat(code,this.overwrite);
        // Concatenar con el hashcode del atributo path
        code = tdi.gen.TdiHashcode.concat(code,this.path);
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(StoreFile_req[] __array1,StoreFile_req[] __array2) {
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
     * Lectura del atributo contents
     * @return   Valor del atributo contents
     */
    public String getContents() { return this.contents; }

    /**
     * Escritura del atributo contents
     * @param    valor    Nuevo valor del atributo contents
     */
    public void setContents(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.contents = valor;
        setChanged();
    }

    /**
     * Lectura del atributo filename
     * @return   Valor del atributo filename
     */
    public String getFilename() { return this.filename; }

    /**
     * Escritura del atributo filename
     * @param    valor    Nuevo valor del atributo filename
     */
    public void setFilename(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.filename = valor;
        setChanged();
    }

    /**
     * Lectura del atributo overwrite
     * @return   Valor del atributo overwrite
     */
    public int getOverwrite() { return this.overwrite; }

    /**
     * Escritura del atributo overwrite
     * @param    valor    Nuevo valor del atributo overwrite
     */
    public void setOverwrite(int valor) { 
        this.overwrite = valor;
        setChanged();
    }

    /**
     * Lectura del atributo path
     * @return   Valor del atributo path
     */
    public org.qualipso.advdoc.ws.client.storage.beans.FolderPath getPath() { return this.path; }

    /**
     * Escritura del atributo path
     * @param    valor    Nuevo valor del atributo path
     */
    public void setPath(org.qualipso.advdoc.ws.client.storage.beans.FolderPath valor) { 
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.storage.beans.FolderPath();
        }
        // Desregistrarse como Observer del objeto anterior
        if (this.path != null) this.path.deleteObserver(this);
        this.path = valor;
        setChanged();
        // Registrarse como Observer del nuevo objeto
        if (this.path != null) this.path.addObserver(this);
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
                "StoreFile_req <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string contents<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string filename<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int overwrite<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FolderPath path<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string[] folders<BR>",
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
        this.setContents("string");
        this.setFilename("string");
        this.setOverwrite(0);
        this.path.fillSampleData();
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append(this.contents);
    output.append(this.filename);
    output.append(this.overwrite);
    output.append(this.path);
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    this.contents = input.extract_String();
    this.filename = input.extract_String();
    this.overwrite = input.extract_int();
    input.extract_object(path);
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
        js.append(varName+".__constructor__ = 'StoreFile_req';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.storage.beans';\n");
    }
    js.append(varName+".contents = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.contents)+"';\n");
    js.append(varName+".filename = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.filename)+"';\n");
    js.append(varName+".overwrite = "+this.overwrite+";\n");
    js.append(this.path.toJS(false,true,varName+".path",indents));
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"StoreFile_req\" package=\"org.qualipso.advdoc.ws.client.storage.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<StoreFile_req type=\"StoreFile_req\" package=\"org.qualipso.advdoc.ws.client.storage.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<contents type=\"string\">"+tdi.text.StringUtil.escapeXML(this.contents,false)+"</contents>");
    } else {
        xml.append(_indentar(indents+1)+"<contents type=\"string\">"+this.contents+"</contents>");
    }

    xml.append("\n");
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<filename type=\"string\">"+tdi.text.StringUtil.escapeXML(this.filename,false)+"</filename>");
    } else {
        xml.append(_indentar(indents+1)+"<filename type=\"string\">"+this.filename+"</filename>");
    }

    xml.append("\n");
    xml.append(_indentar(indents+1)+"<overwrite type=\"int\">"+this.overwrite+"</overwrite>");
    xml.append("\n");
    xml.append(path.toXML("path", indents+1,ponerIndicesDeArrays,escaparStrings));
    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</StoreFile_req>");
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
    __struct__.put("contents", tdi.text.StringUtil.sustituyeUnicode(this.contents));
    __struct__.put("filename", tdi.text.StringUtil.sustituyeUnicode(this.filename));
    __struct__.put("overwrite", new Integer(overwrite));
    java.util.Hashtable path__ht__ = (java.util.Hashtable)path.toRPC();
    if (path!=null && !path.getClass().getName().equals(org.qualipso.advdoc.ws.client.storage.beans.FolderPath.class.getName())) {
        path__ht__.put("__constructor__", path.getClass().getName());
    }
    __struct__.put("path", path__ht__);
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_contents = __params__.get("contents");
    if (__object_contents == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo contents");
    }
    if (!(__object_contents instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo contents no es de tipo String");
    }
    setContents((String)__object_contents);
    Object __object_filename = __params__.get("filename");
    if (__object_filename == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo filename");
    }
    if (!(__object_filename instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo filename no es de tipo String");
    }
    setFilename((String)__object_filename);
    Object __object_overwrite = __params__.get("overwrite");
    if (__object_overwrite == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo overwrite");
    }
    if (!(__object_overwrite instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo overwrite no es de tipo Integer");
    }
    Integer __int_overwrite = (Integer)__object_overwrite;
    setOverwrite(__int_overwrite.intValue());
    Object __object_path = __params__.get("path");
    if (__object_path == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo path");
    }
    if (!(__object_path instanceof java.util.Hashtable)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo path no es de tipo Hashtable");
    }
    java.util.Hashtable __hashtable_path = (java.util.Hashtable)__object_path;
    org.qualipso.advdoc.ws.client.storage.beans.FolderPath __value_path;
    String path__constructor__ = (String)__hashtable_path.get("__constructor__");
    // Si existe el atributo __constructor__ crear el objeto de la clase indicada
    if (path__constructor__ == null || path__constructor__.length()==0) {
        __value_path = new org.qualipso.advdoc.ws.client.storage.beans.FolderPath();
    } else {
        __value_path = (org.qualipso.advdoc.ws.client.storage.beans.FolderPath)Class.forName(path__constructor__).newInstance();
    }
    __value_path.fromRPC(__hashtable_path);
    setPath(__value_path);
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
      org.w3c.dom.Element __e = getNodeByName(__node,"contents");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setContents(__v);
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"filename");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setFilename(__v);
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"overwrite");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setOverwrite(Integer.parseInt(__v));
    }
    {
      org.w3c.dom.Element __e = getNodeByName(__node,"path");
      org.qualipso.advdoc.ws.client.storage.beans.FolderPath __v;
      if (__e != null) {
        if (__e.getAttribute("package") != null && __e.getAttribute("package").length() != 0) {
          __v = (org.qualipso.advdoc.ws.client.storage.beans.FolderPath) Class.forName(__e.getAttribute("package")+"."+__e.getAttribute("type")).newInstance();
        } else {
          __v = new org.qualipso.advdoc.ws.client.storage.beans.FolderPath();
        }
        __v.fromXML(__e);
      } else {
        __v = new org.qualipso.advdoc.ws.client.storage.beans.FolderPath();
      }
      setPath(__v);
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
        writer.write("<contents>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getContents(), false));
        writer.write("</contents>");
        writer.write("\n");
        writer.write("<filename>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getFilename(), false));
        writer.write("</filename>");
        writer.write("\n");
        writer.write("<overwrite>");
        writer.write(Integer.toString(this.getOverwrite()));
        writer.write("</overwrite>");
        writer.write("\n");
        writer.write("<path>");
        this.getPath().toSOAP(writer);
        writer.write("</path>");
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

        node = beanNode.getFirstChildByName("contents");
        if (node != null && node.getContents() != null) {
            this.setContents(node.getContents());
        }

        node = beanNode.getFirstChildByName("filename");
        if (node != null && node.getContents() != null) {
            this.setFilename(node.getContents());
        }

        node = beanNode.getFirstChildByName("overwrite");
        if (node != null && node.getContents() != null) {
            this.setOverwrite(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("path");
        if (node != null && node.getContents() != null) {
            this.path.fromSOAP(node);
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
        json.put("contents",this.getContents());
        json.put("filename",this.getFilename());
        json.put("overwrite",this.getOverwrite());
        jObject = new JSONObject();
        this.getPath().toJSON(jObject);
        json.put("path",jObject);
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
        this.setContents(json.getString("contents"));
        this.setFilename(json.getString("filename"));
        this.setOverwrite(json.getInt("overwrite"));
        this.getPath().fromJSON(json.getJSONObject("path"));
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
        return new StoreFile_req(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof StoreFile_req)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        StoreFile_req bean = (StoreFile_req)source;
        this.set(bean);
    }

}
