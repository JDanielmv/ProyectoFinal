package com.proyectofinal.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectofinal.app.entity.Cliente;
import com.proyectofinal.app.service.ClienteService;


@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService servicio;
	
	@GetMapping({"/clientes", "/"})
	public String listarClientes(Model model) {
		model.addAttribute("dato", servicio.listarTodosLosClientes());
		return "clientes";
	}
	
	@GetMapping("/clientes/nuevo")
	public String formularioCliente(Model modelo) {
		Cliente newCliente = new Cliente();
		modelo.addAttribute("clienteKey", newCliente);
		return "nuevo_cliente";
	}
	
	@PostMapping("/clientes")
	public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
		servicio.guardarCliente(cliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/clientes/editar/{id}")
	public String formularioEdicionCliente(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("clienteKey", servicio.obtenerClientePorId(id));
		return "editar_cliente";
	}
	
	@PostMapping("/clientes/editar/{id}")
	public String editarCliente(@PathVariable Long id, @ModelAttribute("clienteKey") Cliente cliente) {
		Cliente clienteEdit = servicio.obtenerClientePorId(id);
		clienteEdit.setNombre(cliente.getNombre());
		clienteEdit.setApellido(cliente.getApellido());
		clienteEdit.setSexo(cliente.getSexo());
		clienteEdit.setTelefono(cliente.getTelefono());
		
		servicio.guardarCliente(clienteEdit);
		return "redirect:/clientes";
	}
	
	@GetMapping("/clientes/borrar/{id}")
	public String eliminarCliente(@PathVariable Long id) {
		servicio.eliminarCliente(id);
		return "redirect:/clientes";
	}
}






