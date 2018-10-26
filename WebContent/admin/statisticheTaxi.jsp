<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Taxi t = (Taxi) request.getAttribute("taxi"); 
  List<Double> statistiche = (List<Double>) request.getAttribute("statistiche");%>
	<table>
		<tr><th>Marca</th><td><%=t.getMarca()%></td></tr>
		<tr><th>Modello</th><td><%=t.getModello()%></td></tr>
		<tr><th>Targa</th><td><%=t.getTarga()%></td></tr>
		<tr><th>Anno Immatricolazione</th><td><%=t.getAnnoDiImmatricolazione()%></td></tr>
		<tr><th>Posti</th><td><%=t.getPosti()%></td></tr>
		<tr><th>€/Km</th><td><%=t.getPrezzoPerKilometro()%></td></tr>
		<%if(statistiche!=null || !statistiche.isEmpty()) {%>
			<tr><th>Totale viaggi</th><td><%=statistiche.get(0)%></td></tr>
			<tr><th>Totale kilometri</th><td><%=statistiche.get(1)%></td></tr>
		<%} %>

	</table>
</body>
</html>