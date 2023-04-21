package com.mia.itmf.formation.gestioncommerciale;

public class Commande extends Document {
	
	
	

	public Commande() {
		super();
	}

	public Commande(int code, String date, double montant, Client client) {
		super(code, date, montant, client);
	}
	
	public String getKey() throws Exception {
		//throw new Exception("La methode getKey doit être surcharger");
		return "Commande-"+getCode();
	}
	
	

}
