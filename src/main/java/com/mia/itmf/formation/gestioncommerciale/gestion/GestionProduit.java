package com.mia.itmf.formation.gestioncommerciale.gestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mia.itmf.formation.gestioncommerciale.Produit;

public class GestionProduit {
	private Map<Integer, Produit> map;
	
	//Initialisation du produit
		public void initialisationProduit() {
			map = new HashMap<Integer, Produit>();
			
			ajoutProduit(new Produit(1,"Pomme",100));
			ajoutProduit(new Produit(2,"Tomate",50));
			ajoutProduit(new Produit(3,"Haricot",60));
			ajoutProduit(new Produit(4,"Mangue",40));
			ajoutProduit(new Produit(5,"Banane",30));
			ajoutProduit(new Produit(6,"Orange",15));
			
			System.out.println("Produit initialisé !" );
			
			
		}
		
		//Ajout d'un produit
		public void ajoutProduit(Produit produit) {
			
			if(!verifierProduit(produit)) {
				
				map.put(produit.getCodeProduit(), produit);
				System.out.println("Produit ajouté !" );
				
			}else {
				System.err.println("Une erreur s'est produit lors de l'ajout du produit !" );
			}
		}
		
		//Pour verifier si le produit existe
		private boolean verifierProduit(Produit produit) {
			return produit != null && map.containsKey(produit.getCodeProduit());
		}
		
		//Retrouver un produit
	    public Produit retrouverProduit(Integer key) {
			return map.get(key);
		}
	    
	  //Retrouver un produit par libelle
	    public List<Produit> rechercherProduitParNom(String nom){
	    	List<Produit> produits = new ArrayList<Produit>();
	    	for(Produit produit : map.values()) {
	    		if(produit.getLibelle().contains(nom)) {
	    			produits.add(produit);
	    		}
	    	}
	    	return produits;
	    }
	    
	    public List<Produit> rechercherProduitParPrix(double prix){
	    	List<Produit> produits = new ArrayList<Produit>();
	    	for(Produit produit : map.values()) {
	    		if(produit.getPrix() == prix) {
	    			produits.add(produit);
	    		}
	    	}
	    	return produits;
	    }
		
		//Mise à jour du produit
		public void miseAJourProduit(Produit produit) {
			if(verifierProduit(produit)) {
				map.replace(produit.getCodeProduit(), produit);
				System.out.println("Produit mise à jour !" );
			}
		}
		
		//Suppresion d'un produit
	    public void supprimerProduit(Produit produit) {
	    	if(verifierProduit(produit)) {
	    		map.remove(produit.getCodeProduit());
				System.out.println("Produit supprimé !" );
			}
			
		}
	    
	  //afficher produit
	    public void afficherProduit(Produit produit) {
	    	if(verifierProduit(produit)) {
	    		System.out.println("Code: "+produit.getCodeProduit()+", Libelle: "+produit.getLibelle()+", Prix: "+produit.getPrix());
	    	}else {
	    		System.err.println("Produit introuvable !");
	    	}
	    	
		}
	    
	  //afficher Produit
	    public void afficherProduit(Integer key) {
	    	afficherProduit(retrouverProduit(key));
		}
	    
	  //afficher La liste de Produit
	    public void afficherProduit(List<Produit> produits) {
	    	for(Produit produit : produits) {
	    		afficherProduit(produit);
	    	}
		}
	    
	    //Afficher la taille de la map
	    public int getTaille() {
	    	return map.size();
	    }

}
