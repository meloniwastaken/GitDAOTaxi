package ats.controllo.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/ClienteFilter")
public class ClienteFilter implements Filter {

	public ClienteFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)	throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;

		if (request.getSession().getAttribute("ruolo") == null || (Integer) request.getSession().getAttribute("ruolo") != 3) {
			response.sendRedirect("../");
		} else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
