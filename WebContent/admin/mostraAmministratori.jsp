<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="ats.modello.Amministratore" %>
    <%@ page import="ats.modello.Autista" %>
    <%@ page import="ats.modello.Cliente" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amministratori</title>
</head>
<body background="../img/bg.jpg">

	<jsp:include page="../navBar.jsp"/>
	
	<h1 class="first">Amministratori</h1>
	<br>
	<% List<Amministratore> amministratori = (List<Amministratore>) request.getAttribute("amministratori"); %>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<table>
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
  				<td><%=amministratore.getId()%></td>
  				<td><%=amministratore.getNome()%></td>
  				<td><%=amministratore.getCognome()%></td>
  				<td><%=amministratore.getCodiceFiscale()%></td>
  				<td><%=amministratore.getDataDiNascita()%></td>
  	  			<td><%=amministratore.getIndirizzo()%></td>
  		 		<td><%=amministratore.getTelefono()%></td>
  		 		<td><%=amministratore.getEmail()%></td>
  				<td>
	  				<form method="POST" action="/GitDAOTaxi/formUpdate">
		  				<input type="hidden" id="id" name="id" value="<%=amministratore.getId()%>">
		  				<button type="submit" class="btn btn-warning">Modifica</button>
	  				</form>
  				</td>
  				<td>
	  				<form method="POST" action="delete">
		  				<input type="hidden" id="id" name="id" value="<%=amministratore.getId()%>">
		  				<button type="submit" class="btn btn-danger">Cancella</button>
	  				</form>
  				</td>
  			</tr>
  		<%}%>
</table>
</div></div></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

</body>
</html>