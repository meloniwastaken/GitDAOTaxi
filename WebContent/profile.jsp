<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ats.modello.Amministratore" %>
<%@ page import="ats.modello.Cliente" %>
<%@ page import="ats.modello.Autista" %>
<%@ page import="ats.modello.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROFILO</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/bootstrap.min.js"></script>
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
</head>
<body background="img/bg.jpg">
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
	
	<%=request.getSession().getAttribute("id")%> <br>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-body">
								<div class="row"><div class="col-md-4 label">Nome:</div><div class="col-md-4 col-md-offset-2"><%=utente.getNome()%></div></div>
								<div class="row"><div class="col-md-4 label">Cognome:</div><div class="col-md-4 col-md-offset-2"><%=utente.getCognome()%></div></div>
								<div class="row"><div class="col-md-4 label">Codice fiscale:</div><div class="col-md-4 col-md-offset-2"><%=utente.getCodiceFiscale()%></div></div>
								<div class="row"><div class="col-md-4 label">Data di nascita:</div><div class="col-md-4 col-md-offset-2"><%=utente.getDataDiNascita()%></div></div>
								<div class="row"><div class="col-md-4 label">Indirizzo:</div><div class="col-md-4 col-md-offset-2"><%=utente.getIndirizzo()%></div></div>
								<div class="row"><div class="col-md-4 label">Telefono:</div><div class="col-md-4 col-md-offset-2"><%=utente.getTelefono()%></div></div>
								<div class="row"><div class="col-md-4 label">Email:</div><div class="col-md-4 col-md-offset-2"><%=utente.getEmail()%></div></div>
								<%if(stipendio!=null) {%>
									<div class="row"><div class="col-md-4 label">Stipendio:</div><div class="col-md-4 col-md-offset-2"><%=stipendio%> €</div></div>
								<%} %>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>