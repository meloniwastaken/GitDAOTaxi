<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="ats.modello.Utente" %>
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
		<title>Utenti</title>
	</head>
	<body background="../img/bg.jpg">
	<jsp:include page="../navBar.jsp"/>
		<h1 class="first">Utenti</h1>
		<% List<Utente> utenti = (List<Utente>) request.getAttribute("utenti");%>	
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-body">
					<table>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Codice Fiscale</th>
							<th>Data di Nascita</th>
							<th>Indirizzo</th>
							<th>Telefono</th>
							<th>Email</th>
							<th>Ruolo</th>
						</tr>
				  		<% for(Utente utente : utenti){ %>
			  			<tr>
			  				<td><%=utente.getId()%></td>
			  				<td><%=utente.getNome()%></td>
			  				<td><%=utente.getCognome()%></td>
			  				<td><%=utente.getCodiceFiscale()%></td>
			  				<td><%=utente.getDataDiNascita()%></td>
			  				<td><%=utente.getIndirizzo()%></td>
			  		 		<td><%=utente.getTelefono()%></td>
			  		 		<td><%=utente.getEmail()%></td>
			  				<td><%if(utente instanceof Amministratore){
			  					out.print("Admin");
			  				}else if(utente instanceof Autista){
			  					out.print("Autista");
			  				}else{
			  					out.print("Cliente");%>
			  			
			  				<%}%> 
			  				</td>
			  			</tr>
				  		<%}%>
				 	</table>
				</div>
			</div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
	</body>
</html>