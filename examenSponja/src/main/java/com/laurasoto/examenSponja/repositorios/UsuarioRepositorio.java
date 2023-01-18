package com.laurasoto.examenSponja.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.examenSponja.modelos.Usuario;


@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{
	Usuario findByEmail(String email);
	List<Usuario> findAll();
}
