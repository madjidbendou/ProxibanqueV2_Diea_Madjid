package service;

import exception.GestionException;
import model.Client;
import model.CompteCourant;

public interface CustomerService {
public void ajouterClient(Client c) throws GestionException;
public void ajouterCompte(CompteCourant co) throws GestionException;
public void majClient(Client c) throws GestionException;
public void ajouterCompte(Client c, CompteCourant co)  throws GestionException;
}
