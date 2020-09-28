package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.com.springboot.domain.Administrador;
import co.com.springboot.repository.AdministradorRepository;

@Controller
public class controllerAdministrador {
	
private final AdministradorRepository  repoAdministrador;
	
	public controllerAdministrador(AdministradorRepository repoAdministrador) {
		this.repoAdministrador= repoAdministrador;
	}
	
	@PostMapping("/RegistrarAdministrador")
	public String addUser(Administrador user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "RegistrarAdministrador";
		}
		Administrador u=repoAdministrador.validarUsuario(user.getUsuario());
		Administrador us=repoAdministrador.Buscar(user.getCedula());
		if(u==null && us ==null) {
			repoAdministrador.save(user);
			model.addAttribute("administrador", repoAdministrador.findAll());
			
			return "indexAdministradorLogueado";
		}else {
			model.addAttribute("message", "un Administrador ya esta registrado con ese Administradoro esa cedula");
			return "RegistrarAdministrador";
		}
		
	}
	
	@PostMapping("/ModificarAdministrador/{cedula}")
	public String updateUser(@PathVariable("cedula") Integer cedula,Administrador user, BindingResult result,
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
	        Administrador u=new Administrador(user.getIdAdministrador(),user.getCedula(),user.getCorreo(), user.get(), user.getNombre(),user.getTelefono(), user.getUsuario(), user.getPassword(),user.getVentas());
			repoAdministrador.save(u);
			model.addAttribute("administrador", repoAdministrador.findAll());
			return "redirect:/IndexLog";
		} catch (Exception e) {
			
			return "indexLog";
			
		}
		
	}

	@GetMapping("/deleteVendedor/{cedula}")
	public String delete(@PathVariable("cedula") Integer cedula, Model model) {
		Administrador administrador= repoAdministrador.findById(cedula)
				.orElseThrow(() -> new IllegalArgumentException("Invalid AdministradorId:" + cedula));
		repoAdministrador.delete(administrador);
		model.addAttribute("administrador", repoAdministrador.findAll());
		return "index";
	}
	
	

	@PostMapping("/Entrar")
	public String Entrar(Administrador usu,Model model) {
		Administrador u = repoAdministrador.login(usu.getUsuario(), usu.getPassword());
		if (u!=null) {
			System.out.println(u.getPassword());
			model.addAttribute("administrador", repoAdministrador.findAll());
			return "redirect:/IndexLog";
		}else {
			model.addAttribute("message", "Administradorno se encuentra registrado");
			return "Login";
		}
		
	}
}
