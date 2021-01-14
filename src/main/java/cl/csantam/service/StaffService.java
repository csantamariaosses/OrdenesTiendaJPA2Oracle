package cl.csantam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.csantam.model.dao.StaffDao;
import cl.csantam.model.entity.Staff;

@Service
public class StaffService {

	@Autowired
	private StaffDao staffDao;
	
	public List<Staff> getStaffs() {
		return staffDao.findAll();
	}
}
