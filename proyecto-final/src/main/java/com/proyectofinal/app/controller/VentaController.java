package com.proyectofinal.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.app.entity.Venta;
import com.proyectofinal.app.service.VentaService;


@RestController
@RequestMapping("/api")
public class VentaController {
	
	@Autowired
	private VentaService servicio;
	
	
	@GetMapping("/venta")
	public List<Venta> venta() {
		return servicio.findAll();
		
	}
	//fdsfsda
	//----------------------------------------------------------------------------------------------------------------------------

	
	//READ VENTAS
	
	@GetMapping("/ventas/{id}")
	public ResponseEntity<?> ventaShow(@PathVariable Long id){
		Venta venta = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			venta = servicio.findById(id);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar consulta a la base de datos :(");
			response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (venta == null) {
			response.put("Mensaje, ","El venta ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Venta>(venta, HttpStatus.OK);
		
	}
	
	//----------------------------------------------------------------------------------------------------------------------------
	
	
	// DELETE VENTAS
	
	@DeleteMapping("/ventas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> deleteVentaMostrado(@PathVariable  Long id) {
		Venta ventaBorrado= servicio.findById(id);
		Map<String, Object> response = new HashMap<>();
		
		try {	
			
			if (ventaBorrado == null) {
				response.put("Mensaje, ","El venta ID: ".concat(id.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			
			servicio.delete(id);
			
		}
			catch (DataAccessException e) {
			response.put("Mensaje", "Error al borrar en la base de datos :(");
			response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage())); 
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		response.put("Mensaje","El venta ha sido borrado :D");
		response.put("venta", ventaBorrado);
		 
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	//----------------------------------------------------------------------------------------------------------------------------
	
	
	//ACTUALIZAR VENTA
	
	
	@PutMapping("/ventas/{id}")
	public ResponseEntity<?> updateVenta(@RequestBody Venta venta, @PathVariable Long id) {
		
		Venta ventaUpdated = servicio.findById(id);
		Map<String, Object> response = new HashMap<>();
		
		try {
			ventaUpdated.setCod_cliente(venta.getCod_cliente());
			ventaUpdated.setCod_producto(venta.getCod_producto());
			ventaUpdated.setCantidad(venta.getCantidad());
			ventaUpdated.setSubtotal(venta.getSubtotal());
			ventaUpdated.setIva(venta.getIva());
			ventaUpdated.setTotal(venta.getTotal());
			
			servicio.save(ventaUpdated);
			
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al actualizar en la base de datos :(");
			response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage())); 
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje","El venta ha sido actualizado :D");
		response.put("venta", ventaUpdated);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	

	//----------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	//INSERTAR VENTA
	
	
	@PostMapping("/ventas")
	public ResponseEntity<?> saveVenta(@RequestBody Venta venta) {
		Venta ventaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			ventaNew = servicio.save(venta);
		} catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar insert a la base de datos :(");
			response.put("Error", e.getMessage().concat("_").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje","El venta ha sido creado correctamente :D");
		response.put("Venta", ventaNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	

	//----------------------------------------------------------------------------------------------------------------------------
	
}