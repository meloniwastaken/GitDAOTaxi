<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="ats.modello.Cliente" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Clienti</title>
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<link rel="stylesheet" href="../css/style.css">
		<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
	</head>
	<body background="../img/bg.jpg">
	<jsp:include page="../navBar.jsp"/>	
		<h1 class="first">Clienti</h1>		
		<% List<Cliente> clienti = (List<Cliente>) request.getAttribute("clienti"); %>
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
  						<%for(Cliente cliente : clienti){ %>
  						<tr>
			  				<td><%=cliente.getId()%></td>
			  				<td><%=cliente.getNome()%></td>
			  				<td><%=cliente.getCognome()%></td>
			  				<td><%=cliente.getCodiceFiscale()%></td>
			  				<td><%=cliente.getDataDiNascita()%></td>
			  	  			<td><%=cliente.getIndirizzo()%></td>
			  		 		<td><%=cliente.getTelefono()%></td>
			  		 		<td><%=cliente.getEmail()%></td>
				  		 	<td>
	  							<form action="/GitDAOTaxi/visualizzaViaggi" method="POST">
	  								<input type="hidden" name="id" value="<%=cliente.getId()%>">
	  								<button type="submit" class="btn btn-primary">Statistiche</button>
	  							</form>
	  						</td>  		 		
  		 					<%if (cliente.getUsername()!=null && cliente.getPassword()!=null){ %>
  							<td>
  								<form action="/GitDAOTaxi/formUpdate" method="POST">
  									<input type="hidden" name="id" value="<%=cliente.getId()%>">
  									<button type="submit" class="btn btn-warning">Modifica</button>
  								</form>
  							</td>
  				  			<td>
  								<form action="/GitDAOTaxi/delete" method="POST">
  									<input type="hidden" name="id" value="<%=cliente.getId()%>">
  									<button type="submit" class="btn btn-danger">Cancella</button>
  								</form>
  							</td>
  							<%}else{ %>
  							<td>Utente cancellato</td>
  							<td>-----</td>
  							<%} %>  				  
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