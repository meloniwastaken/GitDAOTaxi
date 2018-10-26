<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="ats.modello.Taxi" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Taxi</h1>
	<br>
	<% List<Taxi> elencoTaxi = (List<Taxi>) request.getAttribute("elencoTaxi"); %>
	
	<table style="width:100%">
  <tr>
    <th>ID</th>
    <th>Modello</th> 
    <th>Marca</th>
    <th>Targa</th>
    <th>Anno immatricolazione</th>
    <th>Posti</th>
    <th>Prezzo per Km</th>
    <th>Autista</th>
  </tr>
  	<% 
  		for(Taxi taxi : elencoTaxi){ %>
  			<tr>
  				<td style="text-align:center;"><%=taxi.getId()%></td>
  				<td style="text-align:center;"><%=taxi.getModello()%></td>
  				<td style="text-align:center;"><%=taxi.getMarca()%></td>
  				<td style="text-align:center;"><%=taxi.getTarga()%></td>
  				<td style="text-align:center;"><%=taxi.getAnnoDiImmatricolazione()%></td>
  	  			<td style="text-align:center;"><%=taxi.getPosti()%></td>
  		 		<td style="text-align:center;"><%=taxi.getPrezzoPerKilometro() %></td>
  		 		<td style="text-align:center;"><%=taxi.getAutista().getNome() + " " + taxi.getAutista().getCognome()%></td>
  			</tr>
  		<%}%>
</table>

	<form method="POST" action="deleteTaxi">
	  <input type="hidden" name="taxiId"><br><br>
	  <input type="submit" value="Cancella">
	  
	 <form method="POST" action="statistiche">
	  <input type="hidden" name="taxiId"><br><br>
	  <input type="submit" value="Statistiche">
</body>
</html>