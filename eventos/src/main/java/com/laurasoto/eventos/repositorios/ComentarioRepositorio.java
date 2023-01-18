package com.laurasoto.eventos.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.eventos.modelos.Comentario;

@Repository
public interface ComentarioRepositorio extends CrudRepository<Comentario, Long>{

}
