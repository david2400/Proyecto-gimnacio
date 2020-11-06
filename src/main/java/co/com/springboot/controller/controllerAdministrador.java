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


import co.com.springboot.domain.Administrador;
import co.com.springboot.domain.Instructor;
import co.com.springboot.domain.Maquina;
import co.com.springboot.domain.Sala;
import co.com.springboot.domain.Socio;
import co.com.springboot.repository.AdministradorRepository;
import co.com.springboot.repository.ClaseRepository;
import co.com.springboot.repository.InstructorRepository;
import co.com.springboot.repository.MaquinaRepository;
import co.com.springboot.repository.SalaRepository;
import co.com.springboot.repository.SocioRepository;
import co.com.springboot.repository.TipoSalaRepository;


@Controller
public class controllerAdministrador {
	
	@Autowired
    private AdministradorRepository  repoAdministrador;
	@Autowired
	private SocioRepository  repoSocio;
	@Autowired
	private ClaseRepository  repoClase;
	@Autowired
	private InstructorRepository  repoInstructor;
	@Autowired
	private MaquinaRepository  repoMaquina;
	@Autowired
	private TipoSalaRepository  repoTipoSala;
	@Autowired
	private SalaRepository  repoSala;
	
	
	@GetMapping("/LoginAdministrador")
    public String MenuAdministrador(Model model,@ModelAttribute("socio") Socio socio,@ModelAttribute("instructor")
    Instructor instructor,@ModelAttribute("maquina")Maquina maquina,@ModelAttribute("sala")Sala sala) {
		
        return "MenuAdmin";
    }
	
	@GetMapping("/Socio")
    public String MenuAdministrador(Model model,@ModelAttribute("socio") Socio socio) {
		model.addAttribute("FormSocio","active");
        return "MenuAdmin";
    }
	
		
	@PostMapping("/RegistrarAdministrador")
	public @ResponseBody String RegistrarAdministrador(@Valid @ModelAttribute("administrador") Administrador administrador, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("administrador", administrador);
        	model.addAttribute("FormAdministrador","active");
		}
		Administrador u=repoAdministrador.validarUsuario(administrador.getUsuario());
		Administrador us=repoAdministrador.Buscar(administrador.getCedula());
		if(u==null && us ==null) {
			repoAdministrador.save(administrador);
			model.addAttribute("administradores", repoAdministrador.findAll());
			
			return "redirect:/RegistrarSocio";
		}else {
			model.addAttribute("message", "Ya esta registrado ese usuario con esa  cedula");
			return "redirect:/RegistrarSocio";
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
