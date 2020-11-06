package co.com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@ComponentScan(basePackages= {"co.com.springboot.controller"})
public class ProyectoGimnasioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoGimnasioApplication.class, args);
	}
	


}
