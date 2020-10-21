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

import co.com.springboot.domain.Rutina ;
import co.com.springboot.repository.RutinaRepository;

@RequestMapping("/Rutina")
@Controller
public class controllerRutina {
	
	@Autowired
	private RutinaRepository  repoRutina;
	
	
	@PostMapping("/addRutina")
    public @ResponseBody String addCategoria(@Valid @RequestBody Rutina  Rutina , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-Rutina ";
        }
        repoRutina .save(Rutina );
        model.addAttribute("Rutinas", repoRutina .findAll());
        return "lista-Rutina ";
    }    
    
    //controlador buscador por id---------------------------------------------
	@GetMapping("/seachRutina /{idRutina}")
	public @ResponseBody String buscar(@PathVariable("idRutina") Integer id) {
		Rutina  Rutina  = repoRutina .findById(id).orElseThrow(() -> new IllegalArgumentException("Invalido Rutina  id:" + id));

		String mensaje = "ID: " + Rutina .getIdRutina () + " - Nombre " + Rutina .getNombre().toString();
		System.out.println(mensaje);
		
		return "Buscar";
	}
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarRutina /{idRutina}")
	public @ResponseBody String showUpdateForm(@PathVariable("idRutina") Integer id, Model model) {
		Rutina  Rutina  = repoRutina .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Rutina  con la id:" + id));
		model.addAttribute("Rutinas", Rutina );
		return "update-Rutina ";
	}
	
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteRutina /{idRutina}")
	public String delete(@PathVariable("idRutina") Integer id, Model model) {
		Rutina  Rutina  = repoRutina .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Rutina  con la id:" + id));
		repoRutina .delete(Rutina );
		model.addAttribute("Rutinas",repoRutina .findAll());	
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-Rutina ")
	public String traerTodos(Model model) {
		Iterable<Rutina > lista = repoRutina .findAll();
		model.addAttribute("Rutinas", lista);
		for (Rutina  Rutina  : lista) {
			System.out.println(Rutina .toString());
			
		}
		return "lista-Rutina";
	}	
}
