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
<title>Profilo</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
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
	
	
	<jsp:include page= "navBar.jsp"/>
	
	
	
	
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
	<br>
	<form method="POST" action="visualizzaViaggi">
		<input type="hidden" name="id" value="<%=request.getSession().getAttribute("id")%>"/>
		<input type="submit" value="Visualizza Viaggi"/>
	</form>
	<br>
	<form method="POST" action="formUpdate">
		<input type="hidden" name="id" value="<%=request.getSession().getAttribute("id")%>"/>
		<input type="submit" value="Modifica Account"/>
	</form>
	<br>
	<%if((Integer) request.getSession().getAttribute("ruolo")==1) {%>
		<form method="GET" action="/GitDAOTaxi/admin/findAll">
			<input type="submit" value="Elenco Utenti">
		</form>
		<br>
		<form method="GET" action="/GitDAOTaxi/admin/findAllAutisti">
			<input type="submit" value="Elenco Autisti">
		</form>
		<br>
		<form method="GET" action="/GitDAOTaxi/admin/findAllClienti">
			<input type="submit" value="Elenco Clienti">
		</form>
		<br>
		<form method="POST" action="admin/formRegistrazioneAutista">
			<input type="submit" value="Registra Autista">
		</form>
		<br>
		<form method="POST" action="/GitDAOTaxi/admin/inserisciTaxi.jsp">
			<input type="submit" value="Aggiungi Taxi">
		</form>
		<br>
	<%}%>
	<%if((Integer) request.getSession().getAttribute("ruolo")==2) {
		//autista
	}%>
	<%if((Integer) request.getSession().getAttribute("ruolo")==3) {%>
		<form method="POST" action="cliente/formPrenotazione">
			<input type="hidden" name="id" value="<%=request.getSession().getAttribute("id")%>"/>
			<input type="submit" value="Prenota viaggio"/>
		</form>
	<% }%>
	<a href="logout">Logout</a>
	
	
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>