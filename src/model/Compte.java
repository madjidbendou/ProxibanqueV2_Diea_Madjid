package model;

public class Compte {
	// Attributs
	private double solde;
	private int numero;

	// Constructeurs
	public Compte(double solde, int numero) {
		super();
		this.solde = solde;
		this.numero = numero;
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

	public void setNumero(int numero) {
		this.numero = numero;
	}

	// Méthodes
	@Override
	public String toString() {
		return "Compte [solde=" + solde + ", numero=" + numero + "]";
	}

}
