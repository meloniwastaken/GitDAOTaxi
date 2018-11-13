package ats.controllo.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Taxi;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOTaxi;
import ats.persistenza.interfacce.IDAOTaxi;

@WebServlet("/admin/updateTaxi")
public class ModificaTaxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaTaxiServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		Taxi taxi = null;
		IDAOTaxi daoTaxi = new DAOTaxi();

		try {
			taxi = new Taxi();
			taxi = daoTaxi.findById(Long.parseLong(request.getParameter("id")));
			taxi.setId(Long.parseLong(request.getParameter("id")));
			taxi.setMarca(request.getParameter("marca"));
			taxi.setModello(request.getParameter("modello"));
			taxi.setAnnoDiImmatricolazione(Integer.parseInt(request.getParameter("annoImmatricolazione")));
			taxi.setTarga(request.getParameter("targa"));
			taxi.setPrezzoPerKilometro(Double.parseDouble(request.getParameter("prezzoPerKilometro")));
			taxi.setPosti(Integer.parseInt(request.getParameter("posti")));
			daoTaxi.update(taxi);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("findAllTaxi");
	}

}
