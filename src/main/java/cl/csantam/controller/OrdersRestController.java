package cl.csantam.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<Order>> getOrders4(
			@PathVariable Integer store_id, 
			@PathVariable Integer estado,
			@PathVariable String  fechaDesde,
			@PathVariable String  fechaHasta
			
			)  {
	
		try {
			List<Order> orders = orderService.findByStoreAndEstadoAndOrderDateBetween(store_id, estado, fechaDesde, fechaHasta);
			return ResponseEntity.ok( orders );	

		} catch( Exception ex ) {
			return ResponseEntity.notFound().build();
		}
		
	
		
	}

	
//	@GetMapping( path = "/{fechaDesde}/{fechaHasta}")
//	public ResponseEntity<List<Order>> getOrders4(
//			@PathVariable String fechaDesde, 
//			@PathVariable String fechaHasta
//			) throws ParseException {
//		List<Order> orders = orderService.findByOrderDateBetween(fechaDesde, fechaHasta);
//		return ResponseEntity.ok( orders );
//		
//	}
	
	
//	@GetMapping("/{store_id}/{estado}")
//	public ResponseEntity<List<Order>> getOrders2(
//			@RequestParam("store_id") Integer store_id,
//			@RequestParam("estado") Integer estado
//			) {
//		
//
//		List<Order> orders = orderService.findByStoreAndEstado(store_id, estado);
//		return  ResponseEntity.ok( orders );
//		
//	}
	
	
//	@RequestMapping(value="/params", method = RequestMethod.GET)
//	public ResponseEntity <List<Order>> geOrders3(@RequestParam Map<String, String> params ) {
//
//	   System.out.println(params.keySet());
//	   System.out.println(params.values());
//	   
//
//	   List<Order> orders = new ArrayList<Order>();
//	   return new ResponseEntity<List<Order>>(HttpStatus.OK);
//	}
	
	
	
//	@RequestMapping
//	public ResponseEntity<List<Order>> getOrders2() {
//		
//		List<Order> orders = orderService.findByStoreAndEstadoAndOrderDateBetween(store_id, estado, fechaDesde, fechaHasta);
//		
//		return ResponseEntity.ok( estados );
//
//		
//	}
	
 //	public ResponseEntity<List<Order>> getOrders() {
//		
//		List<Order> orders = orderService.getOrders();
//		return ResponseEntity.ok( orders );
//	}

 }
