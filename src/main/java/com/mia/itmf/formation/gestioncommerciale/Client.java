package com.mia.itmf.formation.gestioncommerciale;

import java.util.regex.Pattern;

public class Client {
	private Integer idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private static int COUNT=1;
	
	public Client() {
		super();
		this.idClient = COUNT++;
	}

	public Client(String nom, String prenom, String adresse, String telephone, String email) {
		super();
		this.idClient = COUNT++;
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setAdresse(adresse);
		setTelephone(telephone);
	}

	public int getIdClient() {
		return idClient;
	}

	protected void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom.toUpperCase();
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	protected void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	protected void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	protected void setTelephone(String telephone) {
		// Expression régulière pour un entier
		String pattern = "^-?\\d+$";

		// Vérification de la correspondance avec l'expression régulière
		if (Pattern.matches(pattern, telephone)) {
			if(telephone.length() == 10 || telephone.length() == 13) {
				this.telephone = telephone;
			}else {
				System.err.println("La numéro de téléphone "+telephone+" n'est pas correct !.");
			}
		} else {
		    System.err.println("La numéro de téléphone "+telephone+" n'est pas un entier.");
		}
	}

	public String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		if(email.substring(email.length()-10, email.length()).equals("@gmail.com") || email.substring(email.length()-16, email.length()).equals("@soprasteria.com")) {
			this.email = email;
		}else {
			 System.err.println("Le mail doit se terminer par: @gmail.com ou @soprasteria.com.");
		}
	
	}
	
	public void modifierClient(String nom, String prenom, String adresse, String telephone, String email) {
		if(nom != null) {
			setNom(nom);
		}
		if(prenom!=null) {
			setPrenom(prenom);
		}
		if(email!=null) {
			setEmail(email);
		}
		if(adresse!=null) {
			setAdresse(adresse);
		}
		if(telephone!=null) {
			setTelephone(telephone);
		}
		
	}

	@Override
	public String toString() {
		return "Client [idClient=" + getIdClient() + ", nom=" + getNom() + ", prenom=" + getPrenom() + ", adresse=" + getAdresse()
				+ ", telephone=" + getTelephone() + ", email=" + getEmail() + "]";
	}
	
	
	
	
	

}
