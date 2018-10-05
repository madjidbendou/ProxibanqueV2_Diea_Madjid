package service;

import exception.GestionException;
import model.Client;
import model.CompteCourant;
import persistance.CustomerDao;
import persistance.CustomerDaoImpl;

public class CustomerServiceImp implements CustomerService {
private CustomerDao dao = new CustomerDaoImpl();

	@Override

	public void ajouterClient(Client c) throws GestionException {
if (c==null) {
	throw new GestionException("Le Client ne doit pas être null");
}else {
	dao.create(c);
}
	}

	@Override
	public void ajouterCompte(CompteCourant co) throws GestionException {
		if (co==null) {
			throw new GestionException("Le Compte ne doit pas être null");
		}else {
			dao.createAccount(co);
		}
	}

	@Override
	public void majClient(Client c) throws GestionException {
		if (c==null) {
			throw new GestionException("Le Client ne doit pas être null");
		}else {
			dao.update(c);
		}
	}

	@Override
	public void ajouterCompte(Client c, CompteCourant co)  throws GestionException{
		ajouterClient(c);
		ajouterCompte(co);
		
		c.setComptecourant(co);	
		
		dao.update(c);
	}


}
