package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.springboot.repository.TipoSalaRepository;
import co.com.springboot.domain.Tiposala;

@Controller
public class controllerTipoSala {
private final TipoSalaRepository repoTipoSala;
	
	public controllerTipoSala(TipoSalaRepository repoTipoSala) {
		this.repoTipoSala= repoTipoSala;
	}
	
	@PostMapping("/addTipoSala")
    public String addCategoria(Tiposala TipoSala, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-TipoSala";
        }
        repoTipoSala.save(TipoSala);
        model.addAttribute("tipoSala", repoTipoSala.findAll());
        return "lista-TipoSala";
    }    
    
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarTipoSala/{idTipoSala}")
	public String showUpdateForm(@PathVariable("idTipoSala") Integer id, Model model) {
		Tiposala TipoSala = repoTipoSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la TipoSala con la id:" + id));
		model.addAttribute("tipoSala", TipoSala);
		return "update-TipoSala";
	}
	
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteTipoSala/{idTipoSala}")
	public String delete(@PathVariable("idTipoSala") Integer id, Model model) {
		Tiposala TipoSala = repoTipoSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la TipoSala con la id:" + id));
		repoTipoSala.delete(TipoSala);
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-TipoSala")
	public String traerTodos(Model model) {
		Iterable<Tiposala> lista = repoTipoSala.findAll();
		model.addAttribute("tipoSalas", lista);
		for (Tiposala TipoSala : lista) {
			System.out.println(TipoSala.toString());
			
		}
		return "lista-TipoSala";
	
}
}
