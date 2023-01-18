package com.laurasoto.countries.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.countries.modelos.City;
import com.laurasoto.countries.modelos.Country;


@Repository
public interface CityRepositorio extends CrudRepository<City, Long>{
	//2mostrar el número total de ciudades de cada país?
	// retornar el nombre del país y el número total de ciudades
	//retorna una lista de objetos??
	 @Query("SELECT c.name, COUNT(i.id) FROM Country c JOIN c.cities i ORDER BY COUNT(i.id) DESC")
	    List<Object[]> paisesListaCiudades();
	    
	//obtener todas las ciudades en México con una población mayor a 500.000
	    @Query("SELECT i.name, i.population FROM City i LEFT JOIN i.country c "
	    		+ "WHERE c.name = ?1 AND i.population > 500000 ORDER BY i.population DESC")
	    List<Object[]> paisesLista(String country);
	//obtener todas las ciudades de Argentina dentro del distrito de Buenos Aires
	//y que tengan una población mayor a 500.000
	    @Query("SELECT i.name FROM City i JOIN i.country c "
	    		+ "WHERE c.name = ?1 AND i.district = ?2 AND i.population > 500000")
	    //como se si ese string name corresponde al del modelo country?
	    List<Object[]> ciudadesDePais(String name, String district);
}
