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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import ats.modello.Cliente;
import ats.modello.Utente;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOUtente;
import ats.persistenza.interfacce.IDAOUtente;

/**
 * Servlet Filter implementation class ValidazioneUtenteFilter
 */
@WebFilter("/ValidazioneUtenteFilter")
public class ValidazioneUtenteFilter implements Filter {

    public ValidazioneUtenteFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;

		request.removeAttribute("errorMap");
		IDAOUtente daoUtente = new DAOUtente();
		Boolean checkCF = null;
		Boolean checkUsername = null;
		
		Utente u = new Cliente();
		u.setNome(request.getParameter("nome"));
		u.setCognome(request.getParameter("cognome"));
		u.setCodiceFiscale(request.getParameter("codFiscale"));
		u.setIndirizzo(request.getParameter("indirizzo"));
		u.setTelefono(request.getParameter("telefono"));
		try {
			u.setDataDiNascita(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		u.setEmail(request.getParameter("email"));
		u.setUsername(request.getParameter("username"));		
		
		try {
			checkCF = daoUtente.checkCodicefiscale(request.getParameter("codFiscale"));
			checkUsername = daoUtente.checkUsername(request.getParameter("username"));
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		Map<String,String> errorMap = new HashMap<String,String>();
		
		if (request.getParameter("nome").isEmpty())
			errorMap.put("nome empty", "Campo nome vuoto");
		
		if (request.getParameter("nome").length() >35)
			errorMap.put("nome length", "Nome troppo lungo");	
		
		if (request.getParameter("cognome").isEmpty())
			errorMap.put("cognome empty", "Campo cognome vuoto");
		
		if (request.getParameter("cognome").length() >35)
			errorMap.put("cognome length", "Cognome troppo lungo");
		
		if (request.getParameter("data").isEmpty())
			errorMap.put("data empty", "Campo data vuoto");
				
				
		if (request.getParameter("codFiscale").length()!=16)
			errorMap.put("codFiscale length", "Lunghezza codice fiscale errata");
						
		if (checkCF == true)
			errorMap.put("codFiscale esistente", "Codice fiscale già registrato");
						
		if (request.getParameter("indirizzo").isEmpty())
			errorMap.put("indirizzo empty", "Campo indirizzo vuoto");
		
		if (request.getParameter("indirizzo").length() >50)
			errorMap.put("indirizzo length", "Indirizzo troppo lungo");				
		
		if(request.getParameter("telefono").isEmpty())
			errorMap.put("telefono empty", "Campo telefono vuoto");
		
		if(request.getParameter("telefono").length()>20)
			errorMap.put("telefono length", "Telefono troppo lungo");
			
		if (StringUtils.isNumeric(request.getParameter("telefono")) == false) 
			errorMap.put("telefono nonValido", "Telefono non valido");
		
		if(request.getParameter("email").isEmpty())
			errorMap.put("email empty", "Campo e-mail vuoto");		
		
		if(request.getParameter("email").length()>35)
			errorMap.put("email length", "E-mail troppo lunga");
			
		if (!request.getParameter("email").contains("@")|| !request.getParameter("email").contains("."))
			errorMap.put("email nonValida", "E-mail non valida");
		
		if (request.getParameter("username").length() >16 || request.getParameter("username").length()<6)
			errorMap.put("username length", "L'username deve essere compreso fra 6 e 16 caratteri");
		
		if (checkUsername==true)
			errorMap.put("username esistente", "Username già utilizzato!");
		
//		if (request.getParameter("password").isEmpty())
//			errorMap.put("password empty", "Campo password vuoto");
		
		if (request.getParameter("password").length() >16 || request.getParameter("password").length()<6)
			errorMap.put("password length", "La password deve essere compresa fra 6 e 16 caratteri");
		
		if (!request.getParameter("password2").equals(request.getParameter("password")))
			errorMap.put("password notEquals", "Le due password non coincidono!");
		
//		if(request.getParameter("stipendio").isEmpty())
//			errorMap.put("stipendio empty", "Campo stipendio vuoto");
			
//		Double.parseDouble(request.getParameter("stipendio"))<500)
				
		
		if(errorMap.isEmpty())
			chain.doFilter(request, response);
		else {
			request.setAttribute("errorMap", errorMap);
			if (u!=null)
				request.setAttribute("utente", u);
			request.getRequestDispatcher(request.getParameter("from")).forward(request, response);
		}
	}

		
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
