package ats.controllo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Cliente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOUtente;

public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrazioneServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAOUtente idaoUtente = new DAOUtente();
		Cliente c = new Cliente();
		
		c.setNome(request.getParameter("nome"));
		c.setCognome(request.getParameter("cognome"));
		c.setCodiceFiscale(request.getParameter("codFiscale"));
		try {
			c.setDataDiNascita(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		c.setIndirizzo(request.getParameter("indirizzo"));
		c.setTelefono(request.getParameter("telefono"));
		c.setEmail(request.getParameter("email"));
		c.setUsername(request.getParameter("username"));
		c.setPassword(request.getParameter("password"));
		
		try {
			idaoUtente.insert(c,3);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("index.html");
		
	}

}
