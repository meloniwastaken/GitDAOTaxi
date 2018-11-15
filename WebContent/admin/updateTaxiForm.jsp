<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="ats.modello.Taxi" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aggiungi taxi</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<script src="js/bootstrap.min.js"></script>
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
</head>
<body background="../img/bg.jpg">

<%Map<String,String> errorMap = (Map<String,String>)request.getAttribute("errorMap");
Taxi t = (Taxi)request.getAttribute("taxi");%>
<jsp:include page="../navBar.jsp"></jsp:include>

<div class="container">
<div class="row">
<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
	<h1 class="first text-center">Modifica taxi</h1>
	<div class="panel panel-default">
	<div class="panel-body">
	 <form method="POST" action="updateTaxi">
	<div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer02">Marca</label>
      			<%if(errorMap!=null && errorMap.get("marca")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (t!=null){ %> value="<%=t.getMarca()%>"<%} %> name="marca">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("marca")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (t!=null){ %> value="<%=t.getMarca() %>"<%} %> name="marca">
      			<%} %>
    		</div>    		
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServer02">Modello</label>
      			<%if(errorMap!=null && errorMap.get("modello")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (t!=null){ %> value="<%=t.getModello() %>"<%} %> name="modello">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("modello")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (t!=null){ %> value="<%=t.getModello() %>"<%} %> name="modello">
      			<%} %>
    		</div>
    </div>
    
    <br><br>
    
    <div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer02">Targa</label>
      			<%if(errorMap!=null && errorMap.get("targa")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (t!=null){ %> value="<%=t.getTarga()%>"<%} %> name="targa">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("targa")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (t!=null){ %> value="<%=t.getTarga() %>"<%} %> name="targa">
      			<%} %>
    		</div> 	    
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServer04">Anno d'immatricolazione</label>
      			<%if(errorMap!=null && errorMap.get("annoImmatricolazione")!=null) {%>
      			<input type="number" class="form-control is-invalid" <%if (t!=null){ if (t.getAnnoDiImmatricolazione()==-1) {%> value="" <%} else {%>value="<%=t.getAnnoDiImmatricolazione()%>" <%}} %> name="annoImmatricolazione">
      				<div class="invalid-feedback">
        			<%=errorMap.get("annoImmatricolazione")%>
      				</div>
      			<%}else {%>
      			<input type="number" class="form-control is-valid" <%if (t!=null){ if (t.getAnnoDiImmatricolazione()==-1) {%> value="" <%} else {%>value="<%=t.getAnnoDiImmatricolazione()%>" <%}} %> name="annoImmatricolazione">
      			<%} %>   
      		</div>    		   
    </div>
    
    <br><br>
    
    <div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer02">Numero posti</label>
      			<%if(errorMap!=null && errorMap.get("posti")!=null) {%>
      			<input type="number" class="form-control is-invalid" <%if (t!=null){ if (t.getPosti()==-1) {%> value="" <%} else {%>value="<%=t.getPosti()%>" <%}} %> name="posti">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("posti")%>
      				</div>
      			<%}else {%>
      			<input type="number" class="form-control is-valid" <%if (t!=null){ if (t.getPosti()==-1) {%> value="" <%} else {%>value="<%=t.getPosti()%>" <%}} %> name="posti">
      			<%} %>
    		</div>    	
    
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServer06">Prezzo €/km</label>
      			<%if(errorMap!=null && errorMap.get("prezzoPerKilometro")!=null) {%>
      			<input type="number" step=".02" class="form-control is-invalid" <%if (t!=null){ if (t.getPrezzoPerKilometro()==-1) {%> value="" <%} else {%>value="<%=t.getPrezzoPerKilometro()%>" <%}} %> name="prezzoPerKilometro">
      				<div class="invalid-feedback">
        			<%=errorMap.get("prezzoPerKilometro")%>
      				</div>
      			<%}else {%>
      			<input type="number" step=".02" class="form-control is-valid" <%if (t!=null){ %>value="<%=t.getPrezzoPerKilometro()%>" <%} %> name="prezzoPerKilometro">
      			<%} %> 
      		</div>    		    
    </div>
    
    <br><br>
    
  
  	<div class="row">
		<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1">
			<div class="btn-toolbar pull-right" role="toolbar">
  				<div class="btn-group" role="group"><button class="btn btn-warning" type="reset">Reset</button></div>
  				<div class="btn-group" role="group"><button class="btn btn-primary" type="submit">Conferma</button></div>
			</div>
  		</div>
  	</div>
  			
  		<input type="hidden" name="id" value="<%=t.getId() %>">
  		<input type="hidden" name="taxi" value="<%=t.getId() %>">
  		<input type="hidden" name="from" value="updateTaxiForm.jsp">	
	</form>
	</div>
	</div>
</div>
</div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>