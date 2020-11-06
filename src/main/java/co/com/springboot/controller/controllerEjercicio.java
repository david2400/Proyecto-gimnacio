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
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.Ejercicio;
import co.com.springboot.repository.EjercicioRepository;

@Controller
public class controllerEjercicio {
	@Autowired
private  EjercicioRepository repoEjercicio;
	
	@PostMapping("/RegistrarEjercicio")
    public @ResponseBody String addCategoria(@Valid @ModelAttribute("ejercicio") Ejercicio Ejercicio, BindingResult result, Model model) {
        if (result.hasErrors()) {        	
        	model.addAttribute("ejercicios", Ejercicio);
        	model.addAttribute("FormEjercicio","active");
        }else {
        repoEjercicio.save(Ejercicio);
        model.addAttribute("ejercicios", repoEjercicio.findAll());
        model.addAttribute("FormEjercicio","active"); }
        return "MenuInstructor";
    }    
    
    
  //controlador Actualizar---------------------------------------------
	@GetMapping("/editarEjercicio/{idEjercicio}")
	public @ResponseBody String showUpdateForm(@PathVariable("idEjercicio") Integer id, Model model) {
		Ejercicio Ejercicio = repoEjercicio.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Ejercicio con la id:" + id));
		model.addAttribute("ejercicios", Ejercicio);
		return "update-Ejercicio";
	}
	   
    
    //controlador Eliminar---------------------------------------------
	@GetMapping("/deleteEjercicio/{idEjercicio}")
	public @ResponseBody String delete(@PathVariable("idEjercicio") Integer id, Model model) {
		Ejercicio Ejercicio = repoEjercicio.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe la Ejercicio con la id:" + id));
		repoEjercicio.delete(Ejercicio);
			
		return traerTodos(model);
	}
	
	@GetMapping("/Todos-Ejercicio")
	public @ResponseBody String traerTodos(Model model) {
		Iterable<Ejercicio> lista = repoEjercicio.findAll();
		model.addAttribute("ejercicios", lista);
		
		return "lista-Ejercicio";
		}
	
	@GetMapping("/Lista-Ejercicio-rutina")
	public @ResponseBody String ListaEjercicio(Integer idRutina,Model model) {
		Iterable<Ejercicio> lista = repoEjercicio.EjercicioRutina(idRutina);
		model.addAttribute("admins", lista);
		
		return "lista-admin";
	}
	
}
