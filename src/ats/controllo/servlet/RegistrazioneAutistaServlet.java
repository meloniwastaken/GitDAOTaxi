package ats.controllo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Autista;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOUtente;

/**
 * Servlet implementation class RegistrazioneAutistaServlet
 */
@WebServlet("/RegistrazioneAutistaServlet")
public class RegistrazioneAutistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneAutistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAOUtente idaoUtente = new DAOUtente();
		Autista a = new Autista();
		
		a.setNome(request.getParameter("nome"));
		a.setCognome(request.getParameter("cognome"));
		a.setCodiceFiscale(request.getParameter("codFiscale"));
		try {
			a.setDataDiNascita(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		a.setIndirizzo(request.getParameter("indirizzo"));
		a.setTelefono(request.getParameter("telefono"));
		a.setEmail(request.getParameter("email"));
		a.setStipendio(Double.parseDouble(request.getParameter("stipendio")));
		a.setUsername(request.getParameter("username"));
		a.setPassword(request.getParameter("password"));
		
		try {
			idaoUtente.insert(a,2);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("index.html");
		
	}

}
