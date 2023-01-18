package com.laurasoto.lenguajes.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laurasoto.lenguajes.modelos.Lenguaje;
import com.laurasoto.lenguajes.servicios.LenguajeServicio;

@Controller
public class LenguajeControlador {
	private final LenguajeServicio lenguajeServicio;
	public LenguajeControlador(LenguajeServicio lenguajeServicio){
		 this.lenguajeServicio = lenguajeServicio;
	 }
	//muestra todos los lenguajes
	@GetMapping("/lenguajes")
	public String inicio(@ModelAttribute("lenguaje") Lenguaje lenguaje, Model model){
		List<Lenguaje> lenguajes = lenguajeServicio.muestraLenguajes();
		model.addAttribute("lenguajes", lenguajes);
		return "/lenguajes/inicio";
	}
	//nuevo lenguaje
	 @RequestMapping("/lenguajes/nuevo")
	 public String nuevoLenguaje(@ModelAttribute("lenguaje") Lenguaje lenguaje) {
		 return "/lenguajes/inicio";
	 }
	 //los datos que envia usuario para crear nuevo lenguaje
	 @RequestMapping(value="/lenguajes", method=RequestMethod.POST)
	 public String crear(@Valid @ModelAttribute("lenguaje") Lenguaje lenguaje, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/lenguajes/inicio";
	     } else {
	         lenguajeServicio.creaLenguaje(lenguaje);
	         return "redirect:/lenguajes";
	     }
	 }
	 
	 //muestra lenguaje especifico
	 @GetMapping(value="/lenguajes/{id}")
	 public String MostrarLenguaje(@PathVariable("id") Long id, Model model) {
		 Lenguaje lenguaje = lenguajeServicio.encontrarLenguaje(id);
		 model.addAttribute("lenguaje", lenguaje);
		 return "/lenguajes/lenguaje";
	 }
	 //elimina lenguaje
	 @RequestMapping(value="/lenguajes/{id}/delete", method=RequestMethod.GET)
	    public String eliminar(@PathVariable("id") Long id) {
	        lenguajeServicio.eliminarLenguaje(id);
	        return "redirect:/lenguajes";
	 	}
	 //edita lenguaje
	    @RequestMapping("/lenguajes/edit/{id}")
	    public String actualizar(@PathVariable("id") Long id, Model model) {
	        Lenguaje lenguaje = lenguajeServicio.encontrarLenguaje(id);
	        model.addAttribute("lenguaje", lenguaje);
	        return "/lenguajes/actualizar";
	    }
	    
	    @RequestMapping(value="/lenguajes/edit/{id}", method=RequestMethod.PUT)
	    public String edita(@Valid @ModelAttribute("lenguaje") Lenguaje lenguaje, BindingResult result, @PathVariable("id") Long id) {
	        if (result.hasErrors()) {
	        	return "/lenguajes/actualizar";
	        }
         else {
         	Lenguaje lenguajeActualizar = lenguajeServicio.encontrarLenguaje(id);
         	 if(lenguajeActualizar != null) {
         		 lenguaje.setId(id);
         		 lenguajeServicio.creaLenguaje(lenguaje);
         	 }
	            return "redirect:/lenguajes";
	        }
	    }
}
