//aa0fc2debb34b1c593c617701187

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : AddLiteralProperties_req.java
// Proyecto : QualiPSoFeedAPI
// Versión  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.feed.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * 
 * @composed 1 - 0..* org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty
 * @author FRAWA
 * @version 1.0
 */
public class AddLiteralProperties_req extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     * 
     */
    protected String resourceUri = "";
    /**
     *  ( org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty[] )
     * @composed org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty
     */
    protected ObjectVector literalProperties = new ObjectVector(10);

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public AddLiteralProperties_req() {
        // Registrarse como Observer de los atributos hijos
        this.literalProperties.addObserver(this);
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public AddLiteralProperties_req(AddLiteralProperties_req object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(AddLiteralProperties_req object) {
        setResourceUri(object.getResourceUri());
        this.literalProperties.clear();
        for (int i = 0;i < object.literalProperties.size();i++) {
            addLiteralProperties(new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty(object.getLiteralProperties(i)));
        }
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    resourceUri    
     * @param    literalProperties    
     */
    public AddLiteralProperties_req(String resourceUri,org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty[] literalProperties) {
        setResourceUri(resourceUri);
        for (int __i = 0;__i < literalProperties.length;__i++) {
            addLiteralProperties(literalProperties[__i]);
        }
    }



    /**
     * Conversión a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("AddLiteralProperties_req",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        for (int i = 0;i < this.literalProperties_size();i++) {
            ok = ok && this.getLiteralProperties(i).valida(errores);
        }
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof AddLiteralProperties_req)) {
            return false;
        }
        AddLiteralProperties_req value = (AddLiteralProperties_req)obj;
        if (!(value.resourceUri.equals(this.resourceUri))) {
            return false;
        }
        if (value.literalProperties.size() != this.literalProperties.size()) {
            return false;
        }
        for (int i = 0;i < value.literalProperties.size();i++) {
            if (!(value.getLiteralProperties(i).equals(this.getLiteralProperties(i)))) {
                return false;
            }
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
        // Concatenar con el hashcode del atributo resourceUri
        code = tdi.gen.TdiHashcode.concat(code,this.resourceUri);
        // Concatenar con el hashcode del atributo literalProperties
        for (int i = 0;i < literalProperties.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getLiteralProperties(i));
        }
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(AddLiteralProperties_req[] __array1,AddLiteralProperties_req[] __array2) {
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
     * Lectura del atributo resourceUri
     * @return   Valor del atributo resourceUri
     */
    public String getResourceUri() { return this.resourceUri; }

    /**
     * Escritura del atributo resourceUri
     * @param    valor    Nuevo valor del atributo resourceUri
     */
    public void setResourceUri(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.resourceUri = valor;
        setChanged();
    }

    /**
     * Vacia los elementos del atributo literalProperties
     */
    public void clearLiteralProperties() { this.literalProperties.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo literalProperties
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeLiteralProperties(int position) {
        return this.literalProperties.remove(position);
    }

    /**
     * Número de elementos en el atributo literalProperties
     * @return   Número de elementos
     */
    public int literalProperties_size() { return this.literalProperties.size(); }

    /**
     * Elementos del atributo literalProperties
     * @return   Array de elementos
     */
    public org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty[] getLiteralProperties() {
        return (org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty[])this.literalProperties.toArray(new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty[this.literalProperties.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo literalProperties
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty getLiteralProperties(int position) {
        return (org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty)this.literalProperties.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo literalProperties
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setLiteralProperties(int position,org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty();
        }
        this.literalProperties.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo literalProperties
     * @param    valores    Los nuevos elementos
     */
    public void setLiteralProperties(org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty[] valores) {
        this.literalProperties = new ObjectVector(valores);
        this.literalProperties.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo literalProperties
     * @param    valor    Nuevo elemento
     */
    public void addLiteralProperties(org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty();
        }
        this.literalProperties.addElement(valor);
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
                "AddLiteralProperties_req <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string resourceUri<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LiteralProperty[] literalProperties<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string propertyUri<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string value<BR>",
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
        this.setResourceUri("string");
        this.literalProperties.clear();
        org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty v_0_1 = new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty();
        v_0_1.fillSampleData();
        this.addLiteralProperties(v_0_1);
        org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty v_0_2 = new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty();
        v_0_2.fillSampleData();
        this.addLiteralProperties(v_0_2);
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append(this.resourceUri);
    output.append((int)this.literalProperties.size());
    for (int i=0; i<this.literalProperties.size(); i++) {
      output.append((org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty)this.literalProperties.elementAt(i));
    }
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    this.resourceUri = input.extract_String();
    {
        int len = input.extract_int();
        this.literalProperties = new ObjectVector(len);
        this.literalProperties.addObserver(this);
        for (int i = 0; i < len; i++) {
          org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty aux = new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty();
          input.extract_object(aux);
          this.literalProperties.addElement(aux);
        }
    }
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
        js.append(varName+".__constructor__ = 'AddLiteralProperties_req';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.feed.beans';\n");
    }
    js.append(varName+".resourceUri = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.resourceUri)+"';\n");
    js.append(varName+".literalProperties = new Array("+this.literalProperties.size()+");\n");
    for (int i = 0;i < this.literalProperties.size();i++) {
        TdiJavascriptable object = (TdiJavascriptable)this.literalProperties.elementAt(i);
        js.append(object.toJS(false,true,varName+".literalProperties["+i+"]",0));
    }
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"AddLiteralProperties_req\" package=\"org.qualipso.advdoc.ws.client.feed.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<AddLiteralProperties_req type=\"AddLiteralProperties_req\" package=\"org.qualipso.advdoc.ws.client.feed.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<resourceUri type=\"string\">"+tdi.text.StringUtil.escapeXML(this.resourceUri,false)+"</resourceUri>");
    } else {
        xml.append(_indentar(indents+1)+"<resourceUri type=\"string\">"+this.resourceUri+"</resourceUri>");
    }

    xml.append("\n");
    xml.append(_indentar(indents+1)+"<literalProperties type=\"org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty[]\" size=\""+this.literalProperties.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.literalProperties.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(((org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty)literalProperties.elementAt(i)).toXML("literalProperties"+"_"+sufijo, indents+2,ponerIndicesDeArrays,escaparStrings));
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</literalProperties>");
    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</AddLiteralProperties_req>");
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
    __struct__.put("resourceUri", tdi.text.StringUtil.sustituyeUnicode(this.resourceUri));
    java.util.Vector __vector_literalProperties = new java.util.Vector();
    for (int __i__ = 0;__i__ < literalProperties.size();__i__++) {
        org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty __object__ = (org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty)literalProperties.elementAt(__i__);
        __vector_literalProperties.addElement(__object__.toRPC());
    }
    __struct__.put("literalProperties",__vector_literalProperties);
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_resourceUri = __params__.get("resourceUri");
    if (__object_resourceUri == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo resourceUri");
    }
    if (!(__object_resourceUri instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo resourceUri no es de tipo String");
    }
    setResourceUri((String)__object_resourceUri);
    Object __object_literalProperties = __params__.get("literalProperties");
    if (__object_literalProperties == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector literalProperties");
    }
    if (!(__object_literalProperties instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo literalProperties no es de tipo Vector");
    }
    java.util.Vector __vector_literalProperties = (java.util.Vector)__object_literalProperties;
    for (int i = 0;i < __vector_literalProperties.size();i++) {
        Object __element__ = __vector_literalProperties.elementAt(i);
        if (!(__element__ instanceof java.util.Hashtable)) {
            throw new Exception(getClass().getName()+".fromRPC() El atributo literalProperties no es de tipo Hashtable");
        }
        java.util.Hashtable __hashtable__ = (java.util.Hashtable)__element__;
        org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty __value__;
        String __constructor__ = (String)__hashtable__.get("__constructor__");
        // Si existe el atributo __constructor__ crear el objeto de la clase indicada
        if (__constructor__ == null || __constructor__.equals("")) {
            __value__ = new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty();
        } else {
            __value__ = (org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty)Class.forName(__constructor__).newInstance();
        }
        __value__.fromRPC(__hashtable__);
        addLiteralProperties(__value__);
    }
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
      org.w3c.dom.Element __e = getNodeByName(__node,"resourceUri");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setResourceUri(__v);
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"literalProperties");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        org.w3c.dom.Element __element2 = getNodeByName(__element,"literalProperties_"+i);
        org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty __entry;
        if (__element2.getAttribute("package") != null && __element2.getAttribute("package").length() != 0) {
          __entry = (org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty) Class.forName(__element2.getAttribute("package")+"."+__element2.getAttribute("type")).newInstance();
        } else {
          __entry = new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty();
        }
        __entry.fromXML(__element2);
        addLiteralProperties(__entry);
      }
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
        writer.write("<resourceUri>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getResourceUri(), false));
        writer.write("</resourceUri>");
        writer.write("\n");
        writer.write("<literalProperties>");
        writer.write("\n");
        for (int i = 0; i < literalProperties_size(); i++) {
            writer.write("<LiteralProperty>");
            writer.write("\n");
            this.getLiteralProperties(i).toSOAP(writer);
            writer.write("</LiteralProperty>");
            writer.write("\n");
        }
        writer.write("</literalProperties>");
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

        node = beanNode.getFirstChildByName("resourceUri");
        if (node != null && node.getContents() != null) {
            this.setResourceUri(node.getContents());
        }

        tdi.xml.parser.TdiXmlNode[] arrayNodes;
        node = beanNode.getFirstChildByName("literalProperties");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("LiteralProperty");
            if (arrayNodes != null) {
                this.clearLiteralProperties();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty tmp = new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty();
                        tmp.fromSOAP(arrayNodes[i]);
                        this.addLiteralProperties(tmp);
                    }  // arrayNodes[i] != null
                }  // for
            }  // arrayNodes != null
        }  // node != null
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
        json.put("resourceUri",this.getResourceUri());
        JSONArray jArray;
        JSONArray jObjectArray;
        jObjectArray = new JSONArray();
        for (int i = 0;i < literalProperties_size();i++) {
            JSONObject jObj_i = new JSONObject();
            this.getLiteralProperties(i).toJSON(jObj_i);
            jObjectArray.put(jObj_i);
        }
        json.put("literalProperties",jObjectArray);
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
        this.setResourceUri(json.getString("resourceUri"));
        JSONArray jArray;
        JSONArray jObjectArray;
        jObjectArray = json.getJSONArray("literalProperties");
        this.clearLiteralProperties();
        for (int i = 0;i < jObjectArray.length();i++) {
            JSONObject jObj_i = jObjectArray.getJSONObject(i);
            org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty tmp = new org.qualipso.advdoc.ws.client.feed.beans.LiteralProperty();
            tmp.fromJSON(jObj_i);
            this.addLiteralProperties(tmp);
        }
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
        return new AddLiteralProperties_req(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof AddLiteralProperties_req)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        AddLiteralProperties_req bean = (AddLiteralProperties_req)source;
        this.set(bean);
    }

}
