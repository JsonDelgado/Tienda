package com.BO.noneShop;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.noneShop.ClienteDAO;
import com.DAO.noneShop.UsuarioDAO;
import com.DTO.noneShop.ClienteVO;
import com.DTO.noneShop.UsuarioVO;



@RestController
public class ClienteController {

	
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
	
	@RequestMapping("/borrarCliente")
	public boolean borrarCliente(String cedulaCliente) {
		ClienteDAO dao = new ClienteDAO();
		return dao.borrarCliente(Integer.parseInt(cedulaCliente));
	}
	
	
	
	
}


