package ats.controllo.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Amministratore;
import ats.persistenza.implementazione.DAOAmministratore;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.interfacce.IDAOAmministratore;

@WebServlet("/admin/findAllAmministratori")
public class FindAllAmministratoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindAllAmministratoriServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Amministratore> amministratori = null;
		IDAOAmministratore daoAmministratore = new DAOAmministratore();

		try {
			amministratori = daoAmministratore.findAll();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

		request.setAttribute("amministratori", amministratori);
		request.getRequestDispatcher("mostraAmministratori.jsp").forward(request, response);
	}

}
