package com.laurasoto.productosCategorias.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.laurasoto.productosCategorias.models.Category;
import com.laurasoto.productosCategorias.models.Product;
import com.laurasoto.productosCategorias.repositorios.CategoryRepositorio;

@Service
public class CategoryServicio {
	private final CategoryRepositorio categoryRepositorio;
	public CategoryServicio(CategoryRepositorio categoryRepositorio) {
		this.categoryRepositorio = categoryRepositorio;
	}
	//busca categoria por id
	public Category buscaCategory(Long id){
		return categoryRepositorio.findById(id).orElse(null);
	}
	//crea/guarda una categoria
	 public Category creaCategory(Category nuevaCategory) {
		  return categoryRepositorio.save(nuevaCategory); 
	 }
	 
	 //muestra todas las categorias
	 public List<Category> muestraCategorias(){
		 return categoryRepositorio.findAll();
	 }
	 //agrega categorias
	 
	 //muestra las categorias del producto
//	 public List<Category> categoriasDelProducto(){
//	 }
	 //muestra las categorias que no contengan el producto especifico, NO SIRVE
	 public List<Category> muestraCategoriaNoProducto(Product product){
		 return categoryRepositorio.findByProductsNotContaining(product);
	 }
}
