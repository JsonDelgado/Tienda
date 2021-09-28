package com.DAO.noneShop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DTO.noneShop.ClienteVO;
import com.DTO.noneShop.ProveedorVO;

public class ProveedorDAO {
	
	public boolean existeProveedor(int nit) {
		boolean existe = false;
		Conexion conex = new Conexion ();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from proveedores where NIT=?");
			
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
		if(!existeProveedor(proveedor.getNit())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO proveedores (NIT, nombre_pro, direccion_pro, telefono_pro, ciudad_pro) VALUES ("+
						proveedor.getNit()+",'"+proveedor.getNombre_pro()+"','"+proveedor.getDireccion_pro()+"','"+proveedor.getTelefono_pro()+"','"+proveedor.getCiudad_pro()+"');";
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
				pro.setNit(res.getInt("NIT"));
				pro.setNombre_pro(res.getString("nombre_pro"));
				pro.setDireccion_pro(res.getString("direccion_pro"));
				pro.setTelefono_pro(res.getString("telefono_pro"));
				pro.setCiudad_pro(res.getString("ciudad_pro"));
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
				String SQL = "DELETE FROM proveedores where NIT="+nit;
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
}
