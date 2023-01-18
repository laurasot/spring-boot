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
public class ProductControlador {
	private final ProductServicio productServicio;
	private final CategoryServicio categoryServicio;
	public ProductControlador(ProductServicio productServicio, CategoryServicio categoryServicio) {
		this.categoryServicio = categoryServicio;
		this.productServicio = productServicio;
	}
	@GetMapping("/")
	public String home() {
		return"/home";
	}
	
	//crea producto
	@GetMapping("/nuevo")
	public String creaProduct(@ModelAttribute("product") Product product ){
		
		return "/creaProduct";
	}
	
	//los datos que envia usuario para crear nuevo producto
	 @RequestMapping(value="/nuevo", method=RequestMethod.POST)
	 public String crearProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/";
	     } else {
	         productServicio.creaProduct(product);
	         return "redirect:/products/"+product.getId();
	     }
	 }
	 
	 //muestra 1 producto
	 @GetMapping("/products/{idP}")
	 public String mostrarProduct(@PathVariable("idP") Long idP, Model model){
		 //se envia el producto a editar, para mostrar las descripciones, sus categorias, etc
		 Product productoAEditar = productServicio.buscaProduct(idP);
		 //muestra las categorias de las que no forma parte el producto
		 List<Category> categoriasNoProduct = categoryServicio.muestraCategoriaNoProducto(productoAEditar);
	 	 model.addAttribute("productoAEditar", productoAEditar);
	 	 model.addAttribute("categoriasNoProduct", categoriasNoProduct);
	 	 System.out.println(categoriasNoProduct.toString());
		 return"muestraProduct";
	 }

	 //busco categoria con id que trae requestparam, busco producto con id del path ¿variable, 
	 //seteo categoria al producto
	 @PostMapping("/products/{idP}")
	 public String agregarCategory(@PathVariable("idP") Long idP,  Model model, @RequestParam("categoria") Long idC){
	         Category categoria = categoryServicio.buscaCategory(idC);
	         Product producto = productServicio.buscaProduct(idP);
	         producto.setCategories(categoria);
	         productServicio.creaProduct(producto);
	         return "redirect:/products/{idP}";
	 }
}