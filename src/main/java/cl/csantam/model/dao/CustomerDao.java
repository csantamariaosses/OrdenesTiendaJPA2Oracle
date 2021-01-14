package cl.csantam.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import cl.csantam.model.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

//	@Query("select c.first_name from Customer c where c.customer_id = 1")
//    Customer  findByCustomerId(Integer id);
}
