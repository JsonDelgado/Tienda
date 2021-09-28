package com.BO.noneShop;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.noneShop.ProveedorDAO;
import com.DAO.noneShop.UsuarioDAO;
import com.DTO.noneShop.ProveedorVO;
import com.DTO.noneShop.UsuarioVO;

@RestController
public class ProveedorController {

	
	
	@RequestMapping("/crearProveedor")
	public boolean crearCliente(String nit, String nombrePro, String direccionPro, String telefonoPro, String ciudadPro) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO pro = new ProveedorVO();
//Revisar*****
		pro.setNit(Integer.parseInt(nit));
		pro.setNombre_pro(nombrePro);
		pro.setDireccion_pro(direccionPro);
		pro.setTelefono_pro(telefonoPro);
		pro.setCiudad_pro(ciudadPro);
		return dao.crearProveedor(pro);
	}
	
	@RequestMapping("/listarProveedor")
	public ArrayList<ProveedorVO> listaDeProveedor() {
		ProveedorDAO dao = new ProveedorDAO();
		return dao.listaDeProveedor();
	}
	
	@RequestMapping("/borrarProveedor")
	public boolean borrarUsuario(String nit) {
		ProveedorDAO dao = new ProveedorDAO();
		return dao.borrarProveedor(Integer.parseInt(nit));
	}
	

}
