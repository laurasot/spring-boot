package com.laurasoto.eventos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.laurasoto.eventos.modelos.Evento;

public interface EventoRepositorio extends CrudRepository<Evento, Long>{
	List<Evento> findByStateEContaining(String stateE);
	List<Evento> findByStateENotContaining(String cityE);
	List<Evento> findAll();
}
