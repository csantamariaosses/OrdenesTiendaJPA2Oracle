package cl.csantam.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.csantam.dto.FormDto;
import cl.csantam.model.entity.Customer;
import cl.csantam.model.entity.Estado;
import cl.csantam.model.entity.Order;
import cl.csantam.model.entity.Store;
import cl.csantam.service.CustomerService;
import cl.csantam.service.EstadoService;
import cl.csantam.service.OrderService;
import cl.csantam.service.StoreService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private OrderService orderService;
	
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	private String home(ModelMap mapa) {
		System.out.println("****  HOME ****");
		List<Estado> estados = estadoService.getEstados();
		List<Store> stores = storeService.getStores();
		List<Order> orders = orderService.getOrders();
		
		
//		List<Staff> staffs = staffService.getStaffs();
		List<Customer> customers = customerService.getCustomers();
//		double contCustomers = customerService.getCount();
		
//		estados.forEach(System.out::println);
//		stores.forEach(System.out::println);
//		orders.forEach(System.out::println);
//		staffs.forEach(System.out::println);
//		System.out.println("Customers::" + contCustomers);
		
		
		mapa.put("estados", estados);
		mapa.put("stores", stores);
		mapa.put("orders", orders);
		mapa.put("customers", customers);
		
		return "home";
	}
	
	
	@PostMapping
	private String Busqueda(ModelMap mapa, 
			@ModelAttribute FormDto frmDto) throws ParseException {
		
		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		
		Integer store_id = frmDto.getStore();
		Integer estado   = frmDto.getEstado();
		String  fechaDesde = frmDto.getFechaDesde();
		String  fechaHasta = frmDto.getFechaHasta();
		
		

				
		logger.info("store:" + store_id);
		logger.info("estado:" + estado);
		logger.info("fechaDesde:" + fechaDesde);
		logger.info("fechaHasta:" + fechaHasta);
		
//		HashMap<String, Object> data = new HashMap<>();
//		if ( store_id != null && store_id != 0) {
//			logger.info("Agrega store");
//			data.put("store_id", store_id );
//		}
//			
//		if ( estado != 0) {
//			logger.info("Agrega estado");
//			data.put("estado",  estado );
//		}
//		
//		if ( fechaDesde != "") {
//			logger.info("Agrega fechaDesde");
//			String ddMMyy = fechaDesde.substring(8, 10)+'-'+fechaDesde.substring(5, 7)+'-'+fechaDesde.substring(2, 4);
//			logger.info("Fecha Formateada:" + sdf.parse(ddMMyy));
//			
//			data.put("order_date_desde",  sdf.parse( ddMMyy ));
//		}	    
		
		
		List<Estado> estados = estadoService.getEstados();
		List<Store> stores = storeService.getStores();
//		List<Order> orders = orderService.getData(data);
//		List<Order> orders = orderService.buscarFiltro(store_id, estado, fechaDesde, fechaHasta);
		
//		for( Order orde:orders) {
//			System.out.println(orde);
//		}
		
	
//		List<Order> orders = orderService.findByEstado(estado);
//		List<Order> orders = orderService.findByStore(store_id);
//		List<Order> orders = orderService.findByStoreAndEstado(store_id, estado);
//		List<Order> orders = orderService.findByOrderDateBetween(fechaDesde, fechaHasta);
		List<Order> orders = orderService.findByStoreAndEstadoAndOrderDateBetween(store_id, estado, fechaDesde, fechaHasta);
		
		mapa.put("estados", estados);;
		mapa.put("stores", stores);
		mapa.put("orders", orders);

		

		
		return "home";
	}
	

}
