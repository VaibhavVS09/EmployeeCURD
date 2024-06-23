package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeInterface;
import com.example.demo.service.EmployeeInter;


@Service
public class EmployeeImpl implements EmployeeInter
{
	
	private EmployeeInterface empinterface;
	
	public EmployeeImpl(EmployeeInterface empinterface) 
	{
		super();
		this.empinterface = empinterface;
	}

	@Override
	public List<Employee> getAllEmployee()
	{
		
		return empinterface.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee)
	{
		
		return empinterface.save(employee);
	}

	@Override
	public Employee getEmployeeId(int id)
	{
		
		return empinterface.findById(id).get();
	}

	@Override
	public Employee UpdateEmployee(Employee employee) 
	{
		
		return empinterface.save(employee);
	}

	@Override
	public void deleteEmployeeById(int id)
	{
		empinterface.deleteById(id);
		
	}
	
	
	


}










