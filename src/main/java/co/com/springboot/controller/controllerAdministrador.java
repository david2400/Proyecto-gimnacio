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


import co.com.springboot.domain.Administrador;
import co.com.springboot.repository.AdministradorRepository;

@Controller
@RequestMapping("/Administrador")
public class controllerAdministrador {
	
	@Autowired
private AdministradorRepository  repoAdministrador;
	
	@GetMapping("/singUpAdmin")
    public String showSignUpForm(Administrador admin) {
        return "MenuAdmin";
    }
	
	@GetMapping("/singadmin")
    public String showSignUpForm() {
        return "add-admin";
    }
	
	@PostMapping("/RegistrarAdministrador")
	public @ResponseBody String addUser(Administrador user, BindingResult result, Model model) {
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
    public @ResponseBody String updateUser(@PathVariable("id") long id,String correo,String celular,String password,String foto, @Valid Administrador user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setCorreo(correo);
            user.setCelular(celular);
            user.setFoto(foto);
            user.setPassword(password);
            
            
            return "MenuAdmin";	         	            
        }	        
        repoAdministrador.save(user);
        model.addAttribute("users", repoAdministrador.findAll());
        return "index";
    }
	
	@PostMapping("/EntrarAdministrador")
	public String Entrar(Administrador usu ,Model model) {
		Administrador u = repoAdministrador.login(usu.getUsuario(), usu.getPassword());
		if (u!=null) {
			model.addAttribute("administrador", repoAdministrador.findAll());
			return "redirect:/IndexLog";
		}else {
			model.addAttribute("message", "usuario no se encuentra registrado");
			return "Login";
		}
		
	}
		

	@RequestMapping(value = "/LoginAdministrador",method = RequestMethod.POST)
	public String login(@RequestParam(required = false, value = "Login") String Login,
			@RequestParam(required = false, value = "Cancelar") String cancelar, @Valid Administrador user,
			BindingResult result, Model model) {
		if ("Login".equals(Login)) {
			return Entrar(user, model);
		} else if ("Cancelar".equals(cancelar)) {
			return "index";
		}
		return "index";
	}
}
