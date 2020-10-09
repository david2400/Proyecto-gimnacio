package co.com.springboot.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.com.springboot.domain.Instructor;
import co.com.springboot.repository.InstructorRepository;

@RequestMapping("/Instructor")
@Controller
public class controllerInstructor {

	
private final InstructorRepository  repoInstructor;
	
	public controllerInstructor(InstructorRepository repoInstructor) {
		this.repoInstructor= repoInstructor;
	}
	
	@PostMapping("/RegistrarInstructor")
	public String addUser(Instructor user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "RegistrarInstructor";
		}
		Instructor u=repoInstructor.validarUsuario(user.getUsuario());
		Instructor us=repoInstructor.Buscar(user.getCedula());
		if(u==null && us ==null) {
			repoInstructor.save(user);
			model.addAttribute("instructor", repoInstructor.findAll());
			
			return "indexVendedorLogueado";
		}else {
			model.addAttribute("message", "un Instructorya esta registrado con ese Instructoro esa cedula");
			return "RegistrarInstructor";
		}
		
	}
	
	 //controlador Actualizar---------------------------------------------
		@PostMapping("/updateInstructor/{id}")
	    public String updateUser(@PathVariable("id") long id,String correo,String celular,String password,String experienciaLaboral,String foto, @Valid Instructor user, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            user.setCorreo(correo);
	            user.setCelular(celular);
	            user.setExperienciaLaboral(experienciaLaboral);
	            user.setFoto(foto);
	            user.setPassword(password);
	            	            
	            return "Update-Instructor";	         	            
	        }	        
	        repoInstructor.save(user);
	        model.addAttribute("instructor", repoInstructor.findAll());
	        return "index";
	    }
		
	

	@GetMapping("/deleteInstrutor/{cedula}")
	public String delete(@PathVariable("cedula") Integer cedula, Model model) {
		Instructor Instructor= repoInstructor.findById(cedula)
				.orElseThrow(() -> new IllegalArgumentException("Invalid InstructorId:" + cedula));
		repoInstructor.delete(Instructor);
		model.addAttribute("instructor", repoInstructor.findAll());
		return "index";
	}
	
	

	@PostMapping("/LoginInstructor")
	public String Entrar(Instructor usu,Model model) {
		Instructor u = repoInstructor.login(usu.getUsuario(), usu.getPassword());
		if (u!=null) {
			System.out.println(u.getPassword());
			model.addAttribute("Instructor", repoInstructor.findAll());
			return "redirect:/IndexLog";
		}else {
			model.addAttribute("message", "Instructor no se encuentra registrado");
			return "Login";
		}
		
}
}
