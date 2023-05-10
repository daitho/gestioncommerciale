package com.mia.itmf.formation.gestioncommerciale;

import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionDocument;

public class Commande extends Document {
	private static int COUNT=1;
	
	public Commande() {
		super();
		setCode(COUNT++);
	}

	public Commande(Client client) {
		super(client);
		setCode(COUNT++);
	}
	
	public String getKey() throws ExceptionDocument {
		//throw new Exception("La methode getKey doit être surcharger");
		return "Commande-"+getCode();
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
