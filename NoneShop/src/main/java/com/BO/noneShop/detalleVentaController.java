package com.BO.noneShop;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.noneShop.detalleVentasDAO;
import com.DTO.noneShop.detalleVentasVO;

@RestController
public class detalleVentaController {

	@RequestMapping("/creardVenta")
	public void creardVenta(detalleVentasVO venta) {
		detalleVentasDAO Dao = new detalleVentasDAO();
		Dao.creardVenta(venta);
	}
	
}
