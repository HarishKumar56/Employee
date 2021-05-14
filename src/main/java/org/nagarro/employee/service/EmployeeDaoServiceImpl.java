package org.nagarro.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.nagarro.employee.model.Employee;
import org.nagarro.employee.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeDaoService")
public class EmployeeDaoServiceImpl implements EmployeeDaoService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	/* (non-Javadoc)
	 * @see org.nagarro.employee.service.EmployeeDaoService#saveOrUpdateEmployee(org.nagarro.employee.model.Employee)
	 */
	@Transactional
	public void saveOrUpdateEmployee(Employee employee) {
		employeeDao.saveOrUpdateEmployee(employee);
	}
	
	/* (non-Javadoc)
	 * @see org.nagarro.employee.service.EmployeeDaoService#getAllEmployee()
	 */
	@Transactional
	public List<Employee> getAllEmployee(){
		return employeeDao.findAllEmployee();
	}
	
	/* (non-Javadoc)
	 * @see org.nagarro.employee.service.EmployeeDaoService#getEmployee(int)
	 */
	@Transactional
	public Employee getEmployee(int employeeCode) {
		return employeeDao.getEmployee(employeeCode);
	}
	
	/* (non-Javadoc)
	 * @see org.nagarro.employee.service.EmployeeDaoService#deleteEmployee(int)
	 */
	@Transactional
	public void deleteEmployee(int employeeCode) {
		Employee emp = getEmployee(employeeCode);
		if(emp!=null) {
			employeeDao.deleteEmployee(getEmployee(employeeCode));
		}
		
	}

}
