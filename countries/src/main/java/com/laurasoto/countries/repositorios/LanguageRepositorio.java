package com.laurasoto.countries.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.countries.modelos.Language;

@Repository
public interface LanguageRepositorio extends CrudRepository<Language, Long>{
	//obtener todos los lenguajes en cada país con un porcentaje mayor al 89%
    @Query("SELECT c.name, l.nombreLenguaje, l.percentage FROM Country c LEFT JOIN c.languages l "
    		+ "WHERE l.percentage > 89 ORDER BY l.percentage DESC")
    List<Object[]> lenguajesPorPais();
    
}
