package com.laurasoto.productosCategorias.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.productosCategorias.models.Category;
import com.laurasoto.productosCategorias.models.Product;

@Repository
public interface ProductRepositorio extends CrudRepository<Product, Long>{
	List<Product> findByCategoriesNotContaining(Category category);
}
