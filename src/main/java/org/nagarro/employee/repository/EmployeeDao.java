package org.nagarro.employee.repository;

import java.util.List;

import org.nagarro.employee.model.Employee;

public interface EmployeeDao {

	void saveOrUpdateEmployee(Employee employee);

	void deleteEmployee(Employee employee);

	List<Employee> findAllEmployee();

	Employee getEmployee(int employeeCode);

}