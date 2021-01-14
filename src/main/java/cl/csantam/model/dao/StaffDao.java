package cl.csantam.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.csantam.model.entity.Staff;

public interface StaffDao  extends JpaRepository<Staff, Integer>{

}
