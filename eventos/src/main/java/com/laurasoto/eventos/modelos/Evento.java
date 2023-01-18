package com.laurasoto.eventos.modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="eventos")
@Getter @Setter
@NoArgsConstructor
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotBlank
	@Size(min=3, max=30, message="minimo 3 letras, maximo 50")
	private String name;
	@NotNull @NotBlank
	@Size(min=3, max=30, message="minimo 3 letras, maximo 50")
	@NotNull @NotBlank
	private String cityE;
	@NotBlank
	private String stateE;
	private Date createdAt;
    private Date updatedAt;
    @Future 
    @NotNull(message="no puede ser nulo!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuario hostUsuario;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuarios_eventos", 
        joinColumns = @JoinColumn(name = "evento_id"), 
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuariosParticipantes;
    
    public void setUsuariosParticipantes(Usuario usuario){
    	usuariosParticipantes.add(usuario);
    }
    @OneToMany(mappedBy="evento", fetch = FetchType.LAZY)
   	private List<Comentario> comentarios ;
    
    public void setComentarios(Comentario comentario){
    	comentarios.add(comentario);
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
