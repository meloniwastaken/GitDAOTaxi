package ats.controllo.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Cliente;
import ats.persistenza.implementazione.DAOCliente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.interfacce.IDAOCliente;

@WebServlet("/admin/findAllClienti")
public class FindAllClientiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindAllClientiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> clienti = null;
		IDAOCliente daoCliente = new DAOCliente();
		
		try {
			clienti = daoCliente.findAll();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("clienti", clienti);
		request.getRequestDispatcher("mostraClienti.jsp").forward(request, response);
	}

}
