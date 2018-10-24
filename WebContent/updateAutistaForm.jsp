<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ats.modello.Autista" %>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Modifica Autista</h1>
	<% Autista autista = (Autista)request.getAttribute("autista"); %>
	<%List<Taxi> listaTaxi = (List<Taxi>)request.getAttribute("listaTaxi"); %>
	
<form method="POST" action="updateAutista">
<table>
	<tbody>
  		<tr>
  			<td>Nome</td>
  			<td><input readonly name="nome" value="<%=autista.getNome()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>Cognome</td>
  			<td><input type="text" name="cognome" value="<%=autista.getCognome()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>Codice fiscale</td>
  			<td><input type="text" name="codiceFiscale" value="<%=autista.getCodiceFiscale()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>Data di nascita</td> 
  			<td><input type="text" name="dataDiNascita" value="<%=autista.getDataDiNascita()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>Indirizzo</td>
  			<td><input type="text" name="indirizzo" value="<%=autista.getIndirizzo()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>Telefono</td>
  			<td><input type="text" name="telefono" value="<%=autista.getTelefono()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>E-mail</td> 
  			<td><input type="text" name="email" value="<%=autista.getEmail()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>Username</td> 
  			<td><input type="text" name="username" value="<%=autista.getUsername()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>Password</td>
  			<td><input type="password" name="password" value="<%=autista.getPassword()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>Stipendio</td> 
  			<td><input type="text" name="stipendio" value="<%=autista.getStipendio()%>"></td>
  		</tr>
  		<input type="hidden" name="id" value="<%=autista.getId()%>"><br>
  		
  		<tr>
  			<td>
  			<select id="taxi" name="taxi">
  			<%for (Taxi t:listaTaxi){ %>
  			<option value="<%=t.getId()%>"><%=t.getMarca() %> <%=t.getModello() %>, <%=t.getTarga() %>, <%if (t.getAutista()==null){%> Non assegnato <%} else { %> Assegnato <%} %></option> <%} %>
  			</select>
  	
  	</tbody>
</table>
<input type="submit" value="Conferma">
</form>
</body>
</html>