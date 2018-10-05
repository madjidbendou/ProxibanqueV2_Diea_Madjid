package model;
/**
 * 
 * @author Diea_Madjid;
 * Ceci est la classe CompteCourant qui étend la classe Compte et qui servira à l'avenir à différencier les comptes courant des comptes épargne. 
 */
public class CompteCourant extends Compte {

	public CompteCourant(int numeroCompte,double solde) {
		super(numeroCompte, solde);
	}

}
