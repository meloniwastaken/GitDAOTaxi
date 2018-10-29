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
<title>Insert title here</title>
</head>
<body>
	<h1>Modifica Autista</h1>
	<% Autista autista = (Autista)request.getAttribute("autista"); %>
	<%List<Taxi> listaTaxi = (List<Taxi>)request.getAttribute("listaTaxi"); %>
	<%Map<String,Boolean> errorMap = (Map<String,Boolean>)request.getAttribute("errorMap");%>
	
<form method="POST" action="updateAutista">
<table>
	<tbody>
  		<tr>
  			<td>Nome: </td>
  			<td><input readonly name="nome" value="<%=autista.getNome()%>"></td>
  			<td><%if(errorMap!=null && errorMap.get("nome")!=null) {%><div style="color:red">Errore nome</div><%}%></td>
  		</tr>
  		
  		<tr>
  			<td>Cognome: </td>
  			<td><input type="text" name="cognome" value="<%=autista.getCognome()%>"></td>
  			<td><%if(errorMap!=null && errorMap.get("cognome")!=null) {%><div style="color:red">Errore cognome</div><%}%></td>
  		</tr>
  		
  		<tr>
  			<td>Codice fiscale: </td>
  			<td><input type="text" name="codFiscale" value="<%=autista.getCodiceFiscale()%>"></td>
  			<td><%if(errorMap!=null && errorMap.get("codFiscale")!=null) {%><div style="color:red">Errore codice fiscale</div><%}%></td>
  		</tr>
  		
  		<tr>
  			<td>Data di nascita: </td> 
  			<td><input type="text" name="dataDiNascita" value="<%=autista.getDataDiNascita()%>"></td>
  		</tr>
  		
  		<tr>
  			<td>Indirizzo: </td>
  			<td><input type="text" name="indirizzo" value="<%=autista.getIndirizzo()%>"></td>
  			<td><%if(errorMap!=null && errorMap.get("indirizzo")!=null) {%><div style="color:red">Errore indirizzo</div><%}%></td>
  		</tr>
  		
  		<tr>
  			<td>Telefono: </td>
  			<td><input type="text" name="telefono" value="<%=autista.getTelefono()%>"></td>
  			<td><%if(errorMap!=null && errorMap.get("telefono")!=null) {%><div style="color:red">Errore telefono</div><%}%></td>
  		</tr>
  		
  		<tr>
  			<td>E-mail: </td> 
  			<td><input type="text" name="email" value="<%=autista.getEmail()%>"></td>
  			<td><%if(errorMap!=null && errorMap.get("email")!=null) {%><div style="color:red">Errore e-mail</div><%}%></td>
  		</tr>
  		
  		<tr>
  			<td>Stipendio: </td> 
  			<td><input type="text" name="stipendio" value="<%=autista.getStipendio()%>"></td>
  			<td><%if(errorMap!=null && errorMap.get("stipendio")!=null) {%><div style="color:red">Errore stipendio</div><%}%></td>
  		</tr>
  		
  		<tr>
  			<td>Username: </td> 
  			<td><input type="text" name="username" value="<%=autista.getUsername()%>"></td>
  			<td><%if(errorMap!=null && errorMap.get("username")!=null) {%><div style="color:red">Errore username</div><%}%></td>
  		</tr>
  		
  		<tr>
  			<td>Password: </td>
  			<td><input type="password" name="password" value="<%=autista.getPassword()%>"></td>
  			<td><%if(errorMap!=null && errorMap.get("password")!=null) {%><div style="color:red">Errore password</div><%}%></td>
  		</tr>
  		
  		<tr>
			<td>
			<label for="password2">Conferma Password: </label></td>
			<td><input type="password" name="password2" value="<%=autista.getPassword()%>"></td>
			<td><%if(errorMap!=null && errorMap.get("password2")!=null) {%><div style="color:red">Le password non sono uguali</div><%}%></td>
		</tr>
  		
  		
  		<input type="hidden" name="id" value="<%=autista.getId()%>"><br>
  		
  		<tr>
  			<td>
  			<select id="taxi" name="taxi">
  			<%for (Taxi t:listaTaxi){ %>
  			<option value="<%=t.getId()%>"><%=t.getMarca() %> <%=t.getModello() %>, <%=t.getTarga() %>, <%if (t.getAutista()==null){%> Non assegnato <%} else { %> Assegnato <%} %></option> <%} %>
  			</select>
  			</td>
  		</tr>
  	
  	</tbody>
</table>
<input type="hidden" name="from" value="updateAutistaForm">
<input type="submit" value="Conferma">
</form>
</body>
</html>