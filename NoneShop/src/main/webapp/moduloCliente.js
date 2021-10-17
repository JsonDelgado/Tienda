$(document).ready(function(){

$("#agregarC").click(function(){
            let cedulaCliente = $("#cedulaCliente").val();
            let direccionClient = $("#direccionClient").val();
            let emailClient = $("#emailClient").val();
            let nombreClient = $("#nombreClient").val();
            let telefonoClient = $("#telefonoClient").val();

            $.post("http://54.144.74.49:8080/NoneShop-0.0.1-SNAPSHOT/crearCliente",{cedulaCliente: cedulaCliente, direccionClient: direccionClient, emailClient: emailClient, nombreClient: nombreClient, telefonoClient: telefonoClient},function(data,status){
                if (data==true){
                    alert(" El usuario fue creado.");
                }else{
                    alert("No fue posible crear el usuario");
                } });    
});

 $("#listarC").click(function(){
            $.get("http://54.144.74.49:8080/NoneShop-0.0.1-SNAPSHOT/listarCliente",function(data, status){
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
					document.getElementById("tablaGC").innerHTML = salida;
                    
                }
            });
        });

 $("#listarVentasC").click(function(){
            $.get("http://54.144.74.49:8080/NoneShop-0.0.1-SNAPSHOT/listarClienteV",function(data, status){
                if(status=="success"){
                                      
                    salida = data.cedulaCliente;
					document.getElementById("txtClienteV").innerHTML = salida;
                    
                }
            });
        });



 $("#listarRC").click(function(){
            $.get("http://54.144.74.49:8080/NoneShop-0.0.1-SNAPSHOT/listarCliente",function(data, status){
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
					document.getElementById("tablaRC").innerHTML = salida;
                    
                }
            });
        });

 $("#borrarC").click(function(){
           let cedulaCliente = $("#cedulaCliente").val();
            $.post("http://54.144.74.49:8080/NoneShop-0.0.1-SNAPSHOT/borrarCliente",{cedulaCliente: cedulaCliente},function(data, status){//Revisar***
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
            $.post("http://54.144.74.49:8080/NoneShop-0.0.1-SNAPSHOT/actualizarCliente",{cedulaCliente: cedulaCliente, direccionClient: direccionClient, emailClient: emailClient, nombreClient: nombreClient, telefonoClient: telefonoClient},function(data,status){
                if (data==true){
                    alert("El usuario fue actualizado.");
                }else{
                    alert("No fue posible actualizar, contacte administrador");
                }
            });            
        });


});