package cl.csantam.model.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.csantam.model.entity.Estado;
import cl.csantam.model.entity.Order;
import cl.csantam.model.entity.Store;

public interface OrderDao extends JpaRepository<Order, Long>{
	public List<Order> getData(HashMap<String, Object> conditions);
	
//	public List<Order> findByStore_idAndOrderStatus(Integer store_id, Integer estado);
//	public List<Order> findByStoreIdAndEstadoAndOrderDateBetween(Integer store_id, Integer estado, String fechaDesde, String fechaHasta);
	
	public List<Order> findByEstado(Estado estado);
	public List<Order> findByStore(Store store);
	public List<Order> findByStoreAndEstado(Store store, Estado estado);
	public List<Order> findByOrderDateBetween(Date fechaDesde, Date fechaHasta);
	public List<Order> findByStoreAndEstadoAndOrderDateBetween(Store store, Estado estado, Date fechaDesde, Date fechaHasta );
}
