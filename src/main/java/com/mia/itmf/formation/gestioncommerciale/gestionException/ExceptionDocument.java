package com.mia.itmf.formation.gestioncommerciale.gestionException;

@SuppressWarnings("serial")
public class ExceptionDocument extends Exception{
	
	public ExceptionDocument() {
		super();
	}
	
	public ExceptionDocument(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExceptionDocument(String message) {
		super(message);
	}
	
	public ExceptionDocument(Throwable cause) {
		super(cause);
	}

}
