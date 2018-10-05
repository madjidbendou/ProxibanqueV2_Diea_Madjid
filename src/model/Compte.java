package model;
/**
 * 
 * @author Diea_Madjid;
 * Ceci est la classe compte qui permet d'instancier les comptes et d'attribuer un solde puis un numero de compte, le numero étant l'id de la BDD, il sera auto-incrémenté.
 */
public class Compte {
	// Attributs
	private double solde;
	private int numero;
	private int numeroCompte;

	// Constructeurs
	public Compte(int numeroCompte , double solde) {
		super();
		this.solde = solde;

	}

	// Getters & Setters
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getNumero() {
		return numero;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	// Méthodes
	@Override
	public String toString() {
		return "Compte [solde=" + solde + ", numero=" + numero + "]";
	}

}
