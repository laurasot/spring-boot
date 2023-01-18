package com.laurasoto.authentication.controladores;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laurasoto.authentication.modelos.User;
import com.laurasoto.authentication.servicios.UserServicio;

//imports removidos para resumir.
@Controller
public class Users {
	private final UserServicio userServicio;
 
	 public Users(UserServicio userServicio) {
	     this.userServicio = userServicio;
	 }
	 //muestra formulario de registro
	 @RequestMapping("/registration")
	 public String registerForm(@ModelAttribute("user") User user) {
	     return "registrationPage";
	 }
	 @RequestMapping("/login")
	 public String login() {
	     return "loginPage";
	 }
	 //formulario de registro
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
		 //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
		if(result.hasErrors()){
			return"registrationPage";
		}
		User usuario = userServicio.registerUser(user);
		session.setAttribute("usuarioId",usuario.getId());
		return "redirect:/home";
	 }
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
			 Model model, HttpSession session) {
		 //Si el usuario está autenticado, guarde su id de usuario en el objeto Session
		 //sino agregue un mensaje de error y retorne a la página de inicio de sesión.
		 boolean autenticacion = userServicio.authenticateUser(email, password);
		 if (autenticacion) {
			 //si es verdadero
			 User usuario = userServicio.findByEmail(email);
			 session.setAttribute("userId", usuario.getId());
			 return "redirect:/home";
		} else { //si es falso
			model.addAttribute("error", "Credencial invalida, intentelo de nuevo por favor");
			return "loginPage";
		}
	 }
	 
	 @RequestMapping("/home")
	 public String home(HttpSession session, Model model) {
	     //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
		 //guardo en variable tipo long, obtengo session usuarioId, se castea a Long
		 //guardo un usuario que busco a traves de ese id
		 //guardo usuario como objeto de model
		 Long usuarioId = (Long) session.getAttribute("usuarioId");
		 User usu = userServicio.findUserById(usuarioId);
		 model.addAttribute("usuario", usu);
		 return "homePage";
	 }
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     // invalidar la sesión
	     // redireccionar a la página de inicio de sesión.
		 session.invalidate();
		 return"redirect:/login";
	 }
}
