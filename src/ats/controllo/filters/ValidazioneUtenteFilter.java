package ats.controllo.filters;

import java.io.IOException;
import java.math.BigDecimal;
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
		Map<String,Boolean> errorMap = new HashMap<String,Boolean>();
		if(request.getParameter("nome")==null || request.getParameter("nome").isEmpty() || request.getParameter("nome").length()>35)
			errorMap.put("nome", true);
		if(request.getParameter("cognome")==null ||  request.getParameter("cognome").isEmpty() || request.getParameter("cognome").length()>35)
			errorMap.put("cognome", true);
		if(request.getParameter("codFiscale")==null || request.getParameter("codFiscale").length()!=16)
			errorMap.put("codFiscale", true);
		if(request.getParameter("indirizzo")==null ||  request.getParameter("indirizzo").isEmpty() || request.getParameter("indirizzo").length()>50)
			errorMap.put("indirizzo", true);
		if(request.getParameter("telefono")==null ||  request.getParameter("telefono").isEmpty() || request.getParameter("telefono").length()>15) 
			errorMap.put("telefono", true);
		if(request.getParameter("email")==null || request.getParameter("email").length()>25 || !request.getParameter("email").contains("@")|| !request.getParameter("email").contains("."))
			errorMap.put("email",true);
		if(request.getParameter("username")==null || request.getParameter("username").length()<=6 || request.getParameter("username").length()>=16)
			errorMap.put("username", true);
		if(request.getParameter("password")==null || request.getParameter("password").length()<=6 || request.getParameter("password").length()>=16)
			errorMap.put("password", true);
		if(request.getParameter("cognome").isEmpty() || !request.getParameter("password").equals(request.getParameter("password2")))
			errorMap.put("password2", true);
		if(request.getParameter("stipendio")!=null)
			if(request.getParameter("stipendio").isEmpty() || Double.parseDouble(request.getParameter("stipendio"))<500)
				errorMap.put("stipendio", true);
		
		if(errorMap.isEmpty())
			chain.doFilter(request, response);
		else {
			request.setAttribute("errorMap", errorMap);
			request.getRequestDispatcher(request.getParameter("from")).forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
