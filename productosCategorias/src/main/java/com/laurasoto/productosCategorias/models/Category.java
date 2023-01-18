package com.laurasoto.productosCategorias.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	     name = "categories_products", 
	     joinColumns = @JoinColumn(name = "category_id"), //siempre va primera el id de la misma tabla en la que estamos
	     inverseJoinColumns = @JoinColumn(name = "product_id") //id de la otra tabla
	 )
	 private List<Product> products;
	  
	 public Category(Long id, String name, List<Product> products) {
	     this.id = id;
	     this.name = name;
	     this.products = products;
	 }
	 public void setProducts(Product producto){
	    products.add(producto);
	 }

}

