package com.DAO.noneShop;

import java.sql.SQLException;
import java.sql.Statement;

import com.DTO.noneShop.detalleVentasVO;

public class detalleVentasDAO {

	public void registrarDetalleVenta(detalleVentasVO detalleventa) {
		// llama y crea una instancia de la clase encargada de hacer la conexiÃ³n
		Conexion conex = new Conexion();

		try {
			// sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();

			// String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO detalle_ventas VALUES(" + detalleventa.getCodigoDetalle() + ","
					+ detalleventa.getCantidadProducto() + "," + detalleventa.getCodigoProducto() + ","
					+ detalleventa.getCodigoVenta() + "," + detalleventa.getValorTotal() + ","
					+ detalleventa.getValorVenta() + "," + detalleventa.getValorIVA() + "" + ");";

			// se ejecuta la sentencia en la base de datos
			estatuto.executeUpdate(sentencia);
			// impresiÃ³n en consola para verificaciÃ³n
			System.out.println("Registrado " + sentencia);
			// cerrando la sentencia y la conexiÃ³n
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la detalleventa");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la detalleventa");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}
	
	
	
}
