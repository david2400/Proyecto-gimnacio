package co.com.springboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.Socio;
import co.com.springboot.repository.ClaseRepository;
import co.com.springboot.repository.SocioClaseRepository;

@RequestMapping("/SocioClase")
@Controller
public class controllerSocioClase {
	@Autowired
private SocioClaseRepository repoClaseSocio;
	
	
	
		
	
	@GetMapping("/ListarSociosClase/{id_clase}")
	public @ResponseBody String ClasesSocio(@PathVariable("id_clase") Integer idClase,Model model) {
		Iterable<Socio> lista = repoClaseSocio.ListaSocioClase(idClase);

		for (Socio anuncio : lista) {
			model.addAttribute("anuncios", lista);
			System.out.println(anuncio.getNombre());

		}
		return "index";
		
	}
}
