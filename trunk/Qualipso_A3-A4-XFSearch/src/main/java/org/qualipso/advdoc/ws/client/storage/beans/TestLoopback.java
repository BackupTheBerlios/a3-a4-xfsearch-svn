//8316bc96035c83ef613f0c8642b341

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : TestLoopback.java
// Proyecto : QualiPSoStorage
// Versión  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.storage.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * 
 * @composed 1 - 0..* org.qualipso.advdoc.ws.client.storage.beans.Composite
 * @composed 1 - 0..* org.qualipso.advdoc.ws.client.storage.beans.Composite
 * @composed 1 - 0..* org.qualipso.advdoc.ws.client.storage.beans.Composite
 * @author FRAWA
 * @version 1.0
 */
public class TestLoopback extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     * 
     */
    protected int clientRequestTime = 0;
    /**
     * 
     */
    protected int clientResponseTime = 0;
    /**
     * 
     */
    protected int serverTime = 0;
    /**
     *  ( org.qualipso.advdoc.ws.client.storage.beans.Composite[] )
     * @composed org.qualipso.advdoc.ws.client.storage.beans.Composite
     */
    protected ObjectVector data1 = new ObjectVector(10);
    /**
     *  ( org.qualipso.advdoc.ws.client.storage.beans.Composite[] )
     * @composed org.qualipso.advdoc.ws.client.storage.beans.Composite
     */
    protected ObjectVector data2 = new ObjectVector(10);
    /**
     *  ( org.qualipso.advdoc.ws.client.storage.beans.Composite[] )
     * @composed org.qualipso.advdoc.ws.client.storage.beans.Composite
     */
    protected ObjectVector data3 = new ObjectVector(10);

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public TestLoopback() {
        // Registrarse como Observer de los atributos hijos
        this.data1.addObserver(this);
        this.data2.addObserver(this);
        this.data3.addObserver(this);
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public TestLoopback(TestLoopback object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(TestLoopback object) {
        setClientRequestTime(object.getClientRequestTime());
        setClientResponseTime(object.getClientResponseTime());
        setServerTime(object.getServerTime());
        this.data1.clear();
        for (int i = 0;i < object.data1.size();i++) {
            addData1(new org.qualipso.advdoc.ws.client.storage.beans.Composite(object.getData1(i)));
        }
        this.data2.clear();
        for (int i = 0;i < object.data2.size();i++) {
            addData2(new org.qualipso.advdoc.ws.client.storage.beans.Composite(object.getData2(i)));
        }
        this.data3.clear();
        for (int i = 0;i < object.data3.size();i++) {
            addData3(new org.qualipso.advdoc.ws.client.storage.beans.Composite(object.getData3(i)));
        }
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    clientRequestTime    
     * @param    clientResponseTime    
     * @param    serverTime    
     * @param    data1    
     * @param    data2    
     * @param    data3    
     */
    public TestLoopback(int clientRequestTime,int serverTime,int clientResponseTime,org.qualipso.advdoc.ws.client.storage.beans.Composite[] data1,org.qualipso.advdoc.ws.client.storage.beans.Composite[] data2,org.qualipso.advdoc.ws.client.storage.beans.Composite[] data3) {
        setClientRequestTime(clientRequestTime);
        setClientResponseTime(clientResponseTime);
        setServerTime(serverTime);
        for (int __i = 0;__i < data1.length;__i++) {
            addData1(data1[__i]);
        }
        for (int __i = 0;__i < data2.length;__i++) {
            addData2(data2[__i]);
        }
        for (int __i = 0;__i < data3.length;__i++) {
            addData3(data3[__i]);
        }
    }



    /**
     * Conversión a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("TestLoopback",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        for (int i = 0;i < this.data1_size();i++) {
            ok = ok && this.getData1(i).valida(errores);
        }
        for (int i = 0;i < this.data2_size();i++) {
            ok = ok && this.getData2(i).valida(errores);
        }
        for (int i = 0;i < this.data3_size();i++) {
            ok = ok && this.getData3(i).valida(errores);
        }
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof TestLoopback)) {
            return false;
        }
        TestLoopback value = (TestLoopback)obj;
        if (value.clientRequestTime != this.clientRequestTime) {
            return false;
        }
        if (value.clientResponseTime != this.clientResponseTime) {
            return false;
        }
        if (value.serverTime != this.serverTime) {
            return false;
        }
        if (value.data1.size() != this.data1.size()) {
            return false;
        }
        for (int i = 0;i < value.data1.size();i++) {
            if (!(value.getData1(i).equals(this.getData1(i)))) {
                return false;
            }
        }
        if (value.data2.size() != this.data2.size()) {
            return false;
        }
        for (int i = 0;i < value.data2.size();i++) {
            if (!(value.getData2(i).equals(this.getData2(i)))) {
                return false;
            }
        }
        if (value.data3.size() != this.data3.size()) {
            return false;
        }
        for (int i = 0;i < value.data3.size();i++) {
            if (!(value.getData3(i).equals(this.getData3(i)))) {
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
        // Concatenar con el hashcode del atributo clientRequestTime
        code = tdi.gen.TdiHashcode.concat(code,this.clientRequestTime);
        // Concatenar con el hashcode del atributo clientResponseTime
        code = tdi.gen.TdiHashcode.concat(code,this.clientResponseTime);
        // Concatenar con el hashcode del atributo serverTime
        code = tdi.gen.TdiHashcode.concat(code,this.serverTime);
        // Concatenar con el hashcode del atributo data1
        for (int i = 0;i < data1.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getData1(i));
        }
        // Concatenar con el hashcode del atributo data2
        for (int i = 0;i < data2.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getData2(i));
        }
        // Concatenar con el hashcode del atributo data3
        for (int i = 0;i < data3.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getData3(i));
        }
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(TestLoopback[] __array1,TestLoopback[] __array2) {
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
     * Lectura del atributo clientRequestTime
     * @return   Valor del atributo clientRequestTime
     */
    public int getClientRequestTime() { return this.clientRequestTime; }

    /**
     * Escritura del atributo clientRequestTime
     * @param    valor    Nuevo valor del atributo clientRequestTime
     */
    public void setClientRequestTime(int valor) { 
        this.clientRequestTime = valor;
        setChanged();
    }

    /**
     * Lectura del atributo clientResponseTime
     * @return   Valor del atributo clientResponseTime
     */
    public int getClientResponseTime() { return this.clientResponseTime; }

    /**
     * Escritura del atributo clientResponseTime
     * @param    valor    Nuevo valor del atributo clientResponseTime
     */
    public void setClientResponseTime(int valor) { 
        this.clientResponseTime = valor;
        setChanged();
    }

    /**
     * Lectura del atributo serverTime
     * @return   Valor del atributo serverTime
     */
    public int getServerTime() { return this.serverTime; }

    /**
     * Escritura del atributo serverTime
     * @param    valor    Nuevo valor del atributo serverTime
     */
    public void setServerTime(int valor) { 
        this.serverTime = valor;
        setChanged();
    }

    /**
     * Vacia los elementos del atributo data1
     */
    public void clearData1() { this.data1.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo data1
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeData1(int position) {
        return this.data1.remove(position);
    }

    /**
     * Número de elementos en el atributo data1
     * @return   Número de elementos
     */
    public int data1_size() { return this.data1.size(); }

    /**
     * Elementos del atributo data1
     * @return   Array de elementos
     */
    public org.qualipso.advdoc.ws.client.storage.beans.Composite[] getData1() {
        return (org.qualipso.advdoc.ws.client.storage.beans.Composite[])this.data1.toArray(new org.qualipso.advdoc.ws.client.storage.beans.Composite[this.data1.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo data1
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public org.qualipso.advdoc.ws.client.storage.beans.Composite getData1(int position) {
        return (org.qualipso.advdoc.ws.client.storage.beans.Composite)this.data1.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo data1
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setData1(int position,org.qualipso.advdoc.ws.client.storage.beans.Composite valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        }
        this.data1.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo data1
     * @param    valores    Los nuevos elementos
     */
    public void setData1(org.qualipso.advdoc.ws.client.storage.beans.Composite[] valores) {
        this.data1 = new ObjectVector(valores);
        this.data1.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo data1
     * @param    valor    Nuevo elemento
     */
    public void addData1(org.qualipso.advdoc.ws.client.storage.beans.Composite valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        }
        this.data1.addElement(valor);
        setChanged();
    }

    /**
     * Vacia los elementos del atributo data2
     */
    public void clearData2() { this.data2.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo data2
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeData2(int position) {
        return this.data2.remove(position);
    }

    /**
     * Número de elementos en el atributo data2
     * @return   Número de elementos
     */
    public int data2_size() { return this.data2.size(); }

    /**
     * Elementos del atributo data2
     * @return   Array de elementos
     */
    public org.qualipso.advdoc.ws.client.storage.beans.Composite[] getData2() {
        return (org.qualipso.advdoc.ws.client.storage.beans.Composite[])this.data2.toArray(new org.qualipso.advdoc.ws.client.storage.beans.Composite[this.data2.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo data2
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public org.qualipso.advdoc.ws.client.storage.beans.Composite getData2(int position) {
        return (org.qualipso.advdoc.ws.client.storage.beans.Composite)this.data2.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo data2
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setData2(int position,org.qualipso.advdoc.ws.client.storage.beans.Composite valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        }
        this.data2.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo data2
     * @param    valores    Los nuevos elementos
     */
    public void setData2(org.qualipso.advdoc.ws.client.storage.beans.Composite[] valores) {
        this.data2 = new ObjectVector(valores);
        this.data2.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo data2
     * @param    valor    Nuevo elemento
     */
    public void addData2(org.qualipso.advdoc.ws.client.storage.beans.Composite valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        }
        this.data2.addElement(valor);
        setChanged();
    }

    /**
     * Vacia los elementos del atributo data3
     */
    public void clearData3() { this.data3.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo data3
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeData3(int position) {
        return this.data3.remove(position);
    }

    /**
     * Número de elementos en el atributo data3
     * @return   Número de elementos
     */
    public int data3_size() { return this.data3.size(); }

    /**
     * Elementos del atributo data3
     * @return   Array de elementos
     */
    public org.qualipso.advdoc.ws.client.storage.beans.Composite[] getData3() {
        return (org.qualipso.advdoc.ws.client.storage.beans.Composite[])this.data3.toArray(new org.qualipso.advdoc.ws.client.storage.beans.Composite[this.data3.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo data3
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public org.qualipso.advdoc.ws.client.storage.beans.Composite getData3(int position) {
        return (org.qualipso.advdoc.ws.client.storage.beans.Composite)this.data3.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo data3
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setData3(int position,org.qualipso.advdoc.ws.client.storage.beans.Composite valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        }
        this.data3.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo data3
     * @param    valores    Los nuevos elementos
     */
    public void setData3(org.qualipso.advdoc.ws.client.storage.beans.Composite[] valores) {
        this.data3 = new ObjectVector(valores);
        this.data3.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo data3
     * @param    valor    Nuevo elemento
     */
    public void addData3(org.qualipso.advdoc.ws.client.storage.beans.Composite valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        }
        this.data3.addElement(valor);
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
                "TestLoopback <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int clientRequestTime<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int clientResponseTime<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int serverTime<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Composite[] data1<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int id<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string name<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double value<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string[] comments<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int[] years<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Composite[] data2<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Composite[] data3<BR>",
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
        this.setClientRequestTime(0);
        this.setClientResponseTime(0);
        this.setServerTime(0);
        this.data1.clear();
        org.qualipso.advdoc.ws.client.storage.beans.Composite v_0_1 = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        v_0_1.fillSampleData();
        this.addData1(v_0_1);
        org.qualipso.advdoc.ws.client.storage.beans.Composite v_0_2 = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        v_0_2.fillSampleData();
        this.addData1(v_0_2);
        this.data2.clear();
        org.qualipso.advdoc.ws.client.storage.beans.Composite v_1_1 = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        v_1_1.fillSampleData();
        this.addData2(v_1_1);
        org.qualipso.advdoc.ws.client.storage.beans.Composite v_1_2 = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        v_1_2.fillSampleData();
        this.addData2(v_1_2);
        this.data3.clear();
        org.qualipso.advdoc.ws.client.storage.beans.Composite v_2_1 = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        v_2_1.fillSampleData();
        this.addData3(v_2_1);
        org.qualipso.advdoc.ws.client.storage.beans.Composite v_2_2 = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        v_2_2.fillSampleData();
        this.addData3(v_2_2);
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append(this.clientRequestTime);
    output.append(this.clientResponseTime);
    output.append(this.serverTime);
    output.append((int)this.data1.size());
    for (int i=0; i<this.data1.size(); i++) {
      output.append((org.qualipso.advdoc.ws.client.storage.beans.Composite)this.data1.elementAt(i));
    }
    output.append((int)this.data2.size());
    for (int i=0; i<this.data2.size(); i++) {
      output.append((org.qualipso.advdoc.ws.client.storage.beans.Composite)this.data2.elementAt(i));
    }
    output.append((int)this.data3.size());
    for (int i=0; i<this.data3.size(); i++) {
      output.append((org.qualipso.advdoc.ws.client.storage.beans.Composite)this.data3.elementAt(i));
    }
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    this.clientRequestTime = input.extract_int();
    this.clientResponseTime = input.extract_int();
    this.serverTime = input.extract_int();
    {
        int len = input.extract_int();
        this.data1 = new ObjectVector(len);
        this.data1.addObserver(this);
        for (int i = 0; i < len; i++) {
          org.qualipso.advdoc.ws.client.storage.beans.Composite aux = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
          input.extract_object(aux);
          this.data1.addElement(aux);
        }
    }
    {
        int len = input.extract_int();
        this.data2 = new ObjectVector(len);
        this.data2.addObserver(this);
        for (int i = 0; i < len; i++) {
          org.qualipso.advdoc.ws.client.storage.beans.Composite aux = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
          input.extract_object(aux);
          this.data2.addElement(aux);
        }
    }
    {
        int len = input.extract_int();
        this.data3 = new ObjectVector(len);
        this.data3.addObserver(this);
        for (int i = 0; i < len; i++) {
          org.qualipso.advdoc.ws.client.storage.beans.Composite aux = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
          input.extract_object(aux);
          this.data3.addElement(aux);
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
        js.append(varName+".__constructor__ = 'TestLoopback';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.storage.beans';\n");
    }
    js.append(varName+".clientRequestTime = "+this.clientRequestTime+";\n");
    js.append(varName+".clientResponseTime = "+this.clientResponseTime+";\n");
    js.append(varName+".serverTime = "+this.serverTime+";\n");
    js.append(varName+".data1 = new Array("+this.data1.size()+");\n");
    for (int i = 0;i < this.data1.size();i++) {
        TdiJavascriptable object = (TdiJavascriptable)this.data1.elementAt(i);
        js.append(object.toJS(false,true,varName+".data1["+i+"]",0));
    }
    js.append(varName+".data2 = new Array("+this.data2.size()+");\n");
    for (int i = 0;i < this.data2.size();i++) {
        TdiJavascriptable object = (TdiJavascriptable)this.data2.elementAt(i);
        js.append(object.toJS(false,true,varName+".data2["+i+"]",0));
    }
    js.append(varName+".data3 = new Array("+this.data3.size()+");\n");
    for (int i = 0;i < this.data3.size();i++) {
        TdiJavascriptable object = (TdiJavascriptable)this.data3.elementAt(i);
        js.append(object.toJS(false,true,varName+".data3["+i+"]",0));
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"TestLoopback\" package=\"org.qualipso.advdoc.ws.client.storage.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<TestLoopback type=\"TestLoopback\" package=\"org.qualipso.advdoc.ws.client.storage.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    xml.append(_indentar(indents+1)+"<clientRequestTime type=\"int\">"+this.clientRequestTime+"</clientRequestTime>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<clientResponseTime type=\"int\">"+this.clientResponseTime+"</clientResponseTime>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<serverTime type=\"int\">"+this.serverTime+"</serverTime>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<data1 type=\"org.qualipso.advdoc.ws.client.storage.beans.Composite[]\" size=\""+this.data1.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.data1.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(((org.qualipso.advdoc.ws.client.storage.beans.Composite)data1.elementAt(i)).toXML("data1"+"_"+sufijo, indents+2,ponerIndicesDeArrays,escaparStrings));
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</data1>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<data2 type=\"org.qualipso.advdoc.ws.client.storage.beans.Composite[]\" size=\""+this.data2.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.data2.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(((org.qualipso.advdoc.ws.client.storage.beans.Composite)data2.elementAt(i)).toXML("data2"+"_"+sufijo, indents+2,ponerIndicesDeArrays,escaparStrings));
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</data2>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<data3 type=\"org.qualipso.advdoc.ws.client.storage.beans.Composite[]\" size=\""+this.data3.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.data3.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(((org.qualipso.advdoc.ws.client.storage.beans.Composite)data3.elementAt(i)).toXML("data3"+"_"+sufijo, indents+2,ponerIndicesDeArrays,escaparStrings));
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</data3>");
    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</TestLoopback>");
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
    __struct__.put("clientRequestTime", new Integer(clientRequestTime));
    __struct__.put("clientResponseTime", new Integer(clientResponseTime));
    __struct__.put("serverTime", new Integer(serverTime));
    java.util.Vector __vector_data1 = new java.util.Vector();
    for (int __i__ = 0;__i__ < data1.size();__i__++) {
        org.qualipso.advdoc.ws.client.storage.beans.Composite __object__ = (org.qualipso.advdoc.ws.client.storage.beans.Composite)data1.elementAt(__i__);
        __vector_data1.addElement(__object__.toRPC());
    }
    __struct__.put("data1",__vector_data1);
    java.util.Vector __vector_data2 = new java.util.Vector();
    for (int __i__ = 0;__i__ < data2.size();__i__++) {
        org.qualipso.advdoc.ws.client.storage.beans.Composite __object__ = (org.qualipso.advdoc.ws.client.storage.beans.Composite)data2.elementAt(__i__);
        __vector_data2.addElement(__object__.toRPC());
    }
    __struct__.put("data2",__vector_data2);
    java.util.Vector __vector_data3 = new java.util.Vector();
    for (int __i__ = 0;__i__ < data3.size();__i__++) {
        org.qualipso.advdoc.ws.client.storage.beans.Composite __object__ = (org.qualipso.advdoc.ws.client.storage.beans.Composite)data3.elementAt(__i__);
        __vector_data3.addElement(__object__.toRPC());
    }
    __struct__.put("data3",__vector_data3);
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_clientRequestTime = __params__.get("clientRequestTime");
    if (__object_clientRequestTime == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo clientRequestTime");
    }
    if (!(__object_clientRequestTime instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo clientRequestTime no es de tipo Integer");
    }
    Integer __int_clientRequestTime = (Integer)__object_clientRequestTime;
    setClientRequestTime(__int_clientRequestTime.intValue());
    Object __object_clientResponseTime = __params__.get("clientResponseTime");
    if (__object_clientResponseTime == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo clientResponseTime");
    }
    if (!(__object_clientResponseTime instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo clientResponseTime no es de tipo Integer");
    }
    Integer __int_clientResponseTime = (Integer)__object_clientResponseTime;
    setClientResponseTime(__int_clientResponseTime.intValue());
    Object __object_serverTime = __params__.get("serverTime");
    if (__object_serverTime == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo serverTime");
    }
    if (!(__object_serverTime instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo serverTime no es de tipo Integer");
    }
    Integer __int_serverTime = (Integer)__object_serverTime;
    setServerTime(__int_serverTime.intValue());
    Object __object_data1 = __params__.get("data1");
    if (__object_data1 == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector data1");
    }
    if (!(__object_data1 instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo data1 no es de tipo Vector");
    }
    java.util.Vector __vector_data1 = (java.util.Vector)__object_data1;
    for (int i = 0;i < __vector_data1.size();i++) {
        Object __element__ = __vector_data1.elementAt(i);
        if (!(__element__ instanceof java.util.Hashtable)) {
            throw new Exception(getClass().getName()+".fromRPC() El atributo data1 no es de tipo Hashtable");
        }
        java.util.Hashtable __hashtable__ = (java.util.Hashtable)__element__;
        org.qualipso.advdoc.ws.client.storage.beans.Composite __value__;
        String __constructor__ = (String)__hashtable__.get("__constructor__");
        // Si existe el atributo __constructor__ crear el objeto de la clase indicada
        if (__constructor__ == null || __constructor__.equals("")) {
            __value__ = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        } else {
            __value__ = (org.qualipso.advdoc.ws.client.storage.beans.Composite)Class.forName(__constructor__).newInstance();
        }
        __value__.fromRPC(__hashtable__);
        addData1(__value__);
    }
    Object __object_data2 = __params__.get("data2");
    if (__object_data2 == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector data2");
    }
    if (!(__object_data2 instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo data2 no es de tipo Vector");
    }
    java.util.Vector __vector_data2 = (java.util.Vector)__object_data2;
    for (int i = 0;i < __vector_data2.size();i++) {
        Object __element__ = __vector_data2.elementAt(i);
        if (!(__element__ instanceof java.util.Hashtable)) {
            throw new Exception(getClass().getName()+".fromRPC() El atributo data2 no es de tipo Hashtable");
        }
        java.util.Hashtable __hashtable__ = (java.util.Hashtable)__element__;
        org.qualipso.advdoc.ws.client.storage.beans.Composite __value__;
        String __constructor__ = (String)__hashtable__.get("__constructor__");
        // Si existe el atributo __constructor__ crear el objeto de la clase indicada
        if (__constructor__ == null || __constructor__.equals("")) {
            __value__ = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        } else {
            __value__ = (org.qualipso.advdoc.ws.client.storage.beans.Composite)Class.forName(__constructor__).newInstance();
        }
        __value__.fromRPC(__hashtable__);
        addData2(__value__);
    }
    Object __object_data3 = __params__.get("data3");
    if (__object_data3 == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector data3");
    }
    if (!(__object_data3 instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo data3 no es de tipo Vector");
    }
    java.util.Vector __vector_data3 = (java.util.Vector)__object_data3;
    for (int i = 0;i < __vector_data3.size();i++) {
        Object __element__ = __vector_data3.elementAt(i);
        if (!(__element__ instanceof java.util.Hashtable)) {
            throw new Exception(getClass().getName()+".fromRPC() El atributo data3 no es de tipo Hashtable");
        }
        java.util.Hashtable __hashtable__ = (java.util.Hashtable)__element__;
        org.qualipso.advdoc.ws.client.storage.beans.Composite __value__;
        String __constructor__ = (String)__hashtable__.get("__constructor__");
        // Si existe el atributo __constructor__ crear el objeto de la clase indicada
        if (__constructor__ == null || __constructor__.equals("")) {
            __value__ = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        } else {
            __value__ = (org.qualipso.advdoc.ws.client.storage.beans.Composite)Class.forName(__constructor__).newInstance();
        }
        __value__.fromRPC(__hashtable__);
        addData3(__value__);
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
      org.w3c.dom.Element __e = getNodeByName(__node,"clientRequestTime");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setClientRequestTime(Integer.parseInt(__v));
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"clientResponseTime");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setClientResponseTime(Integer.parseInt(__v));
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"serverTime");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setServerTime(Integer.parseInt(__v));
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"data1");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        org.w3c.dom.Element __element2 = getNodeByName(__element,"data1_"+i);
        org.qualipso.advdoc.ws.client.storage.beans.Composite __entry;
        if (__element2.getAttribute("package") != null && __element2.getAttribute("package").length() != 0) {
          __entry = (org.qualipso.advdoc.ws.client.storage.beans.Composite) Class.forName(__element2.getAttribute("package")+"."+__element2.getAttribute("type")).newInstance();
        } else {
          __entry = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        }
        __entry.fromXML(__element2);
        addData1(__entry);
      }
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"data2");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        org.w3c.dom.Element __element2 = getNodeByName(__element,"data2_"+i);
        org.qualipso.advdoc.ws.client.storage.beans.Composite __entry;
        if (__element2.getAttribute("package") != null && __element2.getAttribute("package").length() != 0) {
          __entry = (org.qualipso.advdoc.ws.client.storage.beans.Composite) Class.forName(__element2.getAttribute("package")+"."+__element2.getAttribute("type")).newInstance();
        } else {
          __entry = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        }
        __entry.fromXML(__element2);
        addData2(__entry);
      }
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"data3");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        org.w3c.dom.Element __element2 = getNodeByName(__element,"data3_"+i);
        org.qualipso.advdoc.ws.client.storage.beans.Composite __entry;
        if (__element2.getAttribute("package") != null && __element2.getAttribute("package").length() != 0) {
          __entry = (org.qualipso.advdoc.ws.client.storage.beans.Composite) Class.forName(__element2.getAttribute("package")+"."+__element2.getAttribute("type")).newInstance();
        } else {
          __entry = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
        }
        __entry.fromXML(__element2);
        addData3(__entry);
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
        writer.write("<clientRequestTime>");
        writer.write(Integer.toString(this.getClientRequestTime()));
        writer.write("</clientRequestTime>");
        writer.write("\n");
        writer.write("<clientResponseTime>");
        writer.write(Integer.toString(this.getClientResponseTime()));
        writer.write("</clientResponseTime>");
        writer.write("\n");
        writer.write("<serverTime>");
        writer.write(Integer.toString(this.getServerTime()));
        writer.write("</serverTime>");
        writer.write("\n");
        writer.write("<data1>");
        writer.write("\n");
        for (int i = 0; i < data1_size(); i++) {
            writer.write("<Composite>");
            writer.write("\n");
            this.getData1(i).toSOAP(writer);
            writer.write("</Composite>");
            writer.write("\n");
        }
        writer.write("</data1>");
        writer.write("\n");
        writer.write("<data2>");
        writer.write("\n");
        for (int i = 0; i < data2_size(); i++) {
            writer.write("<Composite>");
            writer.write("\n");
            this.getData2(i).toSOAP(writer);
            writer.write("</Composite>");
            writer.write("\n");
        }
        writer.write("</data2>");
        writer.write("\n");
        writer.write("<data3>");
        writer.write("\n");
        for (int i = 0; i < data3_size(); i++) {
            writer.write("<Composite>");
            writer.write("\n");
            this.getData3(i).toSOAP(writer);
            writer.write("</Composite>");
            writer.write("\n");
        }
        writer.write("</data3>");
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

        node = beanNode.getFirstChildByName("clientRequestTime");
        if (node != null && node.getContents() != null) {
            this.setClientRequestTime(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("clientResponseTime");
        if (node != null && node.getContents() != null) {
            this.setClientResponseTime(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("serverTime");
        if (node != null && node.getContents() != null) {
            this.setServerTime(Integer.parseInt(node.getContents()));
        }

        tdi.xml.parser.TdiXmlNode[] arrayNodes;
        node = beanNode.getFirstChildByName("data1");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("Composite");
            if (arrayNodes != null) {
                this.clearData1();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        org.qualipso.advdoc.ws.client.storage.beans.Composite tmp = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
                        tmp.fromSOAP(arrayNodes[i]);
                        this.addData1(tmp);
                    }  // arrayNodes[i] != null
                }  // for
            }  // arrayNodes != null
        }  // node != null
        node = beanNode.getFirstChildByName("data2");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("Composite");
            if (arrayNodes != null) {
                this.clearData2();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        org.qualipso.advdoc.ws.client.storage.beans.Composite tmp = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
                        tmp.fromSOAP(arrayNodes[i]);
                        this.addData2(tmp);
                    }  // arrayNodes[i] != null
                }  // for
            }  // arrayNodes != null
        }  // node != null
        node = beanNode.getFirstChildByName("data3");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("Composite");
            if (arrayNodes != null) {
                this.clearData3();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        org.qualipso.advdoc.ws.client.storage.beans.Composite tmp = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
                        tmp.fromSOAP(arrayNodes[i]);
                        this.addData3(tmp);
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
        json.put("clientRequestTime",this.getClientRequestTime());
        json.put("clientResponseTime",this.getClientResponseTime());
        json.put("serverTime",this.getServerTime());
        JSONArray jArray;
        JSONArray jObjectArray;
        jObjectArray = new JSONArray();
        for (int i = 0;i < data1_size();i++) {
            JSONObject jObj_i = new JSONObject();
            this.getData1(i).toJSON(jObj_i);
            jObjectArray.put(jObj_i);
        }
        json.put("data1",jObjectArray);
        jObjectArray = new JSONArray();
        for (int i = 0;i < data2_size();i++) {
            JSONObject jObj_i = new JSONObject();
            this.getData2(i).toJSON(jObj_i);
            jObjectArray.put(jObj_i);
        }
        json.put("data2",jObjectArray);
        jObjectArray = new JSONArray();
        for (int i = 0;i < data3_size();i++) {
            JSONObject jObj_i = new JSONObject();
            this.getData3(i).toJSON(jObj_i);
            jObjectArray.put(jObj_i);
        }
        json.put("data3",jObjectArray);
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
        this.setClientRequestTime(json.getInt("clientRequestTime"));
        this.setClientResponseTime(json.getInt("clientResponseTime"));
        this.setServerTime(json.getInt("serverTime"));
        JSONArray jArray;
        JSONArray jObjectArray;
        jObjectArray = json.getJSONArray("data1");
        this.clearData1();
        for (int i = 0;i < jObjectArray.length();i++) {
            JSONObject jObj_i = jObjectArray.getJSONObject(i);
            org.qualipso.advdoc.ws.client.storage.beans.Composite tmp = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
            tmp.fromJSON(jObj_i);
            this.addData1(tmp);
        }
        jObjectArray = json.getJSONArray("data2");
        this.clearData2();
        for (int i = 0;i < jObjectArray.length();i++) {
            JSONObject jObj_i = jObjectArray.getJSONObject(i);
            org.qualipso.advdoc.ws.client.storage.beans.Composite tmp = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
            tmp.fromJSON(jObj_i);
            this.addData2(tmp);
        }
        jObjectArray = json.getJSONArray("data3");
        this.clearData3();
        for (int i = 0;i < jObjectArray.length();i++) {
            JSONObject jObj_i = jObjectArray.getJSONObject(i);
            org.qualipso.advdoc.ws.client.storage.beans.Composite tmp = new org.qualipso.advdoc.ws.client.storage.beans.Composite();
            tmp.fromJSON(jObj_i);
            this.addData3(tmp);
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
        return new TestLoopback(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof TestLoopback)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        TestLoopback bean = (TestLoopback)source;
        this.set(bean);
    }

}
