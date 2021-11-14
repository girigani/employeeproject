package net.javaemployee.springboot.service;

import java.util.List;

import net.javaemployee.springboot.model.Dependant;
import net.javaemployee.springboot.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);	
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	/** Dependant getDependantdetailsById(long id); **/
	List<Employee> getBykeyword(String keyword);
	void saveDependant(Dependant dependant);
}