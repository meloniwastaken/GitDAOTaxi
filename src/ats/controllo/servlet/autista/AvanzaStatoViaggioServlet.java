package ats.controllo.servlet.autista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Viaggio;
import ats.modello.Taxi;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOTaxi;
import ats.persistenza.implementazione.DAOViaggio;
import ats.persistenza.interfacce.IDAOTaxi;
import ats.persistenza.interfacce.IDAOViaggio;

@WebServlet("/autista/avanzaStatoViaggio")
public class AvanzaStatoViaggioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AvanzaStatoViaggioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		Long idViaggio = Long.parseLong(request.getParameter("idViaggio"));
		IDAOViaggio daoViaggio = new DAOViaggio();
		IDAOTaxi daoTaxi = new DAOTaxi();
		Viaggio v = null;
		try {
			v = daoViaggio.findById(idViaggio);
			if (v.getStato() != 4) {
				v.setStato(v.getStato() + 1);
				daoViaggio.update(v);
			}
			if (v.getStato() == 2) {
				Long id = (Long) request.getSession().getAttribute("id");
				Taxi t = daoTaxi.findByIdAutista(id);
				t.setDisponibile(true);
				System.out.println("stato 2");
				System.out.println(t);
				daoTaxi.update(t);
			}
			if (v.getStato() == 3) {
				Long id = (Long) request.getSession().getAttribute("id");
				Taxi t = daoTaxi.findByIdAutista(id);
				System.out.println("stato 3");
				System.out.println(t);
				t.setDisponibile(false);
				daoTaxi.update(t);
			}
			if (v.getStato() == 4) {
				Long id = (Long) request.getSession().getAttribute("id");
				Taxi t = daoTaxi.findByIdAutista(id);
				System.out.println("stato 4");
				System.out.println(t);
				t.setDisponibile(true);
				daoTaxi.update(t);
			}
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("/GitDAOTaxi/visualizzaViaggi");
	}

}
