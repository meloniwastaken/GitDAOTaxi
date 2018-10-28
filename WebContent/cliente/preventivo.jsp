<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ats.modello.Viaggio" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Preventivo</title>
</head>
<body>
<% Viaggio v = (Viaggio) request.getSession().getAttribute("viaggio");%>
<h1>AUTISTA</h1>
<table>
	<thead>
		<tr><th>Nome</th><th>Cognome</th><th>Telefono</th><th>Email</th></tr>
	</thead>
	<tbody>
		<tr><td><%=v.getAutista().getNome()%></td>
			<td><%=v.getAutista().getCognome()%></td>
			<td><%=v.getAutista().getTelefono()%></td>
			<td><%=v.getAutista().getEmail()%></td>
		</tr>
	</tbody>
</table>

<h1>TAXI</h1>
<table>
	<thead>
		<tr><th>Marca</th><th>Modello</th><th>Posti</th><th>€/Km</th></tr>
	</thead>
	<tbody>
		<tr><td><%=v.getTaxi().getMarca() %></td>
			<td><%=v.getTaxi().getModello() %></td>
			<td><%=v.getTaxi().getPosti() %></td>
			<td><%=v.getTaxi().getPrezzoPerKilometro() %></td>
		</tr>
	</tbody>
</table>

<h1>PREVENTIVO</h1>
<table>
	<thead>
		<tr><th>Partenza</th><th>Destinazione</th><th>Kilometri</th><th>Data</th><th>Prezzo</th></tr>
	</thead>
	<tbody>
		<tr><td><%=v.getPartenza() %></td>
			<td><%=v.getDestinazione() %></td>
			<td><%=v.getKilometri()%></td>
			<td><%=v.getData()%></td>
			<td><%=v.getPrezzo() %></td>
			
		</tr>
	</tbody>
</table>
<form method="POST" action="prenota">
	<input type="submit" value="Conferma">
</form>
</body>
</html>