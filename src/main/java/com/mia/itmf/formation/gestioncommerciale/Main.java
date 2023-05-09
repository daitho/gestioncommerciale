package com.mia.itmf.formation.gestioncommerciale;

import com.mia.itmf.formation.gestioncommerciale.gestion.GestionClient;
import com.mia.itmf.formation.gestioncommerciale.gestion.GestionProduit;

public class Main {
	static Chien chien;
	public enum Chien{
		Boledogue, Caniche, Carlin, Cairn, Cocker, Dobermann, DogueAllemand;
	}
	
	public static Chien getChien() {
		return chien;
	}

	public static void main(String[] args) throws Exception {
		
		//Initialisation de Client
		
		GestionClient gestionClient = new GestionClient();
		//gestionClient.initialisationClient();
		gestionClient.ajoutClient(new Client(4,"Max","Louis","Nantes", "0902339232","mlouis@gmail.com"));
		gestionClient.supprimerClient(gestionClient.retrouverClient(1));
		gestionClient.afficherClient(1);
		gestionClient.afficherClient(gestionClient.rechercherClientsParNom("M"));
		getChien();
		System.out.println(Chien.Dobermann);
		
		//Initialisation de Produit
		GestionProduit gestionProduit = new GestionProduit();
		//gestionProduit.initialisationProduit();
		gestionProduit.afficherProduit(1);
		gestionProduit.afficherProduit(gestionProduit.rechercherProduitParPrix(30));
		System.out.println(gestionProduit.getTailleProduit());
		
//		GestionFacture gestionFacture = new GestionFacture();
//		Facture facture1 = gestionFacture.ajouterFacture(1, gestionClient.retrouverClient(2));
//		System.out.println(facture1.getCode());
//		
//		facture1.ajouterLigneDetail(new DetailDocument(1, 12, gestionProduit.retrouverProduit(1)));
//		facture1.ajouterLigneDetail(new DetailDocument(2, 15, gestionProduit.retrouverProduit(2)));
//		facture1.ajouterLigneDetail(new DetailDocument(3, 20, gestionProduit.retrouverProduit(3)));
//		facture1.ajouterLigneDetail(new DetailDocument(4, 122, gestionProduit.retrouverProduit(5)));
//		System.out.println(facture1.retrouverLigneDetail(3).getPrix());
//		facture1.supprimerLigneDetail(facture1.retrouverLigneDetail(3));
//		System.out.println(facture1.toString());
//		//System.out.println(facture1.getListeDetail().get(1).getQuantite());
////		facture1.getListeDetail().set(1, new DetailDocument(5, 10, gestionProduit.retrouverProduit(6)));
////		facture1.getListeDetail().add(new DetailDocument(5, 10, gestionProduit.retrouverProduit(6)));
//		gestionFacture.supprimerFacture(gestionFacture.retrouverFacture(1));
//		gestionFacture.supprimerFacture(gestionFacture.retrouverFacture(99));
//		
//		
//		GestionDevis gestionDevis = new GestionDevis();
//		Devis devis = gestionDevis.ajouterDevis(1, gestionClient.retrouverClient(3));
//		devis.ajouterLigneDetail(new DetailDocument(1, 10, gestionProduit.retrouverProduit(1)));
//		devis.ajouterLigneDetail(new DetailDocument(2, 122, gestionProduit.retrouverProduit(3)));
//		devis.ajouterLigneDetail(new DetailDocument(3, 9, gestionProduit.retrouverProduit(4)));
//		devis.ajouterLigneDetail(new DetailDocument(4, 50, gestionProduit.retrouverProduit(6)));
//		System.out.println(devis.toString());
//		
//		GestionCommande gestionCommande = new GestionCommande();
//		Commande commande = gestionCommande.ajouterCommande(1, gestionClient.retrouverClient(4));
//		commande.ajouterLigneDetail(new DetailDocument(1, 101, gestionProduit.retrouverProduit(1)));
//		commande.ajouterLigneDetail(new DetailDocument(2, 12, gestionProduit.retrouverProduit(3)));
//		commande.ajouterLigneDetail(new DetailDocument(3, 55, gestionProduit.retrouverProduit(4)));
//		commande.ajouterLigneDetail(new DetailDocument(4, 50, gestionProduit.retrouverProduit(5)));
//		commande.ajouterLigneDetail(new DetailDocument(5, 540, gestionProduit.retrouverProduit(6)));
//		System.out.println(commande.toString());
	

	}

}
