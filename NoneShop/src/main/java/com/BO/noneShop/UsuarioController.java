package com.BO.noneShop;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.noneShop.UsuarioDAO;
import com.DTO.noneShop.UsuarioVO;

//Autoriza para hacer consultas desde afuera
@RestController
@CrossOrigin(origins= {"http://localhost:8080","http://54.144.74.49"})
public class UsuarioController {
	/**
	 * recibe la peticion para el listado de Usuarios
	 * 
	 * @return
	 */
	@RequestMapping("/listausuarios")
	public ArrayList<UsuarioVO> listaDeUsuarios() {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.listadeUsuarios();
	}

	/**
	 * Busca los datos de un Usuario por su ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/buscarusuarioID")
	public ArrayList<UsuarioVO> buscarUsuario(String id_usuario) {// revisar****
		UsuarioDAO dao = new UsuarioDAO();
		return dao.buscarUsuario(Long.parseLong(id_usuario));
	}

	/**
	 * Agrega un nuevo Usuario a la base de datos
	 * 
	 * @param id
	 * @param usuario
	 * @param clave
	 * @return
	 */
	@RequestMapping("/crearusuario")
	public boolean crearUsuario(String cedulaUsuario, String nombreUsuario, String emailUsuario, String usuarios, String password) {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO Usuario = new UsuarioVO();
		
		Usuario.setCedula_usuario(Integer.parseInt(cedulaUsuario));
		Usuario.setNombre_usuario(nombreUsuario);
		Usuario.setEmail_usuario(emailUsuario);
		Usuario.setUsuarios(usuarios);
		Usuario.setPassword(password);
		
		return dao.crearUsuario(Usuario);
		
	}

	/**
	 * Elimina un Usuario de acuerdo a su ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/borrarusuario")
	public boolean borrarUsuario(String cedulaUsuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.borrarUsuario(Long.parseLong(cedulaUsuario));
	}

	/**
	 * Actualiza los datos del Usuario segun su id
	 * 
	 * @param id
	 * @param usuario
	 * @param clave
	 * @return
	 */
	@RequestMapping("/actualizarusuario")
	public boolean actualizarUsuario(String cedulaUsuario, String nombreUsuario, String emailUsuario, String usuarios, String password) {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO Usuario = new UsuarioVO();
		Usuario.setCedula_usuario(Integer.parseInt(cedulaUsuario));
		Usuario.setNombre_usuario(nombreUsuario);
		Usuario.setEmail_usuario(emailUsuario);
		Usuario.setUsuarios(usuarios);
		Usuario.setPassword(password);
		return dao.actualizarUsuario(Usuario);
	}
}
