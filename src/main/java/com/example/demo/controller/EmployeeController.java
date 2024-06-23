package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeInter;

@Controller
public class EmployeeController 
{
	private EmployeeInter empinterface;
	public EmployeeController(EmployeeInter empinterface) 
	{
		super();
		this.empinterface = empinterface;
	}
	
   //Handler Method For Student List 
	@GetMapping("/")
	public String AllEmployee(Model model)
	{
		model.addAttribute("listEmp",empinterface.getAllEmployee());
		return "all";
	}
	
	
	//For New Employee
	@GetMapping("/new")
	public String EmployeeForm(Model model)
	{
		
		//create Employee object to hold employee form data
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "form";
	}
	
	
	//Save Information
	@PostMapping("/save")
	public String SaveEmployee(@ModelAttribute("employee") Employee employee)
	{
		 empinterface.saveEmployee(employee);
		 return "redirect:/";
	}
	
	//Update Handler
	@GetMapping("/update/{id}")
	public String Update(@PathVariable(value="id") int id, Model model)
	{
		model.addAttribute("employee" ,empinterface.getEmployeeId(id));
		return "Edit";
	}
	
	
	//Update Controller
	@PostMapping("/employee/{id}")
	public String UpdateEmployee(@PathVariable int id, @ModelAttribute("employee")Employee employee, Model model)
	{
	   
		//Get Employee Form DB
        Employee existing=empinterface.getEmployeeId(id);
        existing.setId(id);
        existing.setName(employee.getName());
        existing.setContact(employee.getContact());
        existing.setDepartment(employee.getDepartment());
        
        // Save Update Student Object
        empinterface.UpdateEmployee(existing);
		return "redirect:/";
	}
	
	   //Delete Handler
			@GetMapping("/delete/{id}")
			public String Delete(@PathVariable int id)
			{
			   empinterface.deleteEmployeeById(id);
			    return "redirect:/";
			}
			
			//Handler Method For Payment 
			@PostMapping("/pay2")
			@ResponseBody
			public String pays()
			{
				System.out.println("Function Start");
				return " ";
			}
}

























