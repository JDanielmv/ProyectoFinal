package com.proyectofinal.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.app.dao.ProductoDao;
import com.proyectofinal.app.entity.Producto;


@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public List<Producto> listarTodosLosProductos() {
		return (List<Producto>) productoDao.findAll();
	}
	
	@Override
	public Producto guardarProducto(Producto producto) {
		return productoDao.save(producto);
	}
	
	@Override
	public Producto obtenerProductoPorId(Long id) {
		return productoDao.findById(id).get();
	}

	@Override
	public void eliminarProducto(Long id) {
		productoDao.deleteById(id);
	}

}

