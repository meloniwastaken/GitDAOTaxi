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

/**
 * Servlet implementation class FindAllTaxiServlet
 */
@WebServlet("/admin/findAllTaxi")
public class FindAllTaxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllTaxiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
