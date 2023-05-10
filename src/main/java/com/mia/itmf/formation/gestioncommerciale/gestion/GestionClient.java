package com.mia.itmf.formation.gestioncommerciale.gestion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mia.itmf.formation.gestioncommerciale.Client;
import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionClient;
import com.mia.itmf.formation.gestioncommerciale.tools.MapTool;

public class GestionClient {
	
	private Map<Integer, Client> mapClient = new LinkedHashMap<Integer, Client>();
	
	//Ajout d'un client
	public boolean ajoutClient(Client client) throws ExceptionClient {
		
		if(!verifierClient(client)) {
			mapClient.put(client.getIdClient(), client);
			System.out.println("Client ajouté !" );
			return true;
		}
		
		throw new ExceptionClient("Une erreur s'est produit lors de l'ajout du client !" );
	}
	
	//Retrouver un Client
    public Client retrouverClient(Integer key) {
		return mapClient.get(key);
	}
    
	public Client retrouverUnClient(String nom, String prenom, String email, String tel, String adresse)
			throws ExceptionClient {

		return MapTool.getMapElement(mapClient, Client.class, false,
				addElementListClient(nom, prenom, email, tel, adresse));
	}

	public List<Client> retrouverClient(String nom, String prenom, String email, String tel, String adresse,
			boolean unique) throws ExceptionClient {
		return MapTool.getMapElements(mapClient, unique, addElementListClient(nom, prenom, email, tel, adresse));
	}
	
    
	private List<MapTool.SearchCriteria<Client>> addElementListClient(String nom, String prenom, String email,
			String tel, String adresse) throws ExceptionClient {
		List<MapTool.SearchCriteria<Client>> criteriaList = new ArrayList<>();

		if (nom == null && prenom == null && email == null && tel == null && adresse == null) {
			throw new ExceptionClient("Aucun attribut du client n'est inséré !");
		}

		if (nom != null) {
			criteriaList.add(new MapTool.SearchCriteria<>(Client::getNom, nom));
		}
		if (prenom != null) {
			criteriaList.add(new MapTool.SearchCriteria<>(Client::getPrenom, prenom));
		}
		if (email != null) {
			criteriaList.add(new MapTool.SearchCriteria<>(Client::getEmail, email));
		}
		if (tel != null) {
			criteriaList.add(new MapTool.SearchCriteria<>(Client::getTelephone, tel));
		}
		if (adresse != null) {
			criteriaList.add(new MapTool.SearchCriteria<>(Client::getAdresse, adresse));
		}
		return criteriaList;
	}
	
	//Mise à jour du client
	public boolean miseAJourClient(Client client, String nom, String prenom, String email, String adresse, String telephone) throws ExceptionClient {
		if(verifierClient(client)) {
			client.modifierClient(nom, prenom, adresse, telephone, email);
			
			System.out.println("Client mise à jour !" );
			return true;
		}
		
		throw new ExceptionClient("Client incorrect !");
	}
	
	//Pour verifier si le client existe
	private boolean verifierClient(Client client) throws ExceptionClient {
		if(client ==null) {
			throw new ExceptionClient("Client null!");
		}
		
		for (Client valeurClient : mapClient.values()) {
			if(valeurClient.getNom().equals(client.getNom()) && valeurClient.getPrenom().equals(client.getPrenom())
					&& valeurClient.getEmail().equals(client.getEmail())
					&& valeurClient.getTelephone().equals(client.getTelephone())
					&& valeurClient.getAdresse().equals(client.getAdresse())) {
				return true;
			}
		}
		return false;
	}
	
	//Suppresion Client
    public void supprimerClient(Client client) throws ExceptionClient {
    	if(verifierClient(client)) {
    		mapClient.remove(client.getIdClient());
    		System.out.println("Client supprimé !");
    	}
    	else {
    		System.out.println("Client introuvable !");
    	}
	}
    
    //afficher Client
    public void afficherClient(Client client) throws ExceptionClient {
    	if(verifierClient(client)) {
    		System.out.println("Nom: "+client.getNom()+", Prénom: "+client.getPrenom()+", Ville: "+client.getAdresse()+", Telephone: "+client.getTelephone()+", Email: "+client.getEmail());
    	}else {
    		System.err.println("Client introuvable !");
    	}
    	
	}
    
    public void afficherClient(int key) throws ExceptionClient {
    	afficherClient(retrouverClient(key));
    	
	}
    
    public void afficherClient(List<Client> clients) throws ExceptionClient {
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
