<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="ats.modello.Taxi" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<link rel="stylesheet" href="../css/style.css">
		<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Taxi</title>
	</head>
	<body background="../img/bg.jpg">
	<jsp:include page="../navBar.jsp"/>
		<h1 class="first">Taxi</h1>
		<% List<Taxi> elencoTaxi = (List<Taxi>) request.getAttribute("elencoTaxi"); %>
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-body scrollmenu">
					<table>
						<thead style="font-size:120%">
		 					<tr>
							    <th>Marca</th>
							    <th>Modello</th> 
							    <th>Targa</th>
							    <th>Anno immatricolazione</th>
							    <th>Posti</th>
							    <th>Prezzo per Km</th>
							    <th>Autista</th>
		  					</tr>
		  				</thead>
  						<%for(Taxi taxi : elencoTaxi){ %>
  						<tr>
			  				<td><%=taxi.getMarca()%></td>
			  				<td><%=taxi.getModello()%></td>
			  				<td><%=taxi.getTarga()%></td>
			  				<td><%=taxi.getAnnoDiImmatricolazione()%></td>
			  	  			<td><%=taxi.getPosti()%></td>
			  		 		<td><%=taxi.getPrezzoPerKilometro() %></td>
			  		 		<td><%if(taxi.getAutista() != null){out.print(taxi.getAutista().getNome() + " " + taxi.getAutista().getCognome());}
  		 					else{out.print("Non assegnato");}%></td>
	 						<td>
		 						<form method="POST" action="statisticheTaxi">
						  			<input type="hidden" name="id" value="<%=taxi.getId()%>">
						  			<button type="submit" class="btn btn-primary">Statistiche</button>
		 						</form>
	 						</td>
	 						<td>
	  		 					<form method="POST" action="updateTaxiForm">
						  			<input type="hidden" name="id" value="<%=taxi.getId()%>">
						  			<button type="submit" class="btn btn-warning">Modifica</button>
		 						</form>
	 						</td>
	 						<td>
	  		 					<form method="POST" action="deleteTaxi">
						  			<input type="hidden" name="id" value="<%=taxi.getId()%>">
						  			<button type="submit" class="btn btn-danger">Cancella</button>
		 						</form>
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