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
</head>
<body>
<h1><center>Modifica Utente</center></h1>

<% Map<String,Boolean> errorMap = (Map<String,Boolean>)request.getAttribute("errorMap");%>
<% Utente utente = (Utente)request.getAttribute("utente"); %>

<form method="POST" action="register">
<table>
<tbody>
		<tr>
			<td><label for="nome">Nome: </label></td>
			<td><input type="text" id="nome" name="nome" value="<%=utente.getNome()%>"/> </td>
			<td><%if(errorMap!=null && errorMap.get("nome")!=null) {%><div style="color:red">Errore nome</div><%}%></td>
		</tr>
		
		<tr>
			<td><label for="cognome">Cognome: </label></td>
			<td><input type="text" id="cognome" name="cognome" value="<%=utente.getCognome()%>"/></td>
			<td><%if(errorMap!=null && errorMap.get("cognome")!=null) {%><div style="color:red">Errore cognome</div><%}%></td>
		</tr>
		
		<tr>
			<td><label for="codFiscale">Codice Fiscale: </label></td>
			<td><input type="text" id="codFiscale" name="codFiscale" value="<%=utente.getCodiceFiscale()%>"/></td>
			<td><%if(errorMap!=null && errorMap.get("codFiscale")!=null) {%><div style="color:red">Errore codice fiscale</div><%}%></td>
			
		</tr>
		<tr>
			<td><label for="data">Data di nascita: </label></td>
			<td><input type="date" id="data" name="data" min="1920-01-01" max="2000-12-31" value="<%=utente.getDataDiNascita()%>"/> </td>
		</tr>
		
		<tr>
			<td><label for="indirizzo">Indirizzo: </label></td>
			<td><input type="text" id="indirizzo" name="indirizzo" value="<%=utente.getIndirizzo()%>"/></td>
			<td><%if(errorMap!=null && errorMap.get("indirizzo")!=null) {%><div style="color:red">Errore indirizzo</div><%}%></td>
		</tr>
		
		<tr>
			
			<td><label for="telefono">Telefono: </label></td>
			<td><input type="text" id="telefono" name="telefono" value="<%=utente.getTelefono()%>"/></td>
			<td><%if(errorMap!=null && errorMap.get("telefono")!=null) {%><div style="color:red">Errore telefono</div><%}%></td>
		</tr>
		<tr>
			<td>
			<label for="email">E-mail: </label></td>
			<td><input type="text" id="email" name="email" value="<%=utente.getEmail()%>"/></td>
			<td><%if(errorMap!=null && errorMap.get("email")!=null) {%><div style="color:red">Errore e-mail</div><%}%></td>
		</tr>
		<tr>
			<td>
			<label for="username">Username: </label></td>
			<td><input type="text" id="username" name="username" value="<%=utente.getUsername()%>"/></td>
			<td><%if(errorMap!=null && errorMap.get("username")!=null) {%><div style="color:red">Errore username</div><%}%></td>
		</tr>
		<tr>
			<td>
			<label for="password">Password: </label></td>
			<td><input type="password" id="password" name="password" value="<%=utente.getPassword()%>"/></td>
			<td><%if(errorMap!=null && errorMap.get("password")!=null) {%><div style="color:red">Errore password</div><%}%></td>
		</tr>
		<tr>
			<td>
			<label for="password2">Conferma Password: </label></td>
			<td><input type="password" id="password2" name="password2" value="<%=utente.getPassword()%>"/></td>
			<td><%if(errorMap!=null && errorMap.get("password2")!=null) {%><div style="color:red">Le password non sono uguali</div><%}%></td>
		</tr>
</tbody>
</table>


<br>
<input type="hidden" name="id" value="<%=utente.getId()%>">
<input type="hidden" name="from" value="formUpdate">
<input type="submit" value="MODIFICA"/>
</form>
<form action="index.html">
<input type="submit" value="HOME"/>
</form>


</body>
</html>