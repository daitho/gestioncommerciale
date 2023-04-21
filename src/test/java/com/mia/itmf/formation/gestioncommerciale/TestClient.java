package com.mia.itmf.formation.gestioncommerciale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
	@Test @Order(2)
	public void test2_ajouterClient() {
		gestionClient.ajoutClient(new Client(4,"Max","Louis","Nantes", "0902339232","mlouis@gmail.com"));
		assertEquals(gestionClient.getNombreClient(), 4);
	}
	
	//@Disabled
	@Test @Order(3)
	public void test3_supprimerClient() {
		gestionClient.supprimerClient(gestionClient.retrouverClient(4));
		assertEquals(gestionClient.getNombreClient(), 3);
	}
	
	//@Disabled
	@Test @Order(4)
	public void test4_miseAJourClient() {
		gestionClient.miseAJourClient(new Client(1,"Dupond","Pierre","Nantes 44000", "0602339232","dupondp@gmail.com"));
		Client client = gestionClient.retrouverClient(1);
		assertEquals("Client [idClient=1, nom=DUPOND, prenom=Pierre, adresse=Nantes 44000, telephone=0602339232, email=dupondp@gmail.com]",client.toString());

	}
	
	@AfterAll
	public static void supprimerTousLesTest() {
		gestionClient.supprimerClient(new Client(1,"Dupond","Pierre","Nantes", "0602339232","dupondp@gmail.com"));
		gestionClient.supprimerClient(new Client(2,"Thomas","Paul","Paris", "0602234232","thomaspa@gmail.com"));
		gestionClient.supprimerClient(new Client(3,"Jean","Joseph","Limoges", "0604565332","jeanjo@gmail.com"));
		System.out.println("Clients supprimés !" );
	}
}
