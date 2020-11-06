package co.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerAplication {

	@GetMapping("/")
    public String showSignUpForm() {
        return "inicio";
    }
	
	@GetMapping("/about")
    public String about() {
        return "about";
    }
	
	@GetMapping("/planes")
    public String planes() {
        return "planes";
    }
	
	@GetMapping("/contactenos")
    public String contactenos() {
        return "contact";
    }
	
	
	@GetMapping("/login")
    public String Login() {
        return "login";
    }
	
}
