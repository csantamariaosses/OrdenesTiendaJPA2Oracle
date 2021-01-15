package cl.csantam.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.csantam.model.dao.EstadoDao;
import cl.csantam.model.dao.OrderDao;
import cl.csantam.model.dao.StoreDao;
import cl.csantam.model.entity.Estado;
import cl.csantam.model.entity.Order;
import cl.csantam.model.entity.Store;


@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private EstadoDao estadoDao;
	
	@Autowired
	private StoreDao storeDao;
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	public List<Order> getData(HashMap<String, Object> conditions ){
		return orderDao.getData(conditions);
	}
	
	
	public List<Order> findByEstado(Integer estado )  {
		Estado estado_ = estadoDao.findById( estado ).orElse(null);
		return orderDao.findByEstado( estado_ );
	}
	
	public List<Order> findByStore(Integer store_id )  {
		Store store_ = storeDao.findById( store_id ).orElse(null);
		return orderDao.findByStore( store_ );
	}
	
	public List<Order> findByStoreAndEstado( Integer store_id, Integer estado) {
		System.out.println("Order Service-----------");
		Store store_ = storeDao.findById( store_id ).orElse(null);
		Estado estado_ = estadoDao.findById( estado ).orElse(null);
		return orderDao.findByStoreAndEstado(store_, estado_);
	}

	public List<Order> findByOrderDateBetween(String fechaDesde, String fechaHasta) throws ParseException {

		String ddMMyy_desde = fechaDesde.substring(8, 10)+'/'+fechaDesde.substring(5, 7)+'/'+fechaDesde.substring(2, 4);
		String ddMMyy_hasta = fechaHasta.substring(8, 10)+'/'+fechaHasta.substring(5, 7)+'/'+fechaHasta.substring(2, 4);
		
		Date date1 = new SimpleDateFormat("dd/MM/yy").parse(ddMMyy_desde);
		Date date2 = new SimpleDateFormat("dd/MM/yy").parse(ddMMyy_hasta);
		
//		logger.info("Fecha Formateada:" + sdf.parse(ddMMyy));
		return orderDao.findByOrderDateBetween( date1 , date2 );
	}
	
	public List<Order> findByStoreAndEstadoAndOrderDateBetween(Integer store_id, Integer estado, String fechaDesde, String fechaHasta ) throws ParseException {
		Store store_ = storeDao.findById( store_id ).orElse(null);
		Estado estado_ = estadoDao.findById( estado ).orElse(null);
		
		String ddMMyy_desde = fechaDesde.substring(8, 10)+'/'+fechaDesde.substring(5, 7)+'/'+fechaDesde.substring(2, 4);
		String ddMMyy_hasta = fechaHasta.substring(8, 10)+'/'+fechaHasta.substring(5, 7)+'/'+fechaHasta.substring(2, 4);
		
		Date date1 = new SimpleDateFormat("dd/MM/yy").parse(ddMMyy_desde);
		Date date2 = new SimpleDateFormat("dd/MM/yy").parse(ddMMyy_hasta);
		
		return orderDao.findByStoreAndEstadoAndOrderDateBetween(store_, estado_, date1, date2);
		
	}
}
