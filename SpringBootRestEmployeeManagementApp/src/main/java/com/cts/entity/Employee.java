package com.cts.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees_info")
public class Employee {

	@Id
	@Min(value = 1, message = "Employee ID must be greater than 0")
	private int empId;

	@NotBlank(message = "Employee name cannot be blank")
	private String empName;

	@Min(value = 0, message = "Employee salary must be greater than or equal to 0")
	private int empSal;

	@NotBlank(message = "Employee designation cannot be blank")
	private String empDesg;

	@NotNull(message = "Date of joining cannot be null")
	@Past(message = "Date of joining must be a past date")
	private Date empDoJ;
}