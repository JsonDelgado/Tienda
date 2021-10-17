package com.BO.noneShop;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.noneShop.ventasDAO;
import com.DTO.noneShop.VentasVO;

@RestController
@CrossOrigin(origins= {"http://localhost:8080","http://54.144.74.49"})
public class ventaController {

	
	@PostMapping("/registrarventa")
	public void registrarVenta(VentasVO venta) {
		ventasDAO Dao = new ventasDAO();
		Dao.registrarVenta(venta);
	}
	
}
