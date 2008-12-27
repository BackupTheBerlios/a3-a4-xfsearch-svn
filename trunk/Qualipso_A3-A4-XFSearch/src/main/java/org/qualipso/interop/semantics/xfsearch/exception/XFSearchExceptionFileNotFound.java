package org.qualipso.interop.semantics.xfsearch.exception;

/**
 * 
 * @author Jesus Martin
 *
 */
public class XFSearchExceptionFileNotFound extends XFSearchException {

	private String fileName;
	
	public XFSearchExceptionFileNotFound(String fileName){
		super("The file '"+ fileName +"' can not be found");
		this.fileName = fileName;
	}
	
	public String getFileName(){
		return this.fileName;
	}	
	
	
}
