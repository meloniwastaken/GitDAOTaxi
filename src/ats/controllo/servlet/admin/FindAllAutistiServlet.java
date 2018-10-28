package ats.controllo.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Autista;
import ats.persistenza.implementazione.DAOAutista;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.interfacce.IDAOAutista;


@WebServlet("/admin/findAllAutisti")
public class FindAllAutistiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllAutistiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Autista> autisti = null;
		IDAOAutista daoAutista = new DAOAutista();
		
		try {
			autisti = daoAutista.findAll();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("autisti", autisti);
		request.getRequestDispatcher("mostraAutisti.jsp").forward(request, response);
	}


}
