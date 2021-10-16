package com.DAO.noneShop;

import java.sql.SQLException;
import java.sql.Statement;

import com.DTO.noneShop.detalleVentasVO;



public class ventasDAO {

	public boolean crearDetalleVenta(detalleVentasVO ventas) {
		boolean swCrear = false;
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO detalle_ventas (codigo_detalle_venta, cantidad_producto, codigo_venta, valor_total, valor_venta, valoriva, codigo_producto) VALUES ("+
				ventas.getCodigoDetalle()+",'"+ventas.getCantidadProducto()+"','"+ventas.getCodigoVenta()+"','"+ventas.getValorTotal()+"','"+ventas.getValorVenta()+"','"+ventas.getValorIVA()+"','"+ventas.getCodigoProducto()+"');";
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
			}catch(SQLException e) {
				System.out.println("No se pudo crear el registro de venta "+e);
			}

		return swCrear;
	}
	
}
