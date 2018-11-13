package ats.controllo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Autista;
import ats.modello.Utente;
import ats.persistenza.implementazione.DAOAutista;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOAutista;
import ats.persistenza.interfacce.IDAOUtente;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		IDAOUtente daoUtente = new DAOUtente();
		try {
			Utente u = daoUtente.findById(id);
			if (u instanceof Autista) {
				IDAOAutista daoAutista = new DAOAutista();
				daoAutista.delete(id);
			}
			u.setUsername(null);
			u.setPassword(null);
			daoUtente.update(u);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		if (id == (Long) request.getSession().getAttribute("id")) {
			request.getSession().invalidate();
			response.sendRedirect("/GitDAOTaxi/index.jsp");
		} else {
			request.getSession().setAttribute("messaggio", "Utente cancellato");
			response.sendRedirect("/GitDAOTaxi/profile");
		}


	}

}
