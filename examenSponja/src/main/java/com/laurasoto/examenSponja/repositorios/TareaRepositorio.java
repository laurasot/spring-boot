package com.laurasoto.examenSponja.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.examenSponja.modelos.Tarea;



@Repository
public interface TareaRepositorio extends CrudRepository<Tarea, Long>{
	List<Tarea> findByOrderByPrioridadDesc();
    List<Tarea> findByOrderByPrioridadAsc();
	List<Tarea> findAll();
}
