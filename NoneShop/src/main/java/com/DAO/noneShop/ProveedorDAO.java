package com.DAO.noneShop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.noneShop.ClienteVO;
import com.DTO.noneShop.ProveedorVO;
import com.DTO.noneShop.UsuarioVO;

public class ProveedorDAO {
	
	public boolean existeProveedor(int nit) {
		boolean existe = false;
		Conexion conex = new Conexion ();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from proveedores where nitproveedor=?");
			
			consulta.setLong(1, nit);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo verificar el proveedor");
		}
		return existe;
	}

	public boolean crearProveedor(ProveedorVO proveedor) {
		boolean swCrear = false;
		if(!existeProveedor(proveedor.getNitproveedor())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO proveedores (nitproveedor, nombre_proveedor, direccion_proveedor, telefono_proveedor, ciudad_proveedor) VALUES ("+
						proveedor.getNitproveedor()+",'"+proveedor.getNombre_proveedor()+"','"+proveedor.getDireccion_proveedor()+"','"+proveedor.getTelefono_proveedor()+"','"+proveedor.getCiudad_proveedor()+"');";
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
			}catch(SQLException e) {
				System.out.println(e);
				System.out.println("No se pudo crear el proveedor");
			}
		}else {
			System.out.println("El proveedor ya existe");
		}
		return swCrear;
	}
	
	public ArrayList<ProveedorVO> listaDeProveedor(){
		ArrayList<ProveedorVO> misPros = new ArrayList <ProveedorVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
			ResultSet res = consulta.executeQuery();
			while(res.next()) {
				ProveedorVO pro = new ProveedorVO();
				pro.setNitproveedor(res.getInt("nitproveedor"));
				pro.setNombre_proveedor(res.getString("nombre_proveedor"));
				pro.setDireccion_proveedor(res.getString("direccion_proveedor"));
				pro.setTelefono_proveedor(res.getString("telefono_proveedor"));
				pro.setCiudad_proveedor(res.getString("ciudad_proveedor"));
				misPros.add(pro);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("unable to connect");
		}
		return misPros;
	}
	
	public boolean borrarProveedor(int nit) {
		boolean swCrear = false;
		if(existeProveedor(nit)) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "DELETE FROM proveedores where nitproveedor="+nit;
				consulta.executeUpdate(SQL);
				consulta.close();
				conex.desconectar();
				swCrear= true;
			}catch(SQLException e) {
				System.out.println("No fue posible eliminar");
			}
		}else {
			System.out.println("El proveedor no existe");
		}
		return swCrear;
		}
	
	public boolean actualizarProveedor(ProveedorVO proveedor) {
		boolean swActualizar = false;
		
		if(existeProveedor(proveedor.getNitproveedor())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "UPDATE proveedores set nombre_proveedor='"+proveedor.getNombre_proveedor()+"',"+
				"direccion_proveedor='"+proveedor.getDireccion_proveedor()+"',"+ "telefono_proveedor='"+proveedor.getTelefono_proveedor()+"',"+"ciudad_proveedor='"+proveedor.getCiudad_proveedor()+ "'where nitproveedor="+proveedor.getNitproveedor();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				System.out.println(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swActualizar = true;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("No se pudo actualizar");
				// TODO: handle exception
			}
		}else {
			System.out.println("No existe el usuario");
		}
		return swActualizar;
	}
}
