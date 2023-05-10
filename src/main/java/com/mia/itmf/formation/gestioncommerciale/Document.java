package com.mia.itmf.formation.gestioncommerciale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionDocument;

public abstract class Document {
	
	private int code;
	private String date;
	private double montant;
	private Client client;
	private List<DetailDocument> listeDetail = new ArrayList<DetailDocument>();
	//private boolean statutListeDetail = false;
	
	
	public Document() {
	}
	
	public String getKey() throws ExceptionDocument {
		throw new ExceptionDocument("La methode getKey doit être surcharger");
	}

	public Document(Client client) {
		setClient(client);
		
	}

	
	public List<DetailDocument> getListeDetail() {
		return Collections.unmodifiableList(listeDetail);
	}
	
	public boolean ajouterLigneDetail(DetailDocument ligneDetail) throws ExceptionDocument{
		if(ligneDetail == null)
			throw new ExceptionDocument("La ligne est incorrect !");
		return this.listeDetail.add(ligneDetail);
	}
	
	public void supprimerLigneDetail(DetailDocument ligneDucument) throws ExceptionDocument {
		if(!this.listeDetail.contains(ligneDucument)) {
			throw new ExceptionDocument("La ligne entrée n'existe pas dans la liste");
		}
		this.listeDetail.remove(ligneDucument.getidDetailDocument());
		System.out.println("Ligne "+ligneDucument.getidDetailDocument()+" Supprimé." );
	}
	
	public DetailDocument retrouverLigneDetail(int codeLigneDucument) throws ExceptionDocument {
		for(DetailDocument ligneDucument : this.listeDetail) {
			if(ligneDucument.getidDetailDocument() == codeLigneDucument) {
				return ligneDucument;
			}
		}
		throw new ExceptionDocument("Cette ligne n'existe pas !");
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
			System.out.println("Total: "+total);
			this.montant = total;
		}
		return this.montant;
	}

	

	public int getCode() {
		return code;
	}

	protected void setCode(int code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getMontant() {
		this.montant = calculMontant();
		return this.montant;
	}

	protected void setMontant(double montant) {
		this.montant = montant;
	}

	public Client getClient() {
		return client;
	}

	protected void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		//this.statutListeDetail = true;
		try {
			return  getKey()+", Nom du client: "+this.client.getNom()+" "+this.client.getPrenom()+" Montant: "+getMontant();
		} catch (ExceptionDocument e) {
			e.printStackTrace();
		}
		return null;
	}
}
