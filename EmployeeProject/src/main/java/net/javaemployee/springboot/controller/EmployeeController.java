package net.javaemployee.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaemployee.springboot.model.Dependant;
import net.javaemployee.springboot.model.Employee;
import net.javaemployee.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	// Display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		//create model attribute to bind form data
		Employee employee = new Employee();
	    model.addAttribute("employee", employee);
		return "new_employee";		
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		//save employee in database
		
		employeeService.saveEmployee(employee);
		
		return "redirect:/";
	}
		
		@GetMapping("/showFormForUpdate/{id}")
		public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
		//get employee from service	
			Employee employee=employeeService.getEmployeeById(id);
			
			//setting employee as a model attribute to pre populate the form
			
			model.addAttribute("employee", employee);
			
			return "update_employee";	
	}
		@GetMapping("/deleteEmployee/{id}")
		public String deleteEmployee(@PathVariable (value = "id") long id) {
			this.employeeService.deleteEmployeeById(id);
			return "redirect:/";			
		}
		
		@RequestMapping(path = {"/","/Search"})
		public String viewSearchPage(Model model, @Param("keyword") String keyword) {
			if(keyword != null) {
			List<Employee> employees = employeeService.getBykeyword(keyword);
			model.addAttribute("listEmployees", employees);
			}
				return "index";
			}
		
		
		/** @GetMapping("/DependantDetails/{id}")
		public String getDependantDetails(@PathVariable (value = "id") long id, Model model) {
			Dependant dependant = employeeService.getDependantdetailsById(id);
			model.addAttribute("dependant", dependant);
			return "dependant_details";
		} **/
		
		/** DEPENDENT METHODS **/
		
		@GetMapping("/showNewDependantForm/{id}")
		public String showNewDependantForm(Model model, long id) {
			//create model attribute to bind form data
		    Dependant dependant = new Dependant();
		    model.addAttribute("dependant", dependant);		
			return "dependat_details";	
		}
		@PostMapping("/saveDependant")
		public String saveDependant(@ModelAttribute("dependat") Dependant dependat) {
			
			//save employee in database
			
			employeeService.saveDependant(dependat);
			
			return "redirect:/";
		}
		
		}
