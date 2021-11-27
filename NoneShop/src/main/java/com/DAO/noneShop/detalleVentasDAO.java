package com.DAO.noneShop;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.DTO.noneShop.ClienteVO;
import com.DTO.noneShop.detalleVentasVO;

public class detalleVentasDAO {

	public boolean creardVenta(detalleVentasVO dVentas) {
		boolean swCrear = false;
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO detalle_ventas (codigo_detalle_venta, cantidad_producto, codigo_venta, valor_total, valor_venta, valoriva, codigo_producto, id_ciudad) VALUES ("+
				dVentas.getCodigoDetalle()+",'"+dVentas.getCantidadProducto()+"','"+dVentas.getCodigoVenta()+"','"+dVentas.getValorTotal()+"','"+dVentas.getValorVenta()+"','"+dVentas.getValorIVA()+"','"+dVentas.getCodigoProducto()+"','"+dVentas.getId_ciudad()+"');";
				
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
			}catch(SQLException e) {
				System.out.println(e);
				System.out.println("No se pudo crear el cliente");
			}

		return swCrear;
	}

	
	
	
	
}
