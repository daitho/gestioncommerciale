package com.mia.itmf.formation.gestioncommerciale.gestion;

import com.mia.itmf.formation.gestioncommerciale.Client;
import com.mia.itmf.formation.gestioncommerciale.Devis;

public class GestionDevis extends GestionDocument{
	
	public boolean verifierDevis(Devis devis) {
		return  super.verifierDocument(devis);
	}
	
	public Devis ajouterDevis(int code, Client client) {
		Devis devis = new Devis();
		devis.setCode(code);
		devis.setClient(client);
		
		return (Devis) ajouterDocument(devis);
	}
	
	public void supprimerDevis(Devis devis) throws Exception {
		if(super.supprimerDocument(devis)) {
			System.out.println("Devis supprimé !");
		}else {
			System.err.println("Erreur de suppréssion: Devis non supprimé !");
		}
	}
	
	public Devis retrouverDevis(String key) {
		return  (Devis) super.retrouverDocument(getKey(key));
	}
	
	
	public String getKey(String key) {
		return "Devis-"+key;
	}

}
