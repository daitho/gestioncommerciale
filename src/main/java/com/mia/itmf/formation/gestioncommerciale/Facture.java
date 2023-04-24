package com.mia.itmf.formation.gestioncommerciale;

public class Facture extends Document {

	public Facture() {
		super();

	}

	public Facture(int code, String date, double montant, Client client) {
		super(code, date, montant, client);
	}
	
	public String getKey() throws Exception {
		//throw new Exception("La methode getKey doit être surcharger");
		return "Facture-"+getCode();
	}
	
	
}
