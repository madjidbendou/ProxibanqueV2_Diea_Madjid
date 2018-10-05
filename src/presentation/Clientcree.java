package presentation;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import exception.GestionException;
import model.Client;
import persistance.CustomerDao;
import persistance.CustomerDaoImpl;
import service.CustomerService;
import service.CustomerServiceImp;



@WebServlet("/Clientcree")
public class Clientcree extends HttpServlet {
	private static final long serialVersionUID = 1L;

       private CustomerDao impl = new CustomerDaoImpl();
       
  
    public Clientcree() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession maSession = request.getSession();
		
		String nom = request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");


		Client c2 = new Client(nom, prenom, email, adresse, null, null);
		
		maSession.setAttribute("C2", c2 );
		
		try {
			impl.create(c2);
		} catch (GestionException e) {
			e.printStackTrace();
		}
		 
		response.sendRedirect("liste.jsp");
		
		
	}

}
