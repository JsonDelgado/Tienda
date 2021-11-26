$(document).ready(function(){
     



$('ul.tabs li a:first').addClass('active');
$('.seccions article').hide();
$('.seccions article:first').show();


$('ul.tabs li a').click(function(){
	
	$('ul.tabs li a').removeClass('active');
	$(this).addClass('active');
	$('.seccions article').hide();
		
	var activeTab = $(this).attr('href');
	$(activeTab).show();
	
	return false; 
	
});

$('ul.tabs li a').click(function(){

 	document.getElementById("cedulaUsuario").value="";
	document.getElementById("nombreUsuario").value="";
	document.getElementById("emailUsuario").value="";
	document.getElementById("usuarios").value="";
	document.getElementById("password").value="";
	document.getElementById("id_ciudad").value="";

	
	document.getElementById("cedulaCliente").value="";
	document.getElementById("direccionClient").value="";
	document.getElementById("emailClient").value="";
	document.getElementById("nombreClient").value="";
	document.getElementById("emailClient").value="";
	document.getElementById("telefonoClient").value="";
	
	document.getElementById("nit").value="";
	document.getElementById("nombrePro").value="";
	document.getElementById("direccionPro").value="";
	document.getElementById("telefonoPro").value="";
	document.getElementById("ciudadPro").value="";
	
	document.getElementById("tabla").innerHTML = "";
	document.getElementById("tablaC").innerHTML = "";
	document.getElementById("tablaP").innerHTML = "";
	document.getElementById("tablaRU").innerHTML = "";
	document.getElementById("tablaRC").innerHTML = "";
	
});

$('.form_submitT').click(function(){
	document.getElementById("tablaRU").innerHTML = "";
	document.getElementById("tablaRC").innerHTML = "";

});





 $("#listarU").click(function(){
	http://54.144.74.49:8080/NoneShop-0.0.1-SNAPSHOT
            $.get("http://localhost:8080/listausuarios",function(data, status){
                if(status=="success"){
                    let longitud = data.length;
                    let salida ="<table border='1'>";
                    salida = salida + "<tr><th align=left>Cedula</th><th align=left>Nombre</th>  <th align=left>Email</th> <th align=left>Usuario</th>  <th align=left>Contrasena</th> <th align=left>Ciudad</th></tr>";

                    for(let i=0;i<longitud;i++){
                        salida = salida + "<tr>";
						
                        salida = salida + "<td align=left>"+data[i].cedula_usuario+"</td>";
                        salida = salida + "<td align=left>"+data[i].nombre_usuario+"</td>";
                        salida = salida + "<td align=left>"+data[i].email_usuario+"</td>";
						salida = salida + "<td align=left>"+data[i].usuarios+"</td>";
						salida = salida + "<td align=left>"+data[i].password+"</td>";
						salida = salida + "<td align=left>"+data[i].id_ciudad+"</td>";
                        salida = salida + "</tr>";
                    }
                    salida = salida +"</table>";
					document.getElementById("tabla").innerHTML = salida;
				
					
                    
                    //Revisar***
                }
            });
        });

 $("#listarRU").click(function(){
	
            $.get("http://localhost:8080/listausuarios",function(data, status){
                if(status=="success"){
                    let longitud = data.length;
                    let salida ="<table border='1'>";
                    salida = salida + "<tr><th align=left>Cedula</th><th align=left>Nombre</th>  <th align=left>Email</th> <th align=left>Usuario</th>  <th align=left>Contrasena</th><th align=left>Ciudad</th></tr>";

                    for(let i=0;i<longitud;i++){
                        salida = salida + "<tr>";
						
                        salida = salida + "<td align=left>"+data[i].cedula_usuario+"</td>";
                        salida = salida + "<td align=left>"+data[i].nombre_usuario+"</td>";
                        salida = salida + "<td align=left>"+data[i].email_usuario+"</td>";
						salida = salida + "<td align=left>"+data[i].usuarios+"</td>";
						salida = salida + "<td align=left>"+data[i].password+"</td>";
						salida = salida + "<td align=left>"+data[i].id_ciudad+"</td>";
                        salida = salida + "</tr>";
                    }
                    salida = salida +"</table>";
					document.getElementById("tablaRU").innerHTML = salida;
					
				
					
                    
                    //Revisar***
                }
            });
        });




$("#agregarU").click(function(){
            let cedulaUsuario = $("#cedulaUsuario").val();
            let nombreUsuario = $("#nombreUsuario").val();
            let emailUsuario = $("#emailUsuario").val();
			let usuarios = $("#usuarios").val();
			let password = $("#password").val();
			let id_ciudad =$("#id_ciudad").val();
           
            $.post("http://localhost:8080/crearusuario",{cedulaUsuario: cedulaUsuario, nombreUsuario: nombreUsuario, emailUsuario: emailUsuario, usuarios: usuarios, password: password, id_ciudad: id_ciudad},function(data,status){
					alert(cedulaUsuario);
                if (data==true){
                    alert("Usuario creado");
													
                }else{
                    alert("No fue posible crear el usuario");
                } });  
	
	

});

$("#actualizarU").click(function(){
            let cedulaUsuario = $("#cedulaUsuario").val();
            let nombreUsuario = $("#nombreUsuario").val();
            let emailUsuario = $("#emailUsuario").val();
			let usuarios = $("#usuarios").val();
			let password = $("#password").val();
            $.post("http://localhost:8080/actualizarusuario",{cedulaUsuario: cedulaUsuario, nombreUsuario: nombreUsuario, emailUsuario: emailUsuario, usuarios: usuarios, clave: password},function(data,status){
                if (data==true){
                    alert(" El usuario fue actualizado .");
                }else{
                    alert("No fue posible actualizar el usuario");
                }
            });            
        });

     $("#eliminarU").click(function(){
            let elid = $("#cedulaUsuario").val();
            $.post("http://localhost:8080/borrarusuario",{cedulaUsuario: elid},function(data,status){//Revisar***
                if (data==true){
                    alert(" El usuario fue eliminado.");
                }else{
                    alert("No se pudo eliminar");
                } }); 
		});
		
		
		
 });