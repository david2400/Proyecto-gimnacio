package co.com.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import co.com.springboot.domain.Administrador;
import co.com.springboot.repository.AdministradorRepository;

@RequestMapping("/Administrador")
@Controller
public class controllerAdministrador {
	
	@Autowired
private AdministradorRepository  repoAdministrador;
	
	@GetMapping("/LoginAdministrador")
    public String showSignUpForm() {
        return "MenuAdmin";
    }
	
	@GetMapping("/about")
    public String about() {
        return "about";
    }
	
	@PostMapping("/RegistrarAdministrador")
	public @ResponseBody String addUser(@Valid @RequestBody Administrador user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "RegistrarAdministrador";
		}
		Administrador u=repoAdministrador.validarUsuario(user.getUsuario());
		Administrador us=repoAdministrador.Buscar(user.getCedula());
		if(u==null && us ==null) {
			repoAdministrador.save(user);
			model.addAttribute("Administradores", repoAdministrador.findAll());
			
			return "indexAdministradorLogueado";
		}else {
			model.addAttribute("message", "un Administrador ya esta registrado con ese Administradoro esa cedula");
			return "RegistrarAdministrador";
		}	
	}
	
	
	@PostMapping("/updateAdministrador/{cedula}")
    public @ResponseBody String updateUser(@PathVariable("cedula") Integer cedula,String correo,String celular, BindingResult result, Model model) {
        if (result.hasErrors()) {          
            return "MenuAdmin";	         	            
        }	                
        Administrador user=repoAdministrador.Buscar(cedula);
        user.setCorreo(correo);
        user.setCelular(celular);

        repoAdministrador.save(user);
        model.addAttribute("Administradores", repoAdministrador.findAll());
        return "index";
    }
	
	@PostMapping("/EntrarAdministrador")
	public String Entrar(Administrador usu ,Model model) {
		Administrador u = repoAdministrador.login(usu.getUsuario(), usu.getPassword());
		if (u!=null) {
			model.addAttribute("Administradores", repoAdministrador.findAll());
			return "redirect:/MenuAdmin";
		}else {
			model.addAttribute("message", "usuario no se encuentra registrado");
			return "Login";
		}
		
	}
		

	@RequestMapping(value = "/LoginAdministrador",method = RequestMethod.POST)
	public String login(@RequestParam(required = false, value = "Login") String Login,@RequestParam(required = false, value = "Cancelar") String cancelar, @Valid Administrador user,
			BindingResult result, Model model) {
		if ("Login".equals(Login)) {
			return Entrar(user, model);
		} else if ("Cancelar".equals(cancelar)) {
			return "index";
		}
		return "index";
	}
}
