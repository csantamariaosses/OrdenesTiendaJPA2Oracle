package cl.csantam.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.csantam.model.entity.Estado;

public interface EstadoDao extends JpaRepository<Estado, Integer>{

}
