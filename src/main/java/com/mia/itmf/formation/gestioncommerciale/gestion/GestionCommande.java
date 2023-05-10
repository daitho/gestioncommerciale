package com.mia.itmf.formation.gestioncommerciale.gestion;

import com.mia.itmf.formation.gestioncommerciale.Commande;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionDocument;

public class GestionCommande extends GestionDocument{
	//private Map<Integer, Commande> map = new HashMap<Integer, Commande>();
	
	public boolean verifierCommande(Commande commande) {
		try {
			return  super.verifierDocument(commande);
		} catch (ExceptionDocument e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Commande ajouterCommande(Commande commande) {
		
		try {
			return (Commande) ajouterDocument(commande);
		} catch (ExceptionDocument e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commande;
	}
	
	public void supprimerCommande(Commande commande) throws Exception {
		if(super.supprimerDocument(commande)) {
			System.out.println("Commande supprimée !");
		}else {
			System.err.println("Erreur de suppréssion: Commande non supprimée !");
		}
	}
	
	public Commande retrouverCommande(String key) {
		return  (Commande) retrouverDocument(getKey(key));
	}
	
	
	public String getKey(String key) {
		return "Facture-"+key;
	}


}
