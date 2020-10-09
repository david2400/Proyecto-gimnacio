package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.springboot.domain.Sala;
import co.com.springboot.repository.SalaRepository;

@RequestMapping("/Sala")
@Controller
public class controllerSala {
private final SalaRepository repoSala;
	
	public controllerSala(SalaRepository repoSala) {
		this.repoSala= repoSala;
	}
	
	@PostMapping("/addSala")
    public String addCategoria(Sala Sala, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-Sala";
        }
        repoSala.save(Sala);
        model.addAttribute("sala", repoSala.findAll());
        return "lista-Sala";
    }    
    
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarSala/{idSala}")
	public String showUpdateForm(@PathVariable("idSala") Integer id, Model model) {
		Sala Sala = repoSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Sala con la id:" + id));
		model.addAttribute("sala", Sala);
		return "update-Sala";
	}
	
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteSala/{idSala}")
	public String delete(@PathVariable("idSala") Integer id, Model model) {
		Sala Sala = repoSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Sala con la id:" + id));
		repoSala.delete(Sala);
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-Sala")
	public String traerTodos(Model model) {
		Iterable<Sala> lista = repoSala.findAll();
		model.addAttribute("sala", lista);
		for (Sala Sala : lista) {
			System.out.println(Sala.toString());
			
		}
		return "lista-Sala";
	
}
}
