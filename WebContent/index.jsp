<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/index.css">
	<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
	<meta charset="ISO-8859-1">

</head>

<body background="img/bg.jpg">
	<div class="container">
		<div class="row">
			<div class="logoPrincipale" id="logo">
				<img src="img/logo.png">
			</div>
		</div>
		<div class="row first">
			<div class="col-md-6 col-xs-12">
				<div class="panel-default panel">
					<div class="panel-body">
						<div class="row text-center">
							<h2>PRENOTA IL TUO VIAGGIO</h2>
						</div>
						
						<div class="row" style="margin-top:50px">
							<div class="col-xs-6 text-center">
								&#x1f464 Username
							</div>
							<div class="col-xs-6 text-center">
								&#x1f512 Password
							</div>
						</div>
						<form action="login" method="POST">
							<div class="row">
								<div class="col-xs-6">
									<input style="width:100%" type="text" name="username" placeholder="Username">
								</div>
								<div class="col-xs-6">
									<input style="width:100%" type="password" name="password" placeholder="Password">
								</div>
							</div>
							<div class="row" style="padding-top:20px">
								<div class="col-xs-12">
									<button type="submit" class="btn btn-success btn-center login-button" style="width:60%">Login</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-4 col-xs-12">
				<div class="panel-default panel">
					<div class="panel-body">
						<div class="row text-center">
							<h2>DAOTaxi</h2>
							<p>"Il piacere del viaggio senza la fatica di viaggiare" ©</p>
						</div>
						<div class="row">
							<div class="col-xs-4 col-xs-offset-1">
								<a href="Registrazione.jsp">
									<button class="btn btn-center btn-primary">Registrazione</button>
								</a>
							</div>
							<div class="col-xs-4 col-xs-offset-1">
								<a href="chisiamo.html">
									<button class="btn btn-center btn-warning"> Chi Siamo </button>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%if(request.getSession().getAttribute("messaggio")!=null) {%>
		<div class="container first">
			<div class="row">
				<div class="col-xs-8 col-xs-offset-2 label">
					<div class="panel panel-default">
						<div class="panel-body">
							<p><%out.print((String) request.getSession().getAttribute("messaggio"));%></p>
							   <%request.getSession().removeAttribute("messaggio");%>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%}%>
		<div class="container first">
			<div class="row">
				<div class="col-md-4 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-12 col-md-4">
									<img class="banner-img img-circle" src="img/logo_escursioni.png">
								</div>
								<div class="col-xs-12 col-md-6">
									<div class="row">
										<div class="col-xs-12 text-center">
											La tua escursione a portata di click!
										</div>
									</div>
									<div class="row">
										<div class="col-xs-12 text-center">
											<a href="http://172.22.184.67:8081/ProgettoEscursioni">
												<button class="btn btn-center btn-warning">Prenota subito</button>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>