package com.DAO.noneShop;
	import java.sql.Statement;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	import java.util.ArrayList;

import com.DTO.noneShop.UsuarioVO;

public class UsuarioDAO {

	public ArrayList<UsuarioVO> listadeUsuarios(){
		ArrayList<UsuarioVO> misUsuarios = new ArrayList <UsuarioVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
			ResultSet res = consulta.executeQuery();
			while(res.next()) {
				UsuarioVO Usuario = new UsuarioVO();
				Usuario.setId_usuario(res.getLong("id_usuario"));
				
				Usuario.setUsuario(res.getString("usuario"));
				Usuario.setClave(res.getString("clave"));
				misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("unable to connectt");
		}
		return misUsuarios;
	}
		
		public ArrayList<UsuarioVO> buscarUsuario(long id_usuario){
			ArrayList<UsuarioVO> misUsuarios = new ArrayList<UsuarioVO>();
			Conexion conex = new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from usuarios where id_usuario=?");
				
				consulta.setLong(1,  id_usuario);
				ResultSet res = consulta.executeQuery();
				
				while(res.next()) {
					UsuarioVO Usuario = new UsuarioVO();
					
					Usuario.setId_usuario(res.getLong("id_usuario"));
					Usuario.setUsuario(res.getString("usuario"));
					Usuario.setClave(res.getString("clave"));
					misUsuarios.add(Usuario);
					
				}
				res.close();
				consulta.close();
				conex.desconectar();
				
			}catch(Exception e) {
				System.out.println("No se pudo conectar");
			}
			return misUsuarios;
		}
		
		public boolean existeUsuario(Long id_usuario) {
			boolean existe = false;
			Conexion conex = new Conexion ();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from usuarios where id_usuario=?");
				
				consulta.setLong(1, id_usuario);
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
		
		public boolean crearUsuario(UsuarioVO Usuario) {
			boolean swCrear = false;
			if(!existeUsuario(Usuario.getId_usuario())) {
				Conexion conex = new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL = "INSERT INTO usuarios (id_usuario, usuario, clave) VALUES ("+
					Usuario.getId_usuario()+",'"+Usuario.getUsuario()+"','"+Usuario.getClave()+"');";
					((java.sql.Statement) consulta).executeUpdate(SQL);
					((java.sql.Statement) consulta).close();
					conex.desconectar();
					swCrear = true;
				}catch(SQLException e) {
					System.out.println("No se pudo crear el usuario");
				}
			}else {
				System.out.println("El usuario ya existe");
			}
			return swCrear;
		}
		
		public boolean borrarUsuario(long id_usuario) {
			boolean swCrear = false;
			if(existeUsuario(id_usuario)) {
				Conexion conex = new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL = "DELETE FROM usuarios where id_usuario="+id_usuario;
					consulta.executeUpdate(SQL);
					consulta.close();
					conex.desconectar();
					swCrear= true;
				}catch(SQLException e) {
					System.out.println("No fue posible eliminar");
				}
			}else {
				System.out.println("El usuario no existe");
			}
			return swCrear;
		}
		
		public boolean actualizarUsuario(UsuarioVO Usuario) {
			boolean swActualizar = false;
			if(existeUsuario(Usuario.getId_usuario())) {
				Conexion conex = new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL = "UPDATE usuarios set usuario='"+Usuario.getUsuario()+"',"+
					"clave='"+Usuario.getClave()+"where id_usuario="+Usuario.getId_usuario();
					((java.sql.Statement) consulta).executeUpdate(SQL);
					((java.sql.Statement) consulta).close();
					conex.desconectar();
					swActualizar = true;
				} catch (Exception e) {
					System.out.println("No se pudo actualizar");
					// TODO: handle exception
				}
			}else {
				System.out.println("No existe el usuario");
			}
			return swActualizar;
		}
		
	}
	
	
	
	
	

