package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Clientcree")
public class Clientcree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Clientcree() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		 
		response.sendRedirect("liste.jsp");
		
		
	}

}
