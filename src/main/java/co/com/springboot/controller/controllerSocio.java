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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.springboot.domain.Socio;
import co.com.springboot.repository.SocioRepository;

@Controller
public class controllerSocio {
	@Autowired	
private SocioRepository  repoSocio;
	
	@GetMapping("/Registrar")
    public String Registrarse(Model model,Socio socio) {
        return "RegistrarSocio";
    }	
	
	@PostMapping("/RegistrarSocio")
	public @ResponseBody String RegistrarSocio(@Valid @ModelAttribute("socio") Socio socio, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("socio", socio);
		}
		Socio u=repoSocio.validarUsuario(socio.getUsuario());
		Socio us=repoSocio.Buscar(socio.getCedula());
		if(u==null && us ==null) {
			repoSocio.save(socio);
			model.addAttribute("socios", repoSocio.findAll());
			
			return "redirect:/RegistrarSocio";
		}else {
			model.addAttribute("message", "un Socio ya esta registrado con ese Socioo esa cedula");
			return "redirect:/RegistrarSocio";
		}		
	}
	
	@PostMapping("/RegistrarSocioAdmin")
	public @ResponseBody String RegistrarSocioAdmin(@Valid @ModelAttribute("socio") Socio socio, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("socio", socio);
        	model.addAttribute("FormSocio","active");
		}
		Socio u=repoSocio.validarUsuario(socio.getUsuario());
		Socio us=repoSocio.Buscar(socio.getCedula());
		if(u==null && us ==null) {
			repoSocio.save(socio);
			model.addAttribute("socios", repoSocio.findAll());
			
			return "redirect:/LoginAdministrador";
		}else {
			model.addAttribute("message", "un Socio ya esta registrado con ese Socioo esa cedula");
			return "redirect:/LoginAdministrador";
		}		
	}
	
	@PostMapping("/updateSocio/{id}")
    public @ResponseBody String updateUser(@PathVariable("id") long id,String correo,String direccion,String password,String profesion, @Valid @RequestBody Socio user,BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setCorreo(correo);
            user.setDireccion(direccion);
            user.setProfesion(profesion);
            user.setPassword(password);           
            
            return "Update-Administrador";	         	            
        }	        
        repoSocio.save(user);
        model.addAttribute("Socios", repoSocio.findAll());
        return "index";
    }
	
	@GetMapping("/deleteSocio/{cedula}")
	public @ResponseBody String delete(@PathVariable("cedula") Integer cedula, Model model) {
		Socio Socio= repoSocio.findById(cedula)
				.orElseThrow(() -> new IllegalArgumentException("Invalid SocioId:" + cedula));
		repoSocio.delete(Socio);
		model.addAttribute("Socios", repoSocio.findAll());
		return "redirect:/LoginAdministrador";
	}
	
	

	@PostMapping("/LoginSocio")
	public @ResponseBody String Entrar(Socio usu,Model model) {
		Socio u = repoSocio.login(usu.getUsuario(), usu.getPassword());
		if (u!=null) {
			System.out.println(u.getPassword());
			model.addAttribute("Socios", repoSocio.findAll());
			return "redirect:/LoginSocio";
		}else {
			model.addAttribute("message", "Socio no se encuentra registrado");
			return "Login";
		}
		
	}
}
