package com.mia.itmf.formation.gestioncommerciale.gestionException;

@SuppressWarnings("serial")
public class ExceptionClient extends Exception{

	public ExceptionClient() {
		super();
	}
	
	public ExceptionClient(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExceptionClient(String message) {
		super(message);
	}
	
	public ExceptionClient(Throwable cause) {
		super(cause);
	}

}
