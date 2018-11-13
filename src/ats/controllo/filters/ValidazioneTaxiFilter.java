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
import ats.modello.Taxi;

@WebFilter("/ValidazioneTaxiFilter")
public class ValidazioneTaxiFilter implements Filter {

	public ValidazioneTaxiFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;

		request.removeAttribute("errorMap");
		Taxi t = new Taxi();
		t.setMarca(request.getParameter("marca"));
		t.setModello(request.getParameter("modello"));
		t.setTarga(request.getParameter("targa"));
		if (!request.getParameter("annoImmatricolazione").equals(""))
			t.setAnnoDiImmatricolazione(Integer.parseInt(request.getParameter("annoImmatricolazione")));
		else
			t.setAnnoDiImmatricolazione(-1);
		if (!request.getParameter("posti").equals(""))
			t.setPosti(Integer.parseInt(request.getParameter("posti")));
		else
			t.setPosti(-1);
		if (!request.getParameter("prezzoPerKilometro").equals(""))
			t.setPrezzoPerKilometro(Double.parseDouble(request.getParameter("prezzoPerKilometro")));
		else
			t.setPrezzoPerKilometro(-1D);
		if (request.getParameter("from").equals("updateTaxiForm.jsp"))
			t.setId(Long.parseLong(request.getParameter("id")));

		Map<String, String> errorMap = new HashMap<String, String>();
		if (request.getParameter("marca").isEmpty())
			errorMap.put("marca", "Campo marca vuoto");
		if (request.getParameter("marca").length() > 25)
			errorMap.put("marca", "Lunghezza massima 25 caratteri");
		if (request.getParameter("modello").isEmpty())
			errorMap.put("modello", "Campo modello vuoto");
		if (request.getParameter("modello").length() > 25)
			errorMap.put("modello", "Lunghezza massima 25 caratteri");
		if (request.getParameter("targa").length() != 7)
			errorMap.put("targa", "La targa deve essere di 7 caratteri");
		if (request.getParameter("annoImmatricolazione").isEmpty())
			errorMap.put("annoImmatricolazione", "Campo anno immatricolazione vuoto");
		if (request.getParameter("annoImmatricolazione").length() != 4)
			errorMap.put("annoImmatricolazione", "Cifre non sufficienti");
		if (request.getParameter("posti").isEmpty())
			errorMap.put("posti", "Campo posti vuoto");
		else if (Integer.parseInt(request.getParameter("posti")) > 7
				|| Integer.parseInt(request.getParameter("posti")) <= 0)
			errorMap.put("posti", "Numero posti non valido (min 1, max 7)");
		if (request.getParameter("prezzoPerKilometro").isEmpty())
			errorMap.put("prezzoPerKilometro", "Campo prezzo €/km vuoto");
		else if (Double.parseDouble(request.getParameter("prezzoPerKilometro")) <= 0)
			errorMap.put("prezzoPerKilometro", "Prezzo non valido");
		if (errorMap.isEmpty())
			chain.doFilter(request, response);
		else {
			request.setAttribute("errorMap", errorMap);
			request.setAttribute("taxi", t);
			request.getRequestDispatcher(request.getParameter("from")).forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
