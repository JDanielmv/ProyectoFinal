package com.proyectofinal.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectofinal.app.entity.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long> {

}