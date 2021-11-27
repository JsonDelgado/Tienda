$(document).ready(function(){

$("#agregarDV").click(function(){
	        let cantidadProductos = $("#codP1").val();
            let codigoProducto = $("#coProducto").val();
            let codigoVenta = $("#cVenta").val();
            let valorTotal = $("#vTotal").val();
            let totalVenta = $("#tVenta").val();
            let totalIva = $("#tIva").val();
			let totalconIva = $("#tcIva").val();
            

            $.post("http://localhost:8080/creardVenta",{codP1: cantidadProductos, coProducto: codigoProducto, cVenta: codigoVenta, vTotal: valorTotal, tcIva: totalconIva},function(data,status){
                if (data==true){
                    alert(" Venta registrada.");
                }else{
                    alert("No fue posible registrar la venta");
                } });    
});

});