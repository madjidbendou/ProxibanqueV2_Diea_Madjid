package service;

import exception.MyBusinessException;
import model.Client;

public interface CustomerService {
public void ajouterClient(Client c) throws MyBusinessException;
}
