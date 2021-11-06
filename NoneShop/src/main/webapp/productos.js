var file_upload = null;
function setFile(obj) { file_upload = obj
console.log(obj)};

function eventclickbutton(){
	alert("Productos cargados correctamente");
	
	var fd = new FormData();
        if (file_upload != null) {
            fd.append("archivoCSV", file_upload.files[0]);
        };
        var xhr = new XMLHttpRequest();
        xhr.open('POST', "http://localhost:8080/cargarArchivo", true);
        xhr.onload = function() {
            if (xhr.status == 200) {
                console.log('Listo!');
            } else {
                console.log("Error!");
                
            }
        };
        xhr.send(fd);
	
}


$("#form-importar").submit(function( event ) {
	alert("entro al subimt");        

/*
        var fd = new FormData();
        if (file_upload != null) {
            fd.append("archivoCSV", file_upload.files[0]);
        };
        var xhr = new XMLHttpRequest();
        xhr.open('POST', "localhost:8080/cargarArchivo", true);
        xhr.onload = function() {
            if (xhr.status == 200) {
                console.log('Listo!');
            } else {
                console.log("Error!");
                
            }
        };
        xhr.send(fd);
*/
        event.preventDefault();
    });

$("#cargarArchivo").click(function(){
	alert("entro al subimt");
});