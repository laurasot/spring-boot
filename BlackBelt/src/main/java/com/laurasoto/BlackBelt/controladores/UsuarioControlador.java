package com.laurasoto.BlackBelt.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laurasoto.BlackBelt.modelos.Usuario;
import com.laurasoto.BlackBelt.servicios.UsuarioServicio;


@Controller
public class UsuarioControlador {
	private final UsuarioServicio usuarioServicio;
	public UsuarioControlador(UsuarioServicio usuarioServicio){
		this.usuarioServicio = usuarioServicio;
	}
	
	//muestra formulario de registro
	 @RequestMapping("/")
	 public String muestraForm(@ModelAttribute("usuario") Usuario usuario) {
	     return "creaUsuario";
	 }

	//formulario de registro
	 @RequestMapping(value="/", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()){
			return"creaUsuario";
		}
	           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	           java.util.regex.Matcher m = p.matcher(usuario.getEmail());
	           if (!m.matches()) {
				model.addAttribute("error", "no tiene el formato correcto");
				return"creaUsuario";
			}

		if(usuarioServicio.findByEmail(usuario.getEmail()) == null){

			Usuario usuarioNuevo = usuarioServicio.registerUser(usuario);
			session.setAttribute("usuarioId",usuarioNuevo.getId());
			return "redirect:/home";
		}
		model.addAttribute("error", "ya tienes una cuenta con ese email");
		return"creaUsuario";
	 }
	 
	//pagina de login
		@RequestMapping("/login")
		 public String login(HttpSession session ) {
			if ((Long) session.getAttribute("usuarioId") != null) {
				return"redirect:/home";
			}
			return "login";
		 }
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
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
			return"redirect:/login";
	 }
	 
	 @GetMapping("/home")
	 public String mostrarTablasUsuario(HttpSession session, Model model){
		 if((Long) session.getAttribute("usuarioId") == null){
			 return"redirect:/";
		 }
		 model.addAttribute("usuarioLog", usuarioServicio.findUserById((Long) session.getAttribute("usuarioId")));
		 return"mesasUsuario";
	 }
	 
}
