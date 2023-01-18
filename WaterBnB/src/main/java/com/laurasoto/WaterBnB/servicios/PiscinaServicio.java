package com.laurasoto.WaterBnB.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.laurasoto.WaterBnB.modelos.Piscina;
import com.laurasoto.WaterBnB.modelos.Usuario;
import com.laurasoto.WaterBnB.repositorios.PiscinaRepositorio;
import com.laurasoto.WaterBnB.repositorios.UsuarioRepositorio;



@Service
public class PiscinaServicio {
	private final PiscinaRepositorio piscinaRepositorio;
	private final UsuarioRepositorio usuarioRepositorio;
	public PiscinaServicio(PiscinaRepositorio piscinaRepositorio, UsuarioRepositorio usuarioRepositorio){
		this.piscinaRepositorio = piscinaRepositorio;
		this.usuarioRepositorio = usuarioRepositorio;
	}
	//el .get elimina el optional
	public Usuario usuarioPorId(Long id){
		return usuarioRepositorio.findById(id).get();
	}
	
	public Piscina piscinaPorId(Long id){
		return piscinaRepositorio.findById(id).get();
	}
	public Piscina crearPiscina(Piscina nuevaPiscina, Long idHost){
		nuevaPiscina.setHostUsuario(usuarioPorId(idHost));
		return piscinaRepositorio.save(nuevaPiscina);
	}
	public Piscina editaPiscina(Piscina nuevaPiscina){
		return piscinaRepositorio.save(nuevaPiscina);
	}
	public List<Piscina> piscinaPorDireccion(String direccion){
		return piscinaRepositorio.findByDireccionContaining(direccion);
	}
	
}
