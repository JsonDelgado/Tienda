package com.DAO.noneShop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.DTO.noneShop.productoVO;

public class productoDAO {
	
	public boolean existeProducto(int codigo_producto) {
		boolean existe = false;
		Conexion conex = new Conexion ();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("Select * from productos where codigo_producto=?");
			
			consulta.setInt(1, codigo_producto);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo verificar el producto");
		}
		return existe;
	}

	public boolean crearProducto(productoVO productos) {
		boolean swCrear = false;
		if(!existeProducto(productos.getCodigo_producto())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = conex.getConnection().createStatement();
				String SQL = "INSERT INTO productos (codigo_producto, nombre_producto, nitproveedor, precio_compra, ivacompra,precio_venta) VALUES ("+
				productos.getCodigo_producto()+",'"+productos.getNombre_producto()+"','"+productos.getNitproveedor()+"','"+productos.getPrecio_compra()+"','"+productos.getIvacompra()+"','"+productos.getPrecio_venta()+"');";
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
			}catch(SQLException e) {
				System.out.println(e);
				System.out.println("No se pudo crear el producto");
			}
		}else {
			System.out.println("El producto ya existe");
		}
		return swCrear;
	}
	
	
	public ArrayList<productoVO> listadeProductos(){
		ArrayList<productoVO> misProductos = new ArrayList <productoVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos");
			ResultSet res = consulta.executeQuery();
			while(res.next()) {
				productoVO productos = new productoVO();
				productos.setCodigo_producto(res.getInt("código_producto"));
				productos.setNombre_producto(res.getString("nombre_producto"));
				productos.setNitproveedor(res.getInt("nitproveedor"));
				productos.setPrecio_compra(res.getDouble("precio_compra"));
				productos.setIvacompra(res.getDouble("ivacompra"));
				productos.setPrecio_venta(res.getDouble("precio_venta"));
				misProductos.add(productos);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("unable to connectt");
		}
		return misProductos;
	}
	
	public boolean borrarProducto(int código_producto) {
		boolean swCrear = false;
		if(existeProducto(código_producto)) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "DELETE FROM productos where código_producto="+código_producto;
				consulta.executeUpdate(SQL);
				consulta.close();
				conex.desconectar();
				swCrear= true;
			}catch(SQLException e) {
				System.out.println("No fue posible eliminar");
			}
		}else {
			System.out.println("El producto no existe");
		}
		return swCrear;
		}
	
	
}
