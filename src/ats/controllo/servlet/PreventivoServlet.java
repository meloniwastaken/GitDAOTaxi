package ats.controllo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Cliente;
import ats.modello.Taxi;
import ats.modello.Viaggio;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOTaxi;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.implementazione.DAOViaggio;
import ats.persistenza.interfacce.IDAOTaxi;
import ats.persistenza.interfacce.IDAOUtente;
import ats.persistenza.interfacce.IDAOViaggio;

/**
 * Servlet implementation class PreventivoServlet
 */
@WebServlet("/PreventivoServlet")
public class PreventivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreventivoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Viaggio v = new Viaggio();
		Cliente c = new Cliente();
		Taxi t = new Taxi();
		IDAOUtente daoUtente = new DAOUtente();
		IDAOTaxi daoTaxi= new DAOTaxi();
		try {
			c = daoUtente.findClienteById((Long)request.getSession().getAttribute("id"));
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			t = daoTaxi.findById(Long.parseLong(request.getParameter("taxi")));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		v.setPartenza(request.getParameter("partenza"));
		v.setDestinazione(request.getParameter("destinazione"));
		v.setKilometri(Double.parseDouble(request.getParameter("kilometri")));
		
		try {
			v.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		v.setCliente(c);
		v.setTaxi(t);
		Double prezzo= v.getKilometri()*t.getPrezzoPerKilometro();
		v.setPrezzo(prezzo);
				
		
		
		request.setAttribute("viaggio", v);
		RequestDispatcher rd = request.getRequestDispatcher("preventivo.jsp");
		rd.forward(request, response);
		
		
	}

}
