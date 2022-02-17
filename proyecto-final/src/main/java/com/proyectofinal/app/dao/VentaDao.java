package com.proyectofinal.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectofinal.app.entity.Venta;

@Repository
public interface VentaDao extends CrudRepository<Venta, Long> {

}
