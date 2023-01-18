package com.laurasoto.examenSponja2.controladores;

import org.springframework.stereotype.Controller;

import com.laurasoto.examenSponja2.servicios.PaqueteServicio;

@Controller
public class PaqueteControlador {
	private final PaqueteServicio paqueteServicio;
	public PaqueteControlador(PaqueteServicio paqueteServicio){
		this.paqueteServicio = paqueteServicio;
	}
	
	
}
