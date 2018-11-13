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

@WebServlet("/visualizzaViaggi")
public class VisualizzaViaggiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzaViaggiServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAOUtente daoUtente = new DAOUtente();
		IDAOViaggio daoViaggio = new DAOViaggio();
		Utente u = null;
		List<Viaggio> listaViaggi = new ArrayList<Viaggio>(0);
		List<Double> statistiche = new ArrayList<Double>(0);
		Long idLog = (Long) request.getSession().getAttribute("id");
		if (request.getParameter("id") != null && Long.parseLong(request.getParameter("id")) != idLog)
			idLog = Long.parseLong(request.getParameter("id"));
		try {
			u = daoUtente.findById(idLog);
			if (u instanceof Amministratore) {
				listaViaggi = daoViaggio.findAll();
				statistiche = daoViaggio.findStatisticheTotali();
			} else if (u instanceof Autista) {
				listaViaggi = daoViaggio.findByAutista(u.getId());
				statistiche = daoViaggio.findStatisticheAutista(u.getId());
			} else {
				listaViaggi = daoViaggio.findByCliente(u.getId());
				statistiche = daoViaggio.findStatisticheCliente(u.getId());
			}
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("viaggi", listaViaggi);
		request.setAttribute("statistiche", statistiche);
		request.getRequestDispatcher("viaggi.jsp").forward(request, response);
	}

}
