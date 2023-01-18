package com.laurasoto.examenSponja.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tareas")
@Getter @Setter
@NoArgsConstructor
public class Tarea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=3, max=50, message="minimo 3 letras, maximo 50")
	private String name;
	@NotNull(message = "no puede estar vacio")
	@Min(1) @Max(3)
	private int prioridad;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuario usuarioCreador;
	private  Boolean estaListo = false;
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
    @JoinColumn(name="usuarioasignado_id")
    private Usuario usuarioAsignado;
	 @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
}
