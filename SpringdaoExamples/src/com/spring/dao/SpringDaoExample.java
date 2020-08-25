package com.spring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class SpringDaoExample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeOperations employeeOperations = (EmployeeOperations) context.getBean("employeeOperations");
		//System.out.println("Employee is registered :" + employeeOperations.registerEmployee(1007, "Gopi", "Clerk", 5000));
		//System.out.println("Employee count : "+employeeOperations.fetchEmploeeCount());
		
		Map employeeDetails = employeeOperations.fetchEmployeeDetails(1002);
		System.out.println("Employee Details : "+	employeeDetails);
		System.out.println("Employee Designation :: ");
		List employeeDetailsByDepartment = employeeOperations.findByDesignation("CLERK");
		employeeDetailsByDepartment.forEach(e -> System.out.println(e));
			
		System.out.println("Employee Find by department :: ");
		SqlRowSet department =employeeOperations.findByDepartment(1);
		while(department.next()) {
			System.out.println(department.getInt(1)+ " "+department.getString(2)+ " "+department.getString(3));                     
		}
		
		System.out.println("Employee salary "+(30)+" percent Hike "+employeeOperations.hikeSalary(1001, 30));
		System.out.println("Employee is fired :: "+employeeOperations.fireEmployee(1007));
		
	}

}
