package com.laurasoto.eventos.servicios;

import org.springframework.stereotype.Service;

import com.laurasoto.eventos.modelos.Comentario;
import com.laurasoto.eventos.repositorios.ComentarioRepositorio;

@Service
public class ComentarioServicio {
	private final ComentarioRepositorio comentarioRepositorio;
	private final UsuarioServicio usuarioServicio;
	private final EventoServicio eventoServicio;
	public ComentarioServicio(ComentarioRepositorio comentarioRepositorio, UsuarioServicio usuarioServicio, EventoServicio eventoServicio){
		this.eventoServicio = eventoServicio;
		this.comentarioRepositorio = comentarioRepositorio;
		this.usuarioServicio = usuarioServicio;
	}
	
	public Comentario crearComentario(Comentario comentario, Long idEvento, Long idHost){
		comentario.setUsuario(usuarioServicio.findUserById(idHost));
		comentario.setEvento(eventoServicio.encontrarEvento(idEvento));
		return comentarioRepositorio.save(comentario);
	}
	
}
