package persistance;


import exception.GestionException;
import model.Client;

public interface CustomerDao {
    Client findById(int id) throws GestionException;

    void create(Client c) throws GestionException;

    int update(Client c) throws GestionException;

    int delete(Client c) throws GestionException;

}