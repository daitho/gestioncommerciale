package com.mia.itmf.formation.gestioncommerciale;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mia.itmf.formation.gestioncommerciale.gestionException.ExceptionClient;

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
		try {
			setEmail(email);
		} catch (ExceptionClient e) {
			e.printStackTrace();
		}
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

	protected boolean setEmail(String email) throws ExceptionClient {
//		//email.matches(".+@.+\\.[a-z]+");
		if(isEmailAdress(email)) {
			if(emailAdressAccept(email)) {
				this.email = email;
				return true;
			}
			throw new ExceptionClient(email+": Ne pas utiliser . - et _ caractères consécutivement");
		}
		
		throw new ExceptionClient("L'email "+email+" est incorrect");
	
	}
	
    public boolean isEmailAdress(String email) {
        Pattern parttern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        Matcher matcher = parttern.matcher(email);
        
        return matcher.matches();
    }
    
    private boolean emailAdressAccept(String email) {
    	for(int i = 0; i < email.length(); i++) {
    		if(email.charAt(i) == '-' || email.charAt(i) == '.' || email.charAt(i) == '_') {
    			if(email.charAt(i+1) == '-' || email.charAt(i+1) == '.' || email.charAt(i+1) == '_') {
        			return false;
        		}
    		}
    	}
		return true;
    	
    }
	
	public void modifierClient(String nom, String prenom, String adresse, String telephone, String email) {
		if(nom != null) {
			setNom(nom);
		}
		if(prenom!=null) {
			setPrenom(prenom);
		}
		if(email!=null) {
			try {
				setEmail(email);
			} catch (ExceptionClient e) {
				e.printStackTrace();
			}
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
