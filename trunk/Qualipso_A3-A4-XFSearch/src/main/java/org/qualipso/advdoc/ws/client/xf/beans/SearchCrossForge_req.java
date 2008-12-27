//88809fb5a54fd11ec87599ac4ff213

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : SearchCrossForge_req.java
// Proyecto : QualiPSoXFAPI
// Versi�n  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.xf.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * 
 * @composed 1 - 0..* org.qualipso.advdoc.ws.client.xf.beans.Forge
 * @author FRAWA
 * @version 1.0
 */
public class SearchCrossForge_req extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     * 
     */
    protected String sparql = "";
    /**
     *  ( org.qualipso.advdoc.ws.client.xf.beans.Forge[] )
     * @composed org.qualipso.advdoc.ws.client.xf.beans.Forge
     */
    protected ObjectVector forges = new ObjectVector(10);

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public SearchCrossForge_req() {
        // Registrarse como Observer de los atributos hijos
        this.forges.addObserver(this);
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public SearchCrossForge_req(SearchCrossForge_req object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(SearchCrossForge_req object) {
        setSparql(object.getSparql());
        this.forges.clear();
        for (int i = 0;i < object.forges.size();i++) {
            addForges(new org.qualipso.advdoc.ws.client.xf.beans.Forge(object.getForges(i)));
        }
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    sparql    
     * @param    forges    
     */
    public SearchCrossForge_req(String sparql,org.qualipso.advdoc.ws.client.xf.beans.Forge[] forges) {
        setSparql(sparql);
        for (int __i = 0;__i < forges.length;__i++) {
            addForges(forges[__i]);
        }
    }



    /**
     * Conversi�n a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("SearchCrossForge_req",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        for (int i = 0;i < this.forges_size();i++) {
            ok = ok && this.getForges(i).valida(errores);
        }
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof SearchCrossForge_req)) {
            return false;
        }
        SearchCrossForge_req value = (SearchCrossForge_req)obj;
        if (!(value.sparql.equals(this.sparql))) {
            return false;
        }
        if (value.forges.size() != this.forges.size()) {
            return false;
        }
        for (int i = 0;i < value.forges.size();i++) {
            if (!(value.getForges(i).equals(this.getForges(i)))) {
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
        // Concatenar con el hashcode del atributo sparql
        code = tdi.gen.TdiHashcode.concat(code,this.sparql);
        // Concatenar con el hashcode del atributo forges
        for (int i = 0;i < forges.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getForges(i));
        }
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(SearchCrossForge_req[] __array1,SearchCrossForge_req[] __array2) {
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
     * Vacia los elementos del atributo forges
     */
    public void clearForges() { this.forges.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-�simo del atributo forges
     * @param    position    Posici�n del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeForges(int position) {
        return this.forges.remove(position);
    }

    /**
     * N�mero de elementos en el atributo forges
     * @return   N�mero de elementos
     */
    public int forges_size() { return this.forges.size(); }

    /**
     * Elementos del atributo forges
     * @return   Array de elementos
     */
    public org.qualipso.advdoc.ws.client.xf.beans.Forge[] getForges() {
        return (org.qualipso.advdoc.ws.client.xf.beans.Forge[])this.forges.toArray(new org.qualipso.advdoc.ws.client.xf.beans.Forge[this.forges.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo forges
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public org.qualipso.advdoc.ws.client.xf.beans.Forge getForges(int position) {
        return (org.qualipso.advdoc.ws.client.xf.beans.Forge)this.forges.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo forges
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setForges(int position,org.qualipso.advdoc.ws.client.xf.beans.Forge valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.xf.beans.Forge();
        }
        this.forges.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo forges
     * @param    valores    Los nuevos elementos
     */
    public void setForges(org.qualipso.advdoc.ws.client.xf.beans.Forge[] valores) {
        this.forges = new ObjectVector(valores);
        this.forges.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo forges
     * @param    valor    Nuevo elemento
     */
    public void addForges(org.qualipso.advdoc.ws.client.xf.beans.Forge valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.xf.beans.Forge();
        }
        this.forges.addElement(valor);
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
                "SearchCrossForge_req <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string sparql<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Forge[] forges<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string forgeName<BR>",
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
        this.setSparql("string");
        this.forges.clear();
        org.qualipso.advdoc.ws.client.xf.beans.Forge v_0_1 = new org.qualipso.advdoc.ws.client.xf.beans.Forge();
        v_0_1.fillSampleData();
        this.addForges(v_0_1);
        org.qualipso.advdoc.ws.client.xf.beans.Forge v_0_2 = new org.qualipso.advdoc.ws.client.xf.beans.Forge();
        v_0_2.fillSampleData();
        this.addForges(v_0_2);
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append(this.sparql);
    output.append((int)this.forges.size());
    for (int i=0; i<this.forges.size(); i++) {
      output.append((org.qualipso.advdoc.ws.client.xf.beans.Forge)this.forges.elementAt(i));
    }
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    this.sparql = input.extract_String();
    {
        int len = input.extract_int();
        this.forges = new ObjectVector(len);
        this.forges.addObserver(this);
        for (int i = 0; i < len; i++) {
          org.qualipso.advdoc.ws.client.xf.beans.Forge aux = new org.qualipso.advdoc.ws.client.xf.beans.Forge();
          input.extract_object(aux);
          this.forges.addElement(aux);
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
        js.append(varName+".__constructor__ = 'SearchCrossForge_req';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.xf.beans';\n");
    }
    js.append(varName+".sparql = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.sparql)+"';\n");
    js.append(varName+".forges = new Array("+this.forges.size()+");\n");
    for (int i = 0;i < this.forges.size();i++) {
        TdiJavascriptable object = (TdiJavascriptable)this.forges.elementAt(i);
        js.append(object.toJS(false,true,varName+".forges["+i+"]",0));
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"SearchCrossForge_req\" package=\"org.qualipso.advdoc.ws.client.xf.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<SearchCrossForge_req type=\"SearchCrossForge_req\" package=\"org.qualipso.advdoc.ws.client.xf.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<sparql type=\"string\">"+tdi.text.StringUtil.escapeXML(this.sparql,false)+"</sparql>");
    } else {
        xml.append(_indentar(indents+1)+"<sparql type=\"string\">"+this.sparql+"</sparql>");
    }

    xml.append("\n");
    xml.append(_indentar(indents+1)+"<forges type=\"org.qualipso.advdoc.ws.client.xf.beans.Forge[]\" size=\""+this.forges.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.forges.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(((org.qualipso.advdoc.ws.client.xf.beans.Forge)forges.elementAt(i)).toXML("forges"+"_"+sufijo, indents+2,ponerIndicesDeArrays,escaparStrings));
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</forges>");
    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</SearchCrossForge_req>");
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
    __struct__.put("sparql", tdi.text.StringUtil.sustituyeUnicode(this.sparql));
    java.util.Vector __vector_forges = new java.util.Vector();
    for (int __i__ = 0;__i__ < forges.size();__i__++) {
        org.qualipso.advdoc.ws.client.xf.beans.Forge __object__ = (org.qualipso.advdoc.ws.client.xf.beans.Forge)forges.elementAt(__i__);
        __vector_forges.addElement(__object__.toRPC());
    }
    __struct__.put("forges",__vector_forges);
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_sparql = __params__.get("sparql");
    if (__object_sparql == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo sparql");
    }
    if (!(__object_sparql instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo sparql no es de tipo String");
    }
    setSparql((String)__object_sparql);
    Object __object_forges = __params__.get("forges");
    if (__object_forges == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector forges");
    }
    if (!(__object_forges instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo forges no es de tipo Vector");
    }
    java.util.Vector __vector_forges = (java.util.Vector)__object_forges;
    for (int i = 0;i < __vector_forges.size();i++) {
        Object __element__ = __vector_forges.elementAt(i);
        if (!(__element__ instanceof java.util.Hashtable)) {
            throw new Exception(getClass().getName()+".fromRPC() El atributo forges no es de tipo Hashtable");
        }
        java.util.Hashtable __hashtable__ = (java.util.Hashtable)__element__;
        org.qualipso.advdoc.ws.client.xf.beans.Forge __value__;
        String __constructor__ = (String)__hashtable__.get("__constructor__");
        // Si existe el atributo __constructor__ crear el objeto de la clase indicada
        if (__constructor__ == null || __constructor__.equals("")) {
            __value__ = new org.qualipso.advdoc.ws.client.xf.beans.Forge();
        } else {
            __value__ = (org.qualipso.advdoc.ws.client.xf.beans.Forge)Class.forName(__constructor__).newInstance();
        }
        __value__.fromRPC(__hashtable__);
        addForges(__value__);
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
      org.w3c.dom.Element __e = getNodeByName(__node,"sparql");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setSparql(__v);
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"forges");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        org.w3c.dom.Element __element2 = getNodeByName(__element,"forges_"+i);
        org.qualipso.advdoc.ws.client.xf.beans.Forge __entry;
        if (__element2.getAttribute("package") != null && __element2.getAttribute("package").length() != 0) {
          __entry = (org.qualipso.advdoc.ws.client.xf.beans.Forge) Class.forName(__element2.getAttribute("package")+"."+__element2.getAttribute("type")).newInstance();
        } else {
          __entry = new org.qualipso.advdoc.ws.client.xf.beans.Forge();
        }
        __entry.fromXML(__element2);
        addForges(__entry);
      }
    }

    setChanged();
  }

    /**
     * Serializa el bean en formato SOAP document
     * @throws   java.io.Exception    Cuando se produce una excepci�n al serializar el bean
     * @return   Cadena de texto en formato SOAP document
     */
    public String toSOAP() throws java.io.IOException {
        java.io.StringWriter writer = new java.io.StringWriter();
        this.toSOAP(writer);
        return writer.toString();
    }



    /**
     * Serializa el bean en formato SOAP document
     * @param    writer    Writer donde se escribir� el bean en formato SOAP document
     * @throws   Exception    Cuando se produce un error en la serializaci�n del bean
     */
    public void toSOAP(java.io.Writer writer) throws java.io.IOException {
        writer.write("<sparql>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getSparql(), false));
        writer.write("</sparql>");
        writer.write("\n");
        writer.write("<forges>");
        writer.write("\n");
        for (int i = 0; i < forges_size(); i++) {
            writer.write("<Forge>");
            writer.write("\n");
            this.getForges(i).toSOAP(writer);
            writer.write("</Forge>");
            writer.write("\n");
        }
        writer.write("</forges>");
        writer.write("\n");
    }




    /**
     * Rellena los campos del bean decodificando un documento SOAP document
     * @param    reader    Reader donde se leer� el bean en formato SOAP document
     * @throws   Exception    Cuando se produce un error en la deserializaci�n del bean
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
     * @throws   Exception    Cuando se produce un error en la deserializaci�n del bean
     */
    public void fromSOAP(tdi.xml.parser.TdiXmlNode beanNode) {
        tdi.xml.parser.TdiXmlNode node;

        node = beanNode.getFirstChildByName("sparql");
        if (node != null && node.getContents() != null) {
            this.setSparql(node.getContents());
        }

        tdi.xml.parser.TdiXmlNode[] arrayNodes;
        node = beanNode.getFirstChildByName("forges");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("Forge");
            if (arrayNodes != null) {
                this.clearForges();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        org.qualipso.advdoc.ws.client.xf.beans.Forge tmp = new org.qualipso.advdoc.ws.client.xf.beans.Forge();
                        tmp.fromSOAP(arrayNodes[i]);
                        this.addForges(tmp);
                    }  // arrayNodes[i] != null
                }  // for
            }  // arrayNodes != null
        }  // node != null
    }



    /**
     * Serializa el bean en formato JSON
     * @throws   es.tid.serial.json.JSONException    Cuando se produce una excepci�n al serializar el bean
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
     * @param    json    objeto donde se escribir� el bean en formato JSON
     * @throws   es.tid.serial.json.JSONException    Cuando se produce un error en la serializaci�n del bean
     */
    public void toJSON(JSONObject json) throws JSONException {
        JSONObject jObject;
        json.put("sparql",this.getSparql());
        JSONArray jArray;
        JSONArray jObjectArray;
        jObjectArray = new JSONArray();
        for (int i = 0;i < forges_size();i++) {
            JSONObject jObj_i = new JSONObject();
            this.getForges(i).toJSON(jObj_i);
            jObjectArray.put(jObj_i);
        }
        json.put("forges",jObjectArray);
    }




    /**
     * Deserializa el bean en formato JSON
     * @throws   es.tid.serial.json.JSONException    Cuando se produce una excepci�n al deserializar el bean
     */
    public void fromJSON(String str) throws JSONException {
        JSONObject json = new JSONObject(str);
        this.fromJSON(json);
    }



    /**
     * Deserializa el bean en formato JSON
     * @param    json    objeto que contiene los datos del bean en formato JSON
     * @throws   es.tid.serial.json.JSONException    Cuando se produce un error en la deserializaci�n del objeto JSON
     */
    public void fromJSON(JSONObject json) throws JSONException {
        this.setSparql(json.getString("sparql"));
        JSONArray jArray;
        JSONArray jObjectArray;
        jObjectArray = json.getJSONArray("forges");
        this.clearForges();
        for (int i = 0;i < jObjectArray.length();i++) {
            JSONObject jObj_i = jObjectArray.getJSONObject(i);
            org.qualipso.advdoc.ws.client.xf.beans.Forge tmp = new org.qualipso.advdoc.ws.client.xf.beans.Forge();
            tmp.fromJSON(jObj_i);
            this.addForges(tmp);
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
        return new SearchCrossForge_req(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof SearchCrossForge_req)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        SearchCrossForge_req bean = (SearchCrossForge_req)source;
        this.set(bean);
    }

}
