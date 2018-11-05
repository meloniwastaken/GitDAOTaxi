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
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
</head>
<body background="img/bg.jpg">

	<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">DAOTaxi</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
    <ul class="nav navbar-nav navbar-left">
    
    
       	<li>
    		<form method="POST" action="visualizzaViaggi">
				<input type="hidden" name="id" value="<%=request.getSession().getAttribute("id")%>"/>
				<button class="btn btn-primary navbar-btn" type="submit">Visualizza Viaggi</button>
			</form>
    	</li>
    	<li>&nbsp;</li>
    	
    <%if((Integer) request.getSession().getAttribute("ruolo")==1) {%>
    
    	 <li>
          <button type="button" class="btn btn-warning dropdown-toggle navbar-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    	Elenchi <span class="caret"></span></button>
          <ul class="dropdown-menu">
            <li><a href="/GitDAOTaxi/admin/findAll">Tutti gli utenti</a></li>
            <li><a href="/GitDAOTaxi/admin/findAllAutisti">Elenco Autisti</a></li>
            <li><a href="/GitDAOTaxi/admin/findAllAutisti">Elenco Utenti</a></li>
            <li><a href="admin/findAllTaxi">Elenco Taxi</a></li>
          </ul>
        </li>
        
        <li>&nbsp;</li>
    	 <li>
          <button type="button" class="btn btn-warning dropdown-toggle navbar-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    	Aggiungi <span class="caret"></span></button>
          <ul class="dropdown-menu">
             <li>
           	 <form method="POST" action="admin/formRegistrazioneAutista">
			 	<button class="btn btn-default navbar-btn" type="submit">Aggiungi Autista</button>
			</form>   
            <li><a href="/GitDAOTaxi/admin/inserisciTaxi.jsp">Aggiungi Taxi</a></li>
          </ul>
        </li>
        
        <%} if((Integer) request.getSession().getAttribute("ruolo")==3) {%>
       <li>&nbsp;</li>
       	<li>
    		<form method="POST" action="cliente/formPrenotazione">
				<input type="hidden" name="id" value="<%=request.getSession().getAttribute("id")%>"/>
				<button class="btn btn-success navbar-btn" type="submit">Prenota Viaggio</button>
			</form>
    	</li>
        <%} %>  
      </ul>      
    
    
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="#"><%=request.getSession().getAttribute("nomeUtente") %><span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Menu <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="profile">Profilo</a></li>
            <li>
            <form method="POST" action="formUpdate">
				<input type="hidden" name="id" value="<%=request.getSession().getAttribute("id")%>"/>
				<button class="btn btn-default navbar-btn" type="submit">Modifica Account</button>
			</form>            
            </li>
            <li role="separator" class="divider"></li>
            <li><a href="logout">Logout</a></li>
          </ul>
        </li>
      </ul>    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

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
	
	
	
	<div class="container first">
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>