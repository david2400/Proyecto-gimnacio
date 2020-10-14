package co.com.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.Instructor;
import co.com.springboot.repository.InstructorRepository;

@RequestMapping("/Instructor")
@Controller
public class controllerInstructor {

	@Autowired
private InstructorRepository  repoInstructor;
	
	
	
	@PostMapping("/RegistrarInstructor")
	public @ResponseBody String addUser(Instructor user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "MenuAdmin";
		}
		Instructor u=repoInstructor.validarUsuario(user.getUsuario());
		Instructor us=repoInstructor.Buscar(user.getCedula());
		if(u==null && us ==null) {
			repoInstructor.save(user);
			model.addAttribute("Instructor", repoInstructor.findAll());
			
			return "index";
		}else {
			model.addAttribute("message", "un Instructorya esta registrado con ese Instructoro esa cedula");
			return "MenuAdmin";
		}		
	}
	
	@GetMapping("/deleteInstrutor/{cedula}")
	public @ResponseBody String delete(@PathVariable("cedula") Integer cedula, Model model) {
		Instructor Instructor= repoInstructor.Buscar(cedula);
		repoInstructor.delete(Instructor);
		model.addAttribute("Instructor", repoInstructor.findAll());
		return "MenuAdmin";
	}
	
	 //controlador Actualizar---------------------------------------------
		@PostMapping("/updateInstructor/{cedula}")
	    public @ResponseBody String updateUser(@PathVariable("cedula") long id,String correo,String celular,String password,String experienciaLaboral,String foto, @Valid Instructor user, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            user.setCorreo(correo);
	            user.setCelular(celular);
	            user.setExperienciaLaboral(experienciaLaboral);
	            user.setFoto(foto);
	            user.setPassword(password);
	            	            
	            return "MenuAdmin";	         	            
	        }	        
	        repoInstructor.save(user);
	        model.addAttribute("Instructor", repoInstructor.findAll());
	        return "MenuAdmin";
	    }
			
	
	@PostMapping("/EntrarInstructor")
	public @ResponseBody String Entrar(Instructor usu ,Model model) {
		Instructor u = repoInstructor.login(usu.getUsuario(), usu.getPassword());
		if (u!=null) {
			model.addAttribute("Instructor", repoInstructor.findAll());
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
