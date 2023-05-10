package com.mia.itmf.formation.gestioncommerciale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.formation.gestioncommerciale.gestion.GestionClient;
import com.mia.itmf.formation.gestioncommerciale.gestion.GestionCommande;
import com.mia.itmf.formation.gestioncommerciale.gestion.GestionProduit;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionClient;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionDocument;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionProduit;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestCommande {
	private static GestionClient gestionClient = new GestionClient();
	private static GestionProduit gestionProduit = new GestionProduit();
	static Commande commande;
	
	@BeforeAll
	public static void init() throws ExceptionClient, ExceptionProduit, ExceptionDocument{
		gestionClient.ajoutClient(new Client("Dupond","Pierre","Nantes", "0602339232","dupondp@gmail.com"));
		gestionClient.ajoutClient(new Client("Thomas","Paul","Paris", "0602234232","thomaspa@gmail.com"));
		System.out.println("Produit initialisé !" );
		gestionProduit.ajoutProduit(new Produit("Pomme",100));
		gestionProduit.ajoutProduit(new Produit("Tomate",50));
		gestionProduit.ajoutProduit(new Produit("Haricot",60));
		gestionProduit.ajoutProduit(new Produit("Mangue",40));
		gestionProduit.ajoutProduit(new Produit("Banane",30));
		System.out.println("Client initialisé !" );
		GestionCommande gestionCommande = new GestionCommande();
		commande = gestionCommande.ajouterCommande(new Commande(gestionClient.retrouverClient(2)));
		commande.ajouterLigneDetail(new DetailDocument(1, 12, gestionProduit.retrouverProduit(1)));
		commande.ajouterLigneDetail(new DetailDocument(2, 15, gestionProduit.retrouverProduit(2)));
		commande.ajouterLigneDetail(new DetailDocument(3, 20, gestionProduit.retrouverProduit(3)));
		
	}
	
	//@Disabled
	@Test @Order(1)
	public void test1_afficherCommande(){
		assertEquals(commande.toString(), "Commande-1, Nom du client: THOMAS Paul Montant: 3150.0");
		assertEquals(commande.getMontant(),3150.0);
		assertEquals(commande.getListeDetail().size(),3);
	}
	
	//@Disabled
	@Test @Order(2)
	public void test2_ajouterLigneCommande() {
		try {
			commande.ajouterLigneDetail(new DetailDocument(4, 50, gestionProduit.retrouverProduit(4)));
		} catch (ExceptionDocument e) {
			e.printStackTrace();
		}
		assertEquals(commande.toString(),"Commande-1, Nom du client: THOMAS Paul Montant: 5150.0");
		assertEquals(commande.getMontant(),5150.0);
		assertEquals(commande.getListeDetail().size(),4);
	}
	
	//@Disabled
	@Test @Order(3)
	public void test3_supprimerCommande(){
		try {
			commande.supprimerLigneDetail(commande.retrouverLigneDetail(3));
		} catch (ExceptionDocument e) {
			e.printStackTrace();
		}
		assertEquals(commande.toString(),"Commande-1, Nom du client: THOMAS Paul Montant: 3150.0");
		assertEquals(commande.getMontant(),3150.0);
		assertEquals(commande.getListeDetail().size(),3);
	}

}
