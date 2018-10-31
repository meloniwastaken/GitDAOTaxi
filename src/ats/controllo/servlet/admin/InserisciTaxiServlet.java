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

/**
 * Servlet implementation class InserisciTaxiServlet
 */
@WebServlet("/admin/inserisciTaxi")
public class InserisciTaxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciTaxiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Taxi t = new Taxi();
		IDAOTaxi daoTaxi = new DAOTaxi();
		t.setMarca(request.getParameter("marca"));
		t.setModello(request.getParameter("modello"));
		t.setTarga(request.getParameter("targa"));
		t.setAnnoDiImmatricolazione(Integer.parseInt(request.getParameter("annoImmatricolazione")));
		t.setPosti(Integer.parseInt(request.getParameter("posti")));
		t.setPrezzoPerKilometro(Double.parseDouble(request.getParameter("prezzoPerKilometro")));
		t.setDisponibile(false);
		try {
			daoTaxi.insert(t);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		response.sendRedirect("../profile");
	}

}
