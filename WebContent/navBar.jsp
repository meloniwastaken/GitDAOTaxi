<style>
.btn_href{
     border:none; 
     font: inherit;         
     cursor: pointer;     
     display: block;
     padding: 3px 20px;
     clear: both;
     font-weight: 400;
     line-height: 1.42857143;
     color: #ffff;
     white-space: nowrap;
}


.btn_href:hover{
    color: #ffff;
    text-decoration: none;
    background-color: #080808;
    
}


.dropdown-menu {
      background-color: #333;
}

.dropdown-menu>li>a {
    background-color: #333;
    color: #ffffff;
}

.dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover {
    color: #ffff;
    background-color: #080808;
</style>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
    	<div class="navbar-header">
      		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        	<span class="sr-only">Toggle navigation</span>
	        	<span class="icon-bar"></span>
	        	<span class="icon-bar"></span>
	        	<span class="icon-bar"></span>
      		</button>
      		<a class="navbar-brand" href="/GitDAOTaxi/index.html">DAOTaxi</a>
    	</div>
    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-left">
		       	<li>
		    		<form method="POST" action="/GitDAOTaxi/visualizzaViaggi">
						<input type="hidden" name="id" value="<%=request.getSession().getAttribute("id")%>"/>
						<button class="btn btn-primary navbar-btn" type="submit">Visualizza Viaggi</button>
					</form>
		    	</li>
		    	<li>&nbsp;</li>
    			 <%if((Integer) request.getSession().getAttribute("ruolo")==1) {%>
				<li>
          			<button type="button" class="btn btn-warning dropdown-toggle navbar-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    					Elenchi <span class="caret"></span>
    				</button>
        			<ul class="dropdown-menu">
           				<li><a href="/GitDAOTaxi/admin/findAll">Elenco Utenti</a></li>
           				<li><a href="/GitDAOTaxi/wadmin/findAllAmministratori">Elenco Amministratori</a></li>
           				<li><a href="/GitDAOTaxi/admin/findAllClienti">Elenco Clienti</a></li>
           				<li><a href="/GitDAOTaxi/admin/findAllAutisti">Elenco Autisti</a></li>
           				<li><a href="/GitDAOTaxi/admin/findAllTaxi">Elenco Taxi</a></li>
           			</ul>
        		</li>
    			<li>&nbsp;</li>
    	 		<li>
          			<button type="button" class="btn btn-warning dropdown-toggle navbar-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    					Aggiungi <span class="caret"></span>
    				</button>
	         		<ul class="dropdown-menu">
			            <li>
				           	<form method="POST" action="/GitDAOTaxi/admin/formRegistrazioneAutista" id="idForm1">
							 	<a href="#" class="btn_href" onclick="document.getElementById('idForm1').submit();">Aggiungi Autista</a>
							</form>   
			            <li>
			            	<a href="/GitDAOTaxi/admin/inserisciTaxi.jsp">Aggiungi Taxi</a>
			            </li>
		          	</ul>
	        	</li>
        		<%} if((Integer) request.getSession().getAttribute("ruolo")==3) {%>
       			<li>&nbsp;</li>
		       	<li>
		    		<form method="POST" action="/GitDAOTaxi/cliente/formPrenotazione">
						<input type="hidden" name="id" value="<%=request.getSession().getAttribute("id")%>"/>
						<button class="btn btn-success navbar-btn" type="submit">Prenota Viaggio</button>
					</form>
		    	</li>
        		<%} %>  
      		</ul>      
    		<ul class="nav navbar-nav navbar-right">
        		<li class="active">
        			<a href="#"><%=request.getSession().getAttribute("nomeUtente") %>
        				<span class="sr-only">(current)</span>
        			</a>
        		</li>
        		<li class="dropdown">
          			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Menu
          				<span class="caret"></span>
          			</a>
         			 <ul class="dropdown-menu">
	            		<li><a href="/GitDAOTaxi/profile">Profilo</a></li>
	            		<li>
	            			<form method="POST" action="/GitDAOTaxi/formUpdate" id="idForm2">
								<input type="hidden" name="id" value="<%=request.getSession().getAttribute("id")%>"/>
								<a href="#" class="btn_href" onclick="document.getElementById('idForm2').submit();">Modifica Account</a>
							</form>            
	           			</li>
	            		<li role="separator" class="divider"></li>
	            		<li><a href="/GitDAOTaxi/logout">Logout</a></li>
          			</ul>
        		</li>
      		</ul>    
    	</div>
  	</div>
</nav>