package co.com.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.RutinaEjercicio;
import co.com.springboot.repository.RutinaEjercicioRepository;

@RequestMapping("/RutinaEjercicio")
@Controller
public class controllerRutinaEjercicio {
	@Autowired
private  RutinaEjercicioRepository  repoRutinaEjercicio;
	
	
	@PostMapping("/addRutinaEjercicio")
    public @ResponseBody String addCategoria(@Valid @RequestBody RutinaEjercicio  RutinaEjercicio , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-RutinaEjercicio ";
        }
        repoRutinaEjercicio .save(RutinaEjercicio );
        model.addAttribute("rutina_ejercicio", repoRutinaEjercicio .findAll());
        return "lista-RutinaEjercicio ";
    }    
    
    //controlador buscador por id---------------------------------------------
	@GetMapping("/seachRutinaEjercicio /{idRutinaEjercicio}")
	public @ResponseBody String buscar(@PathVariable("idRutinaEjercicio") Integer id) {
		RutinaEjercicio  RutinaEjercicio  = repoRutinaEjercicio .findById(id).orElseThrow(() -> new IllegalArgumentException("Invalido RutinaEjercicio  id:" + id));

		String mensaje = "ID: " + RutinaEjercicio .getIdRutinaEjercicio () + " - Nombre ";
		System.out.println(mensaje);
		
		return "Buscar";
	}
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarRutinaEjercicio /{idRutinaEjercicio}")
	public @ResponseBody String showUpdateForm(@PathVariable("idRutinaEjercicio") Integer id, Model model) {
		RutinaEjercicio  RutinaEjercicio  = repoRutinaEjercicio .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la RutinaEjercicio  con la id:" + id));
		model.addAttribute("rutina_ejercicio", RutinaEjercicio );
		return "update-RutinaEjercicio ";
	}
	
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteRutinaEjercicio /{idRutinaEjercicio}")
	public @ResponseBody String delete(@PathVariable("idRutinaEjercicio") Integer id, Model model) {
		RutinaEjercicio  RutinaEjercicio  = repoRutinaEjercicio .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la RutinaEjercicio  con la id:" + id));
		repoRutinaEjercicio .delete(RutinaEjercicio );
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-RutinaEjercicio ")
	public @ResponseBody String traerTodos(Model model) {
		Iterable<RutinaEjercicio > lista = repoRutinaEjercicio .findAll();
		model.addAttribute("rutina_ejercicio", lista);
		for (RutinaEjercicio  RutinaEjercicio  : lista) {
			System.out.println(RutinaEjercicio .toString());
			
		}
		return "lista-RutinaEjercicio";
	}	
}
