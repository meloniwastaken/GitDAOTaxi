package ats.controllo.filters;

import java.io.IOException;
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

/**
 * Servlet Filter implementation class ValidazioneTaxiFilter
 */
@WebFilter("/ValidazioneTaxiFilter")
public class ValidazioneTaxiFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidazioneTaxiFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;

		request.removeAttribute("errorMap");
		Map<String,Boolean> errorMap = new HashMap<String,Boolean>();
		if(request.getParameter("marca")==null || request.getParameter("marca").isEmpty() || request.getParameter("marca").length()>20)
			errorMap.put("marca", true);
		if(request.getParameter("modello")==null ||  request.getParameter("modello").isEmpty() || request.getParameter("modello").length()>20)
			errorMap.put("modello", true);
		if(request.getParameter("targa")==null || request.getParameter("targa").length()!=7)
			errorMap.put("targa", true);
		if(request.getParameter("annoImmatricolazione")==null ||  request.getParameter("annoImmatricolazione").isEmpty() || request.getParameter("telefono").length()!=4 || StringUtils.isNumeric(request.getParameter("annoImmatricolazione")) == false) 
			errorMap.put("annoImmatricolazione", true);
		if(request.getParameter("posti")==null || request.getParameter("posti").length()<1 || request.getParameter("posti").length()>2 || Integer.parseInt(request.getParameter("posti")) <= 0 || StringUtils.isNumeric(request.getParameter("posti")) == false)
			errorMap.put("posti",true);
		if(request.getParameter("prezzoPerKilometro")==null || request.getParameter("prezzoPerKilometro").isEmpty() || Double.parseDouble(request.getParameter("prezzoPerKilometro")) <= 0)
			errorMap.put("prezzoPerKilometro", true);
		
		if(errorMap.isEmpty())
			chain.doFilter(request, response);
		else {
			request.setAttribute("errorMap", errorMap);
			request.getRequestDispatcher("inserisciTaxi.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
