package com.laurasoto.BlackBelt.repositorios;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.BlackBelt.modelos.Mesa;
@Repository
public interface MesaRepositorio extends CrudRepository<Mesa, Long>{
	List<Mesa> findAll();
}
