package com.mia.itmf.formation.gestioncommerciale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Document {
	
	private int code;
	private String date;
	private double montant;
	private Client client;
	private List<DetailDocument> listeDetail = new ArrayList<DetailDocument>();
	//private boolean statutListeDetail = false;
	
	
	public Document() {
	}
	
	public String getKey() throws Exception {
		throw new Exception("La methode getKey doit être surcharger");
	}

	public Document(int code, String date, double montant, Client client) {
		this.code = code;
		this.date = date;
		this.montant = montant;
		this.client = client;
		
	}

	
	public List<DetailDocument> getListeDetail() {
		return Collections.unmodifiableList(listeDetail);
	}
	
	public boolean ajouterLigneDetail(DetailDocument ligneDetail) throws Exception{
		if(ligneDetail == null)
			throw new Exception("La ligne est incorrect !");
		return this.listeDetail.add(ligneDetail);
	}
	
	public void supprimerLigneDetail(DetailDocument ligneDucument) throws Exception {
		if(!this.listeDetail.contains(ligneDucument))
			throw new Exception("La ligne entrée n'existe pas dans la liste");
		this.listeDetail.remove(ligneDucument.getidDetailDocument());
		System.out.println("Ligne "+ligneDucument.getidDetailDocument()+" Supprimé." );
	}
	
	public DetailDocument retrouverLigneDetail(int codeLigneDucument) throws Exception {
		for(DetailDocument ligneDucument : this.listeDetail) {
			if(ligneDucument.getidDetailDocument() == codeLigneDucument) {
				return ligneDucument;
			}
		}
		return null;
	}

	public double calculMontant() {
		double total = 0;
		if(this.listeDetail != null) {
			System.out.println("-----------------------------------");
			System.out.println("|code | Quantité | Produit | Libelle | Prix |");
			System.out.println("-----------------------------------");
			for(DetailDocument detail : listeDetail) {
				System.out.println(detail.toString() );
				total = total + detail.getQuantite()*detail.getPrix();
			}
			System.out.println("------------------------------------");
			this.montant = total;
		}
		return this.montant;
	}

	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		//this.statutListeDetail = true;
		try {
			return  getKey()+
					"\nNom du client: "+this.client.getNom()+" "+this.client.getPrenom()+""
					+"Date : " + this.date+""
					+ "\nMontant total "+calculMontant()+"€";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
