<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="ats.modello.Taxi" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione Autista</title>
</head>
<body>
<h1><center>Registrazione Autista</center></h1>
<%List<Taxi> listaTaxi = (List<Taxi>)request.getAttribute("listaTaxi"); %>
<%Map<String,Boolean> errorMap = (Map<String,Boolean>)request.getAttribute("errorMap");%>

<form method="POST" action="registrazioneAutista">
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
			<label for="stipendio">Stipendio: </label></td>
			<td><input type="text" id="stipendio" name="stipendio"/></td>
			<td><%if(errorMap!=null && errorMap.get("stipendio")!=null) {%><div style="color:red">Errore stipendio</div><%}%></td>
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
		
		 		
  		<tr>
  			<td>
  			<select id="taxi" name="taxi">
  			<%for (Taxi t:listaTaxi){ %>
  			<option value="<%=t.getId()%>"><%=t.getMarca() %> <%=t.getModello() %>, <%=t.getTarga() %>, <%if (t.getAutista()==null){%> Non assegnato <%} else { %> Assegnato <%} %></option> <%} %>
  			<option value="0">---Nessuno---</option>
  			</select>
		</td>
		</tr>
		
</tbody>
</table>
<br>
<input type="hidden" name="from" value="formRegistrazioneAutista">
<input type="submit" value="REGISTRA"/>
</form>
<form action="../profile">
<input type="submit" value="INDIETRO"/>
</form>

</body>
</html>

