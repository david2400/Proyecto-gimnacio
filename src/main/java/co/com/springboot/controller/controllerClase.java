package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.springboot.domain.Clase;
import co.com.springboot.repository.ClaseRepository;



@Controller
public class controllerClase {
	
private final ClaseRepository repoClase;
	
	public controllerClase(ClaseRepository repoClase) {
		this.repoClase= repoClase;
	}
	
	@PostMapping("/addClase")
    public String addCategoria(Clase Clase, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-Clase";
        }
        repoClase.save(Clase);
        model.addAttribute("clase", repoClase.findAll());
        return "lista-Clase";
    }    
    
    //controlador buscador por id---------------------------------------------
	@GetMapping("/seachClase/{idClase}")
	public String buscar(@PathVariable("idClase") Integer id) {
		Clase Clase = repoClase.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalido Clase id:" + id));

		String mensaje = "ID: " + Clase.getIdClase() + " - Nombre " + Clase.getNombre().toString();
		System.out.println(mensaje);
		
		return "Buscar";
	}
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarClase/{idClase}")
	public String showUpdateForm(@PathVariable("idClase") Integer id, Model model) {
		Clase Clase = repoClase.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Clase con la id:" + id));
		model.addAttribute("clase", Clase);
		return "update-Clase";
	}
	
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteClase/{idClase}")
	public String delete(@PathVariable("idClase") Integer id, Model model) {
		Clase Clase = repoClase.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Clase con la id:" + id));
		repoClase.delete(Clase);
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-Clase")
	public String traerTodos(Model model) {
		Iterable<Clase> lista = repoClase.findAll();
		model.addAttribute("clase", lista);
		for (Clase Clase : lista) {
			System.out.println(Clase.toString());
			
		}
		return "lista-Clase";
	}	
}
