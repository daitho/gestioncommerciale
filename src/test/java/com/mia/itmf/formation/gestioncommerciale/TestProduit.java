package com.mia.itmf.formation.gestioncommerciale;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.formation.gestioncommerciale.gestion.GestionProduit;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestProduit {
	private GestionProduit gestionProduit;
	
	
	@Test @Order(1)
	public void test1_afficherProduit() {
		gestionProduit = new GestionProduit();
		gestionProduit.initialisationProduit();
		gestionProduit.afficherProduit(1);
		System.out.println();
	}
	
	@Test @Order(2)
	public void test2_ajouterProduit() {
		gestionProduit = new GestionProduit();
		gestionProduit.initialisationProduit();
		gestionProduit.ajoutProduit(new Produit(7,"Biscuit",400));
		gestionProduit.afficherProduit(7);
		System.out.println();
	}
	
	@Test @Order(2)
	public void test3_miseAJourProduit() {
		gestionProduit = new GestionProduit();
		gestionProduit.initialisationProduit();
		gestionProduit.miseAJourProduit(new Produit(1,"Biscuit",400));
		gestionProduit.afficherProduit(1);
		System.out.println();
	}
	
	@Test @Order(2)
	public void test4_supprimerProduit() {
		gestionProduit = new GestionProduit();
		gestionProduit.initialisationProduit();
		gestionProduit.supprimerProduit(gestionProduit.retrouverProduit(1));
		gestionProduit.afficherProduit(1);
		System.out.println();
	}

}
