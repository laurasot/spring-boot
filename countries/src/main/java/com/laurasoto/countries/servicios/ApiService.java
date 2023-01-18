package com.laurasoto.countries.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.laurasoto.countries.modelos.City;
import com.laurasoto.countries.modelos.Country;
import com.laurasoto.countries.modelos.Language;
import com.laurasoto.countries.repositorios.CityRepositorio;
import com.laurasoto.countries.repositorios.CountryRepositorio;
import com.laurasoto.countries.repositorios.LanguageRepositorio;

@Service
public class ApiService {
	private final CityRepositorio cityRepositorio;
	private final CountryRepositorio countryRepositorio;
	private final LanguageRepositorio languageRepositorio;
	
	public ApiService(CityRepositorio cityRepositorio, CountryRepositorio countryRepositorio, LanguageRepositorio languageRepositorio){
		this.cityRepositorio = cityRepositorio;
		this.countryRepositorio = countryRepositorio;
		this.languageRepositorio = languageRepositorio;
	}
	
    //1 paises que hablan un idioma especifico (esloveno)
	public  List<Object[]> paisHablaLengua(String nombreLenguaje){
		return countryRepositorio.paisHablanLenguaje(nombreLenguaje);
	}
	
	//2mostrar el número total de ciudades de cada país?
	public List<Object[]> ciudadesPorPais(){
		return cityRepositorio.paisesListaCiudades();
	}
	
	//3 obtener todas las ciudades en un pais con una población mayor a 500.000
	public List<Object[]> ciudadesDePais(String pais){
		return cityRepositorio.paisesLista(pais);
	}
	
	//4 obtener todos los lenguajes en cada país con un porcentaje mayor al 89%
	public List<Object[]> lenguajesPorPais(){
		return languageRepositorio.lenguajesPorPais();
	}
	
	//5 obtener todos los países con un superficie de área inferior a 501
	public List<Object[]> paisesAreaInferior(){
		return countryRepositorio.paisesAreaMenor();
	}
	
	//6 obtener todos los países que tienen solo Constitutional Monarchy (Monarquía) ...
	public List<Object[]> paisesPorGobierno(String gobierno){
		return countryRepositorio.paisesSegunGobierno(gobierno);
	}
	//7obtener todas las ciudades de Argentina dentro del distrito de Buenos Aires ...
	public List<Object[]> nombreciudadesPorPais(String pais, String distrito){
		return cityRepositorio.ciudadesDePais(pais, distrito);
	}
	//8 sumar el número de países en cada región
	public List<Object[]> paisesEnRegion(){
		return countryRepositorio.paisesEnCadaRegion();
	}
}
