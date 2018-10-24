<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="ats.modello.Autista" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Modifica Autista</h1>
	<% Autista autista = (Autista)request.getAttribute("autista"); %>
	
	<form method="POST" action="updateAutista">
  	<br>
  	Nome <input readonly name="nome" value="<%=autista.getNome()%>"><br>
  	Cognome <input type="text" name="cognome" value="<%=autista.getCognome()%>"><br>
  	Codice fiscale <input type="text" name="codiceFiscale" value="<%=autista.getCodiceFiscale()%>"><br>
  	Data di nascita <input type="text" name="dataDiNascita" value="<%=autista.getDataDiNascita()%>"><br>
  	Indirizzo <input type="text" name="indirizzo" value="<%=autista.getIndirizzo()%>"><br>
  	Telefono <input type="text" name="telefono" value="<%=autista.getTelefono()%>"><br>
  	E-mail <input type="text" name="email" value="<%=autista.getEmail()%>"><br>
  	Username <input type="text" name="username" value="<%=autista.getUsername()%>"><br>
  	Password <input type="password" name="password" value="<%=autista.getPassword()%>"><br>
  	Stipendio <input type="text" name="stipendio" value="<%=autista.getStipendio()%>"><br>
  	<input type="hidden" name="id" value="<%=autista.getId()%>"><br>
  	<input type="submit" value="Conferma">
</form>
</body>
</html>