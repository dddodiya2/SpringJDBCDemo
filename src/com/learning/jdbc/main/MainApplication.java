package com.learning.jdbc.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.jdbc.config.MyApplicationConfig;
import com.learning.jdbc.dao.EmployeeDao;
import com.learning.jdbc.dto.Employee;

public class MainApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApplicationConfig.class);

		EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

		/*
		 * employeeDao.deleteTable(); employeeDao.createEmployeeTable();
		 * 
		 * //String sql =
		 * "insert into Employee values(1, 'Ishwari', 'Java Developer', 90000.00, 5 )";
		 * 
		 * Employee e1 = new Employee(1, "Ishwari", "Java Dev", 99000.00, 5);
		 * employeeDao.addEmployee(e1); Employee e2 = new Employee(2, "Anjali",
		 * "Spring Dev", 98000.00, 8); employeeDao.addEmployee(e2);
		 */

		Employee e = employeeDao.getEmployee(2);
		System.out.println(e);

		/*
		 * System.out.println("Calling getAllEmployee method "); List<Employee>
		 * employeesList = employeeDao.getAllEmployee();
		 * System.out.println(employeesList);
		 */

		// System.out.println(employeeDao.getEmployeeName(61863));
		context.close();

	}

}
