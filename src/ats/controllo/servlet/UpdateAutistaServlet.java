package ats.controllo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Autista;

import ats.modello.Taxi;

import ats.persistenza.implementazione.DAOAutista;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOTaxi;

import ats.persistenza.interfacce.IDAOAutista;
import ats.persistenza.interfacce.IDAOTaxi;

@WebServlet("/updateAutista")
public class UpdateAutistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAutistaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Autista autista = new Autista();
		IDAOAutista daoAutista = new DAOAutista();

		try {
			autista.setNome(request.getParameter("nome"));
			autista.setCognome(request.getParameter("cognome"));
			autista.setCodiceFiscale(request.getParameter("codiceFiscale"));
			try {
				autista.setDataDiNascita(
						new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataDiNascita")));
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			autista.setIndirizzo(request.getParameter("indirizzo"));
			autista.setTelefono(request.getParameter("telefono"));
			autista.setEmail(request.getParameter("email"));
			autista.setUsername(request.getParameter("username"));
			autista.setPassword(request.getParameter("password"));
			autista.setStipendio(Double.parseDouble(request.getParameter("stipendio")));
			autista.setId(Long.parseLong(request.getParameter("id")));
			daoAutista.update(autista);

			IDAOTaxi daoTaxi = new DAOTaxi();
			Taxi t = new Taxi();
			t = daoTaxi.findById(Long.parseLong(request.getParameter("taxi")));
			t.setAutista(autista);
			daoTaxi.update(t);

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("index.html");
	}

}
