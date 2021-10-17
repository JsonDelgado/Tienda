<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda</title>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="login.js"></script><!-- Incorporo al proyecto javascript -->
<link rel="stylesheet" href="./css/cssIndex.css" type="text/css"><link>

</head>
<body>
<h1>Bienvenidos a la tienda noneShop!</h1>
<div class="login">

<form method="get" action=./login2.html>

<input Id="usuario" type="text" value="" placeholder="Usuario">
<input Id="clave" type="text" value="" placeholder="contraseña">
<input type="submit" value="Enviar" id="btn_Enviaru">

<!-- <tr><td><button id="btnEnviar" class="w3-
button">Enviar</button></td></tr>-->
</form>
</div>
<div class="shadow"></div>
</body>
</html>