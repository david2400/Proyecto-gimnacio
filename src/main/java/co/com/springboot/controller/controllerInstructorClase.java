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

import co.com.springboot.domain.InstructorClase;
import co.com.springboot.repository.InstructorClaseRepository;

@RequestMapping("/InstructorClase")
@Controller
public class controllerInstructorClase {
	@Autowired
private InstructorClaseRepository  repoInstructorClase;
	
	
	
	@PostMapping("/addInstructorClase")
    public @ResponseBody String addCategoria(@Valid @RequestBody InstructorClase  InstructorClase , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-InstructorClase ";
        }
        repoInstructorClase .save(InstructorClase );
        model.addAttribute("instructor_clase", repoInstructorClase .findAll());
        return "lista-InstructorClase ";
    }    
    
    //controlador buscador por id---------------------------------------------
	@GetMapping("/seachInstructorClase /{idInstructorClase}")
	public @ResponseBody String buscar(@PathVariable("idInstructorClase") Integer id) {
		InstructorClase  InstructorClase  = repoInstructorClase .findById(id).orElseThrow(() -> new IllegalArgumentException("Invalido InstructorClase  id:" + id));

		String mensaje = "ID: " + InstructorClase .getIdInstructorClase () + " - Nombre " + InstructorClase .getClase().toString();
		System.out.println(mensaje);
		
		return "Buscar";
	}
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarInstructorClase /{idInstructorClase}")
	public @ResponseBody String showUpdateForm(@PathVariable("idInstructorClase") Integer id, Model model) {
		InstructorClase  InstructorClase  = repoInstructorClase .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la InstructorClase  con la id:" + id));
		model.addAttribute("instructor_clase", InstructorClase );
		return "update-InstructorClase ";
	}
	
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteInstructorClase /{idInstructorClase}")
	public @ResponseBody String delete(@PathVariable("idInstructorClase") Integer id, Model model) {
		InstructorClase  InstructorClase  = repoInstructorClase .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la InstructorClase  con la id:" + id));
		repoInstructorClase .delete(InstructorClase );
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-InstructorClase ")
	public @ResponseBody String traerTodos(Model model) {
		Iterable<InstructorClase > lista = repoInstructorClase .findAll();
		model.addAttribute("instructor_clase", lista);
		for (InstructorClase  InstructorClase  : lista) {
			System.out.println(InstructorClase .toString());
			
		}
		return "lista-InstructorClase";
	}	
}
