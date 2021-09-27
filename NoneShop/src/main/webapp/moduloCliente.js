$(document).ready(function(){

$("#agregarC").click(function(){
            let cedulaCliente = $("#cedulaCliente").val();
            let direccionClient = $("#direccionClient").val();
            let emailClient = $("#emailClient").val();
            let nombreClient = $("#nombreClient").val();
            let telefonoClient = $("#telefonoClient").val();

            $.post("http://localhost:8080/crearCliente",{cedulaCliente: cedulaCliente, direccionClient: direccionClient, emailClient: emailClient, nombreClient: nombreClient, telefonoClient: telefonoClient},function(data,status){
                if (data==true){
                    $("#mensaje").html(" El usuario fue creado .");
                }else{
                    $("#mensaje").html("<b style='color:red;'>No se pudo crear, ya existe !!!</b>");
                } });    
});

 $("#listarC").click(function(){
            $.get("http://localhost:8080/listarCliente",function(data, status){
                if(status=="success"){
                    let longitud = data.length;
                    let salida ="<table border='1'>";
                    salida = salida + "<tr><th>Cedula</th><th>Direccion</th><th>Email</th><th>Nombre</><th>Telefono</></tr>";
                    for(let i=0;i<longitud;i++){
                        salida = salida + "<tr>";
                        salida = salida + "<td>"+data[i].cedulaCliente+"</td>";
                        salida = salida + "<td>"+data[i].direccionClient+"</td>";
                        salida = salida + "<td>"+data[i].emailClient+"</td>";
						salida = salida + "<td>"+data[i].nombreClient+"</td>";
						salida = salida + "<td>"+data[i].telefonoClient+"</td>";
                        salida = salida + "</tr>";
                    }
                    salida = salida +"</table>";
                    $("#mensaje").html(salida);
                    //Revisar***
                }
            });
        });
 $("#borrarC").click(function(){
           let cedulaCliente = $("#cedulaCliente").val();
            $.post("http://localhost:8080/borrarCliente",{cedulaCliente: cedulaCliente},function(data, status){//Revisar***
                if (data==true){
                    $("#mensaje").html(" El cliente fue eliminado .");
                }else{
                    $("#mensaje").html("<b style='color:red;'>No se pudo eliminar, NO existe !!!</b>");
                } }); 
		});


});