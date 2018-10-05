package model;
/**
 * 
 * @author Mad&Diea;
 * Ceci est la classe client qui permettra d'instancier tous les clients et de remplir la base de données avec les champs 'nom', 'prenom', 'email','adresse' et d'attribuer des comptes.
 */
public class Client {
	// Attributs
	private int id;


	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private CompteCourant compteCourant;
	private CompteEpargne compteepargne;

	// Constructeurs
	public Client(String nom, String prenom, String email, String adresse,  CompteCourant compteCourant,
			CompteEpargne compteepargne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.compteCourant = compteCourant;
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
		return compteCourant;
	}

	public void setComptecourant(CompteCourant comptecourant) {
		this.compteCourant = comptecourant;
	}

	public CompteEpargne getCompteepargne() {
		return compteepargne;
	}

	public void setCompteepargne(CompteEpargne compteepargne) {
		this.compteepargne = compteepargne;
	}
	
	public int getId() {
		return id;
	}

	// Méthodes
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse
				+ ", comptecourant=" + compteCourant + ", compteepargne=" + compteepargne + "]";
	}

}