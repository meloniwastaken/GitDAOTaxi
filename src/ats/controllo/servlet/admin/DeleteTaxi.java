package ats.controllo.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOTaxi;
import ats.persistenza.interfacce.IDAOTaxi;

@WebServlet("/admin/deleteTaxi")
public class DeleteTaxi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteTaxi() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		IDAOTaxi daoTaxi = new DAOTaxi();
		try {
			daoTaxi.deleteById(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("/GitDAOTaxi/admin/findAllTaxi");
	}

}
