package net.javaemployee.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaemployee.springboot.model.Dependant;
import net.javaemployee.springboot.model.Employee;
import net.javaemployee.springboot.repository.DependantRepository;
import net.javaemployee.springboot.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	  @Autowired
	private EmployeeRepository employeeRepository;
	  
	  
	  @Autowired
	private DependantRepository dependantRepository;
	  
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
   public List<Dependant> getAllDependants(){
	   return dependantRepository.findAll();
   }


	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee =optional.get();
			
		}else {
			
			throw new RuntimeException("Employee not found for id :: " + id);
			
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) { 
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> getBykeyword(String keyword) {
		
		return employeeRepository.findBykeyword(keyword);
	}

	@Override
	public void saveDependant(Dependant dependant) {
		// TODO Auto-generated method stub
		
	}

/**	@Override
	public Dependant getDependantdetailsById(long id) {
		// TODO Auto-generated method stub
		return dependantRepository.getById(id);
	} **/
	
	/** @Override
	public Dependant getDependantdetailsById(long id) {
		Optional<Dependant> optional = dependantRepository.findById(id);
		Dependant dependant=null;
		if(optional.isPresent()) {
			dependant =optional.get();
			
		}else {
			
			throw new RuntimeException("Dependent details not found for id::" + id);
			
		}
		return dependant;
	} **/


	}

