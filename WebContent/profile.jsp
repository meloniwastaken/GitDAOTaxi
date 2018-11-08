<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ats.modello.Amministratore"%>
<%@ page import="ats.modello.Cliente"%>
<%@ page import="ats.modello.Autista"%>
<%@ page import="ats.modello.Utente"%>

<!DOCTYPE html>

<html>
	<head>
		<title>Profilo</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/style.css">
		<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
		<meta charset="ISO-8859-1">
	</head>
	<body background="img/bg.jpg">
		<jsp:include page="navBar.jsp"/>
		<%
			Utente utente = null;
			Double stipendio = null;
			if(request.getAttribute("admin")!=null) {
				utente = (Amministratore) request.getAttribute("admin");
			}
			else if(request.getAttribute("autista")!=null) {
				utente = (Autista) request.getAttribute("autista");
				stipendio = ((Autista) request.getAttribute("autista")).getStipendio();
			}
			else {
				utente = (Cliente) request.getAttribute("cliente");
			}
		%>
		<div class="container-fluid first">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row"><div class="col-xs-4 col-xs-offset-1 label">Nome:</div><div class="col-xs-6 content"><%=utente.getNome()%></div></div>
							<div class="row"><div class="col-xs-4 col-xs-offset-1 label">Cognome:</div><div class="col-xs-6 content"><%=utente.getCognome()%></div></div>
							<div class="row"><div class="col-xs-4 col-xs-offset-1 label">Codice fiscale:</div><div class="col-xs-6 content"><%=utente.getCodiceFiscale()%></div></div>
							<div class="row"><div class="col-xs-4 col-xs-offset-1 label">Data di nascita:</div><div class="col-xs-6 content"><%=utente.getDataDiNascita()%></div></div>
							<div class="row"><div class="col-xs-4 col-xs-offset-1 label">Indirizzo:</div><div class="col-xs-6 content"><%=utente.getIndirizzo()%></div></div>
							<div class="row"><div class="col-xs-4 col-xs-offset-1 label">Telefono:</div><div class="col-xs-6 content"><%=utente.getTelefono()%></div></div>
							<div class="row"><div class="col-xs-4 col-xs-offset-1 label">Email:</div><div class="col-xs-6 content"><%=utente.getEmail()%></div></div>
							<%if(stipendio!=null) {%>
							<div class="row"><div class="col-xs-4 col-xs-offset-1 label">Stipendio:</div><div class="col-xs-6 content"><%=stipendio%> €</div></div>
							<%}%>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%if(request.getSession().getAttribute("messaggio")!=null) {%>
		<div class="container first">
			<div class="row">
				<div class="col-xs-4 col-xs-offset-4 label">
					<div class="panel panel-default">
						<div class="panel-body">
							<p><%out.print((String) request.getSession().getAttribute("messaggio"));%></p>
							   <%request.getSession().removeAttribute("messaggio");%>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%}%>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>