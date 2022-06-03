package com.learning.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.jdbc.dto.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String getEmployeeName(int empId) {
		Object[] params = { new Integer(empId) };
		/// Perform JDBC operation and return name
		String name = jdbcTemplate.queryForObject("Select name,  from Employee where id = ?", String.class, params);
		return name;
	}

	@Override
	public void deleteTable() {
		// We generally do not write such queries but doing it for demo
		String sql = "Drop table Employee";
		try {
			jdbcTemplate.execute(sql);
			System.out.println("Employee Table deleted");
		} catch (DataAccessException e) {
			System.out.println("Employee Table does not exist");
		}
	}

	@Override
	public Employee getEmployee(int empId) {
		Object[] params = { new Integer(empId) };

		BeanPropertyRowMapper<Employee> rowMapper = BeanPropertyRowMapper.newInstance(Employee.class);

		Employee e = jdbcTemplate.queryForObject(
				"select emp_id, name, designation, salary, dept_id from employee where emp_id = ?", rowMapper, params);

		/*
		 * empId, name setEmpId, setName
		 */

		return e;
	}

	@Override
	public List<Employee> getAllEmployee() {
		BeanPropertyRowMapper<Employee> rowMapper = BeanPropertyRowMapper.newInstance(Employee.class);
		List<Employee> employeesList = jdbcTemplate.query("select * from employee", rowMapper);
		return employeesList;
	}

	@Override
	public int addEmployee(Employee e) {
		return jdbcTemplate.update("insert into Employee values(?, ?, ?, ?, ? )",
				new Object[] { e.getEmpId(), e.getName(), e.getDesignation(), e.getSalary(), e.getDeptId() });
	}

	@Override
	public int deleteEmployee(Employee e) {
		return 0;
	}

	@Override
	public int updateEmployeeSalary(int empId, double newSalary) {
		return 0;
	}

	@Override
	public void createEmployeeTable() {
		String sql = "create table employee ( emp_Id int,name varchar(20),designation varchar(20),salary double,dept_Id int )";
		jdbcTemplate.execute(sql);
		System.out.println("Employee table created");
	}

	@Override
	public List<String> getAllEmployeeNames() {
		String sql = "select name from employee";
		return jdbcTemplate.queryForList(sql, String.class);
	}

}
