//b66ba71338a6905452c6cd3e162a82e6

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : ExecQuery_resp.java
// Proyecto : QualiPSoSearchAPI
// Versión  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.search.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * 
 * @composed 1 - 1 org.qualipso.advdoc.ws.client.search.beans.SPARQLResult
 * @author FRAWA
 * @version 1.0
 */
public class ExecQuery_resp extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     * 
     */
    protected org.qualipso.advdoc.ws.client.search.beans.SPARQLResult result = new org.qualipso.advdoc.ws.client.search.beans.SPARQLResult();
    /**
     * SPARQL query
     */
    protected String sparql = "";
    /**
     * Query time in seconds
     */
    protected double time = 0.0;

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public ExecQuery_resp() {
        // Registrarse como Observer de los atributos hijos
        this.result.addObserver(this);
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public ExecQuery_resp(ExecQuery_resp object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(ExecQuery_resp object) {
        getResult().set(object.getResult());
        setSparql(object.getSparql());
        setTime(object.getTime());
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    result    
     * @param    sparql    SPARQL query
     * @param    time    Query time in seconds
     */
    public ExecQuery_resp(org.qualipso.advdoc.ws.client.search.beans.SPARQLResult result,String sparql,double time) {
        setResult(result);
        setSparql(sparql);
        setTime(time);
    }



    /**
     * Conversión a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("ExecQuery_resp",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        ok = ok && this.getResult().valida(errores);
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof ExecQuery_resp)) {
            return false;
        }
        ExecQuery_resp value = (ExecQuery_resp)obj;
        if (!(value.result.equals(this.result))) {
            return false;
        }
        if (!(value.sparql.equals(this.sparql))) {
            return false;
        }
        if (value.time != this.time) {
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
        // Concatenar con el hashcode del atributo result
        code = tdi.gen.TdiHashcode.concat(code,this.result);
        // Concatenar con el hashcode del atributo sparql
        code = tdi.gen.TdiHashcode.concat(code,this.sparql);
        // Concatenar con el hashcode del atributo time
        code = tdi.gen.TdiHashcode.concat(code,this.time);
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(ExecQuery_resp[] __array1,ExecQuery_resp[] __array2) {
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
     * Lectura del atributo result
     * @return   Valor del atributo result
     */
    public org.qualipso.advdoc.ws.client.search.beans.SPARQLResult getResult() { return this.result; }

    /**
     * Escritura del atributo result
     * @param    valor    Nuevo valor del atributo result
     */
    public void setResult(org.qualipso.advdoc.ws.client.search.beans.SPARQLResult valor) { 
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.search.beans.SPARQLResult();
        }
        // Desregistrarse como Observer del objeto anterior
        if (this.result != null) this.result.deleteObserver(this);
        this.result = valor;
        setChanged();
        // Registrarse como Observer del nuevo objeto
        if (this.result != null) this.result.addObserver(this);
    }

    /**
     * Lectura del atributo sparql
     * @return   Valor del atributo sparql
     */
    public String getSparql() { return this.sparql; }

    /**
     * Escritura del atributo sparql
     * @param    valor    Nuevo valor del atributo sparql
     */
    public void setSparql(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.sparql = valor;
        setChanged();
    }

    /**
     * Lectura del atributo time
     * @return   Valor del atributo time
     */
    public double getTime() { return this.time; }

    /**
     * Escritura del atributo time
     * @param    valor    Nuevo valor del atributo time
     */
    public void setTime(double valor) { 
        this.time = valor;
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
                "ExecQuery_resp <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string sparql<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double time<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SPARQLResult result<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string[] columns<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Row[] rows<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Node[] nodes<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int isLiteral<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string value<BR>",
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
        this.result.fillSampleData();
        this.setSparql("string");
        this.setTime(0.0);
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append(this.result);
    output.append(this.sparql);
    output.append(this.time);
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    input.extract_object(result);
    this.sparql = input.extract_String();
    this.time = input.extract_double();
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
        js.append(varName+".__constructor__ = 'ExecQuery_resp';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.search.beans';\n");
    }
    js.append(this.result.toJS(false,true,varName+".result",indents));
    js.append(varName+".sparql = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.sparql)+"';\n");
    js.append(varName+".time = "+this.time+";\n");
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"ExecQuery_resp\" package=\"org.qualipso.advdoc.ws.client.search.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<ExecQuery_resp type=\"ExecQuery_resp\" package=\"org.qualipso.advdoc.ws.client.search.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    xml.append(result.toXML("result", indents+1,ponerIndicesDeArrays,escaparStrings));
    xml.append("\n");
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<sparql type=\"string\">"+tdi.text.StringUtil.escapeXML(this.sparql,false)+"</sparql>");
    } else {
        xml.append(_indentar(indents+1)+"<sparql type=\"string\">"+this.sparql+"</sparql>");
    }

    xml.append("\n");
    xml.append(_indentar(indents+1)+"<time type=\"double\">"+this.time+"</time>");
    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</ExecQuery_resp>");
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
    java.util.Hashtable result__ht__ = (java.util.Hashtable)result.toRPC();
    if (result!=null && !result.getClass().getName().equals(org.qualipso.advdoc.ws.client.search.beans.SPARQLResult.class.getName())) {
        result__ht__.put("__constructor__", result.getClass().getName());
    }
    __struct__.put("result", result__ht__);
    __struct__.put("sparql", tdi.text.StringUtil.sustituyeUnicode(this.sparql));
    __struct__.put("time", new Double(time));
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_result = __params__.get("result");
    if (__object_result == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo result");
    }
    if (!(__object_result instanceof java.util.Hashtable)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo result no es de tipo Hashtable");
    }
    java.util.Hashtable __hashtable_result = (java.util.Hashtable)__object_result;
    org.qualipso.advdoc.ws.client.search.beans.SPARQLResult __value_result;
    String result__constructor__ = (String)__hashtable_result.get("__constructor__");
    // Si existe el atributo __constructor__ crear el objeto de la clase indicada
    if (result__constructor__ == null || result__constructor__.length()==0) {
        __value_result = new org.qualipso.advdoc.ws.client.search.beans.SPARQLResult();
    } else {
        __value_result = (org.qualipso.advdoc.ws.client.search.beans.SPARQLResult)Class.forName(result__constructor__).newInstance();
    }
    __value_result.fromRPC(__hashtable_result);
    setResult(__value_result);
    Object __object_sparql = __params__.get("sparql");
    if (__object_sparql == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo sparql");
    }
    if (!(__object_sparql instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo sparql no es de tipo String");
    }
    setSparql((String)__object_sparql);
    Object __object_time = __params__.get("time");
    if (__object_time == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo time");
    }
    if (!(__object_time instanceof Double) && !(__object_time instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo time no es de tipo Double");
    }
    Double __double_time = new Double(__object_time.toString());
    setTime(__double_time.doubleValue());
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
      org.w3c.dom.Element __e = getNodeByName(__node,"result");
      org.qualipso.advdoc.ws.client.search.beans.SPARQLResult __v;
      if (__e != null) {
        if (__e.getAttribute("package") != null && __e.getAttribute("package").length() != 0) {
          __v = (org.qualipso.advdoc.ws.client.search.beans.SPARQLResult) Class.forName(__e.getAttribute("package")+"."+__e.getAttribute("type")).newInstance();
        } else {
          __v = new org.qualipso.advdoc.ws.client.search.beans.SPARQLResult();
        }
        __v.fromXML(__e);
      } else {
        __v = new org.qualipso.advdoc.ws.client.search.beans.SPARQLResult();
      }
      setResult(__v);
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"sparql");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setSparql(__v);
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"time");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setTime(Double.parseDouble(__v));
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
        writer.write("<result>");
        this.getResult().toSOAP(writer);
        writer.write("</result>");
        writer.write("\n");
        writer.write("<sparql>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getSparql(), false));
        writer.write("</sparql>");
        writer.write("\n");
        writer.write("<time>");
        writer.write(Double.toString(this.getTime()));
        writer.write("</time>");
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

        node = beanNode.getFirstChildByName("result");
        if (node != null && node.getContents() != null) {
            this.result.fromSOAP(node);
        }

        node = beanNode.getFirstChildByName("sparql");
        if (node != null && node.getContents() != null) {
            this.setSparql(node.getContents());
        }

        node = beanNode.getFirstChildByName("time");
        if (node != null && node.getContents() != null) {
            this.setTime(Double.parseDouble(node.getContents()));
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
        jObject = new JSONObject();
        this.getResult().toJSON(jObject);
        json.put("result",jObject);
        json.put("sparql",this.getSparql());
        json.put("time",this.getTime());
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
        this.getResult().fromJSON(json.getJSONObject("result"));
        this.setSparql(json.getString("sparql"));
        this.setTime(json.getDouble("time"));
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
        return new ExecQuery_resp(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof ExecQuery_resp)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        ExecQuery_resp bean = (ExecQuery_resp)source;
        this.set(bean);
    }

}
