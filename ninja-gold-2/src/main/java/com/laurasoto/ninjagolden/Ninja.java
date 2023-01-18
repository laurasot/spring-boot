package com.laurasoto.ninjagolden;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ninja {
	 	
	
	
	@RequestMapping("/inicio")
	public String paginaInicio(HttpSession session, Model model) {
		if(session.getAttribute("goldNinja") == null || session.getAttribute("actividades") == null) {
			session.setAttribute( "goldNinja", 0);
			session.setAttribute("actividades", new ArrayList<String>());
		}
		
		model.addAttribute("goldNinja", session.getAttribute("goldNinja"));
		model.addAttribute("actividades", session.getAttribute("actividades"));
		return "ninja";
	}

	
	@RequestMapping(value = "/gold", method = RequestMethod.POST)
	public String apuestaNinja(@RequestParam("tipoApuesta") String tipoApuesta, 
			HttpSession session) {
		int goldNinja = (int) session.getAttribute("goldNinja");
		
		List<String> actividades = (List<String>) session.getAttribute("actividades");

		if(tipoApuesta.equalsIgnoreCase("farm")) {
			
			// Hacer un numero random del 10 - 20 y sumarlo a la variable Session
			Random rand = new Random();
			int oroGanado = rand.nextInt(11) + 10;
			session.setAttribute("goldNinja", oroGanado + goldNinja);
			
			SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a",Locale.ENGLISH);
            Date fechahoy = new Date();
            String fechaHora = formatoFecha.format(fechahoy);
			
			// añadirle el historial a las actividades
            actividades.add("Ninja!!! Has ganado " + oroGanado + " monedas (" + fechaHora + ")");
		}
		
	    if(tipoApuesta.equalsIgnoreCase("cave")) {
				
			// Hacer un numero random del 10 - 20 y sumarlo a la variable Session
			Random rand = new Random();
			int oroGanado = rand.nextInt(6) + 5;
			session.setAttribute("goldNinja", oroGanado + goldNinja);
				
			SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a",Locale.ENGLISH);
	        Date fechahoy = new Date();
	        String fechaHora = formatoFecha.format(fechahoy);
				
			// añadirle el historial a las actividades
	        actividades.add("Ninja!!! Has ganado " + oroGanado + " monedas (" + fechaHora + ")");
		}
	    if(tipoApuesta.equalsIgnoreCase("house")) {
			
			// Hacer un numero random del 10 - 20 y sumarlo a la variable Session
			Random rand = new Random();
			int oroGanado = rand.nextInt(4) + 2;
			session.setAttribute("goldNinja", oroGanado + goldNinja);
				
			SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a",Locale.ENGLISH);
	        Date fechahoy = new Date();
	        String fechaHora = formatoFecha.format(fechahoy);
				
			// añadirle el historial a las actividades
	        actividades.add("Ninja!!! Has ganado " + oroGanado + " monedas (" + fechaHora + ")");
		}
        if(tipoApuesta.equalsIgnoreCase("casino")) {
			
			// Hacer un numero random del 10 - 20 y sumarlo a la variable Session
			Random rand = new Random();
			int oroGanado = (int)(rand.nextDouble() * (50 - (-50)) + (-50));
			session.setAttribute("goldNinja", oroGanado + goldNinja);
				
			SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a",Locale.ENGLISH);
	        Date fechahoy = new Date();
	        String fechaHora = formatoFecha.format(fechahoy);
	        // añadirle el historial a las actividades
	        if(oroGanado < 0) {
	        	actividades.add("Pequeño ninja, has perdido " + oroGanado + " monedas (" + fechaHora + ")");
	        }else {
	        	actividades.add("Ninja!!! Has ganado " + oroGanado + " monedas (" + fechaHora + ")");
	        }
		} 
		return "redirect:/inicio";
	}
	@RequestMapping("/reset")
    public String reset(HttpSession session) {

        session.setAttribute("goldNinja", 0);

        session.setAttribute("actividades", new ArrayList<String>());

        return "redirect:/inicio";
    }
}
	
