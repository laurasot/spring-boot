package com.laurasoto.authentication.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.authentication.modelos.User;

@Repository
public interface UserRepositorio extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
