package com.laurasoto.lookify44.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.lookify44.modelos.Cancion;

@Repository
//la <cancion> hace referencia al modelo Cancion 
public interface CancionRepositorio extends CrudRepository<Cancion, Long> {
	//Este método recupera todos las canciones de la base de datos, se extiende del crud por lo tanto puedo borrarlo
	 List<Cancion> findAll();
	 //Este método encuentra una cancion por su titulo
	 List<Cancion> findByTitulo(String buscar);
	 //este metodo devuelve todas las canciones que tiene un artista, si y muestra todas las canciones
	 List<Cancion> findByArtista(String buscar);
	 //metodo que devuelve top 10 canciones
	 List<Cancion> findTop10ByOrderByClasificacionDesc();
}
