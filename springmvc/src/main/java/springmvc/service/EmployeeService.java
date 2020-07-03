package springmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.bean.EmployeeBean;
import springmvc.dao.EmployeeDao;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public int addEmployee(EmployeeBean employee) {
		
		return employeeDao.saveEmployee(employee);
	}
}
