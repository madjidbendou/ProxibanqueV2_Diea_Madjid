package service;

import exception.MyBusinessException;
import model.Client;
import persistance.CustomerDao;
import persistance.CustomerDaoImpl;

public class CustomerServiceImp implements CustomerService {
private CustomerDao dao = new CustomerDaoImpl();

	@Override
	public void ajouterClient(Client c) throws MyBusinessException {
if (c==null) {
	throw new MyBusinessException("Le Client ne doit pas être null");
}else {
	dao.create(c);
}
	}

}
