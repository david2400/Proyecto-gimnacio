package co.com.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.Socio;
import co.com.springboot.repository.SocioClaseRepository;


@Controller
public class controllerSocioClase {
	@Autowired
private SocioClaseRepository repoClaseSocio;
	
	
	
		
	
	@GetMapping("/ListarSociosClase/{id_clase}")
	public @ResponseBody String ClasesSocio(@PathVariable("id_clase") Integer idClase,Model model) {
		Iterable<Socio> lista = repoClaseSocio.ListaSocioClase(idClase);
		
		return "index";
		
	}
}
