package com.mia.itmf.formation.gestioncommerciale;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.mia.itmf.formation.gestioncommerciale.gestion.GestionClient;
import com.mia.itmf.formation.gestioncommerciale.gestion.GestionFacture;
import com.mia.itmf.formation.gestioncommerciale.gestion.GestionProduit;

public class TestFacture {
	private GestionClient gestionClient = new GestionClient();
	private GestionProduit gestionProduit = new GestionProduit();
	private GestionFacture gestionFacture = new GestionFacture();
	
	@Disabled
	@Test @Order(1)
	public void test1_afficherFacture() throws Exception {
		Facture facture = gestionFacture.ajouterFacture(1, gestionClient.retrouverClient(2));
		facture.ajouterLigneDetail(new DetailDocument(1, 12, gestionProduit.retrouverProduit(1)));
		facture.ajouterLigneDetail(new DetailDocument(2, 15, gestionProduit.retrouverProduit(2)));
		facture.ajouterLigneDetail(new DetailDocument(3, 20, gestionProduit.retrouverProduit(3)));
		
		System.out.println();
	}

	@Disabled
	@Test @Order(2)
	public void test3_miseAJourFacture() throws Exception {
		Facture facture = gestionFacture.ajouterFacture(1, gestionClient.retrouverClient(2));
		facture.ajouterLigneDetail(new DetailDocument(1, 12, gestionProduit.retrouverProduit(1)));
		facture.ajouterLigneDetail(new DetailDocument(2, 15, gestionProduit.retrouverProduit(2)));
		facture.ajouterLigneDetail(new DetailDocument(3, 20, gestionProduit.retrouverProduit(3)));
		System.out.println();
	}
	
	@Disabled
	@Test @Order(3)
	public void test4_supprimerFacture() throws Exception {
		Facture facture = gestionFacture.ajouterFacture(1, gestionClient.retrouverClient(2));
		facture.ajouterLigneDetail(new DetailDocument(1, 12, gestionProduit.retrouverProduit(1)));
		facture.ajouterLigneDetail(new DetailDocument(2, 15, gestionProduit.retrouverProduit(2)));
		facture.ajouterLigneDetail(new DetailDocument(3, 20, gestionProduit.retrouverProduit(3)));
		System.out.println();
	}
	
	//@Disabled
	@Test @Order(4)
	public void test2_ajouterFacture() throws Exception {
		Facture facture = gestionFacture.ajouterFacture(1, gestionClient.retrouverClient(2));
		assertTrue(facture.ajouterLigneDetail(new DetailDocument(1, 12, gestionProduit.retrouverProduit(1))));
		System.out.println();
	}

}
