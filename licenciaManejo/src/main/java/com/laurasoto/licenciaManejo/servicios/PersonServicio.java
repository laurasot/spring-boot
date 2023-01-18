package com.laurasoto.licenciaManejo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.laurasoto.licenciaManejo.modelos.Person;
import com.laurasoto.licenciaManejo.repositorios.PersonRepositorio;



@Service
public class PersonServicio {
	private final PersonRepositorio personRepositorio;
	
	public PersonServicio(PersonRepositorio personRepositorio){
		this.personRepositorio = personRepositorio;
	}
	
	//crea/guarda una persona
	 public Person creaPerson(Person nuevaPerson) {
	     return personRepositorio.save(nuevaPerson);
	 }
	 
	//muestra una lista de  todas las personas
	 public List<Person> muestraPersonas() {
		return personRepositorio.findAll();
	 }
	//muestra una lista de  todas las personas
		 public List<Person> muestraPersonasSinLicencia() {
			return personRepositorio.findByLicenseIsNull();
		 }
		 
	 //mostrar persona
	 public Person mostrarPersona(Long id) {
		 return personRepositorio.findById(id).orElse(null);
	 }

	 
	
}
