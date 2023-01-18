package com.laurasoto.lenguajes.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.laurasoto.lenguajes.modelos.Lenguaje;
import com.laurasoto.lenguajes.repositorios.LenguajeRepositorio;

@Service
public class LenguajeServicio {
	//instancia u objeto de LenguajeRepository
		private final LenguajeRepositorio lenguajeRepositorio;
		
	//cosntructor con el parametro de la instancia
	public LenguajeServicio(LenguajeRepositorio lenguajeRepositorio) {
		this.lenguajeRepositorio = lenguajeRepositorio;
	}
	//muestra una lista de  todos los lenguajes
	public List<Lenguaje> muestraLenguajes() {
		return lenguajeRepositorio.findAll();
	}
	 //crea/guarda un lenguaje
	 public Lenguaje creaLenguaje(Lenguaje nuevoLenguaje) {
	     return lenguajeRepositorio.save(nuevoLenguaje);
	 }
	 //Obteniendo la información de un lenguaje
	 public Lenguaje encontrarLenguaje(Long id) {
	     Optional<Lenguaje> optionalLenguaje = lenguajeRepositorio.findById(id);
	     if(optionalLenguaje.isPresent()) {
	         return optionalLenguaje.get();
	     } else {
	         return null;
	     }
	 }
	//actualiza lenguaje
	public Lenguaje actualizarLenguaje(Long id,String nombre, String creador, double versionActual){
		Lenguaje lenguaje = encontrarLenguaje(id);
			if(lenguaje != null) {
				lenguaje.setNombre(nombre);
				lenguaje.setCreador(creador);
				lenguaje.setVersionActual(versionActual);
			}
				return lenguajeRepositorio.save(lenguaje);
			}
	//elimina lenguaje
		 public void eliminarLenguaje(Long id) {
			 Lenguaje lenguaje = encontrarLenguaje(id);
			 if(lenguaje != null) {
				 lenguajeRepositorio.deleteById(id);
			 }
			 //return lenguajeRepositorio.save(lenguaje);
		 }

}
