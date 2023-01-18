package com.laurasoto.mostrarFecha;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class Home {
	@RequestMapping("/")
	public String home(Model model){
		return "home";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		//simpledateform da el formato de fecha
		SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE, dd MMMM yyyy",Locale.ENGLISH);
		//entrega la fecha de hoy date
		Date fechahoy = new Date();
		String hoy = formatoFecha.format(fechahoy);
		model.addAttribute("date", hoy);
		return "date";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm a");
		Date horahoy = new Date();
		String mostrarHora = formatoHora.format(horahoy);
		model.addAttribute("time", mostrarHora);
		return "time";
	}
}
