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
    <th>Marca</th>
    <th>Modello</th> 
    <th>Targa</th>
    <th>Anno immatricolazione</th>
    <th>Posti</th>
    <th>Prezzo/km</th>
    <th>Autista</th>
    <th>Cancella</th>
    <th>Statistiche</th>
  </tr>
  	<% 
  		for(Taxi taxi : elencoTaxi){ %>
  			<tr>
  				<td style="text-align:center;"><%=taxi.getMarca()%></td>
  				<td style="text-align:center;"><%=taxi.getModello()%></td>
  				<td style="text-align:center;"><%=taxi.getTarga()%></td>
  				<td style="text-align:center;"><%=taxi.getAnnoDiImmatricolazione()%></td>
  	  			<td style="text-align:center;"><%=taxi.getPosti()%></td>
  		 		<td style="text-align:center;"><%=taxi.getPrezzoPerKilometro() %></td>
  		 		<td style="text-align:center;"><%if (taxi.getAutista().getId()!=0) {%> <%=taxi.getAutista().getNome() + " " + taxi.getAutista().getCognome()%><%}%></td>
  		 		<td style="text-align:center;">
  		 		<form method="POST" action="deleteTaxi">
					  <input type="hidden" name="id" value="<%=taxi.getId()%>">
					  <input type="submit" value="Cancella">
	 			</form>
	 			</td>
	 			<td style="text-align:center;">
	 			<form method="POST" action="statisticheTaxi">
					  <input type="hidden" name="id" value="<%=taxi.getId()%>">
					  <input type="submit" value="Statistiche">
	 			</form>
	 			</td>
  			</tr>
  		<%}%>
</table>
</body>
</html>