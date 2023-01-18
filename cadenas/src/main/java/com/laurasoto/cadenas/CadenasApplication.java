package com.laurasoto.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasApplication.class, args);
	}

	@RequestMapping("/")
	public String buenMensaje() {
		return "Hola cliente, ¿como estas?";
	}

	@RequestMapping("/random")
	public String buenmensajeSpring() {
		return "spring good";
	}
}