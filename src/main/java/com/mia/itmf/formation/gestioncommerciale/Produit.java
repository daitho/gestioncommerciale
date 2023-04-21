package com.mia.itmf.formation.gestioncommerciale;

public class Produit {
	
	private int codeProduit;
	private String libelle;
	private double prix;
	
	
	public Produit() {
		super();

	}

	public Produit(int codeProduit, String libelle, double prix) {
		super();
		this.codeProduit = codeProduit;
		this.libelle = libelle;
		this.prix = prix;
	}

	public int getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(int codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
}
