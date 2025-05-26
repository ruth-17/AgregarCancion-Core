package com.camilaalaniz.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.camilaalaniz.modelos.Cancion;
import com.camilaalaniz.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	
	@Autowired
	private final ServicioCanciones servicioCanciones;
	
	public ControladorCanciones(ServicioCanciones servicioCanciones) {
		this.servicioCanciones = servicioCanciones;
	}
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		List<Cancion> listaDeCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
		modelo.addAttribute("listaCanciones", listaDeCanciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long Id, Model modelo) {
		Cancion cancionBuscada = this.servicioCanciones.obtenerCancionPorId(Id);
		modelo.addAttribute("cancion", cancionBuscada);
		return "detalleCancion.jsp";
	}
	
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion) {
		return "agregarCancion.jsp";
	}
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
			                             BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "agregarCancion.jsp";
		}
		
		this.servicioCanciones.agregarCancion(cancion);
		return "redirect:/canciones";
	}
	
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@ModelAttribute("cancion") Cancion cancion,
			                              @PathVariable("idCancion") Long idCancion,
			                              Model modelo) {
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
		if (cancionActual == null) {
			return "redirect:/canciones";
		}
		modelo.addAttribute("cancion", cancionActual);
		return "editarCancion.jsp";
	}
	
	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
			                            BindingResult validaciones, 
			                            @PathVariable("idCancion") Long idCancion) {
		if (validaciones.hasErrors()) {
			return "editarCancion.jsp";
		}
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
		cancion.setId(cancionActual.getId());
		this.servicioCanciones.actualizarCancion(cancion);
		return "redirect:/canciones";
	}
	
	@DeleteMapping("/canciones/eliminar/{idCancion}")
	public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
		this.servicioCanciones.eliminarCancion(idCancion);
		return "redirect:/canciones";
	}
	
}
