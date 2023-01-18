package com.laurasoto.BlackBelt.modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice.This;

@Entity
@Table(name="mesas")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotBlank(message = "debe tener mas de dos letras")
	@Size(min = 2)
	private String nombreInvitado;
	@NotNull @Min(1) @Max(10)
	private Integer cantidadInvitados;
	private String nota;
	private Date horaLlegada = new Date();
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public String fechaFormato(){
    	String pattern = "MMMM dd HH:mm a";
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	String date = simpleDateFormat.format(this.horaLlegada);
    	return date;
    }
}
