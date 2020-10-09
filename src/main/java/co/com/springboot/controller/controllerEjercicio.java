package co.com.springboot.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.springboot.domain.Ejercicio;
import co.com.springboot.repository.EjercicioRepository;

@RequestMapping("/Ejercicio")
@Controller
public class controllerEjercicio {

private final EjercicioRepository repoEjercicio;
	
	public controllerEjercicio(EjercicioRepository repoEjercicio) {
		this.repoEjercicio= repoEjercicio;
	}
	
	@PostMapping("/addEjercicio")
    public String addCategoria(Ejercicio Ejercicio, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-Ejercicio";
        }
        repoEjercicio.save(Ejercicio);
        model.addAttribute("ejercicio", repoEjercicio.findAll());
        return "lista-Ejercicio";
    }    
    
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarEjercicio/{idEjercicio}")
	public String showUpdateForm(@PathVariable("idEjercicio") Integer id, Model model) {
		Ejercicio Ejercicio = repoEjercicio.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Ejercicio con la id:" + id));
		model.addAttribute("ejercicio", Ejercicio);
		return "update-Ejercicio";
	}
	
	
    
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteEjercicio/{idEjercicio}")
	public String delete(@PathVariable("idEjercicio") Integer id, Model model) {
		Ejercicio Ejercicio = repoEjercicio.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Ejercicio con la id:" + id));
		repoEjercicio.delete(Ejercicio);
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-Ejercicio")
	public String traerTodos(Model model) {
		Iterable<Ejercicio> lista = repoEjercicio.findAll();
		model.addAttribute("ejercicio", lista);
		for (Ejercicio Ejercicio : lista) {
			System.out.println(Ejercicio.toString());
			
		}
		return "lista-Ejercicio";
	
}
}
