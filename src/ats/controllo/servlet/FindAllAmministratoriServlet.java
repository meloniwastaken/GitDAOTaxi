package ats.controllo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Amministratore;
import ats.persistenza.implementazione.DAOAmministratore;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOUtente;


public class FindAllAmministratoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllAmministratoriServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Amministratore> amministratori = null;
		DAOAmministratore daoAmministratore = new DAOAmministratore();
		
		try {
			amministratori = daoAmministratore.findAll();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("amministratori", amministratori);
		request.getRequestDispatcher("mostraAmministratori.jsp").forward(request, response);
	}


}
