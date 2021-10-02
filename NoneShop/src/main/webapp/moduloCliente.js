$(document).ready(function(){

$("#agregarC").click(function(){
            let cedulaCliente = $("#cedulaCliente").val();
            let direccionClient = $("#direccionClient").val();
            let emailClient = $("#emailClient").val();
            let nombreClient = $("#nombreClient").val();
            let telefonoClient = $("#telefonoClient").val();

            $.post("http://localhost:8080/crearCliente",{cedulaCliente: cedulaCliente, direccionClient: direccionClient, emailClient: emailClient, nombreClient: nombreClient, telefonoClient: telefonoClient},function(data,status){
                if (data==true){
                    alert(" El usuario fue creado.");
                }else{
                    alert("No fue posible crear el usuario");
                } });    
});

 $("#listarC").click(function(){
            $.get("http://localhost:8080/listarCliente",function(data, status){
                if(status=="success"){
                    let longitud = data.length;
                    let salida ="<table border='1'>";
                    salida = salida + "<tr><th align=left>Cedula</th><th align=left>Direccion</th><th align=left>Email</th><th align=left>Nombre</><th align=left>Telefono</></tr>";
                    for(let i=0;i<longitud;i++){
                        salida = salida + "<tr>";
                        salida = salida + "<td align=left>"+data[i].cedulaCliente+"</td>";
                        salida = salida + "<td align=left>"+data[i].direccionClient+"</td>";
                        salida = salida + "<td align=left>"+data[i].emailClient+"</td>";
						salida = salida + "<td align=left>"+data[i].nombreClient+"</td>";
						salida = salida + "<td align=left>"+data[i].telefonoClient+"</td>";
                        salida = salida + "</tr>";
                    }
                    salida = salida +"</table>";
					document.getElementById("tablaC").innerHTML = salida;
                    
                }
            });
        });
 $("#borrarC").click(function(){
           let cedulaCliente = $("#cedulaCliente").val();
            $.post("http://localhost:8080/borrarCliente",{cedulaCliente: cedulaCliente},function(data, status){//Revisar***
                if (data==true){
                   alert(" El cliente fue eliminado.");
                }else{
                    alert("No fue posible eliminar, contacte administrador");
                } }); 
		});
		
$("#actualizarC").click(function(){
            let cedulaCliente = $("#cedulaCliente").val();
            let direccionClient = $("#direccionClient").val();
            let emailClient = $("#emailClient").val();
            let nombreClient = $("#nombreClient").val();
            let telefonoClient = $("#telefonoClient").val();
            $.post("http://localhost:8080/actualizarCliente",{cedulaCliente: cedulaCliente, direccionClient: direccionClient, emailClient: emailClient, nombreClient: nombreClient, telefonoClient: telefonoClient},function(data,status){
                if (data==true){
                    alert("El usuario fue actualizado.");
                }else{
                    alert("No fue posible actualizar, contacte administrador");
                }
            });            
        });


});