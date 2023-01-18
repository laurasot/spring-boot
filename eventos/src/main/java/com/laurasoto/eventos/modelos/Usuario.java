package com.laurasoto.eventos.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuarios")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotBlank
	@Size(min=3, max=30, message="minimo 3 letras, maximo 50")
	private String firstName;
	@NotNull @NotBlank
	@Size(min=3, max=30, message="minimo 3 letras, maximo 50")
	private String lastName;
	@NotBlank @NotNull
	@Size(min=10, max=30, message="minimo 10 letras, maximo 50")
	private String email;
	@NotNull @NotBlank
	private String cityU;
	@NotBlank
	private String stateU;
	@NotBlank(message="no puede estar vacio")
	private String password;
    @Transient
    private String passwordConfirmation;
   
    @OneToMany(mappedBy="hostUsuario", fetch = FetchType.LAZY)
	private List<Evento> eventos;
    //un usuario tiene muchos eventos
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuarios_eventos", 
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventosParticipa;
    //un usuario puede tener muchos comentarios
    //busca el atributo "usuario" en la la tabla referenciada
    //el que va a muchos siempre busca el atributo
    @OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
	private List<Comentario> comentarios;
}
