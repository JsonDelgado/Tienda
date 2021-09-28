$(document).ready(function(){

$("#agregarP").click(function(){
            let nit = $("#nit").val();
            let nombrePro = $("#nombrePro").val();
            let direccionPro = $("#direccionPro").val();
            let telefonoPro = $("#telefonoPro").val();
            let ciudadPro = $("#ciudadPro").val();

            $.post("http://localhost:8080/crearProveedor",{nit: nit, nombrePro: nombrePro, direccionPro: direccionPro, telefonoPro: telefonoPro, ciudadPro: ciudadPro},function(data,status){
                if (data==true){
                    $("#mensaje").html(" El proveedor fue creado .");
                }else{
                    $("#mensaje").html("<b style='color:red;'>No se pudo crear, ya existe !!!</b>");
                } });    
});



 $("#listarP").click(function(){
            $.get("http://localhost:8080/listarProveedor",function(data, status){
                if(status=="success"){
                    let longitud = data.length;
                    let salida ="<table border='1'>";
                    salida = salida + "<tr><th>NIT</th><th>Nombre</th><th>Direccion</th><th>Telefono</><th>Ciudad</></tr>";
                    for(let i=0;i<longitud;i++){
                        salida = salida + "<tr>";
                        salida = salida + "<td>"+data[i].nit+"</td>";
                        salida = salida + "<td>"+data[i].nombre_pro+"</td>";
                        salida = salida + "<td>"+data[i].direccion_pro+"</td>";
						salida = salida + "<td>"+data[i].telefono_pro+"</td>";
						salida = salida + "<td>"+data[i].ciudad_pro+"</td>";
                        salida = salida + "</tr>";
                    }
                    salida = salida +"</table>";
                    $("#mensaje").html(salida);
                    //Revisar***
                }
            });
        });

 $("#borrarP").click(function(){
           let nit = $("#nit").val();
            $.post("http://localhost:8080/borrarProveedor",{nit: nit},function(data, status){//Revisar***
                if (data==true){
                    $("#mensaje").html(" El proveedor fue eliminado .");
                }else{
                    $("#mensaje").html("<b style='color:red;'>No se pudo eliminar, NO existe !</b>");
                } }); 
		});
		
$("#actualizarP").click(function(){
            let nit = $("#nit").val();
            let nombrePro = $("#nombrePro").val();
            let direccionPro = $("#direccionPro").val();
            let telefonoPro = $("#telefonoPro").val();
            let ciudadPro = $("#ciudadPro").val();
            $.post("http://localhost:8080/actualizarProveedor",{nit: nit, nombrePro: nombrePro, direccionPro: direccionPro, telefonoPro: telefonoPro, ciudadPro: ciudadPro},function(data,status){
                if (data==true){
                    $("#mensaje").html(" El usuario fue actualizado .");
                }else{
                    $("#mensaje").html("<b style='color:red;'>No se pudo actualizar, NO existe !!!</b>");
                }
            });            
        });

});