<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
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
	<h1>Amministratori</h1>
	<br>
	<% List<Amministratore> amministratori = (List<Amministratore>) request.getAttribute("amministratori"); %>
	
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
  </tr>
  	<% 
  		for(Amministratore amministratore : amministratori){ %>
  			<tr>
  				<td style="text-align:center;"><%=amministratore.getId()%></td>
  				<td style="text-align:center;"><%=amministratore.getNome()%></td>
  				<td style="text-align:center;"><%=amministratore.getCognome()%></td>
  				<td style="text-align:center;"><%=amministratore.getCodiceFiscale()%></td>
  				<td style="text-align:center;"><%=amministratore.getDataDiNascita()%></td>
  	  			<td style="text-align:center;"><%=amministratore.getIndirizzo()%></td>
  		 		<td style="text-align:center;"><%=amministratore.getTelefono()%></td>
  		 		<td style="text-align:center;"><%=amministratore.getEmail()%></td>
  				<td>
  				<form method="POST" action="/GitDAOTaxi/formUpdate">
  				<input type="hidden" id="id" name="id" value="<%=amministratore.getId()%>">
  				<input type="submit" value="MODIFICA">
  				</form>
  				</td>
  				<td>
  				<form method="POST" action="delete">
  				<input type="hidden" id="id" name="id" value="<%=amministratore.getId()%>">
  				<input type="submit" value="CANCELLA">
  				</form>
  				</td>
  			</tr>
  		<%}%>
</table>
</body>
</html>