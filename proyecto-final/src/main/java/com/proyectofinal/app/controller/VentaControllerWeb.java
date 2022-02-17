package com.proyectofinal.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.app.service.VentaService;

@Controller
public class VentaControllerWeb {	
	
	@Autowired
	private VentaService servicio;
	
	
	@GetMapping({"/ventas"})
	public String listarVentas(Model model) {
		model.addAttribute("dato", servicio.listarTodosLosVentas());
		return "ventas";
	}
	
}
