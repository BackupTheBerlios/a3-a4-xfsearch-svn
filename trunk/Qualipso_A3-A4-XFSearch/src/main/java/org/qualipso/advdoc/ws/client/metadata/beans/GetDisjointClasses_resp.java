//ffb4bffa397d374317745db5705e28d

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : GetDisjointClasses_resp.java
// Proyecto : QualiPSoMetadataAPI
// Versi�n  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.metadata.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * 
 * @composed 1 - 0..* org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement
 * @author FRAWA
 * @version 1.0
 */
public class GetDisjointClasses_resp extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     *  ( org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement[] )
     * @composed org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement
     */
    protected ObjectVector disjointClasses = new ObjectVector(10);

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public GetDisjointClasses_resp() {
        // Registrarse como Observer de los atributos hijos
        this.disjointClasses.addObserver(this);
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public GetDisjointClasses_resp(GetDisjointClasses_resp object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(GetDisjointClasses_resp object) {
        this.disjointClasses.clear();
        for (int i = 0;i < object.disjointClasses.size();i++) {
            addDisjointClasses(new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement(object.getDisjointClasses(i)));
        }
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    disjointClasses    
     */
    public GetDisjointClasses_resp(org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement[] disjointClasses) {
        for (int __i = 0;__i < disjointClasses.length;__i++) {
            addDisjointClasses(disjointClasses[__i]);
        }
    }



    /**
     * Conversi�n a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("GetDisjointClasses_resp",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        for (int i = 0;i < this.disjointClasses_size();i++) {
            ok = ok && this.getDisjointClasses(i).valida(errores);
        }
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof GetDisjointClasses_resp)) {
            return false;
        }
        GetDisjointClasses_resp value = (GetDisjointClasses_resp)obj;
        if (value.disjointClasses.size() != this.disjointClasses.size()) {
            return false;
        }
        for (int i = 0;i < value.disjointClasses.size();i++) {
            if (!(value.getDisjointClasses(i).equals(this.getDisjointClasses(i)))) {
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
        // Concatenar con el hashcode del atributo disjointClasses
        for (int i = 0;i < disjointClasses.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getDisjointClasses(i));
        }
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(GetDisjointClasses_resp[] __array1,GetDisjointClasses_resp[] __array2) {
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
     * Vacia los elementos del atributo disjointClasses
     */
    public void clearDisjointClasses() { this.disjointClasses.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-�simo del atributo disjointClasses
     * @param    position    Posici�n del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeDisjointClasses(int position) {
        return this.disjointClasses.remove(position);
    }

    /**
     * N�mero de elementos en el atributo disjointClasses
     * @return   N�mero de elementos
     */
    public int disjointClasses_size() { return this.disjointClasses.size(); }

    /**
     * Elementos del atributo disjointClasses
     * @return   Array de elementos
     */
    public org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement[] getDisjointClasses() {
        return (org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement[])this.disjointClasses.toArray(new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement[this.disjointClasses.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo disjointClasses
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement getDisjointClasses(int position) {
        return (org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement)this.disjointClasses.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo disjointClasses
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setDisjointClasses(int position,org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement();
        }
        this.disjointClasses.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo disjointClasses
     * @param    valores    Los nuevos elementos
     */
    public void setDisjointClasses(org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement[] valores) {
        this.disjointClasses = new ObjectVector(valores);
        this.disjointClasses.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo disjointClasses
     * @param    valor    Nuevo elemento
     */
    public void addDisjointClasses(org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement();
        }
        this.disjointClasses.addElement(valor);
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
                "GetDisjointClasses_resp <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ResourceElement[] disjointClasses<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string comment<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string label<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string localName<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string namespace<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string URI<BR>",
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
        this.disjointClasses.clear();
        org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement v_0_1 = new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement();
        v_0_1.fillSampleData();
        this.addDisjointClasses(v_0_1);
        org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement v_0_2 = new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement();
        v_0_2.fillSampleData();
        this.addDisjointClasses(v_0_2);
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append((int)this.disjointClasses.size());
    for (int i=0; i<this.disjointClasses.size(); i++) {
      output.append((org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement)this.disjointClasses.elementAt(i));
    }
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    {
        int len = input.extract_int();
        this.disjointClasses = new ObjectVector(len);
        this.disjointClasses.addObserver(this);
        for (int i = 0; i < len; i++) {
          org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement aux = new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement();
          input.extract_object(aux);
          this.disjointClasses.addElement(aux);
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
        js.append(varName+".__constructor__ = 'GetDisjointClasses_resp';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.metadata.beans';\n");
    }
    js.append(varName+".disjointClasses = new Array("+this.disjointClasses.size()+");\n");
    for (int i = 0;i < this.disjointClasses.size();i++) {
        TdiJavascriptable object = (TdiJavascriptable)this.disjointClasses.elementAt(i);
        js.append(object.toJS(false,true,varName+".disjointClasses["+i+"]",0));
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"GetDisjointClasses_resp\" package=\"org.qualipso.advdoc.ws.client.metadata.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<GetDisjointClasses_resp type=\"GetDisjointClasses_resp\" package=\"org.qualipso.advdoc.ws.client.metadata.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    xml.append(_indentar(indents+1)+"<disjointClasses type=\"org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement[]\" size=\""+this.disjointClasses.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.disjointClasses.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(((org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement)disjointClasses.elementAt(i)).toXML("disjointClasses"+"_"+sufijo, indents+2,ponerIndicesDeArrays,escaparStrings));
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</disjointClasses>");
    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</GetDisjointClasses_resp>");
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
    java.util.Vector __vector_disjointClasses = new java.util.Vector();
    for (int __i__ = 0;__i__ < disjointClasses.size();__i__++) {
        org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement __object__ = (org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement)disjointClasses.elementAt(__i__);
        __vector_disjointClasses.addElement(__object__.toRPC());
    }
    __struct__.put("disjointClasses",__vector_disjointClasses);
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_disjointClasses = __params__.get("disjointClasses");
    if (__object_disjointClasses == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector disjointClasses");
    }
    if (!(__object_disjointClasses instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo disjointClasses no es de tipo Vector");
    }
    java.util.Vector __vector_disjointClasses = (java.util.Vector)__object_disjointClasses;
    for (int i = 0;i < __vector_disjointClasses.size();i++) {
        Object __element__ = __vector_disjointClasses.elementAt(i);
        if (!(__element__ instanceof java.util.Hashtable)) {
            throw new Exception(getClass().getName()+".fromRPC() El atributo disjointClasses no es de tipo Hashtable");
        }
        java.util.Hashtable __hashtable__ = (java.util.Hashtable)__element__;
        org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement __value__;
        String __constructor__ = (String)__hashtable__.get("__constructor__");
        // Si existe el atributo __constructor__ crear el objeto de la clase indicada
        if (__constructor__ == null || __constructor__.equals("")) {
            __value__ = new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement();
        } else {
            __value__ = (org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement)Class.forName(__constructor__).newInstance();
        }
        __value__.fromRPC(__hashtable__);
        addDisjointClasses(__value__);
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
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"disjointClasses");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        org.w3c.dom.Element __element2 = getNodeByName(__element,"disjointClasses_"+i);
        org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement __entry;
        if (__element2.getAttribute("package") != null && __element2.getAttribute("package").length() != 0) {
          __entry = (org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement) Class.forName(__element2.getAttribute("package")+"."+__element2.getAttribute("type")).newInstance();
        } else {
          __entry = new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement();
        }
        __entry.fromXML(__element2);
        addDisjointClasses(__entry);
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
        writer.write("<disjointClasses>");
        writer.write("\n");
        for (int i = 0; i < disjointClasses_size(); i++) {
            writer.write("<ResourceElement>");
            writer.write("\n");
            this.getDisjointClasses(i).toSOAP(writer);
            writer.write("</ResourceElement>");
            writer.write("\n");
        }
        writer.write("</disjointClasses>");
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

        tdi.xml.parser.TdiXmlNode[] arrayNodes;
        node = beanNode.getFirstChildByName("disjointClasses");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("ResourceElement");
            if (arrayNodes != null) {
                this.clearDisjointClasses();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement tmp = new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement();
                        tmp.fromSOAP(arrayNodes[i]);
                        this.addDisjointClasses(tmp);
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
        JSONArray jArray;
        JSONArray jObjectArray;
        jObjectArray = new JSONArray();
        for (int i = 0;i < disjointClasses_size();i++) {
            JSONObject jObj_i = new JSONObject();
            this.getDisjointClasses(i).toJSON(jObj_i);
            jObjectArray.put(jObj_i);
        }
        json.put("disjointClasses",jObjectArray);
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
        JSONArray jArray;
        JSONArray jObjectArray;
        jObjectArray = json.getJSONArray("disjointClasses");
        this.clearDisjointClasses();
        for (int i = 0;i < jObjectArray.length();i++) {
            JSONObject jObj_i = jObjectArray.getJSONObject(i);
            org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement tmp = new org.qualipso.advdoc.ws.client.metadata.beans.ResourceElement();
            tmp.fromJSON(jObj_i);
            this.addDisjointClasses(tmp);
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
        return new GetDisjointClasses_resp(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof GetDisjointClasses_resp)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        GetDisjointClasses_resp bean = (GetDisjointClasses_resp)source;
        this.set(bean);
    }

}
