package com.laurasoto.examenSponja.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.laurasoto.examenSponja.modelos.Tarea;
import com.laurasoto.examenSponja.repositorios.TareaRepositorio;



@Service
public class TareaServicio {
	private final TareaRepositorio tareaRepositorio;
	private final UsuarioServicio usuarioServicio;
	public TareaServicio(TareaRepositorio tareaRepositorio, UsuarioServicio usuarioServicio){
		this.usuarioServicio = usuarioServicio;
		this.tareaRepositorio = tareaRepositorio;
	}
	public List<Tarea> mostrarTarea(){
		return tareaRepositorio.findAll();
	}
	
	public Tarea creaTarea(Tarea nuevaTarea, Long idCreador){
		nuevaTarea.setUsuarioCreador(usuarioServicio.findUserById(idCreador));
		//nuevaTarea.setUsuarioAsignado(usuarioServicio.findUserById(idAsignado));
		return tareaRepositorio.save(nuevaTarea);
	}

	//encuentra edita
		public Tarea buscaTarea(Long id) {
			Optional<Tarea> optionalEvento = tareaRepositorio.findById(id);
		     if(optionalEvento.isPresent()) {
		         return optionalEvento.get();
		     } else {
		         return null;
		     }
		}
		//edita
		public Tarea editaTarea(Tarea tareaEditada){
			return tareaRepositorio.save(tareaEditada);
		}
		
		public List<Tarea> ordenMayorPrioridad(){
			return tareaRepositorio.findByOrderByPrioridadDesc();
		}
		public List<Tarea> ordenMenorPrioridad(){
			return tareaRepositorio.findByOrderByPrioridadAsc();
		}
		public void borrarTarea(Tarea tarea){
			tareaRepositorio.delete(tarea);
		}
}
