package com.laurasoto.lookify44.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.laurasoto.lookify44.modelos.Cancion;
import com.laurasoto.lookify44.repositorios.CancionRepositorio;

@Service
public class CancionServicio {
	private final CancionRepositorio cancionRepositorio;
	
	public CancionServicio(CancionRepositorio cancionRepositorio) {
		this.cancionRepositorio = cancionRepositorio;
	}
	
	//muestra una lista de  todas las canciones
	public List<Cancion> muestraCanciones() {
		return cancionRepositorio.findAll();
	}
	
	//crea/guarda una cancion
		 public Cancion creaCancion(Cancion nuevaCancion) {
		     return cancionRepositorio.save(nuevaCancion);
		 }
		 
		//Obteniendo la información de una cancion
		 public Cancion encontrarCancion(Long id) {
		     Optional<Cancion> optionalCancion = cancionRepositorio.findById(id);
		     if(optionalCancion.isPresent()) {
		         return optionalCancion.get();
		     } else {
		         return null;
		     }
		 }
		 
		 //buscar artista y mostrar sus canciones
		 public List<Cancion> buscarArtista(String artista){
			 return cancionRepositorio.findByArtista(artista);
		 }
		 //eliminar cancion
		 public void eliminaCancion(Long id) {
			 Cancion cancion = encontrarCancion(id);
			 if(cancion != null) {
				 cancionRepositorio.deleteById(id);
			 }
		 }
		  //hacer top de canciones
		   public List<Cancion> topCanciones() {
		        return cancionRepositorio.findTop10ByOrderByClasificacionDesc();
		    }
}
