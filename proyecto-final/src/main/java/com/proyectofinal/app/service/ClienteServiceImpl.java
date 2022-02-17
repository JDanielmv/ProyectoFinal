package com.proyectofinal.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.app.dao.ClienteDao;
import com.proyectofinal.app.entity.Cliente;


@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public List<Cliente> listarTodosLosClientes() {
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return clienteDao.save(cliente);
	}
	
	@Override
	public Cliente obtenerClientePorId(Long id) {
		return clienteDao.findById(id).get();
	}

	@Override
	public void eliminarCliente(Long id) {
		clienteDao.deleteById(id);
	}

}

