package ats.controllo.servlet.autista;

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

/**
 * Servlet implementation class AvanzaStatoViaggioServlet
 */
@WebServlet("/autista/avanzaStatoViaggio")
public class AvanzaStatoViaggioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvanzaStatoViaggioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("AFASDASDDASSDASADSASD").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idViaggio = Long.parseLong(request.getParameter("idViaggio"));
		IDAOViaggio daoViaggio = new DAOViaggio();
		Viaggio v = null;
		try {
			v = daoViaggio.findById(idViaggio);
			if(v.getStato()!=3) {
				v.setStato(v.getStato()+1);
				daoViaggio.update(v);
			}
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("/GitDAOTaxi/visualizzaViaggi");
	}

}
