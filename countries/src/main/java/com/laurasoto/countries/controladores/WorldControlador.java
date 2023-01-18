package com.laurasoto.countries.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.laurasoto.countries.servicios.ApiService;

@Controller
public class WorldControlador {
	private final ApiService apiService;
	public WorldControlador(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@GetMapping("/")
	public String home(){
		List<Object[]> devuelvePaisList = apiService.paisHablaLengua("slovene");
		for (Object[] objects : devuelvePaisList) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
		System.out.println();
		System.out.println(apiService.ciudadesPorPais());
		System.out.println(apiService.ciudadesDePais("mexico"));
		System.out.println(apiService.lenguajesPorPais());
		return "home";
	}
}
