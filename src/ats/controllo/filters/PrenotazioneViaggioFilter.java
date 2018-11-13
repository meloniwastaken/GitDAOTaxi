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

import ats.modello.Viaggio;

public class PrenotazioneViaggioFilter implements Filter {

	public PrenotazioneViaggioFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)	throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;

		request.removeAttribute("errorMap");

		Viaggio v = new Viaggio();
		v.setPartenza(request.getParameter("partenza"));
		v.setDestinazione(request.getParameter("destinazione"));
		System.out.println(request.getParameter("data") + " " + request.getParameter("time"));

		try {
			if (!request.getParameter("data").equals("") && request.getParameter("time").equals(""))
				v.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));

			else if (request.getParameter("data").equals("") && !request.getParameter("time").equals(""))
				v.setData(new SimpleDateFormat("HH:mm").parse(request.getParameter("time")));

			else if (!request.getParameter("data").equals("") && !request.getParameter("time").equals(""))
				v.setData(new SimpleDateFormat("yyyy-MM-dd HH:mm")
						.parse(request.getParameter("data") + " " + request.getParameter("time")));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		if (!request.getParameter("kilometri").equals(""))
			v.setKilometri(Double.parseDouble(request.getParameter("kilometri")));
		else
			v.setKilometri(-1D);

		Map<String, String> errorMap = new HashMap<String, String>();
		if (request.getParameter("partenza").isEmpty())
			errorMap.put("partenza", "Campo partenza vuoto");
		if (request.getParameter("partenza").length() > 50)
			errorMap.put("partenza", "Lunghezza massima 50 caratteri");
		if (request.getParameter("destinazione").isEmpty())
			errorMap.put("destinazione", "Campo destinazione vuoto");
		if (request.getParameter("partenza").length() > 50)
			errorMap.put("destinazione", "Lunghezza massima 50 caratteri");
		if (request.getParameter("kilometri").isEmpty())
			errorMap.put("kilometri", "Campo kilometri vuoto");
		else if (Double.parseDouble(request.getParameter("kilometri")) <= 0)
			errorMap.put("kilometri", "Valore non valido");
		if (request.getParameter("data").isEmpty())
			errorMap.put("data", "Campo data di partenza vuoto");
		if (request.getParameter("time").isEmpty())
			errorMap.put("time", "Campo orario di partenza vuoto");
		if (errorMap.isEmpty())
			chain.doFilter(request, response);
		else {
			request.setAttribute("errorMap", errorMap);
			request.setAttribute("viaggio", v);
			request.getRequestDispatcher("formPrenotazione").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
