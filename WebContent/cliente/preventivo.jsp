<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ats.modello.Viaggio" %>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<link rel="stylesheet" href="../css/style.css">
		<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Preventivo</title>
</head>
	<body background="../img/bg.jpg">
		<jsp:include page="../navBar.jsp"/>
<% Viaggio v = (Viaggio) request.getSession().getAttribute("viaggio");
DecimalFormat f = new DecimalFormat("##.00");
SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
%>
<div class="container">
<h1 class="first"><%=v.getPartenza()%>-<%=v.getDestinazione()%></h1>
<div class="row">
	<div class="col-md-6">
	<div class="panel panel-default">
		<div class="panel-body">
		<div class="row"><h2>Autista</h2></div>
		<div class="row">
			<div class="col-xs-4 col-xs-offset-1 label">
				Nome
			</div>
			<div class="col-xs-4 col-xs-offset-1">
				<%=v.getAutista().getNome()%>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 col-xs-offset-1 label">
				Cognome
			</div>
			<div class="col-xs-4 col-xs-offset-1">
				<%=v.getAutista().getCognome()%>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 col-xs-offset-1 label">
				Telefono
			</div>
			<div class="col-xs-4 col-xs-offset-1">
				<%=v.getAutista().getTelefono()%>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 col-xs-offset-1 label">
				Email
			</div>
			<div class="col-xs-4 col-xs-offset-1">
				<%=v.getAutista().getEmail()%>
			</div>
		</div>
	</div>
	</div>
	</div>
	<div class="col-md-6">
	<div class="panel panel-default">
	<div class="panel-body">
		<div class="row"><h2>Taxi</h2></div>
		<div class="row">
			<div class="col-xs-4 col-xs-offset-1 label">
				Marca
			</div>
			<div class="col-xs-4 col-xs-offset-1">
				<%=v.getTaxi().getMarca()%>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 col-xs-offset-1 label">
				Modello
			</div>
			<div class="col-xs-4 col-xs-offset-1">
				<%=v.getTaxi().getModello()%>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 col-xs-offset-1 label">
				Posti
			</div>
			<div class="col-xs-4 col-xs-offset-1">
				<%=v.getTaxi().getPosti()%>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 col-xs-offset-1 label">
				€/Km
			</div>
			<div class="col-xs-4 col-xs-offset-1">
				<%=v.getTaxi().getPrezzoPerKilometro()%>
			</div>
		</div>
	</div>
	</div>
	</div>
</div>
<div class="panel panel-default">
<div class="panel-body">
<div class="row"><h2>Preventivo</h2></div>
<div class="row">
	<div class="col-xs-4 col-xs-offset-1 label">
		Partenza
	</div>
	<div class="col-xs-4 col-xs-offset-1">
		<%=v.getPartenza()%>
	</div>
</div>
<div class="row">
	<div class="col-xs-4 col-xs-offset-1 label">
		Destinazione
	</div>
	<div class="col-xs-4 col-xs-offset-1">
		<%=v.getDestinazione()%>
	</div>
</div>
<div class="row">
	<div class="col-xs-4 col-xs-offset-1 label">
		Kilometri
	</div>
	<div class="col-xs-4 col-xs-offset-1">
		<%=v.getKilometri()%>
	</div>
</div>
<div class="row">
	<div class="col-xs-4 col-xs-offset-1 label">
		Data
	</div>
	<div class="col-xs-4 col-xs-offset-1">
		<%=dateFormat.format(v.getData())+" alle ore "+hourFormat.format(v.getData())%>
	</div>
</div>
<div class="row">
	<div class="col-xs-4 col-xs-offset-1 label">
		Prezzo
	</div>
	<div class="col-xs-4 col-xs-offset-1">
		<%=v.getPrezzo()%>
	</div>
</div>
<div class="row">
	<div class="col-xs-6">
		<form method="POST" action="prenota">
			<button type="submit" class="btn btn-success btn-center">Conferma</button>
		</form>
	</div>
	<div class="col-xs-6">
		<form action="/GitDAOTaxi/profile">
			<button type="submit" class="btn btn-danger btn-center">Annulla</button>
		</form>
	</div>
</div>
</div>
</div>
</div>
</body>
</html>