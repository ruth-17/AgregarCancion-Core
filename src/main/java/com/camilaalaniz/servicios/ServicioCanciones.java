package com.camilaalaniz.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilaalaniz.modelos.Cancion;
import com.camilaalaniz.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
	@Autowired
	
	private final RepositorioCanciones repositorioCanciones;
	
	public ServicioCanciones(RepositorioCanciones repositorioCanciones) {
		this.repositorioCanciones = repositorioCanciones;
	}
	
	//métodos
	
	public List<Cancion> obtenerTodasLasCanciones(){
		return this.repositorioCanciones.findAll();
	}
	
	public Cancion obtenerCancionPorId(Long Id) {
		return this.repositorioCanciones.findById(Id).orElse(null);
	}
	
	public Cancion agregarCancion(Cancion nuevaCancion) {
		return this.repositorioCanciones.save(nuevaCancion);
	}

}
