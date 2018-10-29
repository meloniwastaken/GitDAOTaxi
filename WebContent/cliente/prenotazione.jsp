<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prenotazione</title>
</head>
<body>
<%List<Taxi> lista = (List<Taxi>)request.getAttribute("taxi"); 
Map<String,Boolean> errorMap = (Map<String,Boolean>)request.getAttribute("errorMap");
Date data = new Date();
Integer gg=data.getDate();
Integer mm=data.getMonth()+1;
Integer aa=data.getYear()+1900;
String giorno=gg.toString();
String mese=mm.toString();
String anno=aa.toString();
String start = anno + "-" + mese + "-" + giorno;
;
%>
<h1><center>Prenotazione viaggio</center></h1>
<form method="POST" action="preventivo">
<table>

	<tbody>
		
		<tr>
			<td><label for="data">Data di partenza: </label></td>
			<td><input type="date" id="data" name="data" min="<%=start%>"> </td>
		</tr>
		
		<tr>
			<td><label for="time">Orario di partenza: </label></td>
			<td><input type="time" id="time" name="time"></td>	
		
		</tr>
	
	
	
		<tr>
			<td><label for="partenza">Partenza: </label></td>
			<td><input type="text" id="partenza" name="partenza"></td>
			<td><%if(errorMap!=null && errorMap.get("partenza")!=null) {%><div style="color:red">Errore partenza</div><%}%></td>			
		</tr>
		
		<tr>
			<td><label for="destinazione">Destinazione: </label></td>
			<td><input type="text" id="destinazione" name="destinazione"></td>
			<td><%if(errorMap!=null && errorMap.get("destinazione")!=null) {%><div style="color:red">Errore destinazione</div><%}%></td>
		</tr>
		
		<tr>
			<td><label for="kilometri">Kilometri: </label></td>
			<td><input type="text" id="kilometri" name="kilometri"></td>
			<td><%if(errorMap!=null && errorMap.get("kilometri")!=null) {%><div style="color:red">Errore kilometri</div><%}%></td>
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