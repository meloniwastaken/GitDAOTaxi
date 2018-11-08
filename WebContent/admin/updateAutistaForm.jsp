<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ats.modello.Autista" %>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Autista</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
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
<body background="../img/bg.jpg">
</head>
<body>
<h1 class="first">Modifica Autista</h1>
<%Autista u = (Autista)request.getAttribute("autistaUpdate");
List<Taxi> listaTaxi = (List<Taxi>)request.getAttribute("listaTaxi"); 
Map<String,String> errorMap = (Map<String,String>)request.getAttribute("errorMap");

String data="";
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
<jsp:include page="../navBar.jsp"></jsp:include>




<div class="container">
<div class="row">
<div class="col-md-8 col-md-offset-2">
	<div class="panel panel-default">
	<div class="panel-body">
	<form method="POST" action="updateAutista">
	<div class="row">
		<div class="col-md-8 col-md-offset-2"> 
    		<div class="col-md-6 mb-3">
      			<label for="validationServer02">Nome</label>
      			<%if(errorMap!=null && errorMap.get("nome empty")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getNome() %>"<%} %> name="nome">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("nome empty")%>
      				</div>
      			<%} else if (errorMap!=null && errorMap.get("nome length")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getNome() %>"<%} %> name="nome">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("nome length")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getNome() %>"<%} %> name="nome">
      			<%} %>
    		</div>    		
    		<div class="col-md-6 mb-3">
      			<label for="validationServer02">Cognome</label>
      			<%if(errorMap!=null && errorMap.get("cognome empty")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getCognome() %>"<%} %> name="cognome">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("cognome empty")%>
      				</div>
      			<%} else if (errorMap!=null && errorMap.get("cognome length")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getCognome() %>"<%} %> name="cognome">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("cognome length")%>
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
      			<%if (errorMap!=null && errorMap.get("data empty")!=null) {%>
      			<input type="date" class="form-control is-invalid" name="data" min="1920-01-01" max="2000-12-31" <%if (u!=null){ %> value="<%=data %>"<%} %>>      				
    			<div class="invalid-feedback">
       			 	<%=errorMap.get("data empty")%>
      			</div>
      			<%}else {%>
      			<input type="date" class="form-control is-valid" <%if (u!=null){ %> min="1920-01-01" max="2000-12-31" value="<%=data%>"<%} %> name="data">
      			<%} %>
    		
    		</div>    		    
    		<div class="col-md-6 mb-3">
      			<label for="validationServer04">Codice Fiscale</label>
      			<%if(errorMap!=null && errorMap.get("codFiscale length")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getCodiceFiscale() %>"<%} %> name="codFiscale">
      				<div class="invalid-feedback">
        			<%=errorMap.get("codFiscale length")%>
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
      			<label for="validationServer02">Indirizzo</label>
      			<%if(errorMap!=null && errorMap.get("indirizzo empty")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getIndirizzo() %>"<%} %> name="indirizzo">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("indirizzo empty")%>
      				</div>
      			<%} else if (errorMap!=null && errorMap.get("indirizzo length")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getIndirizzo() %>"<%} %> name="indirizzo">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("indirizzo length")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getIndirizzo() %>"<%} %> name="indirizzo">
      			<%} %>
    		</div>    	
    
    		<div class="col-md-6 mb-3">
      			<label for="validationServer06">Telefono</label>
      			<%if(errorMap!=null && errorMap.get("telefono empty")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getTelefono() %>"<%} %> name="telefono">
      				<div class="invalid-feedback">
        			<%=errorMap.get("telefono empty")%>
      				</div>
      			<%}else if (errorMap!=null && errorMap.get("telefono length")!=null) {%>
      				<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getTelefono() %>"<%} %> name="telefono">
      				<div class="invalid-feedback">
        			<%=errorMap.get("telefono length")%>
      				</div>
      			<%}else if (errorMap!=null && errorMap.get("telefono nonValido")!=null){%>
      				<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getTelefono() %>"<%} %> name="telefono">
      				<div class="invalid-feedback">
        			<%=errorMap.get("telefono nonValido")%>
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
      			<label for="validationServer02">E-mail</label>
      			<%if(errorMap!=null && errorMap.get("email empty")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getEmail() %>"<%} %> name="email">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("email empty")%>
      				</div>
      			<%} else if (errorMap!=null && errorMap.get("email length")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getEmail() %>"<%} %> name="email">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("email length")%>
      				</div>
      			<%} else if (errorMap!=null && errorMap.get("email nonValida")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getEmail() %>"<%} %> name="email">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("email nonValida")%>
      				</div>	    			
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getEmail() %>"<%} %> name="email">
      			<%} %>      			
    		</div>
			<div class="col-md-6 mb-3">
      			<label for="validationServer02">Stipendio</label>
      			<%if(errorMap!=null && errorMap.get("stipendio empty")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ if (u.getStipendio()==-1) {%> value="" <%} else {%>value="<%=u.getStipendio()%>"	<%}} %>	name="stipendio">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("stipendio empty")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ if (u.getStipendio()==-1) {%> value="" <%} else {%>value="<%=u.getStipendio()%>"	<%}} %>	name="stipendio">
      			<%} %>
    		</div>    		
    	</div>
    </div>
    
    <br><br>	
    		
    <div class="row">
		<div class="col-md-8 col-md-offset-2">  
    		<div class="col-md-6 mb-3">
      			<label for="validationServerUsername">Username</label>
      			<%if(errorMap!=null && errorMap.get("username length")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (u!=null){ %> value="<%=u.getUsername() %>"<%} %> name="username">
      				<div class="invalid-feedback">
        			<%=errorMap.get("username length")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (u!=null){ %> value="<%=u.getUsername() %>"<%} %> name="username">
      			<%} %> 
      		</div>
    		<div class="col-md-6 mb-3">
      			<label for="validationServer08">Password</label>
      			<%if(errorMap!=null && errorMap.get("password length")!=null) {%>
      			<input type="password" class="form-control is-invalid" id="password" name="password">
      				<div class="invalid-feedback">
        			<%=errorMap.get("password length") %>
      				</div>
      			<%}else {%>
      			<input type="password" class="form-control is-valid" id="password" name="password">
      			<%} %> 
    		</div>
  		</div>
  	</div>
  
  <br><br>
  <div class="row">
	<div class="col-md-8 col-md-offset-2"> 
  		<div class="col-md-8 mb-3">
      		<label for="validationServer09">Taxi</label>
		  		<select id="taxi" name="taxi">
		  			<%for (Taxi t:listaTaxi){ %>
		  			<option value="<%=t.getId()%>"><%=t.getMarca() %> <%=t.getModello() %>, <%=t.getTarga() %>, <%if (t.getAutista()==null){%> Non assegnato <%} else { %> Assegnato <%} %></option> <%} %>
		  			<option value="0">---Nessuno---</option>
		  		</select>
  		</div>
  		<div class="col-md-4 mb-3">
      			<label for="validationServer09">Conferma Password</label>
      			<%if(errorMap!=null && errorMap.get("password notEquals")!=null) {%>
      			<input type="password" class="form-control is-invalid" id="password2" name="password2">
      				<div class="invalid-feedback">
        			<%=errorMap.get("password notEquals")%>
      				</div>
      			<%}else {%>
      			<input type="password" class="form-control is-valid" id="password2" name="password2">
      			<%}%> 
    		</div>
    </div>
   </div>
   
  	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			
			<div class="col-md-6 mb-3">			
  			<button class="btn btn-primary" type="submit">Conferma</button>
  			</div>
  			<input type="hidden" name="from" value="updateAutistaForm">
  			<input type="hidden" name="idforUpdate" value="<%=u.getId()%>"><br> 
  			</form>
  			
			<div class="col-md-6 mb-3">
			<form action="../profile">
			<button type="submit" class="btn btn-success">Annulla</button>
			</form>
			</div> 			
			
		</div>
		</div>
  					  			
  			</div>
  			</div>  			
  			
  	</div>
	</div>
</div>  




  <%-- 	<%if (u!=null){ %> value="<%=u.getStipendio() %>"<%} %> name="stipendio">	 --%>
  		
  		

</body>
</html>