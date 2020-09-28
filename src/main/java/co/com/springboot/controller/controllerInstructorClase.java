package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.springboot.domain.InstructorClase;
import co.com.springboot.repository.InstructorClaseRepository;

@Controller
public class controllerInstructorClase {
private final InstructorClaseRepository  repoInstructorClase;
	
	public controllerInstructorClase (InstructorClaseRepository repoInstructorClase ) {
		this.repoInstructorClase = repoInstructorClase ;
	}
	
	@PostMapping("/addInstructorClase")
    public String addCategoria(InstructorClase  InstructorClase , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-InstructorClase ";
        }
        repoInstructorClase .save(InstructorClase );
        model.addAttribute("instructor_clase", repoInstructorClase .findAll());
        return "lista-InstructorClase ";
    }    
    
    //controlador buscador por id---------------------------------------------
	@GetMapping("/seachInstructorClase /{idInstructorClase}")
	public String buscar(@PathVariable("idInstructorClase") Integer id) {
		InstructorClase  InstructorClase  = repoInstructorClase .findById(id).orElseThrow(() -> new IllegalArgumentException("Invalido InstructorClase  id:" + id));

		String mensaje = "ID: " + InstructorClase .getIdInstructorClase () + " - Nombre " + InstructorClase .getClase().toString();
		System.out.println(mensaje);
		
		return "Buscar";
	}
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarInstructorClase /{idInstructorClase}")
	public String showUpdateForm(@PathVariable("idInstructorClase") Integer id, Model model) {
		InstructorClase  InstructorClase  = repoInstructorClase .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la InstructorClase  con la id:" + id));
		model.addAttribute("instructor_clase", InstructorClase );
		return "update-InstructorClase ";
	}
	
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteInstructorClase /{idInstructorClase}")
	public String delete(@PathVariable("idInstructorClase") Integer id, Model model) {
		InstructorClase  InstructorClase  = repoInstructorClase .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la InstructorClase  con la id:" + id));
		repoInstructorClase .delete(InstructorClase );
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-InstructorClase ")
	public String traerTodos(Model model) {
		Iterable<InstructorClase > lista = repoInstructorClase .findAll();
		model.addAttribute("instructor_clase", lista);
		for (InstructorClase  InstructorClase  : lista) {
			System.out.println(InstructorClase .toString());
			
		}
		return "lista-InstructorClase";
	}	
}
