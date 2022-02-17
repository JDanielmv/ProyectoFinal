package com.proyectofinal.app.service;

import java.util.List;

import com.proyectofinal.app.entity.Producto;

public interface ProductoService {
	public List<Producto> listarTodosLosProductos();
	
	public Producto guardarProducto(Producto producto);
	
	public Producto obtenerProductoPorId(Long id);
	
	public void eliminarProducto(Long id);
}
