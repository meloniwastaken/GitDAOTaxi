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

@WebServlet("/admin/updateTaxiForm")
public class UpdateTaxiForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateTaxiForm() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Taxi taxi = null;
		IDAOTaxi daoTaxi = new DAOTaxi();
		try {
			taxi = daoTaxi.findById(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("taxi", taxi);
		request.getRequestDispatcher("updateTaxiForm.jsp").forward(request, response);
	}

}
