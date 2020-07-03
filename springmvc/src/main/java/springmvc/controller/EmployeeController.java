package springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvc.bean.EmployeeBean;
import springmvc.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("add")
	public ModelAndView addEmployee(@ModelAttribute EmployeeBean employee) {
		System.out.println("Adding Employee");
		System.out.println("Id = " + employee.getEmpId());
		System.out.println("Name = " + employee.getEmpName());
		int result = employeeService.addEmployee(employee);
		if (result == 0) {
			employee.setMessage("Employee Added successfully");
		} else if (result == 1) {
			employee.setMessage("Duplicate Employee ID");
		} else {
			employee.setMessage("Error in Adding Employee");
		}
		httpServletRequest.setAttribute("requestAttrib", "Request attribute");
		session.setAttribute("sessionAttrib", "Session attribute");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("emp", employee);
		return mv;
	}
	
//	@RequestMapping("get")
//	public @ResponseBody String getEmployee(@RequestParam("empId") String empId) {
//		System.out.println("Emp = " + empId);
//		return "11";
//	}
	
	@RequestMapping("get")
	public @ResponseBody String getEmployee() {
		String empId = httpServletRequest.getParameter("empId");
		System.out.println("Emp = " + empId);
		return "11";
	}
}
