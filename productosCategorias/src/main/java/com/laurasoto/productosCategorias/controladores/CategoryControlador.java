package com.laurasoto.productosCategorias.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laurasoto.productosCategorias.models.Category;
import com.laurasoto.productosCategorias.models.Product;
import com.laurasoto.productosCategorias.servicios.CategoryServicio;
import com.laurasoto.productosCategorias.servicios.ProductServicio;

@Controller
public class CategoryControlador {
	private final CategoryServicio categoryServicio;
	private final ProductServicio productServicio;
	public CategoryControlador(CategoryServicio categoryServicio, ProductServicio productServicio){
		this.categoryServicio = categoryServicio;
		this.productServicio = productServicio;
	}
	
	//crea category
		@GetMapping("/new")
		public String creaCategory(@ModelAttribute("category") Category category ) {
			return "/creaCategory";
		}
		
		@RequestMapping(value="/new", method=RequestMethod.POST)
		public String crearCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		    if (result.hasErrors()) {
		        return "/";
		    } else {
		        categoryServicio.creaCategory(category);
		    	return "redirect:/categories/"+category.getId();
		    }
		}
	
		@GetMapping("/categories/{idC}")
		public String muestraCategorias(Model model, @PathVariable("idC") Long idC){
			Category categoriaSetearProducto = categoryServicio.buscaCategory(idC);
			model.addAttribute("categoriaSetearProducto", categoriaSetearProducto);
			List<Product> productsNoCategory = productServicio.muestraProductNoContenganCategory(categoriaSetearProducto);
			model.addAttribute("productsNoCategory", productsNoCategory);
			return "muestraCategory";
		}
		
		@PostMapping("/categories/{idC}")
		public String agregarCategory(@PathVariable("idC") Long idC,  Model model, @RequestParam("producto") Long idP){
		    Category categoria = categoryServicio.buscaCategory(idC);
		    Product producto = productServicio.buscaProduct(idP);
		    categoria.setProducts(producto);
		    categoryServicio.creaCategory(categoria);
		    return "redirect:/categories/{idC}";
		}
}
