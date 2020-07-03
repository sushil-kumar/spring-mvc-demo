package springmvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import springmvc.bean.EmployeeBean;

@Repository
public class EmployeeDao {
	
	private static Map<String, String> db = new HashMap<String, String>();

	public int saveEmployee(EmployeeBean employee) {
		if (db.containsKey(employee.getEmpId())) {
			return 1;
		} else {
			db.put(employee.getEmpId(), employee.getEmpName());
		}
		System.out.println(db);
		return 0;
	}
}
