package com.laurasoto.WaterBnB.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laurasoto.WaterBnB.modelos.Piscina;
import com.laurasoto.WaterBnB.modelos.Review;
import com.laurasoto.WaterBnB.modelos.Usuario;
import com.laurasoto.WaterBnB.servicios.PiscinaServicio;
import com.laurasoto.WaterBnB.servicios.ReviewServicio;
import com.laurasoto.WaterBnB.servicios.UsuarioServicio;

@Controller
public class PiscinaControlador {
	private final PiscinaServicio piscinaServicio;
	private final UsuarioServicio usuarioServicio;
	private final ReviewServicio reviewServicio;
	
	public PiscinaControlador(PiscinaServicio piscinaServicio, UsuarioServicio usuarioServicio, ReviewServicio reviewServicio){
		this.piscinaServicio = piscinaServicio;
		this.usuarioServicio = usuarioServicio;
		this.reviewServicio = reviewServicio;
	}
	
	@GetMapping("/dashboard")
	public String ListaPiscinasHost(@ModelAttribute("piscina") Piscina piscina,Model model, HttpSession session){
		Usuario usuarioLog = usuarioServicio.findUserById((Long) session.getAttribute("usuarioId"));
		List<Piscina> piscinasDeUsuario = usuarioLog.getPiscinas();
		model.addAttribute("piscinas", piscinasDeUsuario);
		return"dashboard";
	}
	
	@PostMapping("/dashboard")
	public String formCrearPiscina(@Valid @ModelAttribute("piscina") Piscina piscina, 
			BindingResult result, HttpSession session){
		 if (result.hasErrors()) {
			 System.out.println(result.getAllErrors());
	         return "/dashboard";
	     } else {
	    	 Piscina nuevaPiscina = piscinaServicio.crearPiscina(piscina,(Long) session.getAttribute("usuarioId"));
	    	 return"redirect:/piscina/"+ nuevaPiscina.getId();
	     }
	}
	
	@GetMapping("/piscina/{id}")
	public String detallePiscina(@PathVariable("id") Long id, HttpSession session, Model model){
		Piscina piscinaAMostrar = piscinaServicio.piscinaPorId(id);
		model.addAttribute("piscina", piscinaAMostrar);
		return"detallePiscina";
	}
	@GetMapping("/host/piscina/{id}")
	public String muestraEditPiscina(@PathVariable("id") Long id, Model model, @ModelAttribute("piscina") Piscina piscina, HttpSession session){
		Piscina piscinaAEditar = piscinaServicio.piscinaPorId(id);
		System.out.println(piscinaAEditar.getHostUsuario());
		if ((Long) session.getAttribute("usuarioId") == piscinaAEditar.getHostUsuario().getId()){
			model.addAttribute("piscinaAEditar", piscinaAEditar);
		}
		return"editaPiscina";
	}
	@GetMapping("/search")
	public String muestraBuscaPiscinas( Model model, HttpSession session, @RequestParam("direccion") String direccion){
		List<Piscina> piscinasBuscadas = piscinaServicio.piscinaPorDireccion(direccion);
		model.addAttribute("piscinasBuscadas", piscinasBuscadas);
		return"busquedaPiscinas";
	}
	
	@PostMapping("/host/piscina/{id}")//putMapping para actualizar
	public String editPiscina(@PathVariable("id") Long id, Model model, 
			@Valid @ModelAttribute("piscina")  Piscina piscina, BindingResult result, HttpSession session){
		if (result.hasErrors()){
			return"editaPiscina";
		}
		//se guarda el id porque se esta sobrescribiendo la misma piscina, sino se crearia otra distinta y no se sobrescribiria
		Piscina piscinaAEditar = piscinaServicio.piscinaPorId(id);
		if (piscinaAEditar.getHostUsuario().getId() == (Long) session.getAttribute("usuarioId")){
			piscina.setId(id);
			piscinaServicio.crearPiscina(piscina, (Long) session.getAttribute("usuarioId"));
			return"redirect:/dashboard";
		}
		return"redirect:/dashboard";
	}
	
	@GetMapping("/piscina/{id}/review")
	public String agregaReview(@ModelAttribute("review") Review review ,@PathVariable("id") Long id,
			HttpSession session, Model model){
		if ((Long) session.getAttribute("usuarioId") == null) {
			return"redirect:/login";
		}
		//encuentro piscina para setearle comentario
		Piscina piscina = piscinaServicio.piscinaPorId(id);
		System.out.println((Long) session.getAttribute("usuarioId"));
		System.out.println(piscina.getHostUsuario().getId());
		//en caso de que id de usuario logueado sea igual al host del la piscina, no puede escribir comentario
		if ((Long) session.getAttribute("usuarioId") == piscina.getHostUsuario().getId()) {
			model.addAttribute("error", "no puedes hacer una review de tu misma piscina!");
			Piscina piscinaAMostrar = piscinaServicio.piscinaPorId(id);
			model.addAttribute("piscina", piscinaAMostrar);
			return"detallePiscina";
		}
		//muestro la direcciion de piscina
		model.addAttribute("piscina", piscina);
		return"nuevoComentario";
	}
	
	@PostMapping("/piscina/{idPiscina}/review")
	public String formReview(@ModelAttribute("review") Review review, @PathVariable("idPiscina") Long idPiscina,
		HttpSession session, Model model){
		//me falta guardar la review en la base de datos?
		Piscina piscina = piscinaServicio.piscinaPorId(idPiscina);
		review.setPiscina(piscina);
		review.setUsuario(usuarioServicio.findUserById((Long) session.getAttribute("usuarioId")));
		piscina.getReviews().add(review);
		reviewServicio.guardaReview(review);
		piscinaServicio.editaPiscina(piscina);
		return"redirect:/home";
	}

}
