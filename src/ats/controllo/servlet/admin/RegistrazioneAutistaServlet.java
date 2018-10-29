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


/**
 * Servlet implementation class RegistrazioneAutistaServlet
 */
@WebServlet("/admin/registrazioneAutista")
public class RegistrazioneAutistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrazioneAutistaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IDAOAutista daoAutista = new DAOAutista();
		Autista a = new Autista();

		a.setNome(request.getParameter("nome"));
		a.setCognome(request.getParameter("cognome"));
		a.setCodiceFiscale(request.getParameter("codFiscale"));
		try {
			a.setDataDiNascita(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		a.setIndirizzo(request.getParameter("indirizzo"));
		a.setTelefono(request.getParameter("telefono"));
		a.setEmail(request.getParameter("email"));
		a.setStipendio(Double.parseDouble(request.getParameter("stipendio")));
		a.setUsername(request.getParameter("username"));
		a.setPassword(request.getParameter("password"));
		
		try {
			daoAutista.insert(a);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		
//		Long idAutista=a.getId();

		IDAOTaxi daoTaxi = new DAOTaxi();
		Taxi t = new Taxi();
		try {
			t = daoTaxi.findById(Long.parseLong(request.getParameter("taxi")));
			t.setDisponibile(true);
			t.setAutista(a);
			daoTaxi.update(t);

		} catch (NumberFormatException e1) {
			System.out.println(e1.getMessage());
		} catch (DAOException e1) {
			System.out.println(e1.getMessage());
		}

		
		response.sendRedirect("../");

	}

}
