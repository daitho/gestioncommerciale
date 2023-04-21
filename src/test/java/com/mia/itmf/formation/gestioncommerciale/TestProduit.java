package com.mia.itmf.formation.gestioncommerciale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.formation.gestioncommerciale.gestion.GestionProduit;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestProduit {
	private static GestionProduit gestionProduit;
	
	//Initialisation du produit
	@BeforeAll
	public static void initialisationProduit() {
		gestionProduit = new GestionProduit();
		gestionProduit.ajoutProduit(new Produit(1,"Pomme",100));
		gestionProduit.ajoutProduit(new Produit(2,"Tomate",50));
		gestionProduit.ajoutProduit(new Produit(3,"Haricot",60));
		gestionProduit.ajoutProduit(new Produit(4,"Mangue",40));
		gestionProduit.ajoutProduit(new Produit(5,"Banane",30));
		gestionProduit.ajoutProduit(new Produit(6,"Orange",15));
		System.out.println("Produit initialisé !" );
	}
	
	
	@Test @Order(1)
	public void test1_afficherProduit() {
		Produit produit = gestionProduit.retrouverProduit(1);
		assertEquals(produit.toString(), "Produit [codeProduit=1, libelle=Pomme, prix=100.0]");
	}
	
	@Test @Order(2)
	public void test2_ajouterProduit() {
		gestionProduit.ajoutProduit(new Produit(7,"Biscuit",400));
		assertEquals(gestionProduit.getTailleProduit(), 7);
	}
	
	@Test @Order(3)
	public void test4_supprimerProduit() {
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(7));
		assertEquals(gestionProduit.getTailleProduit(), 6);
		System.out.println();
	}
	
	@Test @Order(4)
	public void test3_miseAJourProduit() {
		gestionProduit.miseAJourProduit(new Produit(1,"Biscuit",400));
		Produit produit = gestionProduit.retrouverProduit(1);
		assertEquals(produit.getLibelle(), "Biscuit");
		gestionProduit.afficherProduit(1);
	}
	
	@AfterAll
	public static void supprimerTousLesTest() {
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(1));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(2));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(3));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(4));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(5));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(6));
		System.out.println("Clients supprimés !" );
	}
	

}
