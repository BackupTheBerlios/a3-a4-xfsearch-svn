//2a120ebfbe6eda0d03ba9f02dd951ae

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : Composite.java
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
public class Composite extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     * 
     */
    protected int id = 0;
    /**
     * 
     */
    protected String name = "";
    /**
     * 
     */
    protected double value = 0.0;
    /**
     *  ( String[] )
     * @composed string
     */
    protected ObjectVector comments = new ObjectVector(10);
    /**
     *  ( int[] )
     * @composed int
     */
    protected IntVector years = new IntVector(10);

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public Composite() {
        // Registrarse como Observer de los atributos hijos
        this.comments.addObserver(this);
        this.years.addObserver(this);
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public Composite(Composite object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(Composite object) {
        setId(object.getId());
        setName(object.getName());
        setValue(object.getValue());
        setComments(object.getComments());
        setYears(object.getYears());
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    id    
     * @param    name    
     * @param    value    
     * @param    comments    
     * @param    years    
     */
    public Composite(int id,String name,double value,int[] years,String[] comments) {
        setId(id);
        setName(name);
        setValue(value);
        for (int __i = 0;__i < comments.length;__i++) {
            addComments(comments[__i]);
        }
        for (int __i = 0;__i < years.length;__i++) {
            addYears(years[__i]);
        }
    }



    /**
     * Conversión a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("Composite",0);
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
        if (!(obj instanceof Composite)) {
            return false;
        }
        Composite value = (Composite)obj;
        if (value.id != this.id) {
            return false;
        }
        if (!(value.name.equals(this.name))) {
            return false;
        }
        if (value.value != this.value) {
            return false;
        }
        if (value.comments.size() != this.comments.size()) {
            return false;
        }
        for (int i = 0;i < value.comments.size();i++) {
            if (!(value.getComments(i).equals(this.getComments(i)))) {
                return false;
            }
        }
        if (value.years.size() != this.years.size()) {
            return false;
        }
        for (int i = 0;i < value.years.size();i++) {
            if (value.getYears(i) != this.getYears(i)) {
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
        // Concatenar con el hashcode del atributo id
        code = tdi.gen.TdiHashcode.concat(code,this.id);
        // Concatenar con el hashcode del atributo name
        code = tdi.gen.TdiHashcode.concat(code,this.name);
        // Concatenar con el hashcode del atributo value
        code = tdi.gen.TdiHashcode.concat(code,this.value);
        // Concatenar con el hashcode del atributo comments
        for (int i = 0;i < comments.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getComments(i));
        }
        // Concatenar con el hashcode del atributo years
        for (int i = 0;i < years.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getYears(i));
        }
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(Composite[] __array1,Composite[] __array2) {
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
     * Lectura del atributo id
     * @return   Valor del atributo id
     */
    public int getId() { return this.id; }

    /**
     * Escritura del atributo id
     * @param    valor    Nuevo valor del atributo id
     */
    public void setId(int valor) { 
        this.id = valor;
        setChanged();
    }

    /**
     * Lectura del atributo name
     * @return   Valor del atributo name
     */
    public String getName() { return this.name; }

    /**
     * Escritura del atributo name
     * @param    valor    Nuevo valor del atributo name
     */
    public void setName(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.name = valor;
        setChanged();
    }

    /**
     * Lectura del atributo value
     * @return   Valor del atributo value
     */
    public double getValue() { return this.value; }

    /**
     * Escritura del atributo value
     * @param    valor    Nuevo valor del atributo value
     */
    public void setValue(double valor) { 
        this.value = valor;
        setChanged();
    }

    /**
     * Vacia los elementos del atributo comments
     */
    public void clearComments() { this.comments.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo comments
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeComments(int position) {
        return this.comments.remove(position);
    }

    /**
     * Número de elementos en el atributo comments
     * @return   Número de elementos
     */
    public int comments_size() { return this.comments.size(); }

    /**
     * Elementos del atributo comments
     * @return   Array de elementos
     */
    public String[] getComments() {
        return (String[])this.comments.toArray(new String[this.comments.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo comments
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public String getComments(int position) {
        return (String)this.comments.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo comments
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setComments(int position,String valor) {
        if (valor == null) {
            valor = new String();
        }
        this.comments.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo comments
     * @param    valores    Los nuevos elementos
     */
    public void setComments(String[] valores) {
        this.comments = new ObjectVector(valores);
        this.comments.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo comments
     * @param    valor    Nuevo elemento
     */
    public void addComments(String valor) {
        if (valor == null) {
            valor = new String();
        }
        this.comments.addElement(valor);
        setChanged();
    }

    /**
     * Vacia los elementos del atributo years
     */
    public void clearYears() { this.years.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo years
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeYears(int position) {
        return this.years.remove(position);
    }

    /**
     * Número de elementos en el atributo years
     * @return   Número de elementos
     */
    public int years_size() { return this.years.size(); }

    /**
     * Elementos del atributo years
     * @return   Array de elementos
     */
    public int[] getYears() {
        return this.years.toArray();
    }

    /**
     * Obtener el elemento i-isimo del atributo years
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public int getYears(int position) {
        return (int)this.years.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo years
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setYears(int position,int valor) {
        this.years.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo years
     * @param    valores    Los nuevos elementos
     */
    public void setYears(int[] valores) {
        this.years = new IntVector(valores);
        this.years.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo years
     * @param    valor    Nuevo elemento
     */
    public void addYears(int valor) {
        this.years.addElement(valor);
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
                "Composite <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int id<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string name<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double value<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string[] comments<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int[] years<BR>",
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
        this.setId(0);
        this.setName("string");
        this.setValue(0.0);
        this.comments.clear();
        this.addComments("string_0");
        this.addComments("string_1");
        this.years.clear();
        this.addYears(0);
        this.addYears(1);
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append(this.id);
    output.append(this.name);
    output.append(this.value);
    output.append((int)this.comments.size());
    for (int i=0; i<this.comments.size(); i++) {
      output.append((String)this.comments.elementAt(i));
    }
    output.append((int)this.years.size());
    for (int i=0; i<this.years.size(); i++) {
      output.append((int)this.years.elementAt(i));
    }
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    this.id = input.extract_int();
    this.name = input.extract_String();
    this.value = input.extract_double();
    {
        int len = input.extract_int();
        this.comments = new ObjectVector(len);
        this.comments.addObserver(this);
        for (int i = 0; i < len; i++) {
          String aux = input.extract_String();
          this.comments.addElement(aux);
        }
    }
    {
        int len = input.extract_int();
        this.years = new IntVector(len);
        this.years.addObserver(this);
        for (int i = 0; i < len; i++) {
          int aux = input.extract_int();
          this.years.addElement(aux);
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
        js.append(varName+".__constructor__ = 'Composite';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.storage.beans';\n");
    }
    js.append(varName+".id = "+this.id+";\n");
    js.append(varName+".name = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.name)+"';\n");
    js.append(varName+".value = "+this.value+";\n");
    js.append(varName+".comments = new Array("+this.comments.size()+");\n");
    for (int i = 0;i < this.comments.size();i++) {
        js.append(varName+".comments["+i+"] = '"+es.tid.serial.TdiSerialUtil.escapaJavascript((String)this.comments.elementAt(i))+"';\n");
    }
    js.append(varName+".years = new Array("+this.years.size()+");\n");
    for (int i = 0;i < this.years.size();i++) {
        js.append(varName+".years["+i+"] = "+this.years.elementAt(i)+";\n");
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"Composite\" package=\"org.qualipso.advdoc.ws.client.storage.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<Composite type=\"Composite\" package=\"org.qualipso.advdoc.ws.client.storage.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    xml.append(_indentar(indents+1)+"<id type=\"int\">"+this.id+"</id>");
    xml.append("\n");
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<name type=\"string\">"+tdi.text.StringUtil.escapeXML(this.name,false)+"</name>");
    } else {
        xml.append(_indentar(indents+1)+"<name type=\"string\">"+this.name+"</name>");
    }

    xml.append("\n");
    xml.append(_indentar(indents+1)+"<value type=\"double\">"+this.value+"</value>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<comments type=\"string[]\" size=\""+this.comments.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.comments.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(_indentar(indents+2)+"<comments"+"_"+sufijo+" type=\"string\">"+comments.elementAt(i)+"</comments"+"_"+sufijo+">");
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</comments>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<years type=\"int[]\" size=\""+this.years.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.years.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(_indentar(indents+2)+"<years"+"_"+sufijo+" type=\"int\">"+years.elementAt(i)+"</years"+"_"+sufijo+">");
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</years>");
    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</Composite>");
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
    __struct__.put("id", new Integer(id));
    __struct__.put("name", tdi.text.StringUtil.sustituyeUnicode(this.name));
    __struct__.put("value", new Double(value));
    java.util.Vector __vector_comments = new java.util.Vector();
    for (int __i__ = 0;__i__ < comments.size();__i__++) {
        __vector_comments.addElement(tdi.text.StringUtil.sustituyeUnicode((String)this.comments.elementAt(__i__)));
    }
    __struct__.put("comments",__vector_comments);
    java.util.Vector __vector_years = new java.util.Vector();
    for (int __i__ = 0;__i__ < years.size();__i__++) {
        __vector_years.addElement(new Integer(years.elementAt(__i__)));
    }
    __struct__.put("years",__vector_years);
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_id = __params__.get("id");
    if (__object_id == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo id");
    }
    if (!(__object_id instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo id no es de tipo Integer");
    }
    Integer __int_id = (Integer)__object_id;
    setId(__int_id.intValue());
    Object __object_name = __params__.get("name");
    if (__object_name == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo name");
    }
    if (!(__object_name instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo name no es de tipo String");
    }
    setName((String)__object_name);
    Object __object_value = __params__.get("value");
    if (__object_value == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo value");
    }
    if (!(__object_value instanceof Double) && !(__object_value instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo value no es de tipo Double");
    }
    Double __double_value = new Double(__object_value.toString());
    setValue(__double_value.doubleValue());
    Object __object_comments = __params__.get("comments");
    if (__object_comments == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector comments");
    }
    if (!(__object_comments instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo comments no es de tipo Vector");
    }
    java.util.Vector __vector_comments = (java.util.Vector)__object_comments;
    for (int i = 0;i < __vector_comments.size();i++) {
        Object __element__ = __vector_comments.elementAt(i);
        if (!(__element__ instanceof String)) {
            throw new Exception(getClass().getName()+".fromRPC() El elemento "+i+" del array comments no es de tipo String");
        }
        addComments((String)__element__);
    }
    Object __object_years = __params__.get("years");
    if (__object_years == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector years");
    }
    if (!(__object_years instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo years no es de tipo Vector");
    }
    java.util.Vector __vector_years = (java.util.Vector)__object_years;
    for (int i = 0;i < __vector_years.size();i++) {
        Object __element__ = __vector_years.elementAt(i);
        if (!(__element__ instanceof Integer)) {
            throw new Exception(getClass().getName()+".fromRPC() El elemento "+i+" del array years no es de tipo Integer");
        }
        Integer __int__ = (Integer)__element__;
        addYears(__int__.intValue());
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
      org.w3c.dom.Element __e = getNodeByName(__node,"id");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setId(Integer.parseInt(__v));
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"name");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setName(__v);
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"value");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setValue(Double.parseDouble(__v));
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"comments");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        String __v = getNodeByName(__element,"comments_"+i).getChildNodes().item(0).getNodeValue();
        addComments(__v);
      }
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"years");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        String __v = getNodeByName(__element,"years_"+i).getChildNodes().item(0).getNodeValue();
        addYears(Integer.parseInt(__v));
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
        writer.write("<id>");
        writer.write(Integer.toString(this.getId()));
        writer.write("</id>");
        writer.write("\n");
        writer.write("<name>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getName(), false));
        writer.write("</name>");
        writer.write("\n");
        writer.write("<value>");
        writer.write(Double.toString(this.getValue()));
        writer.write("</value>");
        writer.write("\n");
        writer.write("<comments>");
        writer.write("\n");
        for (int i = 0; i < comments_size(); i++) {
            writer.write("<string>");
        writer.write(this.getComments(i));
            writer.write("</string>");
            writer.write("\n");
        }
        writer.write("</comments>");
        writer.write("\n");
        writer.write("<years>");
        writer.write("\n");
        for (int i = 0; i < years_size(); i++) {
            writer.write("<int>");
        writer.write(Integer.toString(this.getYears(i)));
            writer.write("</int>");
            writer.write("\n");
        }
        writer.write("</years>");
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

        node = beanNode.getFirstChildByName("id");
        if (node != null && node.getContents() != null) {
            this.setId(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("name");
        if (node != null && node.getContents() != null) {
            this.setName(node.getContents());
        }

        node = beanNode.getFirstChildByName("value");
        if (node != null && node.getContents() != null) {
            this.setValue(Double.parseDouble(node.getContents()));
        }

        tdi.xml.parser.TdiXmlNode[] arrayNodes;
        node = beanNode.getFirstChildByName("comments");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("string");
            if (arrayNodes != null) {
                this.clearComments();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        this.addComments(arrayNodes[i].getContents());
                    }  // arrayNodes[i] != null
                }  // for
            }  // arrayNodes != null
        }  // node != null
        node = beanNode.getFirstChildByName("years");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("int");
            if (arrayNodes != null) {
                this.clearYears();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        this.addYears(Integer.parseInt(arrayNodes[i].getContents()));
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
        json.put("id",this.getId());
        json.put("name",this.getName());
        json.put("value",this.getValue());
        JSONArray jArray;
        JSONArray jObjectArray;
        jArray = new JSONArray();
        for (int i = 0;i < comments_size();i++) {
            jArray.put(getComments(i));
        }
        json.put("comments",jArray);
        jArray = new JSONArray();
        for (int i = 0;i < years_size();i++) {
            jArray.put(getYears(i));
        }
        json.put("years",jArray);
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
        this.setId(json.getInt("id"));
        this.setName(json.getString("name"));
        this.setValue(json.getDouble("value"));
        JSONArray jArray;
        JSONArray jObjectArray;
        jArray = json.getJSONArray("comments");
        this.clearComments();
        for (int i = 0;i < jArray.length();i++) {
            this.addComments(jArray.getString(i));
        }
        jArray = json.getJSONArray("years");
        this.clearYears();
        for (int i = 0;i < jArray.length();i++) {
            this.addYears(jArray.getInt(i));
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
        return new Composite(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof Composite)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        Composite bean = (Composite)source;
        this.set(bean);
    }

}
