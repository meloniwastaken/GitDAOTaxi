package ats.controllo.servlet.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Viaggio;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOViaggio;
import ats.persistenza.interfacce.IDAOViaggio;

/**
 * Servlet implementation class PrenotaServlet
 */
@WebServlet("/cliente/prenota")
public class PrenotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Viaggio v = (Viaggio) request.getSession().getAttribute("viaggio");
		IDAOViaggio daoViaggio = new DAOViaggio();
		try {
			daoViaggio.insert(v);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("/GitDAOTaxi/profile");
	}

}
