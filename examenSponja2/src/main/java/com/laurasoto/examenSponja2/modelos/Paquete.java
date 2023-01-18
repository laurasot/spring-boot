package com.laurasoto.examenSponja2.modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="paquetes")
public class Paquete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@NotNull(message = "no puede ser nulo")
	private Date fechaVencimiento;
	@NotNull(message = "no puede ser nulo")
	private int precio;
	@NotNull
	private String available;
	@OneToMany(mappedBy="paquete", fetch = FetchType.LAZY)
   	private List<Usuario> usuariosSuscritos;
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
