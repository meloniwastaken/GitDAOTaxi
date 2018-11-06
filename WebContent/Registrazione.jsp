<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="ats.modello.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione utente</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
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



</style>

<body>
<h1><center>Registrazione Utente</center></h1>

<% Map<String,Boolean> errorMap = (Map<String,Boolean>)request.getAttribute("errorMap");
Utente u = (Utente)request.getAttribute("utente");
%>

<%-- <div class="container">
	<form method="POST" action="register">
		<div class="form-row">
			<div class="form-group col-md-6">
				<table>
					<tbody>
							<tr>
								<td><label for="nome">Nome: </label></td>
								<td><input type="text" id="nome" name="nome"/> </td>
								<td><%if(errorMap!=null && errorMap.get("nome")!=null) {%><div style="color:red">Errore nome</div><%}%></td>
							</tr>
							
							<tr>
								<td><label for="cognome">Cognome: </label></td>
								<td><input type="text" id="cognome" name="cognome"/></td>
								<td><%if(errorMap!=null && errorMap.get("cognome")!=null) {%><div style="color:red">Errore cognome</div><%}%></td>
							</tr>
							
							<tr>
								<td><label for="codFiscale">Codice Fiscale: </label></td>
								<td><input type="text" id="codFiscale" name="codFiscale"/></td>
								<td><%if(errorMap!=null && errorMap.get("codFiscale")!=null) {%><div style="color:red">Errore codice fiscale</div><%}%></td>
								
							</tr>
							
							<tr>
								<td><label for="data">Data di nascita: </label></td>
								<td><input type="date" id="data" name="data" min="1920-01-01" max="2000-12-31" /> </td>
							</tr>
							
							<tr>
								<td><label for="indirizzo">Indirizzo: </label></td>
								<td><input type="text" id="indirizzo" name="indirizzo"/></td>
								<td><%if(errorMap!=null && errorMap.get("indirizzo")!=null) {%><div style="color:red">Errore indirizzo</div><%}%></td>
							</tr>
							
							<tr>
								
								<td><label for="telefono">Telefono: </label></td>
								<td><input type="text" id="telefono" name="telefono"/></td>
								<td><%if(errorMap!=null && errorMap.get("telefono")!=null) {%><div style="color:red">Errore telefono</div><%}%></td>
							</tr>
							<tr>
								<td>
								<label for="email">E-mail: </label></td>
								<td><input type="text" id="email" name="email"/></td>
								<td><%if(errorMap!=null && errorMap.get("email")!=null) {%><div style="color:red">Errore e-mail</div><%}%></td>
							</tr>
							<tr>
								<td>
								<label for="username">Username: </label></td>
								<td><input type="text" id="username" name="username"/></td>
								<td><%if(errorMap!=null && errorMap.get("username")!=null) {%><div style="color:red">Errore username</div><%}%></td>
							</tr>
							<tr>
								<td>
								<label for="password">Password: </label></td>
								<td><input type="password" id="password" name="password"/></td>
								<td><%if(errorMap!=null && errorMap.get("password")!=null) {%><div style="color:red">Errore password</div><%}%></td>
							</tr>
							<tr>
								<td>
								<label for="password2">Conferma Password: </label></td>
								<td><input type="password" id="password2" name="password2"/></td>
								<td><%if(errorMap!=null && errorMap.get("password2")!=null) {%><div style="color:red">Le password non sono uguali</div><%}%></td>
							</tr>					
					</tbody>
				</table>		
			<br>
			<input type="hidden" name="from" value="Registrazione.jsp">
			<input type="submit" value="REGISTRA"/>
			</div>
		</div>
	</form>
	<form action="index.html">
	<input type="submit" value="HOME"/>
	</form>
</div> --%>


