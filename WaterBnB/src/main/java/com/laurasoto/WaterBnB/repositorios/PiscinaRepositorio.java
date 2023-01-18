package com.laurasoto.WaterBnB.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.WaterBnB.modelos.Piscina;

@Repository
public interface PiscinaRepositorio extends CrudRepository<Piscina, Long>{
	List<Piscina> findByDireccionContaining(String direccion);
}
