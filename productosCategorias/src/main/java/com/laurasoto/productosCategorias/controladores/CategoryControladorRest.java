package com.laurasoto.productosCategorias.controladores;

import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.RestController;

import com.laurasoto.productosCategorias.servicios.CategoryServicio;
import com.laurasoto.productosCategorias.servicios.ProductServicio;

@RestController
public class CategoryControladorRest {
    private final CategoryServicio categoryServicio;
    private final ProductServicio productServicio;
	
	public CategoryControladorRest(CategoryServicio categoryServicio, ProductServicio productServicio){
		this.categoryServicio = categoryServicio;
        this.productServicio = productServicio;
	}
}
