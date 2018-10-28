package ats.controllo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Utente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOUtente;


public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Utente> utenti = null;
		IDAOUtente daoUtente = new DAOUtente();
		
		try {
			utenti = daoUtente.findAll();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("utenti", utenti);
		request.getRequestDispatcher("mostraUtenti.jsp").forward(request, response);
	}


}
