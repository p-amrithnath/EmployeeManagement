package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepositoryInterface;
@Service
public class EmployeeServiceImpl implements EmployeeService {
  
	@Autowired
	EmployeeRepositoryInterface employeeRepository;
	
	@Override
	public String addEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		if(emp!=null) 
			return "Employee saved Succesfully";
		else
				return "Failed to save";
		
	}
	
	

}
