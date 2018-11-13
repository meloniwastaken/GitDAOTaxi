package ats.controllo.servlet.admin;

import java.io.IOException;
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

@WebServlet("/admin/findAllTaxi")
public class FindAllTaxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindAllTaxiServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Taxi> elencoTaxi = null;
		IDAOTaxi daoTaxi = new DAOTaxi();
		try {
			elencoTaxi = daoTaxi.findAll();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("elencoTaxi", elencoTaxi);
		request.getRequestDispatcher("mostraTaxi.jsp").forward(request, response);
	}

}
