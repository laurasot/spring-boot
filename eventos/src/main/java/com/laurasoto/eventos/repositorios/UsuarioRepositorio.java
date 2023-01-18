package com.laurasoto.eventos.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.eventos.modelos.Usuario;



@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}
