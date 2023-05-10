package com.mia.itmf.formation.gestioncommerciale.gestion;

import com.mia.itmf.formation.gestioncommerciale.Facture;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionDocument;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionFacture;

public class GestionFacture extends GestionDocument{
	//private Map<String, Facture> map = new HashMap<String, Facture>();
	
	
	public boolean verifierFacture(Facture facture) throws ExceptionFacture {
		try {
			return  super.verifierDocument(facture);
		} catch (ExceptionDocument e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Facture ajouterFacture(Facture facture) throws ExceptionFacture {
		
		try {
			return (Facture) ajouterDocument(facture);
		} catch (ExceptionDocument e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facture;
	}
	
	public void supprimerFacture(Facture facture) throws ExceptionDocument {
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
