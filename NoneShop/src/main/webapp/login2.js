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

 	document.getElementById("id").value="";
	document.getElementById("usuario").value="";
	document.getElementById("clave").value="";
	
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
});






 $("#listarU").click(function(){
	
            $.get("http://localhost:8080/listausuarios",function(data, status){
                if(status=="success"){
                    let longitud = data.length;
                    let salida ="<table border='1'>";
                    salida = salida + "<tr><th align=left>ID</th><th align=left>USUARIO</th><th align=left>CLAVE</th></tr>";

                    for(let i=0;i<longitud;i++){
                        salida = salida + "<tr>";
						
                        salida = salida + "<td align=left>"+data[i].id_usuario+"</td>";
                        salida = salida + "<td align=left>"+data[i].usuario+"</td>";
                        salida = salida + "<td align=left>"+data[i].clave+"</td>";
                        salida = salida + "</tr>";
                    }
                    salida = salida +"</table>";
					document.getElementById("tabla").innerHTML = salida;
					
                    
                    //Revisar***
                }
            });
        });



$("#agregarU").click(function(){
	
            let elid = $("#id").val();
            let elusuario = $("#usuario").val();
            let laclave = $("#clave").val();
           
            $.post("http://localhost:8080/crearusuario",{id_usuario: elid, usuario: elusuario, clave: laclave},function(data,status){
                if (data==true){
                    alert("Usuario creado");
													
                }else{
                    alert("No fue posible crear el usuario");
                } });  
	
	

});

$("#actualizarU").click(function(){
            let elid = $("#id").val();
            let elusuario = $("#usuario").val();
            let laclave = $("#clave").val();
            $.post("http://localhost:8080/actualizarusuario",{id_usuario: elid, usuario: elusuario, clave: laclave},function(data,status){
                if (data==true){
                    alert(" El usuario fue actualizado .");
                }else{
                    alert("No fue posible actualizar el usuario");
                }
            });            
        });

        $("#eliminarU").click(function(){
            let elid = $("#id").val();
            $.post("http://localhost:8080/borrarusuario",{id_usuario: elid},function(data,status){//Revisar***
                if (data==true){
                    alert(" El usuario fue eliminado.");
                }else{
                    alert("No se pudo eliminar");
                } }); 
		});
 });