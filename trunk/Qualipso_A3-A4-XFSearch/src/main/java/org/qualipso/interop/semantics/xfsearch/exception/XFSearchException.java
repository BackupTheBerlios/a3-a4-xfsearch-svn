package org.qualipso.interop.semantics.xfsearch.exception;


/**
 * 
 * @author Jesus Martin
 *
 */
public class XFSearchException extends Exception {

	/**
	 * 
	 */
	protected String message;
	
	/**
	 * 
	 * @param message
	 */
	public XFSearchException(String message){
		this.message = message;
	}
	
	/**
	 * 
	 */
	public String getMessage(){
		return this.message;
	}
	
}
