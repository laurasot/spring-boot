package com.laurasoto.listaEstudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.listaEstudiantes.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
 
	List<Student> findAll();
}
