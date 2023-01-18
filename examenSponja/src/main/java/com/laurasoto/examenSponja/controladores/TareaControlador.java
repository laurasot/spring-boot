package com.laurasoto.examenSponja.controladores;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laurasoto.examenSponja.modelos.Tarea;
import com.laurasoto.examenSponja.modelos.Usuario;
import com.laurasoto.examenSponja.servicios.TareaServicio;
import com.laurasoto.examenSponja.servicios.UsuarioServicio;

@Controller
public class TareaControlador {
	private final TareaServicio tareaServicio;
	private final UsuarioServicio usuarioServicio;
	public TareaControlador(TareaServicio tareaServicio, UsuarioServicio usuarioServicio){
		this.tareaServicio = tareaServicio;
		this.usuarioServicio = usuarioServicio;
	}
	
	@GetMapping("/tareas")
	public String mostrarTareas(Model model, HttpSession session){
		if (session.getAttribute("usuarioId") == null){
			return"redirect:/login";
		}
		System.out.println(session.getAttribute("usuarioId"));
		List<Tarea> tareas = tareaServicio.mostrarTarea();
		
		model.addAttribute("tareas", tareas);
		return"tareas";
	}
	
	@GetMapping("/tareaNueva")
	public String muestraFormTarea(HttpSession session, @ModelAttribute("tarea") Tarea tarea,
			 Model model){
		if (session.getAttribute("usuarioId") != null){
			List<Usuario> listaUsuarios = usuarioServicio.mostrarUsuarios();
			model.addAttribute("listaUsuarios", listaUsuarios);
			return"nuevaTarea";
		}
		return"redirect:/login";
		
	}
	
	@PostMapping("/tareaNueva")
	public String FormularioTarea(@Valid @ModelAttribute("tarea") Tarea tarea,
			BindingResult result, HttpSession session, Model model){
		if (result.hasErrors()) {
			List<Usuario> listaUsuarios = usuarioServicio.mostrarUsuarios();
			model.addAttribute("listaUsuarios", listaUsuarios);
	         return "nuevaTarea";
	    }
		//System.out.println(idAsignado);
		//Usuario usuarioAsignado = usuarioServicio.findUserById(idAsignado)
		//se setea y luego se guarda con save, porque este ultimo lo guarda en la base de datos
		if (tarea.getUsuarioAsignado().getTareasAsignadas().size() >= 3) {
			List<Usuario> listaUsuarios = usuarioServicio.mostrarUsuarios();
			model.addAttribute("listaUsuarios", listaUsuarios);
			model.addAttribute("error", "no puedes asignarle mas de tres tareas a una misma persona");
			return"nuevaTarea";
		}
		Tarea nuevaTarea = tareaServicio.creaTarea(tarea,(Long) session.getAttribute("usuarioId"));
		return"redirect:/tareas";
	}
	
	@GetMapping("/tarea/{id}")
	public String detalleTarea(Model model, HttpSession session, @PathVariable("id") Long id){
		if (session.getAttribute("usuarioId") == null){
			return"redirect:/login";
		}
		Long idUsuarioLogin = (Long) session.getAttribute("usuarioId");
		System.out.println(idUsuarioLogin);
		Tarea tarea = tareaServicio.buscaTarea(id);
		model.addAttribute("tarea", tarea);
		model.addAttribute("idUsuarioLogin", idUsuarioLogin);
		return"detalleTarea";
	}
	
	@GetMapping("/tarea/{id}/edit")
	public String editaTarea(@ModelAttribute("tarea") Tarea tarea, HttpSession session, Model model){
		List<Usuario> listaUsuarios = usuarioServicio.mostrarUsuarios();
		model.addAttribute("listaUsuarios", listaUsuarios);
		return"editaTarea";
	}
	
	@PutMapping("/tarea/{id}/edit")
	public String formEditaTarea(@Valid @ModelAttribute("tarea") Tarea tarea,BindingResult result, HttpSession session, 
			@PathVariable("id") Long id, Model model){
		if (result.hasErrors()) {
			List<Usuario> listaUsuarios = usuarioServicio.mostrarUsuarios();
			model.addAttribute("listaUsuarios", listaUsuarios);
	         return "editaTarea";
	    }
		if (session.getAttribute("usuarioId") == null){
			return"redirect:/login";
		}
		if (tarea.getUsuarioAsignado().getTareasAsignadas().size() >= 3) {
			List<Usuario> listaUsuarios = usuarioServicio.mostrarUsuarios();
			model.addAttribute("listaUsuarios", listaUsuarios);
			model.addAttribute("error", "no puedes asignarle mas de tres tareas a una misma persona");
			return"editaTarea";
		}
		tarea = tareaServicio.creaTarea(tarea, (Long) session.getAttribute("usuarioId"));
		return"redirect:/tareas";
	}
	
	@GetMapping("/mayor")
	public String mayorPrioridad(HttpSession session, Model model){
		if (session.getAttribute("usuarioId") == null){
			return"redirect:/login";
		}
		
		Usuario usuarioLogueado = usuarioServicio.findUserById((Long) session.getAttribute("usuarioId"));
		List<Tarea> tareas = tareaServicio.ordenMayorPrioridad();
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		model.addAttribute("tareas", tareas);
		return"tareas";
	}
	@GetMapping("/menor")
	public String menorPrioridad(HttpSession session, Model model){
		if (session.getAttribute("usuarioId") == null){
			return"redirect:/login";
		}
		//Usuario usuarioLogueado = usuarioServicio.findUserById((Long) session.getAttribute("usuarioId"));
		List<Tarea> tareas = tareaServicio.ordenMenorPrioridad();
		//model.addAttribute("usuarioLogueado", usuarioLogueado);
		model.addAttribute("tareas", tareas);
		return"tareas";
	}
	@GetMapping("/delete/{id}")
	public String eliminar(HttpSession session, @PathVariable Long id){
		if (session.getAttribute("usuarioId") == null){
			return"redirect:/login";
		}
		Tarea tareaBorrar = tareaServicio.buscaTarea(id);
		tareaServicio.borrarTarea(tareaBorrar);
		return"redirect:/tareas";
	}
	@GetMapping("/completa/{id}")
	public String completarTarea(HttpSession session, @PathVariable Long id){
		if (session.getAttribute("usuarioId") == null){
			return"redirect:/login";
		}
		Tarea tareaCompletada = tareaServicio.buscaTarea(id);
		tareaCompletada.setEstaListo(true);
		tareaServicio.creaTarea(tareaCompletada,(Long) session.getAttribute("usuarioId"));
		return"redirect:/tareas";
	}
	}
