<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi taxi</title>
</head>
<body>
<h1><center>Inserisci Taxi</center></h1>
<%Map<String,Boolean> errorMap = (Map<String,Boolean>)request.getAttribute("errorMap");%>
<form method="POST" action="inserisciTaxi">
<table>
	<tbody>
		<tr>
			<td><label for="marca">Marca: </label></td>
			<td><input type="text" id="marca" name="marca"></td>
			<td><%if(errorMap!=null && errorMap.get("marca")!=null) {%><div style="color:red">Errore marca</div><%}%></td>
		</tr>
		
		<tr>
			<td><label for="modello">Modello: </label></td>
			<td><input type="text" id="modello" name="modello"></td>
			<td><%if(errorMap!=null && errorMap.get("modello")!=null) {%><div style="color:red">Errore modello</div><%}%></td>
		</tr>
		
		<tr>
			<td><label for="targa">Targa: </label></td>
			<td><input type="text" id="targa" name="targa"></td>
			<td><%if(errorMap!=null && errorMap.get("targa")!=null) {%><div style="color:red">Errore targa</div><%}%></td>
		</tr>
		
		<tr>
			<td><label for="annoImmatricolazione">Anno di immatricolazione: </label></td>
			<td><input type="text" id="annoImmatricolazione" name="annoImmatricolazione"></td>
			<td><%if(errorMap!=null && errorMap.get("annoImmatricolazione")!=null) {%><div style="color:red">Errore anno di immatricolazione</div><%}%></td>
		</tr>
		
		<tr>
			<td><label for="posti">Posti: </label></td>
			<td><input type="text" id="posti" name="posti"></td>
			<td><%if(errorMap!=null && errorMap.get("posti")!=null) {%><div style="color:red">Errore numero posti</div><%}%></td>
		</tr>
		
		<tr>
			<td><label for="prezzoPerKilometro">Prezzo/kilometro: </label></td>
			<td><input type="text" id="prezzoPerKilometro" name="prezzoPerKilometro"></td>
			<td><%if(errorMap!=null && errorMap.get("prezzoPerKilometro")!=null) {%><div style="color:red">Errore prezzo/kilometro</div><%}%></td>
		</tr>
		
		
		
		
	</tbody>
</table>
<input type="submit" value="INSERISCI">
</form>


</body>
</html>