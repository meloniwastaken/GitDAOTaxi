package ats.controllo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Amministratore;
import ats.modello.Autista;
import ats.modello.Cliente;
import ats.modello.Utente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOUtente;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAOUtente daoUtente = new DAOUtente();
		Utente utente = null;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username==null && password==null) {
			username = (String) request.getAttribute("username");
			password = (String) request.getAttribute("password");
		}
		
		try {
			utente = daoUtente.findByUsernameAndPassword(username, password);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		if(utente==null)
			response.sendRedirect("errorpage.jsp");
		else {
			request.getSession().setAttribute("id", utente.getId());
			if(utente instanceof Amministratore)
				request.getSession().setAttribute("ruolo", 1);
			else if (utente instanceof Autista)
				request.getSession().setAttribute("ruolo", 2);
			else if (utente instanceof Cliente)
				request.getSession().setAttribute("ruolo", 3);
			request.getSession().setAttribute("nomeUtente", utente.getNome());
			request.getRequestDispatcher("profile").forward(request, response);
		}
		System.out.println(request.getRequestURI());
	}

}
