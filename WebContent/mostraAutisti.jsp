<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="ats.modello.Autista" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Autisti</h1>
	<br>
	<% List<Autista> autisti = (List<Autista>) request.getAttribute("autisti"); %>
	
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
    <th>Stipendio</th>
  </tr>
  	<% 
  		for(Autista autista : autisti){ %>
  			<tr>
  				<td style="text-align:center;"><%=autista.getId()%></td>
  				<td style="text-align:center;"><%=autista.getNome()%></td>
  				<td style="text-align:center;"><%=autista.getCognome()%></td>
  				<td style="text-align:center;"><%=autista.getCodiceFiscale()%></td>
  				<td style="text-align:center;"><%=autista.getDataDiNascita()%></td>
  	  			<td style="text-align:center;"><%=autista.getIndirizzo()%></td>
  		 		<td style="text-align:center;"><%=autista.getTelefono()%></td>
  		 		<td style="text-align:center;"><%=autista.getEmail()%></td>
  				<td style="text-align:center;"><%=autista.getUsername()%></td>
  				<td style="text-align:center;"><%=autista.getPassword()%></td>
  				<td style="text-align:center;">Autista</td>
  				<td style="text-align:center;"><%=autista.getStipendio()%></td>
  				<td style="text-align:center;">
  					<form method="POST" action="updateAutistaForm">
  						<input type="hidden" name="id" value="<%=autista.getId()%>">
  						<input type="submit" value="Modifica">
  					</form>
  				</td>
  				<td style="text-align:center;">
  					<form method="POST" action="delete">
  						<input type="hidden" name="id" value="<%=autista.getId()%>">
  						<input type="submit" value="Cancella">
  					</form>
  				</td>
  			</tr>
  		<%}%>
</table>
</body>
</html>