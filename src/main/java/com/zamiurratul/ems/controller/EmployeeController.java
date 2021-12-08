package com.zamiurratul.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zamiurratul.ems.model.Employee;
import com.zamiurratul.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/index")
	public String index(Model m) {
		m.addAttribute("name", "Ratul");
		return "index";
	}
	
	@GetMapping("/registration-form")
	public String register(Model m) {
		Employee employee = new Employee();
		m.addAttribute("employee", employee);
		return "new-registration";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Employee employee, Model m) {
		employeeService.saveEmployee(employee);
		m.addAttribute("employeeId", employee.getId());
		return "save-success";
	}
	
	@GetMapping("/all-employee")
	public String allEmp(Model m) {
		m.addAttribute("employees", employeeService.getAll());
		return "all-employee";
	}
}
