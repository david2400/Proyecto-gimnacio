package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.springboot.domain.ClaseSala;
import co.com.springboot.repository.ClaseSalaRepository;

@RequestMapping("/ClaseSala")
@Controller
public class controllerClaseSala{
private final ClaseSalaRepository repoClaseSala;
	
	public controllerClaseSala(ClaseSalaRepository repoClaseSala) {
		this.repoClaseSala= repoClaseSala;
	}
	
	@PostMapping("/addClaseSala")
    public String addCategoria(ClaseSala ClaseSala, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-ClaseSala";
        }
        repoClaseSala.save(ClaseSala);
        model.addAttribute("clase_sala", repoClaseSala.findAll());
        return "lista-ClaseSala";
    }    
    
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarClaseSala/{idClaseSala}")
	public String showUpdateForm(@PathVariable("idClaseSala") Integer id, Model model) {
		ClaseSala ClaseSala = repoClaseSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la ClaseSala con la id:" + id));
		model.addAttribute("clase_sala", ClaseSala);
		return "update-ClaseSala";
	}
	
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteClaseSala/{idClaseSala}")
	public String delete(@PathVariable("idClaseSala") Integer id, Model model) {
		ClaseSala ClaseSala = repoClaseSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la ClaseSala con la id:" + id));
		repoClaseSala.delete(ClaseSala);
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-ClaseSala")
	public String traerTodos(Model model) {
		Iterable<ClaseSala> lista = repoClaseSala.findAll();
		model.addAttribute("clase_sala", lista);
		for (ClaseSala ClaseSala : lista) {
			System.out.println(ClaseSala.toString());
			
		}
		return "lista-ClaseSala";
}
}
