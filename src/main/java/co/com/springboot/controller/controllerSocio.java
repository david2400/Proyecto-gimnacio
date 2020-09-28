package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.com.springboot.domain.Socio;
import co.com.springboot.repository.SocioRepository;

@Controller
public class controllerSocio {
	
private final SocioRepository  repoSocio;
	
	public controllerSocio(SocioRepository repoSocio) {
		this.repoSocio= repoSocio;
	}
	
	@PostMapping("/RegistrarSocio")
	public String addUser(Socio user, BindingResult result, Model model) {
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
	
	@PostMapping("/ModificarSocio/{cedula}")
	public String updateUser(@PathVariable("cedula") Integer cedula,Socio user, BindingResult result,
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
	        Socio u=new Socio(user.getIdSocio(),user.getCedula(),user.getCorreo(), user.get(), user.getNombre(),user.getTelefono(), user.getUsuario(), user.getPassword(),user.getVentas());
			repoSocio.save(u);
			model.addAttribute("socio", repoSocio.findAll());
			return "redirect:/IndexLog";
		} catch (Exception e) {
			
			return "indexLog";
			
		}
		
	}

	@GetMapping("/deleteSocio/{cedula}")
	public String delete(@PathVariable("cedula") Integer cedula, Model model) {
		Socio Socio= repoSocio.findById(cedula)
				.orElseThrow(() -> new IllegalArgumentException("Invalid SocioId:" + cedula));
		repoSocio.delete(Socio);
		model.addAttribute("socio", repoSocio.findAll());
		return "index";
	}
	
	

	@PostMapping("/Entrar")
	public String Entrar(Socio usu,Model model) {
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
