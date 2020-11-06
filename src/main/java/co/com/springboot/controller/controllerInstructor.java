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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.Instructor;
import co.com.springboot.repository.InstructorRepository;

@Controller
public class controllerInstructor {

	@Autowired
private InstructorRepository  repoInstructor;
		
	@GetMapping("/LoginUpInstructor")
    public String showSignUpForm(Instructor instructor) {
        return "MenuInstructor";
    }
	
	
	@PostMapping("/RegistrarInstructor")
	public @ResponseBody String addUser(@Valid @ModelAttribute("instructor") Instructor instructor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("instructor", instructor);
        	model.addAttribute("FormInstructor","active");		}
		
		Instructor u=repoInstructor.validarUsuario(instructor.getUsuario());
		Instructor us=repoInstructor.Buscar(instructor.getCedula());
		if(u==null && us ==null) {
			repoInstructor.save(instructor);
			model.addAttribute("Instructores", repoInstructor.findAll());
			model.addAttribute("FormInstructor","active");
			return "MenuAdmin";
		}else {
			model.addAttribute("message", "un usuario ya esta registrado con esa cedula");
			return "MenuAdmin";
		}		
	}
	
	@GetMapping("/deleteInstrutor/{cedula}")
	public @ResponseBody String delete(@PathVariable("cedula") Integer cedula, Model model) {
		Instructor Instructor= repoInstructor.Buscar(cedula);
		repoInstructor.delete(Instructor);
		model.addAttribute("Instructores", repoInstructor.findAll());
		return "MenuAdmin";
	}
	
	 //controlador Actualizar---------------------------------------------
		@PostMapping("/updateInstructor/{cedula}")
	    public @ResponseBody String updateUser(@PathVariable("cedula") Integer cedula, @Valid Instructor user, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	           return "MenuAdmin";	         	            
	        }	        
	        repoInstructor.save(user);
	        model.addAttribute("Instructores", repoInstructor.findAll());
	        return "MenuAdmin";
	    }
			
	
	@PostMapping("/EntrarInstructor")
	public @ResponseBody String Entrar(Instructor usu ,Model model) {
		Instructor u = repoInstructor.login(usu.getUsuario(), usu.getPassword());
		if (u!=null) {
			model.addAttribute("Instructores", repoInstructor.findAll());
			return "redirect:/MenuAdmin";
		}else {
			model.addAttribute("message", "usuario no se encuentra registrado");
			return "index";
		}
		
	}		

	@RequestMapping(value = "/LoginInstructor",method = RequestMethod.POST)
	public @ResponseBody String login(@RequestParam(required = false, value = "Login") String Login,@RequestParam(required = false, value = "Cancelar") String cancelar,
			@Valid Instructor user,	BindingResult result, Model model) {
		if ("Login".equals(Login)) {
			return Entrar(user, model);
		} else if ("Cancelar".equals(cancelar)) {
			return "index";
		}
		return "index";
	}
}
