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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.Sala;
import co.com.springboot.repository.SalaRepository;

@Controller
public class controllerSala {
	@Autowired
private SalaRepository repoSala;
	
	
	@PostMapping("/RegistrarSala")
    public @ResponseBody String RegistrarSala(@Valid @ModelAttribute("sala") Sala sala, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("sala", sala);
        	model.addAttribute("FormSala","active");
        }else {
        repoSala.save(sala);
        model.addAttribute("salas", repoSala.findAll());}
        return "redirect:/RegistrarSocio";
    }    
    
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarSala/{idSala}")
	public @ResponseBody String updateSala(@PathVariable("idSala") Integer id, Model model) {
		Sala Sala = repoSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Sala con la id:" + id));
		model.addAttribute("sala", Sala);
		return "MenuAdmin";
	}	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteSala/{idSala}")
	public @ResponseBody String delete(@PathVariable("idSala") Integer id, Model model) {
		Sala Sala = repoSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Sala con la id:" + id));
		repoSala.delete(Sala);
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-Sala")
	public @ResponseBody String traerTodos(Model model) {
		Iterable<Sala> lista = repoSala.findAll();
		model.addAttribute("sala", lista);
		
		return "lista-Sala";
	
}
}
