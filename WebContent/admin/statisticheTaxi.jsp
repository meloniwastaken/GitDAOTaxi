<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
<meta charset="ISO-8859-1">
<title>Statistiche</title>
</head>
<body background="../img/bg.jpg">
	<jsp:include page="../navBar.jsp"/>
<%Taxi t = (Taxi) request.getAttribute("taxi"); 
  List<Double> statistiche = (List<Double>) request.getAttribute("statistiche");%>
  
  <h1 class="first">Statistiche Taxi</h1>
  
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-body">
		<div class="row"><div class="col-md-4 label">Marca</div>	 <div class="col-md-4 col-md-offset-2"><%=t.getMarca()%></div>	</div>
		<div class="row"><div class="col-md-4 label">Modello</div>	 <div class="col-md-4 col-md-offset-2"><%=t.getModello()%></div>	</div>
		<div class="row"><div class="col-md-4 label">Targa</div>	 <div class="col-md-4 col-md-offset-2"><%=t.getTarga()%></div>	</div>
		<div class="row"><div class="col-md-4 label">Anno Immatricolazione</div>	 <div class="col-md-4 col-md-offset-2"><%=t.getAnnoDiImmatricolazione()%></div>	</div>
		<div class="row"><div class="col-md-4 label">Posti</div>	 <div class="col-md-4 col-md-offset-2"><%=t.getPosti()%></div>	</div>
		<div class="row"><div class="col-md-4 label">€/Km</div>	 <div class="col-md-4 col-md-offset-2"><%=t.getPrezzoPerKilometro()%></div>	</div>
	<%if(statistiche!=null && !statistiche.isEmpty()) {%>
		<div class="row"><div class="col-md-4 label">Totale viaggi</div>	 <div class="col-md-4 col-md-offset-2"><%=statistiche.get(0)%></div>	</div>
		<div class="row"><div class="col-md-4 label">Totale kilometri</div>	 <div class="col-md-4 col-md-offset-2"><%=statistiche.get(1)%></div>	</div>
	<%} %>
	</div></div></div></div></div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	
</body>
</html>