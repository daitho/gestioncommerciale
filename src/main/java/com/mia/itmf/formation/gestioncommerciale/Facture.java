package com.mia.itmf.formation.gestioncommerciale;

import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionFacture;

public class Facture extends Document {
	private static int COUNT=1;

	public Facture() {
		super();
		setCode(COUNT++);

	}

	public Facture(Client client) {
		super(client);
		setCode(COUNT++);
	}
	
	public String getKey() throws ExceptionFacture {
		//throw new Exception("La methode getKey doit être surcharger");
		return "Facture-"+getCode();
	}
	
	
}
