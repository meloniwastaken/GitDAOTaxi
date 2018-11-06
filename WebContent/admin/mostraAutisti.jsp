<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map" %>
    <%@ page import="ats.modello.Autista" %>
    <%@ page import="ats.modello.Taxi" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostra Autisti</title>
</head>
<body background="../img/bg.jpg">

	<jsp:include page="../navBar.jsp"/>
	
	<h1 class="first">Autisti</h1>

	<% Map<Autista,Taxi> map = (Map<Autista,Taxi>) request.getAttribute("map"); %>
	<div class="container first">
		<div class="panel panel-default">
			<div class="panel-body">
				<table>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Codice Fiscale</th>
						<th>Data di Nascita</th>
						<th>Telefono</th>
						<th>Email</th>
						<th>Stipendio [€]</th>
						<th>Taxi</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
  	<% 
  		for(Autista autista : map.keySet()){ %>
  			<tr>
  				<td style="text-align:center;"><%=autista.getId()%></td>
  				<td style="text-align:center;"><%=autista.getNome()%></td>
  				<td style="text-align:center;"><%=autista.getCognome()%></td>
  				<td style="text-align:center;"><%=autista.getCodiceFiscale()%></td>
  				<td style="text-align:center;"><%=autista.getDataDiNascita()%></td>
  		 		<td style="text-align:center;"><%=autista.getTelefono()%></td>
  		 		<td style="text-align:center;"><%=autista.getEmail()%></td>
  				<td style="text-align:center;"><%=autista.getStipendio()%></td>
  				<td style="text-align:center;"><% if(map.get(autista)!=null) out.println(map.get(autista).getMarca() + " " + map.get(autista).getModello() + " " + map.get(autista).getTarga()); else out.println("Non assegnato");%></td>
  				<td style="text-align:center;">
  					<form method="POST" action="../visualizzaViaggi">
  						<input type="hidden" name="id" value="<%=autista.getId()%>">
						<button type="submit" class="btn btn-primary">Statistiche</button>
  					</form>
  				</td>
  				<%if (autista.getUsername()!=null && autista.getPassword()!=null) {%>
  				
  				<td style="text-align:center;">
  					<form method="POST" action="updateAutistaForm">
  						<input type="hidden" name="id" value="<%=autista.getId()%>">
  						<button type="submit" class="btn btn-warning">Modifica</button>
  					</form>
  				</td>
  				<td style="text-align:center;">
  					<form method="POST" action="../delete">
  						<input type="hidden" name="id" value="<%=autista.getId()%>">
						<button type="submit" class="btn btn-danger">Cancella</button>
  					</form>
  				</td>
  				
  				<%}else{ %>
  				<td style="text-align:center;">Utente cancellato</td>
  				<td style="text-align:center;">-----</td>
  				<%} %>
  				
  			</tr>
  		<%}%>
			</table>
</div></div></div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>