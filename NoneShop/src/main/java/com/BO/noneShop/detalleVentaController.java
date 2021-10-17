package com.BO.noneShop;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.noneShop.detalleVentasDAO;
import com.DTO.noneShop.detalleVentasVO;

@RestController
@CrossOrigin(origins= {"http://localhost:8080","http://54.144.74.49"})
public class detalleVentaController {

	@PostMapping("/registrardetalleventa")
	public void registrarVenta(detalleVentasVO venta) {
		detalleVentasDAO Dao = new detalleVentasDAO();
		Dao.registrarDetalleVenta(venta);
	}
	
}
