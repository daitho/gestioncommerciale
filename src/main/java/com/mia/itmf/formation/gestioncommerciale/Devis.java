package com.mia.itmf.formation.gestioncommerciale;

import java.util.List;

public class Devis extends Document {

	public Devis() {
		super();
	}

	public Devis(int code, String date, double montant, Client client, List<DetailDocument> liste) {
		super(code, date, montant, client);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String getKey() throws Exception {
		//throw new Exception("La methode getKey doit être surcharger");
		return "Devis-"+getCode();
	}
	
	
	
	

}
