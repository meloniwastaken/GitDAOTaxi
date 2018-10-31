<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ats.modello.Autista" %>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="ats.modello.Cliente" %>
<%@ page import="ats.modello.Viaggio" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Viaggio> viaggi = (List<Viaggio>) request.getAttribute("viaggi");
  List<Double> statistiche = (List<Double>) request.getAttribute("statistiche");
  DecimalFormat f = new DecimalFormat("##.00");
%>
	<table style="width:100%">
		<thead>
			<tr>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=2) {%> <th>Autista</th><%}%>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=3) {%> <th>Cliente</th><%}%>
				<th>Taxi</th>
				<th>Partenza</th>
				<th>Destinazione</th>
				<th>Data</th>
				<th>Kilometri</th>
				<th>Prezzo</th>
				<th>Stato</th>
				<th>Feedback</th>
				<%if((Integer) request.getSession().getAttribute("ruolo")==2) {%> <th>Cambia stato</th><%}%>
				<%if((Integer) request.getSession().getAttribute("ruolo")==1) {%> <th>Note</th><%}%>
			</tr>
		</thead>
		<tbody>
		<%for(Viaggio v : viaggi) {%>
			<tr>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=2) {%> <td style="text-align:center;"><%=v.getAutista().getNome()%> <%=v.getAutista().getCognome()%></td><%}%>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=3) {%> <td style="text-align:center;"><%=v.getCliente().getNome()%> <%=v.getCliente().getCognome()%></td><%}%>
				<td style="text-align:center;"><%if((Integer) request.getSession().getAttribute("ruolo")==1) {%>ID: <%=v.getTaxi().getId()%><%}%> <%=v.getTaxi().getMarca()%> <%=v.getTaxi().getModello()%></td>
				<td style="text-align:center;"><%=v.getPartenza()%></td>
				<td style="text-align:center;"><%=v.getDestinazione()%></td>
				<td style="text-align:center;"><%=v.getData().toString()%></td>
				<td style="text-align:center;"><%=v.getKilometri()%></td>
				<td style="text-align:center;"><%=v.getPrezzo()%></td>
				<%if(v.getStato()==1) {%><td style="text-align:center;">In attesa</td><%} else if(v.getStato()==2){%><td style="text-align:center;">Accettato</td><%} else if(v.getStato()==3){%><td style="text-align:center;">In corso</td><%} else {%><td style="text-align:center;">Completato</td>  <%}%>
				<td style="text-align:center;"><%if(v.getFeedback()==null && v.getStato()==4 && (Integer)request.getSession().getAttribute("ruolo")==3) {%>
						<form method="POST" action="cliente/lasciaFeedback">
							<input type="hidden" name="idViaggio" value="<%=v.getId()%>"/>
							<select name="feedback">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
							<input type="submit" value="Lascia Feedback"/>
						</form>
				<%} else if(v.getFeedback()!=null && v.getStato()==4) {%>
					<%=v.getFeedback()%>
				<%}%></td>

				<%if((Integer) request.getSession().getAttribute("ruolo")==2 && v.getStato()!=4 && v.getCliente().getUsername()!=null) {%>
				<td style="text-align:center;">
					<form action="autista/avanzaStatoViaggio" method="POST">
						<input type="hidden" name="idViaggio" value="<%=v.getId()%>"/>
						<input type="submit" value="Avanza Stato">
					</form>
				</td>
				<%} else if((Integer) request.getSession().getAttribute("ruolo")==2 && v.getStato()!=4 && v.getCliente().getUsername()!=null) {%>
					<td style="text-align:center;">Utente cancellato</td>
				<%}%>
				<%if((Integer) request.getSession().getAttribute("ruolo")==1 && v.getCliente().getUsername()==null) {%> <td>Utente cancellato</td><%}%>
			</tr>
		<%} %>
		</tbody>
	</table>
	<%if(statistiche!=null && !statistiche.isEmpty()) {%>
	<table>
		<tr><th>Totale viaggi</th><td><%=statistiche.get(0).intValue()%></td></tr>
		<tr><th>Totale kilometri</th><td><%=statistiche.get(1)%></td></tr>
		<tr><th>Totale prezzo</th><td><%=f.format(statistiche.get(2))%></td></tr>
		<tr><th>Media Feedback</th><td><%=f.format(statistiche.get(3))%></td></tr>
	</table>
	<%} %>
</body>
</html>