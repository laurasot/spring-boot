package com.laurasoto.lookify44.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="canciones")
@Getter
@Setter
@NoArgsConstructor
public class Cancion {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	 @Size(min = 5)
	 private String titulo;
	 @Size(min = 5)
	 private String artista;
	 @Min(value = 1, message = "debe ser mayor que 0")
	 @Max(value = 10, message = "debe ser menor que 11")
	 private int clasificacion;
	 
	 public Cancion(String titulo, String artista, int clasificacion){
		 this.titulo = titulo;
		 this.artista = artista;
		 this.clasificacion = clasificacion;
	 }
}
