package com.DAO.noneShop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.noneShop.ClienteVO;
import com.DTO.noneShop.ProveedorVO;





public class ClienteDAO {
	
	public boolean existeCliente(int cedulaCliente) {
		boolean existe = false;
		Conexion conex = new Conexion ();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from cliente where cedulaCliente=?");
			
			consulta.setInt(1, cedulaCliente);
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

	public boolean crearCliente(ClienteVO cliente) {
		boolean swCrear = false;
		if(!existeCliente(cliente.getCedulaCliente())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO cliente (cedulaCliente, direccionClient, emailClient, nombreClient, telefonoClient) VALUES ("+
				cliente.getCedulaCliente()+",'"+cliente.getDireccionClient()+"','"+cliente.getEmailClient()+"','"+cliente.getNombreClient()+"','"+cliente.getTelefonoClient()+"');";
				
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
			}catch(SQLException e) {
				System.out.println(e);
				System.out.println("No se pudo crear el cliente");
			}
		}else {
			System.out.println("El cliente ya existe");
		}
		return swCrear;
	}
	
	
	public ArrayList<ClienteVO> listadeClientes(){
		ArrayList<ClienteVO> misClientes = new ArrayList <ClienteVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente");
			ResultSet res = consulta.executeQuery();
			while(res.next()) {
				ClienteVO client = new ClienteVO();
				client.setCedulaCliente(res.getInt("cedulaCliente"));
				client.setDireccionClient(res.getString("direccionClient"));
				client.setEmailClient(res.getString("emailClient"));
				client.setNombreClient(res.getString("nombreClient"));
				client.setTelefonoClient(res.getString("telefonoClient"));
				misClientes.add(client);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("unable to connectt");
		}
		return misClientes;
	}
	
	public String nombreCliente(){
		String cliente = "";
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente");
			ResultSet res = consulta.executeQuery();		
				ClienteVO client = new ClienteVO(cliente);
				client.setNombreClient(res.getString("nombreClient"));
				cliente = client.getNombreClient();
			
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("unable to connectt");
		}
		return cliente;
	}
	
	
	public boolean borrarCliente(int cedulaCliente) {
		boolean swCrear = false;
		if(existeCliente(cedulaCliente)) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "DELETE FROM cliente where cedulaCliente="+cedulaCliente;
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
	
	public boolean actualizarCliente(ClienteVO cliente) {
		boolean swActualizar = false;
		if(existeCliente(cliente.getCedulaCliente())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "UPDATE cliente set nombreClient='"+cliente.getNombreClient()+"',"+
				"direccionClient='"+cliente.getDireccionClient()+"',"+"emailClient='"+cliente.getEmailClient() +"',"+"telefonoClient='"+cliente.getTelefonoClient() +"'where cedulaCliente="+cliente.getCedulaCliente();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swActualizar = true;
			} catch (Exception e) {
				System.out.println("No se pudo actualizar"+e);
				// TODO: handle exception
			}
		}else {
			System.out.println("No existe el usuario");
		}
		return swActualizar;
	}
	
}
