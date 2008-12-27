//bfc86fc24ac7b369b5e2d3e1e9c681e

/* 1.0 */

// TDI_3971_4573_0146_8888_2525_8264_3791
//-----------------------------------------------------------------
// Fichero  : ExecQuery_req.java
// Proyecto : QualiPSoSearchAPI
// Versión  : 1.0
// Generado por FRAWA. NO MODIFICAR!!!
//-----------------------------------------------------------------

package org.qualipso.advdoc.ws.client.search.beans;
import es.tid.serial.*;
import es.tid.serial.json.*;



/**
 * 
 * @composed 1 - 0..* org.qualipso.advdoc.ws.client.search.beans.Namespace
 * @composed 1 - 0..* org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup
 * @author FRAWA
 * @version 1.0
 */
public class ExecQuery_req extends java.util.Observable implements es.tid.serial.TdiBean {

    // Atributos del bean

    /**
     * default namespace
     */
    protected String baseNamespace = "";
    /**
     * discard equal results
     */
    protected int distinct = 0;
    /**
     * max results
     */
    protected int limit = 0;
    /**
     * the start index
     */
    protected int offset = 0;
    /**
     * 
     */
    protected String orderBy = "";
    /**
     * query conditions (WHERE) ( String[] )
     * @composed string
     */
    protected ObjectVector conditions = new ObjectVector(10);    // query conditions (WHERE)
    /**
     * namespaces and prefixes ( org.qualipso.advdoc.ws.client.search.beans.Namespace[] )
     * @composed org.qualipso.advdoc.ws.client.search.beans.Namespace
     */
    protected ObjectVector namespaces = new ObjectVector(10);    // namespaces and prefixes
    /**
     * query optional conditions (OPTIONAL) ( org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup[] )
     * @composed org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup
     */
    protected ObjectVector optionalConditions = new ObjectVector(10);    // query optional conditions (OPTIONAL)
    /**
     * query variables (SELECT) ( String[] )
     * @composed string
     */
    protected ObjectVector variables = new ObjectVector(10);    // query variables (SELECT)

    // Atributos obligatorios del bean



    /**
     * Constructor por defecto
     */
    public ExecQuery_req() {
        // Registrarse como Observer de los atributos hijos
        this.conditions.addObserver(this);
        this.namespaces.addObserver(this);
        this.optionalConditions.addObserver(this);
        this.variables.addObserver(this);
    }


    /**
     * Constructor de copia
     * @param    object    Objeto a copiar
     */
    public ExecQuery_req(ExecQuery_req object) {
        this.set(object);
    }

    /**
     * Rellena el objeto con los datos de otro objeto
     * @param    object    Objeto a copiar
     */
    public void set(ExecQuery_req object) {
        setBaseNamespace(object.getBaseNamespace());
        setDistinct(object.getDistinct());
        setLimit(object.getLimit());
        setOffset(object.getOffset());
        setOrderBy(object.getOrderBy());
        setConditions(object.getConditions());
        this.namespaces.clear();
        for (int i = 0;i < object.namespaces.size();i++) {
            addNamespaces(new org.qualipso.advdoc.ws.client.search.beans.Namespace(object.getNamespaces(i)));
        }
        this.optionalConditions.clear();
        for (int i = 0;i < object.optionalConditions.size();i++) {
            addOptionalConditions(new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup(object.getOptionalConditions(i)));
        }
        setVariables(object.getVariables());
        setChanged();
    }


    /**
     * Constructor con los atributos de esta clase y sus superclases
     * @param    baseNamespace    default namespace
     * @param    distinct    discard equal results
     * @param    limit    max results
     * @param    offset    the start index
     * @param    orderBy    
     * @param    conditions    query conditions (WHERE)
     * @param    namespaces    namespaces and prefixes
     * @param    optionalConditions    query optional conditions (OPTIONAL)
     * @param    variables    query variables (SELECT)
     */
    public ExecQuery_req(String baseNamespace,org.qualipso.advdoc.ws.client.search.beans.Namespace[] namespaces,int distinct,String[] variables,String[] conditions,String orderBy,int limit,int offset,org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup[] optionalConditions) {
        setBaseNamespace(baseNamespace);
        setDistinct(distinct);
        setLimit(limit);
        setOffset(offset);
        setOrderBy(orderBy);
        for (int __i = 0;__i < conditions.length;__i++) {
            addConditions(conditions[__i]);
        }
        for (int __i = 0;__i < namespaces.length;__i++) {
            addNamespaces(namespaces[__i]);
        }
        for (int __i = 0;__i < optionalConditions.length;__i++) {
            addOptionalConditions(optionalConditions[__i]);
        }
        for (int __i = 0;__i < variables.length;__i++) {
            addVariables(variables[__i]);
        }
    }



    /**
     * Conversión a String
     * @return   Cadena en formato XML con el contenido del bean
     */
    public String toString() {
        return this.toXML("ExecQuery_req",0);
    }

    /**
     * Valida los atributos obligatorios del bean
     * @param    errores    Lista donde esta rutina introduce los errores de validacisn ocurridos (son de tipo String)
     * @return   Retorna true si los atributos obligatorios del bean se han rellenado
     */
    public boolean valida(java.util.ArrayList errores) {
        if (errores == null) errores = new java.util.ArrayList();
        boolean ok = true;
        for (int i = 0;i < this.namespaces_size();i++) {
            ok = ok && this.getNamespaces(i).valida(errores);
        }
        for (int i = 0;i < this.optionalConditions_size();i++) {
            ok = ok && this.getOptionalConditions(i).valida(errores);
        }
        return ok;
    }

