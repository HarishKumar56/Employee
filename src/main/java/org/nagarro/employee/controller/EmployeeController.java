package org.nagarro.employee.controller;

import java.util.List;

import org.nagarro.employee.model.Employee;
import org.nagarro.employee.service.EmployeeDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EmployeeController {
	
	
	@Autowired
	EmployeeDaoService employeeDaoService; 
	
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return employeeDaoService.getAllEmployee();
	}
	
	@GetMapping("/employee/{employeeCode}")
	public Employee getEmployee(@PathVariable int employeeCode) {
		return employeeDaoService.getEmployee(employeeCode);
	}
	
	@RequestMapping(method = RequestMethod.POST , path= "/employee" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveOrUpdate(@RequestBody Employee employee) {
		employeeDaoService.saveOrUpdateEmployee(employee);
	}
	
	@DeleteMapping("/employee/{employeeCode}")
	public void deleteEmployee(@PathVariable int employeeCode) {
		employeeDaoService.deleteEmployee(employeeCode);
	}
	
	

}
