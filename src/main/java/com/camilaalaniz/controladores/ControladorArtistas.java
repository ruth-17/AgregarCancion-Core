package com.camilaalaniz.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.camilaalaniz.modelos.Artista;
import com.camilaalaniz.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
	
	@Autowired
	private final ServicioArtistas servicioArtistas;
	
	public ControladorArtistas(ServicioArtistas servicioArtistas) {
		this.servicioArtistas = servicioArtistas;
	}
	
	@GetMapping("/artistas")
	public String desplegarArtistas(Model modelo) {
		List<Artista> listaDeArtistas = this.servicioArtistas.obtenerTodosLosArtistas();
		modelo.addAttribute("listaArtistas", listaDeArtistas);
		return "artistas.jsp";
	}
	
	@GetMapping("/artistas/detalle/{idArtista}")
	public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista, Model modelo) {
		Artista artistaBuscado = this.servicioArtistas.obtenerArtistaPorId(idArtista);
		modelo.addAttribute("artista", artistaBuscado);
		return "detalleArtista.jsp";
	}
	
	@GetMapping("/artistas/formulario/agregar/{idArtista}")
	public String formularioAgregarArtista(@ModelAttribute ("artista") Artista artista) {
		return "agregarArtista.jsp";
	}
	
	@PostMapping("/artistas/procesa/agregar")
	public String procesarAgregarArtista(@Valid @ModelAttribute ("artista") Artista artista,
			                             BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "agregarArtista.jsp";
		}
		this.servicioArtistas.agregarArtista(artista);
		return "redirect:/artistas";
	}
}
