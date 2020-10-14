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

import co.com.springboot.domain.Maquina;
import co.com.springboot.repository.MaquinaRepository;

@RequestMapping("/Maquina")
@Controller
public class controllerMaquina {
	@Autowired
private MaquinaRepository  repoMaquina;
	
	
	@PostMapping("/addMaquinas")
    public @ResponseBody String addCategoria(Maquina  Maquina , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "MenuAdmin";
        }
        repoMaquina .save(Maquina );
        model.addAttribute("maquinas", repoMaquina .findAll());
        return "MenuAdmin";
    }    
    
    //controlador buscador por id---------------------------------------------
	@GetMapping("/seachMaquina /{idMaquinas}")
	public @ResponseBody String buscar(@PathVariable("idMaquinas") Integer id) {
		Maquina  Maquina  = repoMaquina .findById(id).orElseThrow(() -> new IllegalArgumentException("Invalido Maquina  id:" + id));

		String mensaje = "ID: " + Maquina .getIdMaquinas() + " - Nombre " + Maquina .getEstado().toString();
		System.out.println(mensaje);
		
		return "Buscar";
	}
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteMaquina /{idMaquinas}")
	public @ResponseBody String delete(@PathVariable("idMaquinas") Integer id, Model model) {
		Maquina  Maquina  = repoMaquina .findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Maquina  con la id:" + id));
		repoMaquina .delete(Maquina );
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-Maquinas")
	public @ResponseBody String traerTodos(Model model) {
		Iterable<Maquina > lista = repoMaquina .findAll();
		model.addAttribute("maquinas", lista);
		for (Maquina  Maquina  : lista) {
			System.out.println(Maquina .toString());
			
		}
		return "MenuAdmin";
	}	
}
