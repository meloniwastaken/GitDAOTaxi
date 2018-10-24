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
				<td><%if(v.getStato()==1) {%>In attesa<%} else if(v.getStato()==2){%>In corso<%} else {%>Completato<%}%></td>
				<td><%=v.getFeedback()%></td>
			</tr>
		<%} %>
		</tbody>
	</table>
</body>
</html>