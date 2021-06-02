package com.pm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.dao.EmployeeRepository;
import com.pm.entities.Employee;

@Controller
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayEmployee(Model model) {
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		
		return "listemployee";
		
		
		
	}
	

	@RequestMapping("/new")
	public String displayEmployeeForm(Model model) {
		// use moodel to bind obj to views
		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);
		
		
		return "newemployee";
		
	}
	
	@PostMapping("/save")
	public String createEmployeeForm(Employee employee,Model model) {
		 empRepo.save(employee);
		return "redirect:/employees/new";
		
		
		
	
	}
	
}
