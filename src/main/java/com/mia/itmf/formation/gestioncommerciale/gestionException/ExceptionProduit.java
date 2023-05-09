package com.mia.itmf.formation.gestioncommerciale.gestionException;

@SuppressWarnings("serial")
public class ExceptionProduit extends Exception{

	public ExceptionProduit() {
		super();
	}
	
	public ExceptionProduit(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExceptionProduit(String message) {
		super(message);
	}
	
	public ExceptionProduit(Throwable cause) {
		super(cause);
	}

}
