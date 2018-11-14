<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
#logo {
	text-align:center;
    position: relative;
    animation-name: example;
    animation-duration: 1.5s;
    animation-iteration-count: 1;    
}

@keyframes example {
    0%   {padding-right:100%; top:0px;}
    100% {padding-right:0%; top:0px;}
}

.icon-user:before {
contest:"\e971";
}
.icon-lock:before {
  content: "\1f512";
}


[ Button ]*/
.container-login100-form-btn {
  width: 100%;
  display: -webkit-box;
  display: -webkit-flex;
  display: -moz-box;
  display: -ms-flexbox;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.login100-form-btn {
  font-family: Ubuntu-Bold;
  font-size: 16px;
  color: #fff;
  line-height: 0.8;
  text-transform: uppercase;
  position:absolute;
  top:20px;
  left:50px;
  width:180px;
  height:180px;

  display: -webkit-box;
  display: -webkit-flex;
  display: -moz-box;
  display: -ms-flexbox;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  min-width: 120px;
  height: 42px;
  border-radius: 21px;

  background: #d41872;
  background: -webkit-linear-gradient(bottom, #ffcc00, #ff6600);
  background: -o-linear-gradient(bottom, #ffcc00, #ff6600);
  background: -moz-linear-gradient(bottom, #ffcc00, #ff6600);
  background: linear-gradient(bottom, #ffcc00,  #ff6600);
  position: relative;
  z-index: 1;

  -webkit-transition: all 0.4s;
  -o-transition: all 0.4s;
  -moz-transition: all 0.4s;
  transition: all 0.4s;
}

.login100-form-btn::before {
  content: "";
  display: block;
  position: absolute;
  z-index: -1;
  width: 100%;
  height: 100%;
  border-radius: 21px;
  background-color: rgb(0, 0, 0);
  top: 0;
  left: 0;
  opacity: 0;

  -webkit-transition: all 0.4s;
  -o-transition: all 0.4s;
  -moz-transition: all 0.4s;
  transition: all 0.4s;
}

.login100-form-btn:hover {
  background-color: transparent;
}

.login100-form-btn:hover:before {
  opacity: 1;
}

.button_container {
	padding-left:20%;
	padding-right:20%;
}

a {
	text-decoration: none;
}
</style>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
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
	</div>
</body>
</html>