    /**
     * Compara con el contenido de otro bean
     * @param    obj    Objeto a comparar
     * @return   Retorna true si los dos beans son iguales en contenido
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof ExecQuery_req)) {
            return false;
        }
        ExecQuery_req value = (ExecQuery_req)obj;
        if (!(value.baseNamespace.equals(this.baseNamespace))) {
            return false;
        }
        if (value.distinct != this.distinct) {
            return false;
        }
        if (value.limit != this.limit) {
            return false;
        }
        if (value.offset != this.offset) {
            return false;
        }
        if (!(value.orderBy.equals(this.orderBy))) {
            return false;
        }
        if (value.conditions.size() != this.conditions.size()) {
            return false;
        }
        for (int i = 0;i < value.conditions.size();i++) {
            if (!(value.getConditions(i).equals(this.getConditions(i)))) {
                return false;
            }
        }
        if (value.namespaces.size() != this.namespaces.size()) {
            return false;
        }
        for (int i = 0;i < value.namespaces.size();i++) {
            if (!(value.getNamespaces(i).equals(this.getNamespaces(i)))) {
                return false;
            }
        }
        if (value.optionalConditions.size() != this.optionalConditions.size()) {
            return false;
        }
        for (int i = 0;i < value.optionalConditions.size();i++) {
            if (!(value.getOptionalConditions(i).equals(this.getOptionalConditions(i)))) {
                return false;
            }
        }
        if (value.variables.size() != this.variables.size()) {
            return false;
        }
        for (int i = 0;i < value.variables.size();i++) {
            if (!(value.getVariables(i).equals(this.getVariables(i)))) {
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
        // Concatenar con el hashcode del atributo baseNamespace
        code = tdi.gen.TdiHashcode.concat(code,this.baseNamespace);
        // Concatenar con el hashcode del atributo distinct
        code = tdi.gen.TdiHashcode.concat(code,this.distinct);
        // Concatenar con el hashcode del atributo limit
        code = tdi.gen.TdiHashcode.concat(code,this.limit);
        // Concatenar con el hashcode del atributo offset
        code = tdi.gen.TdiHashcode.concat(code,this.offset);
        // Concatenar con el hashcode del atributo orderBy
        code = tdi.gen.TdiHashcode.concat(code,this.orderBy);
        // Concatenar con el hashcode del atributo conditions
        for (int i = 0;i < conditions.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getConditions(i));
        }
        // Concatenar con el hashcode del atributo namespaces
        for (int i = 0;i < namespaces.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getNamespaces(i));
        }
        // Concatenar con el hashcode del atributo optionalConditions
        for (int i = 0;i < optionalConditions.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getOptionalConditions(i));
        }
        // Concatenar con el hashcode del atributo variables
        for (int i = 0;i < variables.size();i++) {
            code = tdi.gen.TdiHashcode.concat(code,this.getVariables(i));
        }
        return code;
    }

    /**
     * Compara dos arrays de beans
     * @param    __array1    Array a comparar
     * @param    __array2    Array a comparar
     * @return   Retorna true si los dos arrays son iguales en longitud y en cada uno de sus elementos
     */
    public static boolean equals(ExecQuery_req[] __array1,ExecQuery_req[] __array2) {
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
     * Lectura del atributo baseNamespace
     * @return   Valor del atributo baseNamespace
     */
    public String getBaseNamespace() { return this.baseNamespace; }

    /**
     * Escritura del atributo baseNamespace
     * @param    valor    Nuevo valor del atributo baseNamespace
     */
    public void setBaseNamespace(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.baseNamespace = valor;
        setChanged();
    }

    /**
     * Lectura del atributo distinct
     * @return   Valor del atributo distinct
     */
    public int getDistinct() { return this.distinct; }

    /**
     * Escritura del atributo distinct
     * @param    valor    Nuevo valor del atributo distinct
     */
    public void setDistinct(int valor) { 
        this.distinct = valor;
        setChanged();
    }

    /**
     * Lectura del atributo limit
     * @return   Valor del atributo limit
     */
    public int getLimit() { return this.limit; }

    /**
     * Escritura del atributo limit
     * @param    valor    Nuevo valor del atributo limit
     */
    public void setLimit(int valor) { 
        this.limit = valor;
        setChanged();
    }

    /**
     * Lectura del atributo offset
     * @return   Valor del atributo offset
     */
    public int getOffset() { return this.offset; }

    /**
     * Escritura del atributo offset
     * @param    valor    Nuevo valor del atributo offset
     */
    public void setOffset(int valor) { 
        this.offset = valor;
        setChanged();
    }

    /**
     * Lectura del atributo orderBy
     * @return   Valor del atributo orderBy
     */
    public String getOrderBy() { return this.orderBy; }

    /**
     * Escritura del atributo orderBy
     * @param    valor    Nuevo valor del atributo orderBy
     */
    public void setOrderBy(String valor) { 
        if (valor == null) {
            valor = new String();
        }
        this.orderBy = valor;
        setChanged();
    }

    /**
     * Vacia los elementos del atributo conditions
     */
    public void clearConditions() { this.conditions.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo conditions
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeConditions(int position) {
        return this.conditions.remove(position);
    }

    /**
     * Número de elementos en el atributo conditions
     * @return   Número de elementos
     */
    public int conditions_size() { return this.conditions.size(); }

    /**
     * Elementos del atributo conditions
     * @return   Array de elementos
     */
    public String[] getConditions() {
        return (String[])this.conditions.toArray(new String[this.conditions.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo conditions
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public String getConditions(int position) {
        return (String)this.conditions.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo conditions
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setConditions(int position,String valor) {
        if (valor == null) {
            valor = new String();
        }
        this.conditions.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo conditions
     * @param    valores    Los nuevos elementos
     */
    public void setConditions(String[] valores) {
        this.conditions = new ObjectVector(valores);
        this.conditions.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo conditions
     * @param    valor    Nuevo elemento
     */
    public void addConditions(String valor) {
        if (valor == null) {
            valor = new String();
        }
        this.conditions.addElement(valor);
        setChanged();
    }

    /**
     * Vacia los elementos del atributo namespaces
     */
    public void clearNamespaces() { this.namespaces.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo namespaces
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeNamespaces(int position) {
        return this.namespaces.remove(position);
    }

    /**
     * Número de elementos en el atributo namespaces
     * @return   Número de elementos
     */
    public int namespaces_size() { return this.namespaces.size(); }

    /**
     * Elementos del atributo namespaces
     * @return   Array de elementos
     */
    public org.qualipso.advdoc.ws.client.search.beans.Namespace[] getNamespaces() {
        return (org.qualipso.advdoc.ws.client.search.beans.Namespace[])this.namespaces.toArray(new org.qualipso.advdoc.ws.client.search.beans.Namespace[this.namespaces.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo namespaces
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public org.qualipso.advdoc.ws.client.search.beans.Namespace getNamespaces(int position) {
        return (org.qualipso.advdoc.ws.client.search.beans.Namespace)this.namespaces.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo namespaces
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setNamespaces(int position,org.qualipso.advdoc.ws.client.search.beans.Namespace valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.search.beans.Namespace();
        }
        this.namespaces.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo namespaces
     * @param    valores    Los nuevos elementos
     */
    public void setNamespaces(org.qualipso.advdoc.ws.client.search.beans.Namespace[] valores) {
        this.namespaces = new ObjectVector(valores);
        this.namespaces.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo namespaces
     * @param    valor    Nuevo elemento
     */
    public void addNamespaces(org.qualipso.advdoc.ws.client.search.beans.Namespace valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.search.beans.Namespace();
        }
        this.namespaces.addElement(valor);
        setChanged();
    }

    /**
     * Vacia los elementos del atributo optionalConditions
     */
    public void clearOptionalConditions() { this.optionalConditions.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo optionalConditions
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeOptionalConditions(int position) {
        return this.optionalConditions.remove(position);
    }

    /**
     * Número de elementos en el atributo optionalConditions
     * @return   Número de elementos
     */
    public int optionalConditions_size() { return this.optionalConditions.size(); }

    /**
     * Elementos del atributo optionalConditions
     * @return   Array de elementos
     */
    public org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup[] getOptionalConditions() {
        return (org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup[])this.optionalConditions.toArray(new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup[this.optionalConditions.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo optionalConditions
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup getOptionalConditions(int position) {
        return (org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup)this.optionalConditions.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo optionalConditions
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setOptionalConditions(int position,org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup();
        }
        this.optionalConditions.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo optionalConditions
     * @param    valores    Los nuevos elementos
     */
    public void setOptionalConditions(org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup[] valores) {
        this.optionalConditions = new ObjectVector(valores);
        this.optionalConditions.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo optionalConditions
     * @param    valor    Nuevo elemento
     */
    public void addOptionalConditions(org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup valor) {
        if (valor == null) {
            valor = new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup();
        }
        this.optionalConditions.addElement(valor);
        setChanged();
    }

    /**
     * Vacia los elementos del atributo variables
     */
    public void clearVariables() { this.variables.clear(); setChanged(); }

    /**
     * Eliminar el elemento i-ésimo del atributo variables
     * @param    position    Posición del elemento que se quiere eliminar
     * @return   false si no se puede eliminar
     */
public     boolean removeVariables(int position) {
        return this.variables.remove(position);
    }

    /**
     * Número de elementos en el atributo variables
     * @return   Número de elementos
     */
    public int variables_size() { return this.variables.size(); }

    /**
     * Elementos del atributo variables
     * @return   Array de elementos
     */
    public String[] getVariables() {
        return (String[])this.variables.toArray(new String[this.variables.size()]);
    }

    /**
     * Obtener el elemento i-isimo del atributo variables
     * @param    position    Posicisn del elemento que se quiere obtener
     * @return   Elemento i-isimo
     */
    public String getVariables(int position) {
        return (String)this.variables.elementAt(position);
    }

    /**
     * Modificar el elemento i-isimo del atributo variables
     * @param    position    Posicisn del elemento que se quiere modificar
     * @param    valor    Nuevo elemento
     */
    public void setVariables(int position,String valor) {
        if (valor == null) {
            valor = new String();
        }
        this.variables.setElementAt(valor, position);
        setChanged();
    }

    /**
     * Modifica todos los elementos del atributo variables
     * @param    valores    Los nuevos elementos
     */
    public void setVariables(String[] valores) {
        this.variables = new ObjectVector(valores);
        this.variables.addObserver(this);
        setChanged();
    }

    /**
     * Aqade un nuevo elemento al atributo variables
     * @param    valor    Nuevo elemento
     */
    public void addVariables(String valor) {
        if (valor == null) {
            valor = new String();
        }
        this.variables.addElement(valor);
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
                "ExecQuery_req <BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string baseNamespace<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int distinct<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int limit<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int offset<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string orderBy<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string[] conditions<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string[] variables<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Namespace[] namespaces<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string namespace<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string prefix<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OptionalConditionGroup[] optionalConditions<BR>",
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;string[] optionalCondition<BR>",
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
        this.setBaseNamespace("string");
        this.setDistinct(0);
        this.setLimit(0);
        this.setOffset(0);
        this.setOrderBy("string");
        this.conditions.clear();
        this.addConditions("string_0");
        this.addConditions("string_1");
        this.namespaces.clear();
        org.qualipso.advdoc.ws.client.search.beans.Namespace v_1_1 = new org.qualipso.advdoc.ws.client.search.beans.Namespace();
        v_1_1.fillSampleData();
        this.addNamespaces(v_1_1);
        org.qualipso.advdoc.ws.client.search.beans.Namespace v_1_2 = new org.qualipso.advdoc.ws.client.search.beans.Namespace();
        v_1_2.fillSampleData();
        this.addNamespaces(v_1_2);
        this.optionalConditions.clear();
        org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup v_2_1 = new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup();
        v_2_1.fillSampleData();
        this.addOptionalConditions(v_2_1);
        org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup v_2_2 = new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup();
        v_2_2.fillSampleData();
        this.addOptionalConditions(v_2_2);
        this.variables.clear();
        this.addVariables("string_0");
        this.addVariables("string_1");
    }


    /********************************************************************/
    /*************** RUTINAS INTERNAS PARA SERIALIZACION ****************/
    /********************************************************************/


  /**
   * Serializa el bean a binario
   * @param    output    Stream donde se dejan los datos serializados
   */
  public void serialize(TdiOutputSerializer output) {
    output.append(this.baseNamespace);
    output.append(this.distinct);
    output.append(this.limit);
    output.append(this.offset);
    output.append(this.orderBy);
    output.append((int)this.conditions.size());
    for (int i=0; i<this.conditions.size(); i++) {
      output.append((String)this.conditions.elementAt(i));
    }
    output.append((int)this.namespaces.size());
    for (int i=0; i<this.namespaces.size(); i++) {
      output.append((org.qualipso.advdoc.ws.client.search.beans.Namespace)this.namespaces.elementAt(i));
    }
    output.append((int)this.optionalConditions.size());
    for (int i=0; i<this.optionalConditions.size(); i++) {
      output.append((org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup)this.optionalConditions.elementAt(i));
    }
    output.append((int)this.variables.size());
    for (int i=0; i<this.variables.size(); i++) {
      output.append((String)this.variables.elementAt(i));
    }
  }

  /**
   * Rellena el bean con datos serializados en binario
   * @param    input    Stream donde estan los datos serializados
   * @throws   Exception    Cuando los datos serializados no corresponden con los atributos del bean
   */
  public void deserialize(TdiInputSerializer input) throws Exception {
    this.baseNamespace = input.extract_String();
    this.distinct = input.extract_int();
    this.limit = input.extract_int();
    this.offset = input.extract_int();
    this.orderBy = input.extract_String();
    {
        int len = input.extract_int();
        this.conditions = new ObjectVector(len);
        this.conditions.addObserver(this);
        for (int i = 0; i < len; i++) {
          String aux = input.extract_String();
          this.conditions.addElement(aux);
        }
    }
    {
        int len = input.extract_int();
        this.namespaces = new ObjectVector(len);
        this.namespaces.addObserver(this);
        for (int i = 0; i < len; i++) {
          org.qualipso.advdoc.ws.client.search.beans.Namespace aux = new org.qualipso.advdoc.ws.client.search.beans.Namespace();
          input.extract_object(aux);
          this.namespaces.addElement(aux);
        }
    }
    {
        int len = input.extract_int();
        this.optionalConditions = new ObjectVector(len);
        this.optionalConditions.addObserver(this);
        for (int i = 0; i < len; i++) {
          org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup aux = new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup();
          input.extract_object(aux);
          this.optionalConditions.addElement(aux);
        }
    }
    {
        int len = input.extract_int();
        this.variables = new ObjectVector(len);
        this.variables.addObserver(this);
        for (int i = 0; i < len; i++) {
          String aux = input.extract_String();
          this.variables.addElement(aux);
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
        js.append(varName+".__constructor__ = 'ExecQuery_req';\n");
        js.append(varName+".__package__ = 'org.qualipso.advdoc.ws.client.search.beans';\n");
    }
    js.append(varName+".baseNamespace = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.baseNamespace)+"';\n");
    js.append(varName+".distinct = "+this.distinct+";\n");
    js.append(varName+".limit = "+this.limit+";\n");
    js.append(varName+".offset = "+this.offset+";\n");
    js.append(varName+".orderBy = '"+es.tid.serial.TdiSerialUtil.escapaJavascript(this.orderBy)+"';\n");
    js.append(varName+".conditions = new Array("+this.conditions.size()+");\n");
    for (int i = 0;i < this.conditions.size();i++) {
        js.append(varName+".conditions["+i+"] = '"+es.tid.serial.TdiSerialUtil.escapaJavascript((String)this.conditions.elementAt(i))+"';\n");
    }
    js.append(varName+".namespaces = new Array("+this.namespaces.size()+");\n");
    for (int i = 0;i < this.namespaces.size();i++) {
        TdiJavascriptable object = (TdiJavascriptable)this.namespaces.elementAt(i);
        js.append(object.toJS(false,true,varName+".namespaces["+i+"]",0));
    }
    js.append(varName+".optionalConditions = new Array("+this.optionalConditions.size()+");\n");
    for (int i = 0;i < this.optionalConditions.size();i++) {
        TdiJavascriptable object = (TdiJavascriptable)this.optionalConditions.elementAt(i);
        js.append(object.toJS(false,true,varName+".optionalConditions["+i+"]",0));
    }
    js.append(varName+".variables = new Array("+this.variables.size()+");\n");
    for (int i = 0;i < this.variables.size();i++) {
        js.append(varName+".variables["+i+"] = '"+es.tid.serial.TdiSerialUtil.escapaJavascript((String)this.variables.elementAt(i))+"';\n");
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
      xml.append(_indentar(indents)+"<"+tag+" type=\"ExecQuery_req\" package=\"org.qualipso.advdoc.ws.client.search.beans\">");
      xml.append("\n");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents));
      xml.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
      xml.append(_indentar(indents)+"<ExecQuery_req type=\"ExecQuery_req\" package=\"org.qualipso.advdoc.ws.client.search.beans\">");
      xml.append("\n");
    } else {
      indents--;
    }
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<baseNamespace type=\"string\">"+tdi.text.StringUtil.escapeXML(this.baseNamespace,false)+"</baseNamespace>");
    } else {
        xml.append(_indentar(indents+1)+"<baseNamespace type=\"string\">"+this.baseNamespace+"</baseNamespace>");
    }

    xml.append("\n");
    xml.append(_indentar(indents+1)+"<distinct type=\"int\">"+this.distinct+"</distinct>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<limit type=\"int\">"+this.limit+"</limit>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<offset type=\"int\">"+this.offset+"</offset>");
    xml.append("\n");
    if (escaparStrings) {
        xml.append(_indentar(indents+1)+"<orderBy type=\"string\">"+tdi.text.StringUtil.escapeXML(this.orderBy,false)+"</orderBy>");
    } else {
        xml.append(_indentar(indents+1)+"<orderBy type=\"string\">"+this.orderBy+"</orderBy>");
    }

    xml.append("\n");
    xml.append(_indentar(indents+1)+"<conditions type=\"string[]\" size=\""+this.conditions.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.conditions.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(_indentar(indents+2)+"<conditions"+"_"+sufijo+" type=\"string\">"+conditions.elementAt(i)+"</conditions"+"_"+sufijo+">");
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</conditions>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<namespaces type=\"org.qualipso.advdoc.ws.client.search.beans.Namespace[]\" size=\""+this.namespaces.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.namespaces.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(((org.qualipso.advdoc.ws.client.search.beans.Namespace)namespaces.elementAt(i)).toXML("namespaces"+"_"+sufijo, indents+2,ponerIndicesDeArrays,escaparStrings));
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</namespaces>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<optionalConditions type=\"org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup[]\" size=\""+this.optionalConditions.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.optionalConditions.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(((org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup)optionalConditions.elementAt(i)).toXML("optionalConditions"+"_"+sufijo, indents+2,ponerIndicesDeArrays,escaparStrings));
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</optionalConditions>");
    xml.append("\n");
    xml.append(_indentar(indents+1)+"<variables type=\"string[]\" size=\""+this.variables.size()+"\">");
    xml.append("\n");
    for (int i=0; i<this.variables.size(); i++) {
        String sufijo = (ponerIndicesDeArrays ? ""+i : "elemento");
      xml.append(_indentar(indents+2)+"<variables"+"_"+sufijo+" type=\"string\">"+variables.elementAt(i)+"</variables"+"_"+sufijo+">");
      xml.append("\n");
    }
    xml.append(_indentar(indents+1));
    xml.append("</variables>");
    xml.append("\n");
    if (tag != null && tag.length() > 0) {
      xml.append(_indentar(indents)+"</"+tag+">");
    } else if (tag != null && tag.length() == 0) {
      xml.append(_indentar(indents)+"</ExecQuery_req>");
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
    __struct__.put("baseNamespace", tdi.text.StringUtil.sustituyeUnicode(this.baseNamespace));
    __struct__.put("distinct", new Integer(distinct));
    __struct__.put("limit", new Integer(limit));
    __struct__.put("offset", new Integer(offset));
    __struct__.put("orderBy", tdi.text.StringUtil.sustituyeUnicode(this.orderBy));
    java.util.Vector __vector_conditions = new java.util.Vector();
    for (int __i__ = 0;__i__ < conditions.size();__i__++) {
        __vector_conditions.addElement(tdi.text.StringUtil.sustituyeUnicode((String)this.conditions.elementAt(__i__)));
    }
    __struct__.put("conditions",__vector_conditions);
    java.util.Vector __vector_namespaces = new java.util.Vector();
    for (int __i__ = 0;__i__ < namespaces.size();__i__++) {
        org.qualipso.advdoc.ws.client.search.beans.Namespace __object__ = (org.qualipso.advdoc.ws.client.search.beans.Namespace)namespaces.elementAt(__i__);
        __vector_namespaces.addElement(__object__.toRPC());
    }
    __struct__.put("namespaces",__vector_namespaces);
    java.util.Vector __vector_optionalConditions = new java.util.Vector();
    for (int __i__ = 0;__i__ < optionalConditions.size();__i__++) {
        org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup __object__ = (org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup)optionalConditions.elementAt(__i__);
        __vector_optionalConditions.addElement(__object__.toRPC());
    }
    __struct__.put("optionalConditions",__vector_optionalConditions);
    java.util.Vector __vector_variables = new java.util.Vector();
    for (int __i__ = 0;__i__ < variables.size();__i__++) {
        __vector_variables.addElement(tdi.text.StringUtil.sustituyeUnicode((String)this.variables.elementAt(__i__)));
    }
    __struct__.put("variables",__vector_variables);
    return __struct__;
  }

  /**
   * Rellena el bean con los datos de una tabla hash en la forma clave/valor
   * @param    __params__    Tabla hash que contiene los objetos a partir de los cuales se va a rellenar el bean
   * @throws   Exception    Cuando la tabla hash no contiene los valores adecuados para rellenar el bean
   */
  public void fromRPC(java.util.Hashtable __params__) throws Exception {
    Object __object_baseNamespace = __params__.get("baseNamespace");
    if (__object_baseNamespace == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo baseNamespace");
    }
    if (!(__object_baseNamespace instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo baseNamespace no es de tipo String");
    }
    setBaseNamespace((String)__object_baseNamespace);
    Object __object_distinct = __params__.get("distinct");
    if (__object_distinct == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo distinct");
    }
    if (!(__object_distinct instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo distinct no es de tipo Integer");
    }
    Integer __int_distinct = (Integer)__object_distinct;
    setDistinct(__int_distinct.intValue());
    Object __object_limit = __params__.get("limit");
    if (__object_limit == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo limit");
    }
    if (!(__object_limit instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo limit no es de tipo Integer");
    }
    Integer __int_limit = (Integer)__object_limit;
    setLimit(__int_limit.intValue());
    Object __object_offset = __params__.get("offset");
    if (__object_offset == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo offset");
    }
    if (!(__object_offset instanceof Integer)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo offset no es de tipo Integer");
    }
    Integer __int_offset = (Integer)__object_offset;
    setOffset(__int_offset.intValue());
    Object __object_orderBy = __params__.get("orderBy");
    if (__object_orderBy == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo orderBy");
    }
    if (!(__object_orderBy instanceof String)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo orderBy no es de tipo String");
    }
    setOrderBy((String)__object_orderBy);
    Object __object_conditions = __params__.get("conditions");
    if (__object_conditions == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector conditions");
    }
    if (!(__object_conditions instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo conditions no es de tipo Vector");
    }
    java.util.Vector __vector_conditions = (java.util.Vector)__object_conditions;
    for (int i = 0;i < __vector_conditions.size();i++) {
        Object __element__ = __vector_conditions.elementAt(i);
        if (!(__element__ instanceof String)) {
            throw new Exception(getClass().getName()+".fromRPC() El elemento "+i+" del array conditions no es de tipo String");
        }
        addConditions((String)__element__);
    }
    Object __object_namespaces = __params__.get("namespaces");
    if (__object_namespaces == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector namespaces");
    }
    if (!(__object_namespaces instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo namespaces no es de tipo Vector");
    }
    java.util.Vector __vector_namespaces = (java.util.Vector)__object_namespaces;
    for (int i = 0;i < __vector_namespaces.size();i++) {
        Object __element__ = __vector_namespaces.elementAt(i);
        if (!(__element__ instanceof java.util.Hashtable)) {
            throw new Exception(getClass().getName()+".fromRPC() El atributo namespaces no es de tipo Hashtable");
        }
        java.util.Hashtable __hashtable__ = (java.util.Hashtable)__element__;
        org.qualipso.advdoc.ws.client.search.beans.Namespace __value__;
        String __constructor__ = (String)__hashtable__.get("__constructor__");
        // Si existe el atributo __constructor__ crear el objeto de la clase indicada
        if (__constructor__ == null || __constructor__.equals("")) {
            __value__ = new org.qualipso.advdoc.ws.client.search.beans.Namespace();
        } else {
            __value__ = (org.qualipso.advdoc.ws.client.search.beans.Namespace)Class.forName(__constructor__).newInstance();
        }
        __value__.fromRPC(__hashtable__);
        addNamespaces(__value__);
    }
    Object __object_optionalConditions = __params__.get("optionalConditions");
    if (__object_optionalConditions == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector optionalConditions");
    }
    if (!(__object_optionalConditions instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo optionalConditions no es de tipo Vector");
    }
    java.util.Vector __vector_optionalConditions = (java.util.Vector)__object_optionalConditions;
    for (int i = 0;i < __vector_optionalConditions.size();i++) {
        Object __element__ = __vector_optionalConditions.elementAt(i);
        if (!(__element__ instanceof java.util.Hashtable)) {
            throw new Exception(getClass().getName()+".fromRPC() El atributo optionalConditions no es de tipo Hashtable");
        }
        java.util.Hashtable __hashtable__ = (java.util.Hashtable)__element__;
        org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup __value__;
        String __constructor__ = (String)__hashtable__.get("__constructor__");
        // Si existe el atributo __constructor__ crear el objeto de la clase indicada
        if (__constructor__ == null || __constructor__.equals("")) {
            __value__ = new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup();
        } else {
            __value__ = (org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup)Class.forName(__constructor__).newInstance();
        }
        __value__.fromRPC(__hashtable__);
        addOptionalConditions(__value__);
    }
    Object __object_variables = __params__.get("variables");
    if (__object_variables == null) {
        throw new Exception(getClass().getName()+".fromRPC() No se encuentra el atributo vector variables");
    }
    if (!(__object_variables instanceof java.util.Vector)) {
        throw new Exception(getClass().getName()+".fromRPC() El atributo variables no es de tipo Vector");
    }
    java.util.Vector __vector_variables = (java.util.Vector)__object_variables;
    for (int i = 0;i < __vector_variables.size();i++) {
        Object __element__ = __vector_variables.elementAt(i);
        if (!(__element__ instanceof String)) {
            throw new Exception(getClass().getName()+".fromRPC() El elemento "+i+" del array variables no es de tipo String");
        }
        addVariables((String)__element__);
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
      org.w3c.dom.Element __e = getNodeByName(__node,"baseNamespace");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setBaseNamespace(__v);
    }
    {
      String __v = "0";
      org.w3c.dom.Element __e = getNodeByName(__node,"distinct");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setDistinct(Integer.parseInt(__v));
    }
    {
      String __v = "0";
      org.w3c.dom.Element __e = getNodeByName(__node,"limit");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setLimit(Integer.parseInt(__v));
    }
    {
      String __v = "0";
      org.w3c.dom.Element __e = getNodeByName(__node,"offset");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setOffset(Integer.parseInt(__v));
    }
    {
      String __v = "";
      org.w3c.dom.Element __e = getNodeByName(__node,"orderBy");
      if (__e != null && __e.getChildNodes().item(0) != null) {
        __v = __e.getChildNodes().item(0).getNodeValue();
      }
      setOrderBy(__v);
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"conditions");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        String __v = getNodeByName(__element,"conditions_"+i).getChildNodes().item(0).getNodeValue();
        addConditions(__v);
      }
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"namespaces");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        org.w3c.dom.Element __element2 = getNodeByName(__element,"namespaces_"+i);
        org.qualipso.advdoc.ws.client.search.beans.Namespace __entry;
        if (__element2.getAttribute("package") != null && __element2.getAttribute("package").length() != 0) {
          __entry = (org.qualipso.advdoc.ws.client.search.beans.Namespace) Class.forName(__element2.getAttribute("package")+"."+__element2.getAttribute("type")).newInstance();
        } else {
          __entry = new org.qualipso.advdoc.ws.client.search.beans.Namespace();
        }
        __entry.fromXML(__element2);
        addNamespaces(__entry);
      }
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"optionalConditions");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        org.w3c.dom.Element __element2 = getNodeByName(__element,"optionalConditions_"+i);
        org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup __entry;
        if (__element2.getAttribute("package") != null && __element2.getAttribute("package").length() != 0) {
          __entry = (org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup) Class.forName(__element2.getAttribute("package")+"."+__element2.getAttribute("type")).newInstance();
        } else {
          __entry = new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup();
        }
        __entry.fromXML(__element2);
        addOptionalConditions(__entry);
      }
    }
    {
      // Buscar el tamaqo del array
      org.w3c.dom.Element __element = getNodeByName(__node,"variables");
      int __size = 0;
      if (__element != null) {
        __size = Integer.parseInt(__element.getAttribute("size"));
      }
      // Rellenar los valores del array
      for (int i = 0;i < __size;i++) {
        String __v = getNodeByName(__element,"variables_"+i).getChildNodes().item(0).getNodeValue();
        addVariables(__v);
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
        writer.write("<baseNamespace>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getBaseNamespace(), false));
        writer.write("</baseNamespace>");
        writer.write("\n");
        writer.write("<distinct>");
        writer.write(Integer.toString(this.getDistinct()));
        writer.write("</distinct>");
        writer.write("\n");
        writer.write("<limit>");
        writer.write(Integer.toString(this.getLimit()));
        writer.write("</limit>");
        writer.write("\n");
        writer.write("<offset>");
        writer.write(Integer.toString(this.getOffset()));
        writer.write("</offset>");
        writer.write("\n");
        writer.write("<orderBy>");
        writer.write(tdi.text.StringUtil.escapeXML(this.getOrderBy(), false));
        writer.write("</orderBy>");
        writer.write("\n");
        writer.write("<conditions>");
        writer.write("\n");
        for (int i = 0; i < conditions_size(); i++) {
            writer.write("<string>");
        writer.write(this.getConditions(i));
            writer.write("</string>");
            writer.write("\n");
        }
        writer.write("</conditions>");
        writer.write("\n");
        writer.write("<namespaces>");
        writer.write("\n");
        for (int i = 0; i < namespaces_size(); i++) {
            writer.write("<Namespace>");
            writer.write("\n");
            this.getNamespaces(i).toSOAP(writer);
            writer.write("</Namespace>");
            writer.write("\n");
        }
        writer.write("</namespaces>");
        writer.write("\n");
        writer.write("<optionalConditions>");
        writer.write("\n");
        for (int i = 0; i < optionalConditions_size(); i++) {
            writer.write("<OptionalConditionGroup>");
            writer.write("\n");
            this.getOptionalConditions(i).toSOAP(writer);
            writer.write("</OptionalConditionGroup>");
            writer.write("\n");
        }
        writer.write("</optionalConditions>");
        writer.write("\n");
        writer.write("<variables>");
        writer.write("\n");
        for (int i = 0; i < variables_size(); i++) {
            writer.write("<string>");
        writer.write(this.getVariables(i));
            writer.write("</string>");
            writer.write("\n");
        }
        writer.write("</variables>");
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

        node = beanNode.getFirstChildByName("baseNamespace");
        if (node != null && node.getContents() != null) {
            this.setBaseNamespace(node.getContents());
        }

        node = beanNode.getFirstChildByName("distinct");
        if (node != null && node.getContents() != null) {
            this.setDistinct(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("limit");
        if (node != null && node.getContents() != null) {
            this.setLimit(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("offset");
        if (node != null && node.getContents() != null) {
            this.setOffset(Integer.parseInt(node.getContents()));
        }

        node = beanNode.getFirstChildByName("orderBy");
        if (node != null && node.getContents() != null) {
            this.setOrderBy(node.getContents());
        }

        tdi.xml.parser.TdiXmlNode[] arrayNodes;
        node = beanNode.getFirstChildByName("conditions");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("string");
            if (arrayNodes != null) {
                this.clearConditions();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        this.addConditions(arrayNodes[i].getContents());
                    }  // arrayNodes[i] != null
                }  // for
            }  // arrayNodes != null
        }  // node != null
        node = beanNode.getFirstChildByName("namespaces");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("Namespace");
            if (arrayNodes != null) {
                this.clearNamespaces();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        org.qualipso.advdoc.ws.client.search.beans.Namespace tmp = new org.qualipso.advdoc.ws.client.search.beans.Namespace();
                        tmp.fromSOAP(arrayNodes[i]);
                        this.addNamespaces(tmp);
                    }  // arrayNodes[i] != null
                }  // for
            }  // arrayNodes != null
        }  // node != null
        node = beanNode.getFirstChildByName("optionalConditions");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("OptionalConditionGroup");
            if (arrayNodes != null) {
                this.clearOptionalConditions();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup tmp = new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup();
                        tmp.fromSOAP(arrayNodes[i]);
                        this.addOptionalConditions(tmp);
                    }  // arrayNodes[i] != null
                }  // for
            }  // arrayNodes != null
        }  // node != null
        node = beanNode.getFirstChildByName("variables");
        if (node != null && node.getContents() != null) {

            arrayNodes = node.getChildsByName("string");
            if (arrayNodes != null) {
                this.clearVariables();
                for (int i = 0;i < arrayNodes.length;i++) {
                    if (arrayNodes[i] != null && arrayNodes[i].getContents() != null) {
                        this.addVariables(arrayNodes[i].getContents());
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
        json.put("baseNamespace",this.getBaseNamespace());
        json.put("distinct",this.getDistinct());
        json.put("limit",this.getLimit());
        json.put("offset",this.getOffset());
        json.put("orderBy",this.getOrderBy());
        JSONArray jArray;
        JSONArray jObjectArray;
        jArray = new JSONArray();
        for (int i = 0;i < conditions_size();i++) {
            jArray.put(getConditions(i));
        }
        json.put("conditions",jArray);
        jObjectArray = new JSONArray();
        for (int i = 0;i < namespaces_size();i++) {
            JSONObject jObj_i = new JSONObject();
            this.getNamespaces(i).toJSON(jObj_i);
            jObjectArray.put(jObj_i);
        }
        json.put("namespaces",jObjectArray);
        jObjectArray = new JSONArray();
        for (int i = 0;i < optionalConditions_size();i++) {
            JSONObject jObj_i = new JSONObject();
            this.getOptionalConditions(i).toJSON(jObj_i);
            jObjectArray.put(jObj_i);
        }
        json.put("optionalConditions",jObjectArray);
        jArray = new JSONArray();
        for (int i = 0;i < variables_size();i++) {
            jArray.put(getVariables(i));
        }
        json.put("variables",jArray);
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
        this.setBaseNamespace(json.getString("baseNamespace"));
        this.setDistinct(json.getInt("distinct"));
        this.setLimit(json.getInt("limit"));
        this.setOffset(json.getInt("offset"));
        this.setOrderBy(json.getString("orderBy"));
        JSONArray jArray;
        JSONArray jObjectArray;
        jArray = json.getJSONArray("conditions");
        this.clearConditions();
        for (int i = 0;i < jArray.length();i++) {
            this.addConditions(jArray.getString(i));
        }
        jObjectArray = json.getJSONArray("namespaces");
        this.clearNamespaces();
        for (int i = 0;i < jObjectArray.length();i++) {
            JSONObject jObj_i = jObjectArray.getJSONObject(i);
            org.qualipso.advdoc.ws.client.search.beans.Namespace tmp = new org.qualipso.advdoc.ws.client.search.beans.Namespace();
            tmp.fromJSON(jObj_i);
            this.addNamespaces(tmp);
        }
        jObjectArray = json.getJSONArray("optionalConditions");
        this.clearOptionalConditions();
        for (int i = 0;i < jObjectArray.length();i++) {
            JSONObject jObj_i = jObjectArray.getJSONObject(i);
            org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup tmp = new org.qualipso.advdoc.ws.client.search.beans.OptionalConditionGroup();
            tmp.fromJSON(jObj_i);
            this.addOptionalConditions(tmp);
        }
        jArray = json.getJSONArray("variables");
        this.clearVariables();
        for (int i = 0;i < jArray.length();i++) {
            this.addVariables(jArray.getString(i));
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
        return new ExecQuery_req(this);
    }
    /**
     * Rellena este objeto con los datos de otro de la misma clase (implementacisn de la interfaz TdiCloneable)
     * @param    source    Objecto origen a copiar
     */
    public void copyFrom(Object source) throws ClassCastException {
        if (!(source instanceof ExecQuery_req)) {
            throw new ClassCastException(getClass().getName()+".copyFrom() El objeto de copia es de la clase "+source.getClass().getName());
        }
        ExecQuery_req bean = (ExecQuery_req)source;
        this.set(bean);
    }

}
