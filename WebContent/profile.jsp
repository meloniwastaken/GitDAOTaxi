<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ats.modello.Amministratore" %>
<%@ page import="ats.modello.Cliente" %>
<%@ page import="ats.modello.Autista" %>
<%@ page import="ats.modello.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROFILO</title>
</head>
<body>
	<%
	Utente utente = null;
	Double stipendio = null;
	if(request.getAttribute("admin")!=null) {
		utente = (Amministratore) request.getAttribute("admin");
	}
	else if(request.getAttribute("autista")!=null) {
		utente = (Autista) request.getAttribute("autista");
		stipendio = ((Autista) request.getAttribute("autista")).getStipendio();
	}
	else {
		utente = (Cliente) request.getAttribute("cliente");
	}
	%>
	
	<%=request.getSession().getAttribute("id")%> <br>
	<table>
		<tr><th>Nome:</th><td><%=utente.getNome()%></td>
		<tr><th>Cognome:</th><td><%=utente.getCognome()%></td>
		<tr><th>Codice fiscale:</th><td><%=utente.getCodiceFiscale()%></td>
		<tr><th>Data di nascita:</th><td><%=utente.getDataDiNascita()%></td>
		<tr><th>Indirizzo:</th><td><%=utente.getIndirizzo()%></td>
		<tr><th>Telefono:</th><td><%=utente.getTelefono()%></td>
		<tr><th>Email:</th><td><%=utente.getEmail()%></td>
		<%if(stipendio!=null) {%>
			<tr><th>Stipendio:</th><td><%=stipendio%> €</td>
		<%} %>
	</table>
	<%if((Integer) request.getSession().getAttribute("ruolo")==1) {
		//admin
	}%>
	<a href="logout">Logout</a>
</body>
</html>