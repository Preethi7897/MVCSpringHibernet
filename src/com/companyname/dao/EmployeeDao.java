package com.companyname.dao;
import java.util.List;

import com.companyname.entity.Employee;
public interface EmployeeDao {
	 
	 public void addEmployee(Employee employee);

	 public List<Employee> listEmployeess();
	 
	}
