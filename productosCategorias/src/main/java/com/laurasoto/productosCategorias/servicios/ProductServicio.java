package com.laurasoto.productosCategorias.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.laurasoto.productosCategorias.models.Category;
import com.laurasoto.productosCategorias.models.Product;
import com.laurasoto.productosCategorias.repositorios.ProductRepositorio;


@Service
public class ProductServicio {
	private final ProductRepositorio productRepositorio;
	public ProductServicio(ProductRepositorio productRepositorio) {
		this.productRepositorio = productRepositorio;
	}
	//crea/guarda un producto
		 public Product creaProduct(Product nuevoProduct) {
			  return productRepositorio.save(nuevoProduct); 
		 }
		 
	//muestra un product
		 public Product buscaProduct(Long id){
			 Optional<Product> optionalProduct = productRepositorio.findById(id);
			 if(optionalProduct.isPresent()) {
		         return optionalProduct.get();
		     } else {
		         return null;
		     }
		 }
		 
		 public List<Product> muestraProductNoContenganCategory(Category category){
			 return productRepositorio.findByCategoriesNotContaining(category);
	}
		 
}
