//2d6e8f3ff95b3edaabdcdb4e754d0c4

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : SPARQLResult.java
// Proyecto : QualiPSoSearchAPI
// Versi�n  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.search.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * 
 * @composed 1 - 0..* org.qualipso.advdoc.ws.client.search.beans.Row
 * @author FRAWA
 * @version 1.0
 */
public class SPARQLResult extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     *  ( String[] )
     * @composed string
     */
    protected ObjectVector columns = new ObjectVector(10);
    /**
     *  ( org.qualipso.advdoc.ws.client.search.beans.Row[] )
     * @composed org.qualipso.advdoc.ws.client.search.beans.Row
     */
    protected ObjectVector rows = new ObjectVector(10);

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public SPARQLResult() {
        // Registrarse como Observer de los atributos hijos
        this.columns.addObserver(this);
        this.rows.addObserver(this);
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public SPARQLResult(SPARQLResult object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(SPARQLResult object) {
        setColumns(object.getColumns());
        this.rows.clear();
        for (int i = 0;i < object.rows.size();i++) {
            addRows(new org.qualipso.advdoc.ws.client.search.beans.Row(object.getRows(i)));
        }
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    columns    
     * @param    rows    
     */
    public SPARQLResult(String[] columns,org.qualipso.advdoc.ws.client.search.beans.Row[] rows) {
        for (int __i = 0;__i < columns.length;__i++) {
            addColumns(columns[__i]);
        }
        for (int __i = 0;__i < rows.length;__i++) {
            addRows(rows[__i]);
        }
    }



    /**
     * Conversi�n a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("SPARQLResult",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        for (int i = 0;i < this.rows_size();i++) {
            ok = ok && this.getRows(i).valida(errores);
        }
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof SPARQLResult)) {
            return false;
        }
        SPARQLResult value = (SPARQLResult)obj;
        if (value.columns.size() != this.columns.size()) {
            return false;
        }
        for (int i = 0;i < value.columns.size();i++) {
            if (!(value.getColumns(i).equals(this.getColumns(i)))) {
                return false;
            }
        }
        if (value.rows.size() != this.rows.size()) {
            return false;
        }
        for (int i = 0;i < value.rows.size();i++) {
            if (!(value.getRows(i).equals(this.getRows(i)))) {
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
        // Concatenar con el hashcode del atributo columns
        for (int i = 0;i < columns.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getColumns(i));
        }
        // Concatenar con el hashcode del atributo rows
        for (int i = 0;i < rows.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getRows(i));
        }
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(SPARQLResult[] __array1,SPARQLResult[] __array2) {
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
     * Vacia los elementos del atributo columns
     */
    public void clearColumns() { this.columns.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-�simo del atributo columns
     * @param    position    Posici�n del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeColumns(int position) {
        return this.columns.remove(position);
    }

    /**
     * N�mero de elementos en el atributo columns
     * @return   N�mero de elementos
     */
    public int columns_size() { return this.columns.size(); }

    /**
     * Elementos del atributo columns
     * @return   Array de elementos
     */
    public String[] getColumns() {
        return (String[])this.columns.toArray(new String[this.columns.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo columns
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public String getColumns(int position) {
        return (String)this.columns.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo columns
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setColumns(int position,String valor) {
        if (valor == null) {
            valor = new String();
        }
        this.columns.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo columns
     * @param    valores    Los nuevos elementos
     */
    public void setColumns(String[] valores) {
        this.columns = new ObjectVector(valores);
        this.columns.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo columns
     * @param    valor    Nuevo elemento
     */
    public void addColumns(String valor) {
        if (valor == null) {
            valor = new String();
        }
        this.columns.addElement(valor);
        setChanged();
    }

    /**
     * Vacia los elementos del atributo rows
     */
    public void clearRows() { this.rows.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-�simo del atributo rows
     * @param    position    Posici�n del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeRows(int position) {
        return this.rows.remove(position);
    }

    /**
     * N�mero de elementos en el atributo rows
     * @return   N�mero de elementos
     */
    public int rows_size() { return this.rows.size(); }

    /**
     * Elementos del atributo rows
     * @return   Array de elementos
     */
    public org.qualipso.advdoc.ws.client.search.beans.Row[] getRows() {
        return (org.qualipso.advdoc.ws.client.search.beans.Row[])this.rows.toArray(new org.qualipso.advdoc.ws.client.search.beans.Row[this.rows.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo rows
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public org.qualipso.advdoc.ws.client.search.beans.Row getRows(int position) {
        return (org.qualipso.advdoc.ws.client.search.beans.Row)this.rows.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo rows
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setRows(int position,org.qualipso.advdoc.ws.client.search.beans.Row valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.search.beans.Row();
        }
        this.rows.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo rows
     * @param    valores    Los nuevos elementos
     */
    public void setRows(org.qualipso.advdoc.ws.client.search.beans.Row[] valores) {
        this.rows = new ObjectVector(valores);
        this.rows.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo rows
     * @param    valor    Nuevo elemento
     */
    public void addRows(org.qualipso.advdoc.ws.client.search.beans.Row valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.search.beans.Row();
        }
        this.rows.addElement(valor);
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
                "SPARQLResult <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string[] columns<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Row[] rows<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Node[] nodes<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int isLiteral<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string value<BR>",
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
        this.columns.clear();
        this.addColumns("string_0");
        this.addColumns("string_1");
        this.rows.clear();
        org.qualipso.advdoc.ws.client.search.beans.Row v_1_1 = new org.qualipso.advdoc.ws.client.search.beans.Row();
        v_1_1.fillSampleData();
        this.addRows(v_1_1);
        org.qualipso.advdoc.ws.client.search.beans.Row v_1_2 = new org.qualipso.advdoc.ws.client.search.beans.Row();
        v_1_2.fillSampleData();
        this.addRows(v_1_2);
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append((int)this.columns.size());
    for (int i=0; i<this.columns.size(); i++) {
      output.append((String)this.columns.elementAt(i));
    }
    output.append((int)this.rows.size());
    for (int i=0; i<this.rows.size(); i++) {
      output.append((org.qualipso.advdoc.ws.client.search.beans.Row)this.rows.elementAt(i));
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
        this.columns = new ObjectVector(len);
        this.columns.addObserver(this);
        for (int i = 0; i < len; i++) {
          String aux = input.extract_String();
          this.columns.addElement(aux);
        }
    }
    {
        int len = input.extract_int();
        this.rows = new ObjectVector(len);
        this.rows.addObserver(this);
        for (int i = 0; i < len; i++) {
          org.qualipso.advdoc.ws.client.search.beans.Row aux = new org.qualipso.advdoc.ws.client.search.beans.Row();
          input.extract_object(aux);
          this.rows.addElement(aux);
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
        js.append(varName+".__constructor__ = 'SPARQLResult';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.search.beans';\n");
    }
    js.append(varName+".columns = new Array("+this.columns.size()+");\n");
    for (int i = 0;i < this.columns.size();i++) {
        js.append(varName+".columns["+i+"] = '"+es.tid.serial.TdiSerialUtil.escapaJavascript((String)this.columns.elementAt(i))+"';\n");
    }
    js.append(varName+".rows = new Array("+this.rows.size()+");\n");
    for (int i = 0;i < this.rows.size();i++) {
        TdiJavascriptable object = (TdiJavascriptable)this.rows.elementAt(i);
        js.append(object.toJS(false,true,varName+".rows["+i+"]",0));
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"SPARQLResult\" package=\"org.qualipso.advdoc.ws.client.search.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<SPARQLResult type=\"SPARQLResult\" package=\"org.qualipso.advdoc.ws.client.search.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    xml.append(_indentar(indents+1)+"<columns type=\"string[]\" size=\""+this.columns.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.columns.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(_indentar(indents+2)+"<columns"+"_"+sufijo+" type=\"string\">"+columns.elementAt(i)+"</columns"+"_"+sufijo+">");
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</columns>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<rows type=\"org.qualipso.advdoc.ws.client.search.beans.Row[]\" size=\""+this.rows.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.rows.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(((org.qualipso.advdoc.ws.client.search.beans.Row)rows.elementAt(i)).toXML("rows"+"_"+sufijo, indents+2,ponerIndicesDeArrays,escaparStrings));
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</rows>");
    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</SPARQLResult>");
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
    java.util.Vector __vector_columns = new java.util.Vector();
    for (int __i__ = 0;__i__ < columns.size();__i__++) {
        __vector_columns.addElement(tdi.text.StringUtil.sustituyeUnicode((String)this.columns.elementAt(__i__)));
    }
    __struct__.put("columns",__vector_columns);
    java.util.Vector __vector_rows = new java.util.Vector();
    for (int __i__ = 0;__i__ < rows.size();__i__++) {
        org.qualipso.advdoc.ws.client.search.beans.Row __object__ = (org.qualipso.advdoc.ws.client.search.beans.Row)rows.elementAt(__i__);
        __vector_rows.addElement(__object__.toRPC());
    }
    __struct__.put("rows",__vector_rows);
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_columns = __params__.get("columns");
    if (__object_columns == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector columns");
    }
    if (!(__object_columns instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo columns no es de tipo Vector");
    }
    java.util.Vector __vector_columns = (java.util.Vector)__object_columns;
    for (int i = 0;i < __vector_columns.size();i++) {
        Object __element__ = __vector_columns.elementAt(i);
        if (!(__element__ instanceof String)) {
            throw new Exception(getClass().getName()+".fromRPC() El elemento "+i+" del array columns no es de tipo String");
        }
        addColumns((String)__element__);
    }
    Object __object_rows = __params__.get("rows");
    if (__object_rows == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector rows");
    }
    if (!(__object_rows instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo rows no es de tipo Vector");
    }
    java.util.Vector __vector_rows = (java.util.Vector)__object_rows;
    for (int i = 0;i < __vector_rows.size();i++) {
        Object __element__ = __vector_rows.elementAt(i);
        if (!(__element__ instanceof java.util.Hashtable)) {
            throw new Exception(getClass().getName()+".fromRPC() El atributo rows no es de tipo Hashtable");
        }
        java.util.Hashtable __hashtable__ = (java.util.Hashtable)__element__;
        org.qualipso.advdoc.ws.client.search.beans.Row __value__;
        String __constructor__ = (String)__hashtable__.get("__constructor__");
        // Si existe el atributo __constructor__ crear el objeto de la clase indicada
        if (__constructor__ == null || __constructor__.equals("")) {
            __value__ = new org.qualipso.advdoc.ws.client.search.beans.Row();
        } else {
            __value__ = (org.qualipso.advdoc.ws.client.search.beans.Row)Class.forName(__constructor__).newInstance();
        }
        __value__.fromRPC(__hashtable__);
        addRows(__value__);
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
      org.w3c.dom.Element __element = getNodeByName(__node,"columns");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        String __v = getNodeByName(__element,"columns_"+i).getChildNodes().item(0).getNodeValue();
        addColumns(__v);
      }
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"rows");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        org.w3c.dom.Element __element2 = getNodeByName(__element,"rows_"+i);
        org.qualipso.advdoc.ws.client.search.beans.Row __entry;
        if (__element2.getAttribute("package") != null && __element2.getAttribute("package").length() != 0) {
          __entry = (org.qualipso.advdoc.ws.client.search.beans.Row) Class.forName(__element2.getAttribute("package")+"."+__element2.getAttribute("type")).newInstance();
        } else {
          __entry = new org.qualipso.advdoc.ws.client.search.beans.Row();
        }
        __entry.fromXML(__element2);
        addRows(__entry);
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
        writer.write("<columns>");
        writer.write("\n");
        for (int i = 0; i < columns_size(); i++) {
            writer.write("<string>");
        writer.write(this.getColumns(i));
            writer.write("</string>");
            writer.write("\n");
        }
        writer.write("</columns>");
        writer.write("\n");
        writer.write("<rows>");
        writer.write("\n");
        for (int i = 0; i < rows_size(); i++) {
            writer.write("<Row>");
            writer.write("\n");
            this.getRows(i).toSOAP(writer);
            writer.write("</Row>");
            writer.write("\n");
        }
        writer.write("</rows>");
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
        node = beanNode.getFirstChildByName("columns");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("string");
            if (arrayNodes != null) {
                this.clearColumns();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        this.addColumns(arrayNodes[i].getContents());
                    }  // arrayNodes[i] != null
                }  // for
            }  // arrayNodes != null
        }  // node != null
        node = beanNode.getFirstChildByName("rows");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("Row");
            if (arrayNodes != null) {
                this.clearRows();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        org.qualipso.advdoc.ws.client.search.beans.Row tmp = new org.qualipso.advdoc.ws.client.search.beans.Row();
                        tmp.fromSOAP(arrayNodes[i]);
                        this.addRows(tmp);
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
        jArray = new JSONArray();
        for (int i = 0;i < columns_size();i++) {
            jArray.put(getColumns(i));
        }
        json.put("columns",jArray);
        jObjectArray = new JSONArray();
        for (int i = 0;i < rows_size();i++) {
            JSONObject jObj_i = new JSONObject();
            this.getRows(i).toJSON(jObj_i);
            jObjectArray.put(jObj_i);
        }
        json.put("rows",jObjectArray);
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
        jArray = json.getJSONArray("columns");
        this.clearColumns();
        for (int i = 0;i < jArray.length();i++) {
            this.addColumns(jArray.getString(i));
        }
        jObjectArray = json.getJSONArray("rows");
        this.clearRows();
        for (int i = 0;i < jObjectArray.length();i++) {
            JSONObject jObj_i = jObjectArray.getJSONObject(i);
            org.qualipso.advdoc.ws.client.search.beans.Row tmp = new org.qualipso.advdoc.ws.client.search.beans.Row();
            tmp.fromJSON(jObj_i);
            this.addRows(tmp);
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
        return new SPARQLResult(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof SPARQLResult)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        SPARQLResult bean = (SPARQLResult)source;
        this.set(bean);
    }

}
