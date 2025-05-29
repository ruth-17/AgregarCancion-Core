package com.camilaalaniz.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilaalaniz.modelos.Artista;
import com.camilaalaniz.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
	@Autowired
	
	private final RepositorioArtistas repositorioArtistas;
	
	public ServicioArtistas(RepositorioArtistas repositorioArtistas) {
		this.repositorioArtistas = repositorioArtistas;
	}
	
	//métodos
	
	public List<Artista> obtenerTodosLosArtistas(){
		return this.repositorioArtistas.findAll();
	}
	
	public Artista obtenerArtistaPorId(Long id) {
		return this.repositorioArtistas.findById(id).orElse(null);
	}
	
	public Artista agregarArtista(Artista nuevoArtista) {
		return this.repositorioArtistas.save(nuevoArtista);
	}

}