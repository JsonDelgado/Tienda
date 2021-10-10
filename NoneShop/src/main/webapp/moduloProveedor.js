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
                    salida = salida + "<tr><th  align=left>NIT</th><th  align=left>Nombre</th><th  align=left>Direccion</th><th  align=left>Telefono</><th  align=left>Ciudad</></tr>";
                    for(let i=0;i<longitud;i++){
                        salida = salida + "<tr>";
                        salida = salida + "<td  align=left>"+data[i].nitproveedor+"</td>";
                        salida = salida + "<td  align=left>"+data[i].nombre_proveedor+"</td>";
                        salida = salida + "<td  align=left>"+data[i].direccion_proveedor+"</td>";
						salida = salida + "<td  align=left>"+data[i].telefono_proveedor+"</td>";
						salida = salida + "<td  align=left>"+data[i].ciudad_proveedor+"</td>";
                        salida = salida + "</tr>";
                    }
                    salida = salida +"</table>";
                  	 document.getElementById("tablaP").innerHTML = salida;
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