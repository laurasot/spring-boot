package com.laurasoto.eventos.servicios;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.springframework.stereotype.Service;

import com.laurasoto.eventos.modelos.Evento;
import com.laurasoto.eventos.modelos.Usuario;
import com.laurasoto.eventos.repositorios.EventoRepositorio;
import com.laurasoto.eventos.repositorios.UsuarioRepositorio;

@Service
public class EventoServicio {
	private final EventoRepositorio eventoRepositorio;
	private final UsuarioRepositorio usuarioRepositorio;
	
	public EventoServicio(EventoRepositorio eventoRepositorio, UsuarioRepositorio usuarioRepositorio){
		this.eventoRepositorio = eventoRepositorio;
		this.usuarioRepositorio = usuarioRepositorio;
	}
	public Evento eventoPorId(Long id){
		return eventoRepositorio.findById(id).get();
	}
	public Usuario usuarioPorId(Long id) {
		return usuarioRepositorio.findById(id).get();
	}
	public Evento creaEvento(Evento nuevoEvento, Long idHost){
		nuevoEvento.setHostUsuario(usuarioPorId(idHost));
		return eventoRepositorio.save(nuevoEvento);
	}
	
	public Evento editaEvento(Evento eventoNuevo){
		return eventoRepositorio.save(eventoNuevo);
	}
	
	public List<Evento> mostrarEventos(){
		return eventoRepositorio.findAll();
	}
	
	public List<Evento> mostrarEventoOtrosEstados(String estado){
		return eventoRepositorio.findByStateENotContaining(estado);
	}
	
	public List<Evento> mostrarEventoPorEstado( String region){
		return eventoRepositorio.findByStateEContaining(region);
	}
	//encuentra evento
	public Evento encontrarEvento(Long id) {
		Optional<Evento> optionalEvento = eventoRepositorio.findById(id);
	     if(optionalEvento.isPresent()) {
	         return optionalEvento.get();
	     } else {
	         return null;
	     }
	}
	
	 //eliminar evento
	 public void eliminaEvento(Long id) {
		 Evento evento = encontrarEvento(id);
		 if(evento != null) {
			 eventoRepositorio.deleteById(id);
		 }
	 }
	 public Evento eliminaUsuarioParticipante(Long id, Long idEvento){
		 Usuario usuario = usuarioRepositorio.findById(id).orElse(null);
		 Evento evento = eventoRepositorio.findById(idEvento).orElse(null);
		 List<Usuario> listaParticipantes = evento.getUsuariosParticipantes();
		 listaParticipantes.remove(usuario);
		 return eventoRepositorio.save(evento); 
	 }
}
