package ats.controllo.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Taxi;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOTaxi;
import ats.persistenza.interfacce.IDAOTaxi;

@WebServlet("/admin/formRegistrazioneAutista")
public class FormRegistrazioneAutistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormRegistrazioneAutistaServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IDAOTaxi daoTaxi = new DAOTaxi();
		List<Taxi> listaTaxi = new ArrayList<Taxi>();
		try {
			listaTaxi = daoTaxi.findAll();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listaTaxi", listaTaxi);
		request.getRequestDispatcher("registrazioneAutista.jsp").forward(request, response);
	}

}
