package com.laurasoto.licenciaManejo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.licenciaManejo.modelos.License;
import com.laurasoto.licenciaManejo.modelos.Person;


@Repository
public interface LicenseRepositorio extends CrudRepository<License, Long>{
	List<License> findAll();

}
