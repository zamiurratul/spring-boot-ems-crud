package com.zamiurratul.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zamiurratul.ems.model.Employee;
import com.zamiurratul.ems.repository.EmployeeRepository;
import com.zamiurratul.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Long saveEmployee(Employee employee) {
		return employeeRepository.save(employee).getId();
	}


	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

}
