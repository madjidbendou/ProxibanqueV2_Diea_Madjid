package persistance;


import exception.GestionException;
import model.Client;
import model.CompteCourant;
/**
 * 
 * @author Diea_Madjid;
 * Ceci est l'interface CustomerDao qui déclare les méthodes pour le DAO
 */
public interface CustomerDao {
    Client findById(int id) throws GestionException;

    void create(Client c) throws GestionException;
    
    void createAccount(CompteCourant co) throws GestionException;

    int update(Client c) throws GestionException;

    int delete(Client c) throws GestionException;

}