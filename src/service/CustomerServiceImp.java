package service;

import exception.GestionException;
import model.Client;
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

}
