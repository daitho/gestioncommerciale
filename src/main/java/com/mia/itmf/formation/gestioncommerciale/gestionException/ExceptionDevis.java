package com.mia.itmf.formation.gestioncommerciale.gestionException;

@SuppressWarnings("serial")
public class ExceptionDevis extends Exception{
	public ExceptionDevis() {
		super();
	}
	
	public ExceptionDevis(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExceptionDevis(String message) {
		super(message);
	}
	
	public ExceptionDevis(Throwable cause) {
		super(cause);
	}

}
