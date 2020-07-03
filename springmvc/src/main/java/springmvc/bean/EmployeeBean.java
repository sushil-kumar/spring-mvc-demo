package springmvc.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EmployeeBean {
	private String empId;
	private String empName;
	private String message;
}
