package com.mia.itmf.formation.gestioncommerciale;

import java.util.List;

public class Devis extends Document {

	public Devis() {
		super();
	}

	public Devis(int code, String date, double montant, Client client, List<DetailDocument> liste) {
		super(code, date, montant, client);
	}

//	@Override
//	public String toString() {
//		return "Devis\n\"Nom et prénom:  " + this.getClient().getNom() +" "+this.getClient().getPrenom() +" calculMontant()=" + this.calculMontant();
//	}

	public String getKey() throws Exception {
		//throw new Exception("La methode getKey doit être surcharger");
		return "Devis-"+getCode();
	}
	
	
	
	

}
