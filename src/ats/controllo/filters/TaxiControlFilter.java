package ats.controllo.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ats.modello.Taxi;
import ats.persistenza.implementazione.DAOException;
import ats.persistenza.implementazione.DAOTaxi;
import ats.persistenza.interfacce.IDAOTaxi;

public class TaxiControlFilter implements Filter {

    public TaxiControlFilter() {
    	
    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;
		
		Long idTaxi = null; //request.getParameter("taxi");
		Long idAutista = null; //request.getParameter("idforUpdate");
		
		Taxi t = new Taxi();
		t.setId(0L);
		
		Boolean other = true;
		
		IDAOTaxi daoTaxi = new DAOTaxi();
		
		if(request.getParameter("idforUpdate")!=null) {
			idAutista = Long.parseLong(request.getParameter("idforUpdate"));
			try {
				t = daoTaxi.findByIdAutista(idAutista);
				if (t != null)
					other = daoTaxi.canDeleteTaxi(t.getId());
			} catch (DAOException e) {
				System.out.println(e.getMessage());;
			}
			
		}
		
		if(request.getAttribute("taxi")!=null) {
			idTaxi = ((Taxi) request.getAttribute("taxi")).getId();
		}
		else if(request.getParameter("taxi")!=null) {
			idTaxi = Long.parseLong(request.getParameter("taxi"));
		}
		else
			idTaxi = -1L;
		
		try {
			if(idTaxi.longValue()==-1 || (daoTaxi.canDeleteTaxi(idTaxi) && other || !daoTaxi.canDeleteTaxi(idTaxi) && !other && idTaxi.longValue() == t.getId().longValue())) {
				chain.doFilter(request, response);
			}
			else {
				request.getSession().setAttribute("messaggio", "Taxi in uso");
				response.sendRedirect("/GitDAOTaxi/profile");
			}
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
