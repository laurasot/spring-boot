package com.laurasoto.lookify44.controladores;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.laurasoto.lookify44.modelos.Cancion;
import com.laurasoto.lookify44.servicios.CancionServicio;

@Controller
public class CancionControlador {
	private final CancionServicio cancionServicio;
	public CancionControlador(CancionServicio cancionServicio) {
		this.cancionServicio = cancionServicio;
	}
	//home
	@GetMapping("")
	public String home(Model model) {
		return"/home";
	}
	 
	 //muestra todos las canciones
	 @GetMapping("/dashboard")
	 public String index(Model model){
	     List<Cancion> canciones = cancionServicio.muestraCanciones();
	     model.addAttribute("canciones", canciones);
	     return "/dashboard";
	 }
	//nueva cancion
		 @RequestMapping("/songs/new")
		 public String nuevoLenguaje(@ModelAttribute("cancion") Cancion cancion) {
			 return "/nuevo";
		 }
		 
		//los datos que envia usuario para crear nueva cancion
		 @RequestMapping(value="/dashboard", method=RequestMethod.POST)
		 public String crear(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result) {
		     if (result.hasErrors()) {
		         return "/nuevo";
		     } else {
		         cancionServicio.creaCancion(cancion);
		         return "redirect:/dashboard";
		     }
		 }
		 //mostrar una cancion
		 @GetMapping(value="/songs/{id}")
		 public String MostrarCancion(@PathVariable("id") Long id, Model model) {
			 Cancion cancion = cancionServicio.encontrarCancion(id);
			 model.addAttribute("cancion", cancion);
			 return "/song";
		 }
	
			//los datos que
		 @RequestMapping(value="/search", method=RequestMethod.POST)
		 public String buscar(@RequestParam("artista") String artista, Model model){
			 return "redirect:/search/"+ artista;
		 }
		 //Buscar cancion por artista
		 @GetMapping(value="/search/{artista}")
		 public String buscarArtista( @PathVariable("artista") String artista, Model model){
			 List<Cancion> cancionesArtista = cancionServicio.buscarArtista(artista);
			 model.addAttribute("cancionesArtista", cancionesArtista);
			 return"/cancionesArtista";
		 }
		 //elimina cancion
		 @RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
		    public String eliminar(@PathVariable("id") Long id){
		        cancionServicio.eliminaCancion(id);
		        return "redirect:/dashboard";
		 }
		 
		 //top de canciones
		 @GetMapping(value="/search/topTen")
		 public String topCanciones(Model model){
			 List<Cancion> cancionesTop = cancionServicio.topCanciones();
			 model.addAttribute("cancionesTop", cancionesTop);
			 return "top";
		 }
		 
}
