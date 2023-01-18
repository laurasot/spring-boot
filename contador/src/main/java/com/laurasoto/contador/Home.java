package com.laurasoto.contador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Home {

	@RequestMapping("")
	public String home(HttpSession session) {
		if (session.getAttribute("contador") == null) {
			Integer contador = 0;
			session.setAttribute("contador", contador);
		}
		Integer contador = (Integer) session.getAttribute("contador");
		session.setAttribute("contador", contador + 1 );
		return "home";
	}

	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		if (session.getAttribute("contador") == null) {
			Integer contador = 0;
			session.setAttribute("contador", contador);
		}
		return "counter";
	}
	
	@RequestMapping("/sumaDos")
	public String sumaDos(HttpSession session) {
		if (session.getAttribute("contador") == null) {
			Integer contador = 2;
			session.setAttribute("contador", contador);
		}
		Integer contador = (Integer) session.getAttribute("contador");
		session.setAttribute("contador", contador+2);
		return "redirect:/counter";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session)
	{
		session.setAttribute("contador", 0);
		return "redirect:/counter";
	}
}


//en la linea 14 se inicia la sesion? mas bien se crea un parametro(session) de tipo clase HttpSession
// cada vez que retorne (visite) la pagina "home.jsp", la variable conteo
// aumenta 1.
// como guardar esa info en la sesion? con el metodo setAttribute que asigna un
// objeto a la session
