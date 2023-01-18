package com.laurasoto.countries.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.countries.modelos.Country;

@Repository
public interface CountryRepositorio extends CrudRepository<Country, Long>{
	//obtener todos los paises que hablan esloveno
	//retornar nombre del país, lenguaje y porcentaje del lenguaje
	// c corresponde al alias que le doy a la tabla countries, l al de languages
	// la tabla countries se une con languages a traves de la clave foranea especifica que los une?
	//donde el lenguaje sea igual a slovene
    @Query("SELECT c.name, l.nombreLenguaje, l.percentage From Country c JOIN c.languages l "
    		+ "WHERE l.nombreLenguaje = ?1 ORDER BY l.percentage desc")
    // se retorna una lista de objetos genericos porque contiene diferentes tipos de objetos, de diferentes clases
    //en ese caso de las tablas/modelos country y language
    List<Object[]> paisHablanLenguaje(String nombreLenguaje);
    //traer paises que hablan lenguajes por porcentage, se recibe un el lenguaje especifico que se quiere buscar, en este
    //caso, el parametro seria slovene
    
    //obtener todos los países con un superficie de área inferior a 501 y una población mayor a 100.000
    @Query("SELECT c.name, c.surface_area, c.population FROM Country c "
    		+ "WHERE c.surface_area < 501 AND c.population > 100000")
    List<Object[]> paisesAreaMenor();
    
    //obtener todos los países que tienen solo Constitutional Monarchy (Monarquía) 
    //y una superficie de área mayor a 200 y una expectativa de vida superior a los 75 años
    @Query("SELECT c.name, c.government_form, c.capital, c.life_expectancy FROM Country c"
    		+ " WHERE c.government_form = ?1 AND c.capital > 200 AND c.life_expectancy > 75")
    List<Object[]> paisesSegunGobierno(String government_form);
    
  //sumar el número de países en cada región? La consulta debe mostrar el
  	 //nombre de la región y el número de países
  	    @Query("SELECT c.region, COUNT(c.name) FROM Country c GROUP BY c.region ORDER BY COUNT(c.name) DESC ")
  	    List<Object[]> paisesEnCadaRegion();

}
