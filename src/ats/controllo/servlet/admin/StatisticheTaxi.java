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

@WebServlet("/admin/statisticheTaxi")
public class StatisticheTaxi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StatisticheTaxi() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		IDAOTaxi daoTaxi = new DAOTaxi();
		List<Double> statistiche = new ArrayList<Double>(0);
		Taxi t = new Taxi();
		try {
			t = daoTaxi.findById(id);
			statistiche = daoTaxi.findStatistiche(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("statistiche", statistiche);
		request.setAttribute("taxi", t);
		request.getRequestDispatcher("statisticheTaxi.jsp").forward(request, response);
	}

}
