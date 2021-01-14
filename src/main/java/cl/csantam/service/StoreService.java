package cl.csantam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.csantam.model.dao.StoreDao;
import cl.csantam.model.entity.Store;

@Service
public class StoreService {

	@Autowired
	private StoreDao storeDao;
	
	public List<Store> getStores() {
		return storeDao.findAll();
	}
}
