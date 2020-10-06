package co.com.springboot.controller;

import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.com.springboot.domain.Administrador;
import co.com.springboot.domain.Instructor;
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
	
	@PostMapping("/updateAdministrador/{id}")
    public String updateUser(@PathVariable("id") long id,String correo,String celular,String password,String foto, @Valid Administrador user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setCorreo(correo);
            user.setCelular(celular);
            user.setFoto(foto);
            user.setPassword(password);
            
            
            return "Update-Administrador";	         	            
        }	        
        repoAdministrador.save(user);
        model.addAttribute("users", repoAdministrador.findAll());
        return "index";
    }
	
	
	@GetMapping("/deleteAdministrador/{cedula}")
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
