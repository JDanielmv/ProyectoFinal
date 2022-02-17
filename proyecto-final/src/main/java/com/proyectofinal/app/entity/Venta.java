package com.proyectofinal.app.entity;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="ventas")
public class Venta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_cliente")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Cliente cod_cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_producto")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Producto cod_producto;
	
	@Column(nullable=false)
	private int cantidad;
	
	@Column(nullable=false)
	private int subtotal;
	
	@Column(nullable=false)
	private int iva;
	
	@Column(nullable=false)
	private int total;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(Cliente cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public Producto getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(Producto cod_producto) {
		this.cod_producto = cod_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
		
	
	
}
