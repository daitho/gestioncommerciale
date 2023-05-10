package com.mia.itmf.formation.gestioncommerciale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.formation.gestioncommerciale.gestion.GestionProduit;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionProduit;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestProduit {
	private static GestionProduit gestionProduit;
	
	//Initialisation du produit
	@BeforeAll
	public static void initialisationProduit() {
		gestionProduit = new GestionProduit();
		try {
			gestionProduit.ajoutProduit(new Produit("Pomme",100));
			gestionProduit.ajoutProduit(new Produit("Tomate",50));
			gestionProduit.ajoutProduit(new Produit("Haricot",60));
			gestionProduit.ajoutProduit(new Produit("Mangue",40));
			gestionProduit.ajoutProduit(new Produit("Banane",30));
			gestionProduit.ajoutProduit(new Produit("Orange",15));

			gestionProduit.ajoutProduit(null);
		} catch (ExceptionProduit e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Produit initialisé !" );
	}
	
	
	@Test @Order(1)
	public void test1_afficherProduit() {
		Produit produit = gestionProduit.retrouverProduit(1);
		assertEquals(produit.toString(), "Produit [codeProduit=1, libelle=Pomme, prix=100.0]");
	}
	
	@Test @Order(2)
	public void test2_ajouterProduit() {
		try {
			gestionProduit.ajoutProduit(new Produit("Biscuit",400));
		} catch (ExceptionProduit e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(gestionProduit.getTailleProduit(), 7);
	}
	
	//@Disabled
	@Test @Order(3)
	public void test3_miseAJourProduit() throws ExceptionProduit {
		Produit produit = gestionProduit.retrouverUnProduit("Biscuit", 400);
		assertEquals(produit.getLibelle(), "Biscuit");
		gestionProduit.afficherProduit(1);
	}
	
	@Test @Order(4)
	public void test4_supprimerProduit() {
		try {
			gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(7));
		} catch (ExceptionProduit e) {
			e.printStackTrace();
		}
		assertEquals(gestionProduit.getTailleProduit(), 6);
		System.out.println();
	}
	
	@AfterAll
	public static void supprimerTousLesTest() throws ExceptionProduit {
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(1));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(2));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(3));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(4));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(5));
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(6));
		System.out.println("Clients supprimés !" );
	}
	

}
