package com.spring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class EmployeeDao implements EmployeeOperations {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean registerEmployee(int eno, String name, String designation, float sal) {
		System.out.println("*********** Register Employee ************");
		int result = jdbcTemplate.update("insert into Employee(eno,name,designation,salary)values(?,?,?,?)",
				new Object[] { new Integer(eno), name, designation, new Float(sal) });
		return result == 0 ? false : true;
	}

	@Override
	public int fetchEmploeeCount() {
		System.out.println("*********** Employee count ************");
		return jdbcTemplate.queryForInt("select count(*) from employee");
	}

	@Override
	public Map fetchEmployeeDetails(int employeeNo) {
		System.out.println("*********** Employee fetchEmployeeDetails ************");
		Map employeeDetails = jdbcTemplate.queryForMap("Select * from Employee where eno =?",
				new Object[] { new Integer(employeeNo) });
		return employeeDetails;
	}

	@Override
	public List findByDesignation(String designtion) {
		System.out.println("*********** Employee findByDesignation ************");
        List  employeeList = jdbcTemplate.queryForList("select * from Employee where designation =?",new Object[] {designtion});
		return employeeList;
	}

	@Override
	public SqlRowSet findByDepartment(int departmentId) {
		System.out.println("*********** Employee Hike Salary ************");
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet("select eno,name,department from employee where department =?", 
				                                        new Object[] {new Integer(departmentId)});

		return rowSet;
	}

	@Override
	public int hikeSalary(int empno, int perentage) {
		System.out.println("*********** Employee Hike Salary ************");
		int hikeSal =jdbcTemplate.queryForInt("select Salary from employee where eno=?",new Object[] {new Integer(empno)});
		hikeSal =(int)hikeSal+(hikeSal*(perentage)/100);
		jdbcTemplate.update("update employee set salary =? where eno=?", new Object[] {new Integer(hikeSal),new Integer(empno)});
		return hikeSal;
	}

	@Override
	public boolean fireEmployee(int empno) {
		System.out.println("*********** Employee Hike Salary ************");
		int result = jdbcTemplate.update("delete from employee where eno=?", new Object[] {new Integer(empno)});
		return result == 0 ? false : true;
	}

}
