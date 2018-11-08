<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="ats.modello.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica utente</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
</head>
<style>
.invalid-feedback {
    width: 100%;
    margin-top: .25rem;
    font-size: 80%;
    color: #dc3545;
}

.form-control.is-invalid {
    border-color: #dc3545;
}

.form-control.is-valid {
    border-color: #28a745;
}

.a_button {
	color: #fff;
    text-decoration: none;

}

.a_button:hover {
	color: #ffff;
	text-decoration: none;
}

</style>
<body background="img/bg.jpg">
<jsp:include page="navBar.jsp"></jsp:include>
<% Map<String,String> errorMap = (Map<String,String>)request.getAttribute("errorMap");%>
<% Utente u = (Utente)request.getAttribute("utenteUpdate");
String data ="";
if (u!=null && u.getDataDiNascita()!=null) {
Integer gg = u.getDataDiNascita().getDate();
Integer mm = u.getDataDiNascita().getMonth() + 1;
Integer yyyy = u.getDataDiNascita().getYear() + 1900;      				

String giorno = gg.toString();
String mese = mm.toString();
String anno = yyyy.toString();
	
if (gg < 10)
	giorno = "0" + giorno;
if (mm < 10)
	mese = "0" + mese;
	
data = anno+"-"+mese+"-"+giorno;  }
%>

<div class="container">
<div class="row">
<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
	<h1 class="text-center">Modifica Account</h1>
	<div class="panel panel-default">
	<div class="panel-body">
	<form method="POST" action="update">
	<div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer02">Nome</label>
      			<%if(errorMap!=null && errorMap.get("nome")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getNome() %>"<%} %> name="nome">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("nome")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getNome() %>"<%} %> name="nome">
      			<%} %>
    		</div>    		
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServer02">Cognome</label>
      			<%if(errorMap!=null && errorMap.get("cognome")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getCognome() %>"<%} %> name="cognome">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("cognome")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getCognome() %>"<%} %> name="cognome">
      			<%} %>
    		</div>
    </div>
    
    <br><br>
    
    <div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">    
      			<label for="validationServer03">Data di nascita</label>
      			<%if (errorMap!=null && errorMap.get("data")!=null) {%>
      			<input type="date" class="form-control is-invalid" name="data" min="1920-01-01" max="2000-12-31" <%if (u!=null){ %> value="<%=data %>"<%} %>>      				
    			<div class="invalid-feedback">
       			 	<%=errorMap.get("data")%>
      			</div>
      			<%}else {%>
      			<input type="date" class="form-control is-valid" <%if (u!=null){ %> min="1920-01-01" max="2000-12-31" value="<%=data%>"<%} %> name="data">
      			<%} %>
    		
    		</div>    		    
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServer04">Codice Fiscale</label>
      			<%if(errorMap!=null && errorMap.get("codFiscale")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getCodiceFiscale() %>"<%} %> name="codFiscale">
      				<div class="invalid-feedback">
        			<%=errorMap.get("codFiscale")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getCodiceFiscale() %>"<%} %> name="codFiscale">
      			<%} %>   
      		</div>    		   
    </div>
    
    <br><br>
    
    <div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer02">Indirizzo</label>
      			<%if(errorMap!=null && errorMap.get("indirizzo")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getIndirizzo() %>"<%} %> name="indirizzo">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("indirizzo")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getIndirizzo() %>"<%} %> name="indirizzo">
      			<%} %>
    		</div>    	
    
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServer06">Telefono</label>
      			<%if(errorMap!=null && errorMap.get("telefono")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getTelefono() %>"<%} %> name="telefono">
      				<div class="invalid-feedback">
        			<%=errorMap.get("telefono")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getTelefono() %>"<%} %> name="telefono">
      			<%} %> 
      		</div>    		    
    </div>
    
    <br><br>
    
    
    <div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer02">E-mail</label>
      			<%if(errorMap!=null && errorMap.get("email")!=null) {%>
      			<input type="email" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getEmail() %>"<%} %> name="email">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("email")%>
      				</div>
      			<%}else {%>
      			<input type="email" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getEmail() %>"<%} %> name="email">
      			<%} %>
    		</div>    	
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServerUsername">Username</label>
      			<%if(errorMap!=null && errorMap.get("username")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getUsername() %>"<%} %> name="username">
      				<div class="invalid-feedback">
        			<%=errorMap.get("username")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getUsername() %>"<%} %> name="username">
      			<%} %> 
      		</div>
    </div>
           
    <br><br>
           
    <div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer08">Password</label>
      			<%if(errorMap!=null && errorMap.get("password")!=null) {%>
      			<input type="password" class="form-control is-invalid" id="password" name="password">
      				<div class="invalid-feedback">
        			<%=errorMap.get("password") %>
      				</div>
      			<%}else {%>
      			<input type="password" class="form-control is-valid" id="password" name="password">
      			<%} %> 
    		</div>
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServer09">Conferma Password</label>
      			<%if(errorMap!=null && errorMap.get("password2")!=null) {%>
      			<input type="password" class="form-control is-invalid" id="password2" name="password2">
      				<div class="invalid-feedback">
        			<%=errorMap.get("password2")%>
      				</div>
      			<%}else {%>
      			<input type="password" class="form-control is-valid" id="password2" name="password2">
      			<%}%> 
    		</div>  
  	</div>
  
  <br><br>
  
  	<div class="row">
		<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1">
			<div class="btn-toolbar pull-right" role="toolbar">
  				<div class="btn-group" role="group"><button class="btn btn-danger"><a class="a_button" href="profile">Annulla</a></button></div>
  				<div class="btn-group" role="group"><button class="btn btn-primary" type="submit">Conferma</button></div>
					
				</div>
  			</div>
  	</div>
  	
  		<input type="hidden" name="from" value="updateUtenteForm.jsp">
  		<input type="hidden" name="id" value="<%=u.getId()%>">  			
  	</form>
  			
						
  			
  	</div>
	</div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>