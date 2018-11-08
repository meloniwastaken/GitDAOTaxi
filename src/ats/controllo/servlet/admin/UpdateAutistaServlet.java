package ats.controllo.servlet.admin;

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

@WebServlet("/admin/updateAutista")
public class UpdateAutistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAutistaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Autista autista = new Autista();
		IDAOAutista daoAutista = new DAOAutista();
		IDAOTaxi daoTaxi = new DAOTaxi();
		Taxi t = new Taxi();

		try {
			daoTaxi.deleteAutistaFromTaxi(Long.parseLong(request.getParameter("idforUpdate")));

			autista.setNome(request.getParameter("nome"));
			autista.setCognome(request.getParameter("cognome"));
			autista.setCodiceFiscale(request.getParameter("codFiscale"));
			try {
				autista.setDataDiNascita(
						new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			autista.setIndirizzo(request.getParameter("indirizzo"));
			autista.setTelefono(request.getParameter("telefono"));
			autista.setEmail(request.getParameter("email"));
			autista.setUsername(request.getParameter("username"));
			autista.setPassword(request.getParameter("password"));
			autista.setStipendio(Double.parseDouble(request.getParameter("stipendio")));
			autista.setId(Long.parseLong(request.getParameter("idforUpdate")));
			daoAutista.update(autista);
			
			if (Long.parseLong(request.getParameter("taxi"))==0) 
				daoTaxi.deleteAutistaFromTaxi(Long.parseLong(request.getParameter("idforUpdate")));
			else {
			t = daoTaxi.findById(Long.parseLong(request.getParameter("taxi")));
			t.setDisponibile(true);
			t.setAutista(autista);
			daoTaxi.update(t);
			}

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("findAllAutisti");
	}

}
