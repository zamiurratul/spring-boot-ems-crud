package com.zamiurratul.ems.service;

import java.util.List;

import com.zamiurratul.ems.model.Employee;

public interface EmployeeService {
	Long saveEmployee(Employee employee);
	
	List<Employee> getAll();
}
