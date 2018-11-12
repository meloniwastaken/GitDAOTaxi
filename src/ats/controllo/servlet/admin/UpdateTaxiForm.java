package ats.controllo.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Taxi;
import ats.modello.Utente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOTaxi;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOTaxi;
import ats.persistenza.interfacce.IDAOUtente;

/**
 * Servlet implementation class UpdateTaxiForm
 */
@WebServlet("/admin/updateTaxiForm")
public class UpdateTaxiForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTaxiForm() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
