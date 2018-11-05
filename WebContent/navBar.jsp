<script src="js/bootstrap.min.js"></script>
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