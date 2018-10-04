package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.MyBusinessException;
import model.Client;

public class CustomerDaoImpl extends AbstractDaoJdbc implements CustomerDao {

    @Override
    public Client findById(int id) throws MyBusinessException{
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
            throw new MyBusinessException("Echec lecture de l'utilisateur d'id: " + id, e);
        } finally {
            close(cn, st, rs);
        }

        return c1;

    }

    @Override
    public int create(Client c) throws MyBusinessException{
        Connection cn = null;
        PreparedStatement st = null;
        int result = -1;
        try {
            cn = getConnectionDM();

            String sql = "insert into client (nom, prenom, email, adresse) values (?, ?, ?, ?)";

            st = cn.prepareStatement(sql);

            st.setString(1, c.getNom());
            st.setString(2, c.getPrenom());
            st.setString(3, c.getEmail());
            st.setString(4, c.getAdresse());
            
            result = st.executeUpdate();

            cn.commit();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

            try {
                if (cn != null)
                    cn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new MyBusinessException("Echec creation de l'utilisateur : " + c, e);
        } finally {
            close(cn, st, null);
        }
        return result;
    }

    @Override
    public int update(Client c) throws MyBusinessException{
        Connection cn = null;
        PreparedStatement st = null;
        int result = -1;
        try {
            cn = getConnectionDM();

            String sql = "update client set nom = ?, prenom = ?, email = ? where adresse = ?";

            st = cn.prepareStatement(sql);
            st.setString(1, c.getNom());
            st.setString(2, c.getPrenom());
            st.setString(3, c.getEmail());
            st.setString(4, c.getAdresse());

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
            throw new MyBusinessException("Echec de l'update de l'utilisateur : " + c, e);
        } finally {
            close(cn, st, null);
        }
        return result;

    }

    @Override
    public int delete(Client c) throws MyBusinessException{
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
            throw new MyBusinessException("Echec de la suppression de l'utilisateur : " + c, e);
        } finally {
            close(cn, st, null);
        }
        return result;        
    
    }

}
