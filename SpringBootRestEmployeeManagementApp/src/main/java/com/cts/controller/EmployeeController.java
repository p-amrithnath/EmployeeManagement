package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Employee;
import com.cts.exception.EmployeeNotFound;
import com.cts.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteEmployee(@PathVariable("id") @Min(value = 1, message = "Employee ID must be greater than 0") int employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/getById/{id}")
    public Employee getEmployee(@PathVariable("id") @Min(value = 1, message = "Employee ID must be greater than 0") int employeeId) throws EmployeeNotFound {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getAllBetweenSalaries/{initial}/{final}")
    public List<Employee> getAllBetweenSalaries(@PathVariable("initial") @Min(value = 0, message = "Initial salary must be greater than or equal to 0") int initialSal,
                                                @PathVariable("final") @Min(value = 0, message = "Final salary must be greater than or equal to 0") int finalSal) {
        return employeeService.getAllBetweenSalaries(initialSal, finalSal);
    }

    @GetMapping("/getAllEmpDesg/{empDesg}")
    public List<Employee> getAllEmpDesg(@PathVariable("empDesg") @NotBlank(message = "Employee designation cannot be blank") String empDesg) {
        return employeeService.getAllEmpDesg(empDesg);
    }
}