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
 * Servlet Filter implementation class PrenotazioneViaggioFilter
 */
@WebFilter("/PrenotazioneViaggioFilter")
public class PrenotazioneViaggioFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PrenotazioneViaggioFilter() {
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
		if(request.getParameter("partenza")==null || request.getParameter("partenza").isEmpty() || request.getParameter("partenza").length()>35)
			errorMap.put("partenza", true);
		if(request.getParameter("destinazione")==null ||  request.getParameter("destinazione").isEmpty() || request.getParameter("destinazione").length()>35)
			errorMap.put("destinazione", true);
		if(request.getParameter("kilometri")==null || Double.parseDouble(request.getParameter("kilometri"))<=0)
			errorMap.put("kilometri", true);
		
		
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
