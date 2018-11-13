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

@WebServlet("/cliente/lasciaFeedback")
public class LasciaFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LasciaFeedbackServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		Long idViaggio = Long.parseLong(request.getParameter("idViaggio"));
		Integer feedback = Integer.parseInt(request.getParameter("feedback"));
		IDAOViaggio daoViaggio = new DAOViaggio();
		Viaggio v = null;
		try {
			v = daoViaggio.findById(idViaggio);
			v.setFeedback(feedback);
			daoViaggio.update(v);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("/GitDAOTaxi/visualizzaViaggi");
	}

}
