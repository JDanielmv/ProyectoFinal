package com.proyectofinal.app.service;

import java.util.List;

import com.proyectofinal.app.entity.Cliente;

public interface ClienteService {
	public List<Cliente> listarTodosLosClientes();
	
	public Cliente guardarCliente(Cliente cliente);
	
	public Cliente obtenerClientePorId(Long id);
	
	public void eliminarCliente(Long id);
}
