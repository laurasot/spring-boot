package com.laurasoto.eventos.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laurasoto.eventos.modelos.Comentario;
import com.laurasoto.eventos.modelos.Evento;
import com.laurasoto.eventos.modelos.Usuario;
import com.laurasoto.eventos.repositorios.ComentarioRepositorio;
import com.laurasoto.eventos.servicios.ComentarioServicio;
import com.laurasoto.eventos.servicios.EventoServicio;
import com.laurasoto.eventos.servicios.UsuarioServicio;

@Controller
public class EventoControlador {
	private final EventoServicio eventoServicio;
	private final ComentarioRepositorio comentarioRepositorio;
	private final UsuarioServicio usuarioServicio;
	private final ComentarioServicio comentarioServicio;
	
	public EventoControlador(EventoServicio eventoServicio, ComentarioRepositorio comentarioRepositorio,
			UsuarioServicio usuarioServicio, ComentarioServicio comentarioServicio){
		this.eventoServicio = eventoServicio;
		this.comentarioRepositorio = comentarioRepositorio;
		this.usuarioServicio = usuarioServicio;
		this.comentarioServicio = comentarioServicio;
	}
	@GetMapping("/nuevoEvento")
	public String creaEvento(@ModelAttribute("evento") Evento evento, HttpSession session){
		if (session.getAttribute("userId") == null){
			return"redirect:/login";
		}
		return "creaEvento";
	}
	//los datos que envia usuario para crear nuevo evento
	 @RequestMapping(value="/nuevoEvento", method=RequestMethod.POST)
	 public String crearEvento(@Valid @ModelAttribute("evento") Evento evento, BindingResult result,
			 HttpSession session,Model model) {
	     if (result.hasErrors()) {
	         return "/creaEvento";
	     } else {
	    	 Evento nuevoEvento = eventoServicio.creaEvento(evento,(Long) session.getAttribute("userId"));
	         //eventoServicio.creaEvento(nuevoEvento);
	         return "redirect:/eventos";
	     }
	 }
	 //muestra todos los eventos
	 @GetMapping("/eventos")
	 public String evento(Model model, HttpSession session){
		 if (session.getAttribute("userId") == null){
				return"redirect:/login";
			}
		 Usuario usuario = usuarioServicio.findUserById((Long)session.getAttribute("userId"));
		 List<Evento> eventosEstados = eventoServicio.mostrarEventoPorEstado(usuario.getStateU());
		 List<Evento> eventosNoEstados = eventoServicio.mostrarEventoOtrosEstados(usuario.getStateU());
		 Long idUsuarioLogin = (Long) session.getAttribute("userId");
		 model.addAttribute("idUsuarioLogin", idUsuarioLogin);
		 model.addAttribute("eventosEstados", eventosEstados);
		 model.addAttribute("eventosNoEstados", eventosNoEstados);
		 model.addAttribute("usuario", usuario);
		 return "eventos";
	 }
	 
	 //eliminar evento
	 @GetMapping("/delete/{id}")
	    public String eliminar(@PathVariable("id") Long id, HttpSession session){
		 if (session.getAttribute("userId") == null){
				return"redirect:/login";
			}
	        eventoServicio.eliminaEvento(id);
	        return "redirect:/eventos";
	 }
	 
	 //cierra la sesion
	 @GetMapping("/logout")
	 	public String cierraSesion(HttpSession session){
		 session.invalidate();
			return"redirect:/";
	 }
	 
	 //muestra detalle de evento
	 //debe ir valid?
	 @GetMapping("/events/{id}")
	 public String detalleEvento(@PathVariable("id") Long id,Model model, @ModelAttribute("comentario") Comentario comentario, HttpSession session){
		 if (session.getAttribute("userId") == null){
				return"redirect:/login";
			}
		 Evento evento = eventoServicio.encontrarEvento(id);
		 model.addAttribute("evento", evento);
		 model.addAttribute("comentarios", evento.getComentarios());
		 model.addAttribute("cantidadParticipantes",evento.getUsuariosParticipantes().size());
		 return "detalleEvento";
	 }
	 //agregar los comentarios
	 @PostMapping("/events/{idEvento}")
	 public String agregaComentario(@Valid @ModelAttribute("comentario") Comentario comentario, @PathVariable("idEvento") Long idEvento,
			 HttpSession session ,Model model,BindingResult result){
		   if (result.hasErrors()) {
		         return "/";
		     } else {
		    	 Comentario comentarioAgregar = comentarioServicio.crearComentario(comentario, idEvento, (Long) session.getAttribute("userId") );
//		    	 eventoComent.setComentarios(comentarioAgregar);
//		         eventoServicio.editaEvento(eventoComent);
		         return "redirect:/events/{idEvento}";
		     }
	 }
	 
	 //muestra pagina que edita evento
	 @GetMapping("/edit/{id}")
	 public String editaPagina(@ModelAttribute("evento") Evento evento, @PathVariable("id") Long id, HttpSession session){
		 if (session.getAttribute("userId") == null){
				return"redirect:/login";
		}
		 if(usuarioServicio.findUserById((Long) session.getAttribute("userId")) == eventoServicio.encontrarEvento(id).getHostUsuario()){
			 return "editaEvento";
		 }
		 return"redirect:/";
	 }
	 
	 //edita evento, cuando se edita mejor usar put
	 @PutMapping("/edit/{id}")
	 public String editaEvento(@Valid @ModelAttribute("evento") Evento evento, BindingResult result,
			 HttpSession session,Model model,@PathVariable("id") Long id){
		 if (result.hasErrors()) {
			 System.out.println(result.getAllErrors());
	         return "/";
	     } else {
	    	 //no se crea nueva variable, se setea a el modelo evento
	    	 
	    	 evento = eventoServicio.creaEvento(evento,(Long) session.getAttribute("userId"));
	         //eventoServicio.creaEvento(nuevoEvento);
	         return "redirect:/events/{id}";
	     } 
	 }
	 //cancelar participacion
	 @GetMapping("/cancelar/{id}")
	 public String cancelaParticipacion(@PathVariable("id") Long id, HttpSession session){
		 if (session.getAttribute("userId") == null){
				return"redirect:/login";
		}
		 if(usuarioServicio.findUserById((Long) session.getAttribute("userId")) == eventoServicio.encontrarEvento(id).getHostUsuario()){
			 eventoServicio.eliminaUsuarioParticipante((Long) session.getAttribute("userId"), id);
			 return"redirect:/eventos";
		 } 
		return "redirect:/login";
	 }
}
