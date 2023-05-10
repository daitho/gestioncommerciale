package com.mia.itmf.formation.gestioncommerciale.gestion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mia.itmf.formation.gestioncommerciale.Produit;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionProduit;
import com.mia.itmf.formation.gestioncommerciale.tools.MapTool;

public class GestionProduit {
	private Map<Integer, Produit> map = new LinkedHashMap<Integer, Produit>();
		
		//Ajout d'un produit
		public void ajoutProduit(Produit produit) throws ExceptionProduit {
			
			if(!verifierProduit(produit)) {
				
				map.put(produit.getCodeProduit(), produit);
				System.out.println("Produit ajouté !" );
				
			}else {
				System.err.println("Une erreur s'est produit lors de l'ajout du produit !" );
			}
		}
		
		//Pour verifier si le produit existe
		private boolean verifierProduit(Produit produit) throws ExceptionProduit {
			if(produit == null) {
				throw new ExceptionProduit("Ce produit est null !");
			}
			
			for(Produit valeur  : map.values()) {
				if(valeur.getLibelle().equals(produit.getLibelle()) && valeur.getPrix().equals(produit.getPrix())) {
					return true;
				}
			}
			
			return false;
			
		}
		
		//Retrouver un produit
	    public Produit retrouverProduit(Integer key) {
			return map.get(key);
		}
		
		public Produit retrouverUnProduit(String libelle, double prix)throws ExceptionProduit {

			return MapTool.getMapElement(map, Produit.class, false, addElementListProduit(libelle, prix));
		}

		public List<Produit> retrouverProduit(String libelle, double prix, boolean unique) throws ExceptionProduit {
			return MapTool.getMapElements(map, unique, addElementListProduit(libelle, prix));
		}
		
		private List<MapTool.SearchCriteria<Produit>> addElementListProduit(String libelle, Double prix) throws ExceptionProduit {
			List<MapTool.SearchCriteria<Produit>> criteriaList = new ArrayList<>();

			if (libelle == null && prix == null) {
				throw new ExceptionProduit("Aucun attribut du produit n'est inséré !");
			}

			if (libelle != null) {
				criteriaList.add(new MapTool.SearchCriteria<>(Produit::getLibelle, libelle));
			}
			if (prix != null) {
				criteriaList.add(new MapTool.SearchCriteria<>(Produit::getPrix, prix));
			}
			return criteriaList;
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
		public void miseAJourProduit(Produit produit) throws ExceptionProduit {
			if(verifierProduit(produit)) {
				map.replace(produit.getCodeProduit(), produit);
				System.out.println("Produit mise à jour !" );
			}
		}
		
		public boolean miseAJourProduit(Produit produit, String libelle, Double prix) throws ExceptionProduit {
			if(verifierProduit(produit)) {
				produit.modifierProduit(libelle, prix);
				System.out.println("Produit mise à jour !" );
				return true;
			}
			return false;
		}	
		
		//Suppresion d'un produit
	    public void supprimerProduit(Produit produit) throws ExceptionProduit {
	    	if(verifierProduit(produit)) {
	    		map.remove(produit.getCodeProduit());
				System.out.println("Produit supprimé !" );
			}
			
		}
	    
	  //afficher produit
	    public void afficherProduit(Produit produit) throws ExceptionProduit {
	    	if(verifierProduit(produit)) {
	    		System.out.println("Code: "+produit.getCodeProduit()+", Libelle: "+produit.getLibelle()+", Prix: "+produit.getPrix());
	    	}else {
	    		System.err.println("Produit introuvable !");
	    	}
	    	
		}
	    
	  //afficher Produit
	    public void afficherProduit(Integer key) throws ExceptionProduit {
	    	afficherProduit(retrouverProduit(key));
		}
	    
	  //afficher La liste de Produit
	    public void afficherProduit(List<Produit> produits) {
	    	for(Produit produit : produits) {
	    		try {
					afficherProduit(produit);
				} catch (ExceptionProduit e) {
					e.printStackTrace();
				}
	    	}
		}
	    
	    //Afficher la taille de la map
	    public int getTailleProduit() {
	    	return map.size();
	    }

}
