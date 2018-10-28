package ats.controllo.servlet;

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

/**
 * Servlet implementation class FormRegistrazioneAutistaServlet
 */
@WebServlet("/FormRegistrazioneAutistaServlet")
public class FormRegistrazioneAutistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormRegistrazioneAutistaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IDAOTaxi daoTaxi = new DAOTaxi();
		List<Taxi> listaTaxi = new ArrayList<Taxi>();
		try {
			listaTaxi = daoTaxi.findAll();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

		request.setAttribute("listaTaxi", listaTaxi);
		request.getRequestDispatcher("RegistrazioneAutista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

}
