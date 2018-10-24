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

/**
 * Servlet implementation class DeleteAutistaServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		if(id==(Long) request.getSession().getAttribute("id"))
			request.getSession().invalidate();
		IDAOUtente daoUtente = new DAOUtente();
		try {
			Utente u = daoUtente.findById(id);
			if(u instanceof Autista) {
				IDAOAutista daoAutista = new DAOAutista();
				daoAutista.delete(id);
			}
			else {
				daoUtente.deleteById(id);
			}
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("index.html");
	}

}
