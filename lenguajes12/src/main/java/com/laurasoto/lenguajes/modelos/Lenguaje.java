package com.laurasoto.lenguajes.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="lenguajes")
@Getter
@Setter
@NoArgsConstructor
public class Lenguaje {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	 @Size(min = 2, max = 20)
	 private String nombre;
	 @Size(min = 2, max = 20)
	 private String creador;
	 @NotNull
	 private double versionActual;
	
	 
	 public Lenguaje(String nombre, String creador, double versionActual){
		 this.nombre = nombre;
		 this.creador = creador;
		 this.versionActual = versionActual;
	 }

}	
 
//name: Min char 2, Max char 20
//creator: Min char 2, Max char 20
//
//currentVersion: Cannot be empty