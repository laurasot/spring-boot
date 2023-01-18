package com.laurasoto.eventos.controladores;

import javax.servlet.http.HttpSession;
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

import com.laurasoto.eventos.modelos.Evento;
import com.laurasoto.eventos.modelos.Usuario;
import com.laurasoto.eventos.servicios.EventoServicio;
import com.laurasoto.eventos.servicios.UsuarioServicio;

@Controller
public class UsuarioControlador {
	private final UsuarioServicio usuarioServicio;
	private final EventoServicio eventoServicio;
	public UsuarioControlador(UsuarioServicio usuarioServicio, EventoServicio eventoServicio){
		this.usuarioServicio = usuarioServicio;
		this.eventoServicio = eventoServicio;
	}

	//muestra pagina del formulario
	@GetMapping("/")
	public String creaUsuario(@ModelAttribute("usuario") Usuario usuario, Model model){
		return "creaUsuario";
	}
	//formulario para registrarse
	@PostMapping("/")
	public String creaUsuarioForm(@Valid @ModelAttribute("usuario") Usuario usuario,BindingResult result,HttpSession session){
		if(result.hasErrors()){
            return "creaUsuario";
        } else{
        	Usuario usuarioN = usuarioServicio.creaUsuario(usuario);
    		session.setAttribute("usuarioId",usuarioN.getId());   
            return "redirect:/";
        }
	}
	//pagina de login
	@RequestMapping("/login")
	 public String login() {
	     return "login";
	 }
	//login
	@RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
			 Model model, HttpSession session) {
		 boolean autenticacion = usuarioServicio.authenticateUser(email, password);
		 if (autenticacion) {
			 //si es verdadero
			 Usuario usuario = usuarioServicio.findByEmail(email);
			 session.setAttribute("userId", usuario.getId());
			 session.setAttribute("userEstado", usuario.getStateU());
			 return "redirect:/home";
		} else { //si es falso
			model.addAttribute("error", "Credencial invalida, intentelo de nuevo por favor");
			return "login";
		}
	 }
	@GetMapping("/home")
	public String home(HttpSession session, Model model){
		 Long usuarioId = (Long) session.getAttribute("userId");
		 Usuario usuarioLogueado = usuarioServicio.findUserById(usuarioId);
		 model.addAttribute("usuario", usuarioLogueado);
		return "home";
	}
	
	//usuario se une a evento a traves de join
	//obtengo la session de usuario, que trae el usuario logueado
	//seteo esa session en el atributo usuariosParticipantes de eventos, lo casteo a la clase usuario?
	@GetMapping("/join/{idE}")
	public String usuarioUneEvento( @PathVariable("idE") Long idE, HttpSession session){
		
		Evento evento = eventoServicio.encontrarEvento(idE);
		Long usuarioId = (Long) session.getAttribute("userId");
		Usuario usuarioLog = usuarioServicio.findUserById(usuarioId);
		if(evento.getUsuariosParticipantes().contains(usuarioLog))
			return "redirect:/eventos";
		evento.setUsuariosParticipantes(usuarioLog);
		eventoServicio.editaEvento(evento);
		return"redirect:/eventos";
	}
	
}
