package com.laurasoto.licenciaManejo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.licenciaManejo.modelos.Person;

@Repository
public interface PersonRepositorio extends CrudRepository<Person, Long> {
	//Este método recupera todos las canciones de la base de datos, se extiende del crud por lo tanto puedo borrarlo
		 List<Person> findAll();
		 List<Person> findByLicenseIsNull();
}
