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

@WebServlet("/FormPrenotazione")
public class FormPrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormPrenotazioneServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Taxi> taxi = new ArrayList<Taxi>(0);
		IDAOTaxi daoTaxi = new DAOTaxi();
		try {
			taxi = daoTaxi.findAllDisponibili();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("taxi", taxi);
		request.getRequestDispatcher("Prenotazione.jsp").forward(request, response);
	}

}
