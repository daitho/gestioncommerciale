package com.mia.itmf.formation.gestioncommerciale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.formation.gestioncommerciale.gestion.GestionClient;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestClient {
	private static GestionClient gestionClient = new GestionClient();
	
	@BeforeAll
	public static void init() {
		gestionClient.ajoutClient(new Client(1,"Dupond","Pierre","Nantes", "0602339232","dupondp@gmail.com"));
		gestionClient.ajoutClient(new Client(2,"Thomas","Paul","Paris", "0602234232","thomaspa@gmail.com"));
		gestionClient.ajoutClient(new Client(3,"Jean","Joseph","Limoges", "0604565332","jeanjo@gmail.com"));
		System.out.println("Client initialisé !" );
		
	}
	
	@Test @Order(1)
	public void test1_afficherClient() {
		Client client = gestionClient.retrouverClient(1);
		assertEquals("Client [idClient=1, nom=DUPOND, prenom=Pierre, adresse=Nantes, telephone=0602339232, email=dupondp@gmail.com]",client.toString());
	}
	
	//@Disabled
	@Test 
	@Order(2)
	public void test2_ajouterClient() {
		gestionClient.ajoutClient(new Client(4,"Max","Louis","Nantes", "0902339232","mlouis@gmail.com"));
		assertEquals(gestionClient.NombreDeClientPar(), 4);
		System.out.println();
	}
	
	@Disabled
	@Test 
	@Order(3)
	public void test3_miseAJourClient() {
		gestionClient = new GestionClient();
		gestionClient.miseAJourClient(new Client(1,"Dupond","Pierre","Nantes 44000", "0602339232","dupondp@gmail.com"));
		gestionClient.afficherClient(1);
		System.out.println();
	}
	
	@Disabled
	@Test 
	@Order(4)
	public void test4_supprimerClient() {
		gestionClient = new GestionClient();
		gestionClient.supprimerClient(gestionClient.retrouverClient(1));
		gestionClient.afficherClient(1);
		System.out.println();
	}
}
