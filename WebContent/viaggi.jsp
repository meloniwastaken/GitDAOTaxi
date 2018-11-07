<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ats.modello.Autista" %>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="ats.modello.Cliente" %>
<%@ page import="ats.modello.Viaggio" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Viaggi</title>
</head>
<body background="img/bg.jpg">

	<jsp:include page="navBar.jsp"/>

	<h1 class="first">Viaggi</h1>
<% List<Viaggio> viaggi = (List<Viaggio>) request.getAttribute("viaggi");
   List<Double> statistiche = (List<Double>) request.getAttribute("statistiche");
   DecimalFormat f = new DecimalFormat("##.00"); %>
   	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
	<table>
		<thead>
			<tr>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=2) {%> <th>Autista</th><%}%>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=3) {%> <th>Cliente</th><%}%>
				<th>Taxi</th>
				<th>Partenza</th>
				<th>Destinazione</th>
				<th>Data</th>
				<th>Kilometri</th>
				<th>Prezzo</th>
				<th>Stato</th>
				<th>Feedback</th>
				<%if((Integer) request.getSession().getAttribute("ruolo")==2) {%> <th>Cambia stato</th><%}%>
				<%if((Integer) request.getSession().getAttribute("ruolo")==1) {%> <th>Note</th><%}%>
			</tr>
		</thead>
		<tbody>
		<%for(Viaggio v : viaggi) {%>
			<tr>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=2) {%> <td><%=v.getAutista().getNome()%> <%=v.getAutista().getCognome()%></td><%}%>
				<%if((Integer) request.getSession().getAttribute("ruolo")!=3) {%> <td><%=v.getCliente().getNome()%> <%=v.getCliente().getCognome()%></td><%}%>
				<td><%if((Integer) request.getSession().getAttribute("ruolo")==1) {%>ID: <%=v.getTaxi().getId()%><%}%> <%=v.getTaxi().getMarca()%> <%=v.getTaxi().getModello()%></td>
				<td><%=v.getPartenza()%></td>
				<td><%=v.getDestinazione()%></td>
				<td><%=v.getData().toString()%></td>
				<td><%=v.getKilometri()%></td>
				<td><%=v.getPrezzo()%></td>
				<%if(v.getStato()==1) {%><td>In attesa</td><%} else if(v.getStato()==2){%><td>Accettato</td><%} else if(v.getStato()==3){%><td >In corso</td><%} else {%><td >Completato</td>  <%}%>
				<td ><%if(v.getFeedback()==null && v.getStato()==4 && (Integer)request.getSession().getAttribute("ruolo")==3) {%>
						<form method="POST" action="cliente/lasciaFeedback">
							<input type="hidden" name="idViaggio" value="<%=v.getId()%>"/>
							<select name="feedback">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
							<button type="submit" class="btn btn-primary">Lascia Feedback</button>
						</form>
				<%} else if(v.getFeedback()!=null && v.getStato()==4) {%>
					<%=v.getFeedback()%>
				<%}%></td>

				<%if((Integer) request.getSession().getAttribute("ruolo")==2 && v.getStato()!=4 && v.getCliente().getUsername()!=null) {%>
				<td >
					<form action="autista/avanzaStatoViaggio" method="POST">
						<input type="hidden" name="idViaggio" value="<%=v.getId()%>"/>
						<button type="submit" class="btn btn-primary">Avanza Stato</button>
					</form>
				</td>
				<%} else if((Integer) request.getSession().getAttribute("ruolo")==2 && v.getStato()!=4 && v.getCliente().getUsername()!=null) {%>
					<td>Utente cancellato</td>
				<%}%>
				<%if((Integer) request.getSession().getAttribute("ruolo")==1 && v.getCliente().getUsername()==null) {%> <td>Utente cancellato</td><%}%>
			</tr>
		<%} %>
		</tbody>
	</table>
</div></div></div>	
	<%if(statistiche!=null && !statistiche.isEmpty()) {%>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-body">
		<div class="row"><div class="col-md-4 label">Totale viaggi</div><div class="col-md-4 col-md-offset-2"><%=statistiche.get(0).intValue()%></div></div>
		<div class="row"><div class="col-md-4 label">Totale kilometri</div><div class="col-md-4 col-md-offset-2"><%=statistiche.get(1)%></div></div>
		<div class="row"><div class="col-md-4 label">Totale prezzo</div><div class="col-md-4 col-md-offset-2"><%=f.format(statistiche.get(2))%></div></div>
		<div class="row"><div class="col-md-4 label">Media Feedback</div><div class="col-md-4 col-md-offset-2"><%if(statistiche.get(3)!=null && statistiche.get(3)!=0) out.print(f.format(statistiche.get(3)));%></div></div>
		
	</div></div></div></div></div>
	<%} %>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>