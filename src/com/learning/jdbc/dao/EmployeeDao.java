package com.learning.jdbc.dao;

import java.util.List;

import com.learning.jdbc.dto.Employee;

public interface EmployeeDao {

	public void deleteTable();
	
	public void createEmployeeTable();
	
	public String getEmployeeName(int empId);

	public Employee getEmployee(int empId);

	public List<Employee> getAllEmployee();
	
	public int addEmployee(Employee e);
	
	public int deleteEmployee(Employee e);
	
	public int updateEmployeeSalary(int empId, double newSalary);

}
