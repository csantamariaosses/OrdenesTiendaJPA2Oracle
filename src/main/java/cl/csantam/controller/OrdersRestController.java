package cl.csantam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.csantam.model.entity.Order;
import cl.csantam.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrdersRestController {
	
	
	@Autowired
	private OrderService orderService;  
	

	@GetMapping
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> orders = orderService.getOrders();
		
		return ResponseEntity.ok( orders );		
	}
	
	@GetMapping( path = "/{store_id}/{estado}/{fechaDesde}/{fechaHasta}")
	public ResponseEntity<List<Order>> getOrdersByStoreAndEstadoAndOrderDate(
			@PathVariable Integer store_id, 
			@PathVariable Integer estado,
			@PathVariable String  fechaDesde,
			@PathVariable String  fechaHasta
			
			)  {
	
		try {
			System.out.println( fechaDesde);
			List<Order> orders = orderService.findByStoreAndEstadoAndOrderDateBetween(store_id, estado, fechaDesde, fechaHasta);
			return ResponseEntity.ok( orders );	

		} catch( Exception ex ) {
			return ResponseEntity.notFound().build();
		}	
	}
	
	
	@GetMapping( path = "/estados/{store_id}/{estado}")
	public ResponseEntity<List<Order>> getOrdersByStoreAndEstado(
			@PathVariable Integer store_id, 
			@PathVariable Integer estado
			
			)  {
	
		try {

			List<Order> orders = orderService.findByStoreAndEstado(store_id, estado);
			return ResponseEntity.ok( orders );	

		} catch( Exception ex ) {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@GetMapping( path = "/{store_id}")
	public ResponseEntity<List<Order>> getOrdersByStore(
			@PathVariable Integer store_id
			)  {
	
		try {

			List<Order> orders = orderService.findByStore( store_id );
			return ResponseEntity.ok( orders );	

		} catch( Exception ex ) {
			return ResponseEntity.notFound().build();
		}	
	}

	
	@GetMapping( path = "/fechas//{fechaDesde}/{fechaHasta}")
	public ResponseEntity<List<Order>> getOrdersByFechas(
			@PathVariable String  fechaDesde,
			@PathVariable String  fechaHasta
			)  {
	
		try {

			List<Order> orders = orderService.findByOrderDateBetween(fechaDesde, fechaHasta);
			return ResponseEntity.ok( orders );	

		} catch( Exception ex ) {
			return ResponseEntity.notFound().build();
		}	
	}
	


 }
