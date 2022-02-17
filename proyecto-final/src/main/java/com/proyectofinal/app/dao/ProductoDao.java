package com.proyectofinal.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectofinal.app.entity.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Long> {

}