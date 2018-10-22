<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="ats.modello.Utente" %>
    <%@ page import="ats.modello.Amministratore" %>
    <%@ page import="ats.modello.Autista" %>
    <%@ page import="ats.modello.Cliente" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Utenti</h1>
	<br>
	<% List<Utente> utenti = (List<Utente>) request.getAttribute("utenti"); %>
	
	<table style="width:100%">
  <tr>
    <th>ID</th>
    <th>Nome</th> 
    <th>Cognome</th>
    <th>Codice Fiscale</th>
    <th>Data di nascita</th>
    <th>Indirizzo</th>
    <th>Telefono</th>
    <th>E-mail</th>
    <th>Username</th>
    <th>Password</th>
    <th>Ruolo</th>
  </tr>
  	<% 
  		for(Utente utente : utenti){ %>
  			<tr>
  				<td style="text-align:center;"><%=utente.getId()%></td>
  				<td style="text-align:center;"><%=utente.getNome()%></td>
  				<td style="text-align:center;"><%=utente.getCognome()%></td>
  				<td style="text-align:center;"><%=utente.getCodiceFiscale()%></td>
  				<td style="text-align:center;"><%=utente.getDataDiNascita()%></td>
  	  			<td style="text-align:center;"><%=utente.getIndirizzo()%></td>
  		 		<td style="text-align:center;"><%=utente.getTelefono()%></td>
  		 		<td style="text-align:center;"><%=utente.getEmail()%></td>
  				<td style="text-align:center;"><%=utente.getUsername()%></td>
  				<td style="text-align:center;"><%=utente.getPassword()%></td>
  				<td style="text-align:center;"><%if(utente instanceof Amministratore){
  				out.print("Amministratore");
  				}else if(utente instanceof Autista){
  				out.print("Autista");
  				}else{
  				out.print("Cliente");%></td>
  			</tr>
  		<%}}%>
</table>
</body>
</html>