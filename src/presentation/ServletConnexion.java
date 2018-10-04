package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConnexion() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �tape 1 r�cup�ration
		String login = request.getParameter("login");
		String pwd = request.getParameter("password");
		// �tape 2 soumettre

//		// �tape 3 r�ponse
				
		RequestDispatcher dispatcher;

		if (("mad".equalsIgnoreCase(login)) && ("2018".equalsIgnoreCase(pwd))) {
			dispatcher = request.getRequestDispatcher("liste.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("index.html");
		}
		
		dispatcher.forward(request, response);
	}

}
