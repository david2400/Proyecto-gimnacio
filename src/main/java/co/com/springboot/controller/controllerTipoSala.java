package co.com.springboot.controller;

import java.util.Optional;

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

import co.com.springboot.repository.TipoSalaRepository;
import co.com.springboot.domain.Tiposala;

@RequestMapping("/TipoSala")
@Controller
public class controllerTipoSala {
	@Autowired
private TipoSalaRepository repoTipoSala;
	
	
	@PostMapping("/addTipoSala")
    public @ResponseBody String addTipoSala(@Valid @RequestBody Tiposala sala,BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "MenuAdmin";
        }
        repoTipoSala.save(sala);
        model.addAttribute("tipoSala", repoTipoSala.findAll());
        return "MenuAdmin";
    }    
    
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarTipoSala/{idTipoSala}")
	public @ResponseBody String showUpdateForm(@PathVariable("idTipoSala") Integer id, Model model) {
		Tiposala TipoSala = repoTipoSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la TipoSala con la id:" + id));
		model.addAttribute("tipoSala", TipoSala);
		return "update-TipoSala";
	}
	
	//controlador Actualizar---------------------------------------------
		@GetMapping("/buscarTipoSala/{idTipoSala}")
		public @ResponseBody String buscar(@PathVariable("idTipoSala") Integer id, Model model) {
			Tiposala TipoSala = repoTipoSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la TipoSala con la id:" + id));
			model.addAttribute("tipoSala", TipoSala);
			return "update-TipoSala";
		}
        
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteTipoSala/{idTipoSala}")
	public @ResponseBody String delete(@PathVariable("idTipoSala") Integer id, Model model) {
		Tiposala TipoSala = repoTipoSala.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la TipoSala con la id:" + id));
		repoTipoSala.delete(TipoSala);
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-TipoSala")
	public @ResponseBody String traerTodos(Model model) {
		Iterable<Tiposala> lista = repoTipoSala.findAll();
		model.addAttribute("tipoSala", lista);
		
		return "lista-TipoSala";
	
}
}
