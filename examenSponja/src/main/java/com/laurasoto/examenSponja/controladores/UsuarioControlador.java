package com.laurasoto.examenSponja.controladores;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laurasoto.examenSponja.modelos.Usuario;
import com.laurasoto.examenSponja.servicios.UsuarioServicio;

@Controller
public class UsuarioControlador {
	public UsuarioServicio usuarioServicio;
	public UsuarioControlador(UsuarioServicio usuarioServicio){
		this.usuarioServicio = usuarioServicio;
	}
	@GetMapping("/")
	public String inicio(){
		return"inicio";
	}
	
	//muestra formulario de registro
	 @RequestMapping("/registration")
	 public String muestraForm(@ModelAttribute("usuario") Usuario usuario) {
	     return "creaUsuario";
	 }
	//formulario de registro
	 @PostMapping(value="/registration")
	 public String FormularioRegistro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()){
			return"creaUsuario";
		}
		if(usuarioServicio.findByEmail(usuario.getEmail()) == null){

			Usuario usuarioNuevo = usuarioServicio.registerUser(usuario);
			//guarda id del usuario registrado en la session
			session.setAttribute("usuarioId",usuarioNuevo.getId());
			System.out.println(session.getAttribute("usuarioId"));
			return "redirect:/home";
		}
		model.addAttribute("error", "ya tienes una cuenta con ese email");
		return"creaUsuario";
	 }
	//pagina de login
		@GetMapping("/login")
		 public String login() {
		     return "login";
		 }
		
		@PostMapping(value="/login")
		 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
				 Model model, HttpSession session) {
			 boolean autenticacion = usuarioServicio.authenticateUser(email, password);
			 if (autenticacion) {
				 //si es verdadero
				 Usuario usuario = usuarioServicio.findByEmail(email);
				 session.setAttribute("usuarioId", usuario.getId());
				 return "redirect:/home";
			} else { //si es falso
				model.addAttribute("error", "Credencial invalida, intentelo de nuevo por favor");
				return "login";
			}
		 }
		//cierra la sesion
		 @GetMapping("/logout")
		 	public String cierraSesion(HttpSession session){
			 session.invalidate();
				return"redirect:/registration";
		 }
		 @GetMapping("/home")
			public String home(HttpSession session, Model model){
				Long usuarioId = (Long) session.getAttribute("usuarioId");
				Usuario usuarioLogueado = usuarioServicio.findUserById(usuarioId);
				model.addAttribute("usuario", usuarioLogueado);
				return "home";
			}

}
