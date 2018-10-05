package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import exception.GestionException;
import model.Client;
import model.Compte;
import model.CompteCourant;
/**
 * 
 * @author Diea_Madjid;
 * Ceci est la classe qui implémente l'interface CustomerDao afin de pouvoir utiliser toutes les méthodes de cette dernière.
 *
 */
public class CustomerDaoImpl extends AbstractDaoJdbc implements CustomerDao {

    @Override

    public Client findById(int id) throws GestionException{
    	Client c1 = null;
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            cn = getConnectionDM();

            String sql = "select nom, prenom, email, adresse from client where id = ?";

            st = cn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                c1 = new Client("1", "1", "1", "1", null, null);

                c1.setNom(rs.getString("nom"));
                c1.setPrenom(rs.getString("prenom"));
                c1.setEmail(rs.getString("email"));
                c1.setAdresse(rs.getString("adresse"));

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new GestionException("Echec lecture de l'utilisateur d'id: " + id, e);
        } finally {
            close(cn, st, rs);
        }

        return c1;

    }
	@SuppressWarnings("null")
	public Compte selectCompteByNumero(int id) throws GestionException{
    	Compte c1 = null;
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            cn = getConnectionDM();

            String sql = "select numerocompte from compte where id = ?";

            st = cn.prepareStatement(sql);
            st.setInt(1, c1.getNumeroCompte());
            rs = st.executeQuery();

            if (rs.next()) {
                c1 = new CompteCourant(rs.getInt("numerocompte"),rs.getDouble("solde"));

              
              
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new GestionException("Echec lecture de l'utilisateur d'id: " + id, e);
        } finally {
            close(cn, st, rs);
        }

        return c1;

    }
    @Override
    public void create(Client c) throws GestionException{
        Connection cn = null;
        PreparedStatement st = null;
//        int result = -1;
        try {
            cn = getConnectionDM();

            String sql = "insert into client (nom, prenom, email, adresse) values (?, ?, ?, ?)";

            st = cn.prepareStatement(sql);

            st.setString(1, c.getNom());
            st.setString(2, c.getPrenom());
            st.setString(3, c.getEmail());
            st.setString(4, c.getAdresse());
            
            st.executeUpdate();

            cn.commit();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            try {
                if (cn != null)
                    cn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new GestionException("Echec creation de l'utilisateur : " + c, e);
        } finally {
            close(cn, st, null);
        }
//        return result;
    }

    @Override
    public int update(Client c) throws GestionException{
        Connection cn = null;
        PreparedStatement st = null;
        int result = -1;
        try {
            cn = getConnectionDM();

            String sql = "update client set nom = ?, prenom = ?, email = ?, adresse = ?, comptecourant = ?, where id = ?";

            st = cn.prepareStatement(sql);
            st.setString(1, c.getNom());
            st.setString(2, c.getPrenom());
            st.setString(3, c.getEmail());
            st.setString(4, c.getAdresse());
            st.setInt(5, c.getComptecourant() == null ? null : c.getComptecourant().getNumeroCompte());
            st.setInt(6, c.getId());

            result = st.executeUpdate();
            cn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            try {
                if (cn != null)
                    cn.rollback();
            } catch (SQLException e1) {
                e.printStackTrace();
            }
            throw new GestionException("Echec de l'update de l'utilisateur : " + c, e);
        } finally {
            close(cn, st, null);
        }
        return result;

    }

    @Override
    public int delete(Client c) throws GestionException{
        Connection cn = null;
        PreparedStatement st = null;
        int result = -1;
        try {
            cn = getConnectionDM();

            String sql = "delete from client where id = ?";

            st = cn.prepareStatement(sql);
            st.setInt(1, c.getId());

            result = st.executeUpdate();
            cn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            try {
                if (cn != null)
                    cn.rollback();
            } catch (SQLException e1) {
                e.printStackTrace();
            }
            throw new GestionException("Echec de la suppression de l'utilisateur : " + c, e);
        } finally {
            close(cn, st, null);
        }
        return result;        
    
    }

	@Override
	public void createAccount(CompteCourant co) throws GestionException {
		 Connection cn = null;
	        PreparedStatement st = null;
	        try {
	            cn = getConnectionDM();

	            String sql = "insert into compte ( solde, numerocompte) values ( ?, ?)";

	            st = cn.prepareStatement(sql);

	            st.setDouble(1, co.getSolde());
	            st.setDouble(2, co.getNumeroCompte());
	            
	            st.executeUpdate();

	            cn.commit();

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();

	            try {
	                if (cn != null)
	                    cn.rollback();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	            throw new GestionException("Echec creation de l'utilisateur : " + co, e);
	        } finally {
	            close(cn, st, null);
	        }
	    }		
	

}
