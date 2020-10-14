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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.com.springboot.domain.Socio;
import co.com.springboot.repository.SocioRepository;

@RequestMapping("/Socio")
@Controller
public class controllerSocio {
	@Autowired	
private SocioRepository  repoSocio;
	
	
	@PostMapping("/RegistrarSocio")
	public @ResponseBody String addUser(Socio user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "RegistrarSocio";
		}
		Socio u=repoSocio.validarUsuario(user.getUsuario());
		Socio us=repoSocio.Buscar(user.getCedula());
		if(u==null && us ==null) {
			repoSocio.save(user);
			model.addAttribute("socio", repoSocio.findAll());
			
			return "indexVendedorLogueado";
		}else {
			model.addAttribute("message", "un Socioya esta registrado con ese Socioo esa cedula");
			return "RegistrarSocio";
		}
		
	}
	
	@PostMapping("/updateSocio/{id}")
    public @ResponseBody String updateUser(@PathVariable("id") long id,String correo,String direccion,String password,String profesion, @Valid Socio user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setCorreo(correo);
            user.setDireccion(direccion);
            user.setProfesion(profesion);
            user.setPassword(password);           
            
            return "Update-Administrador";	         	            
        }	        
        repoSocio.save(user);
        model.addAttribute("users", repoSocio.findAll());
        return "index";
    }
	
	@GetMapping("/deleteSocio/{cedula}")
	public @ResponseBody String delete(@PathVariable("cedula") Integer cedula, Model model) {
		Socio Socio= repoSocio.findById(cedula)
				.orElseThrow(() -> new IllegalArgumentException("Invalid SocioId:" + cedula));
		repoSocio.delete(Socio);
		model.addAttribute("socio", repoSocio.findAll());
		return "index";
	}
	
	

	@PostMapping("/LoginSocio")
	public @ResponseBody String Entrar(Socio usu,Model model) {
		Socio u = repoSocio.login(usu.getUsuario(), usu.getPassword());
		if (u!=null) {
			System.out.println(u.getPassword());
			model.addAttribute("socio", repoSocio.findAll());
			return "redirect:/IndexLog";
		}else {
			model.addAttribute("message", "Socio no se encuentra registrado");
			return "Login";
		}
		
	}
}
