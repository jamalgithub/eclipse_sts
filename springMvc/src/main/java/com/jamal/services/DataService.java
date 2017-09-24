package com.jamal.services;

import java.util.List;

import com.jamal.domain.Employee;

public interface DataService {
	 
		 public void insertRow(Employee employee);  
		  
		 public List<Employee> getList();  
		  
		 public Employee getRowById(int id);  
		  
		 public void updateRow(Employee employee);  
		  
		 public void deleteRow(int id); 
}
