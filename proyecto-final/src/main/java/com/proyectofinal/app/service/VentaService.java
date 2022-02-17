package com.proyectofinal.app.service;

import java.util.List;

import com.proyectofinal.app.entity.Venta;

public interface VentaService {
	
	public List<Venta> findAll();
	
	public List<Venta> listarTodosLosVentas();
	
	//BUSCAR ID
	public Venta findById(Long id);
	
	//BORRAR VENTA
	public void delete (Long id);
	
	//GUARDAR VENTA PARA ACTUALIZAR
	public Venta save(Venta venta);

}
