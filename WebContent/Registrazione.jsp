<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione utente</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
</head>
<body>
<h1><center>Registrazione Utente</center></h1>

<% Map<String,Boolean> errorMap = (Map<String,Boolean>)request.getAttribute("errorMap");%>

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
	<form>
	<div class="row">
		<div class="col-md-8 col-md-offset-2"> 
    		<div class="col-md-6 mb-3">
      			<label for="validationServer01">Nome</label>
      			<input type="text" class="form-control is-valid" id="nome" name="nome" required>
      				<div class="valid-feedback">
       			 		Looks good!
      				</div>
    		</div>
    		<div class="col-md-6 mb-3">
      			<label for="validationServer02">Cognome</label>
      			<input type="text" class="form-control is-valid" id="cognome" name="cognome" required>
      				<div class="valid-feedback">
        				Looks good!
      				</div>
    		</div>    
    	</div>    
    </div>
    
    <br><br>
    
    <div class="row">
		<div class="col-md-8 col-md-offset-2">    
    		<div class="col-md-6 mb-3">
      			<label for="validationServer03">Data di nascita</label>
      			<input type="date" class="form-control is-valid" id="data" name="data" min="1920-01-01" max="2000-12-31" required>
      				<div class="valid-feedback">
        				Looks good!
      				</div>
    		</div>    
    		<div class="col-md-6 mb-3">
      			<label for="validationServer04">Codice Fiscale</label>
      			<input type="text" class="form-control is-valid" id="codFiscale" name="codFiscale" required>
      				<div class="valid-feedback">
        				Looks good!
      				</div>
    		</div>    
    	</div>
    </div>
    
    <br><br>
    
    <div class="row">
		<div class="col-md-8 col-md-offset-2">   
    		<div class="col-md-6 mb-3">
      			<label for="validationServer05">Indirizzo</label>
      			<input type="text" class="form-control is-valid" id="indirizzo" name="indirizzo" required>
      				<div class="valid-feedback">
        				Looks good!
      				</div>
    		</div>
    		<div class="col-md-6 mb-3">
      			<label for="validationServer06">Telefono</label>
      			<input type="text" class="form-control is-valid" id="telefono" name="telefono" required>
      				<div class="valid-feedback">
        				Looks good!
      				</div>
    		</div>    
    	</div>
    </div>
    
    <br><br>
    
    
    <div class="row">
		<div class="col-md-8 col-md-offset-2">   
    		<div class="col-md-6 mb-3">
      			<label for="validationServer07">E-mail</label>
      			<input type="text" class="form-control is-valid" id="email" name="email" required>
      				<div class="valid-feedback">
        				Looks good!
      				</div>
    		</div>
    		<div class="col-md-6 mb-3">
      			<label for="validationServerUsername">Username</label>
      			<input type="text" class="form-control is-invalid" id="username" name="username" aria-describedby="inputGroupPrepend3" required>
        			<div class="invalid-feedback">
          				Please choose a username.
        			</div>
      		</div>
    	</div>    
    </div>
    
    
    
    <br><br>
    
    
    
    <div class="row">
		<div class="col-md-8 col-md-offset-2">    
    		<div class="col-md-6 mb-3">
      			<label for="validationServer08">Password</label>
      			<input type="password" class="form-control is-valid" id="password" name="password" required>
      				<div class="valid-feedback">
        				Looks good!
      				</div>
    		</div>
    		<div class="col-md-6 mb-3">
      			<label for="validationServer09">Conferma Password</label>
      			<input type="password" class="form-control is-valid" id="password2" name="password2" required>
      				<div class="valid-feedback">
        				Looks good!
      				</div>
    		</div>  
  		</div>
  	</div>
  
  <br><br>
  
  	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="col-md-6 mb-3"></div>
			<div class="col-md-3 mb-3"></div>
			<div class="col-md-6 mb-3">			
  			<button class="btn btn-primary" type="submit">Conferma</button>
  			</div>
  			</div>
  			</div>  			
  			
  			
	</form>
</div>

</body>
</html>