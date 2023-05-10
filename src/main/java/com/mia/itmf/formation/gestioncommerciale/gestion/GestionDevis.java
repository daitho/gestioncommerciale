package com.mia.itmf.formation.gestioncommerciale.gestion;

import com.mia.itmf.formation.gestioncommerciale.Devis;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionDocument;

public class GestionDevis extends GestionDocument{
	
	public boolean verifierDevis(Devis devis) {
		try {
			return  super.verifierDocument(devis);
		} catch (ExceptionDocument e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Devis ajouterDevis(Devis devis) {
		
		try {
			return (Devis) ajouterDocument(devis);
		} catch (ExceptionDocument e) {
			e.printStackTrace();
		}
		return null;
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
