package com.cts.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private int empId;
	private String empName;
	private int empSal;
	private String empDesg;
	private Date empDoJ;

}
