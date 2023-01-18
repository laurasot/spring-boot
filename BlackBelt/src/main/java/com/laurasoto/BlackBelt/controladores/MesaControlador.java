package com.laurasoto.BlackBelt.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.laurasoto.BlackBelt.modelos.Mesa;
import com.laurasoto.BlackBelt.modelos.Usuario;
import com.laurasoto.BlackBelt.servicios.MesaServicio;
import com.laurasoto.BlackBelt.servicios.UsuarioServicio;

@Controller
public class MesaControlador {
	private final MesaServicio mesaServicio;
	private final UsuarioServicio usuarioServicio;
	public MesaControlador(MesaServicio mesaServicio, UsuarioServicio usuarioServicio){
		this.mesaServicio = mesaServicio;
		this.usuarioServicio = usuarioServicio;
	}
	
	@GetMapping("/tables/new")
	public String creaMesa(@ModelAttribute("mesa") Mesa mesa, 
			 HttpSession session){
		if((Long) session.getAttribute("usuarioId") == null){
			 return"redirect:/";
		 }
		return"creaMesa";
	}
	@PostMapping("/tables/new")
	public String creaMesaForm(@Valid @ModelAttribute("mesa") Mesa mesa,
			BindingResult result, HttpSession session ){
		if (result.hasErrors()) {
	         return "creaMesa";
		}
		mesa.setUsuario(usuarioServicio.findUserById((Long) session.getAttribute("usuarioId")));
		Mesa nuevaMesa = mesaServicio.guardaMesa(mesa);
		return"redirect:/home";
	}
	@GetMapping("/tables/{idMesa}/edit")
	public String editaMesa(@ModelAttribute("mesa") Mesa mesa, HttpSession session, 
			@PathVariable("idMesa") Long idMesa, Model model){
		if((Long) session.getAttribute("usuarioId") == null){
			 return"redirect:/";
		 }
		Mesa mesaAEditar = mesaServicio.mesaPorId(idMesa);
		if(mesaAEditar == null){
			return"redirect:/";
		}
		model.addAttribute("mesaAEditar", mesaAEditar);
		return"editaMesa";
	}
	
	@PostMapping("/tables/{idMesa}/edit")
	public String editaMesaForm(@Valid @ModelAttribute("mesa") Mesa mesa,
			BindingResult result, HttpSession session, @PathVariable("idMesa") Long idMesa){
		if (result.hasErrors()){
			return"editaMesa";
		}
		if((Long) session.getAttribute("usuarioId") == null){
			 return"redirect:/";
		 }
		Mesa mesabuscar = mesaServicio.mesaPorId(idMesa);
		if ((Long) session.getAttribute("usuarioId") == mesabuscar.getUsuario().getId()){
			//falta validacion aqui!!!!!!!
			mesa.setId(idMesa);
			mesa.setUsuario(usuarioServicio.findUserById((Long) session.getAttribute("usuarioId")));
			mesaServicio.guardaMesa(mesa);
			return"redirect:/home";
		}
		return"redirect:/home";
	}
	@GetMapping("/tables")
	public String mesasSinUsuario(HttpSession session, Model model){
		if((Long) session.getAttribute("usuarioId") == null){
			 return"redirect:/";
		 }
		List<Mesa> mesas = mesaServicio.todasMesas();
		List<Mesa> mesasSinUsuario = new ArrayList<>();
		for (Mesa mesa : mesas) {
			if(mesa.getUsuario() == null){
				mesasSinUsuario.add(mesa);
			}
		}
		model.addAttribute("mesasSinUsuario", mesasSinUsuario);
		return"mesasSinUsuario";
	}
	
	@GetMapping("/delete/{idMesa}")
	public String eliminaMesa(@PathVariable("idMesa") Long idMesa,HttpSession session){
		if((Long) session.getAttribute("usuarioId") == null){
			 return"redirect:/";
		 }
		Mesa mesa = mesaServicio.mesaPorId(idMesa);
		if ((Long) session.getAttribute("usuarioId") == mesa.getUsuario().getId()){
			mesaServicio.eliminaMesa(idMesa);
			return"redirect:/home";
		}
		return"redirect:/home";
	}
	
	@GetMapping("/desvincula/{idMesa}")
	public String desvinculaMesa(@PathVariable("idMesa") Long idMesa, HttpSession session){
		if((Long) session.getAttribute("usuarioId") == null){
			 return"redirect:/";
		 }
		Mesa mesa = mesaServicio.mesaPorId(idMesa);
		if ((Long) session.getAttribute("usuarioId") == mesa.getUsuario().getId()){
			Mesa mesaADesvincular = mesaServicio.mesaPorId(idMesa);
			mesaADesvincular.setUsuario(null);
			mesaServicio.guardaMesa(mesaADesvincular);
			return"redirect:/home";
		}
		return"redirect:/tables";
	}

	
	@GetMapping("vincula/{idMesa}")
	public String vinculaMesa(@PathVariable("idMesa") Long idMesa, HttpSession session){
		if((Long) session.getAttribute("usuarioId") == null){
			 return"redirect:/";
		 }
		Mesa mesa = mesaServicio.mesaPorId(idMesa);

			Mesa mesaVincular = mesaServicio.mesaPorId(idMesa);
			Usuario usuario = usuarioServicio.findUserById((Long) session.getAttribute("usuarioId"));
			mesaVincular.setUsuario(usuario);
			mesaServicio.guardaMesa(mesaVincular);
			return"redirect:/home";
	}
}
