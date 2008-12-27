//fb9fc8c934d14bf9fdc3145fcdf583

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : TestParser.java
// Proyecto : QualiPSoStorage
// Versión  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.storage.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * 
 * @author FRAWA
 * @version 1.0
 */
public class TestParser extends org.qualipso.advdoc.ws.client.storage.beans.TestLoopback implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     * json deserialize time per iteration
     */
    protected int jsonDeserialTime = 0;
    /**
     * json serialize time per iteration
     */
    protected int jsonSerialTime = 0;
    /**
     * 
     */
    protected int numIterations = 0;
    /**
     * soap deserialize time per iteration
     */
    protected int soapDeserialTime = 0;
    /**
     * soap serialize time per iteration
     */
    protected int soapSerialTime = 0;

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public TestParser() {
        // Registrarse como Observer de los atributos hijos
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public TestParser(TestParser object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(TestParser object) {
        super.set(object);
        setJsonDeserialTime(object.getJsonDeserialTime());
        setJsonSerialTime(object.getJsonSerialTime());
        setNumIterations(object.getNumIterations());
        setSoapDeserialTime(object.getSoapDeserialTime());
        setSoapSerialTime(object.getSoapSerialTime());
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    clientRequestTime    (heredado de TestLoopback)
     * @param    clientResponseTime    (heredado de TestLoopback)
     * @param    serverTime    (heredado de TestLoopback)
     * @param    data1    (heredado de TestLoopback)
     * @param    data2    (heredado de TestLoopback)
     * @param    data3    (heredado de TestLoopback)
     * @param    jsonDeserialTime    json deserialize time per iteration
     * @param    jsonSerialTime    json serialize time per iteration
     * @param    numIterations    
     * @param    soapDeserialTime    soap deserialize time per iteration
     * @param    soapSerialTime    soap serialize time per iteration
     */
    public TestParser(int clientRequestTime,int serverTime,int clientResponseTime,org.qualipso.advdoc.ws.client.storage.beans.Composite[] data1,org.qualipso.advdoc.ws.client.storage.beans.Composite[] data2,org.qualipso.advdoc.ws.client.storage.beans.Composite[] data3,int numIterations,int jsonSerialTime,int jsonDeserialTime,int soapSerialTime,int soapDeserialTime) {
        super(clientRequestTime,serverTime,clientResponseTime,data1,data2,data3);
        setJsonDeserialTime(jsonDeserialTime);
        setJsonSerialTime(jsonSerialTime);
        setNumIterations(numIterations);
        setSoapDeserialTime(soapDeserialTime);
        setSoapSerialTime(soapSerialTime);
    }



    /**
     * Conversión a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("TestParser",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        ok = ok && super.valida(errores);
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof TestParser)) {
            return false;
        }
        TestParser value = (TestParser)obj;
        if (!super.equals(obj)) {
            return false;
        }
        if (value.jsonDeserialTime != this.jsonDeserialTime) {
            return false;
        }
        if (value.jsonSerialTime != this.jsonSerialTime) {
            return false;
        }
        if (value.numIterations != this.numIterations) {
            return false;
        }
        if (value.soapDeserialTime != this.soapDeserialTime) {
            return false;
        }
        if (value.soapSerialTime != this.soapSerialTime) {
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
        // Concatenar con el hashcode de la clase padre
        code = tdi.gen.TdiHashcode.concat(code,super.hashCode());
        // Concatenar con el hashcode del atributo jsonDeserialTime
        code = tdi.gen.TdiHashcode.concat(code,this.jsonDeserialTime);
        // Concatenar con el hashcode del atributo jsonSerialTime
        code = tdi.gen.TdiHashcode.concat(code,this.jsonSerialTime);
        // Concatenar con el hashcode del atributo numIterations
        code = tdi.gen.TdiHashcode.concat(code,this.numIterations);
        // Concatenar con el hashcode del atributo soapDeserialTime
        code = tdi.gen.TdiHashcode.concat(code,this.soapDeserialTime);
        // Concatenar con el hashcode del atributo soapSerialTime
        code = tdi.gen.TdiHashcode.concat(code,this.soapSerialTime);
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(TestParser[] __array1,TestParser[] __array2) {
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
     * Lectura del atributo jsonDeserialTime
     * @return   Valor del atributo jsonDeserialTime
     */
    public int getJsonDeserialTime() { return this.jsonDeserialTime; }

    /**
     * Escritura del atributo jsonDeserialTime
     * @param    valor    Nuevo valor del atributo jsonDeserialTime
     */
    public void setJsonDeserialTime(int valor) { 
        this.jsonDeserialTime = valor;
        setChanged();
    }

    /**
     * Lectura del atributo jsonSerialTime
     * @return   Valor del atributo jsonSerialTime
     */
    public int getJsonSerialTime() { return this.jsonSerialTime; }

    /**
     * Escritura del atributo jsonSerialTime
     * @param    valor    Nuevo valor del atributo jsonSerialTime
     */
    public void setJsonSerialTime(int valor) { 
        this.jsonSerialTime = valor;
        setChanged();
    }

    /**
     * Lectura del atributo numIterations
     * @return   Valor del atributo numIterations
     */
    public int getNumIterations() { return this.numIterations; }

    /**
     * Escritura del atributo numIterations
     * @param    valor    Nuevo valor del atributo numIterations
     */
    public void setNumIterations(int valor) { 
        this.numIterations = valor;
        setChanged();
    }

    /**
     * Lectura del atributo soapDeserialTime
     * @return   Valor del atributo soapDeserialTime
     */
    public int getSoapDeserialTime() { return this.soapDeserialTime; }

    /**
     * Escritura del atributo soapDeserialTime
     * @param    valor    Nuevo valor del atributo soapDeserialTime
     */
    public void setSoapDeserialTime(int valor) { 
        this.soapDeserialTime = valor;
        setChanged();
    }

    /**
     * Lectura del atributo soapSerialTime
     * @return   Valor del atributo soapSerialTime
     */
    public int getSoapSerialTime() { return this.soapSerialTime; }

    /**
     * Escritura del atributo soapSerialTime
     * @param    valor    Nuevo valor del atributo soapSerialTime
     */
    public void setSoapSerialTime(int valor) { 
        this.soapSerialTime = valor;
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
                "TestParser  extends TestLoopback<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int clientRequestTime (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int clientResponseTime (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int serverTime (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Composite[] data1 (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int id (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string name (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double value (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string[] comments (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int[] years (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Composite[] data2 (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Composite[] data3 (*)<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int jsonDeserialTime<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int jsonSerialTime<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int numIterations<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int soapDeserialTime<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int soapSerialTime<BR>",
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
        this.setJsonDeserialTime(0);
        this.setJsonSerialTime(0);
        this.setNumIterations(0);
        this.setSoapDeserialTime(0);
        this.setSoapSerialTime(0);
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append(this.jsonDeserialTime);
    output.append(this.jsonSerialTime);
    output.append(this.numIterations);
    output.append(this.soapDeserialTime);
    output.append(this.soapSerialTime);
    super.serialize(output);
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    this.jsonDeserialTime = input.extract_int();
    this.jsonSerialTime = input.extract_int();
    this.numIterations = input.extract_int();
    this.soapDeserialTime = input.extract_int();
    this.soapSerialTime = input.extract_int();
    super.deserialize(input);
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
        js.append(varName+".__constructor__ = 'TestParser';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.storage.beans';\n");
    }
    js.append(super.toJS(false,false,varName,indents));
    js.append(varName+".jsonDeserialTime = "+this.jsonDeserialTime+";\n");
    js.append(varName+".jsonSerialTime = "+this.jsonSerialTime+";\n");
    js.append(varName+".numIterations = "+this.numIterations+";\n");
    js.append(varName+".soapDeserialTime = "+this.soapDeserialTime+";\n");
    js.append(varName+".soapSerialTime = "+this.soapSerialTime+";\n");
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"TestParser\" package=\"org.qualipso.advdoc.ws.client.storage.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<TestParser type=\"TestParser\" package=\"org.qualipso.advdoc.ws.client.storage.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    xml.append(_indentar(indents+1)+"<jsonDeserialTime type=\"int\">"+this.jsonDeserialTime+"</jsonDeserialTime>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<jsonSerialTime type=\"int\">"+this.jsonSerialTime+"</jsonSerialTime>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<numIterations type=\"int\">"+this.numIterations+"</numIterations>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<soapDeserialTime type=\"int\">"+this.soapDeserialTime+"</soapDeserialTime>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<soapSerialTime type=\"int\">"+this.soapSerialTime+"</soapSerialTime>");
    xml.append("\n");
    xml.append(super.toXML(null, indents+1, ponerIndicesDeArrays, escaparStrings));
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</TestParser>");
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
    __struct__.put("jsonDeserialTime", new Integer(jsonDeserialTime));
    __struct__.put("jsonSerialTime", new Integer(jsonSerialTime));
    __struct__.put("numIterations", new Integer(numIterations));
    __struct__.put("soapDeserialTime", new Integer(soapDeserialTime));
    __struct__.put("soapSerialTime", new Integer(soapSerialTime));
    super.toRPC(__struct__);
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_jsonDeserialTime = __params__.get("jsonDeserialTime");
    if (__object_jsonDeserialTime == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo jsonDeserialTime");
    }
    if (!(__object_jsonDeserialTime instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo jsonDeserialTime no es de tipo Integer");
    }
    Integer __int_jsonDeserialTime = (Integer)__object_jsonDeserialTime;
    setJsonDeserialTime(__int_jsonDeserialTime.intValue());
    Object __object_jsonSerialTime = __params__.get("jsonSerialTime");
    if (__object_jsonSerialTime == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo jsonSerialTime");
    }
    if (!(__object_jsonSerialTime instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo jsonSerialTime no es de tipo Integer");
    }
    Integer __int_jsonSerialTime = (Integer)__object_jsonSerialTime;
    setJsonSerialTime(__int_jsonSerialTime.intValue());
    Object __object_numIterations = __params__.get("numIterations");
    if (__object_numIterations == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo numIterations");
    }
    if (!(__object_numIterations instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo numIterations no es de tipo Integer");
    }
    Integer __int_numIterations = (Integer)__object_numIterations;
    setNumIterations(__int_numIterations.intValue());
    Object __object_soapDeserialTime = __params__.get("soapDeserialTime");
    if (__object_soapDeserialTime == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo soapDeserialTime");
    }
    if (!(__object_soapDeserialTime instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo soapDeserialTime no es de tipo Integer");
    }
    Integer __int_soapDeserialTime = (Integer)__object_soapDeserialTime;
    setSoapDeserialTime(__int_soapDeserialTime.intValue());
    Object __object_soapSerialTime = __params__.get("soapSerialTime");
    if (__object_soapSerialTime == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo soapSerialTime");
    }
    if (!(__object_soapSerialTime instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo soapSerialTime no es de tipo Integer");
    }
    Integer __int_soapSerialTime = (Integer)__object_soapSerialTime;
    setSoapSerialTime(__int_soapSerialTime.intValue());
    super.fromRPC(__params__);
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
      org.w3c.dom.Element __e = getNodeByName(__node,"jsonDeserialTime");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setJsonDeserialTime(Integer.parseInt(__v));
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"jsonSerialTime");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setJsonSerialTime(Integer.parseInt(__v));
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"numIterations");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setNumIterations(Integer.parseInt(__v));
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"soapDeserialTime");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setSoapDeserialTime(Integer.parseInt(__v));
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"soapSerialTime");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setSoapSerialTime(Integer.parseInt(__v));
    }
    super.fromXML(__node);

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
        writer.write("<jsonDeserialTime>");
        writer.write(Integer.toString(this.getJsonDeserialTime()));
        writer.write("</jsonDeserialTime>");
        writer.write("\n");
        writer.write("<jsonSerialTime>");
        writer.write(Integer.toString(this.getJsonSerialTime()));
        writer.write("</jsonSerialTime>");
        writer.write("\n");
        writer.write("<numIterations>");
        writer.write(Integer.toString(this.getNumIterations()));
        writer.write("</numIterations>");
        writer.write("\n");
        writer.write("<soapDeserialTime>");
        writer.write(Integer.toString(this.getSoapDeserialTime()));
        writer.write("</soapDeserialTime>");
        writer.write("\n");
        writer.write("<soapSerialTime>");
        writer.write(Integer.toString(this.getSoapSerialTime()));
        writer.write("</soapSerialTime>");
        writer.write("\n");
        super.toSOAP(writer);
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

        node = beanNode.getFirstChildByName("jsonDeserialTime");
        if (node != null && node.getContents() != null) {
            this.setJsonDeserialTime(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("jsonSerialTime");
        if (node != null && node.getContents() != null) {
            this.setJsonSerialTime(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("numIterations");
        if (node != null && node.getContents() != null) {
            this.setNumIterations(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("soapDeserialTime");
        if (node != null && node.getContents() != null) {
            this.setSoapDeserialTime(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("soapSerialTime");
        if (node != null && node.getContents() != null) {
            this.setSoapSerialTime(Integer.parseInt(node.getContents()));
        }

        super.fromSOAP(beanNode);
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
        super.toJSON(json);
        JSONObject jObject;
        json.put("jsonDeserialTime",this.getJsonDeserialTime());
        json.put("jsonSerialTime",this.getJsonSerialTime());
        json.put("numIterations",this.getNumIterations());
        json.put("soapDeserialTime",this.getSoapDeserialTime());
        json.put("soapSerialTime",this.getSoapSerialTime());
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
        super.fromJSON(json);
        this.setJsonDeserialTime(json.getInt("jsonDeserialTime"));
        this.setJsonSerialTime(json.getInt("jsonSerialTime"));
        this.setNumIterations(json.getInt("numIterations"));
        this.setSoapDeserialTime(json.getInt("soapDeserialTime"));
        this.setSoapSerialTime(json.getInt("soapSerialTime"));
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
        return new TestParser(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof TestParser)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        TestParser bean = (TestParser)source;
        this.set(bean);
    }

}
