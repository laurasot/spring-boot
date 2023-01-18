package com.laurasoto.examenSponja2.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.laurasoto.examenSponja2.modelos.Paquete;
import com.laurasoto.examenSponja2.repositorios.PaqueteRepositorio;

@Service
public class PaqueteServicio {
	private final PaqueteRepositorio paqueteRepositorio;
	public PaqueteServicio(PaqueteRepositorio paqueteRepositorio){
		this.paqueteRepositorio = paqueteRepositorio;
	}
	
	public Paquete guardaPaquete(Paquete nuevoPaquete){
		return paqueteRepositorio.save(nuevoPaquete);
	}
	public Paquete buscaPaquetePorId(Long id){
		return paqueteRepositorio.findById(id).get();
	}
	public List<Paquete> muestraPaquetes(){
		return paqueteRepositorio.findAll();
	}
}
