package com.spring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface EmployeeOperations {

	public boolean registerEmployee(int eno, String name, String designation, float sal);

	public int fetchEmploeeCount();

	public Map fetchEmployeeDetails(int employeeNo);

	public List findByDesignation(String designtion);

	public SqlRowSet findByDepartment(int departmentId);

	public int hikeSalary(int empno, int perentage);

	public boolean fireEmployee(int empno);
}