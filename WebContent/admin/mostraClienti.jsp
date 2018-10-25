<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="ats.modello.Cliente" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Clienti</h1>
	<br>
	<% List<Cliente> clienti = (List<Cliente>) request.getAttribute("clienti"); %>
	
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
    <th>Modifica</th>
    <th>Cancella</th>
    <th>Statistiche</th>
  </tr>
  	<% 
  		for(Cliente cliente : clienti){ %>
  			<tr>
  				<td style="text-align:center;"><%=cliente.getId()%></td>
  				<td style="text-align:center;"><%=cliente.getNome()%></td>
  				<td style="text-align:center;"><%=cliente.getCognome()%></td>
  				<td style="text-align:center;"><%=cliente.getCodiceFiscale()%></td>
  				<td style="text-align:center;"><%=cliente.getDataDiNascita()%></td>
  	  			<td style="text-align:center;"><%=cliente.getIndirizzo()%></td>
  		 		<td style="text-align:center;"><%=cliente.getTelefono()%></td>
  		 		<td style="text-align:center;"><%=cliente.getEmail()%></td>
  				<td style="text-align:center;"><%=cliente.getUsername()%></td>
  				<td style="text-align:center;"><%=cliente.getPassword()%></td>
  				<td style="text-align:center;">Cliente</td>
  				<td>
  					<form action="/GitDAOTaxi/formUpdate" method="POST">
  						<input type="hidden" name="id" value="<%=cliente.getId()%>">
  						<input type="submit" value="Modifica"/>
  					</form>
  				</td>
  				  <td>
  					<form action="/GitDAOTaxi/delete" method="POST">
  						<input type="hidden" name="id" value="<%=cliente.getId()%>">
  						<input type="submit" value="Cancella"/>
  					</form>
  				</td>
  				  <td>
  					<form action="statistics" method="POST">
  						<input type="hidden" name="id" value="<%=cliente.getId()%>">
  						<input type="submit" value="Statistiche"/>
  					</form>
  				</td>
  			</tr>
  		<%}%>
</table>
</body>
</html>