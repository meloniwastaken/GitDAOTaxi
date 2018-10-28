<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi taxi</title>
</head>
<body>
<h1><center>Inserisci Taxi</center></h1>
<form method="POST" action="inserisciTaxi">
<table>
	<tbody>
		<tr>
			<td><label for="marca">Marca: </label></td>
			<td><input type="text" id="marca" name="marca"></td>
		</tr>
		
		<tr>
			<td><label for="modello">Modello: </label></td>
			<td><input type="text" id="modello" name="modello"></td>
		</tr>
		
		<tr>
			<td><label for="targa">Targa: </label></td>
			<td><input type="text" id="targa" name="targa"></td>
		</tr>
		
		<tr>
			<td><label for="annoImmatricolazione">Anno di immatricolazione: </label></td>
			<td><input type="text" id="annoImmatricolazione" name="annoImmatricolazione"></td>
		</tr>
		
		<tr>
			<td><label for="posti">Posti: </label></td>
			<td><input type="text" id="posti" name="posti"></td>
		</tr>
		
		<tr>
			<td><label for="prezzoPerKilometro">Prezzo/kilometro: </label></td>
			<td><input type="text" id="prezzoPerKilometro" name="prezzoPerKilometro"></td>
		</tr>
		
		
		
		
	</tbody>
</table>
<input type="submit" value="INSERISCI">
</form>


</body>
</html>