package com.mia.itmf.formation.gestioncommerciale;

import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionDocument;

public class Devis extends Document {
	private static int COUNT=1;

	public Devis() {
		super();
		setCode(COUNT++);
	}

	public Devis(Client client) {
		super(client);
		setCode(COUNT++);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String getKey() throws ExceptionDocument{
		//throw new Exception("La methode getKey doit être surcharger");
		return "Devis-"+getCode();
	}
	
	
	
	

}
