package com.BO.noneShop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.noneShop.productoDAO;
import com.DTO.noneShop.productoVO;

public class productosController {

	@RequestMapping("/cargarArchivo")
	public String cargarArchivo(MultipartFile archivoCSV) {
	File archivoNew;
	String salida="";
	FileReader fuente=null;
	String linea="";
	ArrayList<productoVO>listado=new ArrayList<productoVO>();
	try{
		archivoNew = deMultiPartAFile(archivoCSV);
		fuente=new FileReader(archivoNew.getName());
		BufferedReader archivo = new BufferedReader(fuente);
		do {
			linea= archivo.readLine();
				if (linea!=null) {
						String tmpLinea= linea.replace("\"'","'");
						ArrayList<String> miLista=new ArrayList<String>(Arrays.asList(tmpLinea.split(",")));
						
						productoVO productos =new productoVO();
						//provar datos BD
						
						
						productos.setCódigo_producto(Integer.parseInt(miLista.get(0)));
						productos.setNombre_producto(miLista.get(1).replace("'",""));
						productos.setNitproveedor(Integer.parseInt(miLista.get(2).replace("'","")));
						productos.setPrecio_compra(Double.parseDouble(miLista.get(3).replace("'","")));
						productos.setIvacompra(Double.parseDouble(miLista.get(4).replace("'","")));
						productos.setPrecio_venta(Double.parseDouble(miLista.get(5).replace("'","")));
						
						listado.add(productos);
						
				}
		}while (linea!=null);
		archivo.close();
		fuente.close();
		boolean secreo= false;
		for(productoVO registro:listado) {
		productoDAO dao = new productoDAO();
		secreo = dao.crearProducto(registro);
		salida = salida + "**"+secreo+"**" + registro.getCódigo_producto() + "---" + registro.getNombre_producto() + "---"+
				registro.getNitproveedor() + "---" +
				registro.getPrecio_compra() + " ---"+
				registro.getIvacompra() + " ---"+
				registro.getPrecio_venta() + "<br>";
				}
				salida = salida + " RTA: " + (secreo?"Ok":"No se pudo insertar el listado");
				}catch(FileNotFoundException e) {
				System.out.println(e.getMessage());
				}catch(IOException e2) {
				System.out.println(e2.getMessage());
				}
				return salida;
				}
				private File deMultiPartAFile(MultipartFile archivo) {
				File convFile = new File(archivo.getOriginalFilename());
				FileOutputStream salida;
				try {
				salida = new FileOutputStream(convFile);
				salida.write(archivo.getBytes());
				salida.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				return convFile;
				}
				/**
				* recibe la peticion para el listado de clientes
				* @return
				*/
				@RequestMapping("/listaProductos")
				public ArrayList<productoVO> listadeProductos(){
				productoDAO dao = new productoDAO();
				ArrayList<productoVO> listado = dao.listadeProductos();
				return listado;
				}
				/**
				* Peticion para buscar un cliente por su ID
				* @param id
				* @return
				*/
				
}
