<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione utente</title>
</head>
<body>
<h1><center>Registrazione Utente</center></h1>

<form method="POST" action="RegistrazioneServlet">
<table>
<tbody>
		<tr>
			<td><label for="nome">Nome: </label></td>
			<td><input type="text" id="nome" name="nome"/> </td>
			
		</tr>
		
		<tr>
			<td><label for="cognome">Cognome: </label></td>
			<td><input type="text" id="cognome" name="cognome"/></td>
		</tr>
		
		<tr>
			<td><label for="codFiscale">Codice Fiscale: </label></td>
			<td><input type="text" id="codFiscale" name="codFiscale"/></td>
			
		</tr>
		
		<tr>
			<td><label for="data">Data di nascita: </label></td>
			
			<td><input type="date" name="data" min="1920-01-01" max="2000-12-31" /> </td>
					
			
		</tr>
		
		<tr>
			<td><label for="indirizzo">Indirizzo: </label></td>
			<td><input type="text" id="indirizzo" name="indirizzo"/></td>
			
		</tr>
		
		<tr>
			
			<td><label for="telefono">Telefono: </label></td>
			<td><input type="text" id="telefono" name="telefono"/></td>
			
		</tr>
		<tr>
			<td>
			<label for="email">E-mail: </label></td>
			<td><input type="text" id="email" name="email"/></td>
			
		</tr>
		<tr>
			<td>
			<label for="username">Username: </label></td>
			<td><input type="text" id="username" name="username"/></td>
			
		</tr>
		<tr>
			<td>
			<label for="password">Password: </label></td>
			<td><input type="password" id="password" name="password"/></td>
			
		</tr>
		<tr>
			<td>
			<label for="password2">Conferma Password: </label></td>
			<td><input type="password" id="password2" name="password2"/></td>
					</tr>
		
		
</tbody>
</table>


<br>
<input type="submit" value="REGISTRA"/>
</form>
<form action="index.html">
<input type="submit" value="INDIETRO"/>
</form>

</body>
</html>