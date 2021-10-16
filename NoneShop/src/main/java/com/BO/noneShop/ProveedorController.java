package com.BO.noneShop;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.noneShop.ProveedorDAO;
import com.DAO.noneShop.UsuarioDAO;
import com.DTO.noneShop.ProveedorVO;
import com.DTO.noneShop.UsuarioVO;

@RestController
@CrossOrigin(origins= {"http://localhost:8080","http://54.144.74.49"})
public class ProveedorController {

	
	
	@RequestMapping("/crearProveedor")
	public boolean crearCliente(String nit, String nombrePro, String direccionPro, String telefonoPro, String ciudadPro) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO pro = new ProveedorVO();
//Revisar*****
		pro.setNitproveedor(Integer.parseInt(nit));
		pro.setNombre_proveedor(nombrePro);
		pro.setDireccion_proveedor(direccionPro);
		pro.setTelefono_proveedor(telefonoPro);
		pro.setCiudad_proveedor(ciudadPro);
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
	
	@RequestMapping("/actualizarProveedor")
	public boolean actualizarProveedor(String nit, String nombrePro, String direccionPro, String telefonoPro, String ciudadPro) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO proveedor = new ProveedorVO();
		proveedor.setNitproveedor(Integer.parseInt(nit));
		proveedor.setNombre_proveedor(nombrePro);
		proveedor.setDireccion_proveedor(direccionPro);
		proveedor.setTelefono_proveedor(telefonoPro);
		proveedor.setCiudad_proveedor(ciudadPro);		
		return dao.actualizarProveedor(proveedor);
	}
	

}
