package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import exception.GestionException;
import model.Client;
import model.CompteCourant;
import service.CustomerService;
import service.CustomerServiceImp;

@WebServlet("/ClientCree")
/**
 * 
 * @author Diea_Madjid;
 * Ceci est la Servlet ClientCree qui récupère les infos du formulaire de création de client et qui renvoie vers la page liste.jsp.
 *
 */
public class ClientCree extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService impl = new CustomerServiceImp();

	public ClientCree() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		HttpSession maSession = request.getSession();

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String solde = request.getParameter("solde");

		Integer soldec = Integer.valueOf(solde);
		double soldeco = soldec.doubleValue(); 
		CompteCourant co1 = new CompteCourant((int)Math.random()*100, soldeco);
		Client c2 = new Client(nom, prenom, email, adresse, null, null);

		try {
			impl.ajouterCompte(c2, co1);
			} catch (GestionException e) {
			e.printStackTrace();
		}

		response.sendRedirect("liste.jsp");

	}

}
