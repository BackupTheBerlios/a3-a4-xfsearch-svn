package org.qualipso.interop.semantics.xfsearch.exception;


/**
 * 
 * @author Jesus Martin
 *
 */
public class XFSearchExceptionCompulsoryParameter extends XFSearchException {
	
	/**
	 * 
	 */
	private String parameter;
	
	/**
	 * 
	 * @param parameter
	 */
	public XFSearchExceptionCompulsoryParameter(String parameter){
		super("The parameter '"+ parameter +"' can not be NULL");
		this.parameter = parameter;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getParameter(){
		return this.parameter;
	}

}
