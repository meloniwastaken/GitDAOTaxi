<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ats.modello.Taxi" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prenotazione</title>
</head>
<body>
<%List<Taxi> lista = (List<Taxi>)request.getAttribute("taxi"); %>
<h1><center>Prenotazione viaggio</center></h1>
<form method="POST" action="preventivo">
<table>

	<tbody>
		
		<tr>
			<td><label for="data">Data di partenza: </label></td>
			<td><input type="date" id="data" name="data"> </td>
		</tr>
		
		<tr>
			<td><label for="time">Orario di partenza: </label></td>
			<td><input type="time" id="time" name="time"></td>	
		
		</tr>
	
	
	
		<tr>
			<td><label for="partenza">Partenza: </label></td>
			<td><input type="text" id="partenza" name="partenza"></td>			
		</tr>
		
		<tr>
			<td><label for="destinazione">Destinazione: </label></td>
			<td><input type="text" id="destinazione" name="destinazione"></td>
		</tr>
		
		<tr>
			<td><label for="kilometri">Kilometri: </label></td>
			<td><input type="text" id="kilometri" name="kilometri"></td>
		</tr>
		
		<tr>
			<td><label for="taxi">Seleziona taxi: </label>
			<td><select id="taxi" name="taxi">
			<%for (Taxi t:lista) {%>
			<option value="<%=t.getId() %>"><%=t.getMarca()%>, <%=t.getModello()%>, <%=t.getPosti()%> posti, <%=t.getPrezzoPerKilometro()%> €/km </option><%} %>			
			</select>			
			<td>
			
		</tr>
		
				
				
	
	</tbody>
	

</table>
<input type="submit" value="PRENOTA">
</form>	
</body>
</html>