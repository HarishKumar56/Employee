package org.nagarro.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.nagarro.employee.model.Employee;

public interface EmployeeDaoService {

	void saveOrUpdateEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployee(int employeeCode);

	void deleteEmployee(int employeeCode);

}