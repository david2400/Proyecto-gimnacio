package co.com.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.Clase;
import co.com.springboot.repository.ClaseRepository;



@Controller
public class controllerClase {
	
@Autowired
private ClaseRepository repoClase;
		
	@PostMapping("/RegistrarClase")
    public @ResponseBody String addClase(@Valid @ModelAttribute("clase") Clase clase, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("clase", clase);
        	model.addAttribute("FormClase","active");
        }else {
        repoClase.save(clase);
        model.addAttribute("clases", repoClase.findAll());}
        return "MenuInstructor";
    }    
    
    //controlador buscador por id---------------------------------------------
	@GetMapping("/seachClase/{idClase}")
	public @ResponseBody String buscar(@PathVariable("idClase") Integer id) {
		Clase Clase = repoClase.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalido Clase id:" + id));

		String mensaje = "ID: " + Clase.getIdClase() + " - Nombre " + Clase.getNombre().toString();
		System.out.println(mensaje);
		
		return "Buscar";
	}
    
	 //controlador Eliminar---------------------------------------------
		@GetMapping("/deleteClase/{idClase}")
		public @ResponseBody String delete(@PathVariable("idClase") Integer id, Model model) {
			Clase Clase = repoClase.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Clase con la id:" + id));
			repoClase.delete(Clase);
				
			return traerTodos(model);
		}
		
	
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarClase/{idClase}")
	public @ResponseBody String showUpdateForm(@PathVariable("idClase") Integer id, Model model) {
		Clase Clase = repoClase.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Clase con la id:" + id));
		model.addAttribute("clase", Clase);
		return "update-Clase";
	}
		
	@GetMapping("/Todos-Clase")
	public @ResponseBody String traerTodos(Model model) {
		Iterable<Clase> lista = repoClase.findAll();
		model.addAttribute("clase", lista);
		
		return "lista-Clase";
	}	
}
