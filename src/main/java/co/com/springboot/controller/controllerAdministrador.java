package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.example.repository.AdministradorRepository;
import co.com.springboot.domain.Administrador;

@Controller
public class controllerAdministrador {
private final AdministradorRepository  repoAdministrador;
	
	public controllerAdministrador(AdministradorRepository repoAdministrador) {
		this.repoAdministrador= repoAdministrador;
	}
	
	@PostMapping("/Registrar")
	public String addUser(Administrador user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "RegistrarVendedor";
		}
		Administrador u=repoAdministrador.validarUsuario(user);
		Administrador us=repoAdministrador.Buscar(user.getCedula());
		if(u==null && us ==null) {
			repoVendedor.save(user);
			model.addAttribute("vendedor", repoVendedor.findAll());
			
			return "indexVendedorLogueado";
		}else {
			model.addAttribute("message", "un Vendedor ya esta registrado con ese Vendedor o esa cedula");
			return "RegistrarVendedors";
		}
		
	}
	
	@PostMapping("/ModificarVendedor/{cedula}")
	public String updateUser(@PathVariable("cedula") Integer cedula,Vendedor user, BindingResult result,
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
	        Vendedor u=new Vendedor(user.getIdVendedor(),user.getCedula(),user.getCorreo(), user.getDireccion(), user.getNombre(),user.getTelefono(), user.getUsuario(), user.getPassword(),user.getVentas());
			repoVendedor.save(u);
			model.addAttribute("vendedor", repoVendedor.findAll());
			return "redirect:/IndexLog";
		} catch (Exception e) {
			
			return "indexLog";
			
		}
		
	}

	@GetMapping("/deleteVendedor/{cedula}")
	public String delete(@PathVariable("cedula") Integer cedula, Model model) {
		Vendedor Vendedor = repoVendedor.findById(cedula)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Vendedor Id:" + cedula));
		repoVendedor.delete(Vendedor);
		model.addAttribute("vendedor", repoVendedor.findAll());
		return "index";
	}
	
	

	@PostMapping("/Entrar")
	public String Entrar(Vendedor usu ,Model model) {
		Vendedor u = repoVendedor.login(usu.getUsuario(), usu.getPassword());
		if (u!=null) {
			System.out.println(u.getPassword());
			model.addAttribute("vendedor", repoVendedor.findAll());
			return "redirect:/IndexLog";
		}else {
			model.addAttribute("message", "Vendedor no se encuentra registrado");
			return "Login";
		}
		
	}
}
