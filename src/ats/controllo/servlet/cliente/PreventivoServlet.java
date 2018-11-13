package ats.controllo.servlet.cliente;

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
import ats.persistenza.implementazione.DAOCliente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOTaxi;
import ats.persistenza.interfacce.IDAOCliente;
import ats.persistenza.interfacce.IDAOTaxi;

@WebServlet("/cliente/preventivo")
public class PreventivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PreventivoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Viaggio v = new Viaggio();
		Cliente c = new Cliente();
		Taxi t = new Taxi();
		IDAOCliente daoCliente = new DAOCliente();
		IDAOTaxi daoTaxi= new DAOTaxi();
		try {
			c = daoCliente.findById((Long)request.getSession().getAttribute("id"));
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
		v.setAutista(t.getAutista());
		try {
			v.setData(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("data")+" "+request.getParameter("time")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		v.setCliente(c);
		v.setTaxi(t);
		Double prezzo= v.getKilometri()*t.getPrezzoPerKilometro();
		v.setPrezzo(prezzo);
		v.setStato(1);
		v.setFeedback(null);
		
		request.getSession().setAttribute("viaggio", v);
		RequestDispatcher rd = request.getRequestDispatcher("preventivo.jsp");
		rd.forward(request, response);
	}

}
