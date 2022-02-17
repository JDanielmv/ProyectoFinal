package com.proyectofinal.app.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=50)
	private String nombre;
	
	@Column(nullable=false, length=100)
	private String descripcion;
	
	@Column(nullable=false)
	private int pUnidad;
	
	
	private int existencias;


	public Long getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getpUnidad() {
		return pUnidad;
	}


	public void setpUnidad(int pUnidad) {
		this.pUnidad = pUnidad;
	}


	public int getExistencias() {
		return existencias;
	}


	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}


	public void setId(Long id) {
		this.id = id;
	}


	
	
	
}

