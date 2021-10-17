$(document).ready(function(){

$("#agregarDV").click(function(){
            let codP1 = $("#codigoProducto").val();
            let direccionClient = $("#direccionClient").val();
            let emailClient = $("#emailClient").val();
            let nombreClient = $("#nombreClient").val();
            let telefonoClient = $("#telefonoClient").val();

            $.post("http://54.144.74.49:8080/NoneShop-0.0.1-SNAPSHOT/crearCliente",{codigoProducto: codP1, direccionClient: direccionClient, emailClient: emailClient, nombreClient: nombreClient, telefonoClient: telefonoClient},function(data,status){
                if (data==true){
                    alert(" El usuario fue creado.");
                }else{
                    alert("No fue posible crear el usuario");
                } });    
});

});