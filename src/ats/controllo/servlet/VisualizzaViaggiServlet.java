package ats.controllo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Amministratore;
import ats.modello.Autista;
import ats.modello.Utente;
import ats.modello.Viaggio;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.implementazione.DAOViaggio;
import ats.persistenza.interfacce.IDAOUtente;
import ats.persistenza.interfacce.IDAOViaggio;

/**
 * Servlet implementation class VisualizzaViaggiServlet
 */
@WebServlet("/visualizzaViaggi")
public class VisualizzaViaggiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaViaggiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAOUtente daoUtente = new DAOUtente();
		IDAOViaggio daoViaggio = new DAOViaggio();
		Utente u = null;
		List<Viaggio> listaViaggi = new ArrayList<Viaggio>(0);
		try {
			u = daoUtente.findById((Long) request.getSession().getAttribute("id"));
			if(u instanceof Amministratore)
				listaViaggi = daoViaggio.findAll();
			else if(u instanceof Autista)
				listaViaggi = daoViaggio.findByAutista(u.getId());
			else
				listaViaggi = daoViaggio.findByCliente(u.getId());
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("viaggi", listaViaggi);
		request.getRequestDispatcher("viaggi.jsp").forward(request, response);
			
	}

}
