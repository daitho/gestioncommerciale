package com.mia.itmf.formation.gestioncommerciale.gestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mia.itmf.formation.gestioncommerciale.Client;

public class GestionClient {
	
	private Map<Integer, Client> mapClient = new HashMap<Integer, Client>();
	
	//Ajout d'un client
	public void ajoutClient(Client client) {
		
		if(!verifierClient(client)) {
			mapClient.put(client.getIdClient(), client);
			System.out.println("Client ajouté !" );
		}else {
			System.out.println("Une erreur s'est produit lors de l'ajout du client !" );
		}
		
	}
	
	//Retrouver un Client
    public Client retrouverClient(Integer key) {
		return mapClient.get(key);
	}
	
	//Mise à jour du client
	public void miseAJourClient(Client client) {
		if(verifierClient(client)) {
			mapClient.replace(client.getIdClient(), client);
			System.out.println("Client mise à jour !" );
		}
	}
	
	//Pour verifier si le client existe
	private boolean verifierClient(Client client) {
		return client != null && mapClient.containsKey(client.getIdClient());
	}
	
	//Suppresion Client
    public void supprimerClient(Client client) {
    	if(verifierClient(client)) {
    		mapClient.remove(client.getIdClient());
    		System.out.println("Client supprimé !");
    	}
    	else {
    		System.out.println("Client introuvable !");
    	}
	}
    
    //afficher Client
    public void afficherClient(Client client) {
    	if(verifierClient(client)) {
    		System.out.println("Nom: "+client.getNom()+", Prénom: "+client.getPrenom()+", Ville: "+client.getAdresse()+", Telephone: "+client.getTelephone()+", Email: "+client.getEmail());
    	}else {
    		System.err.println("Client introuvable !");
    	}
    	
	}
    
    public void afficherClient(int key) {
    	afficherClient(retrouverClient(key));
    	
	}
    
    public void afficherClient(List<Client> clients) {
    	for(Client client : clients) {
    		afficherClient(client);
    	}
    	
	}
    
    public List<Client> rechercherClientsParNom(String nom){
    	List<Client> clients = new ArrayList<Client>();
    	for(Client client : mapClient.values()) {
    		if(client.getNom().contains(nom)) {
    			clients.add(client);
    		}
    	}
    	return clients;
    }
    
    public List<Client> rechercherClientParEmail(String email){
    	List<Client> clients = new ArrayList<Client>();
    	for(Client client : mapClient.values()) {
    		if(client.getEmail().contains(email)) {
    			clients.add(client);
    		}
    	}
    	return clients;
    }
    
    public int getNombreClient(){
    	return mapClient.size();
    }

}
