package cl.csantam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.csantam.model.dao.EstadoDao;
import cl.csantam.model.entity.Estado;


@Service
public class EstadoService {
	
	@Autowired
	private EstadoDao estadoDao;
	
	public List<Estado> getEstados() {
		return estadoDao.findAll();
	}
	

}
