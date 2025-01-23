package com.cts.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employees")
public class Employee {
	
	private int empId;
	private String empName;
	private int empSal;
	private String empDesg;
	private Date empDoJ;

}
