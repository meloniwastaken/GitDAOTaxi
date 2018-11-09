<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="ats.modello.Viaggio" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prenotazione</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
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


</head>
<body background="../img/bg.jpg">

<% Viaggio v = (Viaggio)request.getAttribute("viaggio");
List<Taxi> lista = (List<Taxi>)request.getAttribute("taxi");
Map<String,String> errorMap = (Map<String,String>)request.getAttribute("errorMap");

Date dataAttuale = new Date();
Integer ggAttuale=dataAttuale.getDate();
Integer mmAttuale=dataAttuale.getMonth()+1;
Integer aaaaAttuale=dataAttuale.getYear()+1900;

String giornoAttuale = ggAttuale.toString();
String meseAttuale = mmAttuale.toString();
String annoAttuale = aaaaAttuale.toString();
	
if (ggAttuale < 10)
	giornoAttuale = "0" + giornoAttuale;
if (mmAttuale < 10)
	meseAttuale = "0" + meseAttuale;

String start = annoAttuale + "-" + meseAttuale + "-" + giornoAttuale;
System.out.println(start);



String orario ="";
if (v!=null && v.getData()!=null && v.getData().getHours()!=0) {
/* Integer gg =v.getData().getDate();
Integer MM = v.getData().getMonth() + 1;
Integer yyyy = v.getData().getYear() + 1900; */

Integer hh = v.getData().getHours();
Integer mm = v.getData().getMinutes();

/* String giorno = gg.toString();
String mese = MM.toString();
String anno = yyyy.toString(); */

String ore= hh.toString();
String minuti= mm.toString();
	
/* if (gg < 10)
	giorno = "0" + giorno;
if (MM < 10)
	mese = "0" + mese; */
	
/* data = anno+"-"+mese+"-"+giorno;  */

if (hh < 10)
	ore = "0" + ore;
if (hh < 10)
	minuti = "0" + minuti;

orario = ore+":"+minuti;
System.out.println(orario);

}

%>



<jsp:include page="../navBar.jsp"></jsp:include>


<div class="container">
<div class="row">
<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
	<h1 class="first text-center">Prenota viaggio</h1>
	<div class="panel panel-default">
	<div class="panel-body">
	 <form method="POST" action="preventivo">
	<div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer02">Data di partenza</label>
      			<%if(errorMap!=null && errorMap.get("data")!=null) {%>
      			<input type="date" class="form-control is-invalid" <%if (v!=null){ %> value="<%=start%>"<%} %> min="<%=start%>" name="data">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("data")%>
      				</div>
      			<%}else {%>
      			<input type="date" class="form-control is-valid" <%if (v!=null){ %> value="<%=start%>"<%} %> name="data">
      			<%} %>
    		</div>    		
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServer02">Orario di partenza</label>
      			<%if(errorMap!=null && errorMap.get("ora")!=null) {%>
      			<input type="time" class="form-control is-invalid" <%if (v!=null && v.getData()!=null && v.getData().getHours()!=0){ %> value="<%=orario%>"<%} %> name="ora">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("ora")%>
      				</div>
      			<%}else {%>
      			<input type="time" class="form-control is-valid" <%if (v!=null && v.getData()!=null && v.getData().getHours()!=0){ %> value="<%=orario%>"<%} %> name="ora">
      			<%} %>
    		</div>
    </div>
    
    <br><br>
    
    <div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer02">Partenza</label>
      			<%if(errorMap!=null && errorMap.get("partenza")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (v!=null){ %> value="<%=v.getPartenza()%>"<%} %> name="partenza">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("partenza")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (v!=null){ %> value="<%=v.getPartenza() %>"<%} %> name="partenza">
      			<%} %>
    		</div>    	
    		<div class="col-md-4 col-sm-5">
      			<label for="validationServer02">Destinazione</label>
      			<%if(errorMap!=null && errorMap.get("destinazione")!=null) {%>
      			<input type="text" class="form-control is-invalid" <%if (v!=null){ %> value="<%=v.getDestinazione()%>"<%} %> name="destinazione">
      				<div class="invalid-feedback">
       			 	<%=errorMap.get("destinazione")%>
      				</div>
      			<%}else {%>
      			<input type="text" class="form-control is-valid" <%if (v!=null){ %> value="<%=v.getDestinazione() %>"<%} %> name="destinazione">
      			<%} %>
    		</div>    		   
    </div>
    
    <br><br>
    
    <div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer06">Kilometri</label>
      			<%if(errorMap!=null && errorMap.get("kilometri")!=null) {%>
      			<input type="number" class="form-control is-invalid" <%if (v!=null){ if (v.getKilometri()==-1) {%> value="" <%} else {%>value="<%=v.getKilometri()%>" <%}} %> name="kilometri">
      				<div class="invalid-feedback">
        			<%=errorMap.get("kilometri")%>
      				</div>
      			<%}else {%>
      			<input type="number" class="form-control is-valid" <%if (v!=null){ if (v.getKilometri()==-1) {%> value="" <%} else {%>value="<%=v.getKilometri()%>" <%} %> name="kilometri">
      			<%} %> 
      		</div>    	
    </div>
    
    <br><br>
    
   <div class="row">
    		<div class="col-md-4 col-md-offset-2 col-sm-5 col-sm-offset-1">
      			<label for="validationServer06">Seleziona taxi</label>
			    <select id="taxi" name="taxi">
					<%for (Taxi t:lista) {%>
				<option value="<%=t.getId()%>"><%=t.getMarca()%>, <%=t.getModello()%>, <%=t.getPosti()%> posti, <%=t.getPrezzoPerKilometro()%> €/km</option><%}} %>			
				</select>	
			</div>
	</div>		
			
  
  	<div class="row">
		<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1">
			<div class="btn-toolbar pull-right" role="toolbar">
  				<div class="btn-group" role="group"><button class="btn btn-warning" type="reset">Reset</button></div>
  				<div class="btn-group" role="group"><button class="btn btn-danger"><a class="a_button" href="profile">Annulla</a></button></div>
  				<div class="btn-group" role="group"><button class="btn btn-primary" type="submit">Prenota</button></div>
			</div>
  		</div>
  	</div>
  			
  			
  		<input type="hidden" name="from" value="inserisciTaxi.jsp">	
	</form>
	</div>
	</div>
</div>
</div>
</div>
<script src="../js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>