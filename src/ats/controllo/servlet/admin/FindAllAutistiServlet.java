package ats.controllo.servlet.admin;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Autista;
import ats.modello.Taxi;
import ats.persistenza.implementazione.DAOAutista;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.interfacce.IDAOAutista;


@WebServlet("/admin/findAllAutisti")
public class FindAllAutistiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindAllAutistiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<Autista,Taxi> map = new LinkedHashMap<Autista,Taxi>();
		IDAOAutista daoAutista = new DAOAutista();
		
		try {
			map = daoAutista.findAllWithTaxi();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("mostraAutisti.jsp").forward(request, response);
	}


}
