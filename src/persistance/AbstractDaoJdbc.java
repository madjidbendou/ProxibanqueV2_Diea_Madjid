
package persistance;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

//	import javax.sql.DataSource;
/**
 * 
 * @author Diea_Madjid;
 * Ceci est la classe abstraite AbstractDaoJdbc qui contient les méthodes close pour fermer les connexions à la BDD MySQL, et la méthode getConnectionDM qui permettra de se connecter à la BDD en invoquant cette méthode.
 *
 */
	public abstract class AbstractDaoJdbc {

//	    CREATE TABLE `customer` (
//	            `id` int(11) NOT NULL AUTO_INCREMENT,
//	          `firstname` varchar(250) NOT NULL,
//	          `lastname` varchar(250) NOT NULL,
//	            `age` mediumint(8),
//	          PRIMARY KEY (`id`)
//	        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


	    protected void close(Connection cn, PreparedStatement st, ResultSet rs) {
	        try {
	            if (rs != null) rs.close();
	        } catch (SQLException e) {}            
	        try {
	            if (st != null) st.close();
	        } catch (SQLException e) {}            
	        try {
	            if (cn != null) cn.close();
	        } catch (SQLException e) {}
	    }

//	    protected Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
//	        return ds.getConnection();
//	        //return getConnectionDS();
//	        //return getConnectionDM();
//	    }
	    
//	    private Connection getConnectionDS() throws NamingException, SQLException {
//	        Context ctx = new InitialContext();
//	        
//	        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/EShopDS");
//	        return ds.getConnection();
//	    }
	//    
	    public Connection getConnectionDM() throws ClassNotFoundException, SQLException {
	        Connection cn;
	        // etablir la connexion
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        String url = "jdbc:mysql://localhost:3306/proxi2";
	        String username = "root";
	        String password = "";
	        
	        cn = DriverManager.getConnection(url, username, password);
	        cn.setAutoCommit(false);
	        return cn;
	    }


}
