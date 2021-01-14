package cl.csantam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.csantam.model.dao.CustomerDao;
import cl.csantam.model.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> getCustomers() {
		return customerDao.findAll();
	}
	
	public double getCount() {
		double count = customerDao.count();
		return count;
	}
	
//	public Customer findByCustomerId(Integer customer_id) {
//		return customerDao.findByCustomerId(customer_id);
//	}
	
	
}
