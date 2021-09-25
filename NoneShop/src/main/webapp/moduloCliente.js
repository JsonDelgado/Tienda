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

});