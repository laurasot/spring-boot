package com.laurasoto.BlackBelt.modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
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
	@Email(message="Invalid email format. Ex: user@user.com")
	@Size(min=10, max=200, message="minimo 10 letras, maximo 200")
	private String email;
	@NotBlank(message="no puede estar vacio")
	private String password;
    @Transient
    private String passwordConfirmation;
    @OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
   	private List<Mesa> mesas;
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
