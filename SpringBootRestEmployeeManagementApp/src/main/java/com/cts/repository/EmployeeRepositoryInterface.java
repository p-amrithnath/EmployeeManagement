package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.entity.Employee;

public interface EmployeeRepositoryInterface extends JpaRepository<Employee, Integer> {

}
