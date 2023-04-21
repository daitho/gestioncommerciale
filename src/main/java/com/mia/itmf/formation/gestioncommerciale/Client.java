package com.mia.itmf.formation.gestioncommerciale;

public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	
	public Client() {
		super();
	}

	public Client(int idClient, String nom, String prenom, String adresse, String telephone, String email) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom.toUpperCase();
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + getIdClient() + ", nom=" + getNom() + ", prenom=" + getPrenom() + ", adresse=" + getAdresse()
				+ ", telephone=" + getTelephone() + ", email=" + getEmail() + "]";
	}
	
	
	
	
	

}
