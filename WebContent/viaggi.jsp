<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ats.modello.Autista" %>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="ats.modello.Cliente" %>
<%@ page import="ats.modello.Viaggio" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Viaggio> viaggi = (List<Viaggio>) request.getAttribute("viaggi");%>
	<table>
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
			</tr>
		</thead>
		<tbody>
		<%for(Viaggio v : viaggi) {%>
			<tr>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=2) {%> <td><%=v.getAutista().getNome()%> <%=v.getAutista().getCognome()%></td><%}%>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=3) {%> <td><%=v.getCliente().getNome()%> <%=v.getCliente().getCognome()%></td><%}%>
				<td><%if((Integer) request.getSession().getAttribute("ruolo")==1) {%>ID: <%=v.getTaxi().getId()%><%}%> <%=v.getTaxi().getMarca()%> <%=v.getTaxi().getModello()%></td>
				<td><%=v.getPartenza()%></td>
				<td><%=v.getDestinazione()%></td>
				<td><%=v.getData()%></td>
				<td><%=v.getKilometri()%></td>
				<td><%=v.getPrezzo()%></td>
				<%if(v.getStato()==1) {%><td>In attesa</td><%} else if(v.getStato()==2){%><td>In corso</td><%} else {%><td>Completato</td><%}%>
				<td><%if(v.getFeedback()==null && v.getStato()==3 && (Integer)request.getSession().getAttribute("ruolo")==3) {%>
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
				<%} else if(v.getFeedback()!=null && v.getStato()==3) {%>
					<%=v.getFeedback()%>
				<%}%></td>
				<%if((Integer) request.getSession().getAttribute("ruolo")==2 && v.getStato()!=3) {%> <td>
					<form action="autista/avanzaStatoViaggio" method="POST">
						<input type="hidden" name="idViaggio" value="<%=v.getId()%>"/>
						<input type="submit" value="Avanza Stato">
					</form>
					</td><%}%>
			</tr>
		<%} %>
		</tbody>
	</table>
</body>
</html>