package ats.controllo.filters;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import ats.modello.Autista;
import ats.modello.Cliente;
import ats.modello.Utente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOUtente;

public class ValidazioneUtenteFilter implements Filter {

	public ValidazioneUtenteFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;

		request.removeAttribute("errorMap");
		IDAOUtente daoUtente = new DAOUtente();
		Boolean checkCF = null;
		Boolean checkUsername = null;
		Utente uRegistrazione = null;
		Utente uUpdate = null;
		Autista aRegistrazione = null;
		Autista aUpdate = null;

		if (request.getParameter("from").equals("Registrazione.jsp")) {
			uRegistrazione = new Cliente(); // utente della registrazione
			uRegistrazione.setNome(request.getParameter("nome"));
			uRegistrazione.setCognome(request.getParameter("cognome"));
			uRegistrazione.setCodiceFiscale(request.getParameter("codFiscale"));
			uRegistrazione.setIndirizzo(request.getParameter("indirizzo"));
			uRegistrazione.setTelefono(request.getParameter("telefono"));
			try {
				uRegistrazione.setDataDiNascita(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			uRegistrazione.setEmail(request.getParameter("email"));
			uRegistrazione.setUsername(request.getParameter("username"));
			try {
				checkCF = daoUtente.checkCodicefiscale(request.getParameter("codFiscale"));
				checkUsername = daoUtente.checkUsername(request.getParameter("username"));
			} catch (DAOException e) {
				System.out.println(e.getMessage());
			}

		}

		if (request.getParameter("from").equals("updateUtenteForm.jsp")) {
			uUpdate = new Cliente(); // utente dell'update
			uUpdate.setNome(request.getParameter("nome"));
			uUpdate.setCognome(request.getParameter("cognome"));
			uUpdate.setCodiceFiscale(request.getParameter("codFiscale"));
			uUpdate.setIndirizzo(request.getParameter("indirizzo"));
			uUpdate.setTelefono(request.getParameter("telefono"));
			uUpdate.setId(Long.parseLong(request.getParameter("id")));
			try {
				uUpdate.setDataDiNascita(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			uUpdate.setEmail(request.getParameter("email"));
			uUpdate.setUsername(request.getParameter("username"));
			uUpdate.setPassword(request.getParameter("password"));

		}

		if (request.getParameter("from").equals("formRegistrazioneAutista")) {
			aRegistrazione = new Autista();
			aRegistrazione.setNome(request.getParameter("nome"));
			aRegistrazione.setCognome(request.getParameter("cognome"));
			aRegistrazione.setCodiceFiscale(request.getParameter("codFiscale"));
			aRegistrazione.setIndirizzo(request.getParameter("indirizzo"));
			aRegistrazione.setTelefono(request.getParameter("telefono"));
			try {
				aRegistrazione.setDataDiNascita(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			aRegistrazione.setEmail(request.getParameter("email"));
			aRegistrazione.setUsername(request.getParameter("username"));
			if (!request.getParameter("stipendio").equals(""))
				aRegistrazione.setStipendio(Double.parseDouble(request.getParameter("stipendio")));
			else
				aRegistrazione.setStipendio(-1D);
			try {
				checkCF = daoUtente.checkCodicefiscale(request.getParameter("codFiscale"));
				checkUsername = daoUtente.checkUsername(request.getParameter("username"));
			} catch (DAOException e) {
				System.out.println(e.getMessage());
			}

		}
		

		if (request.getParameter("from").equals("updateAutistaForm")) {
			aUpdate = new Autista();
			aUpdate.setNome(request.getParameter("nome"));
			aUpdate.setCognome(request.getParameter("cognome"));
			aUpdate.setCodiceFiscale(request.getParameter("codFiscale"));
			aUpdate.setIndirizzo(request.getParameter("indirizzo"));
			aUpdate.setTelefono(request.getParameter("telefono"));
			try {
				aUpdate.setDataDiNascita(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			aUpdate.setEmail(request.getParameter("email"));
			aUpdate.setUsername(request.getParameter("username"));
			if (!request.getParameter("stipendio").equals(""))
				aUpdate.setStipendio(Double.parseDouble(request.getParameter("stipendio")));
			else
				aUpdate.setStipendio(-1D);
			aUpdate.setPassword(request.getParameter("password"));
		}

		Map<String, String> errorMap = new HashMap<String, String>();
		if (request.getParameter("nome").isEmpty())
			errorMap.put("nome", "Campo nome vuoto");
		if (request.getParameter("nome").length() > 35)
			errorMap.put("nome", "Nome troppo lungo");
		if (request.getParameter("cognome").isEmpty())
			errorMap.put("cognome", "Campo cognome vuoto");
		if (request.getParameter("cognome").length() > 35)
			errorMap.put("cognome", "Cognome troppo lungo");
		if (request.getParameter("data").isEmpty())
			errorMap.put("data", "Campo data vuoto");
		if (request.getParameter("codFiscale").length() != 16)
			errorMap.put("codFiscale", "Lunghezza codice fiscale errata");
		if (uRegistrazione != null || aRegistrazione != null) {
			if (checkCF == true)
				errorMap.put("codFiscale", "Codice fiscale già registrato");
		}
		if (request.getParameter("indirizzo").isEmpty())
			errorMap.put("indirizzo", "Campo indirizzo vuoto");
		if (request.getParameter("indirizzo").length() > 50)
			errorMap.put("indirizzo", "Indirizzo troppo lungo");
		if (request.getParameter("telefono").isEmpty())
			errorMap.put("telefono", "Campo telefono vuoto");
		if (request.getParameter("telefono").length() > 20)
			errorMap.put("telefono", "Telefono troppo lungo");
		if (StringUtils.isNumeric(request.getParameter("telefono")) == false)
			errorMap.put("telefono", "Telefono non valido");
		if (request.getParameter("email").isEmpty())
			errorMap.put("email", "Campo e-mail vuoto");
		if (request.getParameter("email").length() > 35)
			errorMap.put("email", "E-mail troppo lunga");
		if (!request.getParameter("email").contains("@") || !request.getParameter("email").contains("."))
			errorMap.put("email", "E-mail non valida");
		if (request.getParameter("username").length() > 16 || request.getParameter("username").length() < 6)
			errorMap.put("username", "L'username deve essere compreso fra 6 e 16 caratteri");
		if (uRegistrazione != null || aRegistrazione != null) {
			if (checkUsername == true)
				errorMap.put("username", "Username già utilizzato!");
		}
		if (request.getParameter("password").length() > 16 || request.getParameter("password").length() < 6)
			errorMap.put("password", "La password deve essere compresa fra 6 e 16 caratteri");
		if (!request.getParameter("password2").equals(request.getParameter("password")))
			errorMap.put("password2", "Le due password non coincidono!");
		if (aRegistrazione != null || aUpdate != null) {
			if (request.getParameter("stipendio").isEmpty())
				errorMap.put("stipendio", "Campo stipendio vuoto");
		}
		if (errorMap.isEmpty())
			chain.doFilter(request, response);
		else {
			request.setAttribute("errorMap", errorMap);
			if (uRegistrazione != null)
				request.setAttribute("utenteRegistrazione", uRegistrazione);
			else if (uUpdate != null)
				request.setAttribute("utenteUpdate", uUpdate);
			else if (aRegistrazione != null)
				request.setAttribute("autistaRegistrazione", aRegistrazione);
			else if (aUpdate != null) {
				request.setAttribute("autistaUpdate", aUpdate);
			}

			request.getRequestDispatcher(request.getParameter("from")).forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
