package model;

public class Client {
	// Attributs
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private CompteCourant comptecourant;
	private CompteEpargne compteepargne;

	// Constructeurs
	public Client(String nom, String prenom, String email, String adresse, CompteCourant comptecourant,
			CompteEpargne compteepargne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.comptecourant = comptecourant;
		this.compteepargne = compteepargne;
	}

	// Getters & Setters
	public String getNom() {
		return nom;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public CompteCourant getComptecourant() {
		return comptecourant;
	}

	public void setComptecourant(CompteCourant comptecourant) {
		this.comptecourant = comptecourant;
	}

	public CompteEpargne getCompteepargne() {
		return compteepargne;
	}

	public void setCompteepargne(CompteEpargne compteepargne) {
		this.compteepargne = compteepargne;
	}

	// Méthodes
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse
				+ ", comptecourant=" + comptecourant + ", compteepargne=" + compteepargne + "]";
	}

}