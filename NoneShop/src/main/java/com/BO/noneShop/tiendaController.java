package com.BO.noneShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.noneShop.LoginDAO;
import com.DTO.noneShop.LoginVO;
@RestController
public class tiendaController {

	
	@RequestMapping("/loginusuario2")
	public Map<String, Boolean> validarlogin2(String usuario, String clave)
	{
		ArrayList<LoginVO> miusuario = new ArrayList<LoginVO>();
		
		LoginDAO Dao=new LoginDAO();
		miusuario=Dao.consultarUsuario(usuario,clave);
		if(miusuario.isEmpty()) {
			return Collections.singletonMap("existe", false);
		}
		else {
			return Collections.singletonMap("existe", true); 
		}
	}
}
