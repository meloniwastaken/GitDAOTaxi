package ats.controllo.filters;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request1;
		HttpServletResponse response = (HttpServletResponse) response1;

		request.removeAttribute("errorMap");

		Viaggio v = new Viaggio();
		v.setPartenza(request.getParameter("partenza"));
		v.setDestinazione(request.getParameter("destinazione"));

		String patternData = "yyyy-MM-dd";
		String patternOra = "HH:mm";
		SimpleDateFormat formattaData = new SimpleDateFormat(patternData);
		SimpleDateFormat formattaOra = new SimpleDateFormat(patternOra);
		Boolean erroreOra = false;

		try {
			if (!request.getParameter("data").equals("") && request.getParameter("time").equals(""))
				v.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));

			else if (request.getParameter("data").equals("") && !request.getParameter("time").equals(""))
				v.setData(new SimpleDateFormat("HH:mm").parse(request.getParameter("time")));

			else if (!request.getParameter("data").equals("") && !request.getParameter("time").equals("")) {
				v.setData(new SimpleDateFormat("yyyy-MM-dd HH:mm")
						.parse(request.getParameter("data") + " " + request.getParameter("time")));
				System.out.println(request.getParameter("time"));

				if (request.getParameter("data").equals(formattaData.format(new Date()))) {

					String orarioUtente = request.getParameter("time");
					String oreUtente = "" + orarioUtente.charAt(0) + orarioUtente.charAt(1);
					String minutiUtente = "" + orarioUtente.charAt(3) + orarioUtente.charAt(4);

					String orarioAttuale = formattaOra.format(new Date());
					String oreAttuali = "" + orarioAttuale.charAt(0) + orarioAttuale.charAt(1);
					String minutiAttuali = "" + orarioAttuale.charAt(3) + orarioAttuale.charAt(4);
					if (oreUtente.equals(oreAttuali)) {
						if (Integer.parseInt(minutiAttuali) > Integer.parseInt(minutiUtente))
							erroreOra = true;
						else
							erroreOra = false;
					} 
					
					else if (Integer.parseInt(oreAttuali) > Integer.parseInt(oreUtente))
						erroreOra = true;
					else
						erroreOra = false;

				}
			}
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
		if (erroreOra==true)
			errorMap.put("time", "Orario già trascorso");
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
