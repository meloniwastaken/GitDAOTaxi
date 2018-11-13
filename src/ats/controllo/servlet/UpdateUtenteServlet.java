package ats.controllo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

public class UpdateUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUtenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		Utente utente = null;
		IDAOUtente daoUtente = new DAOUtente();

		try {
			Utente vecchioUtente = daoUtente.findById(Long.parseLong(request.getParameter("id")));
			if (vecchioUtente instanceof Amministratore) {
				utente = new Amministratore();
			} else if (vecchioUtente instanceof Autista) {
				utente = new Autista();
			} else {
				utente = new Cliente();
			}
			utente.setNome(request.getParameter("nome"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setCodiceFiscale(request.getParameter("codFiscale"));
			try {
				utente.setDataDiNascita(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			utente.setIndirizzo(request.getParameter("indirizzo"));
			utente.setTelefono(request.getParameter("telefono"));
			utente.setEmail(request.getParameter("email"));
			utente.setUsername(request.getParameter("username"));
			utente.setPassword(request.getParameter("password"));
			utente.setId(Long.parseLong(request.getParameter("id")));
			daoUtente.update(utente);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		if ((Integer) request.getSession().getAttribute("ruolo") == 1)
			response.sendRedirect("/GitDAOTaxi/admin/findAllClienti");
		else
			response.sendRedirect("profile");
	}

}
