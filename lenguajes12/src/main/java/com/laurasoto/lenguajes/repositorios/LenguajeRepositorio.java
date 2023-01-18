package com.laurasoto.lenguajes.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.lenguajes.modelos.Lenguaje;

@Repository
public interface LenguajeRepositorio extends CrudRepository<Lenguaje, Long> {
	//Este método recupera todos los lenguajes de la base de datos
		 List<Lenguaje> findAll();
		 //Este método encuentra un lenguaje por su nombre
		 List<Lenguaje> findByNombre(String buscar);	
}
