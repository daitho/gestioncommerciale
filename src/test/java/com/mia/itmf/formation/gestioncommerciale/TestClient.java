package com.mia.itmf.formation.gestioncommerciale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mia.itmf.formation.gestioncommerciale.gestion.GestionClient;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionClient;

@TestMethodOrder(MethodOrderer.MethodName.class )
public class TestClient {
	private static GestionClient gestionClient = new GestionClient();
	
	@BeforeAll
	public static void init() throws ExceptionClient{
		
		gestionClient.ajoutClient(new Client("Dupond","Pierre","Nantes", "0xxxx","dupondp@gmail.com"));
		gestionClient.ajoutClient(new Client("Thomas","Paul","Paris", "0602234232","thomaspa@gmail.com"));
		gestionClient.ajoutClient(new Client("Jean","Joseph","Limoges", "0633045653","jeanjo@gmail.com"));
		
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
		assertEquals(gestionClient.getNombreClient(), 3);
		try {
			gestionClient.ajoutClient(new Client("Max","Louis","Nantes", "0902339232","mlouis@gmail.com"));
		} catch (ExceptionClient e) {
			e.printStackTrace();
		}
		assertEquals(gestionClient.getNombreClient(), 4);
	}
	
	//@Disabled
	@Test @Order(3)
	public void test3_supprimerClient() {

		assertEquals(gestionClient.getNombreClient(), 4);
		try {
			gestionClient.supprimerClient(gestionClient.retrouverClient(4));
		} catch (ExceptionClient e) {
			e.printStackTrace();
		}
		assertEquals(gestionClient.getNombreClient(), 3);
	}
	
	//@Disabled
	@Test @Order(4)
	public void test4_miseAJourClient() {
		try {
			Client client = gestionClient.retrouverClient(1);
			assertEquals("Client [idClient=1, nom=DUPOND, prenom=Pierre, adresse=Nantes, telephone=0602339232, email=dupondp@gmail.com]",client.toString());
			gestionClient.miseAJourClient(client, null, null, 
					null, "Nantes 44000", "0655654634");
		} catch (ExceptionClient e) {
			e.printStackTrace();
		}
		Client client = gestionClient.retrouverClient(1);
		assertEquals("Client [idClient=1, nom=DUPOND, prenom=Pierre, adresse=Nantes 44000, telephone=0655654634, email=dupondp@gmail.com]",client.toString());

	}
	
	@AfterAll
	public static void supprimerLesClientsDeTest() {
		assertEquals(3, gestionClient.getNombreClient());
		try {
			gestionClient.supprimerClient(gestionClient.retrouverClient(1));
			gestionClient.supprimerClient(gestionClient.retrouverClient(2));
			gestionClient.supprimerClient(gestionClient.retrouverClient(3));
		} catch (ExceptionClient e) {
			e.printStackTrace();
		}
		assertEquals(0, gestionClient.getNombreClient());
		System.out.println("Clients supprimés !" );
	}
}
