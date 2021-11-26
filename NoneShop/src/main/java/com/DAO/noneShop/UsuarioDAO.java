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
				Usuario.setCedula_usuario(res.getInt("cedula_usuario"));					
				Usuario.setNombre_usuario(res.getString("nombre_usuario"));
				Usuario.setEmail_usuario(res.getString("email_usuario"));
				Usuario.setUsuarios(res.getString("usuarios"));
				Usuario.setPassword(res.getString("password"));	
				Usuario.setId_ciudad(Integer.parseInt(res.getString("id_ciudad")));			
				misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("unable to connect"+e);
		}
		return misUsuarios;
	}
		
		public ArrayList<UsuarioVO> buscarUsuario(long cedula_usuario){
			ArrayList<UsuarioVO> misUsuarios = new ArrayList<UsuarioVO>();
			Conexion conex = new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from usuarios where cedula_usuario=?");
				
				consulta.setLong(1,  cedula_usuario);
				ResultSet res = consulta.executeQuery();
				
				while(res.next()) {
					UsuarioVO Usuario = new UsuarioVO();
					
					Usuario.setCedula_usuario(res.getInt("cedula_usuario"));					
					Usuario.setNombre_usuario(res.getString("nombre_usuario"));
					Usuario.setEmail_usuario(res.getString("email_usuario"));
					Usuario.setUsuarios(res.getString("usuarios"));
					Usuario.setPassword(res.getString("password"));	
					Usuario.setId_ciudad(Integer.parseInt(res.getString("id_ciudad")));
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
		
		public boolean existeUsuario(long cedula_usuario) {
			boolean existe = false;
			Conexion conex = new Conexion ();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from usuarios where cedula_usuario=?");
				
				consulta.setLong(1, cedula_usuario);
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
			if(!existeUsuario(Usuario.getCedula_usuario())) {
				Conexion conex = new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL = "INSERT INTO usuarios (cedula_usuario, nombre_usuario, email_usuario, usuarios, password) VALUES ("+
					Usuario.getCedula_usuario()+",'"+Usuario.getNombre_usuario()+"','"+Usuario.getEmail_usuario()+"','"+Usuario.getUsuarios()+"','"+Usuario.getPassword()+"','"+Usuario.getId_ciudad                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ()+"');";
					
					((java.sql.Statement) consulta).executeUpdate(SQL);
					((java.sql.Statement) consulta).close();
					conex.desconectar();
					swCrear = true;
				}catch(SQLException e) {
					System.out.println("No se pudo crear el usuario "+e);
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
					String SQL = "DELETE FROM usuarios where cedula_usuario="+id_usuario;
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
			if(existeUsuario(Usuario.getCedula_usuario())) {
				Conexion conex = new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL = "UPDATE usuarios set nombre_usuario='"+Usuario.getNombre_usuario()+"',"+
					"email_usuario='"+Usuario.getEmail_usuario()+"',"+"usuarios='"+Usuario.getUsuarios() +"',"+"password='"+Usuario.getPassword() +"'where cedula_usuario="+Usuario.getCedula_usuario();
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
	
	
	
	
	

