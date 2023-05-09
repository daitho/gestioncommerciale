package com.mia.itmf.formation.gestioncommerciale.gestionException;

@SuppressWarnings("serial")
public class ExceptionFacture extends Exception{
	
	public ExceptionFacture() {
		super();
	}
	
	public ExceptionFacture(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExceptionFacture(String message) {
		super(message);
	}
	
	public ExceptionFacture(Throwable cause) {
		super(cause);
	}


}
