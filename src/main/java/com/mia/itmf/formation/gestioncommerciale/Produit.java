package com.mia.itmf.formation.gestioncommerciale;

public class Produit {
	
	private int codeProduit;
	private String libelle;
	private Double prix;
	private static int COUNT=1;
	
	
	public Produit() {
		super();

	}

	public Produit(String libelle, double prix) {
		super();
		this.codeProduit = COUNT++;
		setLibelle(libelle);
		setPrix(prix);
	}
	
	public void modifierProduit(String libelle, Double prix) {
		if(libelle != null) {
			setLibelle(libelle);
		}
		if(prix!=null) {
			setPrix(prix);
		}
		
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		if(prix!=null && prix>=0) {
			this.prix = prix;
		}else {
			System.err.println("Le prix du produit ne doit pas être null ou vide !");
		}
		
	}

	@Override
	public String toString() {
		return "Produit [codeProduit=" + getCodeProduit() + ", libelle=" + getLibelle() + ", prix=" + getPrix() + "]";
	}
	
	
	
	
}
