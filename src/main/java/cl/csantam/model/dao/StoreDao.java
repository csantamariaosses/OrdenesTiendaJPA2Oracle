package cl.csantam.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.csantam.model.entity.Store;

public interface StoreDao extends JpaRepository<Store, Integer>{

}
