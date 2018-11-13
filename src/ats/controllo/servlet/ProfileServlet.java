package ats.controllo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Amministratore;
import ats.modello.Autista;
import ats.modello.Cliente;
import ats.persistenza.implementazione.DAOAmministratore;
import ats.persistenza.implementazione.DAOAutista;
import ats.persistenza.implementazione.DAOCliente;
import ats.persistenza.implementazione.DAOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = (Long) request.getSession().getAttribute("id");
		if((Integer) request.getSession().getAttribute("ruolo")==1) {
			DAOAmministratore daoAmministratore = new DAOAmministratore();
			Amministratore admin;
			try {
				admin = daoAmministratore.findById(id);
				request.setAttribute("admin", admin);
			} catch (DAOException e) {
				System.out.println(e.getMessage());
			}
		}
		if((Integer) request.getSession().getAttribute("ruolo")==2) {
			DAOAutista daoAutista = new DAOAutista();
			Autista autista;
			try {
				autista = daoAutista.findById(id);
				request.setAttribute("autista", autista);
			} catch (DAOException e) {
				System.out.println(e.getMessage());
			}
		}
		if((Integer) request.getSession().getAttribute("ruolo")==3) {
			DAOCliente daoCliente = new DAOCliente();
			Cliente cliente;
			try {
				cliente = daoCliente.findById(id);
				request.setAttribute("cliente", cliente);
			} catch (DAOException e) {
				System.out.println(e.getMessage());
			}
		}
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}

}
