package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Employee;
import com.cts.exception.EmployeeNotFound;
import com.cts.repository.EmployeeRepositoryInterface;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepositoryInterface employeeRepository;

	@Override
	public String addEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		if (emp != null)
			return "Employee saved Succesfully";
		else
			return "Failed to save";

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		if (emp != null)
			return emp;
		else
			return null;
	}

	@Override
	public String deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
		return "Employee Deleted Successfully";
	}

	@Override
	public Employee getEmployee(int empId) throws  EmployeeNotFound {
		Optional<Employee> optional = employeeRepository.findById(empId);
		if(optional.isPresent())
			 return optional.get();
		else
			throw new EmployeeNotFound("No Employee Found with Given Id!!!");
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getAllBetweenSalaries(int initialSal, int finalSal) {
      
		return employeeRepository.getAllBetweenSalaries(initialSal, finalSal);
		
	}
	
	@Override
	public List<Employee> getAllEmpDesg(String empDesg) {
      
		return employeeRepository.getAllEmpDesg(empDesg);
		
	}

}
