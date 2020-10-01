package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.com.springboot.domain.Instructor;
import co.com.springboot.repository.InstructorRepository;

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
	
	@PostMapping("/ModificarInstructor/{cedula}")
	public String updateUser(@PathVariable("cedula") Integer cedula,Instructor user, BindingResult result,
			Model model, @RequestParam("file")MultipartFile file) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "ModificarVendedor";
		}
		if(file.isEmpty()) {	
			return "redirect:/IndexLog";
		}

		try {
			
			//se crea la url del archivofoto
	        Instructor u=new Instructor(user.getIdInstructor(),user.getCedula(),user.getCorreo(), user.get(), user.getNombre(),user.getTelefono(), user.getUsuario(), user.getPassword(),user.getVentas());
			repoInstructor.save(u);
			model.addAttribute("instructor", repoInstructor.findAll());
			return "redirect:/IndexLog";
		} catch (Exception e) {
			
			return "indexLog";
			
		}
		
	}

	@GetMapping("/deleteInstru/{cedula}")
	public String delete(@PathVariable("cedula") Integer cedula, Model model) {
		Instructor Instructor= repoInstructor.findById(cedula)
				.orElseThrow(() -> new IllegalArgumentException("Invalid InstructorId:" + cedula));
		repoInstructor.delete(Instructor);
		model.addAttribute("instructor", repoInstructor.findAll());
		return "index";
	}
	
	

	@PostMapping("/Entrar")
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
