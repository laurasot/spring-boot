package com.laurasoto.examenSponja2.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.examenSponja2.modelos.Paquete;
@Repository
public interface PaqueteRepositorio extends JpaRepository<Paquete, Long> {
	List<Paquete> findAll();
}