<div class="container">
	<form method="POST" action="register">
	<div class="row">
		<div class="col-md-8 col-md-offset-2"> 
    		<div class="col-md-6 mb-3">
      			<label for="validationServer02">Nome</label>
      			<%if(errorMap!=null && errorMap.get("nome")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getNome() %>"<%} %> name="nome">
      				<div class="invalid-feedback">
       			 	Errore nome
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getNome() %>"<%} %> name="nome">
      			<%} %>
    		</div>
    		
    		<div class="col-md-6 mb-3">
      			<label for="validationServer02">Cognome</label>
      			<%if(errorMap!=null && errorMap.get("cognome")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getCognome() %>"<%} %> name="cognome">
      				<div class="invalid-feedback">
        			Errore cognome
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getCognome() %>"<%} %> name="cognome">
      			<%} %>    		
    		</div>    
    	</div>    
    </div>
    
    <br><br>
    
    <div class="row">
		<div class="col-md-8 col-md-offset-2">    
    		<div class="col-md-6 mb-3">
      			<label for="validationServer03">Data di nascita</label>
      			<input type="date" class="form-control is-valid" id="data" name="data" min="1920-01-01" max="2000-12-31">      				
    		</div>    
    		<div class="col-md-6 mb-3">
      			<label for="validationServer04">Codice Fiscale</label>
      			<%if(errorMap!=null && errorMap.get("codFiscale")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getCodiceFiscale() %>"<%} %> name="codFiscale">
      				<div class="invalid-feedback">
        			Errore codice fiscale
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getCodiceFiscale() %>"<%} %> name="codFiscale">
      			<%} %>   
      		</div>    		   
    	</div>
    </div>
    
    <br><br>
    
    <div class="row">
		<div class="col-md-8 col-md-offset-2">   
    		<div class="col-md-6 mb-3">
      			<label for="validationServer05">Indirizzo</label>
      			<%if(errorMap!=null && errorMap.get("indirizzo")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getIndirizzo() %>"<%} %> name="indirizzo">
      				<div class="invalid-feedback">
        			Errore indirizzo
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getIndirizzo() %>"<%} %> name="indirizzo">
      			<%} %>   
      		</div>
    
    		<div class="col-md-6 mb-3">
      			<label for="validationServer06">Telefono</label>
      			<%if(errorMap!=null && errorMap.get("telefono")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getTelefono() %>"<%} %> name="telefono">
      				<div class="invalid-feedback">
        			Errore telefono
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getTelefono() %>"<%} %> name="telefono">
      			<%} %> 
      		</div>    		    
    	</div>
    </div>
    
    <br><br>
    
    
    <div class="row">
		<div class="col-md-8 col-md-offset-2">   
    		<div class="col-md-6 mb-3">
      			<label for="validationServer07">E-mail</label>
      			<%if(errorMap!=null && errorMap.get("email")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getEmail() %>"<%} %> name="email">
      				<div class="invalid-feedback">
        			Errore e-mail
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getEmail() %>"<%} %> name="email">
      			<%} %> 
      		</div>
    		<div class="col-md-6 mb-3">
      			<label for="validationServerUsername">Username</label>
      			<%if(errorMap!=null && errorMap.get("username")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getUsername() %>"<%} %> name="username">
      				<div class="invalid-feedback">
        			Errore username
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getUsername() %>"<%} %> name="username">
      			<%} %> 
      		</div>
    	</div>    
    </div>
           
    <br><br>
           
    <div class="row">
		<div class="col-md-8 col-md-offset-2">    
    		<div class="col-md-6 mb-3">
      			<label for="validationServer08">Password</label>
      			<%if(errorMap!=null && errorMap.get("password")!=null) {%>
      			<input type="password" class="form-control is-invalid" id="password" name="password">
      				<div class="invalid-feedback">
        			Errore password
      				</div>
      			<%}else {%>
      			<input type="password" class="form-control is-valid" id="password" name="password">
      			<%} %> 
    		</div>
    		<div class="col-md-6 mb-3">
      			<label for="validationServer09">Conferma Password</label>
      			<%if(errorMap!=null && errorMap.get("password2")!=null) {%>
      			<input type="password" class="form-control is-invalid" id="password2" name="password2">
      				<div class="invalid-feedback">
        			Le password non sono uguali
      				</div>
      			<%}else {%>
      			<input type="password" class="form-control is-valid" id="password2" name="password2">
      			<%} %> 
    		</div>  
  		</div>
  	</div>
  
  <br><br>
  
  	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			
			<div class="col-md-6 mb-3">			
  			<button class="btn btn-primary" type="submit">Conferma</button>
  			</div>
  			</div>
  			</div>  			
  			
  		<input type="hidden" name="from" value="Registrazione.jsp">	
	</form>
</div>
<br><br>
</body>
</html>