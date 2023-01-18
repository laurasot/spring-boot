package com.laurasoto.BlackBelt.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.laurasoto.BlackBelt.modelos.Mesa;
import com.laurasoto.BlackBelt.repositorios.MesaRepositorio;

@Service
public class MesaServicio {
	private final MesaRepositorio mesaRepositorio;
	public MesaServicio( MesaRepositorio mesaRepositorio){
		this.mesaRepositorio = mesaRepositorio;
	}
	public Mesa guardaMesa(Mesa nuevaMesa){
		return mesaRepositorio.save(nuevaMesa);
	}
	public Mesa mesaPorId(Long id){
		return mesaRepositorio.findById(id).orElse(null);
	}
	public List<Mesa> todasMesas(){
		return mesaRepositorio.findAll();
	}
	public void eliminaMesa(Long id){
		mesaRepositorio.deleteById(id);
	}
}
