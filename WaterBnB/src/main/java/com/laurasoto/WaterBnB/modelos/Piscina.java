package com.laurasoto.WaterBnB.modelos;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="piscinas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piscina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank 
	@Size(min=8, max=30, message="minimo 8 letras, maximo 50")
	private String direccion;
	@NotBlank(message="debes elegir un tamaño de piscina!")
	private String tamano;
	@NotNull(message="debes agregar un precio!")
	private Double precio;
	@NotBlank(message="agrega una descripcion")
	private String descripcion;
	private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuario hostUsuario;
    @OneToMany(mappedBy="piscina", fetch = FetchType.LAZY)
   	private List<Review> reviews;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public String getPromedio(){
    	int rating = 0;
    	for (Review review : reviews) {
		rating += review.getRating();
		}
    	if (reviews.size() == 0) {
			return "no tiene rating";
		}
    	int promedio = rating/reviews.size();
    	return  String.valueOf(promedio);
    }
    public void setReviews(Review review){
    	reviews.add(review);
    }
}
