package ats.controllo.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Cliente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOUtente;

///**
// * Servlet implementation class RegistrazioneServlet
// */
//@WebServlet("/RegistrazioneServlet")
//public class RegistrazioneServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAOUtente idaoUtente = new DAOUtente();
		Cliente c = new Cliente();
		c.setNome(request.getParameter("nome"));
		c.setCognome(request.getParameter("cognome"));
		c.setCodiceFiscale(request.getParameter("codFiscale"));
		c.setDataDiNascita((Date)request.getAttribute("data"));
		c.setIndirizzo(request.getParameter("indirizzo"));
		c.setTelefono(request.getParameter("telefono"));
		c.setEmail(request.getParameter("email"));
		c.setUsername(request.getParameter("username"));
		c.setPassword(request.getParameter("password"));
		c.setRuolo(3);
		try {
			idaoUtente.insert(c);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		response.sendRedirect("FindAllServlet");
		
	}

}
