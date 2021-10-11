package com.BO.noneShop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DAO.noneShop.ClienteDAO;
import com.DAO.noneShop.Conexion;
import com.DAO.noneShop.UsuarioDAO;
import com.DTO.noneShop.ClienteVO;
import com.DTO.noneShop.UsuarioVO;
import com.sun.java.util.jar.pack.Package.File;



@RestController
public class ClienteController {

	/*@RequestMapping("/cargarArchivoCSV")
		public String cargarArchivo(MultipartFile archivoCSV) {
			File archiveNew;
			String salida="";
			FileReader fuente=null;
			String linea="";
			ArrayList<ClienteVO>listado = new ArrayList<ClienteVO>();
			try {
				archiveNew=deMultiPartAFile(archivoCSV)
						fuente = new FileReader(archivoNew.getName());
						BufferedReader archivo = new BufferedReader(fuente);
						do {
							linea = archivo.readLine();
							if(linea!=null) {
								String tempLinea = linea.replace("\"'";"'");
								ArrayList<String>miLista=new ArrayList<String>(Arrays.asList(tempLinea.split(";")))
							
								ClienteVO cliente = new ClienteVO();
								
								cliente.setCedulaCliente(Integer.parseInt(miLista.get(0)));
								cliente.setDireccionClient(miLista.get(0));
							}
						}
			}
		}
	
	**/
	public boolean existeCliente(long cedulaCliente) {
		boolean existe = false;
		Conexion conex = new Conexion ();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from cliente where cedulaCliente=?");
			
			consulta.setLong(1, cedulaCliente);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo verificar el usuario");
		}
		return existe;
	}
	
	@RequestMapping("/crearCliente")
	public boolean crearCliente(String cedulaCliente, String direccionClient, String emailClient, String nombreClient, String telefonoClient) {
		ClienteDAO dao = new ClienteDAO();
		ClienteVO client = new ClienteVO();
//Revisar*****
		client.setCedulaCliente(Integer.parseInt(cedulaCliente));
		client.setDireccionClient(direccionClient);
		client.setEmailClient(emailClient);
		client.setNombreClient(nombreClient);
		client.setTelefonoClient(telefonoClient);
		return dao.crearCliente(client);
	}
	
	@RequestMapping("/listarCliente")
	public ArrayList<ClienteVO> listaDeUsuarios() {
		ClienteDAO dao = new ClienteDAO();
		return dao.listadeClientes();
	}
	@RequestMapping("/listarClienteV")
	public String nombreCliente(String cliente) {
		ClienteDAO dao = new ClienteDAO();
		return dao.nombreCliente();
	}

	
	@RequestMapping("/borrarCliente")
	public boolean borrarCliente(String cedulaCliente) {
		ClienteDAO dao = new ClienteDAO();
		return dao.borrarCliente(Integer.parseInt(cedulaCliente));
	}
	
	
	@RequestMapping("/actualizarCliente")
	public boolean actualizarCliente(String cedulaCliente, String direccionClient, String emailClient, String nombreClient, String telefonoClient) {
		ClienteDAO dao = new ClienteDAO();
		ClienteVO cliente = new ClienteVO();
		cliente.setCedulaCliente(Integer.parseInt(cedulaCliente));
		cliente.setDireccionClient(direccionClient);
		cliente.setEmailClient(emailClient);
		cliente.setNombreClient(nombreClient);	
		cliente.setTelefonoClient(telefonoClient);
		
		return dao.actualizarCliente(cliente);
	}
	
	
	
}


