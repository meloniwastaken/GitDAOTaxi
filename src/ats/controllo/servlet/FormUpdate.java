package ats.controllo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Utente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOUtente;

@WebServlet("/formUpdate")
public class FormUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public FormUpdate() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Utente utente = null;
		IDAOUtente daoUtente = new DAOUtente();
		try {
			utente = daoUtente.findById(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("utenteUpdate", utente);
		request.getRequestDispatcher("updateUtenteForm.jsp").forward(request, response);
	}

}
