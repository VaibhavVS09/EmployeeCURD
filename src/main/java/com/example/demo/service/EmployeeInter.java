package com.example.demo.service;
import java.util.*;
import com.example.demo.entity.Employee;


public interface EmployeeInter  
{
    List<Employee> getAllEmployee();
    
    Employee saveEmployee(Employee employee);
    
    Employee getEmployeeId(int id);
   
    Employee UpdateEmployee(Employee employee);
   
    void deleteEmployeeById(int id);
}
