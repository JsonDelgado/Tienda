<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="login.js"></script>
</head>
<body>
<link rel="stylesheet" href="./css/cssIndex.css" type="text/css"><link>

<div class="container">
	<div class="screen">
		<div class="screen__content">
			<form class="login" method="get">
				<div class="login__field">
				<h3>Bienvenidos a la Tienda NoneShop</h3>
					<i class="login__icon fas fa-user"></i>
					<input Id="usuario" type="text" class="login__input" placeholder="Usuario">
				</div>
				<div class="login__field">
					<i class="login__icon fas fa-lock"></i>
					<input Id="clave" type="password" class="login__input" placeholder="Contraseña">
				</div>
				<button class="button login__submit" type=button id="btn_Enviaru">

					<span class="button__text">Ingresar</span>
					<i class="button__icon fas fa-chevron-right"></i>
				</button>				
			</form>
			<div class="social-login">

				<div class="social-icons">
					<a href="#" class="social-login__icon fab fa-instagram"></a>
					<a href="#" class="social-login__icon fab fa-facebook"></a>
					<a href="#" class="social-login__icon fab fa-twitter"></a>
				</div>
			</div>
		</div>
		<div class="screen__background">
			<span class="screen_backgroundshape screenbackground_shape4"></span>
			<span class="screen_backgroundshape screenbackground_shape3"></span>		
			<span class="screen_backgroundshape screenbackground_shape2"></span>
			<span class="screen_backgroundshape screenbackground_shape1"></span>
		</div>		
	</div>
</div>

</body>

</html>