package com.mia.itmf.formation.gestioncommerciale.gestionException;

@SuppressWarnings("serial")
public class ExceptionCommande extends Exception{
	
	public ExceptionCommande() {
		super();
	}
	
	public ExceptionCommande(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExceptionCommande(String message) {
		super(message);
	}
	
	public ExceptionCommande(Throwable cause) {
		super(cause);
	}

}
