package com.mia.itmf.formation.gestioncommerciale;

public class DetailDocument {
	
	private int idDetailDocument;
	private int quantite;
	private Produit produit;
	private double prix;

	public DetailDocument() {
		super();
	}

	public DetailDocument(int idDetailDocument, int quantite, Produit produit) {
		super();
		this.idDetailDocument = idDetailDocument;
		this.quantite = quantite;
		this.produit = produit;
		this.prix = produit.getPrix();
	}

	public int getidDetailDocument() {
		return idDetailDocument;
	}

	public void setidDetailDocument(int idDetailDocument) {
		this.idDetailDocument = idDetailDocument;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String toString() {
		return "| "+getidDetailDocument() +" | "+ getQuantite()+" | "+ getProduit().getCodeProduit()+" | "+ getProduit().getLibelle()+" | "+getPrix()+" | ";
	}

}
