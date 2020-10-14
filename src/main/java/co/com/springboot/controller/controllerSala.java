package co.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.Sala;
import co.com.springboot.repository.SalaRepository;

@RequestMapping("/Sala")
@Controller
public class controllerSala {
	@Autowired
private SalaRepository repoSala;
	
	
	@PostMapping("/addSala")
    public @ResponseBody String addCategoria(Sala Sala, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "MenuAdmin";
        }
        repoSala.save(Sala);
        model.addAttribute("sala", repoSala.findAll());
        return "MenuAdmin";
    }    
    
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarSala/{idSala}")
	public @ResponseBody String showUpdateForm(@PathVariable("idSala") Integer id, Model model) {
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
		for (Sala Sala : lista) {
			System.out.println(Sala.toString());
			
		}
		return "lista-Sala";
	
}
}
