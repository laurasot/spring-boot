package com.laurasoto.productosCategorias.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.productosCategorias.models.Category;
import com.laurasoto.productosCategorias.models.Product;



@Repository
public interface CategoryRepositorio extends CrudRepository<Category, Long>{
	List<Category> findByProductsNotContaining(Product product);
	List<Category> findAll();
	Category findByProducts(Product product);
    //List<Category> findByProducts(List<Product> products);
}
