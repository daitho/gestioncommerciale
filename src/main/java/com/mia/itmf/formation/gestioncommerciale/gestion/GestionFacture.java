package com.mia.itmf.formation.gestioncommerciale.gestion;

import com.mia.itmf.formation.gestioncommerciale.Client;
import com.mia.itmf.formation.gestioncommerciale.Facture;

public class GestionFacture extends GestionDocument{
	//private Map<String, Facture> map = new HashMap<String, Facture>();
	
	
	public boolean verifierFacture(Facture facture) {
		return  super.verifierDocument(facture);
	}
	
	public Facture ajouterFacture(int code, Client client) {
		Facture facture = new Facture();
		facture.setCode(code);
		facture.setClient(client);
		
		return (Facture) ajouterDocument(facture);
	}
	
	public void supprimerFacture(Facture facture) throws Exception {
		if(super.supprimerDocument(facture)) {
			System.out.println("Facture supprimée !");
		}else {
			System.err.println("Erreur de suppréssion: Facture non supprimée !");
		}
	}
	
	public Facture retrouverFacture(int key) {
		return  (Facture) retrouverDocument(getKey(key));
	}
	
	
	public String getKey(int key) {
		return "Facture-"+key;
	}

}
