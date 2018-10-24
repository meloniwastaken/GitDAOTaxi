package ats.controllo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Autista;
import ats.persistenza.implementazione.DAOAutista;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.interfacce.IDAOAutista;

/**
 * Servlet implementation class UpdateUtenteServlet
 */
@WebServlet("/updateAutistaForm")
public class UpdateAutistaForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAutistaForm() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Autista autista = null;
		IDAOAutista daoAutista = new DAOAutista();
		
		try {
			autista = daoAutista.findById(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("autista", autista);
		request.getRequestDispatcher("updateAutistaForm.jsp").forward(request, response);
	}

}
