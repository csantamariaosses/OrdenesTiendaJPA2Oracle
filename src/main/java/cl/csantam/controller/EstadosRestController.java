package cl.csantam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.csantam.dto.OrdersDto;
import cl.csantam.model.entity.Estado;
import cl.csantam.model.entity.Order;
import cl.csantam.service.EstadoService;
import cl.csantam.service.OrderService;

@RestController
@RequestMapping("/estados")
public class EstadosRestController {
	
	
	@Autowired
	private EstadoService estadoService;  
	

	
	@GetMapping
	public ResponseEntity<List<Estado>> getEstados() {
		List<Estado> estados = estadoService.getEstados();
		
		return ResponseEntity.ok( estados );

		
	}
	
 //	public ResponseEntity<List<Order>> getOrders() {
//		
//		List<Order> orders = orderService.getOrders();
//		return ResponseEntity.ok( orders );
//	}

 }
