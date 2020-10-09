package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.springboot.domain.Maquina;
import co.com.springboot.repository.MaquinaRepository;

@RequestMapping("/Maquina")
@Controller
public class controllerMaquina {
private final MaquinaRepository  repoMaquina;
	
	public controllerMaquina (MaquinaRepository repoMaquina ) {
		this.repoMaquina = repoMaquina ;
	}
	
	@PostMapping("/addMaquinas")
    public String addCategoria(Maquina  Maquina , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-Maquina ";
        }
        repoMaquina .save(Maquina );
        model.addAttribute("maquinas", repoMaquina .findAll());
        return "lista-Maquina ";
    }    
    
    //controlador buscador por id---------------------------------------------
	@GetMapping("/seachMaquina /{idMaquinas}")
	public String buscar(@PathVariable("idMaquinas") Integer id) {
		Maquina  Maquina  = repoMaquina .findById(id).orElseThrow(() -> new IllegalArgumentException("Invalido Maquina  id:" + id));

		String mensaje = "ID: " + Maquina .getIdMaquinas() + " - Nombre " + Maquina .getEstado().toString();
		System.out.println(mensaje);
		
		return "Buscar";
	}
    
 
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteMaquina /{idMaquinas}")
	public String delete(@PathVariable("idMaquinas") Integer id, Model model) {
		Maquina  Maquina  = repoMaquina .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Maquina  con la id:" + id));
		repoMaquina .delete(Maquina );
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-Maquinas")
	public String traerTodos(Model model) {
		Iterable<Maquina > lista = repoMaquina .findAll();
		model.addAttribute("maquinas", lista);
		for (Maquina  Maquina  : lista) {
			System.out.println(Maquina .toString());
			
		}
		return "lista-Maquina";
	}	
}
