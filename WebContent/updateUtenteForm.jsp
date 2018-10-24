<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="ats.modello.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Modifica Utente</h1>
	<% Utente utente = (Utente)request.getAttribute("utente"); %>
	
	<form method="POST" action="updateUtente">
  	<br>
  	Nome <input type="text" name="nome" value="<%=utente.getNome()%>"><br>
  	<br>
  	Cognome <input type="text" name="cognome" value="<%=utente.getCognome()%>"><br>
  	<br>
  	Codice fiscale <input type="text" name="codiceFiscale" value="<%=utente.getCodiceFiscale()%>"><br>
  	<br>
  	Data di nascita <input type="text" name="dataDiNascita" value="<%=utente.getDataDiNascita()%>"><br>
  	<br>
  	Indirizzo <input type="text" name="indirizzo" value="<%=utente.getIndirizzo()%>"><br>
  	<br>
  	Telefono <input type="text" name="telefono" value="<%=utente.getTelefono()%>"><br>
  	<br>
  	E-mail <input type="text" name="email" value="<%=utente.getEmail()%>"><br>
  	<br>
  	Username <input type="text" name="username" value="<%=utente.getUsername()%>"><br>
  	<br>
  	Password <input type="password" name="password" value="<%=utente.getPassword()%>"><br>
  	<br>
  	<input type="hidden" name="id" value="<%=utente.getId()%>"><br>
  	<br>
  	<input type="submit" value="Conferma">
</form>
</body>
</html>